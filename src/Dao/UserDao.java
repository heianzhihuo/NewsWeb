package Dao;

import java.sql.ResultSet;
import model.userinfo;

public class UserDao {

	private Dao mysqlDao;

	public UserDao() throws Exception {
		mysqlDao = new Dao();
	}

	public String getPassword(String username) throws Exception {
		String sqlString = "select password from userinfo where username = '" + username + "';";
		ResultSet rSet = mysqlDao.doQuery(sqlString);
		if (rSet.next()) {
			String password = rSet.getString("password");
			return password;
		} else {
			return null;
		}
	}

	public int addUser(String username, String password) throws Exception {
		String sqlString = "select * from userinfo where username = '" + username + "';";
		ResultSet rSet = mysqlDao.doQuery(sqlString);
		if (rSet.next()) {
			return 0;
		} else {
			sqlString = "insert into userinfo (username,password) values ('" + username + "','" + password + "');";
			mysqlDao.doUpdate(sqlString);
			return 1;
		}
	}

	public int addFavorites(String username, String favorites) throws Exception {
		String sqlString = "update userinfo set favorites = '" + favorites + "' where username = '" + username + "';";
		return mysqlDao.doUpdate(sqlString);
	}

	public userinfo getUser(String username) throws Exception {
		String sqlString = "select * from userinfo where username = '" + username + "';";
		ResultSet rSet = mysqlDao.doQuery(sqlString);
		if (rSet.next()) {
			userinfo user = new userinfo();
			user.setUserId(rSet.getInt("userId"));
			user.setUsername(username);
			user.setPassword(rSet.getString("password"));
			return user;
		} else {
			return null;
		}
	}
}
