import { createRouter, createWebHashHistory } from 'vue-router'
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
  {
    path: '/'
  }

]

const router = createRouter({
  mode:'history',
  history: createWebHashHistory(),
  routes
})

export default router
