<template>
    <div class="sidebar">
      <div class="message">
        <img src="../assets/img/xiaoxi.png" alt="">
        消息
      </div>
      <div class="kefu">
        <img src="../assets/img/kefu.png" alt="">
        客服
      </div>
      <div class="fankui">
        <img src="../assets/img/yijianfankui.png" alt="">
        反馈
      </div>
      <div class="tixing">
        <img src="../assets/img/tixing.png" alt="">
        提醒
      </div>
    </div>
</template>

<script>
export default {
  name: "sidebar"
}
</script>

<style scoped>
.sidebar {
  position: fixed;
  bottom: 0;
  padding-top: 26px;
  padding-bottom: 26px;
  left: 0;
  width: 60px;
  background-color: white;
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
}
img{
  clear: both;
  display: flex;
  width: 22px;
  height: 24px;
  background-size: 28px;
  margin: auto auto 5px;
}

.sidebar div{
  margin-bottom: 15px;
  text-align: center;
}
</style>