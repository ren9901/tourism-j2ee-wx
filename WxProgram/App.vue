<script>
	export default {
		onLaunch: async function(e) {
			// 检测是否可以调用getUpdateManager检查更新
			if (!uni.canIUse("getUpdateManager")) return;
			const updateManager = uni.getUpdateManager();
			// console.log(updateManager)
			// 获取全局唯一的版本更新管理器，用于管理小程序更新
			updateManager.onCheckForUpdate(function(res) {
				// 监听向微信后台请求检查更新结果事件 
				console.log("是否有新版本：" + res.hasUpdate);
				if (res.hasUpdate) {
					//如果有新版本                
					// 小程序有新版本，会主动触发下载操作        
					updateManager.onUpdateReady(function() {
						//当新版本下载完成，会进行回调          
						uni.showModal({
							title: '更新提示',
							content: '新版本已经准备好，单击确定重启小程序',
							showCancel: false,
							success: function(res) {
								if (res.confirm) {
									// 新的版本已经下载好，调用 applyUpdate 应用新版本并重启小程序               
									updateManager.applyUpdate();
								}
							}
						})
					})
					// 小程序有新版本，会主动触发下载操作       
					updateManager.onUpdateFailed(function() {
						//当新版本下载失败，会进行回调          
						uni.showModal({
							title: '提示',
							content: '检查到有新版本，但下载失败，请稍后尝试',
							showCancel: false,
						})
					})
				}
			});
		},
		onShow: function() {},
		onHide: function() {console.log('App Hide')},
		globalData: {
			userinfo: null,
			token:'',
		},
	}
</script>

<style lang="scss">
	/*每个页面公共css */
	@import "@/uni_modules/uview-ui/index.scss";
	@import "colorui/main.css";
	@import "colorui/icon.css";
</style>
