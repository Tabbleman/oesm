import api from '@/service/axiosConfig';
// store/module/exam.js
export default {
  namespaced: true,
  state: () => ({
    exams: [],  // 存储考试信息
    questions: [],
    examConfig: {
      'examName': null,
      'classId': null,
      'examQuestionCount': null,
      'examStartTimeStamp': null,
      'examEndTimeStamp': null
    },
    answerSheet: {
      userId: null,
      examId: null,
      questionAnswers: [

      ]
    },
    examRecords: [],
    scores: []
  }),
  mutations: {
    SET_EXAM_CONTEXT(state, {userId, examId}) {
      state.answerSheet.userId = userId;
      state.answerSheet.examId = examId;
    },

    SET_EXAMS(state, exams) {
      state.exams = exams;
    },
    SET_EXAMRECORDS(state, examRecords) {
      state.examRecords = examRecords;
    },
    SET_QUESTIONS(state, questions) {
      state.questions = questions;
    },
    SET_EXAM_CONFIG(state, examConfig) {
      state.examConfig = examConfig;
    },
    UPDATE_EXAM_CONFIG(state, {fieldName, value}) {
      state.examConfig[fieldName] = value;
    },

    UPDATE_ANSWER(state, {questionId, sheetAnswer}) {
      // 查找或创建答案对象
      let answerEntry = state.answerSheet.questionAnswers.find(
          qa => qa.questionId === questionId);
      if (answerEntry) {
        // 更新答案
        answerEntry.sheetAnswer = sheetAnswer;
      } else {
        // 添加新的答案
        state.answerSheet.questionAnswers.push({questionId, sheetAnswer});
      }
    },
    RESET_ANSWER_SHEET(state) {
      state.answerSheet = {userId: null, examId: null, questionAnswers: []};
    },
  },
  actions: {
    async setExamContext({commit}, {userId, examId}) {
      commit('SET_EXAM_CONTEXT', {userId, examId});
    },
    async fetchExams({commit, rootState}) {
      // 模拟获取考试信息，实际中应替换为API请求
      const userId = rootState.user.userInfo.userId;
      api.post('/api/exam/user/exams/unfinished', {'userId': userId})
          .then(response => {
            commit('SET_EXAMS', response.data);  // 假设响应数据就是考试信息
          })
          .catch(error => {
            console.error('Failed to fetch exams:', error);
            // 这里可以处理错误，例如显示错误信息
          });
    },
    async fetchExamRecords({commit, rootState}) {
      // 模拟获取考试记录信息，实际中应替换为API请求
      const userId = rootState.user.userInfo.userId;
      api.post('/api/exam/user/exams/finished', {'userId': userId})
          .then(response => {
            commit('SET_EXAMRECORDS', response.data);  // 假设响应数据就是考试信息
          })
          .catch(error => {
            console.error('Failed to fetch exams:', error);
            // 这里可以处理错误，例如显示错误信息
          });
    },
    async fetchQuestions({commit, rootState}, examId) {
      return new Promise((resolve, reject) => {
        const userId = rootState.user.userInfo.userId;

        api.get(`/api/exam/${examId}`, {'userId': userId})
            .then(response => {
              commit('SET_QUESTIONS', response.data);  // 更新问题
              resolve(response);
            })
            .catch(error => {
              console.error('Error fetching questions:', error);
              reject(error);
            });
      });
    },

    async uploadQuestion({commit}, fileCsv) {
      try {
        const formData = new FormData();
        formData.append('file', fileCsv);
        const response = api.post('/api/exam/question/upload', formData)
        console.log(response)
        commit();
      } catch (error) {
        console.log(error);
      }
    },

    async submitExamData({commit}, examConfig) {
      api.post('/api/exam/create', {
           examName: examConfig.examName,
           classId: examConfig.classId,
           examQuestionCount: examConfig.examQuestionCount,
           examStartTimeStamp: examConfig.examStartTimeStamp,
           examEndTimeStamp: examConfig.examEndTimeStamp,
         })
          .then(response => {
            commit('SET_EXAM_CONFIG', examConfig);
            if (response && response.data) {
              alert('Exam created successfully!');
            }
          })
          .catch(error => {
            console.error('Error submitting exam:', error);
            alert('Failed to create exam!')
          });
    },

    async submitExamAnswerSheet({commit}, answerSheet) {
      try {
        const response = await api.post('/api/exam/judge', {
          examId: answerSheet.examId,
          userId: answerSheet.userId,
          questionAnswers: answerSheet.questionAnswers
        });
        console.log(response.data);
        console.log(answerSheet);
        // 如有需要，调用相应的 mutation
        commit("RESET_ANSWER_SHEET");  
        alert('提交！答案已成功');
      } catch (error) {
        console.log("Error!");
      }
    }

  }
};
