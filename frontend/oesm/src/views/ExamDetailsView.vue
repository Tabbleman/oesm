<template>
  <div>
    <NavbarComponent />
    <h1>考试页面</h1>
    <QuestionsComponent/>
  </div>
</template>

<script>
import NavbarComponent from '../components/NavbarComponent.vue';
import QuestionsComponent from '@/components/Exam/QuestionsComponent.vue';
import { mapActions, mapState } from 'vuex';

export default {
  components: {
    NavbarComponent,
    QuestionsComponent
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
