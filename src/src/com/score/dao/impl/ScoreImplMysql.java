package src.com.score.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import src.com.score.dao.IScore;
import src.com.score.db.MysaqlDataBase;
import src.com.score.dto.Course;
import src.com.score.dto.Exam;
import src.com.score.dto.Score;
import src.com.score.dto.Student;

public class ScoreImplMysql extends MysaqlDataBase implements IScore {

	@Override
	public boolean addScore(Score s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into score(code,stunum,score) values(?,?,?) ");
			ps.setInt(1, s.getCourse().getCode());
			ps.setString(2, s.getStudent().getNum());
			ps.setDouble(3, s.getScore());
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
	public boolean delectScore(Score s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("DELETE FROM score WHERE CODE=? AND stunum=?");
			ps.setInt(1, s.getCourse().getCode());
			ps.setString(2, s.getStudent().getNum());
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
	public boolean delectByStudent(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("delete from score where stunum=? ");
			ps.setString(1, s.getNum());
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
	public boolean delectByCourse(Course c) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("delete from score where code=? ");
			ps.setInt(1, c.getCode());
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
	public List<Exam> findByStudent(Student s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Exam exam = null;
		List<Exam> sList = null;
		try {
			ps = con.prepareStatement("select stu_name,stu_id,couse_name,score from score1 WHERE  stu_id=?");
			ps.setString(1, s.getNum());
			rs = ps.executeQuery();
			sList = new ArrayList<Exam>();
			while (rs.next()) {
				exam = new Exam();
				exam.setStu_name(rs.getString("stu_name"));
				exam.setCouse_name(rs.getString("couse_name"));
				exam.setScore(rs.getDouble("score"));
				exam.setStu_id(rs.getString("stu_id"));
				sList.add(exam);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(ps, con);
		return sList;
	}

	public List<Exam> lisp(int code) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Exam> sList = null;
		Exam exam = null;
		try {
			ps = con.prepareStatement("select * from score1 WHERE   couse_id=?");
			ps.setInt(1, code);
			rs = ps.executeQuery();
			System.out.println("课程编号\t课程名称\t学生姓名\t学生学号\t成绩");
			sList = new ArrayList<Exam>();
			while (rs.next()) {
				exam = new Exam();
				exam.setCouse_id(rs.getString("couse_id"));
				exam.setCouse_name(rs.getString("couse_name"));
				exam.setStu_id(rs.getString("stu_id"));
				exam.setStu_name(rs.getString("stu_name"));
				exam.setScore(rs.getDouble("score"));
				System.out.println(exam);
				sList.add(exam);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(ps, con);
		return sList;
	}

	@Override
	public List<Exam> findByCourse(Course c) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Exam> sList = null;
		Exam exam = null;
		try {
			// ps=con.prepareStatement("select * from score where code=?");
			ps = con.prepareStatement("select couse_name,couse_id,score from score1 WHERE  couse_id=?");
			ps.setInt(1, c.getCode());
			rs = ps.executeQuery();
			sList = new ArrayList<Exam>();
			while (rs.next()) {

				exam = new Exam();
				exam.setCouse_id(rs.getString("couse_id"));
				exam.setCouse_name(rs.getString("couse_name"));
				exam.setScore(rs.getDouble("score"));
				sList.add(exam);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(rs, ps, con);
		return sList;
	}

	public Exam findByCourseLookExam(Course c) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Exam> sList = null;
		Exam exam = null;
		try {
			// ps=con.prepareStatement("select * from score where code=?");
			ps = con.prepareStatement(
					"SELECT couse_id,couse_name,score from score1  WHERE  couse_id=?");
			ps.setInt(1, c.getCode());
			rs = ps.executeQuery();
			sList = new ArrayList<Exam>();
			while (rs.next()) {
				exam = new Exam();
				exam.setCouse_id(rs.getString("couse_id"));
				exam.setCouse_name(rs.getString("couse_name"));
				exam.setScore(rs.getDouble("score"));
				sList.add(exam);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(rs, ps, con);
		return exam;
	}

	@Override
	public boolean modifyScore(Score s) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("update score set score=? where stunum=? and code=?");
			ps.setDouble(1, s.getScore());
			ps.setString(2, s.getStudent().getNum());
			ps.setInt(3, s.getCourse().getCode());
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
	public Score get(Student stu, Course c) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Score s = null;

		try {
			ps = con.prepareStatement("SELECT * from score where stunum=? and code=? ");
			ps.setString(1, stu.getNum());
			ps.setInt(2, c.getCode());
			rs = ps.executeQuery();
			while (rs.next()) {
				s = new Score();
				s.setCourse(c);
				s.setStudent(stu);
				s.setScore(rs.getDouble("score"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		TeacherImplMysql.free(ps, con);
		return s;
	}

}
