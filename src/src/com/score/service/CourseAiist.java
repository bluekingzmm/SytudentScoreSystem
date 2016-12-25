/**
 * 
 */
package src.com.score.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.com.score.dao.ICourse;
import src.com.score.dao.impl.CourseImplMysql;
import src.com.score.dao.impl.TeacherImplMysql;
import src.com.score.db.MysaqlDataBase;
import src.com.score.dto.Course;

/**
 * @author Administrator
 *
 */
public class CourseAiist extends MysaqlDataBase {

	Scanner sc = new Scanner(System.in);
	ICourse course = new CourseImplMysql();

	/*
	 * ��ʦ���ӿγ���Ϣ public boolean teaAddCourse(Course c) throws Exception;
	 * ������¼�����
	 */
	public void tesAddCourse() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				Course c = new Course();
				System.out.println("������γ̱��");
				c.setCode(sc.nextInt());
				System.out.println("������γ�����");
				c.setCoursename(sc.next());
				if (course.teaAddCourse(c)) {
					System.out.println("¼��ɹ�����");
					course.dispListCourse(c);
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
	 * public boolean teaDelectCourse(int code) throws Exception; ��ʦ���ݿγ̱��ɾ���γ�
	 * ������ɾ�����
	 */

	public void teaDelectCourse() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱��");
				int code = sc.nextInt();
				Course c = course.findByCode(code);
				course.dispListCourse(c);
				if (course.teaDelectCourse(code)) {
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
 * List���ϴ�Ų��ҵĿγ�
 */
	public List<Course> dispListCourse() throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course c = null;
		List<Course> cList = null;
		try {
			ps = con.prepareStatement("select * from  couse ");

			rs = ps.executeQuery();
			cList = new ArrayList<Course>();
			
			while (rs.next()) {
				c = new Course();
				c.setCode(rs.getInt("couse_id"));
				c.setCoursename(rs.getString("couse_name"));
				cList.add(c);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(ps, con);

		return cList;
	}
	/*
	 * ��ʾ���еĿγ���Ϣ������dispListCourse ��for�������������ѯ������
	 */
	public List<Course> dispAllCourse() throws Exception{
		System.out.println("�γ̱��\t�γ���");
		List<Course> sList=dispListCourse();
		for (int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}
		return sList;
	}
	/*
	 * ��ʦ�޸Ŀγ̣��γ̱�ţ�
	 * ��ʾ�޸ĵ����
	 */

	public void tesModifyCourse() throws Exception {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱��");
				int code = sc.nextInt();
				Course c = course.findByCode(code);
			course.dispListCourse(c);
				if (c != null) {
					System.out.println("���޸Ŀγ�����");
					c.setCoursename(sc.next());
				} else {
					System.out.println("û�пγ̱��Ϊ" + code + "�Ŀγ�");
				}
				if (course.teaModifyCourse(c)) {
					System.out.println("�޸ĳɹ���");
					course.dispListCourse(c);
				} else {
					System.out.println("�޸�ʧ�ܣ�");
				}
				System.out.println("����n����N�˳��޸ģ������������");
				yes = sc.next();

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}

	}

	/*
	 * ���ݿγ̱�Ž��в�ѯ
	 */

	public void findByCode() {
		try {
			String yes = "y";
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("������γ̱��");
				int code = sc.nextInt();
				Course c = course.findByCode(code);
				if (c != null) {
					course.dispListCourse(c);
				} else {
					System.out.println("û�б��Ϊ" + code + "�Ŀγ̣���");
				}
				System.out.println("����n����N���˳����ң����������!");
				yes = sc.next();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵��;");
			e.printStackTrace();
		}

	}

}
