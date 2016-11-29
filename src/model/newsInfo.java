package model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class newsInfo {
	private int newsId;
	private String title;
	private int topicId;
	private String url;
	private String picture;
	private int weight;
	private Timestamp publishTime;
	private String source;

	public newsInfo() {
	}

	public newsInfo(int newsId, String title, int topicId, String url, String picture, int weight,
			Timestamp publishTime, String source) {
		super();
		this.newsId = newsId;
		this.title = title;
		this.topicId = topicId;
		this.url = url;
		this.picture = picture;
		this.weight = weight;
		this.publishTime = publishTime;
		this.source = source;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Timestamp getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
