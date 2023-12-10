<template>
  <div class="card">
    <div class="card-body">
      <h5 class="card-title">{{ exam.name }}</h5>
      <p class="card-text">Date: {{ exam.date }}</p>
      <p class="card-text">Time: {{ exam.time }}</p>
      <router-link :to="'/exam/' + exam.id" class="btn btn-primary">View Exam</router-link>
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
/* 你可以添加一些样式来美化卡片 */
</style>
