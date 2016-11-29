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
		mysqlDao.doExecute("truncate table news");
	}

	public ArrayList<newsInfo> getNews() {
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
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<newsInfo> getNews(int topicId) {

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

	public ArrayList<newsInfo> searchNews(String keyWord) {
		ArrayList<newsInfo> newsList = new ArrayList<newsInfo>();
		String sqlString = "select * from newsinfo where Title like " + "'%" + keyWord + "%';";
		ResultSet rs = mysqlDao.doQuery(sqlString);
		try {
			while (rs.next()) {
				newsInfo temp = new newsInfo(rs.getInt("newsId"), rs.getString("title"), rs.getInt("topicId"),
						rs.getString("url"), rs.getString("picture"), rs.getInt("weight"),
						rs.getTimestamp("publichTime"), rs.getString("source"));
				newsList.add(temp);
			}
			return newsList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addNews(newsInfo news) {
		String sqlString = "insert into newsInfo (title,topicId,url,picture,weight,publishTime,source) values ('"
				+ news.getTitle() + "'," + news.getTopicId() + ",'" + news.getUrl() + "'," + news.getPicture() + ",'"
				+ news.getWeight() + "','" + news.getPublishTime() + "','" + news.getSource() + "');";
		int result = mysqlDao.doUpdate(sqlString);
	}

	public void addNews(List<newsInfo> newsList) {
		String sqlString = "";
	}

}
