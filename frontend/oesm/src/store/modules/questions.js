import api from "@/service/axiosConfig";
// store/module/exam.js
export default {
  namespaced: true,
  state: () => ({
    exams: [] // 存储考试信息
  }),
  mutations: {
    SET_EXAMS(state, exams) {
      state.exams = exams;
    }
  },
  actions: {
    async fetchQuestion({ commit, rootState }) {
      // 模拟获取考试信息，实际中应替换为API请求
      const userId = rootState.user.userInfo.userId;
      api.post("/api/exam/user/exams", { "userId": userId })
      .then(response => {
        commit('SET_EXAMS', response.data); // 假设响应数据就是考试信息
      })
      .catch(error => {
        console.error("Failed to fetch exams:", error);
        // 这里可以处理错误，例如显示错误信息
      });
    }
  }
};
