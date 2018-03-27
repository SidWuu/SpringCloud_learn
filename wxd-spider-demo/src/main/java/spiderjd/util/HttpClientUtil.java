package spiderjd.util;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/************************************************
 * Copyright (c)  by goldensoft
 * All right reserved.
 * Create Date: 2017年7月25日
 * Create Author: wxd
 * File Name: 爬虫工具类
 * Last version:  1.0
 * Function: HttpClientUtil
 * Last Update Date:
 * Change Log:
**************************************************/	
public class HttpClientUtil {
	private final static String GET_METHOD="GET";
//	private final static String POST_METHOD="POST";
	
	public static String sendGet(String url, Map<String, String> params, Map<String, String> headers){
		String result="";
		CloseableHttpClient client=HttpClients.createDefault();
		StringBuffer reqUrl=new StringBuffer(url);
		//拼接params
		if(null!=params && params.size()>0){
			reqUrl.append("?");
			for(Entry<String, String> param:params.entrySet()){
				reqUrl.append(param.getKey()+"="+param.getValue()+"&");
			}
			url=reqUrl.substring(0, reqUrl.length()-1);
		}
//		System.out.println("[url:"+url+",method:"+GET_METHOD+"]");
		HttpGet httpGet=new HttpGet(url);
		//拼接header
//		System.out.println("Header\n");
		if(null!=headers && headers.size()>0){
			for(Entry<String, String> header:headers.entrySet()){
				httpGet.addHeader(header.getKey(),header.getValue());
				System.out.println(header.getKey()+":"+header.getValue());
			}
		}
		CloseableHttpResponse response=null;
		try {
			response=client.execute(httpGet);
			if(200==response.getStatusLine().getStatusCode()){
				HttpEntity entity=response.getEntity();
				result=EntityUtils.toString(entity,"utf-8");
			}
		} catch (Exception e) {
			System.out.println("网络请求出错，请检查原因");
		} finally {
			try {
				if(null!=response){
					response.close();
				}
				client.close();
			} catch (Exception e) {
				System.out.println("网络关闭错误");
			}
		}
		return result;
	}
	
	public static String sendPost(String url, Map<String, String> params, Map<String, String> headers){
		String result="";
		return result;
	}
	
}
