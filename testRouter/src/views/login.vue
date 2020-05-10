<template>
    <div>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px" class="login-box">
        <el-form-item label="账号" prop="name">
          <el-input type="text" placeholder="请输入账号"  v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" placeholder="请输入密码"  v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit('form')">登陆</el-button>
        </el-form-item>
      </el-form>
    </div>
</template>

<script>
    export default {
        name: "login"
    }
</script>

<script>
  export default {
    name:"Login",
    data() {
      return {
        form: {
          name: '',
          password: ''
        },
  rules: {
    name: [
      { required: true, message: '请输入名称', trigger: 'blur' },
      { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
    ],
   password: [
      { required: true, message: '请输入密码', trigger: 'change' }
    ]
  }};
  },
    methods: {
      onSubmit(formName) {
        this.$refs[formName].validate((valid) =>{
          if (valid){
            this.$router.push("/main");
          }else {
            console.log('error!');
            return false;
          }
        })
      }
    }
  }
</script>

<!--<style lang="scss" >-->
<style>
.login-box{
    width: 350px;
    margin: 180px auto;
    padding: 35px;
    border: 1px solid #DCDFF6;
    box-shadow: 0 0 25px #DCDFF6;
  }
</style>
