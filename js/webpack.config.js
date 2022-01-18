const webpack = require("webpack");
const path = require("path");

const reactEntryPoint = "./index.js";
const staticDirectory = "./static/";

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
                    options: {presets: ["@babel/preset-env", "@babel/preset-react"]}
                }]
            },
            {
                test: /\.svg$/,
                use: ['@svgr/webpack'],
            },
            {
                test: /\.s[ac]ss$/i,
                use: [
                    "style-loader", // Creates `style` nodes from JS strings
                    "css-loader", // Translates CSS into CommonJS
                    "sass-loader", // Compiles Sass to CSS
                ],
            },
        ],
    },
    resolve: {
        extensions: ["*", ".js", ".jsx"],
    },
    plugins: [new webpack.HotModuleReplacementPlugin()],
    devServer: {
        static: [
            path.resolve(__dirname, staticDirectory),
        ],
        port: 3000,
        hot: true,
    },
};
