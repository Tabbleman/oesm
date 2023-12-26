<template>
  <div>
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
import { mapActions } from 'vuex';
export default {
  data() {
    return {
      userName: '',
      userPassword: ''
    }
  },
  methods: {
    ...mapActions('user', {
      loginUser: 'login' // 重命名 Vuex action
    }),
    
    login(event) {
      event.preventDefault(); // 阻止表单默认提交行为
      this.loginUser({
       // 调用重命名后的 Vuex action
        userName: this.username,
        userPassword: this.password
      }).then(() => {
        this.$router.push('/'); 
      }).catch(error => {
        console.error('Login failed:', error); 
      });
    }
  }
}
</script>

<style scoped>
/* 可以在这里添加组件的局部样式 */
</style>
