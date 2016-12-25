package src.com.score.db;


import java.sql.Connection;
import java.sql.DriverManager;



public abstract class MysaqlDataBase {


	protected Connection getConn() throws Exception {
		String url = "jdbc:mysql://localhost:3306/score"; // 数据库连接字串，url：统一资源定位符
		String useName = "root"; // 数据库用户名称
		String driver = "com.mysql.jdbc.Driver"; // 数据库驱动名称
		String password = "root"; // 数据库用户登陆密码
		try {
			Connection con;
			Class.forName(driver);// 安装驱动
			con = DriverManager.getConnection(url, useName, password);// DriverManger负责加载不同的驱动，并且根据不同的请求，向调用者放回相应额数据库连接
			return con;
		} catch (Exception e) {
			throw e;
		}
	}
}
