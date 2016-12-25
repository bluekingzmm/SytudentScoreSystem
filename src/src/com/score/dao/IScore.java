package src.com.score.dao;

import java.util.List;

import src.com.score.dto.Course;
import src.com.score.dto.Exam;
import src.com.score.dto.Score;
import src.com.score.dto.Student;

public interface IScore {

	/*
	 * 添加成绩
	 */

	public boolean addScore(Score s) throws Exception;

	/*
	 * 删除成绩
	 */

	public boolean delectScore(Score s) throws Exception;

	/*
	 * 删除学生所有成绩
	 */

	public boolean delectByStudent(Student s) throws Exception;

	/*
	 * 删除某课程所有成绩
	 */

	public boolean delectByCourse(Course c) throws Exception;

	/*
	 * 通过学生查找成绩
	 */

	public List<Exam> findByStudent(Student s) throws Exception;

	/*
	 * 通过课程查找成绩
	 */

	public  List<Exam> findByCourse(Course c) throws Exception;

	/*
	 * 课程和学生，————成绩
	 */

	public boolean modifyScore(Score s) throws Exception;

	public Score get(Student s, Course c) throws Exception;
	
	
	public List<Exam> lisp(int code) throws Exception;
	public Exam findByCourseLookExam(Course c) throws Exception ;

}
