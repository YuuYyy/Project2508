<!--HTML写在template中-->
<template>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container">
    <!--<a class="navbar-brand" href="/">Projcet2508</a>-->
    <router-link class="navbar-brand" :to="{name: 'home'}">Projcet2508</router-link>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <!--<a class="nav-link" aria-current="page" href="/pk/">对战</a>-->
          <router-link :class="route_name == 'pk_index' ? 'nav-link active' : 'nav-link'" :to="{name: 'pk_index'}">对战</router-link>
        </li>
        <li class="nav-item">
          <router-link :class="route_name == 'record_index' ? 'nav-link active' : 'nav-link'" :to="{name: 'record_index'}">对局列表</router-link>
        </li>
        <li class="nav-item">
          <router-link :class="route_name == 'ranklist_index' ? 'nav-link active' : 'nav-link'" :to="{name: 'ranklist_index'}">排行榜</router-link>
        </li>
      </ul>
       <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            playername
          </a>
          <ul class="dropdown-menu">
            <li>
            <router-link class="dropdown-item" :to="{name: 'user_bot_index'}">我的bot</router-link>
            </li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">退出</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
</template>

<!--js写在script中-->
<script>
import { useRoute } from 'vue-router'
import { computed } from 'vue'

//监视并返回当前查看的页面名称
export default {
  setup() {
    const route = useRoute();
    let route_name = computed(() => route.name)
    return {
      route_name
    }
  }

}
</script>

<!--css写在style中-->
<!--scoped作用：在这里写的css会自动加上随机字符串，使该样式不会影响到组件以外的部分-->
<style scoped>
</style>