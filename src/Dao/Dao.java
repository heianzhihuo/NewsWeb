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
	
	public Dao() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");// 加载MYSQL JDBC驱动程序
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsdb", "root", "123456");
		// 连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码
		stmt = conn.createStatement();
	}

	public ResultSet doQuery(String sql) throws Exception {
		//执行SQL查询命令，返回查询结果集对象
		return stmt.executeQuery(sql);
	}
	
	public int doUpdate(String sql) throws Exception {
		//执行SQL添加、删除和修改等更新命令
		return stmt.executeUpdate(sql);
	}
	
	public void doExecute(String sql) throws Exception {
		stmt.execute(sql);
	}

	public void close() throws SQLException {
		if(!stmt.isClosed()){
			stmt.close();
			stmt = null;
		}
		if(!conn.isClosed()) {
			conn.close();
			conn = null;
		}
	}
}
