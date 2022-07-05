<template>
  <el-card class="register-form-layout">
    <el-form
      :rules="rules"
      autocomplete="on"
      :model="registerForm"
      ref="registerForm"
      label-position="right"
    >
      <div class="title">
        <div class="loginLogo" @click="toHomepage">
            <el-image :src="require('@/assets/b_home_logo2.png')" class="loginImgLogo"/>
        </div>
        <div class="title-required font-blue-22">会社新規(登録)</div>
        <div class="tips-required font-red-16">※は入力必須項目です</div>
      </div>
      <hr />
      <div class="headT">会社情報</div>
      <div class="formcontent">
        <el-form-item label-width="195px" label="会社名:" prop="companyNm">
          <el-input
            class="inputwidth"
            v-model="registerForm.companyNm"
            placeholder=""
            autocomplete="off"
            v-bind:disabled="registerForm.popFlg != ''"
          >
          </el-input>
          <el-button
            v-if="buttonViewNum"
            class="button1"
            type="primary"
            icon="el-icon-search"
            @click="initPop()"
            circle
          />
          <el-button
            v-else
            type="primary"
            icon="el-icon-delete"
            @click="cleanAll()"
            class="button1"
            circle
          />
        </el-form-item>
        <el-form-item label-width="195px" label="電話番号:" prop="companyTel">
          <el-input
            class="inputwidth"
            v-model="registerForm.companyTel"
            placeholder=""
            autocomplete="off"
            v-bind:disabled="registerForm.popFlg != ''"
          >
          </el-input>
        </el-form-item>
        <el-form-item
          label-width="195px"
          label="メールアドレス:"
          prop="companyMail"
        >
          <el-input
            class="inputwidth"
            v-model="registerForm.companyMail"
            placeholder=""
            autocomplete="off"
            v-bind:disabled="registerForm.popFlg != ''"
          >
          </el-input>
        </el-form-item>
        <el-form-item label-width="195px" label="会社規模:" prop="companyScale">
          <el-select
            class="inputwidth"
            v-model="registerForm.companyScale"
            placeholder="選択してください"
            @change="setCompanyScaleNm"
            v-bind:disabled="registerForm.popFlg != ''"
          >
            <el-option
              v-for="item in companyScales"
              :key="item.companyScale"
              :label="item.companyScaleNm"
              :value="item.companyScale"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label-width="195px" label="国:" prop="countryId">
          <el-select
            class="inputwidth"
            v-model="registerForm.countryId"
            placeholder="選択してください"
            @change="setCountryNm"
            v-bind:disabled="registerForm.popFlg != ''"
          >
            <el-option
              v-for="item in countrys"
              :key="item.countryId"
              :label="item.countryNm"
              :value="item.countryId"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item
          label-width="195px"
          label="郵便番号:"
          prop="companyPostal3keta"
        >
          <el-input
            class="postal1"
            minlength="3"
            maxlength="3"
            v-model="registerForm.companyPostal3keta"
            placeholder=""
            autocomplete="off"
            v-bind:disabled="registerForm.popFlg != ''"
          >
          </el-input>
        </el-form-item>
        <span> -</span>
        <el-form-item prop="companyPostal4keta">
          <el-input
            class="postal2"
            minlength="4"
            maxlength="4"
            v-model="registerForm.companyPostal4keta"
            placeholder=""
            autocomplete="off"
            v-bind:disabled="registerForm.popFlg != ''"
          >
          </el-input>
        </el-form-item>
        <el-form-item>
          <searchPostal
            class="button-position4"
            @parentMethod="postalInit"
            :postal1="registerForm.companyPostal3keta"
            :postal2="registerForm.companyPostal4keta"
            v-bind:disabled="registerForm.popFlg != ''"
          />
        </el-form-item>
        <el-form-item label-width="195px" label="会社所在地:" prop="address1">
          <el-input
            class="inputwidth"
            v-model="registerForm.address1"
            placeholder="住所検索画面より自動入力されます(編集できません)。"
            autocomplete="off"
            disabled="true"
          >
          </el-input>
          <el-button
            class="button1"
            type="primary"
            icon="el-icon-delete"
            @click="clearAddress"
            v-bind:disabled="registerForm.popFlg != ''"
            circle
          />
        </el-form-item>
        <el-form-item label-width="195px" style="" prop="address2">
          <el-input
            class="inputwidth"
            v-model="registerForm.address2"
            placeholder=""
            autocomplete="off"
            v-bind:disabled="registerForm.popFlg != ''"
          >
          </el-input>
        </el-form-item>
        <el-form-item label-width="195px" label="業種1:" prop="industryId1">
          <el-select
            v-model="registerForm.industryId1"
            placeholder="選択してください"
            @change="setIndustryId1Nm"
            v-bind:disabled="registerForm.popFlg != ''"
          >
            <el-option
              v-for="item in industryIds"
              :key="item.industryId"
              :label="item.industryNm"
              :value="item.industryId"
            >
            </el-option>
          </el-select>
          <el-button
            ref="buttonUp"
            type="primary"
            class="button1"
            icon="el-icon-plus"
            @click="addIndusutry"
            :disabled="IndusutryShow == 2"
            circle
          />
        </el-form-item>
        <el-form-item
          label-width="195px"
          label="業種2:"
          v-show="IndusutryShow > 0"
          prop="industryId2"
        >
          <el-select
            v-model="registerForm.industryId2"
            placeholder="選択してください"
            @change="setIndustryId2Nm"
            v-bind:disabled="registerForm.popFlg != ''"
          >
            <el-option
              v-for="item in industryIds"
              :key="item.industryId"
              :label="item.industryNm"
              :value="item.industryId"
            >
            </el-option>
          </el-select>
          <el-button
            type="primary"
            ref="buttonDown"
            class="button1"
            icon="el-icon-minus"
            @click="minusIndusutry"
            :disabled="IndusutryShow == 0"
            circle
          />
        </el-form-item>
        <el-form-item
          label-width="195px"
          label="業種3:"
          v-show="IndusutryShow > 1"
          prop="industryId3"
        >
          <el-select
            v-model="registerForm.industryId3"
            placeholder="選択してください"
            @change="setIndustryId3Nm"
            v-bind:disabled="registerForm.popFlg != ''"
          >
            <el-option
              v-for="item in industryIds"
              :key="item.industryId"
              :label="item.industryNm"
              :value="item.industryId"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label-width="195px" label="資本金:" prop="capital">
          <el-input
            class="inputwidth"
            v-model="registerForm.capital"
            placeholder=""
            autocomplete="off"
            maxlength="12"
            @blur="toThousandFilter($event)"
            @focus="toNumerFilter($event)"
            v-bind:disabled="registerForm.popFlg != ''"
          >
          </el-input>
        </el-form-item>
        <el-form-item
          label-width="195px"
          label="事業内容:"
          prop="businessContent"
        >
          <el-input
            type="textarea"
            placeholder=""
            :autosize="{ minRows: 1, maxRows: 5 }"
            v-model="registerForm.businessContent"
            maxlength="490"
            v-bind:disabled="registerForm.popFlg != ''"
          >
          </el-input>
        </el-form-item>
        <el-form-item label-width="195px" label="売上:" prop="salesAmount">
          <el-input
            class="inputwidth"
            v-model="registerForm.salesAmount"
            placeholder=""
            autocomplete="off"
            maxlength="14"
            @blur="toThousandFilter($event)"
            @focus="toNumerFilter($event)"
            v-bind:disabled="registerForm.popFlg != ''"
          >
          </el-input>
        </el-form-item>
        <el-form-item label-width="195px" label="ホームページ:" prop="homepage">
          <el-input
            class="inputwidth"
            v-model="registerForm.homepage"
            placeholder=""
            autocomplete="off"
            v-bind:disabled="registerForm.popFlg != ''"
          >
          </el-input>
        </el-form-item>
        <el-form-item
          label-width="195px"
          label="謄本画像:"
          prop="licenseAddress"
        >
          <el-upload
            class="avatar-uploader"
            :action="uploadUrl()"
            :on-error="uploadFail"
            :show-file-list="false"
            :on-success="handleAvatarSuccesslicense"
            :before-upload="beforeUpload"
            v-bind:disabled="registerForm.popFlg != ''"
          >
            <img
              v-if="registerForm.licenseAddress"
              :src="licenseAddressPic"
              class="avatar"
              v-bind:disabled="registerForm.popFlg != ''"
            />
            <em v-else class="el-icon-plus avatar-uploader-icon" alt></em>
          </el-upload>
        </el-form-item>
        <el-form-item label-width="195px" label="会社LOGO:" prop="companyLogo">
          <el-upload
            class="avatar-uploader"
            action="https://www.mocky.io/v2/5185415ba171ea3a00704eed/posts/"
            :on-error="uploadFail"
            :show-file-list="false"
            :on-success="handleAvatarSuccesslogo"
            accept="image/jpeg,image/jpg,image/png,image/svg"
            :before-upload="beforeUpload"
            v-bind:disabled="registerForm.popFlg != ''"
          >
            <img
              v-if="registerForm.companyLogo"
              :src="registerForm.companyLogo"
              class="avatar"
              v-bind:disabled="registerForm.popFlg != ''"
            />
            <em v-else class="el-icon-plus avatar-uploader-icon"></em>
          </el-upload>
        </el-form-item>
        <el-form-item
          label-width="195px"
          label="会社画像1:"
          prop="photoAddress1"
        >
          <el-upload
            class="avatar-uploader"
            action="https://www.mocky.io/v2/5185415ba171ea3a00704eed/posts/"
            :on-error="uploadFail"
            :show-file-list="false"
            :on-success="handleAvatarSuccesscompany"
            accept="image/jpeg,image/jpg,image/png,image/svg"
            :before-upload="beforeUpload"
            v-bind:disabled="registerForm.popFlg != ''"
          >
            <img
              v-if="registerForm.photoAddress1"
              :src="registerForm.photoAddress1"
              class="avatar"
              v-bind:disabled="registerForm.popFlg != ''"
            />
            <em v-else class="el-icon-plus avatar-uploader-icon"></em>
          </el-upload>
          <el-button
            type="primary"
            ref="buttonUp1"
            icon="el-icon-plus"
            @click="photoAddress++"
            v-show="photoAddress < 2"
            class="button-position5"
            v-bind:disabled="registerForm.popFlg != ''"
            circle
          />
          <el-button
              type="primary"
              ref="buttonDown1"
              icon="el-icon-minus"
              @click="photoAddress--"
              class="button-position6"
              v-bind:disabled="registerForm.popFlg != ''"
              v-show="photoAddress > 0"
              circle
          />
        </el-form-item>
        <el-form-item
          label-width="195px"
          v-show="photoAddress > 0"
          label="会社画像2:"
        >
          <el-upload
            class="avatar-uploader"
            action="https://www.mocky.io/v2/5185415ba171ea3a00704eed/posts/"
            :on-error="uploadFail"
            :show-file-list="false"
            :on-success="handleAvatarSuccesscompany2"
            accept="image/jpeg,image/jpg,image/png,image/svg"
            :before-upload="beforeUpload"
            v-bind:disabled="registerForm.popFlg != ''"
          >
            <img
              v-if="registerForm.photoAddress2"
              :src="registerForm.photoAddress2"
              class="avatar"
              v-bind:disabled="registerForm.popFlg != ''"
            />
            <em v-else class="el-icon-plus avatar-uploader-icon"></em>
          </el-upload>
        </el-form-item>
        <el-form-item
          label-width="195px"
          label="会社画像3:"
          v-show="photoAddress > 1"
        >
          <el-upload
            class="avatar-uploader"
            action="https://www.mocky.io/v2/5185415ba171ea3a00704eed/posts/"
            :on-error="uploadFail"
            :show-file-list="false"
            :on-success="handleAvatarSuccesscompany3"
            accept="image/jpeg,image/jpg,image/png,image/svg"
            :before-upload="beforeUpload"
            v-bind:disabled="registerForm.popFlg != ''"
          >
            <img
              v-if="registerForm.photoAddress3"
              :src="registerForm.photoAddress3"
              class="avatar"
              v-bind:disabled="registerForm.popFlg != ''"
            />
            <em v-else class="el-icon-plus avatar-uploader-icon"></em>
          </el-upload>
        </el-form-item>
        <el-form-item label-width="195px" label="会社ビデオ1:" prop="">
          <el-upload
            class="upload-demo"
            action="https://www.mocky.io/v2/5185415ba171ea3a00704eed/posts/"
            :on-error="uploadFail"
            :on-success="handleAvatarSuccessvideo"
            accept=".mp4,.ogg,.flv,.avi,.wmv,.rmvb"
            :before-upload="beforeUploadVideo"
            :limit="1"
            v-bind:disabled="registerForm.popFlg != ''"
          >
            <el-button
              size="small"
              type="primary"
              class="viderButton"
              v-bind:disabled="registerForm.popFlg != ''"
              >アップロード</el-button
            >
          </el-upload>
          <el-button
            type="primary"
            icon="el-icon-plus"
            ref="buttonUp2"
            @click="vedioAddress++"
            v-show="vedioAddress < 2"
            class="button-position5"
            v-bind:disabled="registerForm.popFlg != ''"
            circle
          />
          <el-button
            type="primary"
            ref="buttonDown2"
            icon="el-icon-minus"
            @click="vedioAddress--"
            class="button-position6"
            v-bind:disabled="registerForm.popFlg != ''"
            v-show="vedioAddress > 0"
            circle
          />
        </el-form-item>
        <el-form-item
          label-width="195px"
          label="会社ビデオ2:"
          v-show="vedioAddress > 0"
        >
          <el-upload
            class="upload-demo"
            action="https://www.mocky.io/v2/5185415ba171ea3a00704eed/posts/"
            :on-error="uploadFail"
            :on-success="handleAvatarSuccessvideo"
            :before-upload="beforeUploadVideo"
            :limit="1"
            accept=".mp4,.ogg,.flv,.avi,.wmv,.rmvb"
            v-bind:disabled="registerForm.popFlg != ''"
          >
            <el-button
              size="small"
              type="primary"
              class="viderButton"
              v-bind:disabled="registerForm.popFlg != ''"
              >アップロード</el-button
            >
          </el-upload>
        </el-form-item>
        <el-form-item
          label-width="195px"
          label="会社ビデオ3:"
          v-show="vedioAddress > 1"
        >
          <el-upload
            class="upload-demo"
            action="https://www.mocky.io/v2/5185415ba171ea3a00704eed/posts/"
            :on-success="handleAvatarSuccessvideo"
            :before-upload="beforeUploadVideo"
            :limit="1"
            accept=".mp4,.ogg,.flv,.avi,.wmv,.rmvb"
            v-bind:disabled="registerForm.popFlg != ''"
          >
            <el-button
              size="small"
              type="primary"
              class="viderButton"
              v-bind:disabled="registerForm.popFlg != ''"
              >アップロード</el-button
            >
          </el-upload>
        </el-form-item>
      </div>
      <hr />
      <div class="headT">ユーザー情報</div>
      <div class="formcontent">
        <el-form-item
          label-width="203px"
          label="メールアドレス:"
          prop="userMail"
        >
          <el-input
            class="inputwidth"
            v-model="registerForm.userMail"
            placeholder=""
            autocomplete="off"
          >
          </el-input>
        </el-form-item>
        <el-form-item label-width="203px" label="パスワード:" prop="password">
          <el-input
            class="inputwidth"
            type="password"
            v-model="registerForm.password"
            placeholder=""
            autocomplete="off"
          >
          </el-input>
        </el-form-item>
        <el-form-item
          label-width="203px"
          label="パスワード確認:"
          prop="repassword"
        >
          <el-input
            class="inputwidth"
            type="password"
            v-model="registerForm.repassword"
            placeholder=""
            autocomplete="off"
          >
          </el-input>
        </el-form-item>
        <el-form-item label-width="203px" label="姓:" prop="firstName">
          <el-input
            class="inputwidth"
            v-model="registerForm.firstName"
            placeholder=""
            autocomplete="off"
          >
          </el-input>
        </el-form-item>
        <el-form-item
          label-width="203px"
          label="姓（カナ）:"
          prop="firstNameKana"
        >
          <el-input
            class="inputwidth"
            v-model="registerForm.firstNameKana"
            placeholder=""
            autocomplete="off"
          >
          </el-input>
        </el-form-item>
        <el-form-item label-width="203px" label="名:" prop="lastName">
          <el-input
            class="inputwidth"
            v-model="registerForm.lastName"
            placeholder=""
            autocomplete="off"
          >
          </el-input>
        </el-form-item>
        <el-form-item
          label-width="203px"
          label="名（カナ）:"
          prop="lastNameKana"
        >
          <el-input
            class="inputwidth"
            v-model="registerForm.lastNameKana"
            placeholder=""
            autocomplete="off"
          >
          </el-input>
        </el-form-item>
        <el-form-item label-width="203px" label="性別:">
          <el-radio v-model="registerForm.sex" label="0">男性</el-radio>
          <el-radio v-model="registerForm.sex" label="1">女性</el-radio>
        </el-form-item>
        <el-form-item
          label-width="203px"
          label="電話番号:"
          @blur="remberTel($event)"
        >
          <el-select size="small" v-model="registerForm.countryZip" class="select1">
            <el-option
              v-for="item in telCode"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item class="input-small-position2" prop="userTel">
          <el-input
            v-model="registerForm.userTel"
            placeholder=""
            autocomplete="off"
            class="photoInput"
          >
          </el-input>
        </el-form-item>
        <el-form-item label-width="203px" label="写真:" prop="photoAddress">
          <el-upload
            style="margin-top: 12px"
            class="avatar-uploader"
            action="https://www.mocky.io/v2/5185415ba171ea3a00704eed/posts/"
            :show-file-list="false"
            :on-success="handleAvatarSuccessphoto"
            :on-error="uploadFail"
            :before-upload="beforeUpload"
          >
            <img
              v-if="registerForm.photoAddress"
              :src="registerForm.photoAddress"
              class="avatar"
            />
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>
        <el-row>
          <el-col :span="12">
            <el-form-item>
              <el-button
                class="button-confirm"
                type="primary"
                @click="handelregister()"
                >確認画面へ</el-button
              >
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item>
              <el-button class="button-back" @click="routerBack()"
                >戻る</el-button
              >
            </el-form-item>
          </el-col>
        </el-row>
      </div>
      <modal
        :show="show"
        :title="title"
        @hideModal="hideModal"
        @submit="submit"
      >
        <el-form
          :rules="rulesPop"
          autocomplete="on"
          :model="companySearchForm"
          ref="companySearchForm"
          label-position="right"
          :inline="true"
        >
          <div class="formcontent-popup">
            <el-form-item label="国:" prop="country" class="popForm">
              <el-select v-model="companySearchForm.country">
                <el-option
                  v-for="item in countrys"
                  :key="item.countryId"
                  :label="item.countryNm"
                  :value="item.countryId"
                >
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="都道府県:" prop="address1" class="popForm">
              <el-select
                v-model="companySearchForm.address1"
                placeholder="選択してください"
              >
                <el-option
                  v-for="item in todohuken"
                  :key="item.prefeId"
                  :label="item.prefeNm"
                  :value="item.prefeId"
                >
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="業種:" prop="industryId1" class="popForm">
              <el-select
                v-model="companySearchForm.industryId1"
                placeholder="選択してください"
              >
                <el-option
                  v-for="item in industryIds"
                  :key="item.industryId"
                  :label="item.industryNm"
                  :value="item.industryId"
                >
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="規模:" prop="companyScale" class="popForm">
              <el-select
                v-model="companySearchForm.companyScale"
                placeholder="選択してください"
              >
                <el-option
                  v-for="item in companyScales"
                  :key="item.companyScale"
                  :label="item.companyScaleNm"
                  :value="item.companyScale"
                >
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="会社名:" prop="companyNm">
              <el-input
                v-model="companySearchForm.companyNm"
                placeholder=""
                autocomplete="off"
                class="popFormInput"
              >
              </el-input>
            </el-form-item>
            <el-button
              @click="searchPop()"
              type="primary"
              class="button-select-pop"
              icon="el-icon-search"
              >検索</el-button
            >
            <el-button @click="hideModal()" type="info" class="button-back-pop"
              >戻る</el-button
            >
          </div>
        </el-form>
        <div class="formcontent-popup-content">
          <span class="persion2">検索結果</span>
          <hr style="background-color: #f6f6f6; opacity: 0.4" />
          <el-table
            :data="tableData"
            style="width: 100%"
            :show-header="true"
            @row-click="rowClick"
            max-height="380px"
          >
            :row-class-name="tableRowClassName">
            <el-table-column
              prop="companyLogo"
              label="アイコン"
              style="width: 15%"
            >
            </el-table-column>
            <el-table-column prop="companyId" label="会社Id" v-if="false" fixed>
            </el-table-column>
            <el-table-column
              prop="companyNm"
              label="会社名"
              style="width: 15%"
              fixed
            >
            </el-table-column>
            <el-table-column prop="industryNm1" style="width: 10%" label="業種">
            </el-table-column>
            <el-table-column prop="countryNm" style="width: 10%" label="国籍">
            </el-table-column>
            <el-table-column
              prop="address"
              style="width: 15%"
              label="会社所在地"
            >
            </el-table-column>
            <el-table-column
              prop="companyTel"
              style="width: 10%"
              label="連絡先"
            >
            </el-table-column>
            <el-table-column
              prop="companyScaleNm"
              label="規模"
              style="width: 10%"
            >
            </el-table-column>
            <el-table-column
              prop=""
              label="操作"
              style="width: 15%"
              fixed="right"
            >
              <template slot-scope="scope">
                <el-button
                  @click="rowClick(scope.row)"
                  type="text"
                  size="small"
                  >設定</el-button
                >
              </template>
            </el-table-column>
            <el-table-column prop="companyMail" v-if="false"></el-table-column>
            <el-table-column
              prop="companyPostal"
              v-if="false"
            ></el-table-column>
            <el-table-column prop="capital" v-if="false"></el-table-column>
            <el-table-column
              prop="businessContent"
              v-if="false"
            ></el-table-column>
            <el-table-column prop="salesAmount" v-if="false"></el-table-column>
            <el-table-column prop="homepage" v-if="false"></el-table-column>
            <el-table-column
              prop="licenseAddress"
              v-if="false"
            ></el-table-column>
            <el-table-column prop="companyLogo" v-if="false"></el-table-column>
            <el-table-column
              prop="photoAddress1"
              v-if="false"
            ></el-table-column>
            <el-table-column
              prop="photoAddress2"
              v-if="false"
            ></el-table-column>
            <el-table-column
              prop="photoAddress3"
              v-if="false"
            ></el-table-column>
            <el-table-column
              prop="videoAddress1"
              v-if="false"
            ></el-table-column>
            <el-table-column
              prop="videoAddress2"
              v-if="false"
            ></el-table-column>
            <el-table-column
              prop="videoAddress3"
              v-if="false"
            ></el-table-column>
            <el-table-column prop="industryId1" v-if="false"></el-table-column>
            <el-table-column prop="industryId2" v-if="false"></el-table-column>
            <el-table-column prop="industryId3" v-if="false"></el-table-column>
            <el-table-column
              prop="industryNm1"
              v-if="false"
            ></el-table-column>
            <el-table-column
              prop="industryNm2"
              v-if="false"
            ></el-table-column>
            <el-table-column
              prop="industryNm3"
              v-if="false"
            ></el-table-column>
            <el-table-column prop="countryId" v-if="false"></el-table-column>
          </el-table>
          <!-- <el-pagination
            style="text-align: center"
            :total="total"
            :page-size="params.size"
            :current-page="params.page"
            layout="prev, pager, next"
            background
          >
          </el-pagination> -->
          <el-pagination
              :total="pagination.total"
              :current-page="pagination.currentPage"
              :pager-count="pagination.pagerCount"
              :page-sizes="pagination.pageSizes"
              :page-size="pagination.pageSize"
              :background="true"
              :layout="pagination.layout"
              @size-change="sizeChange"
              @current-change="currentChange"
            />
        </div>
      </modal>
    </el-form>
  </el-card>
</template>

<script>
import modal from "../modal.vue";
import searchPostal from "@/views/spComponents/SearchPostal";
import "@/css/reset.css";
import "@/css/border.css";
//移动端 解决点击按钮闪和active失效的问题
document.body.addEventListener("touchstart", function () {});
export default {
  name: "register",
  data() {
    let checkUserMail = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("メールアドレスを入力してください。"));
      } else {
        let reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (!reg.test(value)) {
          callback(
            new Error(
              "メールアドレスが間違っています。正しく入力してください。"
            )
          );
        } else {
          callback();
        }
      }
    };
    let checkPassword = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("パスワードを入力してください。"));
      } else {
        let reg = /^.{8,16}$/;
        if (!reg.test(value)) {
          callback(
            new Error("８～１６文字の英数字・記号を半角で入力してください")
          );
        } else {
          let reg = /^(?=.*[a-zA-Z])(?=.*[0-9]).*$/;
          if (!reg.test(value)) {
            callback(
              new Error("英字と数字をそれぞれ１文字以上使用してください")
            );
          } else {
            let reg = /^[a-zA-Z0-9#$&+-=.:?@/_^`|()]{8,16}$/;
            if (!reg.test(value)) {
              callback(
                new Error(
                  "記号は # $ & + - = . : ? @ / _ ^ ` | ( )だけが使用できます"
                )
              );
            } else {
              callback();
            }
            callback();
          }
          callback();
        }
      }
    };
    let checkRepassword = (rule, value, callback) => {
      if (value === this.registerForm.password) {
        callback();
      } else {
        callback(new Error("パスワードと確認パスワードが異なる"));
      }
    };
    let checkTel = (rule, value, callback) => {
      let reg = /^[0-9]{6,13}$/;
      if (!reg.test(value)) {
        callback(new Error("電話番号は６～１３半角数字で入力してください。"));
      }
    };

    return {
      title: "",
      show: false,
      zip: null,
      pref_id: null,
      locality: null,
      street: null,
      buttonViewNum:true,
      loading: false,
      IndusutryShow: 0,
      licenseAddressPic:"",
      registerForm: {
        userMail: "",
        password: "",
        repassword: "",
        companyId: "",
        companyNm: "",
        companyTel: "",
        companyMail: "",
        companyScale: "",
        companyScaleNm: "",
        countryId: "",
        countryNm: "",
        companyPostal3keta: "",
        companyPostal4keta: "",
        companyPostal: "",
        address1: "",
        address2: "",
        industryId1: "",
        industryId2: "",
        industryId3: "",
        industryId1Nm: "",
        industryId2Nm: "",
        industryId3Nm: "",
        capital: "",
        businessContent: "",
        salesAmount: "",
        homepage: "",
        licenseAddress: "",
        companyLogo: "",
        photoAddress1: "",
        photoAddress2: "",
        photoAddress3: "",
        videoAddressList: "",
        firstName: "",
        firstNameKana: "",
        lastName: "",
        lastNameKana: "",
        sex: "0",
        countryZip: "81",
        userTel: "",
        photoAddress: "",
        popFlg: "",
      },
      companySearchForm: {
        companyNm: "",
        country: "",
        address1: "",
        industryId1: "",
        companyScale: "",
      },
      rules: {
        userMail: [
          { required: true, message: "メールを入力してください。" },
          { validator: checkUserMail, trigger: "blur" },
        ],
        companyMail: [
          { required: true, message: "メールを入力してください。" },
          { validator: checkUserMail, trigger: "blur" },
        ],
        password: [
          { required: true, message: "パスワードを入力してください。" },
          { validator: checkPassword, trigger: "blur" },
        ],
        repassword: [
          { required: true, message: "パスワードを再入力してください。" },
          { validator: checkRepassword, trigger: "blur" },
        ],
        companyNm: [{ required: true, message: "会社名を入力してください。" }],
        countryZip: [
          { required: true, message: "電話番号国番号を入力してください。" },
        ],
        companyTel: [
          { required: true, message: "電話番号を入力してください。" },
          {
            pattern: /^[0-9]*$/,
            message: "電話番号は半角数字で入力してください。",
            trigger: "blur",
          },
        ],
        companyScale: [
          { required: true, message: "会社規模を選択してください。" },
        ],
        countryId: [{ required: true, message: "国を選択してください。" }],
        companyPostal3keta: [
          { required: true, message: "郵便番号を入力してください。" },
          {
            pattern: /^[0-9]*$/,
            message: "郵便番号は半角数字で入力してください。",
            trigger: "blur",
          },
        ],
        companyPostal4keta: [
          { required: true, message: "郵便番号を入力してください。" },
          {
            pattern: /^[0-9]*$/,
            message: "郵便番号は半角数字で入力してください。",
            trigger: "blur",
          },
        ],
        // address1:[{ required: true, message: '都道府県を入力してください。'}],
        // address2:[{ required: true, message: '市区町村を入力してください。'}],
        address2: [{ required: true, message: "所在地を入力してください。" }],
        capital: [
          { required: true, message: "資本金を入力してください。" },
          {
            pattern: /^[0-9]*$/,
            message: "資本金は半角数字で入力してて下さい。",
            trigger: "blur",
          },
        ],
        industryId1: [{ required: true, message: "業種を入力してください。" }],
        businessContent: [
          { required: true, message: "事業内容を入力してください。" },
        ],
        licenseAddress: [
          { required: true, message: "謄本画像を入力してください。" },
        ],
        salesAmount: [
          {
            pattern: /^[0-9]*$/,
            message: "売上は半角数字で入力してください。",
            trigger: "blur",
          },
        ],
        firstName: [{ required: true, message: "姓を入力してください。" }],
        firstNameKana: [
          { required: true, message: "姓(カナ)を入力してください。" },
        ],
        lastName: [{ required: true, message: "名を入力してください。" }],
        lastNameKana: [
          { required: true, message: "名（カナ）を入力してください。" },
        ],
        userTel: [
          { required: true, message: "電話番号を入力してください。" },
          { validator: checkTel, trigger: "blur" },
        ],
      },
      rulesPop: {
        country: [{ required: false, message: "国をを選択してください。" }],
        address1: [
          { required: false, message: "都道府県を入力してください。" },
        ],
        industryId1: [{ required: true, message: "業種を入力してください。" }],
      },
      radio: "1",
      industryId: 0,
      photoAddress: 0,
      vedioAddress: 0,
      countrys: this.$route.query.data.countryList,
      todohuken: this.$route.query.data.prefecturesList,
      telCode: [
        {
          value: "81",
          label: "81(日本)",
        },
        {
          value: "86",
          label: "86(中国)",
        },
      ],
      industryIds: this.$route.query.data.industryList,
      companyScales: this.$route.query.data.companyScaleList,
      value: "",
      checked: true,
      // total: Number,
      // ページネーション
      pagination: {
        // データ数
        total: 0,
        // table page from
        currentPage: 1,
        // データ数per page
        pageSizes: [10, 30, 50],
        // default データ数per page
        pageSize: 10,
        // 展示ページボタン数
        pagerCount: 5,
        // 順序
        layout: "total, sizes, prev, pager, next, jumper",
        // 当ページの最初の行
        dataStart: 0,
        //当ページの最後の行
        dataEnd: 10,
      },
      tableData: [],
    };
  },
  filters: {
    num: (val) => {
      //每个三位价格逗号
      val = val
        .split("")
        .reverse()
        .join(""); // 翻转整数
      var temp = ""; // 临时变量
      for (var i = 0; i < val.length; i++) {
        temp += val[i];
        if ((i + 1) % 3 == 0 && i != val.length - 1) {
          temp += ","; // 每隔三个数字拼接一个逗号
        }
      }
      temp = temp
        .split("")
        .reverse()
        .join(""); // 加完逗号之后翻转
      return temp; // 返回
    },
  },
  watch: {
    // zip(newVal) {
    //   alert("ff");
    //   if (newVal.length >= 7) {
    //     // eslint-disable-next-line no-undef
    //     new YubinBangoCore(newVal, (addr) => {
    //       this.pref_id = addr.region; // 都道府県
    //       this.locality += addr.locality; // 市区町村
    //       this.street += addr.street; // 町域
    //       alert(this.pref_id);
    //     });
    //   }
    // },
  },
  components: {
    modal,
    searchPostal,
  },
  mounted() {
    document.title = "会社新規(登録)";
    this.initList();
  },
  methods: {
    // 職種増加
    addIndusutry() {
      if (this.IndusutryShow >= 0 && this.IndusutryShow < 2) {
        this.IndusutryShow++;
      }
    },
    // 職種減少
    minusIndusutry() {
      if (this.IndusutryShow > 0 && this.IndusutryShow < 3) {
        this.IndusutryShow--;
      }
    },
    uploadUrl(){
      return `${this.$store.state.HOST}/B0002/upload`
    },
    //TITLE会社LOGOクリック
    toHomepage() {
      this.$router.push({ path: "/home" });
    },
    //会社メッセージクリア
    cleanAll(){
      this.registerForm.popFlg = "";
      this.buttonViewNum = true;
      this.$refs["registerForm"].resetFields();
      if(this.industryId > 1){
        this.$refs.buttonDown.$emit('click');
      }
      if(this.industryId > 0){
        this.$refs.buttonDown.$emit('click');
      }
      if(this.photoAddress > 1){
        this.$refs.buttonDown1.$emit('click');
      }
      if(this.photoAddress > 0){
        this.$refs.buttonDown1.$emit('click');
      }
      if(this.vedioAddress > 1){
        this.$refs.buttonDown2.$emit('click');
      }
      if(this.vedioAddress > 0){
        this.$refs.buttonDown2.$emit('click');
      }
    },
    // 毎ページ行目数のselect
    sizeChange(val) {
      this.pagination.pageSize = val;
      console.log("pageSize", this.pagination.pageSize);
      this.dataFromTo();
    },
    // 当ページのボタン
    currentChange(val) {
      this.pagination.currentPage = val;
      console.log("currentPage", this.pagination.currentPage);
      this.dataFromTo();
    },
    // テーブル値行範囲の設定
    dataFromTo() {
      this.pagination.dataStart =
        (this.pagination.currentPage - 1) * this.pagination.pageSize;
      this.pagination.dataEnd = this.pagination.currentPage * this.pagination.pageSize;
    },
    initList() {
      this.$store.dispatch("registerInit").then((response) => {
        this.$router.push({
          query: { data: response.data.data },
        });
        this.industryIds = response.data.data.industryList;
        this.companyScales = response.data.data.companyScaleList;
        this.countrys = response.data.data.countryList;
        this.registerForm.popFlg = "";
      });
    },
    initPop() {
      this.loading = true;
      this.$store
        .dispatch("initPop", this.registerForm.companyNm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.tableData = response.data.data.companyTblBeanList;
            this.show = true;
          } else if (code == 404) {
            this.$message.error(response.data.message);
          } else {
            this.$router.push({
              path: "/error",
              query: { message: response.data.message },
            });
          }
        })
        .catch(() => {
          this.loading = false;
        });
    },
    postalInit(address) {
      this.registerForm.address1 = address;
      this.registerForm.companyPostal =
        this.registerForm.companyPostal3keta +
        "-" +
        this.registerForm.companyPostal4keta;
    },
    searchPop() {
      this.loading = true;
      this.$store
        .dispatch("searchPop", this.companySearchForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.tableData = response.data.data.companyTblBeanList;
            // データ数を取得する
            this.pagination.total = response.data.data.companyTblBeanList.length;
            // データ数を取得する
            this.pagination.total = response.data.data.companyTblBeanList.length;
          } else if (code == 404) {
            this.$message.error(response.data.message);
          } else {
            this.$router.push({
              path: "/error",
              query: { message: response.data.message },
            });
          }
        })
        .catch(() => {
          this.loading = false;
        });
    },
    SearchPostal() {
      this.loading = true;
      this.$store
        .dispatch(
          "SearchPostal",
          this.registerForm.companyPostal3keta +
            "-" +
            this.registerForm.companyPostal4keta
        )
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.registerForm.address1 = response.data.data.prefeNm;
            // this.registerForm.address2 = response.data.data.cityNm;
          } else if (code == 404) {
            this.$message.error(response.data.message);
          } else {
            this.$router.push({
              path: "/error",
              query: { message: response.data.message },
            });
          }
        })
        .catch(() => {
          this.loading = false;
        });
    },
    //POP画面戻る
    rowClick(row) {
      this.industryId = 0;
      this.photoAddress = 0;
      this.vedioAddress = 0;
      this.show = false;
      this.registerForm.popFlg = "1";
      this.registerForm.companyId = row.companyId;
      this.registerForm.companyNm = row.companyNm;
      this.registerForm.companyTel = row.companyTel;
      this.registerForm.companyMail = row.companyMail;
      this.registerForm.industryId1 = row.industryId1;
      this.registerForm.industryId1Nm = row.industryNm1;
      if(row.industryId2 != null){
        this.registerForm.industryId2 = row.industryId2;
        this.registerForm.industryId2Nm = row.industryNm2;
        this.$refs.buttonUp.$emit('click');
      }
      if(row.industryId3 != null){
        this.registerForm.industryId3 = row.industryId3;
        this.registerForm.industryId3Nm = row.industryNm3;
        this.$refs.buttonUp.$emit('click');
      }
      this.registerForm.countryId = row.countryId;
      this.registerForm.companyPostal3keta = row.companyPostal.substr(0, 3);
      this.registerForm.companyPostal4keta = row.companyPostal.substr(4, 7);
      this.registerForm.companyPostal =
        row.companyPostal.substr(0, 3) + "-" + row.companyPostal.substr(4, 7);
      this.registerForm.address1 = row.address1;
      // this.registerForm.address2 = row.address2;
      this.registerForm.address2 = row.address2;
      this.registerForm.companyScale = row.companyScale;
      this.registerForm.companyMail = row.companyMail;
      this.registerForm.capital = row.capital;
      this.registerForm.businessContent = row.businessContent;
      this.registerForm.salesAmount = row.salesAmount;
      this.registerForm.homepage = row.homepage;
      this.registerForm.licenseAddress = row.licenseAddress;
      this.registerForm.companyLogo = row.companyLogo;
      this.registerForm.photoAddress1 = row.photoAddress1;
      if(row.photoAddress2 != null){
        this.registerForm.photoAddress2 = row.photoAddress2;
        this.$refs.buttonUp1.$emit('click');
      }
      if(row.photoAddress3 != null){
        this.registerForm.photoAddress3 = row.photoAddress3;
        this.$refs.buttonUp1.$emit('click');
      }
      this.registerForm.videoAddress1 = row.videoAddress1;
      if(row.photoAddress2 != null){
        this.registerForm.videoAddress2 = row.videoAddress2;
        this.$refs.buttonUp2.$emit('click');
      }
      if(row.photoAddress3 != null){
        this.registerForm.videoAddress3 = row.videoAddress3;
        this.$refs.buttonUp2.$emit('click');
      }
      this.registerForm.countryNm = row.countryNm;
      this.registerForm.companyScaleNm = row.companyScaleNm;
      this.buttonViewNum = false;
    },
    setCountryNm() {
      for (var i = 0; i < this.countrys.length; i++) {
        if (this.registerForm.countryId == this.countrys[i].countryId) {
          this.registerForm.countryNm = this.countrys[i].countryNm;
          break;
        }
      }
    },
    setCompanyScaleNm() {
      for (var i = 0; i < this.companyScale.length; i++) {
        if (this.registerForm.companyScale == this.companyScale[i].value) {
          this.registerForm.companyScaleNm = this.companyScale[i].label;
          break;
        }
      }
    },
    setIndustryId1Nm() {
      for (var i = 0; i < this.industryIds.length; i++) {
        if (this.registerForm.industryId1 == this.industryIds[i].industryId1) {
          this.registerForm.industryId1Nm = this.industryIds[i].industryId1Nm;
          break;
        }
      }
    },
    setIndustryId2Nm() {
      for (var i = 0; i < this.industryIds.length; i++) {
        if (this.registerForm.industryId2 == this.industryIds[i].industryId2) {
          this.registerForm.industryId2Nm = this.industryIds[i].industryId2Nm;
          break;
        }
      }
    },
    setIndustryId3Nm() {
      for (var i = 0; i < this.industryIds.length; i++) {
        if (this.registerForm.industryId3 == this.industryIds[i].industryId3) {
          this.registerForm.industryId3Nm = this.industryIds[i].industryId3Nm;
          break;
        }
      }
    },
    hideModal() {
      // 取消弹窗回调
      this.show = false;
    },
    submit() {
      // 确认弹窗回调
      this.show = false;
    },
    showPwd() {
      if (this.pwdType === "password") {
        this.pwdType = "";
      } else {
        this.pwdType = "password";
      }
    },
    remberTel(event) {
      this.registerForm.countryZip = event.target.value;
    },
    handleAvatarSuccesslicense(res, file) {
      this.$message.success("アップロード成功");
      // this.registerForm.licenseAddress = URL.createObjectURL(file.raw);
      this.licenseAddressPic = URL.createObjectURL(file.raw);
      this.registerForm.licenseAddress = res;
    },
    handleAvatarSuccesslogo(res, file) {
      this.$message.success("アップロード成功");
      this.registerForm.companyLogo = URL.createObjectURL(file.raw);
    },
    handleAvatarSuccesscompany(res, file) {
      this.$message.success("アップロード成功");
      this.registerForm.photoAddress1 = URL.createObjectURL(file.raw);
    },
    handleAvatarSuccesscompany2(res, file) {
      this.$message.success("アップロード成功");
      this.registerForm.photoAddress2 = URL.createObjectURL(file.raw);
    },
    handleAvatarSuccesscompany3(res, file) {
      this.$message.success("アップロード成功");
      this.registerForm.photoAddress3 = URL.createObjectURL(file.raw);
    },
    handleAvatarSuccessphoto(res, file) {
      this.$message.success("アップロード成功");
      this.registerForm.photoAddress = URL.createObjectURL(file.raw);
    },
    handleAvatarSuccessvideo() {
      this.$message.success("アップロード成功");
    },
    uploadFail() {
      this.$message.error("アップロード失敗");
    },
    beforeUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isPNG = file.type === "image/png";
      const isPDF = file.type === "application/pdf";
      const isLt2M = file.size / 1024 / 1024 < 5;

      if (!isJPG && !isPNG && !isPDF) {
        this.$message.error("アップロードファイルの形式は正しくない。jpeg・png・pdf形式のファイルを選択してください。");
      }
      if (!isLt2M) {
        this.$message.error("アップロードファイルのサイズは5MBを超えました。5MB以下のファイルを選択してください。");
      }
      return (isJPG || isPNG) && isLt2M;
    },
    beforeUploadVideo(file) {
      const isLt10M = file.size / 1024 / 1024 < 10;
      if (
        [
          "video/mp4",
          "video/ogg",
          "video/flv",
          "video/avi",
          "video/wmv",
          "video/rmvb",
        ].indexOf(file.type) == -1
      ) {
        this.$message.error(
          "正しいビデオフォーマットをアップロードしてください。"
        );
        return false;
      }
      if (!isLt10M) {
        this.$message.error(
          "ビデオのアップロードサイズは10 MBを超えてはいけません。"
        );
        return false;
      }
    },
    toThousandFilter(e) {
      //每个三位价格逗号
      if (e.target.value === "") {
        return;
      } else {
        var val = e.target.value;
        var int = val
          .split("")
          .reverse()
          .join(""); // 翻转整数
        var temp = ""; // 临时变量
        for (var i = 0; i < int.length; i++) {
          temp += int[i];
          if ((i + 1) % 3 == 0 && i != int.length - 1) {
            temp += ","; // 每隔三个数字拼接一个逗号
          }
        }
        temp = temp
          .split("")
          .reverse()
          .join(""); // 加完逗号之后翻转
        e.target.value = temp + "円"; // 返回
      }
    },
    toNumerFilter(e) {
      //每个三位价格逗号
      if (e.target.value === "") {
        return;
      } else {
        var val = e.target.value;
        val = val.replace(/,/g, "");
        var temp = val.substr(0, val.length - 1);
        e.target.value = temp; // 返回
      }
    },
    handelregister() {
      this.loading = true;
      this.$store
        .dispatch("register", this.registerForm)
        .then((response) => {
          this.loading = false;
          let code = response.data.code;
          if (code == 200) {
            this.$router.push({
              path: "/sp/sp_b0002Confirm",
              query: { data: response.data.data },
            });
          } else if (code == 404) {
            this.$message.error(response.data.message);
          } else {
            this.$router.push({
              path: "/error",
              query: { message: response.data.message },
            });
          }
        })
        .catch(() => {
          this.loading = false;
        });
    },
    routerBack() {
      this.$router.push({
        path: "/sp/sp_b0001",
        meta: {
          keepAlive: true,
        },
      });
    },
    clearAddress() {
      this.registerForm.address1 = "";
    },
  },
};
</script>
<style lang="scss">
.el-form-item.is-required:not(.is-no-asterisk) > .el-form-item__label:before {
  content: "※";
}
.el-form-item {
  margin-bottom: 20px;
}
.formcontent-popup {
  background-color: #ffffff;
  margin-top: 5px;
  padding-top: 10px;
  font-size: 20px;
  padding-left: 10px;

  .el-select {
    .el-input {
      input {
        height: 40px;
        margin: auto;
      }
    }
  }
}
.formcontent {
  .el-input {
    input {
      height: 40px;
      margin: auto;
      font-size: 20px;
    }
  }
}
.formcontent-popup .el-form-item__label {
  width: 20% !important;
}

.formcontent-popup-content {
  background-color: #ffffff;
  margin-top: 20px;
  padding-top: 10px;
  font-size: 20px;
}
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>
<style scoped>
.headT {
  width: 100%;
  height: 40px;
  background-color: #5db8ff;
  color: #ffffff;
  font-size: 32px;
  font-weight: bolder;
  line-height: 40px;
  margin-bottom: 20px;
  margin-top: 10px;
}
.cash {
  position: fixed;
  width: 100%;
}
.register-form-layout {
  position: relative;
  left: 0;
  right: 0;
  width: 100vw;
  margin: 0 auto;
  border-radius: 10px;
}
.loginLogo {
  position: relative;
  width: 260px;
}

.loginImgLogo {
  background-size: cover;
	position: absolute;
}
.title {
  width: 100%;
  height: 60px;
}
.tit {
  position: absolute;
  left: 370px;
  top: 51px;
  font-weight: normal;
}
.title-required {
  position: absolute;
  right: 10px;
  top: 44px;
  font-weight: normal;
}
.tips-required {
  position: absolute;
  right: 10px;
  font-weight: normal;
}
.font-blue-22 {
  color: #014099;
  font-size: 24px;
}
.font-red-16 {
  color: #ff0000;
  font-size: 20px;
}
.button1 {
  position: absolute;
  border: 0px;
  font-size:32px;
  margin-left: 20px;
  margin-top:-10px;
  -webkit-tap-highlight-color:transparent;
}
.button-position {
  position: absolute;
  margin-left: 10px;
}
.button-position2 {
  position: absolute;
  margin-left: 10px;
}
.button-position4 {
  position: absolute;
  margin-left: 20px;
}
::v-deep .button-position4 .el-button{
  margin-top:-10px;
  font-size: 32px;
  -webkit-tap-highlight-color:transparent;
}
.button-position5 {
  position: absolute;
  right: 10px;
  top: 40px;
  border: 0px;
  font-size:32px;
  -webkit-tap-highlight-color:transparent;
}
.button-position6 {
  position: absolute;
  right: -70px;
  top: 40px;
  border: 0px;
  font-size:32px;
  -webkit-tap-highlight-color:transparent;
}
.viderButton{
  font-size:24px;
  -webkit-tap-highlight-color:transparent;
}
.span-position {
  background: url("~@/assets/b_control2.png") center center no-repeat;
  position: absolute;
  left: 500px;
  width: 32px;
  height: 35px;
  top: 0px;
  border: 0px;
}
.select1 {
  width: 35% !important;
  border-radius: 6px;
  border: 1px solid #464545;
}
.select1:hover {
  border: 1px solid #35a7e9;
}
.photoInput {
  width: 61% !important;
  margin-left: 3%;
}
.button-confirm {
  width: 250px;
  height: 70px;
  background-image: linear-gradient(to right, #33a1ff, #33cdff);
  border-color: #33ccff;
}
.button-back {
  border-color: #909399;
  background: #b7b7b8;
  color: #ffffff;
  margin-left: 100px;
  width: 100px;
  height: 70px;
}
/* 会社pop検索ボタン */
.button-select-pop {
  margin-left: 20px;
  margin-bottom: 10px;
}
/* 会社pop戻るボタン */
.button-back-pop {
  width: 89px;
  height: 40.4px;
  border-color: #909399;
  background: #909399;
  margin-left: 50px;
  margin-bottom: 10px;
}
.el-input,
.el-select {
  width: 100%;
}

.formcontent {
  width: 85%;
}
/* popup全局画面 */
::v-deep .modal-container {
  width: 80%;
  height: 80%;
}
/* 邮编前三位输入框 */
.postal1 {
  width: 40% !important;
  margin-left: 5px;
  vertical-align: middle;
}
/* 邮编后四位输入框 */
.postal2 {
  width: 50% !important;
  margin-left: 5px;
  vertical-align: middle;
}
/* 邮编中间【-】 */
.divSmall {
  font-size: 32px;
  margin-left: 8px;
  margin-right: 8px;
  display: inline-block;
  vertical-align: middle;
}
/* select列表 */
.el-select-dropdown__item {
  font-size: 20px;
}
/* 解决点击后出现蓝色默认背景色 */
body {
  margin: 0px;
  -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
}
/* 解决点击后出现蓝色默认背景色 */
::v-deep .el-select > .el-input:focus-within {
  -webkit-tap-highlight-color: transparent !important;
}
::v-deep .el-select > .el-input__suffix:focus-within {
  -webkit-tap-highlight-color: transparent !important;
}
/* 输入框边框颜色变更 */
::v-deep div > .el-input__inner {
  border: 1px solid #464545;
}
::v-deep div > .el-input__inner:focus {
  border: 1px solid #35a7e9;
}
/* textarea */
::v-deep div > .el-textarea__inner {
  height: 120px !important;
  border: 1px solid #464545;
}
/* 错误信息 */
::v-deep div > .el-form-item__error {
  font-size: 20px;
}
/* アップロード */
::v-deep div > .el-button--small {
  padding: 15px 30px;
}
::v-deep div > .el-input--small > input {
  height: 40px;
  width: 240px;
  margin: auto;
  border: 0;
}
::v-deep div > .el-select > .el-input--small > input {
  width: 150px;
  margin: auto;
  border: 0;
}
::v-deep
  div
  > .input-small-position2
  > .el-form-item__content
  > .el-input
  > input {
  height: 40px;
  margin: auto;
}
::v-deep div > .el-form-item__label {
  font-size: 20px;
  color: #014099;
  font-style: normal;
  font-weight: bold;
  width: 100% !important;
  text-align: left !important;
  margin-left: 5px;
}
::v-deep div > .el-form-item__content {
  margin-left: 5px !important;
}
::v-deep div > .el-radio > .el-radio__label {
  font-size: 20px;
}
::v-deep div > .el-radio > .el-radio__input > .el-radio__inner {
  width: 20px;
  height: 20px;
}
::v-deep div > .el-radio > .el-radio__input > .el-radio__inner {
  width: 20px;
  height: 20px;
}
::v-deep div > .el-radio > .is-checked > .el-radio__inner {
  background: #33a1ff;
  border-color: #33a1ff;
}
::v-deep div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner:hover {
  border-color: #33a1ff;
}
::v-deep div > .el-checkbox > .el-checkbox__input > .el-checkbox__inner::after {
  height: 18px;
  left: 10px;
  width: 6px;
}
/* upload */
::v-deep div > .el-upload-list {
  width: 350px;
}
.register-center-layout {
  background: #409eff;
  width: auto;
  height: auto;
  max-width: 100%;
  max-height: 100%;
  margin-top: 200px;
}
.postal1 {
  width: 10vw;
  text-align: center;
}
.postal2 {
  width: 50vw;
  text-align: center;
}
::v-deep div > .avatar-uploader > .el-upload {
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  border: 1px dashed #464545;
}
::v-deep .avatar-uploader .el-upload:hover {
  border-color: #35a7e9;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #464545;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
.persion {
  color: #014099;
  font-size: 20px;
  margin: 8px 0;
  font-weight: 600;
  position: absolute;
}
.persion2 {
  color: #014099;
  margin-left: 8px;
  font-size: 20px;
}
/* 会社popselect */
.popForm {
  width: 28vw !important;
  margin-bottom: 5px !important;
}
/* 会社popinput */
.popFormInput {
  width: 56vw !important;
  margin-bottom: 5px !important;
}
</style>
