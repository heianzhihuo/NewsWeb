package NewsAction;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Dao.TopicDao;
import model.newsTopic;

public class TopicAction extends ActionSupport implements ModelDriven<newsTopic> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private newsTopic topic = new newsTopic();

	@Override
	public newsTopic getModel() {
		return topic;
	}

	public void setTopic(newsTopic topic) {
		this.topic = topic;
	}

	// Action默认执行方法
	public String execute() {
		return SUCCESS;
	}

	public String showTopicList() {
		return SUCCESS;
	}

	private List<newsTopic> topicList;

	public List<newsTopic> getTopicList() {
		TopicDao topicDao = new TopicDao();
		topicList = topicDao.getTopics();
		return topicList;
	}

	public void setTopicList(List<newsTopic> topicList) {
		this.topicList = topicList;
	}

}
