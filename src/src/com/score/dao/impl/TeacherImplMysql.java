/**
 * 
 */
package src.com.score.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.com.score.dao.Iteacher;
import src.com.score.db.MysaqlDataBase;
import src.com.score.dto.Teacher;

/**
 * @author Administrator
 *
 */
public class TeacherImplMysql extends MysaqlDataBase implements Iteacher {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.score.dao.Iteacher#teaAddTeacher(com.corse.dto.Teacher) 增加教师信息
	 */
	public boolean teaAddTeacher(Teacher t) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("insert into tealogin(name,sex,tea_id,age,money,password) values (?,?,?,?,?,?)");
			ps.setString(1, t.getName());
			ps.setString(2, t.getSex());
			ps.setString(3, t.getTeacode());
			ps.setInt(4, t.getAge());
			ps.setDouble(5, t.getMoney());
			ps.setString(6, t.getPassword());
			if (ps.executeUpdate() > 0)
				return true;

		} catch (Exception e) {
			// TODO: handle exception
		}
		free(ps, con);
		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.score.dao.Iteacher#teaDelectTeacher(java.lang.String)
	 */
	public boolean teaDelectTeacher(String teacode) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			ps = con.prepareStatement("delete from tealogin where tea_id=?");
			ps.setString(1, teacode);
			if (ps.executeUpdate() > 0)
				return true;

		} catch (Exception e) {
			free(ps, con);
			// TODO: handle exception
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.score.dao.Iteacher#teaModifyTeacher(com.corse.dto.Teacher)
	 */
	public boolean teaModifyTeacher(Teacher t) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {	
			ps = con.prepareStatement("update tealogin set money=?, age=?,password=? where tea_id=?");
			ps.setDouble(1, t.getMoney());
			ps.setInt(2, t.getAge());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getTeacode());
			if (ps.executeUpdate() > 0)
				return true;
			else
				return false;
		} catch (Exception sqle) {
			throw sqle;
		} finally {
			ps.close();
			con.close();
		}
		}	
		
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.score.dao.Iteacher#getTeacode(java.lang.String)
	 */
	public Teacher getTeacode(String teacode) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher t = null;
		try {
			ps = con.prepareStatement("select * from tealogin where tea_id=?");
			ps.setString(1, teacode);
			rs = ps.executeQuery();
			if (rs.next()) {
				t = new Teacher();
				t.setName(rs.getString("name"));
				t.setSex(rs.getString("sex"));
				t.setTeacode(rs.getString("tea_id"));
				t.setAge(rs.getInt("age"));
				t.setMoney(rs.getDouble("money"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		free(rs, ps, con);

		return t;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.score.dao.Iteacher#sortTeacher(int)
	 */

	public Teacher Login(String tea_id, String password) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Teacher tea = null;
		try {
			con = getConn();
			ps = con.prepareStatement("select * from tealogin where tea_id=? and password=?");
			ps.setString(1, tea_id);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				tea=new Teacher();
				tea.setName(rs.getString("name"));
				tea.setSex(rs.getString("sex"));
				tea.setTeacode(rs.getString("tea_id"));
				tea.setAge(rs.getInt("age"));
				tea.setMoney(rs.getDouble("money"));
			}
		} catch (Exception e) {
			// TODO: handle exception

		}

		free(rs, ps, con);
		return tea;
	}

	// 关闭连接,释放资源
	public static void free(PreparedStatement ps, Connection con) {

		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
		}
	}

	public static void free(ResultSet rs, PreparedStatement ps, Connection con) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (con != null)
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
	}

	public List<Teacher> sortTeacherByteacode() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Teacher> sList = null;
		try {
			con = getConn();
			ps = con.prepareStatement("SELECT * FROM tealogin ORDER BY tea_id DESC ");
			rs = ps.executeQuery();
			sList = new ArrayList<Teacher>();
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

		free(rs, ps, con);

		return sList;
	}

	public List<Teacher> sortTeacherBymoney() throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Teacher> sList = null;
		try {
			con = getConn();
			ps = con.prepareStatement("SELECT * FROM tealogin ORDER BY money desc ");
			rs = ps.executeQuery();
			sList = new ArrayList<Teacher>();
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

		free(rs, ps, con);

		return sList;
	}

}
