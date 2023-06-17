// import * as Vue from 'vue'
// import Vuex from 'vuex'
// import createLogger from '../../../src/plugins/logger'
import { createStore } from "vuex";
import cart from './modules/cart';
import products from './modules/products';

// Vue.use(Vuex)

const debug = process.env.NODE_ENV !== 'production'

export default createStore({
  modules: {
    cart,
    products
  },
  strict: debug,
//   plugins: debug ? [createLogger()] : []
})

// export default new Vuex.Store({
//   modules: {
//     cart,
//     products
//   },
//   strict: debug,
// //   plugins: debug ? [createLogger()] : []
// })