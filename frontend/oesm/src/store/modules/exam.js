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
    fetchExams({ commit }) {
      // 模拟获取考试信息，实际中应替换为API请求
      const examsData = [] // 假设的考试数据
      commit('SET_EXAMS', examsData);
    }
  }
};
