package model;

public class newsTopic {
	private int topicId;
	private int parentId;
	private String topicName;

	public newsTopic(int topicId, int parentId, String topicName) {
		this.topicId = topicId;
		this.parentId = parentId;
		this.topicName = topicName;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
}
