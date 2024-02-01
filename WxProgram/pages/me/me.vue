<template>
	<view>
		<view class="header">
			<view class="bg">
				<view class="box">
					<view class="box-hd" @click="login">
						<view v-if="islogin">
							<view class="avator">
								<img :src="userinfo.avatar">
							</view>
							<view class="phone-number">ID:{{userinfo.id}} 昵称：{{userinfo.nickname || '未设置昵称'}}</view>
						</view>
						<view v-else>
							<view class="avator">
								<img :src="avatarUrl">
							</view>
							<view class="phone-number" style="color: red;">请先点我登录</view>
						</view>
					</view>
					<view class="box-bd" @click="myNotice">
						<view class="item">
							<u-icon class="icon" name="volume-fill" size="25" color="#757575"></u-icon>
							<view class="text">我的通知</view>
						</view>
						<view class="item">
							<u-icon class="icon" name="star-fill" size="25" color="#757575"></u-icon>
							<view class="text">我的收藏</view>
						</view>
						<view class="item">
							<u-icon class="icon" name="server-fill" size="25" color="#757575"></u-icon>
							<view class="text">我的客服</view>
						</view>
					</view>
				</view>
			</view>
		</view>
		<view class="list-content">
			<view class="list">
				<view class="li">
					<u-icon class="icon" name="coupon-fill" size="25" color="#757575"></u-icon>
					<view class="text">我的名片</view>
					<u-icon class="icon" name="arrow-right" size="20" color="#757575"></u-icon>
				</view>
				<view class="li " @click="changeSkin">
					<u-icon class="icon" name="grid-fill" size="25" color="#757575"></u-icon>
					<view class="text">主题切换</view>
					<u-icon class="icon" name="arrow-right" size="20" color="#757575"></u-icon>
				</view>
				<view class="li ">
					<u-icon class="icon" name="question-circle-fill" size="25" color="#757575"></u-icon>
					<view class="text">帮助中心</view>
					<u-icon class="icon" name="arrow-right" size="20" color="#757575"></u-icon>
				</view>
				<view class="li ">
					<u-icon class="icon" name="info-circle-fill" size="25" color="#757575"></u-icon>
					<view class="text">关于我们</view>
					<u-icon class="icon" name="arrow-right" size="20" color="#757575"></u-icon>
				</view>
				<view class="li ">
					<u-icon class="icon" name="email-fill" size="25" color="#757575"></u-icon>
					<view class="text">意见反馈</view>
					<u-icon class="icon" name="arrow-right" size="20" color="#757575"></u-icon>
				</view>
				<view class="li noborder">
					<u-icon class="icon" name="setting-fill" size="25" color="#757575"></u-icon>
					<view class="text">系统设置</view>
					<u-icon class="icon" name="arrow-right" size="20" color="#757575"></u-icon>
				</view>
				<view class="li noborder" @click="loginOut">
					<u-icon class="icon" name="setting-fill" size="25" color="#757575"></u-icon>
					<view class="text">注销登录</view>
					<u-icon class="icon" name="arrow-right" size="20" color="#757575"></u-icon>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import {
		setUserInfo,
		getUserInfo,
		setToken,
		getToken,
		removeUserInfo,
		removeToken
	} from '@/utils/auth';
	export default {
		data() {
			return {
				avatarUrl: 'https://portrait.gitee.com/uploads/avatars/user/354/1062657_rahman_1649233036.png!avatar60',
				userinfo: {},
				islogin:false,
			}
		},
		onShow() {
			console.log(getUserInfo())
			if(getUserInfo()!=undefined){
				this.islogin = true
			}
			this.userinfo = getUserInfo() || {};
		},
		methods: {
			login() {
				let that = this
				uni.login({
					provider: 'weixin',
					success: function(loginRes) {
						let form = {};
						form.code = loginRes.code; //用户code  注:用户的code每次登录都是随机的，所以不需要进行存储
						uni.showLoading({
							title: "登录中....",
							mask: true
						})
						that.request('wxlogin', form, 'POST').then(wxloginres => {
							console.log("wxloginres: ", wxloginres)
							if (wxloginres.code==200) {
								uni.hideLoading()
								setTimeout(function() {
									uni.hideLoading();
								}, 2000);
								setToken(wxloginres.data.openid)
								setUserInfo(wxloginres.data); //模拟存储用户信息
								//成功后进入头像与昵称修改页面
								uni.navigateTo({
									url: '/pages/me/userinfo'
								})
							} else {
								uni.showToast({
									icon: "none",
									title: "登录失败，请稍后试试！",
									duration: 2000
								})
							}
						})
					},
					fail(err) {
						console.log(err)
					}
				});
			},
			myNotice() {
				uni.navigateTo({
					url: './mynotice/mynotice'
				})
			},
			loginOut() {
				uni.showModal({
					title: '注销登录提示',
					content: '确定要注销登录吗？',
					cancelText: "取消", // 取消按钮的文字
					confirmText: "确认", // 确认按钮的文字
					confirmColor: '#f55850',
					success: (res) => {
						if (res.confirm) {
							console.log('comfirm') //点击确定之后执行的代码
							uni.$u.toast("注销登录成功，欢迎再来")
							removeUserInfo()
							removeToken()
							this.islogin=false
						} else {
							console.log('cancel') //点击取消之后执行的代码
						}
					}
				})
			}
		}
	}
</script>

<style lang="scss">
	page {
		background-color: #f1f1f1;
		font-size: 28rpx;
	}

	.header {
		background: #fff;
		height: 660rpx;
		padding-bottom: 110rpx;

		.bg {
			width: 100%;
			height: 490rpx;
			padding-top: 310rpx;
			background: linear-gradient(to bottom, rgb(1, 94, 234), rgb(0, 192, 250), rgb(255, 255, 255));
		}
	}

	.box {
		width: 650rpx;
		height: 300rpx;
		border-radius: 20rpx;
		margin: 0 auto;
		background: #fff;
		box-shadow: 0 5rpx 20rpx 0rpx rgba(0, 0, 150, .2);

		.box-hd {
			display: flex;
			flex-wrap: wrap;
			flex-direction: row;
			justify-content: center;
			margin-top: 15rpx;

			.avator {
			
				width: 160rpx;
				height: 160rpx;
				background: #fff;
				border: 5rpx solid #f1f1f1;
				border-radius: 50%;
				margin: 0 auto;
				margin-top: -80rpx;
				overflow: hidden;

				img {
					width: 100%;
					height: 100%;
				}
			}

			.phone-number {
				width: 100%;
				text-align: center;
				margin: 20rpx auto;
			}
		}

		.box-bd {
			display: flex;
			flex-wrap: nowrap;
			flex-direction: row;
			justify-content: center;

			.item {
				flex: 1 1 auto;
				display: flex;
				flex-wrap: wrap;
				flex-direction: row;
				justify-content: center;
				border-right: 1px solid #f1f1f1;
				margin: 15rpx 0;

				&:last-child {
					border: none;
				}

				.icon {
					width: 60rpx;
					height: 60rpx;

					img {
						width: 100%;
						height: 100%;
					}
				}

				.text {
					width: 100%;
					text-align: center;
					margin-top: 10rpx;
				}
			}
		}
	}

	.list-content {
		background: #fff;
	}

	.list {
		width: 100%;
		border-bottom: 15rpx solid #f1f1f1;
		background: #fff;

		&:last-child {
			border: none;
		}

		.li {
			width: 92%;
			height: 100rpx;
			padding: 0px 4%;
			border-bottom: 1px solid #f3f3f3;
			display: flex;
			align-items: center;
			margin: 0rpx auto;

			&.noborder {
				border-bottom: 0
			}

			.icon {
				flex-shrink: 0;
				width: 50rpx;
				height: 50rpx;

				image {
					width: 50rpx;
					height: 50rpx;
				}
			}

			.text {
				padding-left: 20rpx;
				width: 100%;
				color: #666;
			}

			.to {
				flex-shrink: 0;
				width: 40rpx;
				height: 40rpx;
			}
		}
	}

	.copyright {
		margin: 20rpx auto;
		width: 80%;
		height: 60rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		color: #9E9E9E;
		font-size: 26rpx;
	}
</style>