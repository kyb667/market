<template>
  <!-- <v-card> -->
    <v-layout>
     <template v-slot:prepend>
        <v-app-bar-nav-icon @click="setShowSideBar()"></v-app-bar-nav-icon>
      </template>

      <v-app-bar-title>Photos</v-app-bar-title>

      <template v-slot:append>
        <v-btn icon="mdi-dots-vertical" ></v-btn>
      </template>
    </v-layout>
  <!-- </v-card> -->
</template>

<script>
// import { mapMutations} from 'vuex'

export default {
  // data () {
  //   return {
  //     showSideBar: this.$store.getters.getShowSideBar
  //   }
  // },
  created: function() {
    console.log(this)
  },

  computed:{
    showSideBar(){
      console.log(123)
      return this.$store.state.bar.showSideBar
    },
  },

  methods:{
    setShowSideBar(){
      console.log(456)
      this.$store.commit('bar/setShowSideBar', !this.showSideBar)
    },
  },

  watch: {
    showSideBar(oldValue, newValue){
      console.log("watch start")
      console.log(oldValue);
      console.log(newValue);
      console.log("watch end")
    }
  },

}
</script>

