<template>
  <v-sheet width="300" class="mx-auto">
    <v-form ref="form">
      <v-text-field
        v-model="userId"
        :counter="20"
        :rules="userIdRules"
        label="USER ID"
        required
      ></v-text-field>

      <v-text-field
        v-model="userPw"
        :counter="20"
        :rules="userPwRules"
        label="USER PW"
        required
      ></v-text-field>

      <v-text-field
        v-model="userName"
        :counter="20"
        :rules="userNameRules"
        label="USER Name"
        required
      ></v-text-field>

      <v-text-field
        v-model="userPhone"
        label="USER Phone"
        required
      ></v-text-field>

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

export default {
  data: () => ({
    userId: "",
    userPw: "",
    userName: "",
    userPhone: "",
    userIdRules: [
      (v) => !!v || "userId is required",
      (v) => (v && v.length <= 20) || "userId must be less than 10 characters",
    ],
    userPwRules: [
      (v) => !!v || "userPw is required",
      (v) => (v && v.length <= 20) || "userPw must be less than 10 characters",
    ],
    userNameRules: [
      (v) => !!v || "userName is required",
      (v) =>
        (v && v.length <= 20) || "userName must be less than 10 characters",
    ],
    select: null,
    items: ["Id", "Email"],
  }),

  methods: {
    async validate() {
      const { valid } = await this.$refs.form.validate();
      if (valid) {
        const body = {
          userEmail: "",
          userId: this.userId,
          userPw: this.userPw,
          userName: this.userName,
          userPhone: this.userPhone,
        };
        await this.signIn(body);
      }
    },
    ...mapActions({
      signIn: "user/signIn",
    }),
  },
};
</script>
