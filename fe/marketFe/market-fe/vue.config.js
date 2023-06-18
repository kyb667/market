const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    port: 8000,
    proxy: {
      '^/context/api': {
        target: 'http://host.docker.internal:8080',
        pathRewrite: { '^/context/api': '' },
        changeOrigin: true,
        logLevel: 'debug',
      },
    },
  },
})