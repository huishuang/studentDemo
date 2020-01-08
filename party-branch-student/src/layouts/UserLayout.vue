<template>
  <vue-particle-line class="banner-wraper">
    <banner :text="title"/>
    <div class="main">
      <router-view></router-view>
    </div>
    <div class="footer">
      <div class="links">
        <a>帮助</a>
        <a>隐私</a>
        <a>条款</a>
      </div>
      <div class="copyright">
        Copyright &copy; 2018 CloudLab开发者团队
      </div>
    </div>
  </vue-particle-line>
</template>

<script>
// import RouteView from './RouteView'
import { mixinDevice } from '@/utils/mixin'
import banner from '@/components/Login/banner'

export default {
  name: 'UserLayout',
  components: { banner },
  mixins: [mixinDevice],
  data () {
    return {
      title: 'Cloud-Lab'
    }
  },
  mounted () {
    document.body.classList.add('userLayout')
  },
  beforeDestroy () {
    document.body.classList.remove('userLayout')
  }
}
</script>

<style lang="less" scoped>
.main {
  min-width: 260px;
  width: 368px;
  margin: 0 auto;
}
.banner-wraper {
    display: flex;
    justify-content: center;
    align-items: center;
    background: #283644;
  }
.footer {
  margin-top: 100px;
  width: 100%;
  bottom: 0;
  padding: 0 16px;
  text-align: center;
}
.links {
  margin-bottom: 8px;
  font-size: 14px;
  a {
    color: #fff;
    transition: all 0.3s;
    &:not(:last-child) {
      margin-right: 40px;
    }
  }
}
.copyright {
  color: #fff;
  font-size: 14px;
}
</style>
