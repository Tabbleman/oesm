<template>
  <div class="question-card card">
    <div class="card-body">
      <h5 class="card-title">{{ question.questionName }}</h5>
      <ul class="list-group">
        <li v-for="(choice, index) in choices" :key="index" class="list-group-item">
          <template v-if="question.questionType === 'single'">
            <input type="radio" :name="'question-' + question.questionId" :id="'choice-' + question.questionId + '-' + index" :value="choice">
            <label :for="'choice-' + question.questionId + '-' + index">{{ choice }}</label>
          </template>
          <template v-else-if="question.questionType === 'multiple'">
            <input type="checkbox" :id="'choice-' + question.questionId + '-' + index" :value="choice">
            <label :for="'choice-' + question.questionId + '-' + index">{{ choice }}</label>
          </template>
          <template v-else-if="question.questionType === 'truefalse'">
            <input type="radio" :name="'question-' + question.id" :id="'choice-' + question.id + '-' + index" :value="choice">
            <label :for="'choice-' + question.questionId + '-' + index">{{ choice }}</label>
          </template>
        </li>
      </ul>

    </div>
  </div>
</template>

<script>
export default {
  props: {
    question: {
      type: Object,
      required: true
    }
  },
  computed: {
    choices() {
      return this.question.questionChoices.split('$');
    }
  },
};
</script>

<style>
  /* 自定义样式可以在这里添加 */
</style>
