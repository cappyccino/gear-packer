const webpack = require("webpack");
const path = require("path");

const reactEntryPoint = "./src/main/js/index.js";
const builtDirectory = "./src/main/resources/static/built/";
const templateDirectory = "./src/main/resources/templates/";

module.exports = {
    entry: path.resolve(__dirname, reactEntryPoint),
    output: {
        path: path.resolve(__dirname, builtDirectory),
        filename: "bundle.js",
    },
    module: {
        rules: [
            {
                test: /\.(js|jsx)$/,
                exclude: /node_modules/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ["@babel/preset-env", "@babel/preset-react"]
                    }
                }]
            },
        ],
    },
    resolve: {
        extensions: ["*", ".js", ".jsx"],
    },
    plugins: [new webpack.HotModuleReplacementPlugin()],
    devServer: {
        contentBase: [
            path.resolve(__dirname, builtDirectory),
        ],
        // index: path.resolve(__dirname, templateDirectory + "index.html"),
        hot: true,
        port: 3000
    },
};
