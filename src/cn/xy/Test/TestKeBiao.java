package cn.xy.Test;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import cn.xy.domain.MyLesson;
import cn.xy.modle.Lesson;
import cn.xy.tool.KeTable;
import cn.xy.tool.MyLessonService;

public class TestKeBiao {

		
	@Test
	public void testKEBiao() throws ClientProtocolException, IOException {

		List<Lesson> list = null;
		KeTable ke = new KeTable();
		list = ke.getKeBiao("201305020346", "ZENYAN");

		for (int i = 0; i < list.size(); i++) {
			Lesson le = list.get(i);
			le.LessonPrint();
		}

	}

	@Test
	public void TestMyLesson() {

		String week = "1-18周上";
		week = week.substring(0, week.indexOf("周"));
		String[] _week = week.split("-");
		int[] weekInt = new int[2];
		weekInt[0] = Integer.parseInt(_week[0]);
		weekInt[1] = Integer.parseInt(_week[1]);
		System.out.println(weekInt[0] + ":" + weekInt[1]);
	}

	@Test
	public void fun1() {

		String lessonWeek = " 2# 3# 5#";
		String[] _lessonWeek = lessonWeek.split("#");
		for (int i = 0; i < _lessonWeek.length; i++) {
			_lessonWeek[i] = _lessonWeek[i].trim();
		}
		int[] dayInt = new int[_lessonWeek.length];
		for (int i = 0; i < _lessonWeek.length; i++) {
			dayInt[i] = Integer.parseInt(_lessonWeek[i]);
		}

		System.out.print(dayInt[0]);
		System.out.print(dayInt[1]);
		System.out.print(dayInt[2] + ";");

	}

	@Test
	public void fun2() {
		String lessonDay = "3#8#1#";
		String[] _lessonDay = lessonDay.split("#");
		int[] OnDay = new int[_lessonDay.length];
		for (int i = 0; i < OnDay.length; i++) {
			OnDay[i] = Integer.parseInt(_lessonDay[i]);
		}
		System.out.print(OnDay[0]);
		System.out.print(OnDay[1]);
		System.out.print(OnDay[2] + ";");

	}

	@Test
	public void fun3() {
		String count = " 2# 2# 2#";
		String[] _count = count.split("#");
		for (int i = 0; i < _count.length; i++) {
			_count[i] = _count[i].trim();
		}
		System.out.println(_count.length);
		int[] lessonCount = new int[_count.length];
		for (int i = 0; i < _count.length; i++) {
			lessonCount[i] = Integer.parseInt(_count[i]);
		}
		System.out.print(lessonCount[0]);
		System.out.print(lessonCount[1]);
		System.out.print(lessonCount[2] + ";");
	}

	@Test
	public void fun4() {
		String str = (" 思学楼#".replace("#", "").trim());
		System.out.println(str);
	}
	Lesson lesson = new Lesson("概率统计(Ⅱ)","刘玲伶* * "," 10-17周上"," 2# 3# 5#","3#8#1#"," 2# 2# 2#"," 思学楼#"," B110#");
	@Test
	public void fun5() {
		
		MyLesson myLesson = new MyLesson();

		myLesson.setLessonName(lesson.getLeName());
		myLesson.setLessonTeacher(lesson.getTeacher().replace("*", "").trim());

		// get the week
		String week = lesson.getTimeWeek();
		week = week.substring(0, week.indexOf("周"));
		String[] _week = week.split("-");
		for (int i = 0; i < _week.length; i++) {
			_week[i] = _week[i].trim();
		}
		int[] weekInt = new int[2];
		weekInt[0] = Integer.parseInt(_week[0]);
		weekInt[1] = Integer.parseInt(_week[1]);
		myLesson.setLessonWeek(weekInt);

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
		
		System.out.println(myLesson);

	}
	@Test
	public void last() throws ClientProtocolException, IOException{
		MyLessonService ms = new MyLessonService();
		
		
		List<MyLesson> list = ms.getMyLesson("201305020346", "ZENYAN");
		for (MyLesson myLesson : list) {
			System.out.println(myLesson);
		}

		}
		
	

}
