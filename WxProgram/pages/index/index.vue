<template>
	<view class="content">
		<!-- banner图 -->
		<view class="uni-padding-wrap">
			<view class="page-section swiper">
				<view class="page-section-spacing">
					<swiper class="swiper" circular="true" indicator-dots="true" autoplay="true" interval="3500"
						duration="600">
						<swiper-item class="swiper-list" v-for="(item, index) in bannerList" :key="index">
							<view class="swiper-item uni-bg-red">
								<image class="swiper-img" :src="item.bannerImg" mode=""></image>
							</view>
						</swiper-item>
					</swiper>
				</view>
			</view>
		</view>
		<view class="message-box" @click="noticeMore">
			<view class="page-section swiper">
				<view class="page-section-spacing">
					<swiper style="height: 120rpx;" class="swiper" vertical="ture" circular="true"
						indicator-dots='false' indicator-color="rgba(0,0,0,.0)" indicator-active-color="rgba(0,0,0,.0)"
						autoplay="true" interval="4000">
						<swiper-item class="swiper-list" v-for="(item, index) in messageData" :key="index">
							<view class="message-tltle">{{item.noticeTitle}}</view>
							<view class="message-content"><span>感谢</span>{{item.noticeDesc}}</view>
						</swiper-item>
					</swiper>
				</view>
			</view>
		</view>
		<view class="cu-bar bg-white margin-top-xs">
			<view class="action sub-title">
				<text class="text-xl text-bold text-blue text-shadow">推荐小程序</text>
				<text class="text-ABC text-blue">my app</text>
			</view>
			<view class="action" @click="gomoreapp"><text class="text-lg text-grey text-shadow" >更多</text></view>
		</view>
		<ad :unit-id="adlist.bannerAd"></ad>
		<view class="skill-sequence-panel-content-wrapper">
			<!--左边虚化-->
			<view class="hide-content-box hide-content-box-left"></view>
			<!--右边虚化-->
			<view class="hide-content-box hide-content-box-right"></view>
			<scroll-view scroll-x="true" class="kite-classify-scroll">
				<view class="kite-classify-cell shadow" v-for="(item, index) in curriculum" :key="index">
					<view :class="'nav-li bg-index' + (index + 1)">
						<view class="nav-name">{{ item.itemName }}</view>
					</view>
					<view class="nav-content">{{ item.itemDesc }}</view>
					<view @click="goDeatil" class="nav-btn shadow" :class="'bg-index' + (index + 1)">立即访问</view>
				</view>
			</scroll-view>
		</view>
		<view class="cu-bar bg-white margin-top-xs">
			<view class="action sub-title">
				<text class="text-xl text-bold text-blue text-shadow">开源项目推荐</text>
				<text class="text-ABC text-blue">curriculum</text>
			</view>
			<view class="action" @click="goMore"><text class="text-lg text-grey text-shadow">更多</text></view>
		</view>
		<ad :unit-id="adlist.videoAd" ad-type="video" ad-theme="white"></ad>
		<view class="cu-card case no-card">
			<view @click="goProject(item.id)" class="cu-item shadow" v-for="(item, index) in projectList" :key="index">
				<view class="image">
					<image :src="item.programImg" mode="widthFix"></image>
					<view class="cu-tag bg-gradual-orange">{{ item.programTag }}</view>
					<view class="cu-bar bg-shadeBottom">
						<text class="text-cut">{{ item.programName }}</text>
					</view>
				</view>
			</view>
		</view>
		<ad-custom :unit-id="adlist.gridAd"></ad-custom>
		<view class="copyright">
			<text>AbuCoder版权所有</text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				adlist:this.myad()[0],
				bannerList: [],
				messageData: [
					{
						noticeTitle: '「AbuCoder」感谢前段铺子前段框架！',
						tag: '感谢',
						noticeContent: '感谢Uview开源框架'
					},
					{
						noticeTitle: '「AbuCoder」感谢若依开发框架！',
						tag: '感谢',
						noticeContent: '第一次做插件，感谢大家的支持哦~'
					},
					{
						noticeTitle: '「AbuCoder」感谢ColorUI前段框架！',
						tag: '感谢',
						noticeContent: '第一次做插件，感谢大家的支持哦~'
					}
				],
				curriculum: [{
						itemName: '专业证件照',
						itemDesc: '基于uniapp的专业证件照制作小程序，欢迎访问...'
					},
					{
						itemName: '极速去水印',
						itemDesc: '基于uniapp的专业极速去水印助手小程序，欢迎访问...'
					},
					{
						itemName: '证件照（民族语言版）',
						itemDesc: '基于uniapp的专业证件照制作小程序民族语言版...'
					},
				],
				projectList:[
					{
						programImg:'https://cdn.uviewui.com/uview/swiper/swiper2.png',
						programTag:'Gitee开源',
						programName:'若依开源框架推荐'
					}
				]
			}
		},
		onLoad() {
			this.getBannerlist()
			this.getNoticelist()
			this.getItemslist()
			this.getProgrammslist()
			this.myAd()
		},
		methods: {
			//暴力插屏广告
			myAd(){
				let that = this
				if (that.myad()[0].plaqueAd) {
					setInterval(function() {
						// 在页面中定义插屏广告
						let interstitialAd = null
				
						// 在页面onLoad回调事件中创建插屏广告实例
						if (wx.createInterstitialAd) {
							interstitialAd = wx.createInterstitialAd({
								adUnitId: that.myad()[0].plaqueAd
							})
							interstitialAd.onLoad(() => {})
							interstitialAd.onError((err) => {})
							interstitialAd.onClose(() => {})
						}
				
						// 在适合的场景显示插屏广告
						if (interstitialAd) {
							interstitialAd.show().catch((err) => {
								console.error(err)
							})
						}
					}, 15000); //15000为插屏间隔时间
				}
			},
			getBannerlist(){
				this.request('loadBaneer', 'GET').then(res=>{
					// console.log("res:",res)
					if(res){
						let imgurl = {}
						 for (var i = 0; i < res.data.length; i++) {
							imgurl[i] = {};
							imgurl[i]['bannerImg'] = 'http://localhost:8083' + res.data[i].bannerImg
						}
						console.log(imgurl,"im")
						this.bannerList = imgurl
					}
				})
			},
			getNoticelist(){
				this.request('loadNotice', 'GET').then(res=>{
					console.log("res:",res)
					if(res){
						this.messageData = res.data
					}
				})
			},
			getItemslist(){
				this.request('loadItems', 'GET').then(res=>{
					console.log("res:",res)
					if(res){
						this.curriculum = res.data
					}
				})
			},
			getProgrammslist(){
				this.request('loadProgramms', 'GET').then(res=>{
					console.log("res:",res)
					// if(res){
					// 	this.projectList = res.data
					// }
					if(res){
						let mydata = {}
						 for (var i = 0; i < res.data.length; i++) {
							mydata[i] = {};
							mydata[i]['programImg'] = 'http://localhost:8083' + res.data[i].programImg;
							mydata[i]['id'] =res.data[i].id
							mydata[i]['programName'] = res.data[i].programName
							mydata[i]['programTag'] = res.data[i].programTag
						}
						// console.log(mydata)
						this.projectList = mydata
					}
				})
			},
			//更多
			goMore(){
				uni.navigateTo({
					url:'../itemlist/itemlist'
				})
			},
			gomoreapp(){
				uni.navigateTo({
					url:'../projectlist/projectlist'
				})
			},
			noticeMore(){
				uni.navigateTo({
					url:'../me/mynotice/mynotice'
				})
			}
		}
	}
</script>

<style lang="scss">
	.swiper-box {
		flex: 1;
	}
	
	.swiper-item {
		height: 100%;
	}
	/*通知公告*/
	.message-box {
		width: 100%;
		height: 120rpx;
		background: url(https://zhoukaiwen.com/img/icon/clock.gif) #FFFFFF;
		background-repeat: no-repeat;
		background-size: 100rpx 100rpx;
		background-position: 15rpx 10rpx;
		margin: 0rpx 0rpx 10rpx 0rpx;
		padding-left: 130rpx;
	
		.message-tltle {
			height: 65rpx;
			line-height: 70rpx;
			font-weight: 600;
			font-size: 28rpx;
		}
	
		.message-content {
			color: #0081ff;
	
			span {
				background-color: #0081ff;
				color: #FFFFFF;
				padding: 2rpx 8rpx;
				border-radius: 8rpx;
				margin-right: 8rpx;
			}
		}
	}
	/*scroll-view外层*/
	.skill-sequence-panel-content-wrapper {
		position: relative;
		white-space: nowrap;
		padding: 10rpx 0 10rpx 10rpx;
	}
	
	/*左右渐变遮罩*/
	.hide-content-box {
		position: absolute;
		top: 0;
		height: 100%;
		width: 10px;
		z-index: 2;
	}
	
	.hide-content-box-left {
		left: 0;
		background-image: linear-gradient(to left, rgba(255, 255, 255, 0), #f3f3f3 60%);
	}
	
	.hide-content-box-right {
		right: 0;
		background-image: linear-gradient(to right, rgba(255, 255, 255, 0), #f3f3f3 60%);
	}
	
	.kite-classify-scroll {
		width: 100%;
		height: 380rpx;
		overflow: hidden;
		white-space: nowrap;
	}
	
	.kite-classify-cell {
		display: inline-block;
		width: 266rpx;
		height: 370rpx;
		margin-right: 20rpx;
		background-color: #ffffff;
		border-radius: 10rpx;
		overflow: hidden;
		box-shadow: 2px 2px 3px rgba(26, 26, 26, 0.2);
	}
	
	.nav-li {
		padding: 40rpx 30rpx;
		width: 100%;
		background-image: url(https://s1.ax1x.com/2020/06/27/NyU04x.png);
		background-size: cover;
		background-position: center;
		position: relative;
		z-index: 1;
	}
	
	.nav-name {
		font-size: 28upx;
		text-transform: Capitalize;
		margin-top: 20upx;
		position: relative;
	}
	
	.nav-name::before {
		content: '';
		position: absolute;
		display: block;
		width: 40rpx;
		height: 6rpx;
		background: #fff;
		bottom: 0;
		right: 0;
		opacity: 0.5;
	}
	
	.nav-name::after {
		content: '';
		position: absolute;
		display: block;
		width: 100rpx;
		height: 1px;
		background: #fff;
		bottom: 0;
		right: 40rpx;
		opacity: 0.3;
	}
	
	.nav-content {
		width: 100%;
		padding: 15rpx;
		display: inline-block;
		overflow-wrap: break-word;
		white-space: normal;
	}
	
	.nav-btn {
		width: 200rpx;
		height: 60rpx;
		margin: 8rpx auto;
		text-align: center;
		line-height: 60rpx;
		border-radius: 10rpx;
	}
	
	.bg-index1 {
		background-color: #19cf8a;
		color: #fff;
	}
	
	.bg-index2 {
		background-color: #954ff6;
		color: #fff;
	}
	
	.bg-index3 {
		background-color: #5177ee;
		color: #fff;
	}
	
	.bg-index4 {
		background-color: #f49a02;
		color: #fff;
	}
	
	.bg-index5 {
		background-color: #ff4f94;
		color: #fff;
	}
	
	.bg-index6 {
		background-color: #7fd02b;
		color: #fff;
	}
	
	.item-name {
		margin-bottom: 15rpx;
		display: -webkit-box;
		-webkit-box-orient: vertical;
		-webkit-line-clamp: 1;
		overflow: hidden;
	}
	.copyright{
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
