<template>
  <span>
    <el-button type="text" @click="show">
      <em class="el-icon-document" />
    </el-button>
    <el-dialog title="詳細情報" :visible.sync="isShow" :append-to-body="true">
      <el-row v-for="columeNm in columeList" :key="columeNm">
        <el-col :span="12">
          {{ columeNm }}
        </el-col>
        <el-col :span="12" v-for="colData in rowData" :key="colData">
          {{ colData }}
        </el-col>
      </el-row>
    </el-dialog>
  </span>
</template>
<script>
export default {
  data() {
    return {
      isShow: false,
      dataList: [],
    };
  },
  props: {
    rowData: Array,
    columeList: Array,
  },
  methods: {
    show() {
      this.isShow = true;
      if (this.columeList.length == this.rowData.length) {
        this.dataList = [];
        for (var i = 0; i < this.rowData.length; i++) {
          var infoData = this.columeList[i] + ": " + this.rowData[i];
          this.dataList.push(infoData);
        }
      }
    },
  },
};
</script>
