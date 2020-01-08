<template>
  <a-breadcrumb :routes="breadcrumb">
    <template slot="itemRender" slot-scope="{route, params, routes}">
      <span v-if="routes.indexOf(route) === routes.length - 1">
        {{ route.name }}
      </span>
      <router-link v-else :to="'/' + route.path">
        {{ route.name }}
      </router-link>
    </template>
  </a-breadcrumb>
</template>

<script>
export default {
  name: 'BreadCrumb',
  data () {
    return {
      name: '',
      breadList: []
    }
  },
  computed: {
    breadcrumb () {
      return this.$route.meta.breadcrumb
    }
  }
}
</script>

<style scoped>

</style>
