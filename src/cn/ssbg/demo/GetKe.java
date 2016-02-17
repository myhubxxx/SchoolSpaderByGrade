package cn.ssbg.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

import cn.Util.HttpClientUtil;

public class GetKe {
	
	public static void main(String[] args) throws Exception {
//		HttpPost httpPost = new HttpPost("http://jwxt.swpu.edu.cn/validateCodeAction.do");
//		
		HttpClient httpclient = HttpClientUtil.getInstance();
//		
//		HttpResponse response = httpclient.execute(httpPost); 
//		//±£´æÍ¼Æ¬
//		InputStream in = response.getEntity().getContent();
//				
//		FileOutputStream fos = new FileOutputStream(new File("c:\\fos.jpg"));
//		byte[] bytes = new byte[1024];
//		while( in.read(bytes) != -1){
//			fos.write(bytes);
//		}
//		// close
//		fos.close();
//		in.close();
		
		HttpResponse response = null;
		
		HttpClientUtil.savaImage("http://jwxt.swpu.edu.cn/validateCodeAction.do", "c:\\validate.jpg");
		
		
//		Scanner s= new Scanner(System.in);
////		HttpPost post = new HttpPost("http://jwxt.swpu.edu.cn/loginAction.do?zjh=201305020346&mm=ZENYAN&v_yzm=" + s.next());
//		
//		HttpPost post = new HttpPost("http://jwxt.swpu.edu.cn/loginAction.do");
//		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
//		params.add(new BasicNameValuePair("zjh", "201305020346"));
//		params.add(new BasicNameValuePair("mm", "ZENYAN")); 
//		
//		params.add(new BasicNameValuePair("v_yzm", s.next()));
//		
//		HttpEntity entity = new UrlEncodedFormEntity(params);
//		
//		post.setEntity(entity);
//		
//		response = httpclient.execute(post);
//		response = httpclient.execute(new HttpPost("http://jwxt.swpu.edu.cn/xkAction.do?actionType=6"));
//		StringBuilder sb = new StringBuilder(EntityUtils.toString(response.getEntity()) );
//		
//		System.out.println(sb);
//		
		Scanner s = new Scanner(System.in);
		
		Map<String, String> param = new HashMap<String, String>();
			param.put("zjh", "201305020346");
			param.put("mm", "ZENYA");
			param.put("v_yzm", s.next());
		HttpClientUtil.doPost("http://jwxt.swpu.edu.cn/loginAction.do", param);
		System.out.println(HttpClientUtil.doPost("http://jwxt.swpu.edu.cn/xkAction.do?actionType=6", param));
		
		
		
	}
	


}
