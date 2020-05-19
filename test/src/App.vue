<template>
  <div id="app">
    <router-link to="/login">登陆</router-link>
    <router-link to="/helloWorld">首页</router-link>
    <router-view></router-view>
    <!--<img src="./assets/logo.png">-->
    <HelloWorld/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld'

export default {
  name: 'App',
  mounted(){
    // window.addEventListener('beforeunload',this.saveState);
    window.addEventListener('unload',evt => {
      sessionStorage.setItem('user',sessionStorage.getItem('user'));
    });
  },
  methods:{
    // saveState(){
    //   sessionStorage.setItem('user',JSON.stringify(this.$store.state));
    // }
  },
  components: {
    HelloWorld
  }
}
</script>

<style scoped>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
