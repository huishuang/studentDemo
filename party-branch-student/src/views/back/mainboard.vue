<template>
  <a-layout>
    <a-layout-content
      :style="{ margin: '24px 16px', padding: '24px', background: '#fff', minHeight: '800px'}"
    >
      <div>
        <a-row type="flex">
          <a-col :span="24" style="height:50px;font-size:20px;font-weight:bold;text-align:center">报名流程</a-col>
        </a-row>
        <a-row type="flex">
          <a-col :span="24" style="height:200px">
            <a-row>
              <a-col style="height:50px">
              </a-col>
            </a-row>
            <a-row>
              <a-col style="height:150px">
                <span v-show="mystep">暂未选择学生</span>
                <a-steps :current="stepnum" v-model="stepnum" v-show="mysteps">
                  <a-popover slot="progressDot" slot-scope="{index, status, prefixCls}">
                    <template slot="content">
                      <span>step {{ index }} status: {{ status }}</span>
                    </template>
                    <span :class="`${prefixCls}-icon-dot`"></span>
                  </a-popover>
                  <a-step title="1招生办" description="1.1报到  1.2注册" />
                  <a-step title="2财务处" description="2.1学费  2.2杂费  2.3保险" />
                  <a-step title="3学工处" description="3.1档案  3.2组织关系  3.3户籍" />
                  <a-step title="4舍务、备品" description="4.1行李  4.2盆  4.3暖瓶" />
                  <a-step title="5服装发放" description="5.1军训服  5.2运动服  5.3夏季装" />
                  <a-step title="6寝室分配" description="6.1栋  6.2层  6.3号" />
                </a-steps>
              </a-col>
            </a-row>
          </a-col>
        </a-row>
        <a-row type="flex">
          <a-col :span="24" style="height:50px">
            <a-row :gutter="2" justify="center">
              <a-col class="gutter-row" :span="5">
                学院：
                <a-select
                  @change="handleSelectChangeCollege"
                  style="width: 160px"
                  placeholder="请选择..."
                >
                  <a-select-option value="---请选择---">---请选择---</a-select-option>
                  <a-select-option v-for="college in collegeList" :value="college.collegeName" :key="college.collegeName">
                    {{ college.collegeName }}
                  </a-select-option>
                </a-select>
              </a-col>
              <a-col class="gutter-row" :span="5">
                专业：
                <a-select
                  @change="handleSelectChangeMajor"
                  style="width: 160px"
                  placeholder="请选择..."
                >
                  <a-select-option value="---请选择---">---请选择---</a-select-option>
                  <a-select-option v-for="major in majorList" :value="major.majorName" :key="major.majorName">
                    {{ major.majorName }}
                  </a-select-option>
                </a-select>
              </a-col>
              <a-col class="gutter-row" :span="5">
                班级：
                <a-select
                  @change="handleSelectChangeClassId"
                  style="width: 160px"
                  placeholder="请选择..."
                >
                  <a-select-option value="---请选择---">---请选择---</a-select-option>
                  <a-select-option v-for="cla in classList" :value="cla.classId" :key="cla.classId">
                    {{ cla.classId }}
                  </a-select-option>
                </a-select>
              </a-col>
              <a-col class="gutter-row" :span="5">
                学号：
                <a-input
                  placeholder="请选择..."
                  type="text"
                  style="width: 160px"
                  v-model="studentId"
                />
              </a-col>
              <a-col class="gutter-row" :span="2">
                <a-button type="primary" style="width: 80px" @click="handleSearch">查询</a-button>
              </a-col>
              <a-col class="gutter-row" :span="2">
                <div class="gutter-box">
                  <a-button type="primary" style="width: 80px" @click="resetting">重置</a-button>
                </div>
              </a-col>
            </a-row>
          </a-col>
        </a-row>
        <a-row type="flex">
          <a-col :span="24" style="height:30px">
            <a-row>
              <a-col class="gutter-row" :span="3">
                <div class="gutter-box">
                  <a-button type="primary" style="width: 100px" @click="showModalAdd">添加</a-button>
                </div>
                <a-modal title="添加学生" v-model="visible1" @ok="handleSubmit">
                  <a-form :form="form" @submit="handleSubmit">
                    <a-form-item label="学号" :label-col="{ span: 7 }" :wrapper-col="{ span: 12 }">
                      <a-input
                        v-decorator="['studentId', { rules: [{ required: true, message: '请输入你的学号！' }] }]"
                      />
                    </a-form-item>
                    <a-form-item label="姓名" :label-col="{ span: 7 }" :wrapper-col="{ span: 12 }">
                      <a-input
                        v-decorator="['studentName', { rules: [{ required: true, message: '请输入你的姓名！' }] }]"
                      />
                    </a-form-item>
                    <a-form-item label="学院" :label-col="{ span: 7 }" :wrapper-col="{ span: 12 }">
                      <a-select
                        v-decorator="[
                          'studentCollege',
                          { rules: [{ required: true, message: '请选择你的学院！' }] },
                        ]"
                        placeholder="请选择..."
                        @change="handleSelectChangeCollege"
                      >
                        <a-select-option v-for="college in collegeList" :value="college.collegeName" :key="college.collegeName">
                          {{ college.collegeName }}
                        </a-select-option>
                      </a-select>
                    </a-form-item>
                    <a-form-item label="专业" :label-col="{ span: 7 }" :wrapper-col="{ span: 12 }">
                      <a-select
                        v-decorator="[
                          'studentMajor',
                          { rules: [{ required: true, message: '请选择你的专业！' }] },
                        ]"
                        placeholder="请选择..."
                        @change="handleSelectChangeMajor"
                      >
                        <a-select-option v-for="major in majorList" :value="major.majorName" :key="major.majorName">
                          {{ major.majorName }}
                        </a-select-option>
                      </a-select>
                    </a-form-item>
                    <a-form-item label="性别" :label-col="{ span: 7 }" :wrapper-col="{ span: 12 }">
                      <a-select
                        v-decorator="[
                          'sex',
                          { rules: [{ required: true, message: '请选择你的性别！' }] },
                        ]"
                        placeholder="请选择..."
                        @change="handleSelectChangeSex"
                      >
                        <a-select-option value="男">
                          男
                        </a-select-option>
                        <a-select-option value="女">
                          女
                        </a-select-option>
                      </a-select>
                    </a-form-item>
                    <a-form-item label="班级" :label-col="{ span: 7 }" :wrapper-col="{ span: 12 }">
                      <a-select
                        v-decorator="[
                          'classId',
                          { rules: [{ required: true, message: '请选择你的班级！' }] },
                        ]"
                        placeholder="请选择..."
                        @change="handleSelectChangeClassId"
                      >
                        <a-select-option v-for="cla in classList" :value="cla.classId" :key="cla.classId">
                          {{ cla.classId }}
                        </a-select-option>
                      </a-select>
                    </a-form-item>
                  </a-form>
                </a-modal>
              </a-col>
              <a-col class="gutter-row" :span="3">
                <div class="gutter-box">
                  <a-button type="primary" style="width: 100px" @click="showModalAdds">批量添加</a-button>
                </div>
                <a-modal title="批量添加" v-model="visible2" @ok="handleAdds">
                  <a-upload-dragger
                    name="file"
                    :multiple="true"
                    action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
                    @change="handleChangeUpload"
                  >
                    <p class="ant-upload-drag-icon">
                      <a-icon type="inbox" />
                    </p>
                    <p class="ant-upload-text">点击或将文件拖拽到这里上传</p>
                    <p class="ant-upload-hint">
                      支持扩展名：.excel..
                    </p>
                  </a-upload-dragger>
                </a-modal>
              </a-col>
              <a-col class="gutter-row" :span="3">
                <div class="gutter-box">
                  <a-button type="primary" style="width: 100px" @click="deleteselected">批量删除</a-button>
                </div>
              </a-col>
              <a-col class="gutter-row" :span="15">
              </a-col>
            </a-row>
          </a-col>
        </a-row>
        <a-row type="flex">
          <a-col :span="24">
            <a-row>
              <a-col>
                <span style="margin-left: 8px">
                </span>
              </a-col>
              <a-col>
                <div>
                  <a-table
                    :rowSelection="{selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
                    :columns="columns"
                    :dataSource="studentList"
                    :rowKey="record => record.studentId"
                  >
                    <template slot="operation" slot-scope="text, record">
                      <a-button type="primary" @click="showstep(record.studentId)">进度</a-button>
                      <a-button type="primary" @click="showflow(record.studentId)">流程</a-button>
                      <a-popconfirm
                        v-if="studentList.length"
                        title="确认删除吗?"
                        @confirm="() => deleteOne(record.studentId)"
                      >
                        <a-button type="primary">删除</a-button>
                      </a-popconfirm>
                      <a-button type="primary" @click="showprintpdf(record.studentId)">打印</a-button>
                    </template>
                  </a-table>
                  <a-modal title="学生办理信息" v-model="visible4" @ok="printpdf">
                    <div class="row" id="pdfDom" style="padding-top: 30px;background-color:#fff;">
                      <table align="center" valign="center" border="1px" width="400px">
                        <tr>
                          <th colspan="4"><center>新生报到电子回执单</center></th>
                        </tr>
                        <tr>
                          <td>学院</td>
                          <td>{{ this.acollege }}</td>
                          <td>专业</td>
                          <td>{{ this.amajor }}</td>
                        </tr>
                        <tr>
                          <td>班级</td>
                          <td>{{ this.aclass }}</td>
                          <td>姓名</td>
                          <td>{{ this.astudentname }}</td>
                        </tr>
                        <tr>
                          <td>学号</td>
                          <td>{{ this.astudentid }}</td>
                          <td>性别</td>
                          <td>{{ this.asex }}</td>
                        </tr>
                        <tr>
                          <th colspan="4"><center>已完成项目</center></th>
                        </tr>
                        <tr>
                          <th colspan="2">部门</th>
                          <th colspan="2">流程</th>
                        </tr>
                        <tr v-for="site in this.scheduleListone" :key="site.studentId">
                          <td v-text="site.departmentName" colspan="2"></td>
                          <td v-text="site.scheduleName" colspan="2"></td>
                        </tr>
                      </table>
                    </div><br>
                    <center><button type="button" class="btn btn-primary" @click="getPdf()">导出PDF</button></center>
                  </a-modal>
                  <a-modal title="流程选择" v-model="visible3" @ok="handelechange">
                    <a-select
                      v-decorator="[
                        'departmentName',
                        { rules: [{ required: true}] },
                      ]"
                      style="width: 470px"
                      @change="handleSelectChangeDepartment"
                    >
                      <a-select-option v-for="department in departmentList" :key="department.departmentName">
                        {{ department.departmentName }}
                      </a-select-option>
                    </a-select>
                    <br><br>
                    <a-select
                      v-decorator="[
                        'scheduleName',
                        { rules: [{ required: true}] },
                      ]"
                      style="width: 470px"
                      @change="handleSelectChangeSchedule"
                    >
                      <a-select-option v-for="schedule in Schedules" :key="schedule.scheduleName" :value="schedule.scheduleName">
                        {{ schedule.scheduleName }}
                      </a-select-option>
                    </a-select>
                  </a-modal>
                </div>
              </a-col>
            </a-row>
          </a-col>
        </a-row>
      </div>
    </a-layout-content>
  </a-layout>
</template>
<script>
import { findAllStudent, deleteByStudentSelected, deleteByStudentId, addStudent,
  findByStudentId, findByStudentCollege, findByStudentCollegeAndStudentMajor,
  findByStudentCollegeAndStudentMajorAndClassId, addFlow,
  findByDepartmentName, findMajorByCollegeName, findClassIdByMajorName, findScheduleByStudentId, findAllScheduleByStudentId } from '@/api/mainboard'

const columns = [
  {
    title: '学号',
    dataIndex: 'studentId',
    width: '8%'
  },
  {
    title: '姓名',
    dataIndex: 'studentName',
    width: '8%'
  },
  {
    title: '性别',
    dataIndex: 'sex',
    width: '6%'
  },
  {
    title: '院系',
    dataIndex: 'studentCollege',
    width: '20%'
  },
  {
    title: '专业',
    dataIndex: 'studentMajor',
    width: '14%'
  },
  {
    title: '班级',
    dataIndex: 'classId',
    width: '8%'
  },
  {
    title: '操作',
    dataIndex: 'operation',
    // 直接对应插槽名为operation的模板
    scopedSlots: { customRender: 'operation' }
  }
]
export default {
  name: 'MainBoard',
  data () {
    return {
      studentList: [],
      studentListone: [],
      scheduleListone: [],
      acollege: '',
      amajor: '',
      aclass: '',
      astudentid: '',
      astudentname: '',
      asex: '',
      columns,
      checkNick: false,
      visible1: false,
      visible2: false,
      visible3: false,
      visible4: false,
      htmlTitle: '页面导出PDF文件名',
      formLayout: 'horizontal',
      form: this.$form.createForm(this, { name: 'coordinated' }),
      selectedRowKeys: [],
      studentCollege: '',
      studentMajor: '',
      classId: '',
      studentId: '',
      departmentName: '',
      mystep: true,
      mysteps: false,
      collegeList: [],
      majorList: [],
      classList: [],
      departmentList: [],
      FlowList: [],
      Schedules: [],
      temp: '',
      stepnum: 0
    }
  },
  computed: {
  },
  created () {
    this.axios.get('/api/findAllStudent').then((res) => {
      if (res.status) {
        var data = JSON.parse(res.data)
        this.studentList = data
      }
    })
    this.axios.get('/api/findAllDepartment').then((res) => {
      if (res.status) {
        var Department = JSON.parse(res.data)
        this.departmentList = Department
      }
    })
    this.axios.get('/api/findAllFlow').then((res) => {
      if (res.status) {
        var flow = JSON.parse(res.data)
        this.FlowList = flow
      }
    })
    this.axios.get('/api/findAllCollege').then((res) => {
      if (res.status) {
        var College = JSON.parse(res.data)
        this.collegeList = College
      }
    })
  },
  methods: {
    handleSearch () {
      var param = {
        'studentCollege': this.studentCollege,
        'studentMajor': this.studentMajor,
        'classId': this.classId,
        'studentId': this.studentId
      }

      if (this.studentCollege !== '' && this.studentCollege !== '---请选择---' && this.studentId === '') {
        if (this.studentMajor !== '' && this.studentMajor !== '---请选择---' && this.studentId === '') {
          if (this.classId !== '' && this.classId !== '---请选择---' && this.studentId === '') {
            findByStudentCollegeAndStudentMajorAndClassId(param).then((res) => {
              if (res.status) {
                this.studentList = JSON.parse(res.data)
              } else {
                this.$message.info('学生不存在')
              }
            })
          } else {
            findByStudentCollegeAndStudentMajor(param).then((res) => {
              if (res.status) {
                this.studentList = JSON.parse(res.data)
              } else {
                this.$message.info('学生不存在')
              }
            })
          }
        } else {
          findByStudentCollege(param).then((res) => {
            if (res.status) {
              this.studentList = JSON.parse(res.data)
            } else {
              this.$message.info('学生不存在')
            }
          })
        }
      } else if ((this.studentCollege === '' || this.studentCollege === '---请选择---') && (this.studentMajor === '' || this.studentMajor === '---请选择---') && (this.classId === '' || this.classId === '---请选择---')) {
        findByStudentId(param).then((res) => {
          if (res.status) {
            this.studentList = JSON.parse(res.data)
          } else {
            this.$message.info('学生不存在')
          }
        })
      }
    },
    resetting () {
      findAllStudent()
        .then((res) => {
          if (res.status) {
            var data = JSON.parse(res.data)
            this.studentList = data
          }
        })
    },
    handleSubmit (e) {
      e.preventDefault()
      this.form.validateFieldsAndScroll((err, values) => {
        if (!err) {
          var params = {
            'studentId': values.studentId,
            'studentName': values.studentName,
            'sex': values.sex,
            'studentCollege': values.studentCollege,
            'studentMajor': values.studentMajor,
            'classId': values.classId
          }
          addStudent(params)
            .then((res) => {
              if (res.status) {
                var data = JSON.parse(res.data)
                this.studentList = data
                this.visible1 = false
                this.$message.info('添加成功')
              } else {
                this.$message.info('学生已存在')
              }
            })
          this.studentMajor = ''
          this.classId = ''
        }
      })
    },
    onSelectChange (selectedRowKeys) {
      this.selectedRowKeys = selectedRowKeys
    },
    showModalAdd () {
      this.visible1 = true
    },
    showModalAdds () {
      this.visible2 = true
    },
    handleAdds (e) {
      this.visible2 = false
    },
    handleSelectChangeCollege (value) {
      this.studentCollege = value
      var param = {
        'collegeName': value
      }
      findMajorByCollegeName(param).then((res) => {
        if (res.status) {
          this.majorList = JSON.parse(res.data)
        } else {
          this.majorList = null
        }
      })
    },
    handleSelectChangeMajor (value) {
      this.studentMajor = value
      var param = {
        'majorName': value
      }
      findClassIdByMajorName(param).then((res) => {
        if (res.status) {
          this.classList = JSON.parse(res.data)
        } else {
          this.classList = null
        }
      })
    },
    handleSelectChangeSex (value) {
      this.sex = value
    },
    handleSelectChangeClassId (value) {
      this.classId = value
    },
    handleChangeUpload (info) {
      const status = info.file.status
      if (status !== 'uploading') {
        console.log(info.file, info.fileList)
      }
      if (status === 'done') {
        this.$message.success(`${info.file.name} 文件上传成功`)
      } else if (status === 'error') {
        this.$message.error(`${info.file.name} 文件上传失败`)
      }
    },
    deleteOne (studentId) {
      deleteByStudentId(studentId)
        .then((res) => {
          var data = JSON.parse(res.data)
          this.studentList = data
        })
    },
    deleteselected () {
      var params = []
      params = this.selectedRowKeys
      if (params.length === 0) {
        this.$message.info('请选择你想要删除的学生')
      } else {
        deleteByStudentSelected(params)
          .then((res) => {
            var data = JSON.parse(res.data)
            this.studentList = data
            this.selectedRowKeys.length = 0
          })
      }
    },
    handelechange (e) {
      this.visible3 = false
    },
    printpdf (e) {
      this.visible4 = false
    },
    handleSelectChangeDepartment (value) {
      var param = {
        'departmentName': value,
        'studentId': this.studentId
      }
      findByDepartmentName(param).then((res) => {
        if (res.status) {
          this.Schedules = JSON.parse(res.data)
        }
      })
      this.departmentName = value
    },
    handleSelectChangeSchedule (value) {
      this.scheduleId = value
      var param = {
        'departmentName': this.departmentName,
        'scheduleName': value,
        'studentId': this.studentId
      }
      addFlow(param).then((res) => {
        if (res.status) {
          this.$message.info('学生已办完该流程')
        } else {
          if (res.data === '请按顺序办理流程') {
            this.$message.info('请按顺序办理流程')
          } else {
            this.$message.info(res.data)
          }
        }
      })
    },
    showflow (studentId) {
      this.visible3 = true
      this.studentId = studentId
    },
    showprintpdf (studentId) {
      this.visible4 = true
      this.studentId = studentId
      var param = {
        'studentId': studentId
      }
      findByStudentId(param).then((res) => {
        if (res.status) {
          this.studentListone = JSON.parse(res.data)
          this.acollege = this.studentListone[0].studentId
          this.amajor = this.studentListone[0].studentMajor
          this.aclass = this.studentListone[0].classId
          this.astudentid = this.studentListone[0].studentId
          this.astudentname = this.studentListone[0].studentName
          this.asex = this.studentListone[0].sex
        }
      })
      findAllScheduleByStudentId(param).then((res) => {
        if (res.status) {
          this.scheduleListone = JSON.parse(res.data)
        } else {
          this.scheduleListone = null
        }
      })
    },
    showstep (studentId) {
      this.mystep = false
      this.mysteps = true
      var param = {
        'studentId': studentId
      }
      findScheduleByStudentId(param).then((res) => {
        if (res.data === '招生办') {
          this.stepnum = 0
        } else if (res.data === '财务处') {
          this.stepnum = 1
        } else if (res.data === '学工处') {
          this.stepnum = 2
        } else if (res.data === '舍务、备品') {
          this.stepnum = 3
        } else if (res.data === '服装发放') {
          this.stepnum = 4
        } else if (res.data === '寝室分配') {
          this.stepnum = 5
        }
      })
    }
  }
}
</script>
<style>
  .components-input-demo-size .ant-input {
    width: 160px;
    margin: 0 8px 8px 0;
  }
</style>
