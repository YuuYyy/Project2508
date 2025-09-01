<template>
  <NavBar></NavBar>
  <router-view></router-view>
</template>

<!--导入组件NavBar-->
<script>
import NavBar from "@/components/NavBar.vue"
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"

export default{
  components:{
    NavBar
  }
}
</script>

<style>
body{
  background-image: url("@/assets/background.png");
  background-size: cover;
}
</style>