<template>
  <NavBar></NavBar>
  <router-view></router-view>
</template>

<!--导入组件NavBar-->
<script>
import NavBar from "@/components/NavBar.vue"
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"
// import $ from 'jquery'

export default{
  components:{
    NavBar
  },
  setup() {
    // $.ajax({
    //   url:"http://127.0.0.1:3000/user/account/token/",
    //   type:"post",
    //   data: {
    //     username: "test",
    //     password: "test",
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp); 
    //   }
    // });

    // $.ajax({
    //   url:"http://127.0.0.1:3000/user/account/info/",
    //   type:"get",
    //   headers: {
    //     Authorization: "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiMjQ4MjNiM2ZmN2I0NjA0OTFmY2JlZmUyNThjZWQzNyIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTc1NzQ4MDYzMSwiZXhwIjoxNzU4NjkwMjMxfQ._FbfLt-wRzqsMtXFSfrgSSKLMnglOxYl2PlCrlk0XjQ"
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp); 
    //   }
    // });

//     $.ajax({
//       url:"http://127.0.0.1:3000/user/account/register/",
//       type:"post",
//       data: {
//         username: "test3",
//         password: "test3",
//         confirmedPassword: "test3",
//       },
//       success(resp) {
//         console.log(resp);
//       },
//       error(resp) {
//         console.log(resp); 
//       }
//     });
  }
}
</script>

<style>
body{
  background-image: url("@/assets/images/background.png");
  background-size: cover;
}
</style>