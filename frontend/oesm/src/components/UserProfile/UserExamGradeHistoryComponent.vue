<template>
  <div>
    <!-- 循环遍历考试成绩列表 -->
    <UserExamGradeCardComponent 
      v-for="exam in exams" 
      :key="exam.id" 
      :exam="exam" 
    />
  </div>
</template>

<script>
import UserExamGradeCardComponent from '@/components/UserProfile/UserExamGradeCardComponent.vue';

export default {
  components: {
    UserExamGradeCardComponent
  },
  props: {
    exams: {
      type: Array,
      required: true
    }
  }
};
</script>

<style scoped>
/* 样式调整 */
</style>
