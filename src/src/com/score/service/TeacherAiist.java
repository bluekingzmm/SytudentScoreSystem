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
	 * ���ӿγ���Ϣ public boolean teaAddCourse(Course c) throws Exception;
	 */
	public void tesAddTeacher() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Teacher t = new Teacher();
				System.out.println("�������ʦ����");
				t.setName(sc.next());
				System.out.println("�������ʦ�Ա�");
				t.setSex(sc.next());
				System.out.println("�������ʦ���");
				t.setTeacode(sc.next());
				System.out.println("�������ʦ����");
				t.setAge(sc.nextInt());
				System.out.println("�������ʦ����");
				t.setMoney(sc.nextDouble());
				if (teacher.teaAddTeacher(t)) {
					System.out.println("¼��ɹ�����");
					lispTeacher(t);
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

	public void findListTeacher() throws Exception {
		// TODO Auto-generated method stub
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("�������ʦ���");
				String teacode = sc.next();
				Teacher tea = teacher.getTeacode(teacode);
				if (tea != null) {
					listTeacherINfo(teacode);
				} else {
					System.out.println("û�б��Ϊ" + teacode + "�Ľ�ʦ");
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
			System.out.println("����\t�Ա�\t����\t��ʦ���\t����");
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
	 * public boolean teaDelectCourse(int code) throws Exception; ���ݿγ̱�Ų��ҿγ�
	 */

	public void teaDelectTeacher() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("�������ʦ���");
				String teacode = sc.next();
				Teacher t = teacher.getTeacode(teacode);
				listTeacherINfo(teacode);
				if (t != null) {
					if (teacher.teaDelectTeacher(teacode)) {
						System.out.println("ɾ���ɹ�");
					} else {
						System.out.println("ɾ��ʧ�ܣ�");
					}
				} else {
					System.out.println("û�б��Ϊ" + teacode + "�Ľ�ʦ");
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

	public void tesModifyTeacher() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				// System.out.println("�������ʦ���");
				// String teacode = sc.next();
				// Teacher t = teacher.getTeacode(tea.getTeacode());
				listTeacherINfo(tea.getTeacode());
				System.out.println("1��                        ��ʦ����");
				System.out.println("2��                        ��ʦ������");
				System.out.println("3:            ��ʦ�ĵ�¼����");
				System.out.println("           ���������ѡ��");
				int key = sc.nextInt();
				switch (key) {
				case 1:
					System.out.println("1��                        ��ʦ����");
					tea.setMoney(sc.nextDouble());
					break;
				case 2:
					System.out.println("2��                        ��ʦ����");
					tea.setAge(sc.nextInt());
					break;
				case 3:
					System.out.println("3:            ��ʦ�ĵ�¼����");
					tea.setPassword(sc.next());
					break;
				default:
					break;
				}
				if (teacher.teaModifyTeacher(tea)) {
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

	public void sortByKeyTeacher() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("1:   ���ս�ʦ�������");
				System.out.println("2:    ���ս�ʦ��������");
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
				System.out.println("�����������������n����N���˳�����");
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
			System.out.println("����\t�Ա�\t����\t��ʦ���\t����");
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
		System.out.println("��������Ľ�ʦ���");
		String tea_id = sc.next();
		System.out.println("�������������");
		String password = sc.next();
		tea = teacher.Login(tea_id, password);
		if (tea != null) {
			System.out.println("��ӭ��" + tea.getName());

			return true;
		}

		else
			return false;
	}

	public void changePassword() {
		try {
			System.out.println("������ԭ����");
			String oldpassword = sc.next();
			if (oldpassword.equals(tea.getPassword())) {
			}
			System.out.println("������������");
			String newpassword = sc.next();
			System.out.println("����һ���������룬����ȷ��");
			String arginpassword = sc.next();
			if (newpassword.equals(arginpassword)) {
				tea.setPassword(arginpassword);
				if (teacher.teaModifyTeacher(tea)) {
					System.out.println("�����޸ĳɹ���");
				} else {
					System.out.println("�޸�ʧ�ܣ���");
				}
			} else {
				System.out.println("��������Ĳ�ͬ����");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
