<template>
       <v-list-item
        title="John Leider"
      ></v-list-item>

      <v-divider></v-divider>

      <v-list density="compact" nav>
          <v-list-item title="signin" value="signin" @click="signin()"></v-list-item>
          <v-list-item title="login" value="login" @click="login()"></v-list-item>
      </v-list>
</template>

<script>
  export default {
    // computed:{
    //   showSideBar(){
    //     return this.$store.state.bar.showSideBar
    //   },
    // },

    // watch: {
    //   showSideBar(oldValue, newValue){

    //   }
    // },

    methods:{
      // setShowSideBar(){
      //   this.$store.commit('bar/setShowSideBar', !this.showSideBar)
      // },
      signin(){
        console.log(123)
        this.$router.push("/signin");
      },
      login(){
        console.log(456)
      },
    },
  }
</script>