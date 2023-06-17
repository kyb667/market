<template>
  <div>
    <router-link to="/"></router-link>
    <router-link to="/a"></router-link>
  </div>
  <!-- <router-link to="/a">a1</router-link> -->

  <router-view name="sideBar"></router-view>
  <router-view></router-view>
  <router-view name="b"></router-view>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    // HelloWorld
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
