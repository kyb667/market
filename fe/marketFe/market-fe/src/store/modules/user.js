import axios from "axios";
import common from "../../plugin/common";
import config from "../../plugin/config";

const state = () => ({
  loginFlag: false,
  userInfoForm: {
    userId: null,
    userName: null,
  },
  alertTitle: null,
  alertMsg: null,
  alertFlag: false,
});

// getters
const getters = {
  getLoginFlag: (state) => {
    return state.loginFlag;
  },
  getUserInfoForm: (state) => {
    return state.userInfoForm;
  },
  getAlertTitle: (state) => {
    return state.alertTitle;
  },
  getAlertMsg: (state) => {
    return state.alertMsg;
  },
  getAlertFlag: (state) => {
    return state.alertFlag;
  },
};

// actions
const actions = {
  // eslint-disable-next-line no-unused-vars
  async signIn({ state, commit }, body) {
    console.log("signIn start");
    await axios
      .post(
        "/context/api/" + config.Url.buyer.default + config.Url.buyer.signIn,
        body
      )
      .then((res) => {
        if (res.data.result === config.RES_STATE.OK) {
          commit("setAlertTitle", "signin");
          commit("setAlertMsg", "signin success");
          commit("setAlertFlag", true);
          // show login
          common.moveTemplate(config.PAGE_NUMBER.LogIn);
        } else {
          commit("setAlertTitle", "signin");
          commit("setAlertMsg", "signin error");
          commit("setAlertFlag", true);
        }
      })
      .catch(() => {
        commit("setAlertTitle", "signin");
        commit("setAlertMsg", "signin error");
        commit("setAlertFlag", true);
      })
      .finally(() => {
        console.log("signIn end");
      });
  },
  // eslint-disable-next-line no-unused-vars
  async logIn({ state, commit }, body) {
    console.log("logIn start");
    await axios
      .post(
        "/context/api/" + config.Url.buyer.default + config.Url.buyer.logIn,
        body
      )
      .then((res) => {
        if (res.data.result === config.RES_STATE.OK) {
          commit("setUserInfoForm", { userName: res.data.data.userName });
          commit("setLoginFlag", true);
          commit("setAlertTitle", "login");
          commit("setAlertMsg", "login success");
          commit("setAlertFlag", true);
          // show main
          common.moveTemplate(config.PAGE_NUMBER.MainFrame);
        } else {
          commit("setAlertTitle", "login");
          commit("setAlertMsg", "login error");
          commit("setAlertFlag", true);
        }
      })
      .catch(() => {
        commit("setAlertTitle", "login");
        commit("setAlertMsg", "login error");
        commit("setAlertFlag", true);
      })
      .finally(() => {
        console.log("logIn end");
      });
  },
};

// mutations
const mutations = {
  setLoginFlag(state, value) {
    state.loginFlag = value;
  },
  setUserInfoForm(state, value) {
    state.userInfoForm = value;
  },
  setAlertTitle: (state, value) => {
    state.alertTitle = value;
  },
  setAlertMsg: (state, value) => {
    state.alertMsg = value;
  },
  setAlertFlag: (state, value) => {
    state.alertFlag = value;
  },
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations,
};
