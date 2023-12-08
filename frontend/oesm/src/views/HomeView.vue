<template>
  <div>
    <NavbarComponent></NavbarComponent> <!-- 使用Navbar组件 -->
    <div class="container">
      <h1>Welcome to our Online Exam System</h1>
      <p>This is the HomeView component.</p>
      <button class="btn btn-primary">Get Started</button>
    </div>
    <FooterComponent/> 
  </div>
</template>

<script>
import NavbarComponent from '@/components/NavbarComponent.vue'; // 导入Navbar组件
import FooterComponent from '@/components/FooterComponent.vue'

export default {
  components: {
    NavbarComponent, // 注册Navbar组件
    FooterComponent
  }
  // 其他组件逻辑
}
</script>
