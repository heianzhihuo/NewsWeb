package Dao;

import java.sql.ResultSet;
import model.userinfo;

public class UserDao {

	private Dao mysqlDao;

	public UserDao() {
		mysqlDao = new Dao();
	}

	public String getPassword(String username) {
		String sqlString = "select password from userinfo where username = '" + username + "';";
		ResultSet rSet = mysqlDao.doQuery(sqlString);
		try {
			if (rSet.next()) {
				String password = rSet.getString("password");
				return password;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int addUser(userinfo user) {
		String sqlString = "select * from userinfo where username = '" + user.getUsername() + "';";
		ResultSet rSet = mysqlDao.doQuery(sqlString);
		try {
			if (rSet.next()) {
				return 0;
			} else {
				sqlString = "insert into userinfo (username,password,email) values ('" + user.getUsername() + "','"
						+ user.getPassword() + "','" + user.getEmail() + "');";
				mysqlDao.doUpdate(sqlString);
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public userinfo getUser(String username) {
		String sqlString = "select * from userinfo where username = '" + username + "';";
		ResultSet rSet = mysqlDao.doQuery(sqlString);
		try {
			if (rSet.next()) {
				userinfo user = new userinfo();
				user.setUserId(rSet.getInt("userId"));
				user.setUsername(username);
				user.setPassword(rSet.getString("password"));
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getFavorites(String username) {
		String sqlString = "select favorites from userinfo where username = '" + username + "';";
		ResultSet rSet = mysqlDao.doQuery(sqlString);
		try {
			String favorites = null;
			if (rSet.next()) {
				favorites = rSet.getString("favorites");
			} 
			return favorites;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int setFavorites(String username, String favorites) {
		String sqlString = "update userinfo set favorites = '" + favorites + "' where username = '" + username + "';";
		return mysqlDao.doUpdate(sqlString);
	}
}
