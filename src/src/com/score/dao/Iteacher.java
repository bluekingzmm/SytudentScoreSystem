package src.com.score.dao;
import java.util.List;

import src.com.score.dto.Teacher;

public interface Iteacher {

	
	/*
	 * 教师增加教师信息
	 */
	

	public boolean teaAddTeacher(Teacher t) throws Exception;
	
	
	/*
	 * 教师删除教师信息
	 */
	
	public boolean teaDelectTeacher(String teacode) throws Exception;
	
	
	/*
	 * 教师修改教师信息
	 */
	
	
	public boolean teaModifyTeacher(Teacher t) throws Exception;
	
	
	/*
	 * 教师按照编号查找教师信息
	 */

	public Teacher getTeacode(String teacode) throws Exception;
	
	
	/*
	 * 
	 */

	public List<Teacher> sortTeacherByteacode() throws Exception;
	
	public List<Teacher> sortTeacherBymoney() throws Exception ;

	public Teacher Login(String tea_id, String password) throws Exception ;
	

	
}
