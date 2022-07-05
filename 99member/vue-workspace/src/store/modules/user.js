import {
  homeinit,
} from '@/api/home'
import {
  getPositionBySearchId,
} from '@/api/positionListFromHome'
import {
  companyDetailFrom,
} from '@/api/positionDetailFromHome'
import {
  getPositionByCompanyId,
} from '@/api/companyDetailFromHome'
import {
  login,
  getUserName,
} from '@/api/login' //引入登录 api 接口
import {
  register,
  registerInit,
  initPop,
  searchPop,
  searchPostal,
  insertCompany,
  userSelect,
}
from '@/api/register' //引入注册 api 接口
import {
  a0601Init,
  a0601Confirm,
  a0602Position,
  a0602Training,
  a0602Briefing,
} from '@/api/a06'
import {
  a070101Init,
  a070101Search,
  a070101Confirm,
  a070101Deny,
  a070102Search,
  a070102Confirm,
  a070103Search,
  a070103Confirm,
  a070104Search,
  a070104Confirm,
  a070105Search,
  a070105Confirm,
} from '@/api/a07'
import {
  b0003Search
} from '@/api/b0003'
import {
  b0101Init,
  b0101Search,
  b0101Delete,
  b0102InitIndustry,
  b0102InitJobtype,
  b0102InitSkill,
  sendPositionInfo,
  sendPositionInfoModify,
  b0101OnlineOffline,
  b0101Top,
  b0102register
} from '@/api/b01'
import {
  b0201Init,
  b0201Search,
  updateStatus
} from '@/api/b0201'
import {
  b0301Init,
  b0301Search
} from '@/api/b03'
import {
  b0401Search,
  b0401Delete
} from '@/api/b04' //引入b0401的检索 api 接口
import {
  b0501Init,
  b0501Search,
  b0501Delete,
  b0502Init,
  sendTrainingInfo,
  b0503Search,
} from '@/api/b05'
import {
  g01Search,
} from '@/api/G01'   // データ採集検証のため、追加
import {
  b0601Init,
  b0601Search,
  b0601Delete,
  sendBriefingInfo,
  b0603Search
} from '@/api/b06'
import {
  b0901Init,
  b0902Message,
} from '@/api/b09'
import {
  b0801Init
} from '@/api/b0801'
import {
  b0802Init
} from '@/api/b0802'
import {
  insertCoupon
} from '@/api/b0802'
import {
  b0803Init,
  b0803getCharge
} from '@/api/b0803'
import {
  getComchargeResult,
  getComconsResult,
} from '@/api/b0804'
import {
  clogin
} from '@/api/c0001'
import {
  personalInformationInit,
  personalInformationInsert,
  personalInformationUpdate,
  qualificationCertificateInsertQua,
  qualificationCertificateDeleteQua,
  qualificationCertificateUpdateQua,
  skillInformationInsertSkill,
  skillInformationDeleteSkill,
  skillInformationUpdateSkill,
  workExperienceInsertWorkHis,
  workExperienceDeleteWorkHis,
  workExperienceUpdateWorkHis,
  languageSkillsInsertLan,
  languageSkillsDeleteLan,
  languageSkillsUpdateLan,
  educationalBackgroundInsertEdu,
  educationalBackgroundDeleteEdu,
  educationalBackgroundUpdateEdu,
  projectExperienceInsertProjectHis,
  projectExperienceUpdateProjectHis,
  projectExperienceDeleteProjectHis,
  getApplicant,
} from '@/api/c01'
import {
  c0003Search
} from '@/api/c0003'
import {
  userConf,
  userInsert
} from '@/api/c0002'
import {
  alogin
} from '@/api/a0001'
import {
  auserConf,
  auserInsert
} from '@/api/a0002'
import {
  a0003Search
} from '@/api/a0003'
import {
  c0201Init,
  c0201getDate,
  c0201InitPost,
  c0201InitLike,
  c0201insertPost,
  c0201insertLike,
  c0201updateLike,
  c0201deleteApplication
} from '@/api/c0201'
import {
  c0301Init,
  c0301getList,
  c0301InitPost,
  c0301InitLike,
  c0301insertPost,
  c0301insertLike,
  c0301updateLike,
  c0301deleteTrainingAppl
} from '@/api/c0301'
import {
  c0401Init,
  c0401getList,
  c0401InitPost,
  c0401InitLike,
  c0401insertPost,
  c0401insertLike,
  c0401updateLike,
  c0401deleteBriefingAppl
} from '@/api/c0401'
import {
  c0501select,
  c0501selectInfo,
  c0501flgChange
} from '@/api/c0501'
import {
  a0801Insert,
  a0801AddressList,
  a0802GetMessage,
} from '@/api/a08'
import {
  verifyCode
} from '@/api/Kaptcha'
import {
  sendPwMail,
  checkMailCode,
  changePassword
} from '@/api/retrievePassword'
import {
  a0301Search,
  a0301Update
} from '@/api/a0301'
import {
  a0901InitUserInfoA,
  a0901InitUserInfoB,
  a0901InitUserInfoC,
  a0901userInfoUpdate

} from '@/api/a0901'
import {
  a0501Init,
  a0501Delete,
  a0502registerInit,
  a0502initPop,
  a0502searchPop,
  a0502InitLayout,
  sendAdInfo
} from '@/api/a05'
const user = {
  actions: {
    // ホームページ
    homeinit({
      commit
    }) {
      return new Promise((resolve, reject) => {
        homeinit().then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    // ホームページから職位一覧
      getPositionBySearchId({
        commit
      }, homeVueForm) {
        this.commit = (type, payload, options) => {
          return commit.call(this, type, payload, options)
        }
          return new Promise((resolve, reject) => {
          getPositionBySearchId(
            homeVueForm.searchNm, homeVueForm.industryId, homeVueForm.jobtypeId, 
            homeVueForm.prefeNm, homeVueForm.language, homeVueForm.levelSection, 
            homeVueForm.adId
            ).then(response => {
            resolve(response)
          }).catch(error => {
            reject(error)
          })
        })
      },
    // 職位一覧から会社データを取得
    companyDetailFrom({
      commit
    }, companyId) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
    return new Promise((resolve, reject) => {
        companyDetailFrom(companyId).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    //会社の職位データ取得
    getPositionByCompanyId({
      commit
    }, companyId) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
    return new Promise((resolve, reject) => {
        getPositionByCompanyId(companyId).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    // ログイン
    Login({
      commit
    }, userInfo) { //定义 Login 方法，在组件中使用 this.$store.dispatch("Login") 调用
        this.commit = (type, payload, options) => {
          return commit.call(this, type, payload, options)
        }
      const userMail = userInfo.userMail.trim()
      return new Promise((resolve, reject) => { //封装一个 Promise
        login(userMail, userInfo.password).then(response => { //使用 login 接口进行网络请求
          // commit('') //提交一个 mutation，通知状态改变
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
    // 新規登録
    register({
      commit
    }, companyInfo) { //定义 register 方法，在组件中使用 this.$store.dispatch("register") 调用
      return new Promise((resolve, reject) => { //封装一个 Promise
        register(companyInfo).then(response => { //使用 register 接口进行网络请求
          commit('') //提交一个 mutation，通知状态改变
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
    registerInit() { //定义 register 方法，在组件中使用 this.$store.dispatch("register") 调用
      return new Promise((resolve, reject) => { //封装一个 Promise
        registerInit().then(response => { //使用 register 接口进行网络请求
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
    personalInformationInit() {
      return new Promise((resolve, reject) => {
        personalInformationInit().then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    personalInformationInsert({
      commit
    }, personalInformationForm) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        personalInformationInsert(personalInformationForm.companyId,
          personalInformationForm.userCd,
          personalInformationForm.applicantId,
          personalInformationForm.photo,
          personalInformationForm.countryId,
          personalInformationForm.birthday,
          personalInformationForm.applicantPostal,
          personalInformationForm.address1,
          personalInformationForm.address2,
          personalInformationForm.station,
          personalInformationForm.industryId1,
          personalInformationForm.jobtypeId1_1,
          personalInformationForm.jobtypeId1_2,
          personalInformationForm.jobtypeId1_3,
          personalInformationForm.industryId2,
          personalInformationForm.jobtypeId2_1,
          personalInformationForm.jobtypeId2_2,
          personalInformationForm.jobtypeId2_3,
          personalInformationForm.industryId3,
          personalInformationForm.jobtypeId3_1,
          personalInformationForm.jobtypeId3_2,
          personalInformationForm.jobtypeId3_3,
          personalInformationForm.hopeLand1,
          personalInformationForm.hopeLand2,
          personalInformationForm.hopeLand3,
          personalInformationForm.graduationSchool,
          personalInformationForm.graduationMajor,
          personalInformationForm.finalEducation,
          personalInformationForm.workYears,
          personalInformationForm.hopeSalaryFrom,
          personalInformationForm.hopeSalaryTo,
          personalInformationForm.workSituation,
          personalInformationForm.specialty,
          personalInformationForm.reason,
          personalInformationForm.introduce,
          personalInformationForm.interest,
          personalInformationForm.remarks, ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    personalInformationUpdate({
      commit
    }, personalInformationForm) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        personalInformationUpdate(personalInformationForm.companyId,
          personalInformationForm.userCd,
          personalInformationForm.applicantId,
          personalInformationForm.photo,
          personalInformationForm.countryId,
          personalInformationForm.birthday,
          personalInformationForm.applicantPostal,
          personalInformationForm.address1,
          personalInformationForm.address2,
          personalInformationForm.station,
          personalInformationForm.industryId1,
          personalInformationForm.jobtypeId1_1,
          personalInformationForm.jobtypeId1_2,
          personalInformationForm.jobtypeId1_3,
          personalInformationForm.industryId2,
          personalInformationForm.jobtypeId2_1,
          personalInformationForm.jobtypeId2_2,
          personalInformationForm.jobtypeId2_3,
          personalInformationForm.industryId3,
          personalInformationForm.jobtypeId3_1,
          personalInformationForm.jobtypeId3_2,
          personalInformationForm.jobtypeId3_3,
          personalInformationForm.hopeLand1,
          personalInformationForm.hopeLand2,
          personalInformationForm.hopeLand3,
          personalInformationForm.graduationSchool,
          personalInformationForm.graduationMajor,
          personalInformationForm.finalEducation,
          personalInformationForm.workYears,
          personalInformationForm.hopeSalaryFrom,
          personalInformationForm.hopeSalaryTo,
          personalInformationForm.workSituation,
          personalInformationForm.specialty,
          personalInformationForm.reason,
          personalInformationForm.introduce,
          personalInformationForm.interest,
          personalInformationForm.remarks, ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    qualificationCertificateInsertQua({
      commit
    }, c010102VueForm) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        qualificationCertificateInsertQua(
          c010102VueForm.acquisitionDate,
          c010102VueForm.appQuaId,
          c010102VueForm.applicantId,
          c010102VueForm.createBy,
          c010102VueForm.createTime,
          c010102VueForm.delFlg,
          c010102VueForm.quaAddress,
          c010102VueForm.quaNm,
          c010102VueForm.quaNum,
          c010102VueForm.remarks,
          c010102VueForm.updateBy,
          c010102VueForm.updateTime,
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    qualificationCertificateDeleteQua({
      commit
    }, row) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        qualificationCertificateDeleteQua(
          row.applicantId,
          row.appQuaId,
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    qualificationCertificateUpdateQua({
      commit
    }, c010102VueForm) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        qualificationCertificateUpdateQua(
          c010102VueForm.acquisitionDate,
          c010102VueForm.appQuaId,
          c010102VueForm.applicantId,
          c010102VueForm.quaAddress,
          c010102VueForm.quaNm,
          c010102VueForm.quaNum,
          c010102VueForm.remarks,
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    skillInformationInsertSkill({
      commit
    }, c010103VueForm) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        skillInformationInsertSkill(
          c010103VueForm.companyId,
          c010103VueForm.userCd,
          c010103VueForm.appSkillId,
          c010103VueForm.applicantId,
          c010103VueForm.skillId,
          c010103VueForm.expSection,
          c010103VueForm.otherNm,
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    skillInformationDeleteSkill({
      commit
    }, row) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        skillInformationDeleteSkill(
          row.applicantId,
          row.appSkillId,
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    skillInformationUpdateSkill({
      commit
    }, c010103VueForm) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        skillInformationUpdateSkill(
          c010103VueForm.companyId,
          c010103VueForm.userCd,
          c010103VueForm.appSkillId,
          c010103VueForm.applicantId,
          c010103VueForm.skillId,
          c010103VueForm.expSection,
          c010103VueForm.otherNm,
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    workExperienceInsertWorkHis({
      commit
    }, c010104VueForm) {
      return new Promise((resolve, reject) => {
        this.commit = (type, payload, options) => {
          return commit.call(this, type, payload, options)
        }
        workExperienceInsertWorkHis(
          c010104VueForm.companyId,
          c010104VueForm.userCd,
          c010104VueForm.workHisId,
          c010104VueForm.applicantId,
          c010104VueForm.companyNm,
          c010104VueForm.industryId1,
          c010104VueForm.jobtypeId1_1,
          c010104VueForm.jobtypeId1_2,
          c010104VueForm.jobtypeId1_3,
          c010104VueForm.workPosition,
          c010104VueForm.workPlace,
          c010104VueForm.workSkill,
          c010104VueForm.workDateFrom,
          c010104VueForm.workDateTo,
          c010104VueForm.introduction,
          c010104VueForm.workContent,
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    workExperienceDeleteWorkHis({
      commit
    }, row) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        workExperienceDeleteWorkHis(
          row.applicantId,
          row.workHisId,
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    workExperienceUpdateWorkHis({
      commit
    }, c010104VueForm) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        workExperienceUpdateWorkHis(
          c010104VueForm.companyId,
          c010104VueForm.userCd,
          c010104VueForm.workHisId,
          c010104VueForm.applicantId,
          c010104VueForm.companyNm,
          c010104VueForm.industryId1,
          c010104VueForm.jobtypeId1_1,
          c010104VueForm.jobtypeId1_2,
          c010104VueForm.jobtypeId1_3,
          c010104VueForm.workPosition,
          c010104VueForm.workPlace,
          c010104VueForm.workSkill,
          c010104VueForm.workDateFrom,
          c010104VueForm.workDateTo,
          c010104VueForm.introduction,
          c010104VueForm.workContent,
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    languageSkillsInsertLan({
      commit
    }, c010105VueForm) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        languageSkillsInsertLan(
          c010105VueForm.companyId,
          c010105VueForm.userCd,
          c010105VueForm.applicantId,
          c010105VueForm.languageId,
          c010105VueForm.levelSection,
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    languageSkillsDeleteLan({
      commit
    }, row) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        languageSkillsDeleteLan(
          row.applicantId,
          row.languageId,
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    languageSkillsUpdateLan({
      commit
    }, c010105VueForm) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        languageSkillsUpdateLan(
          c010105VueForm.companyId,
          c010105VueForm.userCd,
          c010105VueForm.applicantId,
          c010105VueForm.languageId,
          c010105VueForm.levelSection,
          c010105VueForm.appLanId,
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    educationalBackgroundInsertEdu({
      commit
    }, c010106VueForm) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        educationalBackgroundInsertEdu(
          c010106VueForm.companyId,
          c010106VueForm.userCd,
          c010106VueForm.educationId,
          c010106VueForm.applicantId,
          c010106VueForm.schoolNm,
          c010106VueForm.majorNm,
          c010106VueForm.eduDateFrom,
          c010106VueForm.eduDateTo,
          c010106VueForm.degree,
          c010106VueForm.eduSection,
          c010106VueForm.degreePic1,
          c010106VueForm.photoPic,
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    educationalBackgroundDeleteEdu({
      commit
    }, row) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        educationalBackgroundDeleteEdu(
          row.applicantId,
          row.educationId,
        ).then(response => {
          console.log("user.js", response.data.data);
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    educationalBackgroundUpdateEdu({
      commit
    }, c010106VueForm) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        educationalBackgroundUpdateEdu(
          c010106VueForm.companyId,
          c010106VueForm.userCd,
          c010106VueForm.educationId,
          c010106VueForm.applicantId,
          c010106VueForm.schoolNm,
          c010106VueForm.majorNm,
          c010106VueForm.eduDateFrom,
          c010106VueForm.eduDateTo,
          c010106VueForm.degree,
          c010106VueForm.eduSection,
          c010106VueForm.degreePic1,
          c010106VueForm.photoPic,
        ).then(response => {
          console.log("user.js", response.data.data);
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    projectExperienceInsertProjectHis({
      commit
    }, c010107VueForm) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        projectExperienceInsertProjectHis(
          c010107VueForm.companyId,
          c010107VueForm.userCd,
          c010107VueForm.projectId,
          c010107VueForm.applicantId,
          c010107VueForm.projectNm,
          c010107VueForm.proDateFrom,
          c010107VueForm.proDateTo,
          c010107VueForm.proRole,
          c010107VueForm.proCnt,
          c010107VueForm.proDuties,
          c010107VueForm.proTec,
          c010107VueForm.proContent,
        ).then(response => {
          console.log("user.js", response.data.data);
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    projectExperienceDeleteProjectHis({
      commit
    }, row) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        projectExperienceDeleteProjectHis(
          row.applicantId,
          row.projectId,
        ).then(response => {
          console.log("user.js", response.data.data);
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    projectExperienceUpdateProjectHis({
      commit
    }, c010107VueForm) {
      this.commit = (type, payload, options) => {
        return commit.call(this, type, payload, options)
      }
      return new Promise((resolve, reject) => {
        projectExperienceUpdateProjectHis(
          c010107VueForm.companyId,
          c010107VueForm.userCd,
          c010107VueForm.projectId,
          c010107VueForm.applicantId,
          c010107VueForm.projectNm,
          c010107VueForm.proDateFrom,
          c010107VueForm.proDateTo,
          c010107VueForm.proRole,
          c010107VueForm.proCnt,
          c010107VueForm.proDuties,
          c010107VueForm.proTec,
          c010107VueForm.proContent,
        ).then(response => {
          console.log("user.js", response.data.data);
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    getApplicant({
      commit
    }, applicantId) {
      this.commit = (type, payload, applicantId) => {
        return commit.call(this, type, payload, applicantId)
      }
      return new Promise((resolve, reject) => {
        getApplicant(
          applicantId
        ).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    initPop({
      commit
    }, companyNm) {
      return new Promise((resolve, reject) => {
        initPop(companyNm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    searchPop({
      commit
    }, companyInfo) {
      return new Promise((resolve, reject) => {
        searchPop(companyInfo.companyNm, companyInfo.country, companyInfo.address1, companyInfo.industryCd1, companyInfo.companyScale).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    getUserName({
      commit
    }) {
      return new Promise((resolve, reject) => {
        getUserName().then(response => {
          console.log("rsp1", response);
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    searchPostal({
      commit
    }, companyPostal) {
      return new Promise((resolve, reject) => {
        searchPostal(companyPostal).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    userSelect({
      commit
    }, SelectForm) {
      return new Promise((resolve, reject) => {
        userSelect(SelectForm.userMail, SelectForm.companyNm, SelectForm.userName).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    insertCompany({
      commit
    }, companyInfo) {
      return new Promise((resolve, reject) => {
        insertCompany(companyInfo).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a0601Init({
      commit
    }, a0601VueForm) {
      return new Promise((resolve, reject) => {
        a0601Init(
          a0601VueForm.typeSection,
          a0601VueForm.reportSection,
          a0601VueForm.limit,
          a0601VueForm.offset,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a0601Confirm({
      commit
    }, a0601VueForm) {
      return new Promise((resolve, reject) => {
        a0601Confirm(
          a0601VueForm.reportIds,
          a0601VueForm.statusFlg,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a0602Position({
      commit
    }, positionId) {
      return new Promise((resolve, reject) => {
        a0602Position(
          positionId
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a0602Training({
      commit
    }, trainingId) {
      return new Promise((resolve, reject) => {
        a0602Training(
          trainingId
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a0602Briefing({
      commit
    }, briefingId) {
      return new Promise((resolve, reject) => {
        a0602Briefing(
          briefingId
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a070101Init({
      commit
    }, A070101VueForm) {
      return new Promise((resolve, reject) => {
        a070101Init(
          A070101VueForm.userMail,
          A070101VueForm.userName,
          A070101VueForm.authority,
          A070101VueForm.userCd,
          A070101VueForm.userCds,
          A070101VueForm.statusFlg,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a070101Search({
      commit
    }, A070101VueForm) {
      return new Promise((resolve, reject) => {
        a070101Search(
          A070101VueForm.userMail,
          A070101VueForm.userName,
          A070101VueForm.authority,
          A070101VueForm.userCd,
          A070101VueForm.userCds,
          A070101VueForm.statusFlg,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a070101Confirm({
      commit
    }, A070101VueForm) {
      return new Promise((resolve, reject) => {
        a070101Confirm(
          A070101VueForm.userMail,
          A070101VueForm.userName,
          A070101VueForm.authority,
          A070101VueForm.userCd,
          A070101VueForm.userCds,
          A070101VueForm.statusFlg,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a070101Deny({
      commit
    }, A070101VueForm) {
      return new Promise((resolve, reject) => {
        a070101Deny(
          A070101VueForm.userMail,
          A070101VueForm.userName,
          A070101VueForm.authority,
          A070101VueForm.userCd,
          A070101VueForm.userCds,
          A070101VueForm.statusFlg,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a070102Search({
      commit
    }, A070102VueForm) {
      return new Promise((resolve, reject) => {
        a070102Search(
          A070102VueForm.companyNm,
          A070102VueForm.prefeNm,
          A070102VueForm.industryId,
          A070102VueForm.companyId,
          A070102VueForm.companyIds,
          A070102VueForm.statusFlg
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a070102Confirm({
      commit
    }, A070102VueForm) {
      return new Promise((resolve, reject) => {
        a070102Confirm(
          A070102VueForm.companyNm,
          A070102VueForm.prefeNm,
          A070102VueForm.industryId,
          A070102VueForm.companyId,
          A070102VueForm.companyIds,
          A070102VueForm.statusFlg
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a070103Search({
      commit
    }, A070103VueForm) {
      return new Promise((resolve, reject) => {
        a070103Search(
          A070103VueForm.likeSelect,
          A070103VueForm.positionNm,
          A070103VueForm.companyNm,
          A070103VueForm.prefeNm,
          A070103VueForm.industryId,
          A070103VueForm.jobtypeId,
          A070103VueForm.positionId,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a070103Confirm({
      commit
    }, A070103VueForm) {
      return new Promise((resolve, reject) => {
        a070103Confirm(
          A070103VueForm.listData,
          A070103VueForm.statusFlg,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a070104Search({
      commit
    }, A070104VueForm) {
      return new Promise((resolve, reject) => {
        a070104Search(
          A070104VueForm.companyNm,
          A070104VueForm.trainingNm,
          A070104VueForm.prefeNm,
          A070104VueForm.industryId,
          A070104VueForm.trainingId,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a070104Confirm({
      commit
    }, A070104VueForm) {
      return new Promise((resolve, reject) => {
        a070104Confirm(
          A070104VueForm.listData,
          A070104VueForm.statusFlg,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a070105Search({
      commit
    }, A070105VueForm) {
      return new Promise((resolve, reject) => {
        a070105Search(
          A070105VueForm.companyNm,
          A070105VueForm.briefingNm,
          A070105VueForm.briefingType,
          A070105VueForm.dateFromString,
          A070105VueForm.dateToString,
          A070105VueForm.briefingId,
          A070105VueForm.prefeNm,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a070105Confirm({
      commit
    }, A070105VueForm) {
      return new Promise((resolve, reject) => {
        a070105Confirm(
          A070105VueForm.listData,
          A070105VueForm.statusFlg,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0501Init(B0501VueForm) {
      return new Promise((resolve, reject) => {
        b0501Init(B0501VueForm).then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    b0601Init({
      commit
    }, B0601VueForm) {
      return new Promise((resolve, reject) => {
        b0601Init(B0601VueForm).then(response => {
          console.log("user.js.request", response);
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0003Search() {
      return new Promise((resolve, reject) => { //封装一个 Promise
        b0003Search().then(response => { //使用 register 接口进行网络请求
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
    changeLogin(state, a) {
      state.Authorization = a;
      localStorage.setItem('Authorization', state.Authorization);
    },
    b0101Init() {
      return new Promise((resolve, reject) => {
        b0101Init().then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0101Search({
      commit
    }, B0101VueForm) {
      return new Promise((resolve, reject) => {
        b0101Search(
          B0101VueForm.companyId,
          B0101VueForm.userCd,
          B0101VueForm.positionNm,
          B0101VueForm.checkStatus,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0101Delete({
      commit
    }, B0101VueForm) {
      return new Promise((resolve, reject) => {
        b0101Delete(
          B0101VueForm.positionId,
          B0101VueForm.positionIds
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0101OnlineOffline({
      commit
    }, B0101VueForm) {
      return new Promise((resolve, reject) => {
        b0101OnlineOffline(
          B0101VueForm.positionId,
          B0101VueForm.positionIds,
          B0101VueForm.onlineStatus,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0101Top({
      commit
    }, B0101VueForm) {
      return new Promise((resolve, reject) => {
        b0101Top(
          B0101VueForm.positionId,
          B0101VueForm.positionIds,
          B0101VueForm.topStatus,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0102InitIndustry({
      commit
    }) {
      return new Promise((resolve, reject) => {
        b0102InitIndustry().then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0102InitJobtype({
      commit
    }) {
      return new Promise((resolve, reject) => {
        b0102InitJobtype().then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0102InitSkill({
      commit
    }) {
      return new Promise((resolve, reject) => {
        b0102InitSkill().then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    sendPositionInfo({
      commit
    }, B0102VueForm) {
      return new Promise((resolve, reject) => {
        sendPositionInfo(
          B0102VueForm.userCd,
          B0102VueForm.companyId,
          B0102VueForm.industryId,
          B0102VueForm.jobTypeId,
          B0102VueForm.skillId,
          B0102VueForm.positionNm,
          B0102VueForm.expDate,
          B0102VueForm.degree,
          B0102VueForm.workTimeFrom,
          B0102VueForm.workTimeTo,
          B0102VueForm.salarySection,
          B0102VueForm.positionInt,
          B0102VueForm.salaryMin,
          B0102VueForm.salaryMax,
          B0102VueForm.empLaborIns,
          B0102VueForm.workContent,
          B0102VueForm.welfare,
          B0102VueForm.expYears,
          B0102VueForm.trainingFlg,
          B0102VueForm.inspectionFlg,
          B0102VueForm.conUpdFlg,
          B0102VueForm.peoCnt,
          B0102VueForm.workDateStr,
          B0102VueForm.contractSection,
          B0102VueForm.holiday,
          B0102VueForm.postal,
          B0102VueForm.workAddress1,
          B0102VueForm.workAddress2,
          B0102VueForm.station,
          B0102VueForm.workingAddress1,
          B0102VueForm.workingAddress2,
          B0102VueForm.workingAddress3
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    sendPositionInfoModify({
      commit
    }, B0102VueForm) {
      return new Promise((resolve, reject) => {
        sendPositionInfoModify(
          B0102VueForm.userCd,
          B0102VueForm.positionId,
          B0102VueForm.companyId,
          B0102VueForm.industryId,
          B0102VueForm.jobTypeId,
          B0102VueForm.skillId,
          B0102VueForm.positionNm,
          B0102VueForm.expDate,
          B0102VueForm.degree,
          B0102VueForm.workTimeFrom,
          B0102VueForm.workTimeTo,
          B0102VueForm.salarySection,
          B0102VueForm.positionInt,
          B0102VueForm.salaryMin,
          B0102VueForm.salaryMax,
          B0102VueForm.empLaborIns,
          B0102VueForm.workContent,
          B0102VueForm.welfare,
          B0102VueForm.expYears,
          B0102VueForm.trainingFlg,
          B0102VueForm.inspectionFlg,
          B0102VueForm.conUpdFlg,
          B0102VueForm.peoCnt,
          B0102VueForm.workDateStr,
          B0102VueForm.contractSection,
          B0102VueForm.holiday,
          B0102VueForm.postal,
          B0102VueForm.workAddress1,
          B0102VueForm.workAddress2,
          B0102VueForm.station,
          B0102VueForm.workingAddress1,
          B0102VueForm.workingAddress2,
          B0102VueForm.workingAddress3
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0102register({
      commit
    }, b0102VueForm) { //定义 register 方法，在组件中使用 this.$store.dispatch("register") 调用
      return new Promise((resolve, reject) => { //封装一个 Promise
        b0102register(
          b0102VueForm.userCd,
          b0102VueForm.companyId,
          b0102VueForm.industryId,
          b0102VueForm.jobTypeId,
          b0102VueForm.skillId,
          b0102VueForm.positionNm,
          b0102VueForm.expDate,
          b0102VueForm.degree,
          b0102VueForm.workTimeFrom,
          b0102VueForm.workTimeTo,
          b0102VueForm.salarySection,
          b0102VueForm.positionInt,
          b0102VueForm.salaryMin,
          b0102VueForm.salaryMax,
          b0102VueForm.empLaborIns,
          b0102VueForm.workContent,
          b0102VueForm.welfare,
          b0102VueForm.expYears,
          b0102VueForm.trainingFlg,
          b0102VueForm.inspectionFlg,
          b0102VueForm.conUpdFlg,
          b0102VueForm.peoCnt,
          b0102VueForm.workDateStr,
          b0102VueForm.contractSection,
          b0102VueForm.holiday,
          b0102VueForm.postal,
          b0102VueForm.workAddress1,
          b0102VueForm.workAddress2,
          b0102VueForm.station,
          b0102VueForm.workingAddress1,
          b0102VueForm.workingAddress2,
          b0102VueForm.workingAddress3,
        ).then(response => { //使用 register 接口进行网络请求
          commit('') //提交一个 mutation，通知状态改变
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0201Init() {
      return new Promise((resolve, reject) => {
        b0201Init().then(response => {
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0201Search({
      commit
    }, searchForm) {
      return new Promise((resolve, reject) => {
        b0201Search(searchForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    updateStatus({
      commit
    }, b0201SearchVueForm) {
      return new Promise((resolve, reject) => {
        updateStatus(b0201SearchVueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    b0301Init({
      commit
    }, B0301VueForm) {
      return new Promise((resolve, reject) => {
        b0301Init(B0301VueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0301Search({
      commit
    }, B0301VueForm) {
      console.log("testt", B0301VueForm);
      return new Promise((resolve, reject) => {
        b0301Search(
          B0301VueForm.companyId,
          B0301VueForm.userCd,
          B0301VueForm.skillId,
          B0301VueForm.industryId,
          B0301VueForm.jobtypeId,
          B0301VueForm.prefeNm,
          B0301VueForm.hopeland,
          B0301VueForm.finalEducation,
          B0301VueForm.workYearsFrom,
          B0301VueForm.workYearsTo,
          B0301VueForm.languageId,
          B0301VueForm.levelSection,
          B0301VueForm.sex,
          B0301VueForm.hopeSalaryFrom,
          B0301VueForm.hopeSalaryTo,
          B0301VueForm.ageFrom,
          B0301VueForm.ageTo
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    b0401Search({
      commit
    }, B0401VueForm) {
      return new Promise((resolve, reject) => {
        b0401Search(B0401VueForm.userCd, B0401VueForm.companyId, B0401VueForm.interviewType, B0401VueForm.interviewDateFrom, B0401VueForm.interviewDateTo, B0401VueForm.dateFrom, B0401VueForm.dateTo, B0401VueForm.statusFlg, B0401VueForm.interviewId, B0401VueForm.interviewIds).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0401Delete({
      commit
    }, B0401VueForm) {
      return new Promise((resolve, reject) => {
        b0401Delete(
          B0401VueForm.userCd,
          B0401VueForm.companyId,
          B0401VueForm.interviewType,
          B0401VueForm.interviewDateFrom,
          B0401VueForm.interviewDateTo,
          B0401VueForm.dateFrom,
          B0401VueForm.dateTo,
          B0401VueForm.statusFlg,
          B0401VueForm.interviewId,
          B0401VueForm.interviewIds,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0501Search({
      commit
    }, B0501VueForm) {
      return new Promise((resolve, reject) => {
        b0501Search(B0501VueForm.companyId, B0501VueForm.userCd, B0501VueForm.trainingNm, B0501VueForm.industryId, B0501VueForm.statusFlg, B0501VueForm.dateFrom, B0501VueForm.dateTo, B0501VueForm.trainingId, B0501VueForm.trainingIds, ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    g01Search({         // データ採集検証のため、追加
      commit
    }, G01VueForm) {
      return new Promise((resolve, reject) => {
        g01Search(G01VueForm.goodsDetail,G01VueForm.goodsPhoto,G01VueForm.goodsLink,G01VueForm.goodsName,G01VueForm.goodsTag,G01VueForm.goodsPrice,).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0501Delete({
      commit
    }, trainingIds) {
      return new Promise((resolve, reject) => {
        b0501Delete(trainingIds).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0502Init({
      commit
    }) {
      return new Promise((resolve, reject) => {
        b0502Init().then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    sendTrainingInfo({
      commit
    }, B0502VueForm) {
      console.log(B0502VueForm);
      return new Promise((resolve, reject) => {
        sendTrainingInfo(B0502VueForm.userCd,
          B0502VueForm.trainingId,
          B0502VueForm.companyId,
          B0502VueForm.industryId,
          B0502VueForm.trainingNm,
          B0502VueForm.dateFrom,
          B0502VueForm.dateTo,
          B0502VueForm.timeFrom,
          B0502VueForm.timeTo,
          B0502VueForm.postal,
          B0502VueForm.prefingNm,
          B0502VueForm.charge,
          B0502VueForm.cost,
          B0502VueForm.proCnt,
          B0502VueForm.remarks,
          B0502VueForm.teaIntro,
          B0502VueForm.teaNm,
          B0502VueForm.tel,
          B0502VueForm.trainingAddress1,
          B0502VueForm.trainingAddress2,
          B0502VueForm.trainingContent,
          B0502VueForm.trainingPic1,
          B0502VueForm.trainingPic2,
          B0502VueForm.trainingPic3, ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    b0503Search({
        commit
      },
      B0503VueForm
    ) {
      return new Promise(
        (resolve, reject) => {
          b0503Search(
              B0503VueForm.userCd,
              B0503VueForm.companyId,
              B0503VueForm.trainingId,
              B0503VueForm.name,
              B0503VueForm.status,
              B0503VueForm.applicantId,
              B0503VueForm.statusFlg,
            )
            .then(
              response => {
                commit('')
                console.log("user.js: response", response);
                resolve(response)
              }
            )
            .catch(
              error => {
                reject(error)
              }
            )
        }
      )
    },

    b0801Init() {
      return new Promise((resolve, reject) => { //封装一个 Promise
        b0801Init().then(response => { //使用 register 接口进行网络请求
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    b0802Init() {
      return new Promise((resolve, reject) => { //封装一个 Promise
        b0802Init().then(response => { //使用 register 接口进行网络请求
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    b0803Init() {
      return new Promise((resolve, reject) => { //封装一个 Promise
        b0803Init().then(response => { //使用 register 接口进行网络请求
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    b0803getCharge({
      commit
    }, b0803VueForm) {
      return new Promise((resolve, reject) => {
        b0803getCharge(b0803VueForm.companyId, b0803VueForm.chargeTime, b0803VueForm.chargeMoney, b0803VueForm.chargeHoney, b0803VueForm.payMethod, b0803VueForm.statusFlg, b0803VueForm.remainder, b0803VueForm.honeyLastDate, b0803VueForm.userCd, ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },


    insertCoupon({
      commit
    }, b0802VueForm) {
      return new Promise((resolve, reject) => {
        insertCoupon(b0802VueForm.beans).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    b0601Search({
      commit
    }, B0601VueForm) {
      return new Promise((resolve, reject) => {
        b0601Search(
          B0601VueForm.companyId,
          B0601VueForm.userCd,
          B0601VueForm.briefingType,
          B0601VueForm.briefingDate,
          B0601VueForm.statusFlg,
          B0601VueForm.dateFrom,
          B0601VueForm.dateTo,
          B0601VueForm.briefingId,
          B0601VueForm.briefingIds,
          B0601VueForm.briefingNm,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    b0601Delete({
      commit
    }, B0601VueForm) {
      return new Promise((resolve, reject) => {
        b0601Delete(
          B0601VueForm.briefingId,
          B0601VueForm.briefingIds
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    sendBriefingInfo({
      commit
    }, B0602VueForm) {
      console.log(B0602VueForm);
      return new Promise((resolve, reject) => {
        sendBriefingInfo(
          B0602VueForm.companyId,
          B0602VueForm.userCd,
          B0602VueForm.briefingId,
          B0602VueForm.briefingNm,
          B0602VueForm.briefingType,
          B0602VueForm.briefingDate,
          B0602VueForm.dateFrom,
          B0602VueForm.dateTo,
          B0602VueForm.postal,
          B0602VueForm.prefeNm,
          B0602VueForm.briefingAddress1,
          B0602VueForm.briefingAddress2,
          B0602VueForm.briefingContent,
          B0602VueForm.proCntPlan,
          B0602VueForm.teaNm,
          B0602VueForm.teaIntro,
          B0602VueForm.tel,
          B0602VueForm.charge,
          B0602VueForm.photoAddress1,
          B0602VueForm.photoAddress2,
          B0602VueForm.photoAddress3,
          B0602VueForm.remarks, ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    b0603Search({
        commit
      },
      B0603VueForm
    ) {
      return new Promise(
        (resolve, reject) => {
          b0603Search(
              B0603VueForm.companyId,
              B0603VueForm.briefingId,
              B0603VueForm.name
            )
            .then(
              response => {
                commit('')
                resolve(response)
              }).catch(error => {
              reject(error)
            })
        })
    },

    getComchargeResult({
      commit
    }, b0804VueForm) {
      return new Promise((resolve, reject) => {
        getComchargeResult(b0804VueForm.chargeFrom, b0804VueForm.chargeTo, b0804VueForm.statusFlg, b0804VueForm.consFrom, b0804VueForm.consTo, b0804VueForm.itemId, b0804VueForm.chargeId, b0804VueForm.chargeMoney, b0804VueForm.chargeHoney).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    getComconsResult({
      commit
    }, b0804VueForm) {
      return new Promise((resolve, reject) => {
        getComconsResult(b0804VueForm.chargeFrom, b0804VueForm.chargeTo, b0804VueForm.statusFlg, b0804VueForm.consFrom, b0804VueForm.consTo, b0804VueForm.itemId, b0804VueForm.chargeId, b0804VueForm.chargeMoney, b0804VueForm.chargeHoney).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    b0901Init({
      commit
    }, b0901Form) {
      return new Promise((resolve, reject) => { //封装一个 Promise
        b0901Init(
          b0901Form.userCd, b0901Form.internalMessageId, b0901Form.address, b0901Form.subject, b0901Form.dateFrom, b0901Form.dateTo, b0901Form.statusFlg
        ).then(response => { //使用 register 接口进行网络请求
          commit('')
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    b0902Message({
      commit
    }, b0902Form) {
      console.log(b0902Form);
      return new Promise((resolve, reject) => { //封装一个 Promise
        b0902Message(
          b0902Form.userCd, b0902Form.internalMessageId, b0902Form.address, b0902Form.subject, b0902Form.dateFrom, b0902Form.dateTo, b0902Form.statusFlg
        ).then(response => { //使用 register 接口进行网络请求
          commit('')
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    cLogin({
      commit
    }, userInfo) { //定义 Login 方法，在组件中使用 this.$store.dispatch("Login") 调用
      const userMail = userInfo.userMail.trim()
      return new Promise((resolve, reject) => { //封装一个 Promise
        clogin(userMail, userInfo.password).then(response => { //使用 login 接口进行网络请求
          commit('') //提交一个 mutation，通知状态改变
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
    c0003Search() {
      return new Promise((resolve, reject) => { //封装一个 Promise
        c0003Search().then(response => { //使用 register 接口进行网络请求
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
    userConf({
      commit
    }, registerInfo) { //定义 Login 方法，在组件中使用 this.$store.dispatch("Login") 调用
      const userMail = registerInfo.userMail.trim()
      return new Promise((resolve, reject) => { //封装一个 Promise
        userConf(registerInfo.userCd,
          registerInfo.pwd,
          registerInfo.repwd,
          registerInfo.companyId,
          registerInfo.authority,
          registerInfo.firstNameKana,
          registerInfo.firstName,
          registerInfo.lastNameKana,
          registerInfo.lastName,
          registerInfo.sex,
          registerInfo.countryZip,
          registerInfo.userTel,
          userMail,
          registerInfo.photoAddress,
          registerInfo.userStatus

        ).then(response => { //使用 login 接口进行网络请求
          commit('') //提交一个 mutation，通知状态改变
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    userInsert({
      commit
    }, registerInfo) { //定义 Login 方法，在组件中使用 this.$store.dispatch("Login") 调用
      const userMail = registerInfo.userMail.trim()
      return new Promise((resolve, reject) => { //封装一个 Promise
        userInsert(registerInfo.userCd,
          registerInfo.pwd,
          registerInfo.repwd,
          registerInfo.companyId,
          registerInfo.authority,
          registerInfo.firstNameKana,
          registerInfo.firstName,
          registerInfo.lastNameKana,
          registerInfo.lastName,
          registerInfo.sex,
          registerInfo.countryZip,
          registerInfo.userTel,
          userMail,
          registerInfo.photoAddress,
          registerInfo.userStatus

        ).then(response => { //使用 login 接口进行网络请求
          commit('') //提交一个 mutation，通知状态改变
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    aLogin({
      commit
    }, userInfo) { //定义 Login 方法，在组件中使用 this.$store.dispatch("Login") 调用
      const userMail = userInfo.userMail.trim()
      return new Promise((resolve, reject) => { //封装一个 Promise
        alogin(userMail, userInfo.password).then(response => { //使用 login 接口进行网络请求
          commit('') //提交一个 mutation，通知状态改变
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
    a0003Search() {
      return new Promise((resolve, reject) => { //封装一个 Promise
        a0003Search().then(response => { //使用 register 接口进行网络请求
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },
    auserConf({
      commit
    }, registerInfo) { //定义 Login 方法，在组件中使用 this.$store.dispatch("Login") 调用
      const userMail = registerInfo.userMail.trim()
      return new Promise((resolve, reject) => { //封装一个 Promise
        auserConf(registerInfo.userCd,
          registerInfo.pwd,
          registerInfo.repwd,
          registerInfo.companyId,
          registerInfo.authority,
          registerInfo.firstNameKana,
          registerInfo.firstName,
          registerInfo.lastNameKana,
          registerInfo.lastName,
          registerInfo.sex,
          registerInfo.countryZip,
          registerInfo.userTel,
          userMail,
          registerInfo.photoAddress,
          registerInfo.userStatus

        ).then(response => { //使用 login 接口进行网络请求
          commit('') //提交一个 mutation，通知状态改变
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    auserInsert({
      commit
    }, registerInfo) { //定义 Login 方法，在组件中使用 this.$store.dispatch("Login") 调用
      const userMail = registerInfo.userMail.trim()
      return new Promise((resolve, reject) => { //封装一个 Promise
        auserInsert(registerInfo.userCd,
          registerInfo.pwd,
          registerInfo.repwd,
          registerInfo.companyId,
          registerInfo.authority,
          registerInfo.firstNameKana,
          registerInfo.firstName,
          registerInfo.lastNameKana,
          registerInfo.lastName,
          registerInfo.sex,
          registerInfo.countryZip,
          registerInfo.userTel,
          userMail,
          registerInfo.photoAddress,
          registerInfo.userStatus

        ).then(response => { //使用 login 接口进行网络请求
          commit('') //提交一个 mutation，通知状态改变
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0201Init({
      commit
    }, C0201VueForm) {
      return new Promise((resolve, reject) => {
        c0201Init(C0201VueForm.likeSelect, C0201VueForm.companyNm, C0201VueForm.prefeId, C0201VueForm.prefeNm, C0201VueForm.salary, C0201VueForm.industryId, C0201VueForm.jobtypeId, C0201VueForm.degree, C0201VueForm.expYears, C0201VueForm.empLaborIns, C0201VueForm.welfare, C0201VueForm.trainingFlg, C0201VueForm.inspectionFlg, C0201VueForm.userCd).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0201getDate({
      commit
    }, C0201VueForm) {
      return new Promise((resolve, reject) => {
        c0201getDate(C0201VueForm.likeSelect, C0201VueForm.companyNm, C0201VueForm.prefeId, C0201VueForm.prefeNm, C0201VueForm.salarySection, C0201VueForm.salary, C0201VueForm.industryId, C0201VueForm.jobtypeId, C0201VueForm.degree, C0201VueForm.expYears, C0201VueForm.empLaborIns, C0201VueForm.welfare, C0201VueForm.trainingFlg, C0201VueForm.inspectionFlg, C0201VueForm.userCd).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0201InitPost({
      commit
    }, C0201VueForm) {
      return new Promise((resolve, reject) => {
        c0201InitPost(C0201VueForm.likeSelect, C0201VueForm.companyNm, C0201VueForm.prefeId, C0201VueForm.prefeNm, C0201VueForm.salary, C0201VueForm.industryId, C0201VueForm.jobtypeId, C0201VueForm.degree, C0201VueForm.expYears, C0201VueForm.empLaborIns, C0201VueForm.welfare, C0201VueForm.trainingFlg, C0201VueForm.inspectionFlg, C0201VueForm.userCd).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0201InitLike({
      commit
    }, C0201VueForm) {
      return new Promise((resolve, reject) => {
        c0201InitLike(C0201VueForm.likeSelect, C0201VueForm.companyNm, C0201VueForm.prefeId, C0201VueForm.prefeNm, C0201VueForm.salary, C0201VueForm.industryId, C0201VueForm.jobtypeId, C0201VueForm.degree, C0201VueForm.expYears, C0201VueForm.empLaborIns, C0201VueForm.welfare, C0201VueForm.trainingFlg, C0201VueForm.inspectionFlg, C0201VueForm.userCd).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0201insertPost({
      commit
    }, vueForm) {
      return new Promise((resolve, reject) => {
        c0201insertPost(vueForm.c0201VueForm, vueForm.c0201ListVueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0201insertLike({
      commit
    }, vueForm) {
      return new Promise((resolve, reject) => {
        c0201insertLike(vueForm.c0201VueForm, vueForm.c0201ListVueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0201updateLike({
      commit
    }, vueForm) {
      return new Promise((resolve, reject) => {
        c0201updateLike(vueForm.c0201VueForm, vueForm.c0201ListVueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0201deleteApplication({
      commit
    }, vueForm) {
      return new Promise((resolve, reject) => {
        c0201deleteApplication(vueForm.c0201VueForm, vueForm.c0201ListVueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0301Init({
      commit
    }, C0301VueForm) {
      return new Promise((resolve, reject) => {
        c0301Init(C0301VueForm.trainingNm, C0301VueForm.companyNm, C0301VueForm.prefeNm, C0301VueForm.industryId, C0301VueForm.dateFrom, C0301VueForm.dateTo, C0301VueForm.timeFrom, C0301VueForm.timeTo, C0301VueForm.salary, C0301VueForm.userCd).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0301getList({
      commit
    }, C0301VueForm) {
      return new Promise((resolve, reject) => {
        c0301getList(C0301VueForm.trainingNm, C0301VueForm.companyNm, C0301VueForm.prefeNm, C0301VueForm.industryId, C0301VueForm.dateFrom, C0301VueForm.dateTo, C0301VueForm.timeFrom, C0301VueForm.timeTo, C0301VueForm.salary, C0301VueForm.userCd).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0301InitPost({
      commit
    }, C0301VueForm) {
      return new Promise((resolve, reject) => {
        c0301InitPost(C0301VueForm.trainingNm, C0301VueForm.companyNm, C0301VueForm.prefeNm, C0301VueForm.industryId, C0301VueForm.dateFrom, C0301VueForm.dateTo, C0301VueForm.timeFrom, C0301VueForm.timeTo, C0301VueForm.salary, C0301VueForm.userCd).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0301InitLike({
      commit
    }, C0301VueForm) {
      return new Promise((resolve, reject) => {
        c0301InitLike(C0301VueForm.trainingNm, C0301VueForm.companyNm, C0301VueForm.prefeNm, C0301VueForm.industryId, C0301VueForm.dateFrom, C0301VueForm.dateTo, C0301VueForm.timeFrom, C0301VueForm.timeTo, C0301VueForm.salary, C0301VueForm.userCd).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0301insertPost({
      commit
    }, vueForm) {
      return new Promise((resolve, reject) => {
        c0301insertPost(vueForm.c0301VueForm, vueForm.c0301ListVueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0301insertLike({
      commit
    }, vueForm) {
      return new Promise((resolve, reject) => {
        c0301insertLike(vueForm.c0301VueForm, vueForm.c0301ListVueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0301updateLike({
      commit
    }, vueForm) {
      return new Promise((resolve, reject) => {
        c0301updateLike(vueForm.c0301VueForm, vueForm.c0301ListVueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0301deleteTrainingAppl({
      commit
    }, vueForm) {
      return new Promise((resolve, reject) => {
        c0301deleteTrainingAppl(vueForm.c0301VueForm, vueForm.c0301ListVueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0401Init({
      commit
    }, C0401VueForm) {
      return new Promise((resolve, reject) => {
        c0401Init(C0401VueForm.briefingNm, C0401VueForm.companyNm, C0401VueForm.briefingType, C0401VueForm.dateFrom, C0401VueForm.dateTo, C0401VueForm.prefeNm, C0401VueForm.userCd, C0401VueForm.applicantId).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0401getList({
      commit
    }, C0401VueForm) {
      return new Promise((resolve, reject) => {
        c0401getList(C0401VueForm.briefingNm, C0401VueForm.companyNm, C0401VueForm.briefingType, C0401VueForm.dateFrom, C0401VueForm.dateTo, C0401VueForm.prefeNm, C0401VueForm.userCd, C0401VueForm.applicantId).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0401InitPost({
      commit
    }, C0401VueForm) {
      return new Promise((resolve, reject) => {
        c0401InitPost(C0401VueForm.briefingNm, C0401VueForm.companyNm, C0401VueForm.briefingType, C0401VueForm.dateFrom, C0401VueForm.dateTo, C0401VueForm.prefeNm, C0401VueForm.userCd, C0401VueForm.applicantId).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0401InitLike({
      commit
    }, C0401VueForm) {
      return new Promise((resolve, reject) => {
        c0401InitLike(C0401VueForm.briefingNm, C0401VueForm.companyNm, C0401VueForm.briefingType, C0401VueForm.dateFrom, C0401VueForm.dateTo, C0401VueForm.prefeNm, C0401VueForm.userCd, C0401VueForm.applicantId).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0401insertPost({
      commit
    }, vueForm) {
      return new Promise((resolve, reject) => {
        c0401insertPost(vueForm.c0401VueForm, vueForm.c0401ListVueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0401insertLike({
      commit
    }, vueForm) {
      return new Promise((resolve, reject) => {
        c0401insertLike(vueForm.c0401VueForm, vueForm.c0401ListVueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0401updateLike({
      commit
    }, vueForm) {
      return new Promise((resolve, reject) => {
        c0401updateLike(vueForm.c0401VueForm, vueForm.c0401ListVueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0401deleteBriefingAppl({
      commit
    }, vueForm) {
      return new Promise((resolve, reject) => {
        c0401deleteBriefingAppl(vueForm.c0401VueForm, vueForm.c0401ListVueForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0501selectInfo({
      commit
    }, C0501VueForm) {
      return new Promise((resolve, reject) => {
        c0501selectInfo(C0501VueForm.userCd, C0501VueForm.applicantId, C0501VueForm.companyId, C0501VueForm.interviewType, C0501VueForm.interviewDateFrom, C0501VueForm.interviewDateTo, C0501VueForm.dateFrom, C0501VueForm.dateTo, C0501VueForm.statusFlg, C0501VueForm.interviewId, C0501VueForm.interviewIds).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0501select({
      commit
    }, C0501VueForm) {
      return new Promise((resolve, reject) => {
        c0501select(C0501VueForm.userCd, C0501VueForm.applicantId, C0501VueForm.companyId, C0501VueForm.interviewType, C0501VueForm.interviewDateFrom, C0501VueForm.interviewDateTo, C0501VueForm.dateFrom, C0501VueForm.dateTo, C0501VueForm.statusFlg, C0501VueForm.interviewId, C0501VueForm.interviewIds).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    c0501flgChange({
      commit
    }, C0501VueForm) {
      return new Promise((resolve, reject) => {
        c0501flgChange(C0501VueForm.userCd, C0501VueForm.applicantId, C0501VueForm.companyId, C0501VueForm.interviewType, C0501VueForm.interviewDateFrom, C0501VueForm.interviewDateTo, C0501VueForm.dateFrom, C0501VueForm.dateTo, C0501VueForm.statusFlg, C0501VueForm.interviewId, C0501VueForm.interviewIds).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    a0801Insert({
      commit
    }, A0801VueForm) {
      return new Promise((resolve, reject) => {
        a0801Insert(A0801VueForm.sendId, A0801VueForm.recid, A0801VueForm.subject, A0801VueForm.internalMessageTextId, A0801VueForm.internalMessageText).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    a0801AddressList({
      commit
    }, B0901VueForm) {
      return new Promise((resolve, reject) => {
        a0801AddressList(B0901VueForm.userCd, B0901VueForm.internalMessageId, B0901VueForm.address, B0901VueForm.subject, B0901VueForm.dateFrom, B0901VueForm.dateTo, B0901VueForm.statusFlg).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    a0802GetMessage({
      commit
    }, a0802Form) {
      return new Promise((resolve, reject) => { //封装一个 Promise
        a0802GetMessage(
          a0802Form.userCd, a0802Form.internalMessageId, a0802Form.address, a0802Form.subject, a0802Form.dateFrom, a0802Form.dateTo, a0802Form.statusFlg
        ).then(response => { //使用 register 接口进行网络请求
          commit('')
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    verifyCode({
      commit
    }, code) {
      return new Promise((resolve, reject) => {
        verifyCode(code).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    sendPwMail({
      commit
    }, mailInfo) {
      return new Promise((resolve, reject) => {
        sendPwMail(mailInfo.userMail).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    checkMailCode({
      commit
    }, mailInfo) {
      return new Promise((resolve, reject) => {
        checkMailCode(mailInfo.mailCode).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    changePassword({
      commit
    }, mailInfo) {
      return new Promise((resolve, reject) => {
        changePassword(mailInfo.userMail, mailInfo.passwordNew, mailInfo.passwordC).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a0301Search({
      commit
    }, searchForm) {
      return new Promise((resolve, reject) => {
        a0301Search(searchForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a0301Update({
      commit
    }, searchForm) {
      return new Promise((resolve, reject) => {
        a0301Update(searchForm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    a0901InitUserInfoA() {
      return new Promise((resolve, reject) => { //封装一个 Promise
        a0901InitUserInfoA().then(response => { //使用 register 接口进行网络请求
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    a0901InitUserInfoB() {
      return new Promise((resolve, reject) => { //封装一个 Promise
        a0901InitUserInfoB().then(response => { //使用 register 接口进行网络请求
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    a0901InitUserInfoC() {
      return new Promise((resolve, reject) => { //封装一个 Promise
        a0901InitUserInfoC().then(response => { //使用 register 接口进行网络请求
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    a0901userInfoUpdate({
      commit
    }, registerInfo) { //定义 Login 方法，在组件中使用 this.$store.dispatch("Login") 调用

      return new Promise((resolve, reject) => { //封装一个 Promise
        a0901userInfoUpdate(registerInfo.userCd,
          registerInfo.pwd,
          registerInfo.repwd,
          registerInfo.companyId,
          registerInfo.authority,
          registerInfo.firstNameKana,
          registerInfo.firstName,
          registerInfo.lastNameKana,
          registerInfo.lastName,
          registerInfo.sex,
          registerInfo.countryZip,
          registerInfo.userTel,
          registerInfo.userMail,
          registerInfo.photoAddress,
          registerInfo.userStatus

        ).then(response => { //使用 login 接口进行网络请求
          commit('') //提交一个 mutation，通知状态改变
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    a0501Init({
      commit
    }, A0501VueForm) {
      return new Promise((resolve, reject) => {
        a0501Init(
          A0501VueForm.userCd,
          A0501VueForm.layoutId,
          A0501VueForm.onlineFlg,
          A0501VueForm.chargeFlg,
          A0501VueForm.dateFrom,
          A0501VueForm.dateTo,
          A0501VueForm.adId,
          A0501VueForm.adIds
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a0501Delete({
      commit
    }, A0501VueForm) {
      return new Promise((resolve, reject) => {
        a0501Delete(
          A0501VueForm.adId,
          A0501VueForm.adIds
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    a0502registerInit() { //定义 register 方法，在组件中使用 this.$store.dispatch("register") 调用
      return new Promise((resolve, reject) => { //封装一个 Promise
        a0502registerInit().then(response => { //使用 register 接口进行网络请求
          resolve(response) //将结果封装进 Promise
        }).catch(error => {
          reject(error)
        })
      })
    },

    a0502initPop({
      commit
    }, companyNm) {
      return new Promise((resolve, reject) => {
        a0502initPop(companyNm).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a0502searchPop({
      commit
    }, companyInfo) {
      return new Promise((resolve, reject) => {
        a0502searchPop(companyInfo.companyNm, companyInfo.country, companyInfo.address1, companyInfo.industryCd1, companyInfo.companyScale).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    a0502InitLayout({
      commit
    }) {
      return new Promise((resolve, reject) => {
        a0502InitLayout().then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
    sendAdInfo({
      commit
    }, A0502VueForm) {
      return new Promise((resolve, reject) => {
        sendAdInfo(
          A0502VueForm.userCd,
          A0502VueForm.adId,
          A0502VueForm.companyId,
          A0502VueForm.layoutId,
          A0502VueForm.photo,
          A0502VueForm.link,
          A0502VueForm.content,
          A0502VueForm.dateFrom,
          A0502VueForm.dateTo,
          A0502VueForm.days,
          A0502VueForm.sum,
          A0502VueForm.onlineFlg,
          A0502VueForm.chargeFlg,
        ).then(response => {
          commit('')
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },
  }
}
export default user