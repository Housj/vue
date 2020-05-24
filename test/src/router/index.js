import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '../components/HelloWorld'
import Login from '../views/login'
import Main from '../views/main'
import Out from '../views/out'
// 用于嵌套的路由组件
import UserProfile from '../views/user/Profile'
import UserList from '../views/user/List'
import NotFound from '../views/NotFound'
import Axios from 'axios'



Vue.prototype.axios = Axios;
Vue.use(Router);

export default new Router({
  routes: [ 
    {
      path: '/helloWorld',
      name: 'HelloWorld',
      component: HelloWorld
    },{
      path: '/',
      name:"",
      component: Login
    },
    {
      path: '/login',
      name:"Login",
      component: Login
    },
    {
      path: '/out',
      name:"Out",
      component: Out
    },{
      path: '/main',
      name: 'Main',
      component: Main,
      //配置嵌套路由
        children: [
          {path: '/user/profile/:id', name:"UserProfile",component: UserProfile},
          // {path: '/user/profile/:id', name:'UserProfile', component: UserProfile, props: true},
          {path: '/user/list',name:'UserList', component: UserList}
        ]
    },
    // {
    //   path:'/logout',
    //   redirect:'login'
    // },
    {
      path: '*',
      component: NotFound
    }
  ]
})
