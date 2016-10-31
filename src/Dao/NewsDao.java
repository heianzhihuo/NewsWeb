package Dao;

import java.sql.Statement;
import java.util.List;
import java.sql.Connection;

import model.News;

public class NewsDao {

	private Connection connection;
	private Statement stmt;

	public NewsDao() {
		try {
			connection = Dao.getConn();
			stmt = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void InitialData() {
		try {
			stmt.execute("truncate table news");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addNews(News news) {
		String sqlString = "insert into news (Title,Link,Type,Picture) values ("
		+ "'";
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
