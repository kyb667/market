// import * as Vue from 'vue'
// import Vuex from 'vuex'
// import createLogger from '../../../src/plugins/logger'
import { createStore } from "vuex";
import bar from "./modules/bar";
import map from "./modules/map";
import shop_selectList from "./modules/shop_selectList";
import user from "./modules/user";
// Vue.use(Vuex)

const debug = process.env.NODE_ENV !== "production";

export default createStore({
  modules: {
    bar,
    user,
    map,
    shop_selectList,
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
