<template>
  <div class="card mb-2">
    <div class="card-body">
      <h5 class="card-title">Exam name: {{ exam.examName }}</h5>
      <p class="card-text">Score: {{ exam.userScore }}</p>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    exam: {
      type: Object,
      required: true
    }
  }
};
</script>

<style scoped>

</style>
