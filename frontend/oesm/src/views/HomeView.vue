<template>
  <div class="content-wrapper">
    <NavbarComponent />
    <div class="container">
      <h1>Welcome to our Online Exam System</h1>
      <div class="row">
        <div v-for="exam in exams" :key="exam.id" class="col-md-4 mb-4">
          <ExamCardComponent :exam="exam" />
        </div>
      </div>
    </div>
    <FooterComponent /> 
  </div>
</template>

<script>
import NavbarComponent from '@/components/NavbarComponent.vue';
import FooterComponent from '@/components/FooterComponent.vue';
import ExamCardComponent from '@/components/Exam/ExamCardComponent.vue';

export default {
  components: {
    NavbarComponent,
    FooterComponent,
    ExamCardComponent
  },
  data() {
    return {
      exams: [
        // 假设这些是从 API 或 Vuex Store 获取的考试数据
        { id: 1, name: 'Math Exam', date: '2023-01-01', time: '10:00 AM' },
        { id: 2, name: 'Physics Exam', date: '2023-01-02', time: '02:00 PM' },
        // 更多考试...
      ]
    };
  }
};
</script>

<style>
.content-wrapper {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}
</style>
