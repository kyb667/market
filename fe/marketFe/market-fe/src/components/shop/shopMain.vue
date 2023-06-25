<template>
  <GoogleMap
    id="map"
    :api-key="GOOGLE_API_KEY"
    style="width: 100%; height: 500px"
    :center="center"
    :zoom="3"
    language="kor"
    @click="toggleOverlay"
  >
    <Marker
      :options="{ position: center, label: 'L', title: 'LADY LIBERTY' }"
    />

    <MarkerCluster>
      <Marker
        v-for="(location, i) in locations"
        :options="{ position: location }"
        :key="i"
        @click="center = location"
      >
        <InfoWindow>
          <div id="contet">
            <div id="siteNotice"></div>
            <h1 id="firstHeading" class="firstHeading">Uluru</h1>
            <div id="bodyContent">
              <p>
                <b>Uluru</b>, also referred to as <b>Ayers Rock</b>, is a large
                sandstone rock formation in the southern part of the Northern
                Territory, central Australia. It lies 335&#160;km (208&#160;mi)
                south west of the nearest large town, Alice Springs; 450&#160;km
                (280&#160;mi) by road. Kata Tjuta and Uluru are the two major
                features of the Uluru - Kata Tjuta National Park. Uluru is
                sacred to the Pitjantjatjara and Yankunytjatjara, the Aboriginal
                people of the area. It has many springs, waterholes, rock caves
                and ancient paintings. Uluru is listed as a World Heritage Site.
              </p>
              <p>
                Attribution: Uluru,
                <a
                  href="https://en.wikipedia.org/w/index.php?title=Uluru&oldid=297882194"
                >
                  https://en.wikipedia.org/w/index.php?title=Uluru</a
                >
                (last visited June 22, 2009).
              </p>
            </div>
          </div>
        </InfoWindow>
      </Marker>
    </MarkerCluster>
  </GoogleMap>
</template>

<script>
import { defineComponent, computed } from "vue";
import { useStore } from "vuex";
import { GoogleMap, Marker, MarkerCluster, InfoWindow } from "vue3-google-map";

export default defineComponent({
  components: { GoogleMap, Marker, MarkerCluster, InfoWindow },
  setup() {
    const store = useStore();

    const center = computed(() => store.getters["map/getCenter"]);

    const locations = computed(() => store.getters["map/getLocations"]);

    const GOOGLE_API_KEY = process.env.VUE_APP_GOOGLE_API_KEY;

    return { center, locations, GOOGLE_API_KEY };
  },
  methods: {
    toggleOverlay(event) {
      var latLng = event.latLng.toJSON();
      console.log(latLng);
      this.$store.commit("map/setCenter", latLng);
    },
  },
});
</script>
