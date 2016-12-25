package src.com.score.dao;






import java.util.List;

import src.com.score.dto.Course;

public interface ICourse {

	/*
	 * 教师增加课程
	 */
	public boolean teaAddCourse(Course c) throws Exception;
	
	/*
	 * 教师删除课程
	 */
	
	public boolean teaDelectCourse(int code) throws Exception;
	
	/*
	 * 教师修改课程
	 */
	
	
	public boolean teaModifyCourse(Course c) throws Exception;
	

	
	/*
	 *教师按照课程编号来查看课程 
	 */

	public Course findByCode(int code) throws Exception;
	

	
	
	
	public List<Course> dispListCourse(Course s) throws Exception ;
	
	
	
	

	
}
