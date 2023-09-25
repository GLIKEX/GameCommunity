<template>
  <div class="box">
    <div v-for="game in GameImformation" :key="game.Game_Name" class="Game_container">
      <div class="Game_picture">
      <img :src="game.img_src" alt="" class="pic">
    </div>
    <div class="Game_Introduce">
      <p>{{ game.Game_Name }}</p>
      <span class="text">{{ game.Game_Text}}</span>
      <span class="score">{{game.Game_Score}}</span>
    </div>
    </div>
  </div>
</template>

<script>
export default {
  props:{
    GameImformation:{
      type:Array,
      default: function(){
        return[{
          img_src:"",
          Game_Name:"",
          Game_Text:"",
          Game_Score:""}]
        }
      }
    }
}

</script>

<style scoped>
.box{
  display: flex;
  flex-direction: column;

  margin: 0 auto;
  text-align: center;
  /* border-radius: 18px; */

}
.Game_container{
margin-bottom: 50px;
/* border-radius: 18px; */
/* box-shadow: 10px 8px 6px 2px gainsboro; */
width: 1100px;
border-bottom:1px solid #ccc;
}
.Game_picture{
  display: flex;
  width: 100px;
  height: 100px;
  flex-direction: column; /* 垂直排列子组件 */
}
.pic{
  width: 250px;
  height: 200px;
  margin-bottom: 0px;
  /* border-top-left-radius: 18px;
  border-top-right-radius: 18px; */
}
.Game_Introduce{
  display: flex;
  height: 65px;
  flex-direction: column; /* 将子元素垂直排列 */
  justify-content: center; /* 垂直居中文字和分数 */
  align-items: flex-end; /* 将子元素靠右对齐 */
  margin-bottom: 20px;
}
.text{
  color: rgb(121, 119, 119);
  font-size: 14px;
  margin-left: 10px;
}
p{
  margin-left: 10px;
  margin-bottom: 3px ;
  margin-top: 10px ;
  font-weight: 1000;
  font-size:30px
}
.score{
  float: right;
  margin-right: 10px;
  margin-bottom: 20px;
  font-size: 20px;
  color: rgb(21, 197, 206);
  font-weight:bold ;
  bottom: 15px;
  margin-top: 10px;
}
</style>