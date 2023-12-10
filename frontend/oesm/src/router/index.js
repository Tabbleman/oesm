import { createRouter, createWebHistory } from 'vue-router'
// import vue view
import HomeView from '../views/HomeView.vue'
import store from '../store' // 引入 Vuex store


const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView 
  },
  
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, from, next) => {
  // 检查用户是否登录
  const isLoggedIn = store.state.user.userInfo !== null;
  if (!isLoggedIn && to.name !== 'login') { // 假设有一个名为 'login' 的登录路由
    next({ name: 'login' }); // 重定向到登录页
  } else {
    next(); // 正常进入目标页面
  }
})
export default router
