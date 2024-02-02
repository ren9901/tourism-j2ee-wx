<template>
	<view class="content">
		<view class="cu-card case no-card">
			<view v-if="loadingList.length>0">
				<view @click="goProject(item.id)" class="cu-item shadow" v-for="(item, index) in projectList"
					:key="index">
					<view class="image">
						<image :src="item.programImg" mode="widthFix"></image>
						<view class="cu-bar bg-shadeBottom">
							<text class="text-cut">{{ item.programName }}</text>
							<text class="text-cut">点赞数：{{ item.dzNum }} 收藏数：{{item.collectNum}}</text>
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
			<view v-else>
				<u-empty mode="search" icon="http://cdn.uviewui.com/uview/empty/search.png"></u-empty>
			</view>

		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				projectList: [],
				searchText: '',
				loadingList: []
			}
		},
		onLoad(query) {
			console.log(this.projectList.length)
			this.searchText = Object.keys(query).length !== 0 ? query.jdName : '';
			this.getProgrammslist()
		},
		methods: {
			getProgrammslist() {
				this.request('jdList', {
					name: this.searchText
				}, 'GET').then(res => {
					if (res) {
						this.loadingList = res.data
						let mydata = {}
						for (var i = 0; i < res.data.length; i++) {
							mydata[i] = {};
							mydata[i]['programImg'] = 'http://localhost:8083' + res.data[i].indexUrl;
							mydata[i]['id'] = res.data[i].id
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
			goProject(id) {
				uni.navigateTo({
					url: `../order/order?id=${id}`
				})
			}
		}
	}
</script>

<style lang="scss">
	.myimage {
		width: 100%;
		height: 360rpx;
	}

	.text-desc {
		/* margin-top: 25rpx; */
		margin: 20rpx;
		font-size: 28rpx;
		color: #fff;
		/* height: 4.8em; */
		overflow: hidden;
	}

	.text-content {
		margin-top: 20rpx;
	}
</style>