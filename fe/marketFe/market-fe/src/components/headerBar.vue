<template>
  <v-layout>
    <template v-slot:prepend>
      <v-app-bar-nav-icon @click="setShowSideBar()"></v-app-bar-nav-icon>
    </template>

    <v-app-bar-title>Photos</v-app-bar-title>

    <template v-slot:append>
      <v-btn icon="mdi-dots-vertical"></v-btn>
    </template>
  </v-layout>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  computed: {
    ...mapGetters({
      showSideBar: "bar/getShowSideBar",
    }),
  },

  methods: {
    setShowSideBar() {
      this.$store.commit("bar/setShowSideBar", !this.showSideBar);
    },
  },
};
</script>
