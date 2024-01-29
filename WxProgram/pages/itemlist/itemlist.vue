<template>
	<view class="content">
		<ad :unit-id="adlist.bannerAd"></ad>
		<view class="cu-card article shadow" v-for="(item, index) in projectList" :key="index">
			<view class="cu-item shadow">
				<view class="title">
					<text class="text-cut">{{item.programName}}</text>
				</view>
				<view class="desc">
					<view class="text-desc cu-tag bg-cyan">{{item.programTag}}</view>
				</view>
				<view class="cu-item">
					<image :src="item.programImg" class="myimage"></image>
				</view>
				<view class="desc" style="padding: 10rpx;">
					<u-parse class="text-content" :content="item.programContent"></u-parse>
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
				projectList:{}
			}
		},
		onLoad() {
			this.getprojectList()
		},
		methods: {
			getprojectList(){
				this.request('loadProgramms', 'GET').then(res=>{
					console.log("res:",res)
					if(res){
						let mydata = {}
						 for (var i = 0; i < res.data.length; i++) {
							mydata[i] = {};
							mydata[i]['programImg'] = this.myimgurl() + res.data[i].programImg;
							mydata[i]['id'] =res.data[i].id
							mydata[i]['programName'] = res.data[i].programName
							mydata[i]['programTag'] = res.data[i].programTag
							mydata[i]['programContent'] = res.data[i].programContent
						}
						// console.log(mydata)
						this.projectList = mydata
					}
				})
			}
		}
	}
</script>

<style lang="scss">
	.myimage{
		width: 100%;
		height: 360rpx;
	}
	.text-desc{
		/* margin-top: 25rpx; */
		margin: 20rpx;
		font-size: 28rpx;
		color: #fff;
		/* height: 4.8em; */
		overflow: hidden;
	}
	.text-content{
		margin-top: 20rpx;
	}
</style>
