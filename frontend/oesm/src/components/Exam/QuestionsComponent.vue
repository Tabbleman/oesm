<template>
  <div class="container">
    <div class="row">
      <div class="col-md-8">
        <div v-for="(question, index) in questions" :key="index" class="mb-3">
          <QuestionComponent :data="question" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import QuestionComponent from './QuestionComponent.vue';

export default {
  components: {
    QuestionComponent
  },
  props: {
    questions: { // 使用 'questions' 作为 prop 名
      type: Array,
      required: true
    }
  }
};
</script>

<style>
  /* 如果需要，可以在这里添加自定义样式 */
</style>
