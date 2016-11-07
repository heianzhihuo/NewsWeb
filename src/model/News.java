package model;

import java.sql.Date;
import java.sql.Time;

public class News {
	private int NewsID;
	private String Title;
	private String Type;// politics,economic,military,sports,science
	private String Link;
	private String Picture;
	private int Weight;
	private Date PublishDate;
	private Time PublishTime;
	private String Source;

	public News() {
	}

	public News(int newsID, String title, String type, String link, String picture, int weight, Date publishDate,
			Time publishTime, String source) {
		NewsID = newsID;
		Title = title;
		Type = type;
		Link = link;
		Picture = picture;
		Weight = weight;
		PublishDate = publishDate;
		PublishTime = publishTime;
		Source = source;
	}

	public Time getPublishTime() {
		return PublishTime;
	}

	public void setPublishTime(Time publishTime) {
		PublishTime = publishTime;
	}

	public int getNewsID() {
		return NewsID;
	}

	public void setNewsID(int newsID) {
		NewsID = newsID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(Date publishDate) {
		PublishDate = publishDate;
	}

	public String getLink() {
		return Link;
	}

	public void setLink(String link) {
		Link = link;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getPicture() {
		return Picture;
	}

	public void setPicture(String picture) {
		Picture = picture;
	}

	public int getWeight() {
		return Weight;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
}
