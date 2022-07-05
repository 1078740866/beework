<template>
  <footer class="footer">
    <!-- データを表示させます。-->
    <div class="fontSize">
      <el-link type="primary" href="../privacy">
        プライバシー
      </el-link>
      <el-divider direction="vertical" />
      <el-link type="primary" href="../terms">
        利用規約
      </el-link>
    </div>
    <div>{{ copyright }}</div>
  </footer>
</template>

<script>
export default {
  //Vue インスタンスのためのデータオブジェクトです
  data() {
    return {
      copyright: "Copyright (C) 2021 Ansin Corporation. All Rights Reserved.",
    };
  },
};
</script>

<style>
.footer {
  background-color: #eeeeee;
  color: #555;
  padding-bottom: 10px;
  padding-top: 10px;
  text-align: center;
  left: 0px;
  bottom: 0px;
  width: 100%;
  height: 40px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
h1 {
  color: #013892;
  margin: 0;
}
p {
  color: #000;
  margin: 0;
}
.fontSize {
  font-size: 16px;
}
</style>
