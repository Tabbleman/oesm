<template>
  <div class="question-card card mb-3">
    <div class="card-body">
      <h5 class="card-title">{{ question.questionName }}</h5>
      <ul class="list-group">
        <li v-for="(choice, index) in choices" :key="index" class="list-group-item">
          <div v-if="question.questionType === 'single'" class="form-check">
            <input
              class="form-check-input"
              type="radio"
              :name="'question-' + question.questionId"
              :id="'choice-' + question.questionId + '-' + index"
              :value="choice"
              @change="handleChoiceChange($event, choice)"
            />
            <label
              class="form-check-label"
              :for="'choice-' + question.questionId + '-' + index"
              >{{ choice }}</label
            >
          </div>
          <div v-else-if="question.questionType === 'multiple'" class="form-check">
            <input
              class="form-check-input"
              type="checkbox"
              :id="'choice-' + question.questionId + '-' + index"
              :value="choice"
              @change="handleChoiceChange($event, choice)"
            />
            <label
              class="form-check-label"
              :for="'choice-' + question.questionId + '-' + index"
              >{{ choice }}</label
            >
          </div>
          <div v-else-if="question.questionType === 'truefalse'" class="form-check">
            <input
              class="form-check-input"
              type="radio"
              :name="'question-' + question.id"
              :id="'choice-' + question.id + '-' + index"
              :value="choice"
              @change="handleChoiceChange($event, choice)"
            />
            <label
              class="form-check-label"
              :for="'choice-' + question.questionId + '-' + index"
              >{{ choice }}</label
            >
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { mapMutations } from "vuex";
export default {
  props: {
    question: {
      type: Object,
      required: true,
    },
  },
  computed: {
    choices() {
      return this.question.questionChoices.split("$");
    },
    answerSheet() {
      // 假设您已经在 Vuex 的 state 中定义了 answerSheet
      return this.$store.state.exam.answerSheet;
    },
  },
  methods: {
    // 使用mapMutations创建一个方法映射
    ...mapMutations("exam", ["UPDATE_ANSWER"]),
    handleChoiceChange(event, choice) {
      if (this.question.questionType === "multiple") {
        // 在多选题时处理多个选项
        let selectedOptions = this.answerSheet.questionAnswers.find(
          (qa) => qa.questionId === this.question.questionId
        );
        
        if (selectedOptions) {
          if (event.target.checked) {
            // 如果复选框被选中，添加答案
            selectedOptions.answer = selectedOptions.answer
              ? selectedOptions.answer + "$" + choice
              : choice;
          } else {
            // 如果复选框被取消选中，移除答案
            let choicesArray = selectedOptions.answer.split("$");
            choicesArray = choicesArray.filter((c) => c !== choice);
            selectedOptions.answer = choicesArray.join("$");
          }
        } else {
          // 如果是第一次选择，创建一个新的答案对象
          this.UPDATE_ANSWER({ questionId: this.question.questionId, answer: choice });
        }
      } else {
        // 单选题或判断题
        this.UPDATE_ANSWER({ questionId: this.question.questionId, answer: choice });
      }
    },
    
  },
};
</script>

<style>
/* 自定义样式可以在这里添加 */
</style>
