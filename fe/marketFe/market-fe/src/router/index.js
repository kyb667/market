import { createRouter, createWebHistory } from "vue-router";
import headerBar from "../components/headerBar.vue";
import mainFrame from "../components/mainFrame.vue";
import showAlert from "../components/showAlert.vue";
import sideBar from "../components/sideBar.vue";
import userLogIn from "../components/user/userLogin.vue";
import userSignIn from "../components/user/userSignIn.vue";

const routes = [
  {
    path: "/",
    components: {
      mainFrame: mainFrame,
      sideBar: sideBar,
      headerBar: headerBar,
      showAlert: showAlert,
    },
  },
  {
    path: "/signIn",
    components: {
      mainFrame: userSignIn,
      sideBar: sideBar,
      headerBar: headerBar,
      showAlert: showAlert,
    },
  },
  {
    path: "/logIn",
    components: {
      mainFrame: userLogIn,
      sideBar: sideBar,
      headerBar: headerBar,
      showAlert: showAlert,
    },
  },
];

const router = createRouter({
  // mode: 'history',
  // process.env.BASE_URL
  history: createWebHistory(),
  routes,
});

router.beforeEach((to, from, next) => {
  next();
});

export default router;
