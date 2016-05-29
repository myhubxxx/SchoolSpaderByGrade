package cn.xy.domain;

import java.util.Arrays;

public class MyLesson {
	private String LessonName;
	private String LessonTeacher;
	private int[]  LessonWeek;
	private int[]  LessonDay;
	private int[]  LessonJie;
	private int[]  LessonCount;
	private String LessonLocation;
	private String LessonClass;
	public String getLessonName() {
		return LessonName;
	}
	public void setLessonName(String lessonName) {
		LessonName = lessonName;
	}
	public String getLessonTeacher() {
		return LessonTeacher;
	}
	public void setLessonTeacher(String lessonTeacher) {
		LessonTeacher = lessonTeacher;
	}
	public int[] getLessonWeek() {
		return LessonWeek;
	}
	public void setLessonWeek(int[] lessonWeek) {
		LessonWeek = lessonWeek;
	}
	public int[] getLessonDay() {
		return LessonDay;
	}
	public void setLessonDay(int[] lessonDay) {
		LessonDay = lessonDay;
	}
	public int[] getLessonJie() {
		return LessonJie;
	}
	public void setLessonJie(int[] lessonJie) {
		LessonJie = lessonJie;
	}
	public int[] getLessonCount() {
		return LessonCount;
	}
	public void setLessonCount(int[] lessonCount) {
		LessonCount = lessonCount;
	}
	public String getLessonLocation() {
		return LessonLocation;
	}
	public void setLessonLocation(String lessonLocation) {
		LessonLocation = lessonLocation;
	}
	public String getLessonClass() {
		return LessonClass;
	}
	public void setLessonClass(String lessonClass) {
		LessonClass = lessonClass;
	}
	@Override
	public String toString() {
		return "MyLesson [LessonName=" + LessonName + ", LessonTeacher="
				+ LessonTeacher + ", LessonWeek=" + Arrays.toString(LessonWeek)
				+ ", LessonDay=" + Arrays.toString(LessonDay) + ", LessonJie="
				+ Arrays.toString(LessonJie) + ", LessonCount="
				+ Arrays.toString(LessonCount) + ", LessonLocation="
				+ LessonLocation + ", LessonClass=" + LessonClass + "]";
	}
	public MyLesson(String lessonName, String lessonTeacher, int[] lessonWeek,
			int[] lessonDay, int[] lessonJie, int[] lessonCount,
			String lessonLocation, String lessonClass) {
		super();
		LessonName = lessonName;
		LessonTeacher = lessonTeacher;
		LessonWeek = lessonWeek;
		LessonDay = lessonDay;
		LessonJie = lessonJie;
		LessonCount = lessonCount;
		LessonLocation = lessonLocation;
		LessonClass = lessonClass;
	}
	public MyLesson() {
		super();
	}
	
	
}
