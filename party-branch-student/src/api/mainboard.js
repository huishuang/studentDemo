import { axios } from '@/utils/request'

export function findAllStudent () {
  return axios({
    methods: 'get',
    url: '/api/findAllStudent',
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}

export function deleteByStudentSelected (params) {
  var form = new FormData()
  form.append('studentSelected', params)
  return axios({
    url: '/api/deleteByStudentSelected',
    method: 'post',
    data: form
  })
}

export function deleteByStudentId (studentId) {
  var form = new FormData()
  form.append('studentId', studentId)
  return axios({
    url: '/api/deleteByStudentId',
    method: 'post',
    data: form,
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  })
}

export function addStudent (params) {
  var form = new FormData()
  form.append('studentId', params.studentId)
  form.append('studentName', params.studentName)
  form.append('sex', params.sex)
  form.append('studentCollege', params.studentCollege)
  form.append('studentMajor', params.studentMajor)
  form.append('classId', params.classId)
  return axios({
    url: '/api/addStudent',
    method: 'post',
    data: form,
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  })
}

export function findByStudentId (params) {
  return axios({
    url: '/api/findByStudentId',
    method: 'get',
    params: {
      'studentId': params.studentId
    }
  })
}

export function findByStudentCollege (params) {
  return axios({
    url: '/api/findByStudentCollege',
    method: 'get',
    params: {
      'studentCollege': params.studentCollege
    }
  })
}

export function findByStudentCollegeAndStudentMajor (params) {
  return axios({
    url: '/api/findByStudentCollegeAndStudentMajor',
    method: 'get',
    params: {
      'studentCollege': params.studentCollege,
      'studentMajor': params.studentMajor
    }
  })
}

export function findByStudentCollegeAndStudentMajorAndClassId (params) {
  return axios({
    url: '/api/findByStudentCollegeAndStudentMajorAndClassId',
    method: 'get',
    params: {
      'studentCollege': params.studentCollege,
      'studentMajor': params.studentMajor,
      'classId': params.classId
    }
  })
}

export function findAllDepartment () {
  return axios({
    methods: 'get',
    url: '/api/findAllDepartment',
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}

export function findAllFlow () {
  return axios({
    methods: 'get',
    url: '/api/findAllFlow',
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}

export function findAllCollege () {
  return axios({
    methods: 'get',
    url: '/api/findAllCollege',
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}

export function findAllMajor () {
  return axios({
    methods: 'get',
    url: '/api/findAllMajor',
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}

export function findAllClass () {
  return axios({
    methods: 'get',
    url: '/api/findAllClass',
    headers: {
      'Content-Type': 'multipart/form-data'
    }
  })
}

export function findByDepartmentNameAndScheduleNameAndStudentId (params) {
  return axios({
    url: '/api/findByDepartmentNameAndScheduleNameAndStudentId',
    method: 'get',
    params: {
      'departmentName': params.departmentName,
      'scheduleName': params.scheduleName,
      'studentId': params.studentId
    }
  })
}

export function addFlow (params) {
  var form = new FormData()
  form.append('departmentName', params.departmentName)
  form.append('scheduleName', params.scheduleName)
  form.append('studentId', params.studentId)
  return axios({
    url: '/api/addFlow',
    method: 'post',
    data: form,
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  })
}

export function findByDepartmentName (params) {
  return axios({
    url: '/api/findByDepartmentName',
    method: 'get',
    params: {
      'departmentName': params.departmentName
    }
  })
}

export function findMajorByCollegeName (params) {
  return axios({
    url: '/api/findMajorByCollegeName',
    method: 'get',
    params: {
      'collegeName': params.collegeName
    }
  })
}

export function findClassIdByMajorName (params) {
  return axios({
    url: '/api/findClassIdByMajorName',
    method: 'get',
    params: {
      'majorName': params.majorName
    }
  })
}

export function findScheduleByStudentId (params) {
  return axios({
    url: '/api/findScheduleByStudentId',
    method: 'get',
    params: {
      'studentId': params.studentId
    }
  })
}

export function findAllScheduleByStudentId (params) {
  return axios({
    url: '/api/findAllScheduleByStudentId',
    method: 'get',
    params: {
      'studentId': params.studentId
    }
  })
}
