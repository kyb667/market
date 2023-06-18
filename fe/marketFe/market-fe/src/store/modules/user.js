const state = () => ({
})

// getters
const getters = {
}

// actions
const actions = {
  signIn : () => {
    console.log("signIn start")
    axios.get("/context/api/user/admin/",).then((res) => {
      console.log(123);
      console.log(res);
    }).catch((err) => {
      console.log(123)
      console.log(err)
    }).finally(() => {
      console.log("signIn end")
    })
  },
}

// mutations
const mutations = {
  
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}