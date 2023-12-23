<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <router-link class="navbar-brand" to="/">oesm</router-link>
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

          <li class="nav-item dropdown" v-if="userInfo && userInfo.userRoleLevel === 1">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              问题管理
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
              <li><router-link class="dropdown-item" to="/upload">上传题目</router-link></li>
              <!-- 其他子项... -->
            </ul>
          </li>

          <!-- 考试管理下拉菜单 -->
          <li class="nav-item dropdown" v-if="userInfo && userInfo.userRoleLevel === 1">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownExamLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              考试管理
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownExamLink">
              <li><router-link class="dropdown-item" to="/create-exam">发布考试</router-link></li>
              <!-- 其他子项... -->
            </ul>
          </li>
          
          <li class="nav-item dropdown" v-if="userInfo && userInfo.userRoleLevel === 1">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownExamLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              学生管理
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdownExamLink">
              <li><router-link class="dropdown-item" to="/class-grade">成绩单</router-link></li>
              <li><router-link class="dropdown-item" to="/import-info">导入学生信息</router-link></li>
              <!-- 其他子项... -->
            </ul>
          </li>

          <li class="nav-item" v-if="userInfo && userInfo.userRoleLevel === 0">
            <router-link class="nav-link" to="/admin">Admin Here!</router-link>
          </li>
                    
          <li class="nav-item">
            <router-link class="nav-link" to="/" @click="logout">登出</router-link>
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
@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(-10px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

.navbar-nav .dropdown-menu {
  display: none; /* 初始状态设置为隐藏 */
  animation: fadeIn 0.5s ease forwards; /* 应用淡入动画 */
}

.dropdown:hover .dropdown-menu {
  display: block; /* 鼠标悬停时显示下拉菜单 */
}

</style>
