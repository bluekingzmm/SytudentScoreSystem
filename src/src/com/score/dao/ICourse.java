package src.com.score.dao;






import java.util.List;

import src.com.score.dto.Course;

public interface ICourse {

	/*
	 * ��ʦ���ӿγ�
	 */
	public boolean teaAddCourse(Course c) throws Exception;
	
	/*
	 * ��ʦɾ���γ�
	 */
	
	public boolean teaDelectCourse(int code) throws Exception;
	
	/*
	 * ��ʦ�޸Ŀγ�
	 */
	
	
	public boolean teaModifyCourse(Course c) throws Exception;
	

	
	/*
	 *��ʦ���տγ̱�����鿴�γ� 
	 */

	public Course findByCode(int code) throws Exception;
	

	
	
	
	public List<Course> dispListCourse(Course s) throws Exception ;
	
	
	
	

	
}
