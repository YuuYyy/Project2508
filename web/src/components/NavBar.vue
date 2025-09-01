<!--HTML写在template中-->
<template>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container">
    <a class="navbar-brand" href="/">Projcet2508</a>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="/pk/">对战</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/record/">对局列表</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/ranklist/">排行榜</a>
        </li>
      </ul>
       <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            playername
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/user/bot/">我的bot</a></li>
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
</script>

<!--css写在style中-->
<!--scoped作用：在这里写的css会自动加上随机字符串，使该样式不会影响到组件以外的部分-->
<style scoped>
</style>