<template>
  <v-sheet width="300" class="mx-auto">
    <v-form ref="form">
      <v-text-field v-model="userId" label="USER ID" required></v-text-field>

      <v-text-field v-model="userPw" label="USER PW" required></v-text-field>

      <v-select
        v-model="select"
        :items="items"
        :rules="[(v) => !!v || 'Login Type is required']"
        label="Login Type"
        required
      ></v-select>

      <div class="d-flex flex-column">
        <v-btn color="success" class="mt-4" block @click="validate">
          Validate
        </v-btn>
      </div>
    </v-form>
  </v-sheet>
</template>

<script>
import { mapActions } from "vuex";
import config from "../../plugin/config";

export default {
  data: () => ({
    userId: "",
    userPw: "",
    select: null,
    items: ["Id", "Email"],
  }),

  methods: {
    async validate() {
      const { valid } = await this.$refs.form.validate();
      if (valid) {
        var loginType = "";

        if (this.select === "Id") {
          loginType = config.LoginType.IdType;
        } else {
          loginType = config.LoginType.EmailType;
        }
        const body = {
          userEmail: "",
          userId: this.userId,
          userPw: this.userPw,
          loginType: loginType,
        };

        await this.logIn(body);
      }
    },
    ...mapActions({
      logIn: "user/logIn",
    }),
  },
};
</script>
