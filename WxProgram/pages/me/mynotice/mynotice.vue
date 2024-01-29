<template>
	<view>
		<ad :unit-id="adlist.bannerAd"></ad>
		<view class="cu-card article shadow" v-for="(item,index) in noticelist" :key="index">
			<view class="cu-item shadow">
				<view class="title">{{item.noticeTitle}}</view>
				<view class="cu-tag round bg-olive light" style="margin-left: 20rpx;">发布人：{{item.createBy}}</view>
				<view class="cu-tag round bg-blue light" style="margin-left: 30rpx;">发布时间：{{item.createTime}}</view>
				<view class="desc padding">
					<text class="text-content">{{item.noticeDesc}}</text>
				</view>
				<u-line></u-line>
				<view class="content margin-tb-sm">
					<u-parse class="text-content" :content="item.noticeContent"></u-parse>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				adlist:this.myad()[0],
				noticelist:{}
			}
		},
		onLoad() {
			this.getNoticelist()
		},
		methods: {
			getNoticelist(){
				let that = this
				that.request('loadNotice','GET').then(res =>{
					console.log(res)
					if(res){
						this.noticelist = res.data
					}
				})
			}
		}
	}
</script>

<style>

</style>
