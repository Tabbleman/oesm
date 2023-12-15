<template>
  <div class="container">
    <div class="row">
      <div class="col-md-8">
        <div v-for="(question, index) in examQuestions" :key="index" class="mb-3">
          <QuestionComponent :question="question"/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import QuestionComponent from './QuestionComponent.vue';
import { mapState } from 'vuex';
export default {
  components: {
    QuestionComponent
  },
  computed: {
    ...mapState('exam', ['questions']),
    examQuestions() {
      return this.questions; // Assuming 'questions' is the exact name in your Vuex module
    }
  },
  
};
</script>

<style>
  /* 如果需要，可以在这里添加自定义样式 */
</style>
