<template>
  <div class="content-wrapper">
    <NavbarComponent />
    <div class="container">
      <h1>💩</h1>
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
import NavbarComponent from "@/components/NavbarComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";
import ExamCardComponent from "@/components/Exam/ExamCardComponent.vue";
import { mapActions, mapState } from "vuex";
export default {
  components: {
    NavbarComponent,
    FooterComponent,
    ExamCardComponent,
  },
  computed: {
    ...mapState('exam', ['exams']), // 从 Vuex 获取考试信息
  },
  created() {
    this.fetchExams(); // 调用 fetchExams 动作获取考试信息
  },
  methods: {
    ...mapActions('exam', ['fetchExams']), // 映射 fetchExams 动作
  },
};
</script>



<style lang="scss">

.content-wrapper {
  display: flex;
  flex-direction: column;
  min-height: 100vh;

}

</style>

