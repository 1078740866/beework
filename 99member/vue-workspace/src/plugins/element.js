import Vue from 'vue'
import Element from 'element-ui'
import '../element-variables.scss'
import lang from 'element-ui/lib/locale/lang/ja'
import locale from 'element-ui/lib/locale'
// element ui CSS配置
import 'element-ui/lib/theme-chalk/index.css'

// 日本語言語配置
locale.use(lang)

Vue.use(Element)