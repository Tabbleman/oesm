<template>
  <div class="card">
    <div class="card-body">
      <h5 class="card-title">{{ exam.examName }}</h5>
      <p class="card-text">开始时间 <br> {{ exam.examStartTimeStamp }}</p>
      <p class="card-text">结束时间 <br> {{ exam.examEndTimeStamp }}</p>
      <router-link :to="'/exam/' + exam.examId" class="btn btn-primary" @click="startExam">开始考试</router-link>
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
  },
  methods: {
    startExam() {
      const examId = this.exam.examId;
      const userId = this.$store.state.user.userInfo.userId; 
      
      localStorage.setItem("currentExamEndTime", this.exam.examEndTimeStamp);
      this.$store.dispatch('exam/setExamContext', { userId, examId });
    }
  }
};
</script>

<style scoped>
/* 你可以添加一些样式来美化卡片 */
</style>
