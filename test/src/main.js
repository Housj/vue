// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import Vuex from 'vuex'

Vue.config.productionTip = false;

Vue.use(ElementUI);
Vue.use(Vuex);

router.beforeEach((to, form, next) => {

  // 获取用户登录状态
  let isLogin = sessionStorage.getItem('user');
  // debugger;
  // 注销
  if (to.path == '/logout') {
    // 清空
    sessionStorage.clear();

    // 跳转到登录
    next({path: '/login'});
  }

  // 如果请求的是登录页
  else if (to.path == '/' || to.path == '/login') {

    if (isLogin == 1) {
      // 跳转到首页
      next({path: '/main'});
    }
  }

  // 如果为非登录状态
  else if (isLogin != 1) {

    // 跳转到登录页
    next({path: '/login'});
  }

  // 下一个路由
  next();
});

Vue.use(router);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
  // 在跳转前执行
})
