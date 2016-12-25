package src.com.score.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.com.score.dao.IScore;
import src.com.score.dao.Istudent;
import src.com.score.dao.impl.ScoreImplMysql;
import src.com.score.dao.impl.StudentImplMysql;
import src.com.score.dao.impl.TeacherImplMysql;
import src.com.score.db.MysaqlDataBase;
import src.com.score.dto.Exam;
import src.com.score.dto.Student;

public class StudentAiist extends MysaqlDataBase {

	IScore scoreimpl = new ScoreImplMysql();
	Scanner sc = new Scanner(System.in);
	Istudent studentimpl = new StudentImplMysql();
	// ScoreAiist sa = new ScoreAiist();
	private List<Student> sList;
	


	/*
	 * 根据学生学号查找学生
	 */
	public void findListStuden() throws Exception {
		// TODO Auto-generated method stub

		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入学生学号");
				String num = sc.next();
				Student s = studentimpl.getNum(num);
				if (s != null) {
					studentimpl.dispListStudent(s);
				} else {
					System.out.println("没有学号为" + num + "的学生");
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

	// public void sortByKeyStudent() {
	// try {
	// String yes = "y";
	// while (!yes.equalsIgnoreCase("n")) {
	// System.out.println("1: 按照学生姓名排序");
	// System.out.println("2: 按照学生学号排序");
	// System.out.println("请 输 入 你 的 选 择 ");
	// List<Student> sList = student.sortStudent(sc.nextInt());
	// for (int i = 0; i < sList.size(); i++) {
	// System.out.println(sList.get(i));
	// }
	//
	// System.out.println("任意键继续排序，输入n或者N则退出排序");
	// yes = sc.next();
	// }
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// }
	/*
	 * 功能：显示所有学生，存在List（Student）中
	 */
	public List<Student> listAllStudent() throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student s = null;
		sList = new ArrayList<Student>();
		try {
			ps = con.prepareStatement("select * from stulogin ");
			rs = ps.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setName(rs.getString("stu_name"));
				s.setSex(rs.getString("sex"));
				s.setAge(rs.getInt("age"));
				s.setNum(rs.getString("stu_id"));
				s.setNativeplace(rs.getString("nativeplace"));
				s.setDepartment(rs.getString("department"));
				s.setMobilephone(rs.getString("mobilephone"));
				s.setChange(rs.getString("change_stu"));
				s.setGradue(rs.getString("gradue"));
				sList.add(s);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(ps, con);
		return sList;
	}
	/*
	 * 教师增加学生信息
	 */

	public void tesAddStudent() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Student s = new Student();
				System.out.println("请输入学生姓名");
				s.setName(sc.next());
				System.out.println("请输入教学生性别");
				s.setSex(sc.next());
				System.out.println("请输入学生密码");
				s.setPassword(sc.next());
				System.out.println("请输入学生年龄");
				s.setAge(sc.nextInt());
				System.out.println("请输入学生学号");
				s.setNum(sc.next());
				System.out.println("请输入学生籍贯");
				s.setNativeplace(sc.next());
				System.out.println("请输入学生所在系部");
				s.setDepartment(sc.next());
				System.out.println("请输入学生电话");
				s.setMobilephone(sc.next());
				System.out.println("请输入学生学籍异动");
				s.setChange(sc.next());
				System.out.println("请输入学生是否毕业");
				s.setGradue(sc.next());
				if (studentimpl.teaAddStudent(s)) {
					System.out.println("录入成功！！");
					studentimpl.dispListStudent(s);
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
	 * 教师通过学生编号删除学生信息
	 */

	public void teaDelectStudent() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入学生编号");
				String num = sc.next();
				Student s = studentimpl.getNum(num);
				studentimpl.dispListStudent(s);
				if (studentimpl.teaDelectStudent(num)) {
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
	 * 教师修改学生信息
	 */

	public void tesModifyStudent() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入学生编号");
				String num = sc.next();
				Student s = studentimpl.getNum(num);
				studentimpl.dispListStudent(s);
				System.out.println("1:          学生名字");
				System.out.println("2：                         学生性别");
				System.out.println("3：                        学生年龄");
				System.out.println("4：                        学生学号");
				System.out.println("5：                        电话号码");
				System.out.println("6：                        所在籍贯");
				System.out.println("7：                        所在系部");
				System.out.println("8:          学籍异动");
				System.out.println("9:          是否毕业");
				System.out.println("           请输入你的选择");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:          学生名字");
					s.setName(sc.next());
					break;
				case 2:
					System.out.println("2：                         学生性别");
					s.setSex(sc.next());
					break;
				case 3:
					System.out.println("3：                        学生年龄");
					s.setAge(sc.nextInt());
					break;
				case 4:
					System.out.println("4：                        学生学号");
					s.setNum(sc.next());
					break;
				case 5:
					System.out.println("5：                        电话号码");
					s.setMobilephone(sc.next());
					break;
				case 6:
					System.out.println("6：                        所在籍贯");
					s.setNativeplace(sc.next());
					break;
				case 7:
					System.out.println("7：                        所在系部");
					s.setDepartment(sc.next());

					break;
				case 8:
					System.out.println("8:          学籍异动");
					s.setChange(sc.next());
					break;
				case 9:
					System.out.println("9:          是否毕业");
					s.setGradue(sc.next());
					break;
				default:
					break;
				}

				if (studentimpl.teaModifyStudent(s)) {
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

	/*
	 * 显示所有学生信息
	 */
	public void listAllStu() throws Exception {
		List<Student> sList = listAllStudent();
		System.out.println("姓名\t性别\t年龄\t学号\t籍贯\t\t系部\t电话号码\t学籍异动\t是否毕业");
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));

		}
	}

	public  void changePassword() throws Exception{
		
			
			System.out.println("请输入你的原来密码");
			String stu_password = sc.next();
			Student stu = studentimpl.getPassword(stu_password);
			if (stu != null) {
						System.out.println("原密码：" + stu_password);
						System.out.println("请输入新密码");
						String newpassword = sc.next();
						if(stu_password.equals(newpassword)){
							System.out.println("不能和原来的密码相同");
							return;
						}
						System.out.println("请再一次输入密码，进行确认");
						
						String arginpassword = sc.next();
						if (newpassword.equals(arginpassword)) {
							stu.setPassword(arginpassword);
							if (studentimpl.teaModifyStudent(stu)) {
								System.out.println("密码修改成功！");
							} else {
								System.out.println("修改失败！！");
							}
						} else {
							System.out.println("两次输入的不同！！");
						}
					}
			}
	
	
	public void findStudentScore(String num) {
		try {		
				Student student = studentimpl.getNum(num);
				if (student == null) {
					System.out.println("没有学号为：" + num + "的学生！！");
					return;
				}
				List<Exam> sList = scoreimpl.findByStudent(student);

				for (int i = 0; i < sList.size(); i++) {
					Exam exam = sList.get(i);
					System.out.println(
							"学号：\t" + exam.getStu_id() + "\t姓名:\t" + exam.getStu_name() +"\t课程名\t"+exam.getCouse_name()+ "\t分数：\t" + exam.getScore());
				}
		

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}
	}
}
