// src/services/axiosConfig.js
import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8080',
  
});

// 可选：添加请求和响应拦截器
api.interceptors.request.use(config => {
  // 请求前的处理
  return config;
}, error => {
  return Promise.reject(error);
});

api.interceptors.response.use(response => {
  // 响应后的处理
  return response;
}, error => {
  return Promise.reject(error);
});

export default api;
