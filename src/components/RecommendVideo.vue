<template>
  <div class="Recommend_video">
      <div class="RecommendGame">
        <!-- 推荐游戏 -->
        <RecommendVideo_game :GameImformation="GameImformation"></RecommendVideo_game>
      </div>
    
  </div>
</template>

<script>
import RecommendVideo_game from './RecommendVideo_game.vue';

export default {
    components:{
        RecommendVideo_game
    },
    data(){
        return{
          GameImformation:[
            {
              img_src: require('../assets/img/1.png'),
              Game_Name:'电子木鱼',
              Game_Text:'超级解压的一款游戏!',
              Game_Score:'7.5'
        },
        {
          img_src: require('../assets/img/2.png'),
              Game_Name:'原神',
              Game_Text:'原神4.0版本抢先更新!',
              Game_Score:'9.0'

        },
        {
          img_src: require('../assets/img/3.jpg'),
              Game_Name:'冒险岛：枫之传说',
              Game_Text:'冒险岛IP正版手游，邀你登岛冒险',
              Game_Score:'4.9'

        }]
        }
    }

}

</script>

<style scoped>
.Recommend_video{
  margin:0 auto;
  text-align: center;
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
}
.RecommendGame {
  /* 调整左右间距 */
  margin-left: 50px;
  margin-right: 50px;
}

</style>
