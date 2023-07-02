<template>
  <v-card class="mx-auto">
    <v-container>
      <v-row class="mb-6" no-gutters>
        <v-col cols="12" md="3">
          <!-- creditcard -->
          <v-sheet class="pa-2 ma-2">
            <v-checkbox
              v-model="selectFilter"
              v-bind:label="select_search.creditcard"
              color="info"
              v-bind:value="select_search.creditcard"
            ></v-checkbox>
          </v-sheet>
        </v-col>

        <!-- parking -->
        <v-col cols="12" md="3">
          <v-sheet class="pa-2 ma-2">
            <v-checkbox
              v-model="selectFilter"
              v-bind:label="select_search.parking"
              color="info"
              v-bind:value="select_search.parking"
            ></v-checkbox>
          </v-sheet>
        </v-col>

        <!-- smoking -->
        <v-col cols="12" md="3">
          <v-sheet class="pa-2 ma-2">
            <v-checkbox-btn
              v-model="smoking_flag"
              v-bind:label="select_search.smoking.label"
              class="pe-2"
            ></v-checkbox-btn>

            <v-combobox
              :disabled="!smoking_flag"
              v-model="smoking_selected"
              :items="select_search.smoking.value"
              v-bind:label="select_search.smoking.label"
              multiple
              chips
            ></v-combobox>
          </v-sheet>
        </v-col>

        <!-- coupon -->
        <v-col cols="12" md="3">
          <v-sheet class="pa-2 ma-2">
            <v-checkbox
              v-model="selectFilter"
              v-bind:label="select_search.coupon"
              color="info"
              v-bind:value="select_search.coupon"
            ></v-checkbox>
          </v-sheet>
        </v-col>
      </v-row>

      <v-row class="mb-6" no-gutters>
        <!-- reservation -->
        <v-col cols="12" md="3">
          <v-sheet class="pa-2 ma-2">
            <v-checkbox
              v-model="selectFilter"
              v-bind:label="select_search.reservation"
              color="info"
              v-bind:value="select_search.reservation"
            ></v-checkbox>
          </v-sheet>
        </v-col>

        <!-- open -->
        <v-col cols="12" md="3">
          <v-sheet class="pa-2 ma-2">
            <v-checkbox
              v-model="selectFilter"
              v-bind:label="select_search.open"
              color="info"
              v-bind:value="select_search.open"
            ></v-checkbox>
          </v-sheet>
        </v-col>

        <!-- price -->
        <v-col cols="12" md="3">
          <v-sheet class="pa-2 ma-2">
            <v-checkbox-btn
              v-model="price_flag"
              v-bind:label="select_search.price.label"
              class="pe-2"
            ></v-checkbox-btn>

            <!-- min_price -->
            <v-text-field
              :disabled="!price_flag"
              hide-details
              v-bind:label="select_search.price.value.min_price"
              v-model="min_price"
            ></v-text-field>

            <!-- max_price -->
            <v-text-field
              :disabled="!price_flag"
              hide-details
              v-bind:label="select_search.price.value.max_price"
              v-model="max_price"
            ></v-text-field>
          </v-sheet>
        </v-col>

        <!-- <v-col cols="12" md="3">
          <v-sheet class="pa-2 ma-2">
            <v-checkbox label="test" color="info" value="test"></v-checkbox>
          </v-sheet>
        </v-col> -->
      </v-row>

      <v-row no-gutters>
        <v-col cols="auto">
          <v-sheet class="pa-2 ma-2">
            <v-btn prepend-icon="$vuetify" @click="checkSearch"> select </v-btn>
          </v-sheet>
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
    price_flag: false,
    min_price: "",
    max_price: "",
    smoking_flag: false,
    smoking_selected: [],
  }),
  methods: {
    ...mapActions({
      sendLocalSearch: "shop_selectList/localSearch",
    }),
    checkSearch() {
      const filters = {};

      if (this.price_flag === true) {
        if (this.max_price === "") {
          this.$store.commit("user/setAlertTitle", "search");
          this.$store.commit("user/setAlertMsg", "max_price is not selected");
          this.$store.commit("user/setAlertFlag", true);
          return;
        }

        if (this.min_price === "") {
          this.$store.commit("user/setAlertTitle", "search");
          this.$store.commit("user/setAlertMsg", "min_price is not selected");
          this.$store.commit("user/setAlertFlag", true);
          return;
        }

        filters["price"] = {
          max_price: this.max_price,
          min_price: this.min_price,
        };
      }

      if (this.smoking_flag === true) {
        if (this.smoking_selected.length > 0) {
          filters["smoking"] = this.smoking_selected;
        } else {
          this.$store.commit("user/setAlertTitle", "search");
          this.$store.commit("user/setAlertMsg", "smoking is not selected");
          this.$store.commit("user/setAlertFlag", true);
          return;
        }
      }

      for (var prop of this.selectFilter) {
        filters[prop] = true;
      }

      /* ex) filters 
      {
        coupon: true
        price: {max_price: '10000', min_price: '1000'}
        smoking: ['禁煙']
      }
      */
      this.$store.commit("shop_selectList/setSelectFilter", [filters]);

      this.sendLocalSearch();
    },
  },
};
</script>
