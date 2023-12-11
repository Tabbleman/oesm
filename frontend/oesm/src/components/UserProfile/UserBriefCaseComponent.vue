<template>
  <div class="card">
    <div class="card-body">
      <h5 class="card-title">{{ user.name }}</h5>
      <p class="card-text">Email: {{ user.email }}</p>
    </div>
  </div>
</template>

<script>
export default {
  // 逻辑部分
  props: {
    user: {
      type: Object,
      required: true
    }
  }
};
</script>

<style scoped>
/* 样式调整 */
.card {
  border: transparent;
}

</style>
