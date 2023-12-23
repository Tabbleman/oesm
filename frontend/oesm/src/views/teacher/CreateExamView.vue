<template>
  <div>
    <NavbarComponent/>
    <CreateExamFormComponent/>
    
  </div>
</template>

<script>

import NavbarComponent from '@/components/NavbarComponent.vue';
import CreateExamFormComponent from '@/components/Exam/CreateExamFormComponent.vue';

export default {
  components:{
    NavbarComponent,
    CreateExamFormComponent
  }
};

</script>

<style>
  
</style>