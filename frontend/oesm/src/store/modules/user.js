// store/modules/user.js
import api from '@/service/axiosConfig'; // 引入配置的 Axios 实例
export default {
  namespaced: true,
  state: {
    userInfo: JSON.parse(localStorage.getItem('userInfo')) || null, // 从 localStorage 获取用户信息
  },
  mutations: {
    SET_USER_INFO(state, userInfo) {
      state.userInfo = userInfo;
      localStorage.setItem('userInfo', JSON.stringify(userInfo)); // 将用户信息存储在 localStorage
    }
  },
  actions: {
    login({ commit }, credentials) {
      return new Promise((resolve, reject) => {
        api.post('/api/user/login', credentials) // 使用 Axios 发送登录请求
          .then(response => {
            commit('SET_USER_INFO', response.data); // 假设响应中包含用户信息
            resolve(response);
          })
          .catch(error => {
            reject(error);
          });
      });
    },
    logout({commit}){
      commit('SET_USER_INFO', null); // 清空用户信息
    }
    // 其他 actions...
  }
  // 其他 state, getters...
};
