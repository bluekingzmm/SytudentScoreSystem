package src.com.score.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import src.com.score.dao.Istudent;
import src.com.score.db.MysaqlDataBase;
import src.com.score.dto.Student;

public class StudentImplMysql extends MysaqlDataBase implements Istudent {

	@Override
	/*
	 * (non-Javadoc)
	 * @see src.com.score.dao.Istudent#teaAddStudent(src.com.corse.dto.Student)
	 * 
	 */
	public boolean teaAddStudent(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(
					"insert into stulogin(stu_name,sex,stu_password,age,stu_id,nativeplace,department,mobilephone,change_stu,gradue) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, s.getName());
			ps.setString(2, s.getSex());
			ps.setString(3, s.getPassword());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getNum());
			ps.setString(6, s.getNativeplace());
			ps.setString(7, s.getDepartment());
			ps.setString(8, s.getMobilephone());
			ps.setString(9, s.getChange());
			ps.setString(10, s.getGradue());
			if (ps.executeUpdate() > 0) {

				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(ps, con);
		return false;
	}

	@Override
	public boolean teaDelectStudent(String num) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("delete from stulogin where stu_id=?");
			ps.setString(1, num);
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(ps, con);

		return false;
	}

	@Override
	public boolean teaModifyStudent(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(
					"update stulogin set stu_name=?,sex=?,age=?, nativeplace=?,department=?,mobilephone=?,change_stu=?,gradue=?,stu_password=? where stu_id=?");
			ps.setString(1, s.getName());
			ps.setString(2, s.getSex());
			ps.setInt(3, s.getAge());
			ps.setString(4, s.getNativeplace());
			ps.setString(5, s.getDepartment());
			ps.setString(6, s.getMobilephone());
			ps.setString(7, s.getChange());
			ps.setString(8, s.getGradue());
			ps.setString(9, s.getPassword());
			ps.setString(10, s.getNum());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(ps, con);
		return false;
	}
	
	@Override
	public Student getNum(String num) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student s = null;
		try {
			ps = con.prepareStatement("select * from stulogin where stu_id=?");
			ps.setString(1, num);
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
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(ps, con);
		return s;
	}
	public Student getPassword(String stu_password) throws Exception {
		// TODO Auto-generated method stub
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student s = null;
		try {
			con=getConn();                           
			ps = con.prepareStatement("select * from stulogin where stu_password=?");
			ps.setString(1, stu_password);
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
				s.setPassword(rs.getString("stu_password"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(rs, ps, con);
		return s;
	}
	public List<Student> dispListStudent(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> sList =null; 
		try {
			ps = con.prepareStatement("select * from stulogin where stu_id=? ");
			ps.setString(1, s.getNum());
			rs = ps.executeQuery();
			sList=new ArrayList<Student>();
			System.out.println("姓名\t性别\t年龄\t学号\t籍贯\t\t系部\t电话号码\t学籍异动\t是否毕业");
			while (rs.next()) {
				s.setName(rs.getString("stu_name"));
				s.setSex(rs.getString("sex"));
				s.setAge(rs.getInt("age"));
				s.setNum(rs.getString("stu_id"));
				s.setNativeplace(rs.getString("nativeplace"));
				s.setDepartment(rs.getString("department"));
				s.setChange(rs.getString("change_stu"));
				s.setGradue(rs.getString("gradue"));
				sList.add(s);
				System.out.println(s);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(ps, con);
		return sList;
	}

	public  Student Login(String stu_id, String stu_password) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student s = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from stulogin where stu_id=? and stu_password=?");
			ps.setString(1, stu_id);
			ps.setString(2, stu_password);
			rs = ps.executeQuery();
			if (rs.next()) {
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

			}
		} catch (Exception e) {
			// TODO: handle exception

		}

		TeacherImplMysql.free(rs, ps, con);
		return s;
	}

}
