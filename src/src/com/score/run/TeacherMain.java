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
				System.out.println("1:*******************************����ѧ����Ϣ");
				System.out.println("2:*******************************ɾ��ѧ����Ϣ");
				System.out.println("3:*******************************�޸�ѧ����Ϣ");
				System.out.println("4:**************************����ѧ�Ų�ѯѧ����Ϣ");
				System.out.println("5:*******************************��ʾѧ��ȫ����Ϣ");
				System.out.println("0:***********************************�������˵�");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:*******************************����ѧ����Ϣ");
					sa.tesAddStudent();
					break;
				case 2:
					System.out.println("2:*******************************ɾ��ѧ����Ϣ");
					sa.teaDelectStudent();
					break;

				case 3:
					System.out.println("3:*******************************�޸�ѧ����Ϣ");
					sa.tesModifyStudent();
					break;
				case 4:
					System.out.println("4:**************************����ѧ�Ų�ѯѧ����Ϣ");
					sa.findListStuden();
					break;
				case 5:
					System.out.println("5:*******************************��ʾѧ��ȫ����Ϣ");
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
				System.out.println("1:*******************************���ӿγ���Ϣ");
				System.out.println("2:*******************************ɾ���γ���Ϣ");
				System.out.println("3:*******************************�޸Ŀγ���Ϣ");
				System.out.println("4:*************************���տγ̱�Ų�ѯ�γ���Ϣ");
				System.out.println("5:*******************************��ѯ�γ�������Ϣ");
				System.out.println("0:**********************************�������˵�");

				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:*******************************���ӿγ���Ϣ");
					ca.tesAddCourse();
					break;
				case 2:
					System.out.println("2:*******************************ɾ���γ���Ϣ");
					ca.teaDelectCourse();
					break;
				case 3:
					System.out.println("3:*******************************�޸Ŀγ���Ϣ");
					ca.tesModifyCourse();
					break;
				case 4:
					System.out.println("4:**************************���տγ̱�Ų�ѯ�γ���Ϣ");
					ca.findByCode();
					break;
				case 5:
					System.out.println("5:*******************************��ѯ�γ�������Ϣ");
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
				System.out.println("1:*******************************���ӽ�ʦ��Ϣ");
				System.out.println("2:*******************************ɾ����ʦ��Ϣ");
				System.out.println("3:*******************************�޸Ľ�ʦ��Ϣ");
				System.out.println("4:*************************���ս�ʦ��Ų�ѯ��ʦ��Ϣ");
				System.out.println("5:*******************************��ѯ��ʦ������Ϣ");
				System.out.println("6:*******************************�����ʦ��Ϣ");
				System.out.println("7:*******************************�޸Ľ�ʦ��¼����");
				System.out.println("0:*******************************�������˵�**");

				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:*******************************���ӽ�ʦ��Ϣ");
					ta.tesAddTeacher();
					break;
				case 2:
					System.out.println("2:*******************************ɾ����ʦ��Ϣ");
					ta.teaDelectTeacher();
					break;
				case 3:
					System.out.println("3:*******************************�޸Ľ�ʦ��Ϣ");
					ta.tesModifyTeacher();
					break;
				case 4:
					System.out.println("4:**************************���ս�ʦ��Ų�ѯ��ʦ��Ϣ");
					ta.findListTeacher();
					break;
				case 5:
					System.out.println("5:*******************************��ѯ��ʦ������Ϣ");
					ta.lispTeacher();
					break;
				case 6:
					System.out.println("6:*******************************�����ʦ��Ϣ");
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
				System.out.println("1:*******************************��ӳɼ���Ϣ");
				System.out.println("2:********************************ɾ���ɼ���Ϣ****");
				System.out.println("3:********************************�޸ĳɼ���Ϣ****");
				System.out.println("4:********************����ѧ��ѧ��ɾ�����гɼ���Ϣ****");
				System.out.println("5:*******************���տγ̱��ɾ�����гɼ���Ϣ�ɼ�****");
				System.out.println("6:*******************���տγ̱�Ų�ѯ���гɼ���Ϣ�ɼ�****");
				System.out.println("7:*******************����ѧ��ѧ�Ų�ѯ���гɼ���Ϣ�ɼ�****");
				System.out.println("8:*******************�鿴���гɼ�*******************");
				System.out.println("9:***************���տγ̱�Ž��з��������ɸߵ��ͣ���ʾ**");
				System.out.println("10:***************���տγ̱�Ų鿴���γ̳ɼ����ֺܷ�ƽ����**");
				System.out.println("0:*******************************�������˵�*********");

				int key = sc.nextInt();
				switch (key) {

				case 1:
					System.out.println("1:*******************************��ӳɼ���Ϣ");
					Sa.addScore();
					break;
				case 2:
					System.out.println("2:********************************ɾ���ɼ���Ϣ****");
					Sa.delectSCore();
					break;
				case 3:
					System.out.println("3:********************************�޸ĳɼ���Ϣ****");
					Sa.modifyScore();
					break;
				case 4:
					System.out.println("4:********************����ѧ��ѧ��ɾ�����гɼ���Ϣ****");
					Sa.delectByStudent();
					break;
				case 5:
					System.out.println("5:*******************���տγ̱��ɾ�����гɼ���Ϣ�ɼ�****");
					Sa.delectByCourse();
					break;
				case 6:
					System.out.println("6:*******************���տγ̱�Ų�ѯ���гɼ���Ϣ�ɼ�****");
					Sa.findCourseScore();
					break;
				case 7:
					System.out.println("7:*******************����ѧ��ѧ�Ų�ѯ���гɼ���Ϣ�ɼ�****");
					Sa.findStudentScore();
					break;
				case 8:
					System.out.println("8:*******************�鿴���гɼ�()***************");
					Sa.listAllScore();
					break;
				case 9:
					System.out.println("9:***************���տγ̱�Ž��з��������ɸߵ��ͣ���ʾ**");
					Sa.disp();
					break;
				case 10:
					System.out.println("10:***************���տγ̱�Ų鿴���γ̳ɼ����ֺܷ�ƽ����**");
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
				System.out.println("1:*************************ѧ������**************************");
				System.out.println("2:*************************��ʦ����**************************");
				System.out.println("3:*************************�γ̹���**************************");
				System.out.println("4:*************************�ɼ�����**************************");
				System.out.println("***************************���������ѡ��*******************");
				System.out.println("0:*************************�������˵�**********************");
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
