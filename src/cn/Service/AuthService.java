package cn.Service;

import java.util.HashMap;
import java.util.Map;

import cn.Util.HttpClientUtil;
import cn.Util.PropertiesUtil;

public class AuthService {
	
	public boolean Auth(String username, String password, String validataCode){
		
		String loginUrl = PropertiesUtil.getValue("loginUrl");
		
		Map<String, String> param = new HashMap<String, String>();
			param.put("zjh", username);
			param.put("mm", password);
			param.put("v_yzm", validataCode);
		
		StringBuilder sb = new StringBuilder(HttpClientUtil.doPost(loginUrl, param));
		
		// the form info is wrong
		if(sb.toString().contains("¥ÌŒÛ–≈œ¢")){
			return false;
		}
		
//		System.out.println(sb);
		
		return true;
	}

}
