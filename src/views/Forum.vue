<template>
  <div>
    <div class="GameList">
      <GameList :message="message"></GameList>
    </div>
    
    </div>
</template>

<script>
import GameList from '../components/GameList.vue'
export default {
components:{
GameList
},
data(){
  return {
    message:[
      {
      img_src:require('../assets/img/Game1.png'),
      GameName:"山海镜花",
      GameConcernt:"110万关注"
    },
    {
      img_src:require('../assets/img/Game2.png'),
      GameName:"香肠派对",
      GameConcernt:"3535万关注"
    },
    {
      img_src:require('../assets/img/Game3.png'),
      GameName:"浮石之旅",
      GameConcernt:"38万关注"
    },
    {
      img_src:require('../assets/img/Game4.png'),
      GameName:"摇光录：乱世公主",
      GameConcernt:"55万关注"
    },
    {
      img_src:require('../assets/img/Game5.png'),
      GameName:"诸神皇冠",
      GameConcernt:"93万关注"
    },
    {
      img_src:require('../assets/img/Game6.png'),
      GameName:"我的勇者",
      GameConcernt:"316万关注"
    },
      {
        img_src:require('../assets/img/Game7.png'),
      GameName:"阴阳师",
      GameConcernt:"380万关注"
      },
      {
        img_src:require('../assets/img/Game8.png'),
      GameName:"崩坏：星穹铁道",
      GameConcernt:"986万关注"
      }
    ]
  }
}
}
</script>

<style scoped>
.GameList{
  margin-top: 80px;
  float: right;
}
</style>