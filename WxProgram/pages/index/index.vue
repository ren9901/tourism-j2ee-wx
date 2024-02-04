<template>
	<view class="content">
		<view class="message-box" @click="gomoreapp">
			<view class="page-section swiper">
				<view style="padding-top: 20upx;">
					<u-search shape="round" :disabled="true"></u-search>
				</view>
			</view>
		</view>
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
		
		<view class="cu-bar bg-white margin-top-xs">
			<view class="action sub-title">
				<text class="text-xl text-bold text-blue text-shadow">热门景区推荐</text>
				<text class="text-ABC text-blue">recommend</text>
			</view>
			<view class="action" @click="goMore"><text class="text-lg text-grey text-shadow">更多</text></view>
		</view>
		<view class="cu-card case no-card">
			<view @click="goProject(item.id)" class="cu-item shadow" v-for="(item, index) in projectList" :key="index">
				<view class="image">
					<image :src="item.programImg" mode="widthFix"></image>
					<view class="cu-bar bg-shadeBottom">
						<text class="text-cut">{{ item.programName }}</text>
						<text class="text-cut">点赞数：{{ item.dzNum }}  收藏数：{{item.collectNum}}</text>
					</view>
				</view>
				<view class="imageDetail">
					<view class="imageDetail-text">景区简介：{{item.remark}}</view>
				</view>
				<view class="imageKc">
					<view class="imageDetail-text">门票价格：{{item.price}} ¥</view>
					<view class="imageDetail-text">库存数：{{item.kucunNum}}</view>
				</view>
			</view>
		</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				bannerList: [],
				messageData: [],
				curriculum: [],
				projectList:[]
			}
		},
		onShow() {
			this.getBannerlist()
			this.getNoticelist()
			this.getItemslist()
			this.getProgrammslist()
		},
		methods: {
			
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
				this.request('jdListTop3', 'GET').then(res=>{
					if(res){
						let mydata = {}
						for (var i = 0; i < res.data.length; i++) {
							mydata[i] = {};
							mydata[i]['programImg'] = 'http://localhost:8083' + res.data[i].indexUrl;
							mydata[i]['id'] =res.data[i].id
							mydata[i]['programName'] = res.data[i].name
							mydata[i]['dzNum'] = res.data[i].dznum
							mydata[i]['collectNum'] = res.data[i].collectNum
							mydata[i]['remark'] = res.data[i].remark
							mydata[i]['price'] = res.data[i].price
							mydata[i]['kucunNum'] = res.data[i].kucunNum
						}
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
			// 搜索
			gomoreapp(){
				uni.navigateTo({
					url:'../projectlist/projectlist'
				})
			},
			noticeMore(){
				uni.navigateTo({
					url:'../me/mynotice/mynotice'
				})
			},
			goProject(id){
				if(uni.getStorageSync("userinfo")!=''){
					uni.navigateTo({
						url:`../order/order?id=${id}`
					})
				}else{
					uni.showToast({
						icon: "none",
						title: "请先登录后，再查看景点详情！",
						duration: 2000
					})
				}
				
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
		height: 100rpx;
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
