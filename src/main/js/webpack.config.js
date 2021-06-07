const webpack = require("webpack");
const path = require("path");

const reactEntryPoint = "./index.js";
const staticDirectory = "../resources/static/";

module.exports = {
    entry: path.resolve(__dirname, reactEntryPoint),
    output: {
        path: path.resolve(__dirname, staticDirectory),
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
            path.resolve(__dirname, staticDirectory),
        ],
        port: 3000,
        hot: true,
    },
};
