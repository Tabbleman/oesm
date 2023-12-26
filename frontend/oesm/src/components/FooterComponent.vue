<template>
  
  <footer class="footer mt-auto py-3 bg-light">
    <div class="container text-center">
      <p>&copy; {{ currentYear }} oesm all right reserved.</p>
    </div>
  </footer>
</template>

<script>
export default {
  data() {
    return {
      currentYear: new Date().getFullYear()
    }
  }
}
</script>

<style scoped>
/* 可以在这里添加组件的局部样式 */
.footer {
  flex-shrink: 0;
}

</style>
