<template xmlns="">
  <div class="front-page">
    <swiper></swiper>
    <RecommendVideo_Search></RecommendVideo_Search>
    <RecommendVideo></RecommendVideo>
  </div>
</template>

<script>
import Swiper from "@/components/swiper.vue";
import RecommendVideo_Search from "@/components/RecommendVideo_Search.vue";
import RecommendVideo from "@/components/RecommendVideo.vue";

export default {
  name: "FrontPage",
  components: {RecommendVideo, Swiper,RecommendVideo_Search}
}
</script>

<style scoped>

</style>