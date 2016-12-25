/**
 * 
 */
package src.com.score.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.com.score.dao.ICourse;
import src.com.score.dao.impl.CourseImplMysql;
import src.com.score.dao.impl.TeacherImplMysql;
import src.com.score.db.MysaqlDataBase;
import src.com.score.dto.Course;

/**
 * @author Administrator
 *
 */
public class CourseAiist extends MysaqlDataBase {

	Scanner sc = new Scanner(System.in);
	ICourse course = new CourseImplMysql();

	/*
	 * 教师增加课程信息 public boolean teaAddCourse(Course c) throws Exception;
	 * 并给出录入情况
	 */
	public void tesAddCourse() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Course c = new Course();
				System.out.println("请输入课程编号");
				c.setCode(sc.nextInt());
				System.out.println("请输入课程名称");
				c.setCoursename(sc.next());
				if (course.teaAddCourse(c)) {
					System.out.println("录入成功！！");
					course.dispListCourse(c);
				} else {
					System.out.println("录入失败！！！");
				}
				System.out.println("输入n或者N则退出录入，任意键继续!");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}

	}

	/*
	 * public boolean teaDelectCourse(int code) throws Exception; 教师根据课程编号删除课程
	 * 并给出删除情况
	 */

	public void teaDelectCourse() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号");
				int code = sc.nextInt();
				Course c = course.findByCode(code);
				course.dispListCourse(c);
				if (course.teaDelectCourse(code)) {
					System.out.println("删除成功");
				} else {
					System.out.println("删除失败！");
				}
				System.out.println("输入n或者N则退出录入，任意键继续!");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}

	}
/*
 * List集合存放查找的课程
 */
	public List<Course> dispListCourse() throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course c = null;
		List<Course> cList = null;
		try {
			ps = con.prepareStatement("select * from  couse ");

			rs = ps.executeQuery();
			cList = new ArrayList<Course>();
			
			while (rs.next()) {
				c = new Course();
				c.setCode(rs.getInt("couse_id"));
				c.setCoursename(rs.getString("couse_name"));
				cList.add(c);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(ps, con);

		return cList;
	}
	/*
	 * 显示所有的课程信息，根据dispListCourse （for）方法，输出查询的内容
	 */
	public List<Course> dispAllCourse() throws Exception{
		System.out.println("课程编号\t课程名");
		List<Course> sList=dispListCourse();
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}
		return sList;
	}
	/*
	 * 教师修改课程（课程编号）
	 * 提示修改的情况
	 */

	public void tesModifyCourse() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号");
				int code = sc.nextInt();
				Course c = course.findByCode(code);
			course.dispListCourse(c);
				if (c != null) {
					System.out.println("请修改课程名称");
					c.setCoursename(sc.next());
				} else {
					System.out.println("没有课程编号为" + code + "的课程");
				}
				if (course.teaModifyCourse(c)) {
					System.out.println("修改成功！");
					course.dispListCourse(c);
				} else {
					System.out.println("修改失败！");
				}
				System.out.println("输入n或者N退出修改，任意键继续！");
				yes = sc.next();

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}

	}

	/*
	 * 根据课程编号进行查询
	 */

	public void findByCode() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号");
				int code = sc.nextInt();
				Course c = course.findByCode(code);
				if (c != null) {
					course.dispListCourse(c);
				} else {
					System.out.println("没有编号为" + code + "的课程！！");
				}
				System.out.println("输入n或者N则退出查找，任意键继续!");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明;");
			e.printStackTrace();
		}

	}

}
