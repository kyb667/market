import axios from "axios";
import common from "../../plugin/common";
import config from "../../plugin/config";

const state = () => ({
  loginFlag: false,
  userInfoForm: {
    userId: null,
  },
});

// getters
const getters = {
  getLoginFlag: (state) => {
    return state.loginFlag;
  },
  getUserInfoForm: (state) => {
    return state.userInfoForm;
  },
};

// actions
const actions = {
  // eslint-disable-next-line no-unused-vars
  async signIn({ state }, body) {
    console.log("signIn start");
    await axios
      .post("/context/api/v1/user/buyer/signIn", body)
      // eslint-disable-next-line no-unused-vars
      .then((res) => {
        // show main
        common.moveTemplate(config.PAGE_NUMBER.MainFrame);
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => {
        console.log("signIn end");
      });
  },
  // eslint-disable-next-line no-unused-vars
  async logIn({ state, commit }, body) {
    console.log("logIn start");
    await axios
      .post("/context/api/v1/user/buyer/logIn", body)
      // eslint-disable-next-line no-unused-vars
      .then((res) => {
        commit("setUserInfoForm", { userId: body["userId"] });
        commit("setLoginFlag", true);
        // show main
        common.moveTemplate(config.PAGE_NUMBER.MainFrame);
      })
      .catch((err) => {
        console.log(err);
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
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations,
};
