<template>
  <div class="timer-container">
    你还有😎        <br />
    {{ timeLeft }}  <br />
    的作答时间😆
  </div>
</template>

<script>
import { mapActions } from "vuex";
export default {
  data() {
    return {
      examEndTime: null,
      totalSeconds: 0,
      timer: null,  
      timeLeft: "",
    };
  },

  methods: {
    ...mapActions("exam", ["submitExamAnswerSheet"]),
    handleSubmit() {
      // 用户 ID 和考试 ID 已经在 Vuex store 中设置好了
      this.submitExamAnswerSheet(this.$store.state.exam.answerSheet)
        .then(() => {
          alert("答案提交成功！");
          this.$store.commit("exam/RESET_ANSWER_SHEET");
          this.$router.push("/");
        })
        .catch((error) => {
          console.error("答案提交失败：", error);
          alert("提交出错！");
        });
    },
    
    startTimer() {
      this.timer = setInterval(() => {
        if (this.totalSeconds > 0) {
          this.totalSeconds -= 1;
          this.updateTimeLeft();
        } else {
          clearInterval(this.timer);
          this.handleSubmit();
          alert("Successfully upload your exam answer sheet!");
        }
      }, 1000);
    },
    updateTimeLeft() {
      const hours = Math.floor(this.totalSeconds / 3600);
      const minutes = Math.floor((this.totalSeconds % 3600) / 60);
      const seconds = this.totalSeconds % 60;

      this.timeLeft = `${hours}:${minutes}:${seconds}`;
    },
  },

  mounted() {
    this.examEndTime = new Date(localStorage.getItem('currentExamEndTime'));
    let currentTime = new Date();
    this.totalSeconds = Math.floor((this.examEndTime - currentTime) / 1000) ;
    if(this.totalSeconds < 0){
      this.totalSeconds = 0;
    }
    this.updateTimeLeft();
    this.startTimer();
  },
  beforeUnmount() {
    if (this.timer) {
      clearInterval(this.timer);
    }
  },
};
</script>

<style>
.timer-container {
  position: fixed;
  bottom: 20px; /* 距离顶部的距离 */
  right: 20px; /* 距离右侧的距离 */
  background-color: white; /* 背景颜色 */
  padding: 10px; /* 内边距 */
  border: 1px solid #ccc; /* 边框样式 */
  border-radius: 10px; /* 边框圆角 */
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); /* 阴影效果 */
  z-index: 1000; /* 确保组件在最前面 */
}
</style>
