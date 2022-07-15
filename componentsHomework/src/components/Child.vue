<template>
  <div>
    <button :class="btnStyle" @click="send"><slot></slot></button><br />
  </div>
</template>

<script>
export default {
   props: {
      btnStyle: String
    },
  data () {
    return {
      allMessage: [
        { message:"保存しました。"},
        { message2:"キャンセルしました。"}
      ],
    
  }
  },
  methods: {
    send() {
      this.$emit("click", this.allMessage);
    },
  
  },
};
</script>
<style scoped>
.save {
  background-color: rgb(246, 0, 0);
  color: rgb(255, 255, 255);
  width: 150px;
  height: 30px;
}
.cancel {
  background-color: rgb(0, 50, 249);
  color: azure;
  width: 150px;
  height: 30px;
}
.input {
  margin-left: 10px;
  height: 38px;
  width: 100px;
  font-size: 30px;
}
.btn {
  height: 40px;
  width: 100px;
  font-size: 20px;
  background-color: rgba(255, 217, 113, 0.76);
  border: 2px solid #ccc;
}
.btn:hover {
  cursor: pointer;
  background-color: yellow;
}
p {
  font-size: 30px;
}
</style>