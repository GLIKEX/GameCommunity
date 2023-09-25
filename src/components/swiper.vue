<template>
  <div class="swiper-container">
    <el-carousel :interval="4000" type="card" height="300px">
      <el-carousel-item  >
        <img src='../assets/img/swiper01.jpg' width="100%" height="100%">
      </el-carousel-item>
      <el-carousel-item >
        <img src='../assets/img/swiper02.jpg' width="100%" height="100%">
      </el-carousel-item>
      <el-carousel-item >
        <img src='../assets/img/swiper03.jpg' width="100%" height="100%">
      </el-carousel-item>
      <el-carousel-item >
        <img src='../assets/img/swiper04.png' width="100%" height="100%">
      </el-carousel-item>
      <el-carousel-item >
        <img src='../assets/img/swiper05.png' width="100%" height="100%">
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: "swiper"
}
</script>

<style scoped>
.swiper-container
{
  margin: 30px auto 0;
  width: 75%;
  text-align: center;
}
</style>