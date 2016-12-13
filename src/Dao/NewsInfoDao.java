package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.newsInfo;

public class NewsInfoDao {
	private Dao mysqlDao;

	public NewsInfoDao() {
		mysqlDao = new Dao();
	}

	public void InitData() {
		mysqlDao.doExecute("truncate table newsinfo");
	}

	public ArrayList<newsInfo> getNews() {
		// 获取所有新闻
		ArrayList<newsInfo> newsList = new ArrayList<newsInfo>();
		String sqlString = "select * from newsinfo;";
		ResultSet rs = mysqlDao.doQuery(sqlString);
		try {
			while (rs.next()) {
				newsInfo temp = new newsInfo(rs.getInt("newsId"), rs.getString("title"), rs.getInt("topicId"),
						rs.getString("url"), rs.getString("picture"), rs.getInt("weight"),
						rs.getTimestamp("publishTime"), rs.getString("source"));
				newsList.add(temp);
			}
			return newsList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<newsInfo> getNews(int topicId) {
		// 获取某类新闻的新闻列表
		ArrayList<newsInfo> newsList = new ArrayList<newsInfo>();
		String sqlString = "select * from newsinfo where topicId = " + topicId + ";";
		ResultSet rs = mysqlDao.doQuery(sqlString);
		try {
			while (rs.next()) {
				newsInfo temp = new newsInfo(rs.getInt("newsId"), rs.getString("title"), rs.getInt("topicId"),
						rs.getString("url"), rs.getString("picture"), rs.getInt("weight"),
						rs.getTimestamp("publishTime"), rs.getString("source"));
				newsList.add(temp);
			}
			return newsList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<newsInfo> getNews(String favoriteString) {
		ArrayList<newsInfo> newsList = new ArrayList<newsInfo>();
		String sqlString = "select * from newsinfo where topicId in " + favoriteString + ";";
		ResultSet rs = mysqlDao.doQuery(sqlString);
		try {
			while (rs.next()) {
				newsInfo temp = new newsInfo(rs.getInt("newsId"), rs.getString("title"), rs.getInt("topicId"),
						rs.getString("url"), rs.getString("picture"), rs.getInt("weight"),
						rs.getTimestamp("publishTime"), rs.getString("source"));
				newsList.add(temp);
			}
			return newsList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean isExisted(newsInfo news) {
		//查找数据库中某条新闻是否存在
		String sqlString = "select * from newsinfo where Title = '" + news.getTitle() + "';";
		ResultSet rs = mysqlDao.doQuery(sqlString);
		try {
			if (rs.next())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	public ArrayList<newsInfo> searchNews(String keyWord) {
		// 查找包含某个词的新闻
		ArrayList<newsInfo> newsList = new ArrayList<newsInfo>();
		String sqlString = "select * from newsinfo where Title like " + "'%" + keyWord + "%';";
		ResultSet rs = mysqlDao.doQuery(sqlString);
		try {
			while (rs.next()) {
				newsInfo temp = new newsInfo(rs.getInt("newsId"), rs.getString("title"), rs.getInt("topicId"),
						rs.getString("url"), rs.getString("picture"), rs.getInt("weight"),
						rs.getTimestamp("publishTime"), rs.getString("source"));
				newsList.add(temp);
			}
			return newsList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addNews(newsInfo news) {
		// 向数据库中添加新闻
		String sqlString = "insert into newsinfo (title,topicId,url,picture,weight,publishTime,source) values ('"
				+ news.getTitle() + "'," + news.getTopicId() + ",'" + news.getUrl() + "'," + news.getPicture() + ",'"
				+ news.getWeight() + "','" + news.getPublishTime() + "','" + news.getSource() + "');";
		int result = 0;
		if (!isExisted(news)) {
			result = mysqlDao.doUpdate(sqlString);
		}
	}
}
