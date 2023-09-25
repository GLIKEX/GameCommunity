<template>
  <div class="navigation-bar">
    <span class="initiator">
      <div class="logo-content">
        <div style="display:flex;flex-direction:row;justify-content:flex-start;align-items:center;">
          <div class="logo-text">
            <div>Fun Play</div>
            <div style="font-size:12px;margin-top:5px;color: #666;">
              游戏玩家交流中心
             </div>
          </div>
        </div>
      </div>
      <div class="userin">
        <span @click="Login" class="login">登录</span> |
        <span @click="Register" class="register">注册</span>
      </div>
    </span>
    <div class="menu-content">
      <el-menu
          mode="horizontal"
          @select="handleSelect"
          background-color="#fff"
          text-color="#87CEEB"
          active-text-color="#00BFFF"
          id="menu">
        <el-menu-item index="1" class="item" @click="frontBtn">首页</el-menu-item>
        <el-menu-item index="2" class="item" @click="forumBtn">论坛</el-menu-item>
        <el-menu-item index="3" class="item" @click="classifyBtn">分类</el-menu-item>
      </el-menu>
    </div>
  </div>
</template>

<script>
import classify from "@/views/classify.vue";

export default {
  name: "navbar",
  computed: {
    classify() {
      return classify
    }
  },
  methods:{
    handleSelect(key, keyPath) {},
    Login(){

    },
    Register(){

    },
    frontBtn() {
      new Promise((resolve, reject) => {
        this.$router.push("/home/front", resolve, reject);
      }).catch((err) => console.error(err));
    },
    forumBtn() {
      new Promise((resolve, reject) => {
        this.$router.push("/home/forum", resolve, reject);
      }).catch((err) => console.error(err));
    },
    classifyBtn() {
      new Promise((resolve, reject) => {
        this.$router.push("/home/classify", resolve, reject);
      }).catch((err) => console.error(err));
    }
  }
}
</script>

<style scoped>

.navigation-bar {
  width: 100%;
  .initiator {
    width: 1100px;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    padding: 5px 20px;

    .logo-content {
      color: #00CED1;
      text-align: center;
      .logo-text {
        margin-left: 10px;
        font-size: 16px;
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        justify-content: flex-start;
      }
    }
  }
  .menu-content {
    height: 42px;
    background-color:#fff !important;
  }
  .el-menu {
    width: 1100px;
    margin: 0 auto;
    height: 40px;
    .el-menu-item {
      background-color: #fff !important;
      height: 40px;
      line-height: 40px;
      font-size: 16px;
      margin-right: 34px;
    }
  }
}
.login{
  cursor: pointer;
}
.register{
  cursor: pointer;
}

</style>