import { axios } from '@/utils/request'

// 用户登录
export function Userlogin (params) {
  var form = new FormData()
  form.append('userId', params.userId)
  form.append('password', params.password)
  return axios({
    url: '/api/login',
    method: 'post',
    data: form,
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}
