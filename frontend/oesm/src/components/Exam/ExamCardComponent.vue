<template>
  <div class="card">
    <div class="card-body">
      <h5 class="card-title">{{ exam.examName }}</h5>
      <p class="card-text">开始时间 <br> {{ exam.examStartTimeStamp }}</p>
      <p class="card-text">结束时间 <br> {{ exam.examEndTimeStamp }}</p>
      <router-link :to="'/exam/' + exam.examId" class="btn btn-primary">开始考试</router-link>
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
