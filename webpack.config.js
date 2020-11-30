const path = require('path');
const { CleanWebpackPlugin } = require('clean-webpack-plugin');
const VueLoaderPlugin = require('vue-loader/lib/plugin');

module.exports = {
    module: {
        rules: [
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            },
            {
                test: /\.css$/i,
                exclude: /node_modules/,
                use: [
                    "style-loader",
                    { loader: "css-loader", options: { importLoaders: 1 } },
                    "postcss-loader"
                ],
            },
        ],
    },
    plugins: [
        new CleanWebpackPlugin(),
        new VueLoaderPlugin()
    ],
    entry: './src/main/resources/static/js/index.js',
    output: {
        filename: 'main.js',
        path: path.resolve(__dirname, 'src', 'main', 'resources', 'static', 'dist'),
    },
    resolve: {
        alias: {
          vue: 'vue/dist/vue.js'
        }
      }
};
