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

		try { // HttpClient��Ҫ����ִ������
			httpclient = new DefaultHttpClient();
			context = new BasicHttpContext();

			// ����HTTP GET���������������
			HttpGet get = new HttpGet(
					"http://xk.swpu.edu.cn:9099/loginAction.do");
			//

			// ��÷�������Ӧ�ĵ�������Ϣ
			HttpResponse response = httpclient.execute(get, context);
			// ��÷�������Ӧ��������Ϣ�壨������HTTP HEAD��
			HttpEntity entity = response.getEntity();
			String charset = null;

			if (entity != null) {
				// �����Ӧ���ַ���������Ϣ //����ȡHTTP
				// HEAD�ģ�Content-Type:text/html;charset=UTF-8�е��ַ�����Ϣ

				// charset = EntityUtils.getContentCharSet(entity);
				charset = "GBK";

			//	System.out.println("��Ӧ���ַ����ǣ�" + charset);
				InputStream is = entity.getContent();
				// ʹ����Ӧ�еı�����������Ӧ������
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, charset));
				String line = null;
				while ((line = br.readLine()) != null) {
					// System.out.println(line);
				}
				is.close();
			}

			// ************* ִ�е�¼���� ********************//
			HttpPost post = new HttpPost(
					"http://xk.swpu.edu.cn:9099/loginAction.do");
			// ���POST����
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("zjh", uname));
			nvps.add(new BasicNameValuePair("mm", upass));
			post.setEntity(new UrlEncodedFormEntity(nvps, charset));
			response = httpclient.execute(post);
			entity = response.getEntity();
			if (entity != null) {
				InputStream is = entity.getContent();
				// ʹ����Ӧ�еı�����������Ӧ������
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, "GBK"));
				String line = null;
				while ((line = br.readLine()) != null) {
					// System.out.println(line);
				}
		//		System.out.println("���񴦽���ɹ�������");
				is.close();
			}
		//  ȫ������ɼ�  type = 0	
			if( type == 0 ){
				get = new HttpGet(		
					"http://xk.swpu.edu.cn:9099/gradeLnAllAction.do?type=ln&oper=qbinfo&lnxndm=2013-2014%D1%A7%C4%EA%C7%EF(%C1%BD%D1%A7%C6%DA)#2013-2014ѧ����(��ѧ��)");
			}
		// �α�  type = 1
			if( type == 1)
			get = new HttpGet(
					"http://xk.swpu.edu.cn:9099/xkAction.do?actionType=6");
			response = httpclient.execute(get);
			entity = response.getEntity();
			if (entity != null) {
				InputStream is = entity.getContent();
				// ʹ����Ӧ�еı�����������Ӧ������
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, charset));
				String line = null;
				while ((line = br.readLine()) != null) {
				//	System.out.println(line);
				//	System.out.println(" =================oneline======================= ");

					strBu.append(line);
				}
				is.close();
			} // �ͷ����е�������Դ��һ�������е����������֮�󣬲���Ҫ�ͷ�
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
