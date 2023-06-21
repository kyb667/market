const state = () => ({
  showSideBar: false,
});

// getters
const getters = {
  getShowSideBar: (state) => {
    return state.showSideBar;
  },
};

// actions
const actions = {};

// mutations
const mutations = {
  setShowSideBar(state, value) {
    state.showSideBar = value;
  },
};

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations,
};
