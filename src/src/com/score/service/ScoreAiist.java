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
				System.out.println("������ѧ��ѧ��");
				String num = sc.next();
				Student stu = new Student(num);
				System.out.println("������γ̱��");
				int code = sc.nextInt();
				Course c = new Course(code);
				System.out.println("������ɼ�");
				double score = sc.nextDouble();
				Score score1 = new Score(stu, c, score);
				if (scoreimpl.addScore(score1)) {
					System.out.println("��ӳɹ���");
				} else {
					System.out.println("���ʧ��");
				}
				System.out.println("����n����N���˳���ӣ����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("�쳣˵����");
			System.out.println(e.toString());
		}

	}

	public void delectSCore() {

		try {

			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱��");
				int code = sc.nextInt();
				Course c = courseimpl.findByCode(code);
				System.out.println("������ѧ��ѧ��");
				String num = sc.next();
				Student s = studentimpl.getNum(num);
				Score score = scoreimpl.get(s, c);
				if (score == null) {
					System.out.println("û�пγ̱��Ϊ" + code + "��" + num + "����Ϣ");
					return;
				}
				if (scoreimpl.delectScore(score)) {
					System.out.println("ɾ���ɹ���");
				} else {
					System.out.println("ɾ��ʧ�ܣ���");
				}
				System.out.println("����n����N���˳�ɾ�������������");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("�쳣˵����");
			System.out.println(e.toString());
		}
	}

	public void modifyScore() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {

				System.out.println("����������ӳɼ��Ŀγ̱��");
				int code = sc.nextInt();
				Course c = courseimpl.findByCode(code);
				if (c == null) {
					System.out.println("������Ŀγ̱�Ų����ڣ���");
					return;
				}
				System.out.println("������Ҫ�޸ĵ�ѧ��ѧ��");
				String num = sc.next();
				Student student = studentimpl.getNum(num);
				if (student == null) {
					System.out.println("û��ѧ��Ϊ" + num + "��ѧ��");
					return;

				}
				Score score = scoreimpl.get(student, c);
				if (score == null) {
					System.out.println("û��ѧ��Ϊ" + num + "��ѧ����" + code + "�Ŀγ̱�ţ������ԣ�");
					return;
				}
				System.out.println("ԭ���ĳɼ�Ϊ" + score.getScore() + "��");
				System.out.println("�������µĳɼ�");
				score.setScore(sc.nextDouble());
				if (scoreimpl.modifyScore(score)) {
					System.out.println("�޸ĳɹ���");
				} else {
					System.out.println("�޸�ʧ�ܣ�");
				}
				System.out.println("����n����N���˳�ɾ�������������");
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
				System.out.println("������ѧ��ѧ�ţ�");
				String num = sc.next();
				Student student = studentimpl.getNum(num);
				if (student == null) {
					System.out.println("û��ѧ��Ϊ��" + num + "��ѧ������");
					return;
				}
				List<Exam> sList = scoreimpl.findByStudent(student);

				for (int i = 0; i < sList.size(); i++) {
					Exam exam = sList.get(i);
					System.out.println("ѧ�ţ�\t" + exam.getStu_id() + "\t����:\t" + exam.getStu_name() + "\t�γ���\t"
							+ exam.getCouse_name() + "\t������\t" + exam.getScore());
				}
				System.out.println("����n����N���˳���ѯ�����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}
	}

	public void findCourseScore() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱�ţ�");
				int code = sc.nextInt();
				Course course = courseimpl.findByCode(code);
				if (course == null) {
					System.out.println("û��Ϊ��" + code + "�Ŀγ̣���");
					return;
				}
				List<Exam> sList = scoreimpl.findByCourse(course);

				for (int i = 0; i < sList.size(); i++) {
					Exam exam = sList.get(i);
					System.out.println("����\t" + exam.getStu_name() + "\t" + "�γ̺ţ�\t" + exam.getCouse_id() + "\t�γ���:\t"
							+ exam.getCouse_name() + "\t������\t" + exam.getScore());
				}
				System.out.println("����n����N���˳���ѯ�����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}
	}

	public void findCourseScoreLookExam() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱�ţ�");
				int code = sc.nextInt();
				Course course = courseimpl.findByCode(code);
				if (course == null) {
					System.out.println("û��Ϊ��" + code + "�Ŀγ̣���");
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
						System.out.println("��");
					}
				}

				System.out.println("�γ̺ţ�\t" + exam.getCouse_id() + "\t�γ���:\t" + exam.getCouse_name() + "\t�ܷ�\t" + total
						+ "\tƽ����\t" + total / sList.size());

				System.out.println("����n����N���˳���ѯ�����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}
	}

	public void delectByStudent() {
		try {
			String yes = "y";

			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������ѧ��ѧ�ţ�");
				String num = sc.next();
				Student s = studentimpl.getNum(num);
				if (s == null) {
					System.out.println("�����ѧ�Ų����ڣ���");
				}
				if (scoreimpl.delectByStudent(s)) {
					System.out.println("ɾ���ɹ�����");
				} else {
					System.out.println("ɾ��ʧ�ܣ���");
				}

				System.out.println("����n����N����ɾ�����������������");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}
	}

	public void delectByCourse() {
		try {
			String yes = "y";

			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱�ţ�");
				int code = sc.nextInt();
				Course course = courseimpl.findByCode(code);
				if (course == null) {
					System.out.println("�����ѧ�Ų����ڣ���");
				}
				if (scoreimpl.delectByCourse(course)) {
					System.out.println("ɾ���ɹ�����");
				} else {
					System.out.println("ɾ��ʧ�ܣ���");
				}

				System.out.println("����n����N����ɾ�����������������");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}
	}

	public void listAllScore() throws Exception {
		// TODO Auto-generated method stub
		List<Student> sList = si.listAllStudent();
		List<Course> cList = ci.dispListCourse();
		System.out.println("����\tѧ��\t�γ���\t\t�γ̱��\t\t����");
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
			System.out.println("�ܷ֣�" + total + "\tƽ����" + total / cList.size());
		}
	}

	// public void totalScore() throws Exception {
	// List<Course> List=ci.dispListCourse();
	// try {
	// for (int i = 0; i < List.size(); i++) {
	// Course course = List.get(i);
	// System.out.println("[�γ̱�ţ�" + course.getCode() + ".......�γ����ƣ�"
	// + course.getCoursename() + "]");
	// double total = 0;
	// List<Score> scoreList = scoreimpl.findByCourse(course);
	// for (int j = 0; j < scoreList.size(); j++) {
	// Score score = scoreList.get(j);
	// total += score.getScore();
	// }
	// System.out.println("ƽ����Ϊ��"+total / scoreList.size() + "����������"
	// + scoreList.size() + ")");
	// }
	//
	//
	// } catch (Exception e) {
	// System.out.print(">>>�쳣˵����");
	// System.out.println(e.toString());
	// }
	// }
	public void disp() {

		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("��������Ҫ���շ�������Ŀγ̱��");
				int code = sc.nextInt();
				Course course = courseimpl.findByCode(code);
				if (course != null) {
					scoreimpl.lisp(code);
				} else {
					System.out.println("������Ŀγ̱�Ų����ڣ���");
				}
				System.out.println("��Ҫ���������𣬲���Ҫ������n����N�����������");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
