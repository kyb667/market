
const state = () => ({
  showSideBar : false
})

// getters
const getters = {
  getShowSideBar: (state) => {
    return state.showSideBar;
  }
}

// actions
const actions = {
}

// mutations
const mutations = {
  setShowSideBar(state, value) {
    console.log("setShowSideBar start")
    console.log(value);
    state.showSideBar = value
    console.log("setShowSideBar end")
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}