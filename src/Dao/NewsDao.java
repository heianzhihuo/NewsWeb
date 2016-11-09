package Dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		String sqlString = "insert into news (Title,Type,Link,Picture,Weight,"
				+ "PublishDate,PublishTime,Source) values (" + "'" + news.getTitle() + "'" + "'" + news.getType() + "'"
				+ "'" + news.getLink() + "'" + "'" + news.getPicture() + "'";
		try {
			stmt.execute(sqlString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addNewsList(List<News> newsList) {
		try {
			for (int i = 0; i < newsList.size(); i++) {
				addNews(newsList.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<News> getNews(String type) {
		List<News> newsList = new ArrayList<News>();
		String sqlString = "select * from news where Type = " + type + ";";
		try {
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				News tempNews = new News(rs.getInt("NewsID"), rs.getString("Title"), type, rs.getString("Link"),
						rs.getString("Picture"), rs.getInt("Weight"), rs.getDate("PublisDate"),
						rs.getTime("PublihsTime"), rs.getString("Source"));
				newsList.add(tempNews);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsList;
	}

	public List<News> getNews(int start, int number, String type) {
		List<News> newsList = new ArrayList<News>();
		String sqlString = "select * from news where Type = " + type + " limit" + start + "," + number + ";";
		try {
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				News tempNews = new News(rs.getInt("NewsID"), rs.getString("Title"), type, rs.getString("Link"),
						rs.getString("Picture"), rs.getInt("Weight"), rs.getDate("PublisDate"),
						rs.getTime("PublihsTime"), rs.getString("Source"));
				newsList.add(tempNews);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsList;
	}

	public List<News> getNews(int start, int number) {
		List<News> newsList = new ArrayList<News>();
		String sqlString = "select * from news limit" + start + "," + number + ";";
		try {
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				News tempNews = new News(rs.getInt("NewsID"), rs.getString("Title"), rs.getString("Type"),
						rs.getString("Link"), rs.getString("Picture"), rs.getInt("Weight"), rs.getDate("PublisDate"),
						rs.getTime("PublihsTime"), rs.getString("Source"));
				newsList.add(tempNews);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsList;
	}

	public List<News> getNews() {
		List<News> newsList = new ArrayList<News>();
		String sqlString = "select * from news;";
		try {
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				News tempNews = new News(rs.getInt("NewsID"), rs.getString("Title"), rs.getString("Type"),
						rs.getString("Link"), rs.getString("Picture"), rs.getInt("Weight"), rs.getDate("PublisDate"),
						rs.getTime("PublihsTime"), rs.getString("Source"));
				newsList.add(tempNews);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsList;
	}

	public List<News> searchNews(String keyWords) {
		List<News> newsList = new ArrayList<News>();
		String sqlString = "select * from news where Title like " + "'%" + keyWords + "%';";
		try {
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				News tempNews = new News(rs.getInt("NewsID"), rs.getString("Title"), rs.getString("Type"),
						rs.getString("Link"), rs.getString("Picture"), rs.getInt("Weight"), rs.getDate("PublisDate"),
						rs.getTime("PublihsTime"), rs.getString("Source"));
				newsList.add(tempNews);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsList;
	}
}
