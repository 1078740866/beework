<template>
  <div>
    <!-- <Child @click="getMessage" /> -->
    <Child btnStyle="save" @click="getMessage">保存</Child><br><br>
    <Child btnStyle="cancel" @click="getMessage2">キャンセル</Child>
    <p class="message">{{ message }}</p>
  </div>
</template>

<script>
import Child from "./Child.vue";
export default {
  data() {
    return {
      message:"",
    };
  },
  components: {
    Child,
  },

  methods: {
    getMessage() {
      this.message="保存しました"
    },
    getMessage2() {
      this.message="キャンセルしました"
    },
  },
};
</script>
<style>
p {
  font-size: 40px;
}
.message {
  background-color: rgb(225, 246, 250);
  font: 100;
}
</style>
