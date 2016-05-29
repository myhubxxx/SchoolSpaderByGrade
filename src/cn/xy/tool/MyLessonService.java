package cn.xy.tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import cn.xy.domain.MyLesson;
import cn.xy.modle.Lesson;
import cn.zy.Exception.MyLessonException;

public class MyLessonService {

	private List<MyLesson> listLesson = new ArrayList<MyLesson>();
	private List<Lesson> oldLesson = null;

	/**
	 * 
	 * get the oldLesson and init oldLesson
	 * 
	 * @param username
	 * @param password
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	private void initLesson(String username, String password)
			throws ClientProtocolException, IOException {
		
		KeTable ke = new KeTable();
		oldLesson = ke.getKeBiao(username, password);

		
	}

	/**
	 * make the myLesson to init
	 * 
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public List<MyLesson> getMyLesson(String username, String password)
			throws ClientProtocolException, IOException {
			
		initLesson(username, password);
		
		MyLesson newLesson = null;
		for (int i = 0; i < oldLesson.size(); i++) {

			newLesson = toMyLesson(oldLesson.get(i));
			listLesson.add(newLesson);

		}
		
		return listLesson;
	}

	/**
	 * the function is make the Lesson to
	 * 
	 * chang into the MyLesson
	 * 
	 * 
	 */
	private MyLesson toMyLesson(Lesson lesson) {
		MyLesson myLesson = new MyLesson();

		myLesson.setLessonName(lesson.getLeName());
		myLesson.setLessonTeacher(lesson.getTeacher().replace("*", "").trim());

		// get the week
		String week = lesson.getTimeWeek();
		if (-1 != week.indexOf("ÖÜ")) {
			week = week.substring(0, week.indexOf("ÖÜ"));
			String[] _week = week.split("-");
			for (int i = 0; i < _week.length; i++) {
				_week[i] = _week[i].trim();
			}
			int[] weekInt = new int[2];
			weekInt[0] = Integer.parseInt(_week[0]);
			weekInt[1] = Integer.parseInt(_week[1]);
			myLesson.setLessonWeek(weekInt);
		}

		// get the day on every week
		String lessonWeek = lesson.getOnWeek();
		String[] _lessonWeek = lessonWeek.split("#");
		for (int i = 0; i < _lessonWeek.length; i++) {
			_lessonWeek[i] = _lessonWeek[i].trim();
		}
		int[] dayInt = new int[_lessonWeek.length];
		for (int i = 0; i < _lessonWeek.length; i++) {
			dayInt[i] = Integer.parseInt(_lessonWeek[i]);
		}
		myLesson.setLessonDay(dayInt);

		// get the on weekday
		String lessonDay = lesson.getJieChi();
		String[] _lessonDay = lessonDay.split("#");
		int[] OnDay = new int[_lessonDay.length];
		for (int i = 0; i < OnDay.length; i++) {
			OnDay[i] = Integer.parseInt(_lessonDay[i]);
		}
		myLesson.setLessonJie(OnDay);

		// get the calss count
		String count = lesson.getJieShu();
		String[] _count = count.split("#");
		for (int i = 0; i < _count.length; i++) {
			_count[i] = _count[i].trim();
		}
		int[] lessonCount = new int[_count.length];
		for (int i = 0; i < _count.length; i++) {
			lessonCount[i] = Integer.parseInt(_count[i]);
		}
		myLesson.setLessonCount(lessonCount);

		// get the location
		myLesson.setLessonLocation(lesson.getLocation().replace("#", "").trim());

		// get the class
		myLesson.setLessonClass(lesson.getJiaoShi().replace("#", "").trim());

		return myLesson;
	}

}
