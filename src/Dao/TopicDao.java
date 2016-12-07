package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.newsTopic;

public class TopicDao {
	private Dao mysqlDao;

	public TopicDao() {
		mysqlDao = new Dao();
	}

	public ArrayList<newsTopic> getTopics() {
		ArrayList<newsTopic> topicList = new ArrayList<newsTopic>();
		String sqlString = "select * from topics;";
		ResultSet rs = mysqlDao.doQuery(sqlString);
		try {
			while (rs.next()) {
				newsTopic temp = new newsTopic(rs.getInt("topicId"), rs.getInt("parentID"), rs.getString("topicName"));
				topicList.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topicList;
	}

	public int getTopicId(String topicName) {
		String sqlString = "select topicId from topics where topicName = '" + topicName + "';";
		int topicId = -1;
		ResultSet rs = mysqlDao.doQuery(sqlString);
		try {
			if (rs.next()) {
				topicId = rs.getInt("topicId");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return topicId;
	}

	public String getTopicName(int topicId) {
		String sqlString = "select * from topics where topicId = " + topicId;
		String topicName = null;
		ResultSet rSet = mysqlDao.doQuery(sqlString);
		try {
			if (rSet.next()) {
				topicName = rSet.getString("topicName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return topicName;
	}
	
	public void addTopic(String topicName) {
		String sqlString = "insert into topics (topicName) values " + "'" + topicName + "';";
		mysqlDao.doUpdate(sqlString);
	}

}
