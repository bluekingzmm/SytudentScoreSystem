package src.com.score.dao;

import java.util.List;

import src.com.score.dto.Course;
import src.com.score.dto.Exam;
import src.com.score.dto.Score;
import src.com.score.dto.Student;

public interface IScore {

	/*
	 * ��ӳɼ�
	 */

	public boolean addScore(Score s) throws Exception;

	/*
	 * ɾ���ɼ�
	 */

	public boolean delectScore(Score s) throws Exception;

	/*
	 * ɾ��ѧ�����гɼ�
	 */

	public boolean delectByStudent(Student s) throws Exception;

	/*
	 * ɾ��ĳ�γ����гɼ�
	 */

	public boolean delectByCourse(Course c) throws Exception;

	/*
	 * ͨ��ѧ�����ҳɼ�
	 */

	public List<Exam> findByStudent(Student s) throws Exception;

	/*
	 * ͨ���γ̲��ҳɼ�
	 */

	public  List<Exam> findByCourse(Course c) throws Exception;

	/*
	 * �γ̺�ѧ�������������ɼ�
	 */

	public boolean modifyScore(Score s) throws Exception;

	public Score get(Student s, Course c) throws Exception;
	
	
	public List<Exam> lisp(int code) throws Exception;
	public Exam findByCourseLookExam(Course c) throws Exception ;

}
