<template>
  <div class="user-wrapper">
    <div>
      <a-row>
        <a-col>
          <a-dropdown>
            <span class="action ant-dropdown-link user-dropdown-menu">
              <a-avatar class="avatar" size="small" :src="avatar()"/>
              <span>{{ nickname() }}</span>
            </span>
            <a-menu slot="overlay" class="user-dropdown-menu-wrapper">
              <a-menu-item key="0">
                <router-link :to="{ name: 'Back' }">
                  <a-icon type="user"/>
                  <span>个人中心</span>
                </router-link>
              </a-menu-item>
              <a-menu-divider/>
              <a-menu-item key="3">
                <a href="javascript:;" @click="handleLogout">
                  <a-icon type="logout"/>
                  <span>退出登录</span>
                </a>
              </a-menu-item>
            </a-menu>
          </a-dropdown>
        </a-col>
      </a-row>
    </div>
  </div>
</template>

<script>
import NoticeIcon from '@/components/NoticeIcon'
import { mapActions, mapGetters } from 'vuex'

export default {
  name: 'UserMenu',
  components: {
    NoticeIcon
  },
  methods: {
    ...mapActions(['Logout']),
    ...mapGetters(['nickname', 'avatar']),
    handleLogout () {
      var that = this
      this.$confirm({
        title: '提示',
        content: '真的要注销登录吗 ?',
        onOk () {
          that.Logout({})
          that.$router.push({ path: '/' })
        },
        onCancel () {
        }
      })
    }
  }
}
</script>
