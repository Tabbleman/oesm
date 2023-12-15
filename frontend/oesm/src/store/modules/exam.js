import api from "@/service/axiosConfig";
// store/module/exam.js
export default {
  namespaced: true,
  state: () => ({
    exams: [], // 存储考试信息
    questions: []
  }),
  mutations: {
    SET_EXAMS(state, exams) {
      state.exams = exams;
    },
    SET_QUESTIONS(state, questions) {
      state.questions = questions;
    }
  },
  actions: {
    async fetchExams({ commit, rootState }) {
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
    },
    async fetchQuestions({ commit, rootState }, examId) {
      return new Promise((resolve, reject) => {
        const userId = rootState.user.userInfo.userId;

        api.get(`/api/exam/${examId}`, {"userId":userId})
          .then(response => {
            commit('SET_QUESTIONS', response.data); // 更新问题
            resolve(response);
          })
          .catch(error => {
            console.error("Error fetching questions:", error);
            reject(error);
          });
      });
    }

  }
};
