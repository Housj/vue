<template>
    <div id="list">
      用户列表
      <ul>
        <li v-for="user in users">
          {{ user.id }}
          {{ user.sname }}
          {{ user.score }}
        </li>
      </ul>
    </div>
</template>

<script>

    export default {
      name: "UserList",
      data(){
        return{
          users:[
            {
              "id":"NULL",
              "sname":"NULL",
              "score":"NULL"
            }
          ]
        }
      },
      beforeRouteEnter: (to, from, next) => {
        // debugger;
        console.log("准备进入用户列表");
        next();
        // 注意，一定要在 next 中请求，因为该方法调用时 Vue 实例还没有创建，此时无法获取到 this 对象，在这里使用官方提供的回调函数拿到当前实例
        // next(vm => {
        //   vm.getData();
        // });
      },
      beforeRouteLeave: (to, from, next) => {
        console.log("准备离开用户列表");
        next();
      },
      created(){
        const _this = this;
        this.axios({
          method: 'get',
          url: 'http://192.168.1.7:8181/users'
        }).then(function (reps) {
          _this.users = reps.data;
        }).catch(function (error) {
          console.log(error);
        });
      },
      methods: {
        // getData: function (){
        //   const _this = this;
        //   this.axios({
        //     method: 'get',
        //     url: 'http://192.168.1.7:8181/users'
        //   }).then(function (reps) {
        //     this.users = reps.data;
        //   }).catch(function (error) {
        //     console.log(error);
        //   });
        // }
      }
    }
</script>

<style scoped>

</style>
