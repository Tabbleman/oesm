<template>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div
          v-for="(question, index) in examQuestions"
          :key="index"
          class="mb-3"
        >
          <QuestionComponent :question="question" />
        </div>
      </div>
      <button type="button" class="btn btn-primary" @click="handleSubmit">
        Submit
      </button>
    </div>
  </div>
</template>

<script>
import QuestionComponent from "./QuestionComponent.vue";
import { mapState, mapActions } from "vuex";
export default {
  components: {
    QuestionComponent,
  },
  computed: {
    ...mapState("exam", ["questions"]),
    examQuestions() {
      return this.questions; // Assuming 'questions' is the exact name in your Vuex module
    },
  },
  methods: {
    ...mapActions("exam", ["submitExamAnswerSheet"]),
    handleSubmit() {
      // 用户 ID 和考试 ID 已经在 Vuex store 中设置好了
      this.submitExamAnswerSheet(this.$store.state.exam.answerSheet)
        .then(() => {
          alert("答案提交成功！");
          this.$store.commit('exam/RESET_ANSWER_SHEET'); 
          this.$router.push("/")
        })
        .catch(error => {
          console.error("答案提交失败：", error);
          alert("提交出错！");
        });
    },
  },
};
</script>

<style>
/* 如果需要，可以在这里添加自定义样式 */
</style>
