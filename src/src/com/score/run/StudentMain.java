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
	 *            ��ʾѧ�����ܵĲ˵�
	 */
	public static void dispStudentMenu() {

		System.out.println("1:*******************************��ʾ������Ϣ");
		System.out.println("2:*******************************�鿴�ɼ�����Ϣ");
		System.out.println("3:********************************������****");
		System.out.println("4:********************************����ϵͳ****");
		System.out.println("**************���������ѡ��*******************");

	}

	/*
	 * ѧ���������˵� ��Ҫ����ѧ�ź����룬���ɽ���ϵͳ
	 */
	public static void StuMenu() {
		try {
			boolean flag = true;
			System.out.println("���������ѧ��ѧ��");
			String stu_id = sc.next();
			System.out.println("�������������");
			String stu_password = sc.next();
			Student stu = si.Login(stu_id, stu_password);
			if (stu != null) {
				System.out.println("��ӭ��:  " + stu.getName());
				while (flag) {
					dispStudentMenu();
					int key = sc.nextInt();
					switch (key) {
					case 1:
						System.out.println("1:*******************************��ʾ������Ϣ");
						System.out.println("����\t�Ա�\t����\tѧ��\t����\t\tϵ��\t�绰����\tѧ���춯\t�Ƿ��ҵ");
						System.out.println(stu);
						break;
					case 2:
						System.out.println("2:*******************************�鿴���˳ɼ���Ϣ");
						sa.findStudentScore(stu_id);
						break;
					case 3:
						System.out.println("********************************������****");
						sa.changePassword();
						break;
					case 4:
						System.out.println("********************************����ϵͳ****");
						flag = false;
						break;
					default:
						break;

					}
				}

			} else {
				System.out.println("ѧ�������ڣ���");
			}
		} catch (Exception e) {

		}

	}

}
