<template>
    <!-- <div>  -->
      
       <el-table :data="users" stripe border style="width: 100%">
          用户列表
      <el-table-column fixed prop="id" label="编号" min-width="10%"></el-table-column>
      <el-table-column prop="name" label="名字" min-width="10%"></el-table-column>
      <el-table-column prop="url" label="url" min-width="10%"></el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="remove(scope.row.id)" type="text" size="small">删除</el-button>
          <!-- <el-button type="text" size="small">编辑</el-button> -->
        </template>
     </el-table-column>
      <!-- <el-table-column><a href="#" @click="remove(user.id)">删除</a></el-table-column> -->
    </el-table>
      <!-- <table >
            <th><td>编号</td><td>名字</td><td>url</td><td>操作</td></th>
            <tr v-for="user in users">
                <td>{{user.id}}</td>
                <td>{{user.name}}</td>
                <td>{{user.url}}</td>
                <td><a href="#" @click="remove(user.id)">删除</a></td>
             </tr>
        </table> -->
    <!-- </div> -->
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
          this.axios.get('http://localhost:3000/users')
          .then((res)=>{
              _this.users = res.data;
          });
          // this.axios({
          //   method: 'get',
          //   url: 'http://localhost:3000/users'
          // }).then(function (reps) {
          //   _this.users = reps.data;
          // }).catch(function (error) {
          //   console.log(error);
          // });
        },
        remove:function(index){
          // debugger;
          this.axios.delete('http://localhost:3000/users/'+index)
          .then((res)=>{
            if(res.status == 200){
              // debugger;
              // alert("删除成功");
              this.getData();
            }else{
              console.log(index+"删除失败");
            }
          });
        }
      }
    }
</script>

<style scoped>

</style>
