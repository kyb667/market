<template>
  <shopMain />
  <selectList />
</template>

<script>
import shopMain from "./shop/shopMain.vue";
import selectList from "./shop/selectList.vue";

export default {
  name: "mainFrame",
  components: {
    shopMain,
    selectList,
  },
};
</script>
