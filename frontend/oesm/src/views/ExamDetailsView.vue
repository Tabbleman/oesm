<template>
  <div>
    <NavbarComponent />
    <h1>考试页面</h1>
    <QuestionsComponent :questions="questions" />
  </div>
</template>

<script>
import NavbarComponent from '../components/NavbarComponent.vue';
import QuestionsComponent from '@/components/Exam/QuestionComponent.vue';
export default {
  components: {
    NavbarComponent,
    QuestionsComponent
  },
  data() {
    return {
      questions: [
        // 假设这些是从 API 或 Vuex Store 获取的考试问题
        { id: 1, text: '第1个问题的文本...', options: "123$234$345$456", type: "single"},
        { id: 2, text: '第2个问题的文本...', options: "T$F" , type:"truefalse"},
        { id: 3, text: '第3个问题的文本...', options: "123$234$345$456", type: "multiple"},
        // 更多问题...
      ]
    };
  }
};
</script>

<style>
  /* 你的样式 */
</style>
