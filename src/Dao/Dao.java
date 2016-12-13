package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author HWW 用于数据库的链接和相关的操作
 */
public class Dao {

	private Connection conn;
	private Statement stmt;

	public Dao() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); ;
			String urlString  = "jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_newsweb";
			String usernameString = "n2zlx4olyy";
			String passwordString = "ixlk42h45wyiim10z0wi5334m5h33303j422kj5i";
//			String user=SaeUserInfo.getAccessKey();    //获取AccessKey,不需要自己填写
//            String password=SaeUserInfo.getSecretKey(); //获取SecretKey
			// 加载MYSQL JDBC驱动程序
			//w.rdc.sae.sina.com.cn:3307
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsdb", "root", "123456");
			conn = DriverManager.getConnection(urlString,usernameString,passwordString);
			// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet doQuery(String sql) {
		// 执行SQL查询命令，返回查询结果集对象
		try {
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(sql);
			return null;
		}
	}

	public int doUpdate(String sql) {
		// 执行SQL添加、删除和修改等更新命令
		try {
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(sql);
			e.printStackTrace();
			return 0;
		}
	}

	public void doExecute(String sql) {
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(sql);
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (!stmt.isClosed()) {
				stmt.close();
				stmt = null;
			}
			if (!conn.isClosed()) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
