<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <router-link class="navbar-brand" to="/">考试系统</router-link>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link class="nav-link" to="/user-profile"
              >用户资料</router-link
            >
          </li>
          <!-- 其他导航项... -->
          <li class="nav-item">
            <router-link class="nav-link" to="/" @click="logout">登出</router-link>
          </li>

          <li class="nav-item" v-if="userInfo && userInfo.userRoleLevel === 1">
            <router-link class="nav-link" to="/upload">上传题目</router-link>
          </li>
          
          <li class="nav-item" v-if="userInfo && userInfo.userRoleLevel === 0">
            <router-link class="nav-link" to="/admin">Admin Here!</router-link>
          </li>
          
          <li class="nav-item">
            <router-link class="nav-link" to="/exam">还没做的更多功能：）</router-link>
          </li>

        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
import { mapActions, mapState } from 'vuex';
export default {
  name: "NavbarComponent",
  methods:{
    ...mapActions('user', {
      clearUserInfo: 'clearUserInfo' // 假设你有一个 Vuex action 叫做 clearUserInfo
    }),
    logout() {
      this.clearUserInfo(); // 调用 Vuex action
      localStorage.removeItem('userInfo'); // 清除 localStorage 中的用户信息
      this.$router.push('/login'); // 重定向到登录页面
    }
  },
  computed: {
    ...mapState({
      userInfo: state => state.user.userInfo
    })
  },
};
</script>

<style scoped>
/* 添加一些自定义样式（如果需要） */
</style>
