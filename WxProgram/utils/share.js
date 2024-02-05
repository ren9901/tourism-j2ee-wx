/**
 * description：全局分享
 * 在项目的 main.js 文件中引入该 share.js 文件并使用 Vue.mixin() 方法将之全局混入：
 */
export default {
	data() {
		return {
			// 默认的全局分享内容
			share: {
				title: '我在使用旅游推广平台小程序，你也要不要试试呢~',//分享时的标题
				path: '/pages/index/index?shareid='+ uni.getStorageSync('token'), // 全局分享的路径，比如 首页
				imageUrl: '/static/img/share.png', // 全局分享的图片(可本地可网络)
			}
		}
	},
	// 定义全局分享
	// 1.发送给朋友
    onShareAppMessage(res) {
        return {
			title: this.share.title,
			path: this.share.path,
			imageUrl: this.share.imageUrl,
		}
    },
	//2.分享到朋友圈
    onShareTimeline(res) {
        return {
			title: this.share.title,
			path: this.share.path,
			imageUrl: this.share.imageUrl,
		}
    },
}

