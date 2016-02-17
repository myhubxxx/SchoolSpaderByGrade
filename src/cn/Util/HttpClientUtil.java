package cn.Util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	private static CloseableHttpClient httpClient = null;

	private HttpClientUtil() {
	}

	/**
	 * 获取httpclient实例
	 * 
	 * @return
	 */
	public static CloseableHttpClient getInstance() {
		if (httpClient == null) {
			httpClient = HttpClients.createDefault();
		}
		return httpClient;
	}

	/**
	 * 设置httpclient 连接时延
	 * 
	 * @return
	 */
	private static RequestConfig requestConfig() {
		return RequestConfig.custom().setSocketTimeout(5000)
				.setConnectTimeout(5000).build();
	}

	/**
	 * get 请求
	 * 
	 * @param url
	 * @return
	 */
	public static String doGet(String url) {
		HttpGet get = new HttpGet(url);
		get.setConfig(requestConfig());
		CloseableHttpResponse response = null;
		try {
			response = HttpClientUtil.getInstance().execute(get);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(response.getEntity());
			} else {
				return "远程服务器返回码 : " + response.getStatusLine().getStatusCode();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			get.abort();
		} catch (IOException e) {
			e.printStackTrace();
			get.abort();
		} finally {
			try {
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * post请求(无参)
	 * 
	 * @param url
	 * @return
	 */
	public static String doPost(String url) {
		return doPost(url, null);
	}

	/**
	 * post请求(有参)
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	public static String doPost(String url, Map<String, String> param) {
		HttpPost post = new HttpPost(url);
		CloseableHttpResponse response = null;
		try {
			post.setConfig(requestConfig());

			HttpEntity entity = (param == null) ? null
					: new UrlEncodedFormEntity(params(param));
			post.setEntity(entity);
			response = HttpClientUtil.getInstance().execute(post);

			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return EntityUtils.toString(response.getEntity());
			} else {
				return "远程服务器返回码 : " + response.getStatusLine().getStatusCode();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			post.abort();
		} catch (IOException e) {
			e.printStackTrace();
			post.abort();
		} finally {
			try {
				response.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 设置post 请求参数
	 * 
	 * @param datas
	 * @return
	 */
	private static List<BasicNameValuePair> params(Map<String, String> datas) {
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		for (String key : datas.keySet()) {
			params.add(new BasicNameValuePair(key, datas.get(key)));
		}
		return params;
	}

	/**
	 * save the web page's picture to desti..
	 * 
	 * @param url
	 *            --the image url
	 * @param savePath
	 *            -- the image savePath
	 */
	public static void savaImage(String url, String savePath) {
		HttpPost post = new HttpPost(url);
		HttpResponse response = null;

		try {

			response = HttpClientUtil.getInstance().execute(post);
			InputStream in = response.getEntity().getContent();
			// sava the Stream to File
			HttpClientUtil.saveFile(in, savePath);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// get the image Stream
	public static InputStream imageInStream(String url){
		HttpPost post = new HttpPost(url);
		HttpResponse response = null;
		InputStream in = null;
		try {

			response = HttpClientUtil.getInstance().execute(post);
			in = response.getEntity().getContent();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return in;
		
	}
	
	
	/**
	 * save the InputStream to file
	 * 
	 * @param in
	 * @param savePath
	 */
	public static void saveFile(InputStream in, String savePath) {
		FileOutputStream fos = null;
		try {
			
			fos = new FileOutputStream(savePath);
			byte[] bytes = new byte[1024];
			while((in.read(bytes)) != -1){
				fos.write(bytes);
			}
			// start close the Stream
			in.close();
			fos.close();
			// end Close the Stream
			
		} catch (Exception e) {
			e.printStackTrace();
		}	

	}
}
