<template>
  <el-card class="card-style">
    <el-collapse
      v-model="collapseIsActive"
      name="qualificationCertificate"
      value="qualificationCertificate"
      @change="collapseChange"
    >
      <el-collapse-item name="qualificationCertificate" :title="name">
        <el-row>
          <el-col :span="24">
            <el-table
              ref="applicantQuaTblBean"
              :data="applicantQuaTblBean"
              @row-dblclick="rowDoubleClick"
              :default-sort="{ prop: 'acquisitionDate', order: 'descending' }"
              row-key="appQuaId"
              max-height="350"
              :empty-text="promptMessage.noTableData"
              highlight-current-row
              stripe
            >
              <el-table-column type="index" />
              <el-table-column type="expand">
                <template slot-scope="props">
                  <el-form :model="props" label-position="top">
                    <el-row>
                      <el-col :span="12">
                        <el-form-item :label="labelName.quaPhoto">
                          <pdf
                            :src="props.row.photoPic"
                            class="image-style"
                            v-if="rowPhotoIsPDF(props.row.quaAddress)"
                          />
                          <el-image
                            :src="props.row.photoPic"
                            fit="contain"
                            class="image-style"
                            v-else
                          >
                            <div slot="error" class="image-slot">
                              <em class="el-icon-postcard" />
                            </div>
                          </el-image>
                        </el-form-item>
                      </el-col>
                      <el-col :span="12">
                        <el-form-item :label="labelName.remarks">
                          <p>{{ props.row.remarks }}</p>
                        </el-form-item>
                      </el-col>
                    </el-row>
                  </el-form>
                </template>
              </el-table-column>
              <el-table-column prop="quaNm" :label="labelName.quaNm" />
              <el-table-column prop="quaNum" :label="labelName.quaNum" sortable />
              <el-table-column
                prop="acquisitionDate"
                :label="labelName.acquisitionDate"
                sortable
              />
            </el-table>
          </el-col>
        </el-row>
      </el-collapse-item>
    </el-collapse>
  </el-card>
</template>
<script>
export default {
  name: "c010102",
  props: {
    applicantQuaTblBean: {},
  },
  data() {
    return {
      // collapseタイトル
      name: "資格·検定",
      // collapse初期不展開
      collapseIsActive: "",
      // テーブルラベル
      labelName: {
        quaNm: "資格名",
        quaNum: "資格番号",
        quaPhoto: "資格画像",
        acquisitionDate: "取得日",
        remarks: "備考",
        quaAdd: "資格新規",
        quaEdit: "資格編集",
      },
      promptMessage: {
        noTableData: "資格を取得していません",
      },
    };
  },
  methods: {
    // テーブル行目ダブルクリック
    rowDoubleClick(row) {
      let $applicantQuaTblBean = this.$refs.applicantQuaTblBean;
      this.applicantQuaTblBean.map((item) => {
        // 単一の行目展開
        if (row.appQuaId != item.appQuaId) {
          $applicantQuaTblBean.toggleRowExpansion(item, false);
        }
      });
      $applicantQuaTblBean.toggleRowExpansion(row);
    },
    // テーブル内の写真タイプ判断
    rowPhotoIsPDF(file) {
      var fileType = "";
      if (file.split(".")[1]) fileType = file.split(".")[file.split(".").length - 1];
      return fileType == "pdf" ? true : false;
    },
    // collapse展開状態
    collapseChange(val) {
      if (val.length == 1) {
        // 展開した行目クローズ
        this.tableRowClose();
      }
    },
    // 展開した行目クローズ
    tableRowClose() {
      this.applicantQuaTblBean.map((item) => {
        this.$refs.applicantQuaTblBean.toggleRowExpansion(item, false);
      });
    },
  },
};
</script>
<style lang="scss" scoped>
// カードのマージン
.card-style {
  margin: 2vh 10%;
}
// collapseのタイトル
::v-deep .el-collapse-item__header {
  font-size: 28px;
  color: #409eff;
}
// coolapseボルダ
::v-deep .el-collapse-item__header,
::v-deep .el-collapse-item__wrap {
  border-bottom: none;
}
// テーブル内ボタン
::v-deep .el-table .cell {
  padding: 0;
}
// ラベルの青字
::v-deep div > .el-form-item__label {
  font-size: 16px;
  color: #014099;
  font-style: normal;
  font-weight: bold;
}
// テーブル数字
::v-deep td.el-table_1_column_1 {
  text-align: center;
}
// collapse本体
.el-collapse {
  border: none;
}
// 空いているのel-rowプレースホルダー
.el-col {
  min-height: 1px;
}
// テーブルボタンの下の黒い線を削除
.el-table__fixed-right::before {
  height: 0;
}
// 画像サイズ
.image-style {
  max-width: 150px;
  max-height: 150px;
}
</style>
