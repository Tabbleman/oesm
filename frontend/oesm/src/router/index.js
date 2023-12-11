import store from '../store' // 引入 Vuex store
import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue' // 导入LoginView组件
import UserProfileView from '../views/UserProfileView.vue' // 导入UserProfileView组件
import ExamDetailsView from '../views/ExamDetailsView.vue' // 导入ExamDetailView组件 from '../views/ExamView.vue' // 导入ExamView组件



const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView 
  },
  {
    path: '/login', // 添加LoginView的路由配置
    name: 'login',
    component: LoginView
  },
  { 
    path: '/user-profile',
    name:"user-profile",
    component: UserProfileView 
  },
  {
    path: '/exam',
    name: 'exam',
    component: ExamDetailsView
  },

]

const router = createRouter({
  mode:'history',
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
