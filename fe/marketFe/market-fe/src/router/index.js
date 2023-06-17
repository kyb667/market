import { createRouter, createWebHistory } from 'vue-router';
import HelloWorld1 from '../components/HelloWorld1.vue';
import HelloWorld2 from '../components/HelloWorld2.vue';
import sideBar from '../components/sideBar.vue';

const routes = [
  {
    path: '/',
    components: {
        default: HelloWorld1,
        sideBar: sideBar,
        b: HelloWorld2
    }
  },
  {
    path: '/a',
    components: {
        default: HelloWorld2,
        sideBar: sideBar,
        b: HelloWorld1
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