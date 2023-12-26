<template>
  <div>
    <NavbarComponent />
    <ExamDetailWrapperComponent />
    <FooterComponent/>
  </div>
</template>

<script>
import ExamDetailWrapperComponent from "@/components/Exam/ExamDetailWrapperComponent.vue";
import NavbarComponent from "@/components/NavbarComponent.vue";
import FooterComponent from "@/components/FooterComponent.vue";

window.addEventListener("beforeunload", (e) => {
  e.preventDefault();
  e.returnValue = "";
});

export default {
  components: {
    NavbarComponent,
    ExamDetailWrapperComponent,
    FooterComponent 
  }
};
</script>

<style>
/* 你的样式 */
</style>
