<template>
  <div class="logo">
    <router-link :to="{name:'dashboard'}">
      <!-- <Logosvg alt="logo" /> -->
      <h1 v-if="showTitle">{{ title }}</h1>
    </router-link>
  </div>
</template>

<script>
import Logosvg from '@/assets/logo.svg?inline'

export default {
  name: 'Logo',
  components: {
    Logosvg
  },
  props: {
    title: {
      type: String,
      default: 'Ant Design Pro',
      required: false
    },
    showTitle: {
      type: Boolean,
      default: true,
      required: false
    }
  }
}
</script>
