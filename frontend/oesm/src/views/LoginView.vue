<template>
  <div>
    <div class="container">
      <h1>Login</h1>
      <LoginFormComponent/> <!-- 使用 LoginForm 组件 -->
    </div>
  </div>
</template>

<script>
import LoginFormComponent from '@/components/LoginFormComponent.vue'; // 导入 LoginForm 组件

export default {
  components: {
    LoginFormComponent 
  },
  
}
</script>
