import { createRouter, createWebHistory } from 'vue-router';
import headerBar from '../components/headerBar.vue';
import mainFrame from '../components/mainFrame.vue';
import sideBar from '../components/sideBar.vue';
import userSignIn from '../components/user/userSignIn.vue';

const routes = [
  {
    path: '/',
    components: {
        mainFrame: mainFrame,
        sideBar: sideBar,
        headerBar: headerBar
    }
  },
  {
    path: '/signIn',
    components: {
      mainFrame: userSignIn,
      sideBar: sideBar,
      headerBar: headerBar
    }
  },
]

const router = createRouter({
  // mode: 'history',
  // process.env.BASE_URL
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  console.log("--------start")
  console.log(to)
  console.log(from)
  console.log("--------end")
  next()
})

export default router