<template>
  <div class="question-card card">
    <div class="card-body">
      <h5 class="card-title">{{ data.text }}</h5>
      <ul class="list-group">
        <li v-for="(option, index) in options" :key="index" class="list-group-item">
          <template v-if="data.type === 'single'">
            <!-- 单选题 -->
            <input type="radio" :name="'question-' + data.id" :id="'option-' + data.id + '-' + index" :value="option">
            <label :for="'option-' + data.id + '-' + index">{{ option }}</label>
          </template>
          <template v-else-if="data.type === 'multiple'">
            <!-- 多选题 -->
            <input type="checkbox" :id="'option-' + data.id + '-' + index" :value="option">
            <label :for="'option-' + data.id + '-' + index">{{ option }}</label>
          </template>
          <template v-else-if="data.type === 'truefalse'">
            <!-- 判断题 -->
            <input type="radio" :name="'question-' + data.id" :id="'option-' + data.id + '-' + index" :value="option">
            <label :for="'option-' + data.id + '-' + index">{{ option }}</label>
          </template>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    data: {
      type: Object,
      required: true
    }
  },
  computed: {
    options() {
      return this.data.options.split('$');
    }
  }
};
</script>

<style>
  /* 自定义样式可以在这里添加 */
</style>
