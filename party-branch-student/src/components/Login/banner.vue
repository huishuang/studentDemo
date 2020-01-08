<template>
  <div class="banner">
    <h2>{{ text }}</h2>
  </div>
</template>

<script>
/* eslint-disable */
export default {
  name: 'Banner',
  props: [ 'text' ]
}
</script>

<style lang="scss" scoped>
.banner {
  display: flex;
  justify-content: center;
  align-items: center;
  color: #fff;
  h2 {
    font-size: 5em;
    font-family: Teko, sans-serif;
    background: linear-gradient(to right, #c62020, #2188e1);
    background-clip: text;
    -webkit-background-clip: text;
    color: transparent;
  }
}
</style>
