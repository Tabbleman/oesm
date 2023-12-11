<template>
  <div class="card mb-2">
    <div class="card-body">
      <h5 class="card-title">{{ exam.name }}</h5>
      <p class="card-text">Score: {{ exam.score }}</p>
      <!-- 其他考试信息 -->
    </div>
  </div>
</template>

<script>
export default {
  props: {
    exam: {
      type: Object,
      required: true
    }
  }
};
</script>

<style scoped>
/* 样式调整 */
</style>
