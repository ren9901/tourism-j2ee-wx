<template>
  <div class="app-container home">
    <el-row :gutter="20">
    <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <h2>Hello,Guest</h2>
            <span>微信小程序请扫描以下二维码</span>
            <br>
            <span>陆陆续续收到一些打赏，为了更好的体验已用于演示服务器升级。谢谢各位小伙伴</span>
          </div>
          <div class="body">
            <img
              src="../assets/images/qr_coder.jpg"
              alt="donate"
              width="100%"
            />
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
            <h2>RuoYi-Vue-Uniapp微信小程序脚手架</h2>
            <p>
              一直想做一款基于若依后台管理系统的微信小程序，最近比较闲了，所以想做个简单的东西。主要为了学习，走一遍整个过程，也是为像我这种小白提供些简单的学习内容。
            </p>
            <p>
              <b>当前版本:</b> <span>v1.0</span>
            </p>
            <p>
              <el-tag type="danger">&yen;完全免费开源</el-tag>
            </p>
            <p>
              <el-button
                type="primary"
                size="mini"
                icon="el-icon-cloudy"
                plain
                @click="goTarget('https://gitee.com/y_project/RuoYi-Vue')"
                >访问码云</el-button
              >
              <el-button
                size="mini"
                icon="el-icon-s-home"
                plain
                @click="goTarget('http://ruoyi.vip')"
                >访问主页</el-button
              >
            </p>
            </el-card>
      </el-col>

   <el-col :xs="24" :sm="24" :md="12" :lg="8">
      <el-card class="update-log">
                <el-row>
                  <el-col :span="12">
                    <h2>技术选型</h2>
                  </el-col>
                </el-row>
                <el-row>
                  <el-col :span="6">
                    <h4>后端技术</h4>
                    <ul>
                      <li>SpringBoot</li>
                      <li>Spring Security</li>
                      <li>JWT</li>
                      <li>MyBatis</li>
                      <li>Druid</li>
                      <li>Fastjson</li>
                      <li>...</li>
                    </ul>
                  </el-col>
                  <el-col :span="6">
                    <h4>前端技术</h4>
                    <ul>
                      <li>Vue</li>
                      <li>Vuex</li>
                      <li>Element-ui</li>
                      <li>Axios</li>
                      <li>Sass</li>
                      <li>Quill</li>
                      <li>...</li>
                    </ul>
                  </el-col>
                  <el-col :span="6">
                    <h4>微信小程序端</h4>
                    <ul>
                      <li>Uview2.0</li>
                      <li>ColorUI</li>
                      <li>Uniapp框架</li>
                      <li>前段铺子</li>
                    </ul>
                  </el-col>
                </el-row>
            </el-card>
      </el-col>
    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>联系信息</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-s-promotion"></i> 官网：<el-link
                href="http://www.ruoyi.vip"
                target="_blank"
                >http://www.ruoyi.vip</el-link
              >
            </p>
            <p>
              QQ群：<a style="color:red" href="https://jq.qq.com/?_wv=1027&k=T2nwpddM" target="_blank">228763221</a>
            </p>
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>更新日志</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="v1.0 - 2022-06-26">
              <ol>
                <li>体验版发布</li>
              </ol>
            </el-collapse-item>
          </el-collapse>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>捐赠支持（你可以请贡献者喝杯咖啡表示鼓励）</span>
          </div>
          <div class="body">
            <img
              src="../assets/images/pay.png"
              alt="donate"
              width="100%"
            />
            >
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.8.2",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

