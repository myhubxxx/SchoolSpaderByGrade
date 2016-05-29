package cn.xy.tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import cn.xy.me.Ppost;
import cn.xy.modle.Lesson;
import cn.zy.Exception.MyLessonException;

public class KeTable {

	private final String flagLesson = "<tr class=\"odd\" onMouseOut=\"this.className='even';\" onMouseOver=\"this.className='evenfocus';\">";
	private final String flagWeek = "<tr class=odd onMouseOut=this.className='even'; onMouseOver=this.className='evenfocus';>";
	private final String flagName = "&nbsp;";
	private final String flagEnd = "</td>";
	private List<Lesson> lesson = new ArrayList<Lesson>();
	private StringBuffer sb = null;

	private int[] StrJump(String aLesson, int num){
		int[] a = new int[2];
		
		for ( int i =0;i < num; i++) {  // get the lesson name   
			a[0] = aLesson.indexOf(flagName, a[0]);
			a[0] = a[0] + flagName.length();
			a[1] = aLesson.indexOf( flagEnd, a[0] );
		}
		
		
		return a; 
	}
	/**
	 * return the lesson
	 * 
	 * @param uname
	 * @param upass
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public List<Lesson> getKeBiao(String uname, String upass)
			throws ClientProtocolException, IOException {

		Ppost p = new Ppost();
		sb = p.getKB(uname, upass, 1);

		getLesson(sb);

		return lesson;
	}

	/**
	 * get the lesson from the StringBuffer
	 * 
	 * 
	 * @param sb
	 */
	public void getLesson(StringBuffer sb) {

		int index = 0;
		int temp = 0;
		while ((index = sb.indexOf(flagLesson, index)) != -1) { // list the all
			// Lessons
			index = index + flagLesson.length();
			int tempIndex = sb.indexOf(flagLesson, index);
			if(tempIndex == -1){
				tempIndex = sb.length();
			}
			
			String aLesson = sb.substring(index, tempIndex);
//			System.out.println(index+":"+tempIndex);
//			System.out.println(aLesson);
//			System.out.println(sb.indexOf(flagWeek));
//			System.out.println(sb.length());
			
			// this get the nam,e teacher, week.
			Lesson tempLesson = new Lesson();
			// lesson name
			int[] myTemp = StrJump(aLesson, 3);// jump 3 get the course name
			String lessonName = aLesson.substring(myTemp[0], myTemp[1]);
			tempLesson.setLeName(lessonName);
			
			myTemp = StrJump(aLesson, 8);  // jump 8 get the teacher name
			String lessonTeacher = aLesson.substring(myTemp[0], myTemp[1]);
			tempLesson.setTeacher(lessonTeacher);
			
			myTemp = StrJump(aLesson, 11); // jump 11 get the week 
			String lessonWeek = aLesson.substring(myTemp[0], myTemp[1]);
			tempLesson.setTimeWeek(lessonWeek);
			
			myTemp = StrJump(aLesson, 12); // jump 12 get the onWeek 
			String lessonOnWeek = aLesson.substring(myTemp[0], myTemp[1]);
			lessonOnWeek = lessonOnWeek.concat("#");
			tempLesson.setOnWeek(lessonOnWeek);

			myTemp = StrJump(aLesson, 13); // jump 13 get the Jiechi 
			String lessonJieChi = aLesson.substring(myTemp[0], myTemp[1]);
			lessonJieChi = lessonJieChi.concat("#");
			tempLesson.setJieChi(lessonJieChi);
			
			myTemp = StrJump(aLesson, 14); // jump 14 get the JieShu
			String lessonJieShu = aLesson.substring(myTemp[0], myTemp[1]);
			lessonJieShu = lessonJieShu.concat("#");
			tempLesson.setJieShu(lessonJieShu);
			
			myTemp = StrJump(aLesson, 16); // jump 16 get the JieShu
			String lessonLocation = aLesson.substring(myTemp[0], myTemp[1]);
			lessonLocation = lessonLocation.concat("#");
			tempLesson.setLocation(lessonLocation);
			
			myTemp = StrJump(aLesson, 17); // jump 17 get the JieShu
			String lessonJiaoShi = aLesson.substring(myTemp[0], myTemp[1]);
			lessonJiaoShi = lessonJiaoShi.concat("#");
			tempLesson.setJiaoShi(lessonJiaoShi);


			//  lesson week when the lesson have more than one onWeek
			int indexWeek = 0;

			while ((indexWeek = aLesson.indexOf(flagWeek, indexWeek)) != -1) { // the week of the lesson list

				indexWeek = indexWeek + flagWeek.length();
				int tempEnd = aLesson.indexOf("</tr>", indexWeek);
				String moreWeek = aLesson.substring(indexWeek, tempEnd);

				// to get the lesson info
				myTemp = StrJump(moreWeek, 2); // jump 2 get the OnWeek
				String	lessonMoreWeek = moreWeek.substring(myTemp[0], myTemp[1]);
				lessonMoreWeek = lessonMoreWeek.concat("#");
				tempLesson.addOnWeek(lessonMoreWeek);

				myTemp = StrJump(moreWeek, 3); // jump 3 get the OnWeek
				String	lessonMoreJieChi = moreWeek.substring(myTemp[0], myTemp[1]);
				lessonMoreJieChi = lessonMoreJieChi.concat("#");
				tempLesson.addJieChi(lessonMoreJieChi);

				myTemp = StrJump(moreWeek, 4); // jump 4 get the OnWeek
				String	lessonMoreJieShu = moreWeek.substring(myTemp[0], myTemp[1]);
				lessonMoreJieShu = lessonMoreJieShu.concat("#");
				tempLesson.addJieShu(lessonMoreJieShu);
		//		System.out.println(tempLesson.getJieShu());
				
				

	
			}
			
			lesson.add(tempLesson);
			
		}

	}

}
