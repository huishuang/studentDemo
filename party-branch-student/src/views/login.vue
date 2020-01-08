<template>
  <div class="maincenter">
    <a-form
      id="components-form-demo-normal-login"
      :form="form"
      class="login-form"
      @submit="handleSubmit"
    >
      <a-form-item style="font-size: 20px; font-weight:bold; text-align:center">
        登录
      </a-form-item>
      <a-form-item>
        <a-input
          v-decorator="[
            'userId',
            { rules: [{ required: true, message: 'Please input your userId!' }] },
          ]"
          placeholder="请输入用户名"
        >
          <a-icon slot="prefix" type="user" style="color: rgba(0,0,0,.25)" />
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-input
          v-decorator="[
            'password',
            { rules: [{ required: true, message: 'Please input your Password!' }] },
          ]"
          type="password"
          placeholder="请输入用户密码"
        >
          <a-icon slot="prefix" type="lock" style="color: rgba(0,0,0,.25)" />
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-checkbox
          v-decorator="[
            'remember',
            {
              valuePropName: 'checked',
              initialValue: true,
            },
          ]"
        >
        记住密码
        </a-checkbox>
        <a class="login-form-forgot" href="">
          忘记密码？
        </a>
        <a-button @click="handleSubmit" type="primary" html-type="submit" class="login-form-button">
          登录
        </a-button>
        <a href="">
          注册
        </a>
      </a-form-item>
    </a-form>
  </div>
</template>

<script>
import { login, isLogin, logout } from '@/api/login'
import { Userlogin } from '@/api/file'
import router from '../router'
export default {
  name: 'Login',
  beforeCreate () {
    this.form = this.$form.createForm(this, { name: 'normal_login' })
  },
  methods: {
    handleSubmit (e) {
      e.preventDefault()
      this.form.validateFields((err, values) => {
        if (!err) {
          var params = {
            'userId': values.userId,
            'password': values.password
          }
          Userlogin(params).then((res) => {
            if (res.status) {
              login(values.userId, values.password)
              if (isLogin()) {
                this.$store.dispatch('GenerateRoutes')
                this.$router.push("/back/mainBoard")
              }
            } else {
              this.$message.info('用户名或密码错误！')
            }
          })
        }
      })
    }
  }
}
</script>
<style>
.maincenter {
  border:1px solid #dcdfe6;
  position: fixed;
  top: 20%;
  left: 39%;
  width: 22%;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 0 18px
}
#components-form-demo-normal-login .login-form {
  max-width: 300px;
}
#components-form-demo-normal-login .login-form-forgot {
  float: right;
}
#components-form-demo-normal-login .login-form-button {
  width: 100%;
}
</style>

