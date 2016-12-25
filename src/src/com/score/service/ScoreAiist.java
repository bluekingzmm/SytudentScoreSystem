package src.com.score.service;

import java.util.List;
import java.util.Scanner;

import src.com.score.dao.ICourse;
import src.com.score.dao.IScore;
import src.com.score.dao.Istudent;
import src.com.score.dao.impl.CourseImplMysql;
import src.com.score.dao.impl.ScoreImplMysql;
import src.com.score.dao.impl.StudentImplMysql;
import src.com.score.db.MysaqlDataBase;
import src.com.score.dto.Course;
import src.com.score.dto.Exam;
import src.com.score.dto.Score;
import src.com.score.dto.Student;

public class ScoreAiist extends MysaqlDataBase {

	ICourse courseimpl = new CourseImplMysql();
	Istudent studentimpl = new StudentImplMysql();
	IScore scoreimpl = new ScoreImplMysql();
	Scanner sc = new Scanner(System.in);
	StudentAiist si = new StudentAiist();
	CourseAiist ci = new CourseAiist();

	public void addScore() {
		try {

			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入学生学号");
				String num = sc.next();
				Student stu = new Student(num);
				System.out.println("请输入课程编号");
				int code = sc.nextInt();
				Course c = new Course(code);
				System.out.println("请输入成绩");
				double score = sc.nextDouble();
				Score score1 = new Score(stu, c, score);
				if (scoreimpl.addScore(score1)) {
					System.out.println("添加成功！");
				} else {
					System.out.println("添加失败");
				}
				System.out.println("输入n或者N则退出添加，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("异常说明：");
			System.out.println(e.toString());
		}

	}

	public void delectSCore() {

		try {

			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号");
				int code = sc.nextInt();
				Course c = courseimpl.findByCode(code);
				System.out.println("请输入学生学号");
				String num = sc.next();
				Student s = studentimpl.getNum(num);
				Score score = scoreimpl.get(s, c);
				if (score == null) {
					System.out.println("没有课程编号为" + code + "和" + num + "的信息");
					return;
				}
				if (scoreimpl.delectScore(score)) {
					System.out.println("删除成功！");
				} else {
					System.out.println("删除失败！！");
				}
				System.out.println("输入n或者N则退出删除，任意键继续");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("异常说明：");
			System.out.println(e.toString());
		}
	}

	public void modifyScore() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {

				System.out.println("请你输入添加成绩的课程编号");
				int code = sc.nextInt();
				Course c = courseimpl.findByCode(code);
				if (c == null) {
					System.out.println("你输入的课程编号不存在！！");
					return;
				}
				System.out.println("请输入要修改的学生学号");
				String num = sc.next();
				Student student = studentimpl.getNum(num);
				if (student == null) {
					System.out.println("没有学号为" + num + "的学生");
					return;

				}
				Score score = scoreimpl.get(student, c);
				if (score == null) {
					System.out.println("没有学号为" + num + "的学生和" + code + "的课程编号，请重试！");
					return;
				}
				System.out.println("原来的成绩为" + score.getScore() + "分");
				System.out.println("请输入新的成绩");
				score.setScore(sc.nextDouble());
				if (scoreimpl.modifyScore(score)) {
					System.out.println("修改成功！");
				} else {
					System.out.println("修改失败！");
				}
				System.out.println("输入n或者N则退出删除，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void findStudentScore() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入学生学号：");
				String num = sc.next();
				Student student = studentimpl.getNum(num);
				if (student == null) {
					System.out.println("没有学号为：" + num + "的学生！！");
					return;
				}
				List<Exam> sList = scoreimpl.findByStudent(student);

				for (int i = 0; i < sList.size(); i++) {
					Exam exam = sList.get(i);
					System.out.println("学号：\t" + exam.getStu_id() + "\t姓名:\t" + exam.getStu_name() + "\t课程名\t"
							+ exam.getCouse_name() + "\t分数：\t" + exam.getScore());
				}
				System.out.println("输入n或者N则退出查询，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}
	}

	public void findCourseScore() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号：");
				int code = sc.nextInt();
				Course course = courseimpl.findByCode(code);
				if (course == null) {
					System.out.println("没有为：" + code + "的课程！！");
					return;
				}
				List<Exam> sList = scoreimpl.findByCourse(course);

				for (int i = 0; i < sList.size(); i++) {
					Exam exam = sList.get(i);
					System.out.println("姓名\t" + exam.getStu_name() + "\t" + "课程号：\t" + exam.getCouse_id() + "\t课程名:\t"
							+ exam.getCouse_name() + "\t分数：\t" + exam.getScore());
				}
				System.out.println("输入n或者N则退出查询，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}
	}

	public void findCourseScoreLookExam() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号：");
				int code = sc.nextInt();
				Course course = courseimpl.findByCode(code);
				if (course == null) {
					System.out.println("没有为：" + code + "的课程！！");
					return;
				}
				
				List<Exam> sList = scoreimpl.findByCourse(course);
				Exam exam = scoreimpl.findByCourseLookExam(course);
				double total = 0;
				for (int j = 0; j < sList.size(); j++) {
					if (exam != null) {
						Exam e=sList.get(j);
						total += e.getScore();
					} else {
						System.out.println("空");
					}
				}

				System.out.println("课程号：\t" + exam.getCouse_id() + "\t课程名:\t" + exam.getCouse_name() + "\t总分\t" + total
						+ "\t平均分\t" + total / sList.size());

				System.out.println("输入n或者N则退出查询，任意键继续");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}
	}

	public void delectByStudent() {
		try {
			String yes = "y";

			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入学生学号：");
				String num = sc.next();
				Student s = studentimpl.getNum(num);
				if (s == null) {
					System.out.println("输入的学号不存在！！");
				}
				if (scoreimpl.delectByStudent(s)) {
					System.out.println("删除成功！！");
				} else {
					System.out.println("删除失败！！");
				}

				System.out.println("输入n或者N继续删除，任意键继续！！");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}
	}

	public void delectByCourse() {
		try {
			String yes = "y";

			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入课程编号：");
				int code = sc.nextInt();
				Course course = courseimpl.findByCode(code);
				if (course == null) {
					System.out.println("输入的学号不存在！！");
				}
				if (scoreimpl.delectByCourse(course)) {
					System.out.println("删除成功！！");
				} else {
					System.out.println("删除失败！！");
				}

				System.out.println("输入n或者N继续删除，任意键继续！！");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}
	}

	public void listAllScore() throws Exception {
		// TODO Auto-generated method stub
		List<Student> sList = si.listAllStudent();
		List<Course> cList = ci.dispListCourse();
		System.out.println("姓名\t学号\t课程名\t\t课程编号\t\t分数");
		for (int i = 0; i < sList.size(); i++) {
			Student student = sList.get(i);
			double total = 0;
			for (int j = 0; j < cList.size(); j++) {
				Course course = cList.get(j);
				Score score = scoreimpl.get(student, course);
				if (score != null) {
					total += score.getScore();
					System.out.println(score);
				} else {
					System.out.print("\n");
				}
			}
			System.out.println("总分：" + total + "\t平均分" + total / cList.size());
		}
	}

	// public void totalScore() throws Exception {
	// List<Course> List=ci.dispListCourse();
	// try {
	// for (int i = 0; i < List.size(); i++) {
	// Course course = List.get(i);
	// System.out.println("[课程编号：" + course.getCode() + ".......课程名称："
	// + course.getCoursename() + "]");
	// double total = 0;
	// List<Score> scoreList = scoreimpl.findByCourse(course);
	// for (int j = 0; j < scoreList.size(); j++) {
	// Score score = scoreList.get(j);
	// total += score.getScore();
	// }
	// System.out.println("平均分为："+total / scoreList.size() + "（总人数："
	// + scoreList.size() + ")");
	// }
	//
	//
	// } catch (Exception e) {
	// System.out.print(">>>异常说明：");
	// System.out.println(e.toString());
	// }
	// }
	public void disp() {

		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入你要按照分数排序的课程编号");
				int code = sc.nextInt();
				Course course = courseimpl.findByCode(code);
				if (course != null) {
					scoreimpl.lisp(code);
				} else {
					System.out.println("你输入的课程编号不存在！！");
				}
				System.out.println("还要继续排序吗，不需要请输入n或者N，任意键继续");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
