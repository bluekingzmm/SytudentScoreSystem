  package src.com.score.run;

import java.util.Scanner;

import src.com.score.dao.Istudent;
import src.com.score.dao.impl.StudentImplMysql;
import src.com.score.dto.Student;
import src.com.score.service.ScoreAiist;
import src.com.score.service.StudentAiist;

public class StudentMain {

	static Scanner sc = new Scanner(System.in);
	static StudentAiist sa = new StudentAiist();
	static ScoreAiist Sa = new ScoreAiist();
	static Istudent si = new StudentImplMysql();

	/**
	 * @param args
	 *            显示学生功能的菜单
	 */
	public static void dispStudentMenu() {

		System.out.println("1:*******************************显示个人信息");
		System.out.println("2:*******************************查看成绩单信息");
		System.out.println("3:********************************改密码****");
		System.out.println("4:********************************返回系统****");
		System.out.println("**************请输入你的选择*******************");

	}

	/*
	 * 学生功能主菜单 需要输入学号和密码，方可进入系统
	 */
	public static void StuMenu() {
		try {
			boolean flag = true;
			System.out.println("请输入你的学生学号");
			String stu_id = sc.next();
			System.out.println("请输入你的密码");
			String stu_password = sc.next();
			Student stu = si.Login(stu_id, stu_password);
			if (stu != null) {
				System.out.println("欢迎你:  " + stu.getName());
				while (flag) {
					dispStudentMenu();
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("1:*******************************显示个人信息");
						System.out.println("姓名\t性别\t年龄\t学号\t籍贯\t\t系部\t电话号码\t学籍异动\t是否毕业");
						System.out.println(stu);
						break;
					case 2:
						System.out.println("2:*******************************查看本人成绩信息");
						sa.findStudentScore(stu_id);
						break;
					case 3:
						System.out.println("********************************改密码****");
						sa.changePassword();
						break;
					case 4:
						System.out.println("********************************返回系统****");
						flag = false;
						break;
					default:
						break;

					}
				}

			} else {
				System.out.println("学生不存在！！");
			}
		} catch (Exception e) {

		}

	}

}
