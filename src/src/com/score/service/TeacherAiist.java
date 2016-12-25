package src.com.score.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.com.score.dao.Iteacher;
import src.com.score.dao.impl.TeacherImplMysql;
import src.com.score.db.MysaqlDataBase;
import src.com.score.dto.Teacher;

public class TeacherAiist extends MysaqlDataBase {

	Scanner sc = new Scanner(System.in);
	Iteacher teacher = new TeacherImplMysql();
	private static Teacher tea;

	/*
	 * 增加课程信息 public boolean teaAddCourse(Course c) throws Exception;
	 */
	public void tesAddTeacher() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Teacher t = new Teacher();
				System.out.println("请输入教师姓名");
				t.setName(sc.next());
				System.out.println("请输入教师性别");
				t.setSex(sc.next());
				System.out.println("请输入教师编号");
				t.setTeacode(sc.next());
				System.out.println("请输入教师年龄");
				t.setAge(sc.nextInt());
				System.out.println("请输入教师工资");
				t.setMoney(sc.nextDouble());
				if (teacher.teaAddTeacher(t)) {
					System.out.println("录入成功！！");
					lispTeacher(t);
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

	public void findListTeacher() throws Exception {
		// TODO Auto-generated method stub
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入教师编号");
				String teacode = sc.next();
				Teacher tea = teacher.getTeacode(teacode);
				if (tea != null) {
					listTeacherINfo(teacode);
				} else {
					System.out.println("没有编号为" + teacode + "的教师");
				}

				System.out.println("输入n或者N则停止查找，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}

	}

	public List<Teacher> listTeacherINfo(String teacode) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Teacher> sList = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from tealogin where tea_id=? ");
			ps.setString(1, teacode);
			rs = ps.executeQuery();
			sList = new ArrayList<Teacher>();
			System.out.println("姓名\t性别\t年龄\t教师编号\t工资");
			while (rs.next()) {
				Teacher tea = new Teacher();
				tea.setName(rs.getString("name"));
				tea.setSex(rs.getString("sex"));
				tea.setTeacode(rs.getString("tea_id"));
				tea.setAge(rs.getInt("age"));
				tea.setMoney(rs.getDouble("money"));
				sList.add(tea);
				System.out.println(tea);
			}
		} catch (Exception e) {
			// TODO: handle exception

		}
		TeacherImplMysql.free(rs, ps, con);

		return sList;
	}

	/*
	 * public boolean teaDelectCourse(int code) throws Exception; 根据课程编号查找课程
	 */

	public void teaDelectTeacher() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入教师编号");
				String teacode = sc.next();
				Teacher t = teacher.getTeacode(teacode);
				listTeacherINfo(teacode);
				if (t != null) {
					if (teacher.teaDelectTeacher(teacode)) {
						System.out.println("删除成功");
					} else {
						System.out.println("删除失败！");
					}
				} else {
					System.out.println("没有编号为" + teacode + "的教师");
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

	public void tesModifyTeacher() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				// System.out.println("请输入教师编号");
				// String teacode = sc.next();
				// Teacher t = teacher.getTeacode(tea.getTeacode());
				listTeacherINfo(tea.getTeacode());
				System.out.println("1：                        教师工资");
				System.out.println("2：                        教师的年龄");
				System.out.println("3:            教师的登录密码");
				System.out.println("           请输入你的选择");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1：                        教师工资");
					tea.setMoney(sc.nextDouble());
					break;
				case 2:
					System.out.println("2：                        教师年龄");
					tea.setAge(sc.nextInt());
					break;
				case 3:
					System.out.println("3:            教师的登录密码");
					tea.setPassword(sc.next());
					break;
				default:
					break;
				}
				if (teacher.teaModifyTeacher(tea)) {
					System.out.println("修改成功！！！");
				} else {
					System.out.println("修改失败！！");
				}
				System.out.println("输入n或者N则退出修改，任意键继续!");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}

	}

	public void sortByKeyTeacher() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("1:   按照教师编号排序");
				System.out.println("2:    按照教师工资排序");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					teacher.sortTeacherByteacode();
					break;
				case 2:
					teacher.sortTeacherBymoney();
					break;

				default:
					break;
				}
				System.out.println("任意键继续排序，输入n或者N则退出排序");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public List<Teacher> lispTeacher(Teacher t) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Teacher> sList = null;

		try {
			con = getConn();
			ps = con.prepareStatement("SELECT * FROM tealogin  ");
			rs = ps.executeQuery();
			sList = new ArrayList<Teacher>();
			System.out.println("姓名\t性别\t年龄\t教师编号\t工资");
			while (rs.next()) {
				t = new Teacher();
				t.setName(rs.getString("name"));
				t.setSex(rs.getString("sex"));
				t.setTeacode(rs.getString("tea_id"));
				t.setAge(rs.getInt("age"));
				t.setMoney(rs.getDouble("money"));
				sList.add(t);
				System.out.println(t);
			}
		} catch (Exception e) {
			// TODO: handle exception

		}

		TeacherImplMysql.free(rs, ps, con);
		return sList;
	}

	public void lispTeacher() {
		lispTeacher(tea);
	}

	public boolean loginTeacher() throws Exception {
		System.out.println("请输入你的教师编号");
		String tea_id = sc.next();
		System.out.println("请输入你的密码");
		String password = sc.next();
		tea = teacher.Login(tea_id, password);
		if (tea != null) {
			System.out.println("欢迎你" + tea.getName());

			return true;
		}

		else
			return false;
	}

	public void changePassword() {
		try {
			System.out.println("请输入原密码");
			String oldpassword = sc.next();
			if (oldpassword.equals(tea.getPassword())) {
			}
			System.out.println("请输入新密码");
			String newpassword = sc.next();
			System.out.println("请再一次输入密码，进行确认");
			String arginpassword = sc.next();
			if (newpassword.equals(arginpassword)) {
				tea.setPassword(arginpassword);
				if (teacher.teaModifyTeacher(tea)) {
					System.out.println("密码修改成功！");
				} else {
					System.out.println("修改失败！！");
				}
			} else {
				System.out.println("两次输入的不同！！");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
