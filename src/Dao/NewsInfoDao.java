package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.newsInfo;

public class NewsInfoDao {
	private Dao mysqlDao;

	public NewsInfoDao() throws Exception {
		mysqlDao = new Dao();
	}

	public void InitData() throws Exception {
		mysqlDao.doExecute("truncate table news");
	}

	public List<newsInfo> getNews() throws Exception {
		List<newsInfo> newsList = new ArrayList<newsInfo>();
		String sqlString = "select * from newsinfo;";
		ResultSet rs = mysqlDao.doQuery(sqlString);
		while (rs.next()) {
			newsInfo temp = new newsInfo(rs.getInt("newsId"), rs.getString("title"), rs.getInt("topicId"),
					rs.getString("url"), rs.getString("picture"), rs.getInt("weight"), rs.getDate("publishDate"),
					rs.getTime("publishTime"), rs.getString("source"));
			newsList.add(temp);
		}
		return newsList;
	}

	public List<newsInfo> getNews(int topicId) throws Exception {
		
		List<newsInfo> newsList = new ArrayList<newsInfo>();
		String sqlString = "select * from newsinfo where topicId = " + topicId +";";
		ResultSet rs = mysqlDao.doQuery(sqlString);
		while (rs.next()) {
			newsInfo temp = new newsInfo(rs.getInt("newsId"), rs.getString("title"), rs.getInt("topicId"),
					rs.getString("url"), rs.getString("picture"), rs.getInt("weight"), rs.getDate("publishDate"),
					rs.getTime("publishTime"), rs.getString("source"));
			newsList.add(temp);
		}
		return newsList;
	}

	public List<newsInfo> searchNews(String keyWord) throws Exception {
		List<newsInfo> newsList = new ArrayList<newsInfo>();
		String sqlString = "select * from newsinfo where Title like " + "'%" + keyWord + "%';";
		ResultSet rs = mysqlDao.doQuery(sqlString);
		while (rs.next()) {
			newsInfo temp = new newsInfo(rs.getInt("newsId"), rs.getString("title"), rs.getInt("topicId"),
					rs.getString("url"), rs.getString("picture"), rs.getInt("weight"), rs.getDate("publishDate"),
					rs.getTime("publichTime"), rs.getString("source"));
			newsList.add(temp);
		}
		return newsList;
	}

	public void addNews(newsInfo news) throws Exception {
		String sqlString = "insert into newsInfo (newsId,title,topicId,url,picture,weight,publishDate,publishTime"
				+ "source) values +(";
	}

	public void addNews(List<newsInfo> newsList) throws  Exception {
		String sqlString = "";
	}

}
