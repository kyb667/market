<template>
  <v-sheet width="300" class="mx-auto">

    <v-form ref="form">
      <v-text-field
        v-model="userId"
        :counter="10"
        :rules="userIdRules"
        label="USER ID"
        required
      ></v-text-field>

      <v-text-field
        v-model="userPw"
        :counter="10"
        :rules="userPwRules"
        label="USER PW"
        required
      ></v-text-field>

      <v-text-field
        v-model="userName"
        :counter="10"
        :rules="userNameRules"
        label="USER Name"
        required
      ></v-text-field>

      <!-- <v-select
        v-model="select"
        :items="items"
        :rules="[v => !!v || 'Item is required']"
        label="Item"
        required
      ></v-select> -->

      <v-checkbox
        v-model="checkbox"
        :rules="[v => !!v || 'You must agree to continue!']"
        label="Do you agree?"
        required
      ></v-checkbox>

      <div class="d-flex flex-column">
        <v-btn
          color="success"
          class="mt-4"
          block
          @click="validate"
        >
          Validate
        </v-btn>

        <v-btn
          color="error"
          class="mt-4"
          block
          @click="reset"
        >
          Reset Form
        </v-btn>

        <v-btn
          color="warning"
          class="mt-4"
          block
          @click="resetValidation"
        >
          Reset Validation
        </v-btn>
      </div>
    </v-form>

  </v-sheet>
</template>

<script>
import { mapActions } from 'vuex'

  export default {
    data: () => ({
      userId: '',
      userPw: '',
      userName: '',
      userIdRules: [
        v => !!v || 'userId is required',
        v => (v && v.length <= 10) || 'userId must be less than 10 characters',
      ],
      userPwRules: [
        v => !!v || 'userPw is required',
        v => (v && v.length <= 10) || 'userPw must be less than 10 characters',
      ],
      userNameRules: [
        v => !!v || 'userName is required',
        v => (v && v.length <= 10) || 'userName must be less than 10 characters',
      ],
      select: null,
      items: [
        'Item 1',
        'Item 2',
        'Item 3',
        'Item 4',
      ],
      checkbox: false,
    }),

    methods: {
      async validate () {
        const { valid } = await this.$refs.form.validate()

        if (valid){
          console.log(1)
          this.signIn()
        }
      },
      reset () {
        this.$refs.form.reset()
      },
      resetValidation () {
        this.$refs.form.resetValidation()
      },
      ...mapActions({
        signIn: 'user/signIn'
      })
    },

    // computed:{
    // }
  }
</script>