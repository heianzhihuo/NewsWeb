package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.newsTopic;

public class TopicDao {
	private Dao mysqlDao;

	public TopicDao() throws Exception {
		mysqlDao = new Dao();
	}

	public List<newsTopic> getTopics() throws Exception {
		List<newsTopic> topicList = new ArrayList<newsTopic>();
		String sqlString = "select * from topics;";
		ResultSet rs = mysqlDao.doQuery(sqlString);
		while (rs.next()) {
			newsTopic temp = new newsTopic(rs.getInt("topicId"), rs.getInt("parentID"), rs.getString("topicName"));
			topicList.add(temp);
		}
		return topicList;
	}

	public int getTopicId(String topicName) throws Exception {
		String sqlString = "select topicId from topics where topicName = " + topicName;
		int topicId = -1;
		ResultSet rs = mysqlDao.doQuery(sqlString);
		if (rs.next()) {
			topicId = rs.getInt("topicId");
		}
		return topicId;
	}

	public String getTopicName(int topicId) throws Exception {
		String sqlString = "select * from topics where topicId = " + topicId;
		String topicName = null;
		ResultSet rSet = mysqlDao.doQuery(sqlString);
		if (rSet.next()) {
			topicName = rSet.getString("topicName");
		}
		return topicName;
	}

	public void addTopic(String topicName) throws Exception {
		String sqlString = "insert into topics (topicName) values " + "'" + topicName + "';";
		mysqlDao.doUpdate(sqlString);
	}

	public String getTopicList(int queryTopicId) throws Exception {
		String topicList;
		List<newsTopic> list1 = new ArrayList<newsTopic>();
		int id, id2;
		int parentId, parentId2;
		String title, title2;
		ResultSet rs = mysqlDao.doQuery("select all * from topics where parentid<>0");
		while (rs.next()) {
			id = rs.getInt("topicid");
			parentId = rs.getInt("parentid");
			title = rs.getString("title");
			list1.add(new newsTopic(id, parentId, title));
		}
		rs = mysqlDao.doQuery("select all * from topics where parentid=0");
		topicList = "<select name=\"topicid\" id=\"topicid\" style=\"width: 120px\">";
		while (rs.next()) {
			id = rs.getInt("topicid");
			parentId = rs.getInt("parentid");
			title = rs.getString("title");
			topicList = topicList + "<option value =\"" + id + "\" ";
			// 如果栏目ID与请求的栏目ID相同，则添加默认选中标记
			if (id == queryTopicId) {
				topicList = topicList + " selected";
			}
			topicList = topicList + ">" + title + "</option>";
			Iterator<newsTopic> ib = list1.iterator();
			newsTopic news;
			while (ib.hasNext()) {// 在一级栏目下方添加所有子栏目选项
				news = ib.next();
				id2 = news.getTopicId();
				parentId2 = news.getParentId();
				title2 = news.getTopicName();
				if (id == parentId2) {
					topicList = topicList + "<option value =\"" + id2 + "\" ";
					// 如果栏目ID与请求的栏目ID相同，则添加默认选中标记
					if (id2 == queryTopicId) {
						topicList = topicList + " selected";
					}
					topicList = topicList + ">&nbsp;" + title + "::" + title2 + "</option>";
				}
			}
		}
		topicList = topicList + "</select>";
		return topicList;
	}

	public void setParentTopic(newsTopic topic, String parentTopic) throws Exception {
		String sqlString = "";
	}

}
