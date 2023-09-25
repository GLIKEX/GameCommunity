<template>
  <div class="home" ref="top">
    <navbar></navbar>
    <sidebar></sidebar>
    <router-view></router-view>
  </div>
</template>

<script>
import Navbar from "@/components/navbar.vue";
import Sidebar from "@/components/sidebar.vue";

export default {
  name: "Home",
  components: {Sidebar,  Navbar}
}
</script>

<style scoped>

</style>