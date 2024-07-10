import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import fangjian from '@/views/modules/fangjian/list'
    import fangjianruzhu from '@/views/modules/fangjianruzhu/list'
    import fankui from '@/views/modules/fankui/list'
    import houqinrenyuan from '@/views/modules/houqinrenyuan/list'
    import hugong from '@/views/modules/hugong/list'
    import laoren from '@/views/modules/laoren/list'
    import liuyan from '@/views/modules/liuyan/list'
    import news from '@/views/modules/news/list'
    import tijianyuan from '@/views/modules/tijianyuan/list'
    import wuzi from '@/views/modules/wuzi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import dictionaryFangjian from '@/views/modules/dictionaryFangjian/list'
    import dictionaryFankui from '@/views/modules/dictionaryFankui/list'
    import dictionaryJibing from '@/views/modules/dictionaryJibing/list'
    import dictionaryLaoren from '@/views/modules/dictionaryLaoren/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryWuzi from '@/views/modules/dictionaryWuzi/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryFangjian',
        name: '房间类型',
        component: dictionaryFangjian
    }
    ,{
        path: '/dictionaryFankui',
        name: '反馈类型',
        component: dictionaryFankui
    }
    ,{
        path: '/dictionaryJibing',
        name: '是否有疾病',
        component: dictionaryJibing
    }
    ,{
        path: '/dictionaryLaoren',
        name: '老人身体状态',
        component: dictionaryLaoren
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryWuzi',
        name: '物资类型',
        component: dictionaryWuzi
    }


    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/fangjian',
        name: '房间信息',
        component: fangjian
      }
    ,{
        path: '/fangjianruzhu',
        name: '房间入住信息',
        component: fangjianruzhu
      }
    ,{
        path: '/fankui',
        name: '反馈信息',
        component: fankui
      }
    ,{
        path: '/houqinrenyuan',
        name: '后勤人员',
        component: houqinrenyuan
      }
    ,{
        path: '/hugong',
        name: '护工',
        component: hugong
      }
    ,{
        path: '/laoren',
        name: '老人信息',
        component: laoren
      }
    ,{
        path: '/liuyan',
        name: '留言',
        component: liuyan
      }
    ,{
        path: '/news',
        name: '公告',
        component: news
      }
    ,{
        path: '/tijianyuan',
        name: '体检员',
        component: tijianyuan
      }
    ,{
        path: '/wuzi',
        name: '物资申请',
        component: wuzi
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
