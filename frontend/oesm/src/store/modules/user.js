// store/module/user.js
export default {
  namespaced: true,
  state: () => ({
    userInfo: null // 存储用户信息
  }),
  mutations: {
    SET_USER_INFO(state, userInfo) {
      state.userInfo = userInfo;
    }
  },
  actions: {
    login({ commit }, userInfo) {
      // 模拟用户登录，实际中应替换为API请求
      commit('SET_USER_INFO', userInfo);
    }
  }
};
