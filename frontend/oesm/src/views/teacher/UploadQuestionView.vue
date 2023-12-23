<template>
  <div>
    <NavbarComponent/>
    <UploadQuestionFormComponent />
  </div>
</template>
<script>
import UploadQuestionFormComponent from "@/components/Exam/UploadQuestionFormComponent.vue";
import NavbarComponent from "@/components/NavbarComponent.vue";
export default {
  components: { NavbarComponent, UploadQuestionFormComponent },
};
</script>
<style>
  
</style>