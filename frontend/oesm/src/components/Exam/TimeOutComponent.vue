<template>
  <div class="timer-container">
    {{ timeLeft }}
  </div>
</template>

<script>
export default {
  data() {
    return {
      totalSeconds: 3600, // 假设考试时间为 1 小时
      timer: null,
      timeLeft: '',
    };
  },
  methods: {
    startTimer() {
      this.timer = setInterval(() => {
        if (this.totalSeconds > 0) {
          this.totalSeconds -= 1;
          this.updateTimeLeft();
        } else {
          clearInterval(this.timer);
          // 可以在这里加入考试时间结束的处理逻辑
        }
      }, 1000);
    },
    updateTimeLeft() {
      const hours = Math.floor(this.totalSeconds / 3600);
      const minutes = Math.floor((this.totalSeconds % 3600) / 60);
      const seconds = this.totalSeconds % 60;

      this.timeLeft = `${hours}:${minutes}:${seconds}`;
    }
  },
  mounted() {
    this.updateTimeLeft();
    this.startTimer();
  },
  beforeUnmount() {
    if (this.timer) {
      clearInterval(this.timer);
    }
  }
};
</script>

<style>
.timer-container {
  position: fixed;
  top: 20px;  /* 距离顶部的距离 */
  right: 20px; /* 距离右侧的距离 */
  background-color: white; /* 背景颜色 */
  padding: 10px; /* 内边距 */
  border: 1px solid #ccc; /* 边框样式 */
  border-radius: 5px; /* 边框圆角 */
  box-shadow: 0px 0px 10px rgba(0,0,0,0.1); /* 阴影效果 */
  z-index: 1000; /* 确保组件在最前面 */
}
</style>
