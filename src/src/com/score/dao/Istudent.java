package src.com.score.dao;

import java.util.List;

import src.com.score.dto.Student;

public interface Istudent {

	/*
	 * ��ʦ����ѧ����Ϣ
	 */
	

	public boolean teaAddStudent(Student s) throws Exception;
	
	/*
	 * ��ʦɾ��ѧ����Ϣ
	 */
	
	public boolean teaDelectStudent(String num) throws Exception;
	
	/*
	 * ��ʦ�޸�ѧ����Ϣ
	 */
	
	
	public boolean teaModifyStudent(Student s) throws Exception;

	
	/*
	 * ��ʦ����ѧ����Ų鿴ѧ����Ϣ
	 */

	
	public Student getNum(String num) throws Exception;
	
	/*
	 * ����ѧ��������ѧ������
	 */
	


	public List<Student> dispListStudent(Student s) throws Exception; 
	
	public Student getPassword(String stu_password) throws Exception ;
	
	public  Student Login(String stu_id, String stu_password) throws Exception ;

}
