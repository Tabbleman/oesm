<template>
  <div class="card">
    <div class="card-body">
      <h5 class="card-title">Id:  {{ userInfo.userId }}</h5>
      <p class="card-text">Name: {{ userInfo.userName }}</p>
      
    </div>
  </div>
</template>

<script>
import {mapState} from 'vuex'

export default {
  // 逻辑部分
  computed: {
    ...mapState({
      userInfo: state => state.user.userInfo
    })
  }
};
</script>

<style scoped>
/* 样式调整 */
.card {
  border: transparent;
}

</style>
