package src.com.score.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import src.com.score.dao.ICourse;
import src.com.score.db.MysaqlDataBase;
import src.com.score.dto.Course;

public class CourseImplMysql extends MysaqlDataBase implements ICourse {

	@Override
	public boolean teaAddCourse(Course c) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into couse(couse_id,couse_name) values (?,?)");
			ps.setInt(1, c.getCode());
			ps.setString(2, c.getCoursename());

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
	public boolean teaDelectCourse(int code) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("delete from couse where couse_id=?");
			ps.setInt(1, code);
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
	public boolean teaModifyCourse(Course c) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("update  couse set couse_name=? where couse_id=?");
			ps.setString(1, c.getCoursename());
			ps.setInt(2, c.getCode());
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
	public Course findByCode(int code) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course c = null;
		try {
			ps = con.prepareStatement("select * from  couse  where couse_id=?");
			ps.setInt(1, code);
			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Course();
				c.setCode(rs.getInt("couse_id"));
				c.setCoursename(rs.getString("couse_name"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(ps, con);
		return c;
	}

	@Override

	public List<Course> dispListCourse(Course s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course c = null;
		List<Course> cList = null;
		try {
			ps = con.prepareStatement("select * from  couse where couse_id=?");
			ps.setInt(1, s.getCode());
			rs = ps.executeQuery();
			cList = new ArrayList<Course>();
			System.out.println("¿Î³Ì±àºÅ\t¿Î³ÌÃû");
			while (rs.next()) {
				c = new Course();
				c.setCode(rs.getInt("couse_id"));
				c.setCoursename(rs.getString("couse_name"));
				cList.add(c);
				System.out.println(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(ps, con);
		return cList;

	}
}
