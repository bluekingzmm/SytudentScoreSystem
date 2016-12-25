package src.com.score.run;

import java.util.Scanner;

import src.com.score.dao.impl.ScoreImplMysql;
import src.com.score.service.CourseAiist;
import src.com.score.service.ScoreAiist;
import src.com.score.service.StudentAiist;
import src.com.score.service.TeacherAiist;

public class TeacherMain {
	static Scanner sc = new Scanner(System.in);
	static StudentAiist sa = new StudentAiist();
	static CourseAiist ca = new CourseAiist();
	static ScoreAiist Sa = new ScoreAiist();
	static TeacherAiist ta = new TeacherAiist();
	static ScoreImplMysql si = new ScoreImplMysql();

	public static void studentInfo() throws Exception {
		try {
			boolean flag = true;
			while (flag) {
				System.out.println("1:*******************************增加学生信息");
				System.out.println("2:*******************************删除学生信息");
				System.out.println("3:*******************************修改学生信息");
				System.out.println("4:**************************按照学号查询学生信息");
				System.out.println("5:*******************************显示学生全部信息");
				System.out.println("0:***********************************返回主菜单");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:*******************************增加学生信息");
					sa.tesAddStudent();
					break;
				case 2:
					System.out.println("2:*******************************删除学生信息");
					sa.teaDelectStudent();
					break;

				case 3:
					System.out.println("3:*******************************修改学生信息");
					sa.tesModifyStudent();
					break;
				case 4:
					System.out.println("4:**************************按照学号查询学生信息");
					sa.findListStuden();
					break;
				case 5:
					System.out.println("5:*******************************显示学生全部信息");
					sa.listAllStu();
					break;
				case 0:
					flag = false;
					break;
				default:
					break;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void courseInfo() throws Exception {
		try {
			boolean flag = true;
			while (flag) {
				System.out.println("1:*******************************增加课程信息");
				System.out.println("2:*******************************删除课程信息");
				System.out.println("3:*******************************修改课程信息");
				System.out.println("4:*************************按照课程编号查询课程信息");
				System.out.println("5:*******************************查询课程所有信息");
				System.out.println("0:**********************************返回主菜单");

				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:*******************************增加课程信息");
					ca.tesAddCourse();
					break;
				case 2:
					System.out.println("2:*******************************删除课程信息");
					ca.teaDelectCourse();
					break;
				case 3:
					System.out.println("3:*******************************修改课程信息");
					ca.tesModifyCourse();
					break;
				case 4:
					System.out.println("4:**************************按照课程编号查询课程信息");
					ca.findByCode();
					break;
				case 5:
					System.out.println("5:*******************************查询课程所有信息");
					ca.dispAllCourse();
					break;
				case 0:
					flag = false;
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void teacherInfo() throws Exception {
		try {

			boolean flag = true;
			while (flag) {
				System.out.println("1:*******************************增加教师信息");
				System.out.println("2:*******************************删除教师信息");
				System.out.println("3:*******************************修改教师信息");
				System.out.println("4:*************************按照教师编号查询教师信息");
				System.out.println("5:*******************************查询教师所有信息");
				System.out.println("6:*******************************排序教师信息");
				System.out.println("7:*******************************修改教师登录密码");
				System.out.println("0:*******************************返回主菜单**");

				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:*******************************增加教师信息");
					ta.tesAddTeacher();
					break;
				case 2:
					System.out.println("2:*******************************删除教师信息");
					ta.teaDelectTeacher();
					break;
				case 3:
					System.out.println("3:*******************************修改教师信息");
					ta.tesModifyTeacher();
					break;
				case 4:
					System.out.println("4:**************************按照教师编号查询教师信息");
					ta.findListTeacher();
					break;
				case 5:
					System.out.println("5:*******************************查询教师所有信息");
					ta.lispTeacher();
					break;
				case 6:
					System.out.println("6:*******************************排序教师信息");
					ta.sortByKeyTeacher();
					break;
				case 7:
					ta.changePassword();
					break;
				case 0:
					flag = false;
					break;
				default:
					break;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void scoreInfo() throws Exception {
		try {
			boolean flag = true;
			while (flag) {
				System.out.println("1:*******************************添加成绩信息");
				System.out.println("2:********************************删除成绩信息****");
				System.out.println("3:********************************修改成绩信息****");
				System.out.println("4:********************按照学生学号删除所有成绩信息****");
				System.out.println("5:*******************按照课程编号删除所有成绩信息成绩****");
				System.out.println("6:*******************按照课程编号查询所有成绩信息成绩****");
				System.out.println("7:*******************按照学生学号查询所有成绩信息成绩****");
				System.out.println("8:*******************查看所有成绩*******************");
				System.out.println("9:***************按照课程编号进行分数排序（由高到低）显示**");
				System.out.println("10:***************按照课程编号查看本课程成绩的总分和平均分**");
				System.out.println("0:*******************************返回主菜单*********");

				int key = sc.nextInt();
				switch (key) {

				case 1:
					System.out.println("1:*******************************添加成绩信息");
					Sa.addScore();
					break;
				case 2:
					System.out.println("2:********************************删除成绩信息****");
					Sa.delectSCore();
					break;
				case 3:
					System.out.println("3:********************************修改成绩信息****");
					Sa.modifyScore();
					break;
				case 4:
					System.out.println("4:********************按照学生学号删除所有成绩信息****");
					Sa.delectByStudent();
					break;
				case 5:
					System.out.println("5:*******************按照课程编号删除所有成绩信息成绩****");
					Sa.delectByCourse();
					break;
				case 6:
					System.out.println("6:*******************按照课程编号查询所有成绩信息成绩****");
					Sa.findCourseScore();
					break;
				case 7:
					System.out.println("7:*******************按照学生学号查询所有成绩信息成绩****");
					Sa.findStudentScore();
					break;
				case 8:
					System.out.println("8:*******************查看所有成绩()***************");
					Sa.listAllScore();
					break;
				case 9:
					System.out.println("9:***************按照课程编号进行分数排序（由高到低）显示**");
					Sa.disp();
					break;
				case 10:
					System.out.println("10:***************按照课程编号查看本课程成绩的总分和平均分**");
					Sa.findCourseScoreLookExam();
					break;
				case 0:
					flag = false;
					break;
				default:
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void TeaMenu() {
		try {
			boolean flag = true;
			while (flag) {
				System.out.println("1:*************************学生管理**************************");
				System.out.println("2:*************************教师管理**************************");
				System.out.println("3:*************************课程管理**************************");
				System.out.println("4:*************************成绩管理**************************");
				System.out.println("***************************请输入你的选择*******************");
				System.out.println("0:*************************返回主菜单**********************");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					studentInfo();
					break;
				case 2:
					teacherInfo();
					break;
				case 3:
					courseInfo();
					break;
				case 4:
					scoreInfo();
					break;
				case 0:
					flag = false;
					break;
				default:
					break;
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
