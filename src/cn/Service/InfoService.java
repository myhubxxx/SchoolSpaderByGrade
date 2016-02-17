package cn.Service;

import cn.Util.HttpClientUtil;
import cn.Util.PropertiesUtil;

public class InfoService {
	
	// get the grade 
	public StringBuilder getGrade(){
		
		String graderUrl = PropertiesUtil.getValue("GradeUrl");
			
		return new StringBuilder(HttpClientUtil.doPost(graderUrl));

	}
	// get the lesson info
	public StringBuilder getLesson(){
		
		String lessonUrl = PropertiesUtil.getValue("LessonTableUrl");
		
		return new StringBuilder(HttpClientUtil.doPost(lessonUrl));
	}
	
	

}
