<template>
  <div class="modal-bg" v-show="show">
    <div class="modal-container">
      <div class="modal-header">
        {{ title }}
      </div>
      <div class="modal-main">
        <slot></slot>
      </div>
      <div class="modal-footer">
        <el-button round @click="hideModal">取消</el-button>
        <el-button type="primary" round @click="submit">确认</el-button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'modal',
  props: {
    show: {
      type: Boolean,
      default: false
    },
    title: {
      type: String,
      default: ''
    },
  },
  methods: {
    hideModal() {
      this.$emit('hideModal')
    },

    submit() {
      this.$emit('submit')
    },
  }
}
</script>