<template>
	<view>
		<view class="skill-sequence-panel-content-wrapper">
			<ad :unit-id="adlist.bannerAd"></ad>
			<view class="kite-classify-cell shadow" v-for="(item, index) in curriculum" :key="index">
				<view :class="'nav-li bg-index' + (index + 1)">
					<view class="nav-name">{{ item.itemName }}</view>
				</view>
				<view class="nav-content">{{ item.itemDesc }}</view>
				<view @click="goDeatil" class="nav-btn shadow" :class="'bg-index' + (index + 1)">立即访问</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				adlist:this.myad()[0],
				curriculum:{}
			}
		},
		onLoad() {
			this.getItemslist()
		},
		methods: {
			getItemslist(){
				this.request('loadItems', 'GET').then(res=>{
					console.log("res:",res)
					if(res){
						this.curriculum = res.data
					}
				})
			},
		}
	}
</script>

<style lang="scss">
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
		// display: inline-block;
		// width: 300rpx;
		height: 370rpx;
		margin-right: 25rpx;
		background-color: #ffffff;
		border-radius: 10rpx;
		overflow: hidden;
		box-shadow: 2px 2px 3px rgba(26, 26, 26, 0.2);
		margin-bottom: 20rpx;
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
		// margin-top: 20upx;
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
</style>
