<template>
  <div>
    <!-- 循环遍历考试成绩列表 -->
    <UserExamGradeCardComponent 
      v-for="exam in examRecords" 
      :key="exam.id" 
      :exam="exam" 
    />
  </div>
</template>

<script>
import UserExamGradeCardComponent from '@/components/UserProfile/UserExamGradeCardComponent.vue';
import { mapState } from 'vuex';

export default {
  components: {
    UserExamGradeCardComponent
  },
  computed: {
    ...mapState('exam', ['examRecords'])
  },
  mounted() {
    this.$store.dispatch('exam/fetchExamRecords');
  }
};
</script>

<style scoped>
/* 样式调整 */
</style>
