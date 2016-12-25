package src.com.score.db;


import java.sql.Connection;
import java.sql.DriverManager;



public abstract class MysaqlDataBase {


	protected Connection getConn() throws Exception {
		String url = "jdbc:mysql://localhost:3306/score"; // ���ݿ������ִ���url��ͳһ��Դ��λ��
		String useName = "root"; // ���ݿ��û�����
		String driver = "com.mysql.jdbc.Driver"; // ���ݿ���������
		String password = "root"; // ���ݿ��û���½����
		try {
			Connection con;
			Class.forName(driver);// ��װ����
			con = DriverManager.getConnection(url, useName, password);// DriverManger������ز�ͬ�����������Ҹ��ݲ�ͬ������������߷Ż���Ӧ�����ݿ�����
			return con;
		} catch (Exception e) {
			throw e;
		}
	}
}
