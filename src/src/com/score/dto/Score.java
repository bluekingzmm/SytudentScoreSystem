/**
 * 
 */
package src.com.score.dto;

/**
 * @author Administrator
 *
 */
public class Score {

	private Student student; // 将学生信息调过来
	private Course course;
	private double score; // 成绩分数

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Score() {

	}

	public Score(Student student, Course course, double score) {
		this.student = student;
		this.course = course;
		this.score = score;
	}

	public String toString() {
		return this.student.getName() + "\t" + this.student.getNum() + "\t" + this.course.getCoursename() + "\t\t"
				+ this.course.getCode() + "\t\t" + this.score;
	}

}