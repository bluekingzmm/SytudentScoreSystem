package src.com.score.dao;

import java.util.List;

import src.com.score.dto.Student;

public interface Istudent {

	/*
	 * 教师增加学生信息
	 */
	

	public boolean teaAddStudent(Student s) throws Exception;
	
	/*
	 * 教师删除学生信息
	 */
	
	public boolean teaDelectStudent(String num) throws Exception;
	
	/*
	 * 教师修改学生信息
	 */
	
	
	public boolean teaModifyStudent(Student s) throws Exception;

	
	/*
	 * 教师按照学生编号查看学生信息
	 */

	
	public Student getNum(String num) throws Exception;
	
	/*
	 * 根据学生姓名，学号排序
	 */
	


	public List<Student> dispListStudent(Student s) throws Exception; 
	
	public Student getPassword(String stu_password) throws Exception ;
	
	public  Student Login(String stu_id, String stu_password) throws Exception ;

}
