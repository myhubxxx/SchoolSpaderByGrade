package cn.xy.modle;

public class Lesson {

	private String LeName;
	private String Teacher;
	private String TimeWeek;
	private String onWeek;
	private String jieChi;
	private String jieShu;
	private String location;
	
	public Lesson(String leName, String teacher, String timeWeek,
			String onWeek, String jieChi, String jieShu, String location,
			String jiaoShi) {
		super();
		LeName = leName;
		Teacher = teacher;
		TimeWeek = timeWeek;
		this.onWeek = onWeek;
		this.jieChi = jieChi;
		this.jieShu = jieShu;
		this.location = location;
		this.jiaoShi = jiaoShi;
	}

	private String jiaoShi;

	public Lesson() {
		super();
	}

	/**
	 * @return the leName
	 */
	public String getLeName() {
		return LeName;
	}

	/**
	 * @param leName
	 *            the leName to set
	 */
	public void setLeName(String leName) {
		LeName = leName;
	}

	/**
	 * @return the teacher
	 */
	public String getTeacher() {
		return Teacher;
	}

	/**
	 * @param teacher
	 *            the teacher to set
	 */
	public void setTeacher(String teacher) {
		Teacher = teacher;
	}

	/**
	 * @return the timeWeek
	 */
	public String getTimeWeek() {
		return TimeWeek;
	}

	/**
	 * @param timeWeek
	 *            the timeWeek to set
	 */
	public void setTimeWeek(String timeWeek) {
		TimeWeek = timeWeek;
	}

	/**
	 * @return the onWeek
	 */
	public String getOnWeek() {
		return onWeek;
	}

	/**
	 * @param onWeek
	 *            the onWeek to set
	 */
	public void setOnWeek(String onWeek) {
		this.onWeek = onWeek;
	}
	
	public void addOnWeek(String temp){
		
		this.onWeek = this.onWeek.concat(temp);
	}

	/**
	 * @return the jieChi
	 */
	public String getJieChi() {
		return jieChi;
	}

	/**
	 * @param jieChi
	 *            the jieChi to set
	 */
	public void setJieChi(String jieChi) {
		this.jieChi = jieChi;
	}
	
	public void addJieChi(String temp){
		
		this.jieChi = this.jieChi.concat(temp);
	}

	/**
	 * @return the jieShu
	 */
	public String getJieShu() {
		return jieShu;
	}

	/**
	 * @param jieShu
	 *            the jieShu to set
	 */
	public void setJieShu(String jieShu) {
		this.jieShu = jieShu;
	}
	public void addJieShu(String temp){
		
		this.jieShu = this.jieShu.concat(temp);
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the jiaoShi
	 */
	public String getJiaoShi() {
		return jiaoShi;
	}

	/**
	 * @param jiaoShi
	 *            the jiaoShi to set
	 */
	public void setJiaoShi(String jiaoShi) {
		this.jiaoShi = jiaoShi;
	}
	@Override
	public String toString() {
		return "Lesson [LeName=" + LeName + ", Teacher=" + Teacher
				+ ", TimeWeek=" + TimeWeek + ", onWeek=" + onWeek + ", jieChi="
				+ jieChi + ", jieShu=" + jieShu + ", location=" + location
				+ ", jiaoShi=" + jiaoShi + "]";
	}

	public void LessonPrint(){
		System.out.println(LeName+":"+Teacher+":"+TimeWeek+":"+onWeek+":"+jieChi+":"+jieShu+":"+location+":"+jiaoShi);
	}

}
