<template>
  <div>
    <div class="container">
      <h1>Register</h1>
      <RegisterFormComponent></RegisterFormComponent>
    </div>
  </div>
</template>

<script>
import RegisterFormComponent from "@/components/RegisterFormComponent.vue";

export default {
  components: {
    RegisterFormComponent,
  },
};
</script>
