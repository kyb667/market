<template>
  <div class="text-center">
    <v-dialog v-model="alertFlag" width="auto">
      <v-card>
        <v-toolbar color="primary" v-bind:title="alertTitle"></v-toolbar>

        <v-card-text> {{ alertMsg }} </v-card-text>
        <v-card-actions>
          <v-btn color="primary" block @click="closeAlert()">Close</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  computed: {
    ...mapGetters({
      alertTitle: "user/getAlertTitle",
      alertMsg: "user/getAlertMsg",
      alertFlag: "user/getAlertFlag",
    }),
  },
  methods: {
    closeAlert() {
      this.$store.commit("user/setAlertFlag", false);
    },
  },
};
</script>
