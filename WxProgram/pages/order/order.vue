<template>
	<view class="content" >
		<view class="cu-bar bg-white margin-top-xs">
			<view class="action sub-title">
				<text class="text-xl text-bold text-blue text-shadow">景区详情</text>
				<text class="text-ABC text-blue">scenicspot</text>
			</view>
		</view>
		<view class="cu-card case no-card">
			<view class="cu-item shadow">
				<view class="image">
					<image :src="jdDetail.indexUrl" mode="widthFix"></image>
				</view>
				<view class="imageDetail-text">景区名称：{{jdDetail.name}}</view>
				<view class="imageDetail">
					
					<view class="imageDetail-text">景区简介：{{jdDetail.remark}}</view>
				</view>
				<view class="imageKc">
					<view class="imageDetail-text">门票价格：{{jdDetail.price}} ¥</view>
					<view class="imageDetail-text">库存数：{{jdDetail.kucunNum}}</view>
				</view>
			</view>
		</view>
		<!-- 评论 -->
		<view class="cu-bar bg-white margin-top-xs">
			<view class="action sub-title">
				<text class="text-xl text-bold text-blue text-shadow">评论</text>
				<text class="text-ABC text-blue">comment</text>
			</view>
		</view>	
		<view class="cu-card case no-card">
			<view class="cu-item shadow" v-for="(item, index) in commentListVo" :key="index">
				<view class="commentUser">
					<u-avatar :src="item.avatar"></u-avatar>
					<view class="commentName">{{item.nickname}}</view>
				</view>
				<view style="margin: 0 18upx;">
					<u-alert type = "primary" :description = "item.content" fontSize="16"></u-alert>
				</view>
			</view>
		</view>
		
		<!-- 底部 -->
		<view class="bottom-bar">
			<view class="icon-container">
				<u-icon v-if="isDz == false" name="heart" size="28" @click="dzEvent"></u-icon>
				<u-icon v-else name="heart-fill" size="28"></u-icon>
				<u-icon v-if="isSc == false" name="star" size="28" @click="scEvent"></u-icon>
				<u-icon v-else name="star-fill" size="28"></u-icon>
			</view>
			<view class="order-button">
				<u-button text="订购门票"  color="linear-gradient(to right, rgb(66, 83, 216), rgb(213, 51, 186))"></u-button>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				jdDetail:{},
				isDz: false,
				isSc: false,
				jingdianId: '',
				wxuserId: '',
				commentList: [],
				commentListVo: []
			}
		},
		onLoad(query) {
			this.wxuserId = JSON.parse(uni.getStorageSync("userinfo")).id;
			this.jingdianId = query.id;
			// console.log('query', this.wxuserId );
			this.getInfo(query.id);
			this.getCommentList(this.jingdianId);
		},
		methods: {
			getCommentList(jdid){
				this.commentListVo = [];
				this.request(`commentListByJdID/${jdid}`, 'GET').then(res=>{
					if(res.code == 200){
						this.commentList = res.data;
						this.commentList.forEach((comment, index) => {
							this.getUserInfo(comment);
						});
					}
				})
			},
			getUserInfo(comment){
				const userId = comment.wxuserId;
				this.request(`getWxInfo/${userId}`, 'GET').then(res=>{
					if(res.code == 200){
						const objectVo = {};
						objectVo.nickname = res.data.nickname;
						objectVo.avatar = res.data.avatar;
						objectVo.content = comment.content;
						// 添加进数组
						this.commentListVo.push(objectVo);
					}
					
					console.log(this.commentListVo,"vo")
				})
			},
			
			scEvent(){
				this.request(`operateSc?wxuserId=${this.wxuserId}`,{id: this.jingdianId},'PUT').then(res=>{
					// console.log("res:",res)
					if(res.code == 200){
						this.isSc = true;
						uni.showToast({
							icon: "none",
							title: "收藏成功，可在我的收藏中查看！",
							duration: 2000
						})
					}else{
						uni.showToast({
							icon: "none",
							title: "已经加入收藏，请在我的收藏中查看！",
							duration: 2000
						})
					}
				})
			},
			dzEvent(){
				this.request("operateDz",{id: this.jingdianId},'PUT').then(res=>{
					// console.log("res:",res)
					if(res.code == 200){
						this.isDz = true;
						
					}
				})
			},
			getInfo(id){
				this.request(`jdInfo/${id}`, 'GET').then(res=>{
					// console.log("res:",res)
					if(res.code == 200){
						this.jdDetail = res.data;
						this.jdDetail.indexUrl ='http://localhost:8083' + this.jdDetail.indexUrl;
					}
				})
			}
		}
	}
</script>

<style>
	.content {
		 padding-bottom: calc(135upx + env(safe-area-inset-bottom)); 
	}
	.bottom-bar {
		position: fixed;
		bottom: env(safe-area-inset-bottom);
		width: 100%;
		display: flex;
		justify-content: space-between;
		padding: 10px;
		background-color: #f8f8f8;
	}
	
	.icon-container {
		display: flex;
		justify-content: space-around;
		width: 20vw;
	}
	
	.order-button {
		width: 70vw;
	}


</style>
