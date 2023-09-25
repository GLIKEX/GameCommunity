<template>
  <div class="Search">
        <input type="text" class="search" placeholder="搜索推荐视频" @focus="inputFocus" @blur="inputBlur" :class="{'focused':isinputFocus}">
        <input type="button" name="" id="" class="btn" value="Search">
    </div>
</template>

<script>
export default {
    data(){
        return{
            isinputFocus:false
        }
    },
    methods:{
        inputFocus(){
            this.isinputFocus=true
        },
        inputBlur(){
            this.isinputFocus=false
        }
    }
}
</script>

<style scoped>
* {
    margin: 0;
    padding: 0;
}
.container {
    height: 70px;
    width: 800px;
    margin: 100px auto 0 auto;
}

.Search{
    margin:0 auto;
    text-align: center;
    margin-top:20px;
    margin-bottom:100px ;
}
.parent {
    position: relative;
}

.search {
    width: 340px;
    height: 40px;
    border-top-left-radius: 18px;
    border-bottom-left-radius: 18px;
    outline: none;
    border: 1px solid #ccc;
    padding-left: 20px;
    text-align: center;
    left: 200px;
}
.focused{
    border-color: rgb(21, 197, 206);
    /* border-width: 1px;
    border-style:sold; */
}

.btn {
    height: 42px;
    width: 80px;
    background-color:rgb(21, 197, 206);
    border: none;
    outline: none;
    cursor: pointer;
    border-top-right-radius: 18px;
    border-bottom-right-radius: 18px;
    /* font-size: 10px; */
    color: white;
}

</style>