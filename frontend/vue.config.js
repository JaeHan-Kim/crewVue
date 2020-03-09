'use strict'

module.exports = {
    devServer: {
        proxy: { // proxyTable 설정
            '/api': {
                target: 'http://localhost:8080',
                secure: false,
                changeOrigin: true,
                publicPath: {
                    '^/api': '/'
                }
            }
        }
    },

    outputDir: '../src/main/static'
}