import Vue from 'vue' //引入 Vue
import VueRouter from 'vue-router' //引入 Vue 路由

Vue.use(VueRouter); //安装插件

//移动端和PC端同时适配
const redirectPath = /micromessenger|phone|SymbianOS|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone/i.test(navigator.userAgent) ? '/sp/sp_b0001' : '/home';

// NavigationDuplicated: Avoided redundant navigation to current location
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

export const constantRouterMap = [{
    path: '/',
    redirect: redirectPath
  },
  /****************************************/
  /*           PC端路由配置               **/
  /****************************************/
  //loginのurlパスを配置する
  {
    path: '/',
    component: () => import('@/views/home')
  },
  {
    path: '/home',
    component: () => import('@/views/home')
  },
  {
    path: '/test',
    component: () => import('@/views/test')
  },
  {
    path: '/positionListFromHome',
    component: () => import('@/views/positionListFromHome')
  },
  {
    path: '/positionDetailFromHome',
    component: () => import('@/views/positionDetailFromHome')
  },
  {
    path: '/companyDetailFromHome',
    component: () => import('@/views/companyDetailFromHome')
  },
  {
    path: '/login',
    component: () => import('@/views/login')
  },

  //配置默认的路径，404用（路径为*的路由，一定配置再路由表的最底部）
  {
    path: '/404',
    component: () => import('@/views/notFound.vue')
  },
  // { path: '*', redirect: '/404'},

  //配置登录成功页面，使用时需要使用 path 路径来实现跳转
  {
    path: '/success',
    component: () => import('@/views/success')
  },

  //配置登录失败页面，使用时需要使用 path 路径来实现跳转
  {
    path: '/error',
    component: () => import('@/views/error'),
    hidden: true
  },

  //配置注册的路径，显示注册页
  {
    path: '/register',
    component: () => import('@/views/register'),
    hidden: true,
    name: 'register',
    meta: {
      keepAlive: true, //此组件需要缓存
      isBack: false, //用来判断是否是返回上一页
    }
  },

  //配置職位一覧的路径
  {
    path: '/position',
    component: () => import('@/views/position'),
    hidden: true
  },

  //配置注册確認的路径，显示注册確認页
  {
    path: '/registerCommit',
    component: () => import('@/views/registerCommit'),
    hidden: true,
    name: 'registerCommit',
    meta: {
      keepAlive: false,
    }
  },

  //利用規約画面のurlパスを配置する
  {
    path: '/privacy',
    component: () => import('@/views/privacy')
  },
  //利用規約画面のurlパスを配置する
  {
    path: '/terms',
    component: () => import('@/views/terms')
  },

  //a0001_システム管理者ログイン画面のurlパスを配置する
  {
    path: '/a0001',
    component: () => import('@/views/a/a00/a0001')
  },
  //a0002_システム管理者新規画面のurlパスを配置する
  {
    path: '/a0002',
    component: () => import('@/views/a/a00/a0002/a0002')
  },
  //a0002_システム管理者新規確認画面のurlパスを配置する
  {
    path: '/a0002Commit',
    component: () => import('@/views/a/a00/a0002/a0002Commit')
  },
  //a0003_システム管理者ログイン後画面のurlパスを配置する
  {
    path: '/a0003',
    component: () => import('@/views/a/a00/a0003')
  },
  {
    path: '/a0201',
    component: () => import('@/views/a/a02/a0201')
  },
  {
    path: '/a0202',
    component: () => import('@/views/a/a02/a0202/a0202')
  },
  //a0301_管理者一覧画面のurlパスを配置する
  {
    path: '/a0301',
    component: () => import('@/views/a0301')
  },
  //a0501_広告一覧画面のurlパスを配置する
  {
    path: '/a0501',
    component: () => import('@/views/a0501')
  },
  //a0502_広告新規入力画面のurlパスを配置する
  {
    path: '/a0502',
    component: () => import('@/views/a0502')
  },
  //a0501_広告修正画面のurlパスを配置する
  {
    path: '/a0502Modify',
    component: () => import('@/views/a0502Modify')
  },
  //a0601_通報画面のurlパスを配置する
  {
    path: '/a0601',
    component: () => import('@/views/a0601')
  },
  //a0602_通報詳細画面のurlパスを配置する
  {
    path: '/a0602',
    component: () => import('@/views/a0602')
  },
  //a0701_承認画面のurlパスを配置する
  {
    path: '/a0701',
    component: () => import('@/views/a0701')
  },
  //a0801_発信画面のurlパスを配置する
  {
    path: '/a0801',
    component: () => import('@/views/a0801')
  },
  //a0802_発信詳細画面のurlパスを配置する
  {
    path: '/a0802',
    component: () => import('@/views/a0802')
  },
  //a0901_ユーザー情報画面のurlパスを配置する
  {
    path: '/a0901',
    component: () => import('@/views/a0901')
  },
  //a0901_ユーザー情報修正画面のurlパスを配置する
  {
    path: '/a0901Modify',
    component: () => import('@/views/a0901Modify')
  },

  //配置默认的路径，默认显示会社管理
  {
    path: '/b0003',
    component: () => import('@/views/b0003')
  },

  //B0301_人材推薦一覧画面のurlパスを配置する
  {
    path: '/b0301',
    component: () => import('@/views/b0301')
  },

  //B0401_面接一覧画面のurlパスを配置する
  {
    path: '/b0401',
    component: () => import('@/views/b0401')
  },

  //B0402_面接詳細画面画面のurlパスを配置する
  {
    path: '/b0402Detailed',
    component: () => import('@/views/b0402Detailed')
  },

  //B0501_研修一覧画面のurlパスを配置する
  {
    path: '/b0501',
    component: () => import('@/views/b0501')
  },
  //B0502_研修新規確認画面のurlパスを配置する
  {
    path: '/b0502Confirm',
    component: () => import('@/views/b0502Confirm')
  },
  //B0502_研修詳細画面のurlパスを配置する
  {
    path: '/b0502Detailed',
    component: () => import('@/views/b0502Detailed')
  },
  //B0502_研修情報修正のurlパスを配置する
  {
    path: '/b0502Modify',
    component: () => import('@/views/b0502Modify')
  },
  //B0502_研修新規入力のurlパスを配置する
  {
    path: '/b0502Registered',
    component: () => import('@/views/b0502Registered')
  },
  //B0503_研修詳細画面のurlパスを配置する
  {
    path: '/b0503',
    component: () => import('@/views/b0503')
  },

  //B0601_説明会一覧画面のurlパスを配置する
  {
    path: '/b0601',
    component: () => import('@/views/b0601')
  },
  //B0602_説明会新規確認画面のurlパスを配置する
  {
    path: '/b0602Confirm',
    component: () => import('@/views/b0602Confirm')
  },
  //B0602_説明会詳細画面のurlパスを配置する
  {
    path: '/b0602Detailed',
    component: () => import('@/views/b0602Detailed')
  },
  //B0602_説明会情報修正のurlパスを配置する
  {
    path: '/b0602Modify',
    component: () => import('@/views/b0602Modify')
  },
  //B0602_説明会新規入力のurlパスを配置する
  {
    path: '/b0602Registered',
    component: () => import('@/views/b0602Registered')
  },
  //B0603_説明会応募者のurlパスを配置する
  {
    path: '/b0603',
    component: () => import('@/views/b0603')
  },
  //B0101_職位一覧画面のurlパスを配置する
  {
    path: '/b0101',
    component: () => import('@/views/b0101')
  },
  //B0102_研修新規確認画面のurlパスを配置する
  {
    path: '/b0102Confirm',
    component: () => import('@/views/b0102Confirm')
  },
  //B0102_研修詳細画面のurlパスを配置する
  {
    path: '/b0102Detailed',
    component: () => import('@/views/b0102Detailed')
  },
  //B0102_研修情報修正のurlパスを配置する
  {
    path: '/b0102Modify',
    component: () => import('@/views/b0102Modify')
  },
  //B0102_研修新規入力のurlパスを配置する
  {
    path: '/b0102Registered',
    component: () => import('@/views/b0102Registered')
  },
  //B0102_研修修正確認画面のurlパスを配置する
  {
    path: '/b0102ModifyConfirm',
    component: () => import('@/views/b0102ModifyConfirm')
  },
  //b0201_応募画面のurlパスを配置する
  {
    path: '/b0201',
    component: () => import('@/views/b0201')
  },

  //b0801_資産情報画面のurlパスを配置する
  {
    path: '/b0801',
    component: () => import('@/views/b0801')
  },
  //b0802_クーポン取得画面のurlパスを配置する
  {
    path: '/b0802',
    component: () => import('@/views/b0802')
  },
  //b0803_チャージ画面のurlパスを配置する
  {
    path: '/b0803',
    component: () => import('@/views/b0803')
  },
  //b0804_履歴画面のurlパスを配置する
  {
    path: '/b0804',
    component: () => import('@/views/b0804')
  },
  //b0805_会員管理一覧画面のurlパスを配置する
  {
    path: '/b0805',
    component: () => import('@/views/b0805')
  },
  //b0901_受信画面のurlパスを配置する
  {
    path: '/b0901',
    component: () => import('@/views/b0901')
  },
  //b0902_受信詳細画面のurlパスを配置する
  {
    path: '/b0902',
    component: () => import('@/views/b0902')
  },

  //c0001_応募者ログイン画面のurlパスを配置する
  {
    path: '/c0001',
    component: () => import('@/views/c0001')
  },
  //c0002_応募者新規画面のurlパスを配置する
  {
    path: '/c0002',
    component: () => import('@/views/c0002')
  },
  //c0002_応募者新規確認画面のurlパスを配置する
  {
    path: '/c0002Commit',
    component: () => import('@/views/c0002Commit')
  },
  //c0003_応募者ログイン後画面のurlパスを配置する
  {
    path: '/c0003',
    component: () => import('@/views/c0003')
  },
  {
    path: '/c0101',
    component: () => import('@/views/c0101')
  },
  {
    path: '/c01Detailed',
    component: () => import('@/views/c01Detailed')
  },
  //c0201_職位推薦画面のurlパスを配置する
  {
    path: '/c0201',
    component: () => import('@/views/c0201')
  },
  //c0301_研修推薦画面のurlパスを配置する
  {
    path: '/c0301',
    component: () => import('@/views/c0301')
  },
  //c0401_説明会推薦画面のurlパスを配置する
  {
    path: '/c0401',
    component: () => import('@/views/c0401')
  },
  {
    path: '/c0501',
    component: () => import('@/views/c0501')
  },
  {
    path: '/c0502',
    component: () => import('@/views/c0502')
  },

  /****************************************/
  /*           移动端端路由配置           **/
  /****************************************/
  //sp_b0001会社登録のurlパスを配置する
  {
    path: '/sp/sp_b0001',
    component: () => import('@/views/sp/sp_b0001')
  },
  //sp_b0002会社新規登録のurlパスを配置する
  {
    path: '/sp/sp_b0002',
    component: () => import('@/views/sp/sp_b0002')
  },
  //配置忘记密码的路径，显示忘记密码
  {
    path: '/retrievePassword',
    component: () => import('@/views/retrievePassword'),
    hidden: true
  },
  //sp_b0002Confirm会社新規登録確認のurlパスを配置する
  {
    path: '/sp/sp_b0002Confirm',
    component: () => import('@/views/sp/sp_b0002Confirm')
  },
  //sp_b0003会社メインのurlパスを配置する
  {
    path: '/sp/sp_b0003',
    component: () => import('@/views/sp/sp_b0003')
  },
  //sp_b0101_職位一覧画面のurlパスを配置する
  {
    path: '/sp/sp_b0101',
    component: () => import('@/views/sp/sp_b0101')
  },
  //sp_b0401面接一覧のurlパスを配置する
  {
    path: '/sp/sp_b0401',
    component: () => import('@/views/sp/sp_b0401')
  },
  //sp_b0402_面接詳細画面画面のurlパスを配置する
  {
    path: '/sp/sp_b0402Detailed',
    component: () => import('@/views/sp/sp_b0402Detailed')
  },
  //sp_b0501_研修一覧画面のurlパスを配置する
  {
    path: '/sp/sp_b0501',
    component: () => import('@/views/sp/sp_b0501')
  },
  //sp_b0502_研修新規確認画面のurlパスを配置する
  {
    path: '/sp/sp_b0502Confirm',
    component: () => import('@/views/sp/sp_b0502Confirm')
  },
  //sp_b0502_研修詳細画面のurlパスを配置する
  {
    path: '/sp/sp_b0502Detailed',
    component: () => import('@/views/sp/sp_b0502Detailed')
  },
  //sp_b0502_研修情報修正のurlパスを配置する
  {
    path: '/sp/sp_b0502Modify',
    component: () => import('@/views/sp/sp_b0502Modify')
  },
  //sp_b0502_研修新規入力のurlパスを配置する
  {
    path: '/sp/sp_b0502Registered',
    component: () => import('@/views/sp/sp_b0502Registered')
  },
  //sp_b0503_研修応募者一覧画面のurlパスを配置する
  {
    path: '/sp/sp_b0503',
    component: () => import('@/views/sp/sp_b0503')
  },
  //sp_b0601_説明会一覧画面のurlパスを配置する
  {
    path: '/sp/sp_b0601',
    component: () => import('@/views/sp/sp_b0601')
  },
  //sp_b0602_説明会新規確認画面のurlパスを配置する
  {
    path: '/sp/sp_b0602Confirm',
    component: () => import('@/views/sp/sp_b0602Confirm')
  },
  //sp_b0602_説明会詳細画面のurlパスを配置する
  {
    path: '/sp/sp_b0602Detailed',
    component: () => import('@/views/sp/sp_b0602Detailed')
  },
  //sp_b0602_説明会情報修正のurlパスを配置する
  {
    path: '/sp/sp_b0602Modify',
    component: () => import('@/views/sp/sp_b0602Modify')
  },
  //sp_b0602_説明会新規入力のurlパスを配置する
  {
    path: '/sp/sp_b0602Registered',
    component: () => import('@/views/sp/sp_b0602Registered')
  },
  //sp_b0603_説明会応募者一覧画面のurlパスを配置する
  {
    path: '/sp/sp_b0603',
    component: () => import('@/views/sp/sp_b0603')
  },
  //sp_b0801資産情報のurlパスを配置する
  {
    path: '/sp/sp_b0801',
    component: () => import('@/views/sp/sp_b0801')
  },
  //sp_b0802クーポン取得のurlパスを配置する
  {
    path: '/sp/sp_b0802',
    component: () => import('@/views/sp/sp_b0802')
  },
  //sp_b0803チャージのurlパスを配置する
  {
    path: '/sp/sp_b0803',
    component: () => import('@/views/sp/sp_b0803')
  },
  //sp_b0001会社登録のurlパスを配置する
  {
    path: '/sp/sp_c0001',
    component: () => import('@/views/sp/sp_c0001')
  },
  //sp_c0201_職位推薦画面のurlパスを配置する
  {
    path: '/sp/sp_c0201',
    component: () => import('@/views/sp/sp_c0201')
  },
  //getdata_データ採集検証用
  {
    path: '/getdata',
    component: () => import('@/views/getdata')
  },
  //getdatadetail_データ採集検証用
  {
    path: '/getdatadetail',
    component: () => import('@/views/getdatadetail')
  },

]
const vueRouter = new VueRouter({
  mode: 'history', //后端支持可开
  scrollBehavior: () => ({
    y: 0
  }),
  routes: constantRouterMap //指定路由列表
});

export default vueRouter