<template>
  <div>
    <h1>考试页面</h1>
    <TimeOutComponent/>
    <QuestionsComponent/>

  </div>
</template>

<script>
import QuestionsComponent from '@/components/Exam/QuestionsComponent.vue';
import TimeOutComponent from '@/components/Exam/TimeOutComponent.vue';

import { mapActions, mapState } from 'vuex';
window.addEventListener('beforeunload', (e) => {
  e.preventDefault();
  e.returnValue = '';
});

export default {
  components: {
    QuestionsComponent,
    TimeOutComponent
},
  computed: {
    ...mapState('exam', ['questions'])
  },
  methods: {
    ...mapActions('exam', ['fetchQuestions'])
  },
  created() {
    this.fetchQuestions(this.$route.params.examId);
  },
};
</script>

<style>
  /* 你的样式 */
</style>
