<template>
  <div class="card my-4">
    <div class="card-body">
      <h5 class="card-title">Upload User Info</h5>
      <form @submit.prevent="submitFile">
        <div class="mb-3">
          <label for="file" class="form-label">选择文件</label>
          <input type="file" class="form-control" id="file" @change="handleFileUpload">
        </div>
        <button type="submit" class="btn btn-primary">提交</button>
      </form>
    </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex';

export default {
  data() {
    return {
      file: null,
    };
  },
  methods: {
    ...mapActions('user', ['uploadQuestion']),
    
    handleFileUpload(event) {
      this.file = event.target.files[0];
    },

    submitFile() {
      if (this.file) {
        // 调用 Vuex action 来上传文件
        this.uploadQuestion(this.file)
          .then(() => {
            // 处理上传成功，可能是显示消息或跳转到其他视图
            alert('File uploaded successfully');
            this.file = null;
          })
          .catch(error => {
            // 处理上传失败，可能是显示错误消息
            console.error('Error uploading file:', error);
          });
      } else {
        console.error('No file selected');
      }
    }
  }
};
</script>

<style scoped>

</style>

