<template>

</template>

<script>
  export default {
    name:"Out",
    created() {
      sessionStorage.removeItem("user");
      alert("用户退出")
      this.$router.push("/login");
    }
  }
</script>
