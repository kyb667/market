<template>
  <v-list-item
    v-bind:title="loginFlag === false ? 'test' : userInfoForm.userId"
  ></v-list-item>

  <v-divider></v-divider>

  <v-list density="compact" nav>
    <div v-if="loginFlag === false">
      <v-list-item
        title="signin"
        value="signin"
        @click="signin()"
      ></v-list-item>
      <v-list-item title="login" value="login" @click="login()"></v-list-item>
    </div>
    <div v-else>
      <v-list-item
        title="logout"
        value="logout"
        @click="logout()"
      ></v-list-item>
    </div>
  </v-list>
</template>

<script>
import { mapGetters } from "vuex";
import common from "../plugin/common";
import config from "../plugin/config";

export default {
  computed: {
    ...mapGetters({
      loginFlag: "user/getLoginFlag",
      userInfoForm: "user/getUserInfoForm",
    }),
  },
  methods: {
    signin() {
      common.moveTemplate(config.PAGE_NUMBER.SignIn);
    },
    login() {
      common.moveTemplate(config.PAGE_NUMBER.LogIn);
    },
    logout() {
      this.$store.commit("user/setLoginFlag", false);
      common.moveTemplate(config.PAGE_NUMBER.MainFrame);
    },
  },
};
</script>
