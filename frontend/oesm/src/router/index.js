import { createRouter, createWebHashHistory } from 'vue-router'
// import vue view
import HomeView from '../views/HomeView.vue'


const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView 
  },
  
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
