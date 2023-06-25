<template>
  <v-card class="mx-auto">
    <v-container fluid>
      <v-row>
        <v-col cols="12" sm="4" md="4">
          <v-checkbox
            v-model="selectFilter"
            v-bind:label="select_search.creditcard"
            color="info"
            v-bind:value="select_search.creditcard"
          ></v-checkbox>
          <v-checkbox
            v-model="selectFilter"
            v-bind:label="select_search.parking"
            color="info"
            v-bind:value="select_search.parking"
          ></v-checkbox>
        </v-col>
        <v-col cols="12" sm="4" md="4">
          <v-checkbox
            v-model="selectFilter"
            v-bind:label="select_search.smoking"
            color="info"
            v-bind:value="select_search.smoking"
          ></v-checkbox>
          <v-checkbox
            v-model="selectFilter"
            v-bind:label="select_search.creditcard"
            color="info"
            v-bind:value="select_search.creditcard"
          ></v-checkbox>
        </v-col>
      </v-row>

      <v-row class="mt-12">
        <v-col cols="12" sm="4" md="4">
          <v-btn prepend-icon="$vuetify" @click="sendLocalSearch">
            select
          </v-btn>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
</template>

<script>
// eslint-disable-next-line no-unused-vars
import { mapState, mapActions, mapGetters } from "vuex";
import config from "../../plugin/config";

export default {
  data: () => ({
    selectFilter: [],
    select_search: config.SELECT_SEARCH,
  }),
  watch: {
    selectFilter(newVal) {
      // this.$store.commit("map/setLocations", [
      //   {
      //     lat: 34.6750441,
      //     lng: 138.4906772,
      //   },
      // ]);

      // this.$store.commit("map/setCenter", {
      //   lat: 35.6750441,
      //   lng: 139.4906772,
      // });

      this.$store.commit("shop_selectList/setSelectFilter", newVal);
    },
  },
  methods: {
    ...mapActions({
      sendLocalSearch: "shop_selectList/localSearch",
    }),
  },
};
</script>
