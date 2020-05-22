<template>
    <div id="list">
      用户列表
      <table >
            <th><td>编号</td><td>名字</td><td>url</td><td>操作</td>>/th>
            <tr v-for="user in users">
                <td>{{user.id}}</td>
                <td>{{user.name}}</td>
                <td>{{user.url}}</td>
                <td><a href="#" @click="update(user.id)">update</a> | <a href="#" @click="remove(user.id)">delete</a></td>
            </tr>
        </table>
    </div>
</template>

<script>

    export default {
      name: "UserList",
      data () {
        return {
          users:[
            {
              "id":"1",
              "name":"2",
              "url":"3"
            }
          ]
        }
      },
      beforeRouteEnter: (to, from, next) => {
        // debugger;
        console.log("准备进入用户列表");
        next();
        // 注意，一定要在 next 中请求，因为该方法调用时 Vue 实例还没有创建，此时无法获取到 this 对象，在这里使用官方提供的回调函数拿到当前实例
        next(vm => {
          vm.getData();
        });
      },
      beforeRouteLeave: (to, from, next) => {
        console.log("准备离开用户列表");
        next();
      },
      methods: {
        getData: function (){
          const _this = this;
          this.axios({
            method: 'get',
            url: 'http://localhost:3000/users'
          }).then(function (reps) {
            debugger;
            _this.users = reps.data;
          }).catch(function (error) {
            console.log(error);
          });
        },
        remove
      }
    }
</script>

<style scoped>

</style>
