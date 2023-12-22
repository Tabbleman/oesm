<template>
  <div>
    <NavbarComponent />
    <ExamDetailWrapperComponent />
  </div>
</template>

<script>
import ExamDetailWrapperComponent from "@/components/Exam/ExamDetailWrapperComponent.vue";
import NavbarComponent from "../components/NavbarComponent.vue";

window.addEventListener("beforeunload", (e) => {
  e.preventDefault();
  e.returnValue = "";
});

export default {
  components: {
    NavbarComponent,
    ExamDetailWrapperComponent,
  }
};
</script>

<style>
/* 你的样式 */
</style>
