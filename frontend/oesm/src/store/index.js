import { createStore } from 'vuex'
import user from './modules/user'
import exam from './modules/exam'
export default createStore({
  modules: {
    user, exam
  }
})
