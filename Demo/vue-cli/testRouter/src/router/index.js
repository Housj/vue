import Vue from 'vue'
import Router from 'vue-router'
import Content from '../components/Content'
import Login from '../views/login'
import Main from '../views/main'
// 用于嵌套的路由组件
import UserProfile from '../views/user/Profile'
import UserList from '../views/user/List'
import NotFound from '../views/NotFound'
import axios from 'axios'

Vue.prototype.axios = axios;
Vue.use(Router)

export default new Router({
  routes: [
    { path: '/content',
      component:Content
    },
    { path: '/goMain',
      redirect: '/main',
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },{
      path: '/main',
      name: 'Main',
      component: Main,
      // 配置嵌套路由
      children: [
        // {path: '/user/profile/:id', name:"UserProfile",component: UserProfile},
        {path: '/user/profile/:id', name:'UserProfile', component: UserProfile, props: true},
        {path: '/user/list', component: UserList},
      ]
    }, {
      path: '*',
      component: NotFound
    }
  ]
})
