package src.com.score.dao;
import java.util.List;

import src.com.score.dto.Teacher;

public interface Iteacher {

	
	/*
	 * ��ʦ���ӽ�ʦ��Ϣ
	 */
	

	public boolean teaAddTeacher(Teacher t) throws Exception;
	
	
	/*
	 * ��ʦɾ����ʦ��Ϣ
	 */
	
	public boolean teaDelectTeacher(String teacode) throws Exception;
	
	
	/*
	 * ��ʦ�޸Ľ�ʦ��Ϣ
	 */
	
	
	public boolean teaModifyTeacher(Teacher t) throws Exception;
	
	
	/*
	 * ��ʦ���ձ�Ų��ҽ�ʦ��Ϣ
	 */

	public Teacher getTeacode(String teacode) throws Exception;
	
	
	/*
	 * 
	 */

	public List<Teacher> sortTeacherByteacode() throws Exception;
	
	public List<Teacher> sortTeacherBymoney() throws Exception ;

	public Teacher Login(String tea_id, String password) throws Exception ;
	

	
}
