/**
 * author：AbuCoder
 * date:2022年5月22日13:53:23
 * 封装的异步请求处理函数
 * 需要在main.js引入与挂载 import request from 'utils/request.js'  //引入异步请求函数
 *  Vue.prototype.request = request.request //挂载到全局
 * 使用方法为:
 * request('接口名称',{key:value},'请求方式(默认为GET)')
 * .then(res=>{console.log(res)})
 */
import { getToken} from "./auth";
import { baseUrl,uploadUrl } from "./apiconfig";
// let baseUrl = 'https://ga.rasmall.cn/prod-api/wxapi/';
// let baseUrl = 'http://localhost:8083/wxapi/'
async function request(mehtod, params, type, callBack) {
  //创建一个名为request请求的方法函数
  if (!type) {
    type = 'GET';
  }
  let header = {
    //设置请求头信息
    // 'Authorization': getToken(),
    // 'X-Requested-With': 'XMLHttpRequest',
    "Accept": "application/json",
    "Content-Type": "application/json; charset=UTF-8"
  };
  let http = {
    url: baseUrl + mehtod,
    data: params,
    method: type,
    header: header
  };
  let promise = new Promise((resolve, reject) => {
    uni.request(http).then(res => {
      let newdata = res[1].data; // if (newdata.code == 403) {
      if (newdata == -1) {
        //如果错误码为 -1 提示
        uni.showToast({
          title: res[1].data.msg,
          icon: 'none'
        });
      }
      resolve(res[1].data);
    }).catch(err => {
      reject(err);
      console.log(err);
    });
  });
  return promise;
}

async function requestJson(mehtod, params, type, headerParams, callBack) {
  //创建一个名为request请求的方法函数
  let header = {
    //设置请求头信息
    'X-Requested-With': 'XMLHttpRequest',
    "Accept": "application/json",
    "Content-Type": "application/json; charset=UTF-8"
  };
  if(headerParams){
	  header = Object.assign(header, headerParams);
  }
  let http = {
    url:  mehtod,
    data: params,
    method: type,
    header: header
  };
  let promise = new Promise((resolve, reject) => {
    uni.request(http).then(res => {
      resolve(res);
    }).catch(err => {
      reject(err);
      console.log(err);
    });
  });
  return promise;
}

async function requestForm(mehtod, params, type, callBack) {
  //创建一个名为request请求的方法函数
  let header = {
    //设置请求头信息
    'X-Requested-With': 'XMLHttpRequest',
    "Accept": "application/json",
    "Content-Type": "application/x-www-form-urlencoded"
  };
  let http = {
    url:  mehtod,
    data: params,
    method: type,
    header: header
  };
  let promise = new Promise((resolve, reject) => {
    uni.request(http).then(res => {
      resolve(res);
    }).catch(err => {
      reject(err);
      console.log(err);
    });
  });
  return promise;
}
export default {
  request,
  requestJson,
  requestForm
};