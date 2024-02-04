<template>
	<view>
		<view class="cu-card article shadow" v-for="(item,index) in noticelist" :key="index">
			<view class="cu-item shadow">
				<view class="title">{{item.jdname}}门票</view>
				<view class="cu-tag round bg-olive light" style="margin-left: 20rpx;">价格：{{item.price}} ¥</view>
				<view class="cu-tag round bg-blue light" style="margin-left: 30rpx;">下单时间：{{item.createTime}}</view>
				<view class="desc padding">
					<text class="text-content">订单编号：{{item.orderNo}}</text>
				</view>
				<u-line></u-line>
				<view class="flex justify-between" style="margin: 20upx 20upx 0 20upx;">
					<view>
						<u-button type="success" @click="printBr(item.orderNo)" :plain="true" :hairline="true" text="细边">出示核销码</u-button>
					</view>
					<view>
						<u-button type="primary" @click="openComment(item.jingdianId)" :plain="true" :hairline="true" text="细边">立即评论</u-button>
					</view>
				</view>
			</view>
		</view>
		
		<!-- qr -->
		<u-modal :show="qrShow" title="核销二维码" @confirm="closeQr">
			<view class="qr-class">
				<canvas type="2d" style="width: 260px; height: 260px;" id="myQrcode"></canvas>
			</view>
		</u-modal>
		
		<!-- 评论 -->
		<u-modal :show="commentShow" :showCancelButton="true" title="评论" @confirm="confirmComment()" @cancel="closeComment()">
			<view >
				<view class="flex justify-between">
					<!-- <view class="" style="font-size: 32upx;">评分：</view>
					<view class="">
						<u-rate :count="commentcount" :value="commentvalue" :disabled="false" :readonly="false" size="22" :allowHalf="true" @change="commentEva()"></u-rate>
					</view> -->
					<!-- <view class="" style="font-size: 32upx;">请输入评论内容：</view> -->
					<view class="">
						  <u--input
							v-model="commentText"
						    placeholder="请输入评论内容"
						    border="bottom"
						    clearable
						  ></u--input>
					</view>
				</view>
			</view>
		</u-modal>
		
	</view>
</template>

<script>
	import drawQrcode from '../../utils/weapp.qrcode.esm.js'
	export default {
		data() {
			return {
				noticelist:[],
				qrShow: false,
				qrText: '',
				commentShow: false,
				commentcount: 5,
				commentvalue: 1,
				commentText: '',
				jdId: '',
				wxuserId: '',
			}
		},
		onLoad() {
			this.wxuserId = JSON.parse(uni.getStorageSync("userinfo")).id;
			this.getNoticelist();
		},
		methods: {
			confirmComment(){
				this.request('addComment',{
					jingdianId: this.jdId,
					wxuserId:this.wxuserId,
					content: this.commentText
				},'POST').then(res =>{
					if (res.code == 200) {
						this.commentShow = false
						uni.showToast({
							icon: "none",
							title: "评论成功",
							duration: 2000
						})
					}
				})
			},
			commentEva(){
				console.log("触发")
			},
			openComment(id){
				this.jdId = id;
				this.commentShow = true
			},
			closeComment(){
				this.commentShow = false
			},
			closeQr(){
				this.qrShow = false;
			},
			printBr(No) {
				console.log(No, "订单号")
				this.qrShow = true;
				this.qrText = No;
				
				const query = wx.createSelectorQuery()
				query.select('#myQrcode')
					.fields({
						node: true,
						size: true
					})
					.exec((res) => {
						var canvas = res[0].node
				
						// 调用方法drawQrcode生成二维码
						drawQrcode({
							canvas: canvas,
							canvasId: 'myQrcode',
							width: 260,
							padding: 30,
							background: '#ffffff',
							foreground: '#000000',
							text: this.qrText,
						})
						// 获取临时路径
						wx.canvasToTempFilePath({
							canvasId: 'myQrcode',
							canvas: canvas,
							x: 0,
							y: 0,
							width: 260,
							height: 260,
							destWidth: 260,
							destHeight: 260,
							success(res) {
								// console.log('二维码临时路径：', res.tempFilePath)
							},
							fail(res) {
								console.error(res)
							}
						})
					})
			},
			getNoticelist(){
				this.request('orderList','GET').then(res =>{
					if(res){
						this.noticelist = res.data
						for(let i = 0; i<this.noticelist.length; i++){
							// let randomNumber = '';
							// for(let j = 0; j < 15; j++){
							// 	randomNumber += Math.floor(Math.random() * 10);
							// }
							this.noticelist[i].orderNo = this.noticelist[i].id + this.noticelist[i].createTime.replace(/[-:\s]/g, '');;
						}
						
					}
				})
			}
		}
	}
</script>

<style lang="scss">
.qr-class {
		display: flex;
		justify-content: center;
	}
</style>
