<template>
  <div class="TotalList">
    <div class="title">热门游戏论坛</div>
    <div v-for="game in message" :key="game.GameName">
    <div class="game">
        <img :src="game.img_src" alt="">
        <div class="text">
            <span class="name">{{ game.GameName }}</span><br>
            <span class="numberOfConcentrate">{{ game.GameConcernt }}</span>
        </div>
        
        <button>关注</button>

    </div>
</div>
    <div class="seeAll">查看全部</div>
  </div>
</template>

<script>
export default {
    props:{
        message:{
            type:Array,
            default:function(){
                return[{
                    img_src:"",
                    GameName:"",
                    GameConcernt:""
                }]
            }
        }
    }
}
</script>

<style scoped>
.TotalList{
    width: 300px;
    border: 1px solid rgb(235, 239, 240);
    border-radius: 10px;
}
.title{
    padding-top: 5px;
    padding-left: 10px;
    padding-bottom: 5px;
    margin-bottom: 15px;
    border-bottom: 1px solid rgb(235, 239, 240);
    font-weight: bold;
}
.game{
    display: flex;
    height: 50px;
    margin:20px 10px;
}
button{
    float: right;
    height: 30px;
    color: rgb(98, 215, 222);
    background-color: rgb(236, 250, 251);
    border: 1px solid rgb(236, 250, 251);
    border-radius: 18px;
    width: 80px;
    margin-left: 40px;
    margin-top: 8px;
}
.text{
    display:inline-block;
    /* justify-content: center;
    align-items: center; */
    width: 180px;
    margin-left: 8px;
}
.name{
margin-bottom: 15px;
font-size: 15px;
}
.numberOfConcentrate{
color: #868585;
font-size: 10px;
/* margin-top: 40px; */
}
.seeAll{
    border-top: 1px solid rgb(235, 239, 240);
    margin-top:10px; 
    font-size: 10px;
    color: rgb(98, 215, 222);
    padding-top: 8px;
    padding-left: 10px;
    padding-bottom: 8px;
}
</style>