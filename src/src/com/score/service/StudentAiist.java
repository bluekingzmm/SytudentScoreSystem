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
	 * ����ѧ��ѧ�Ų���ѧ��
	 */
	public void findListStuden() throws Exception {
		// TODO Auto-generated method stub

		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������ѧ��ѧ��");
				String num = sc.next();
				Student s = studentimpl.getNum(num);
				if (s != null) {
					studentimpl.dispListStudent(s);
				} else {
					System.out.println("û��ѧ��Ϊ" + num + "��ѧ��");
				}

				System.out.println("����n����N��ֹͣ���ң����������");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}
	}

	// public void sortByKeyStudent() {
	// try {
	// String yes = "y";
	// while (!yes.equalsIgnoreCase("n")) {
	// System.out.println("1: ����ѧ����������");
	// System.out.println("2: ����ѧ��ѧ������");
	// System.out.println("�� �� �� �� �� ѡ �� ");
	// List<Student> sList = student.sortStudent(sc.nextInt());
	// for (int i = 0; i < sList.size(); i++) {
	// System.out.println(sList.get(i));
	// }
	//
	// System.out.println("�����������������n����N���˳�����");
	// yes = sc.next();
	// }
	// } catch (Exception e) {
	// // TODO: handle exception
	// }
	// }
	/*
	 * ���ܣ���ʾ����ѧ��������List��Student����
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
	 * ��ʦ����ѧ����Ϣ
	 */

	public void tesAddStudent() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Student s = new Student();
				System.out.println("������ѧ������");
				s.setName(sc.next());
				System.out.println("�������ѧ���Ա�");
				s.setSex(sc.next());
				System.out.println("������ѧ������");
				s.setPassword(sc.next());
				System.out.println("������ѧ������");
				s.setAge(sc.nextInt());
				System.out.println("������ѧ��ѧ��");
				s.setNum(sc.next());
				System.out.println("������ѧ������");
				s.setNativeplace(sc.next());
				System.out.println("������ѧ������ϵ��");
				s.setDepartment(sc.next());
				System.out.println("������ѧ���绰");
				s.setMobilephone(sc.next());
				System.out.println("������ѧ��ѧ���춯");
				s.setChange(sc.next());
				System.out.println("������ѧ���Ƿ��ҵ");
				s.setGradue(sc.next());
				if (studentimpl.teaAddStudent(s)) {
					System.out.println("¼��ɹ�����");
					studentimpl.dispListStudent(s);
				} else {
					System.out.println("¼��ʧ�ܣ�����");
				}
				System.out.println("����n����N���˳�¼�룬���������!");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}

	}

	/*
	 * ��ʦͨ��ѧ�����ɾ��ѧ����Ϣ
	 */

	public void teaDelectStudent() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������ѧ�����");
				String num = sc.next();
				Student s = studentimpl.getNum(num);
				studentimpl.dispListStudent(s);
				if (studentimpl.teaDelectStudent(num)) {
					System.out.println("ɾ���ɹ�");
				} else {
					System.out.println("ɾ��ʧ�ܣ�");
				}
				System.out.println("����n����N���˳�¼�룬���������!");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}

	}
	/*
	 * ��ʦ�޸�ѧ����Ϣ
	 */

	public void tesModifyStudent() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������ѧ�����");
				String num = sc.next();
				Student s = studentimpl.getNum(num);
				studentimpl.dispListStudent(s);
				System.out.println("1:          ѧ������");
				System.out.println("2��                         ѧ���Ա�");
				System.out.println("3��                        ѧ������");
				System.out.println("4��                        ѧ��ѧ��");
				System.out.println("5��                        �绰����");
				System.out.println("6��                        ���ڼ���");
				System.out.println("7��                        ����ϵ��");
				System.out.println("8:          ѧ���춯");
				System.out.println("9:          �Ƿ��ҵ");
				System.out.println("           ���������ѡ��");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1:          ѧ������");
					s.setName(sc.next());
					break;
				case 2:
					System.out.println("2��                         ѧ���Ա�");
					s.setSex(sc.next());
					break;
				case 3:
					System.out.println("3��                        ѧ������");
					s.setAge(sc.nextInt());
					break;
				case 4:
					System.out.println("4��                        ѧ��ѧ��");
					s.setNum(sc.next());
					break;
				case 5:
					System.out.println("5��                        �绰����");
					s.setMobilephone(sc.next());
					break;
				case 6:
					System.out.println("6��                        ���ڼ���");
					s.setNativeplace(sc.next());
					break;
				case 7:
					System.out.println("7��                        ����ϵ��");
					s.setDepartment(sc.next());

					break;
				case 8:
					System.out.println("8:          ѧ���춯");
					s.setChange(sc.next());
					break;
				case 9:
					System.out.println("9:          �Ƿ��ҵ");
					s.setGradue(sc.next());
					break;
				default:
					break;
				}

				if (studentimpl.teaModifyStudent(s)) {
					System.out.println("�޸ĳɹ�������");
				} else {
					System.out.println("�޸�ʧ�ܣ���");
				}
				System.out.println("����n����N���˳��޸ģ����������!");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}

	}

	/*
	 * ��ʾ����ѧ����Ϣ
	 */
	public void listAllStu() throws Exception {
		List<Student> sList = listAllStudent();
		System.out.println("����\t�Ա�\t����\tѧ��\t����\t\tϵ��\t�绰����\tѧ���춯\t�Ƿ��ҵ");
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));

		}
	}

	public  void changePassword() throws Exception{
		
			
			System.out.println("���������ԭ������");
			String stu_password = sc.next();
			Student stu = studentimpl.getPassword(stu_password);
			if (stu != null) {
						System.out.println("ԭ���룺" + stu_password);
						System.out.println("������������");
						String newpassword = sc.next();
						if(stu_password.equals(newpassword)){
							System.out.println("���ܺ�ԭ����������ͬ");
							return;
						}
						System.out.println("����һ���������룬����ȷ��");
						
						String arginpassword = sc.next();
						if (newpassword.equals(arginpassword)) {
							stu.setPassword(arginpassword);
							if (studentimpl.teaModifyStudent(stu)) {
								System.out.println("�����޸ĳɹ���");
							} else {
								System.out.println("�޸�ʧ�ܣ���");
							}
						} else {
							System.out.println("��������Ĳ�ͬ����");
						}
					}
			}
	
	
	public void findStudentScore(String num) {
		try {		
				Student student = studentimpl.getNum(num);
				if (student == null) {
					System.out.println("û��ѧ��Ϊ��" + num + "��ѧ������");
					return;
				}
				List<Exam> sList = scoreimpl.findByStudent(student);

				for (int i = 0; i < sList.size(); i++) {
					Exam exam = sList.get(i);
					System.out.println(
							"ѧ�ţ�\t" + exam.getStu_id() + "\t����:\t" + exam.getStu_name() +"\t�γ���\t"+exam.getCouse_name()+ "\t������\t" + exam.getScore());
				}
		

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}
	}
}
