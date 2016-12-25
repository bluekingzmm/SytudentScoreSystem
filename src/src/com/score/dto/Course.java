package src.com.score.dto;

public class Course {

	private int code;// 课程编号
	private String coursename;// 课程名称

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public Course(int code, String coursename) {
		this.code = code;
		this.coursename = coursename;
	}

	public Course() {

	}

	public Course(int code) {
		this.code = code;

	}

	public String toString() {
		return this.code + "\t" + this.coursename;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Course))
			return false;
		else {
			Course course = (Course) obj;
			// 以课程编号为依据判断两个课程对象是否相同
			return this.code == course.getCode();
		}
	}

	@Override
	public int hashCode() {
		return this.code;
	}

}
