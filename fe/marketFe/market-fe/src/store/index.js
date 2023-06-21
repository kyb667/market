// import * as Vue from 'vue'
// import Vuex from 'vuex'
// import createLogger from '../../../src/plugins/logger'
import { createStore } from "vuex";
import bar from "./modules/bar";
import user from "./modules/user";

// Vue.use(Vuex)

const debug = process.env.NODE_ENV !== "production";

export default createStore({
  modules: {
    bar,
    user,
  },
  strict: debug,
  //   plugins: debug ? [createLogger()] : []
});

// export default new Vuex.Store({
//   modules: {
//     cart,
//     products
//   },
//   strict: debug,
// //   plugins: debug ? [createLogger()] : []
// })
