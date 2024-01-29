// 该文件用来存储localStorage 本地缓存的方法
import { baseUrl,uploadUrl } from "./apiconfig";
/**
 * 操作用户token
 */
export function setToken(value) {
  uni.setStorageSync('token', value);
  // console.log('存储用户信息成功');
}
/**
 * 获取缓存的Openid
 */
export function getToken() {
  let token = uni.getStorageSync('token');
  return token;
}
/**
 * 移除用户token=openid
 */
export function removeToken() {
  uni.removeStorageSync('token');
}
/**
 * 操作用户信息
 * 缓存微信用户信息
 */
export function setUserInfo(value) {
  try {
    let newValue = JSON.stringify(value);
    uni.setStorageSync('userinfo', newValue);
    // console.log('存储用户信息成功');
  } catch (e) {
    return;
  }
}
/**
 * 获取缓存的微信用户信息
 */
export function getUserInfo() {
  let userinfo = uni.getStorageSync('userinfo');
  // console.log('userinfo', userinfo)
  if (userinfo) {
    return JSON.parse(userinfo);
  }
}
/**
 * 移除缓存的用户信息
 */
export function removeUserInfo(){
	uni.removeStorageSync('userinfo');
}

/**
 * 操作会员信息
 * 会员信息存储缓存
 */
export function setRememberInfo(value) {
  try {
    uni.setStorageSync('rememberInfo', value);
    // console.log('存储会员信息成功');
  } catch (e) {
    return;
  }
}

/**
 * 获取缓存的会员信息
 */
export function getRememberInfo() {
  let rememberInfo = uni.getStorageSync('rememberInfo');
  if(rememberInfo){
	   // console.log('会员信息获取成功：', rememberInfo)
	  return rememberInfo;
  }
}
/**
 * 移除缓存的会员信息
 */
export function removeRememberInfo(){
	uni.removeStorageSync('rememberInfo');
	// console.log("清楚会员信息成功！")
}

/**
 * 缓存用户分享ID
 * 登录时传到后端
 */
export function setShareID(value){
	try{
		uni.setStorageSync("shareid",value);
	}catch (e) {
    return;
  }
}
/**
 * 获取用户分享ID
 * 登录时传到后端
 */
export function getShareID(){
	let shareid = uni.getStorageSync("shareid")
	if(shareid){
		return shareid;
	}
}
export function getConfig(){
	let base = {
		baseUrl,
		uploadUrl,
	}
	return base;
}