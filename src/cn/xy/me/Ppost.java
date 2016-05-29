package cn.xy.me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

@SuppressWarnings("deprecation")
public class Ppost {

	public StringBuffer getKB(String uname, String upass, int type)
			throws ClientProtocolException, IOException {
		
		

		StringBuffer strBu = new StringBuffer();
		HttpClient httpclient = null;
		HttpContext context = null;

		try { // HttpClient主要负责执行请求
			httpclient = new DefaultHttpClient();
			context = new BasicHttpContext();

			// 利用HTTP GET向服务器发起请求，
			HttpGet get = new HttpGet(
					"http://xk.swpu.edu.cn:9099/loginAction.do");
			//

			// 获得服务器响应的的所有信息
			HttpResponse response = httpclient.execute(get, context);
			// 获得服务器响应回来的消息体（不包括HTTP HEAD）
			HttpEntity entity = response.getEntity();
			String charset = null;

			if (entity != null) {
				// 获得响应的字符集编码信息 //即获取HTTP
				// HEAD的：Content-Type:text/html;charset=UTF-8中的字符集信息

				// charset = EntityUtils.getContentCharSet(entity);
				charset = "GBK";

			//	System.out.println("响应的字符集是：" + charset);
				InputStream is = entity.getContent();
				// 使用响应中的编码来解释响应的内容
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, charset));
				String line = null;
				while ((line = br.readLine()) != null) {
					// System.out.println(line);
				}
				is.close();
			}

			// ************* 执行登录请求 ********************//
			HttpPost post = new HttpPost(
					"http://xk.swpu.edu.cn:9099/loginAction.do");
			// 添加POST参数
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("zjh", uname));
			nvps.add(new BasicNameValuePair("mm", upass));
			post.setEntity(new UrlEncodedFormEntity(nvps, charset));
			response = httpclient.execute(post);
			entity = response.getEntity();
			if (entity != null) {
				InputStream is = entity.getContent();
				// 使用响应中的编码来解释响应的内容
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, "GBK"));
				String line = null;
				while ((line = br.readLine()) != null) {
					// System.out.println(line);
				}
		//		System.out.println("教务处进入成功！！！");
				is.close();
			}
		//  全部及格成绩  type = 0	
			if( type == 0 ){
				get = new HttpGet(		
					"http://xk.swpu.edu.cn:9099/gradeLnAllAction.do?type=ln&oper=qbinfo&lnxndm=2013-2014%D1%A7%C4%EA%C7%EF(%C1%BD%D1%A7%C6%DA)#2013-2014学年秋(两学期)");
			}
		// 课表  type = 1
			if( type == 1)
			get = new HttpGet(
					"http://xk.swpu.edu.cn:9099/xkAction.do?actionType=6");
			response = httpclient.execute(get);
			entity = response.getEntity();
			if (entity != null) {
				InputStream is = entity.getContent();
				// 使用响应中的编码来解释响应的内容
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, charset));
				String line = null;
				while ((line = br.readLine()) != null) {
				//	System.out.println(line);
				//	System.out.println(" =================oneline======================= ");

					strBu.append(line);
				}
				is.close();
			} // 释放所有的链接资源，一般在所有的请求处理完成之后，才需要释放
			httpclient.getConnectionManager().shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strBu;
	}
//	 public static void main(String args[]) throws ClientProtocolException,
//		 IOException {
//	
//		 Ppost p = new Ppost();
//		  
//		StringBuffer sb = p.getKB("201305020346","ZENYAN",1);
//
//	 }

}
