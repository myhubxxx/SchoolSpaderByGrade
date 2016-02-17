package cn.ssbg.demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.junit.Test;

import cn.Util.HttpClientUtil;





public class PostVilidate {
	
	
	public void testImage(){
		
		StringBuilder sb = new StringBuilder( HttpClientUtil.doPost("http://jwxt.swpu.edu.cn/") );
		
//		System.out.println( sb );
		
		
	}
	
	public static void test2(){
		String url = "http://jwxt.swpu.edu.cn/validateCodeAction.do";
		
		StringBuilder sb  = new StringBuilder( HttpClientUtil.doGet(url) );
		
		
	}
	
	public static void post(String vilidate ){
		String url = "http://jwxt.swpu.edu.cn/loginAction.do";
				//?zjh=201305020346&mm=ZENYAN&v_yzm=";
		//url = url.concat(vilidate);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("zjh", "201305020346");
		params.put("mm", "ZENYAN");
		params.put("v_yzm", vilidate);
		
		
		StringBuilder sb = new StringBuilder( HttpClientUtil.doPost(url, params) );
		
		System.out.println(sb);
	}

	@Test
	public void downImage() throws MalformedURLException, IOException{
		String imgurl = "http://jwxt.swpu.edu.cn/validateCodeAction.do";
//		String imgurl = "http://jwxt.swpu.edu.cn/";
		
//		testImage();
		
//		test2();
		
		BufferedImage bi = ImageIO.read(new URL(imgurl)) ;
		
		if( bi != null){
			ImageIO.write(bi, "jpeg", new File("c:\\v.jpg"));
		}
		Scanner in = new Scanner(System.in);
		
		String vilidate = in.next();
		
		post(vilidate);
		
	}
}
