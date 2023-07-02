import axios from "axios";
import config from "../../plugin/config";

import user from "./user";

import map from "./map";

const state = () => ({
  selectFilter: [],
});

// getters
const getters = {
  getSelectFilter: (state) => {
    return state.selectFilter;
  },
};

// actions
const actions = {
  // eslint-disable-next-line no-unused-vars
  async localSearch({ state, commit, rootState }) {
    if (state.selectFilter.length !== 0) {
      var a = {
        selectFilter: state.selectFilter,
        center: state.map.center,
      };
      let body = { filterData: a };
      console.log("localSearch start");
      console.log(body);
      await axios
        .post(
          "/context/api/" + config.Url.map.default + config.Url.map.localSearch,
          body
        )
        .then((res) => {
          console.log(res);
          if (res.data.result === config.RES_STATE.OK) {
            commit(
              "map/setLocations",
              // [
              //   {
              //     lat: 34.6750441,
              //     lng: 138.4906772,
              //   },
              //   {
              //     lat: 33.6750441,
              //     lng: 137.4906772,
              //   },
              // ],
              res.data.locations,
              { root: true }
            );
            // commit(
            //   "map/setCenter",
            //   // {
            //   //   lat: 35.6750441,
            //   //   lng: 139.4906772,
            //   // },
            //   res.data.center,
            //   { root: true }
            // );
            commit("user/setAlertTitle", "search", { root: true });
            commit("user/setAlertMsg", "success", { root: true });
            commit("user/setAlertFlag", true, { root: true });
          } else {
            commit("user/setAlertTitle", "search", { root: true });
            commit("user/setAlertMsg", "search fail", { root: true });
            commit("user/setAlertFlag", true, { root: true });
          }
        })
        .catch(() => {
          commit("user/setAlertTitle", "search", { root: true });
          commit("user/setAlertMsg", "connection fail", { root: true });
          commit("user/setAlertFlag", true, { root: true });
        })
        .finally(() => {
          console.log("localSearch end");
        });
    } else {
      commit("user/setAlertTitle", "search", { root: true });
      commit("user/setAlertMsg", "no filter", { root: true });
      commit("user/setAlertFlag", true, { root: true });
    }
  },
};

// mutations
const mutations = {
  setSelectFilter(state, value) {
    state.selectFilter.splice(0, state.selectFilter.length);
    state.selectFilter.push(...value);
  },
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations,
  modules: {
    user,
    map,
  },
};
