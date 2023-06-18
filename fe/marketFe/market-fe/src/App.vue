<template>
  <v-card :height="height">
    <v-layout>
      <v-app-bar color="primary" density="compact">
        <!-- <router-view name="headerBar"></router-view> -->
        <template v-slot:prepend>
          <v-app-bar-nav-icon @click="setShowSideBar()"></v-app-bar-nav-icon>
        </template>

        <v-app-bar-title>Market</v-app-bar-title>

        <template v-slot:append>
          <v-btn icon="mdi-dots-vertical" ></v-btn>
        </template>
      </v-app-bar>

      <v-navigation-drawer
        v-model="showSideBar"
        permanent
        width="150"
      >
        <router-view name="sideBar"></router-view>
      </v-navigation-drawer>

      <v-main>
        <router-view name="mainFrame"></router-view>
      </v-main>
    </v-layout>
  </v-card>    
</template>

<script>
import { computed } from 'vue'
import { useDisplay } from 'vuetify'

export default {
  name: 'App',
  components: {
    // HelloWorld
  },
  setup () {
    const { name } = useDisplay()

    const height = computed(() => {
      switch (name.value) {
        case 'xs': return 220
        case 'sm': return 400
        case 'md': return 500
        case 'lg': return 600
        case 'xl': return 800
        case 'xxl': return 1200
      }

      return undefined
    })

    return { height }
  },

  computed:{
    showSideBar(){
      return this.$store.state.bar.showSideBar
    },
  },
  methods:{
    setShowSideBar(){
      this.$store.commit('bar/setShowSideBar', !this.showSideBar)
    },
  },
}
</script>
