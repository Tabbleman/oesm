<template>
  <div>
    <h2>Login</h2>
    <form @submit="login">
      <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" id="username" v-model="username">
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" v-model="password">
      </div>
      <button type="submit" class="btn btn-primary">Login</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: ''
    }
  },
  methods: {
    login() {
      // 在这里处理登录逻辑，可以使用 this.username 和 this.password 获取输入的值
      // 例如，发送登录请求到服务器
      console.log('Logging in with username:', this.username);
    }
  }
}
</script>

<style scoped>
/* 可以在这里添加组件的局部样式 */
</style>
