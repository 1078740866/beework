<template>
<div class="allHtml">
  <el-form :rules="rules" autocomplete="on" :model="loginForm" ref="loginForm" label-position="left">
    <div class="centerHtml">
      <div class="position_menu">
        <div class="position_menu_font">
          職位一覧
        </div>
      </div>
      <div class="position_select">
        <el-row :gutter="0" class="el-row1">
          <el-col :span="1">
            <div class="grid-content bg-a">職位名称:</div>
          </el-col>
          <el-col :span="2">
            <el-input v-model="input" placeholder=""></el-input>
          </el-col>
          <el-col :span="3">
            <div class="grid-content bg-b">職種:</div>
          </el-col>
          <el-col :span="4">
           <div class="block">
            <el-cascader
              placeholder="選択してください"
              v-model="value"
              :options="options"
              @change="handleChange"></el-cascader>
          </div>
          </el-col>
          <el-col :span="3">
            <div class="grid-content bg-b">状態:</div>
          </el-col>
          <el-col :span="2">
            <el-select class="el-select1" v-model="value1" placeholder="">
              <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="5">
            <el-button type="primary" icon="el-icon-search">搜索</el-button>
          </el-col>
        </el-row>
      </div>
      <div style="height:19px;background-color:#f6f6f6"></div>
      <div class="position_condition">
         <el-row :gutter="0" class="el-row2">
          <el-col :span="3">
            <div class="grid-content bg-e">合計:</div>
          </el-col>
          <el-col :span="6">
            <el-input class="el-input1" v-model="input" placeholder="30" :disabled="true"></el-input>
          </el-col>
          <el-col :span="7">
            <div class="grid-content bg-c">件</div>
          </el-col>
          <el-col :span="8">
            <div class="grid-content borderLine"></div>
          </el-col>
          <el-col :span="9">
            <div class="grid-content bg-d">並び方</div>
          </el-col>
          <el-col :span="4">
            <el-select class="el-select2" v-model="value2" placeholder="">
              <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
              </el-option>
            </el-select>
          </el-col>
          <el-col :span="5">
            <el-button type="primary" icon="el-icon-search">新規</el-button>
          </el-col>
        </el-row>
      </div>
      <div class="position_table">
         <table>
          <tr class="tr1">
            <td rowspan="3" class="td1"><el-checkbox v-model="checked"></el-checkbox></td>
            <td class="td2">xxxxxx職位</td>
            <td class="td3">有効期限：2020-05-01</td>
            <td class="td4">オンライン</td>
            <td class="td5">最後ログイン日時：2020-05-05</td>
            <td class="td6">ddd</td>
          </tr>
          <tr class="tr2">
            <td>業種 職種</td>
            <td>学歴：大学</td>
            <td>未確認</td>
            <td></td>
            <td>dddddd</td>
          </tr>
          <tr class="tr3">
            <td>東京都 品川駅</td>
            <td>人数：5</td>
            <td></td>
            <td></td>
            <td>dddddd</td>
          </tr>
         </table>
      </div>
    </div>
  </el-form>

</div>

</template>

<script>
export default {
  
    data() {
      return {
        checked:false,
        input:'',
        input1:'',
        value: [],
        value1: [],
        value2: [],
        options: [{
          value: 'zhinan',
          label: '指南',
          children: [{
            value: 'shejiyuanze',
            label: '设计原则',
          }, {
            value: 'daohang',
            label: '导航',
          }]
        }, {
          value: 'zujian',
          label: '组件',
          children: [{
            value: 'basic',
            label: 'Basic',
          }, {
            value: 'form',
            label: 'Form',
          }, {
            value: 'data',
            label: 'Data',
          }, {
            value: 'notice',
            label: 'Notice',
          }, {
            value: 'navigation',
            label: 'Navigation',
          }, {
            value: 'others',
          }]
        }, {
          value: 'ziyuan',
          label: '资源',
          children: [{
            value: 'axure',
            label: 'Axure Components'
          }, {
            value: 'sketch',
            label: 'Sketch Templates'
          }, {
            value: 'jiaohu',
            label: '组件交互文档'
          }],
        }],
      }
    }
  };

</script>

<style scoped>
.allHtml{
   width: calc(100vw);
   height: calc(300vh);
   background-color: #f6f6f6;
}
.centerHtml {
  position: absolute;
  margin: 0 auto; 
  margin-top: 10px;
  margin-left: 10%;
  width: calc(80vw);
  background-size: cover;
  background-color: #ffffff;
}
.position_menu{
  height: 70px;
  border-top: 1px solid #dce5f4;
  border-bottom: 1px solid #f6f6f6;
}
.position_menu_font{
  margin-top: 25px;
  margin-left: 33px;
  color: #003f99;
  font-size: 20px;
  font-weight:bolder;
  background-color: #ffffff;
}
.position_condition{
  background-color:#ffffff;
  border-top:1px solid #dce5f4;
  border-bottom:1px solid #eeeeee;
}
  .el-col {
    border-radius: 4px;
  }
  .grid-content {
    display:flex;
    border-radius: 4px;
    min-height: 40px;
     font-size: 18px;
   align-items:center;
   color: #014099;
   text-align:center;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
  .el-col .el-input{
    width:150px;
  }
  .el-row1 {
  margin-top: 15px !important;
  margin-bottom:20px !important;
  margin-left: 105px !important;
  margin-right: 105px !important;
  padding-top:5px;
  }
  .el-row2 {
  margin-top: 20px !important;
  margin-bottom:20px !important;
  margin-left: 29px !important;
   color:#000000 !important; 
  }
  .bg-a{
 width:60px;
 min-height:30px;
 font-size:12px;
  }
  .bg-b{
 width:32px;
 min-height:30px;
 font-size:12px;
  }
  .bg-c{
 width:14px;
 min-height:30px;
  font-size:12px;
  color:#000000;
  }
  .bg-d{
 width:40px;
 min-height:30px;
  font-size:12px;
  color:#000000;
  }
  .bg-e{
 width:40px;
 min-height:30px;
  font-size:12px;
  color:#000000;
  }
  .el-col-1{
 width:71px;
  }
  .el-col-2{
    width:180px;
  }
  .el-col-3{
    width:43px;
  }
  .el-col-4{
    width:230px;
  }
  .el-col-5{
    width:120px;

  }
  .el-col-6{
    width:117px;
  }
  .el-col-7{
    width:44px;
  }
  .el-col-8{
    width:30px;
  }
  .el-col-9{
    width:59px;
  }
.el-icon-arrow-up{
  color:#000000;
  font-size:18px; 
}
.el-select1{
   width:120px;
}
.el-select2{
   width:150px;
}
.el-input1{
  width:105px !important;
  height:38px !important;
  color:#000000 !important;
}
.el-button{
  background-color:#409eff;
  border-color:#409eff;
  background-image: linear-gradient(to right, #33a1ff , #33c7ff);
  height:30px;
}
.borderLine{
  border-left:1px solid #eeeeee;
  height:60px;
  margin-top:-15px;
}
.td1{
  width:92px;
}
.tr1{
  height:32px;
}
.td1 .el-checkbox{
  margin-left:49px;
}
.td1 .el-checkbox .checkbox__inner{
  border-color:#409eff;
}
.el-checkbox__input.is-checked .el-checkbox__inner{
   border-color:#409eff;
}
::v-deep div > .el-input > input{
  height: 30px;
 font-size:12px;
}
::v-deep div > .el-row > div{
  height: 30px;
  margin:auto;
  line-height:30px;
}
::v-deep div > .el-col > .block{
  height: 30px;
 font-size:12px;
}
::v-deep div > .el-col > .block > .el-cascader{
  height: 30px;
 font-size:12px;
 line-height:30px;
}
::v-deep div > .el-col > .block > .el-cascader .el-input--suffix{
  width:200px;
  height: 30px;
 font-size:12px;
}
::v-deep div > .el-col > .block > .el-cascader > .el-input > span > span > i{
  line-height:30px;
}
::v-deep div > .el-col > .el-select > .el-input > span > span > i{
  line-height:30px;
}

</style>