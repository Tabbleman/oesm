<template>
  <div>
    <NavbarComponent/>
    <UploadUserInfoFormComponent />
  </div>
</template>
<script>
import NavbarComponent from "@/components/NavbarComponent.vue";
import UploadUserInfoFormComponent from '@/components/UserProfile/UploadUserInfoFormComponent'
export default {
  components: { NavbarComponent, UploadUserInfoFormComponent },
};
</script>

<style>
  
</style>