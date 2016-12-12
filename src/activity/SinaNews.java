package activity;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import Dao.NewsInfoDao;
import Dao.TopicDao;
import model.newsInfo;
import model.newsTopic;

public class SinaNews {
	private TopicDao topicDao = new TopicDao();
	private ArrayList<newsTopic> topicList = topicDao.getTopics();
	FileOutputStream out;
	PrintStream p;

	public SinaNews() {
		/*try {
			out = new FileOutputStream("Data1.txt");
			p = new PrintStream(out);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		System.getProperties().put("proxySet", "true");
		System.getProperties().put("proxyHost", "127.0.0.1");
		System.getProperties().put("proxyPort", "8070");

	}

	private void print(String msg) {
		try {
			p.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int getTopicId(String topic) {
		int topicId = -1;
		if (topic.contains("金融") || topic.contains("证券") || topic.contains("财经")) {
			return topicDao.getTopicId("财经");
		}
		for (int i = 0; i < topicList.size(); i++) {
			if (topic.contains(topicList.get(i).getTopicName())) {
				return topicList.get(i).getTopicId();
			}
		}
		return topicId;
	}

	private String getTime(Document doc) {
		String timeString = null;
		for (int i = 0; i < doc.childNodeSize(); i++) {
			Node child = doc.childNode(i);
			if (child.nodeName().equals("#comment")) {
				timeString = child.toString();
				if (timeString.contains("published at")) {
					timeString = timeString.substring(21, 40);
					return timeString;
				}
			}
		}
		return timeString;
	}

	public void getNewsInfo(String url) {
		String title, publishTime = null, topic = null, source = null;
		int topicId = -1;
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
			// 下面获取标题
			Elements h1s = doc.select("h1");
			if (h1s == null) {
				return;
			}
			Element h1 = h1s.first();
			if (h1 == null) {
				return;
			}
			title = h1.text();

			Elements divs = doc.select("div[class=bread]");
			if (divs.isEmpty()) {
				divs = doc.select("div[class=path]");
			}
			if (!divs.isEmpty()) {
				topic = divs.text();
			}
			if (topic != null) {
				topicId = getTopicId(topic);
			} else {
				return;
			}

			// 下面获取时间
			/*
			 * Elements metas =
			 * doc.select("meta[name=weibo: article:create_at]"); if
			 * (!metas.isEmpty()) { Element meta = metas.first(); publishTime =
			 * meta.attr("content"); }
			 */
			publishTime = getTime(doc);

			// 下面获取来源
			Elements mets = doc.select("meta[name=mediaid]");
			if (!mets.isEmpty()) {
				Element mes = mets.first();
				source = mes.attr("content");
			}

			if (title != null && topicId != -1) {
				newsInfo tempNews = new newsInfo();
				tempNews.setTitle(title);
				tempNews.setTopicId(topicId);
				tempNews.setUrl(url);
				Timestamp timestamp = Timestamp.valueOf(publishTime);
				tempNews.setPublishTime(timestamp);
				tempNews.setSource(source);

				NewsInfoDao newsDao = new NewsInfoDao();
				newsDao.addNews(tempNews);
				/*
				 * print(title); print(url); print(topic); print(publishTime);
				 * print(source); print("++++++++++++++++++++");
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(url);
		}
	}

	public void getOnePage(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
			Elements links = doc.select("a[href]");
			for (Element link : links) {
				if (link.attr("abs:href").contains("sina.com.cn") && link.text().length() > 10) {
					// 判断链接是否为新闻链接
					getNewsInfo(link.attr("abs:href"));
					double t = Math.random();
					Thread.sleep((int) t * 10);
				}
			}
		} catch (Exception e) {
			System.out.println(url);
			e.printStackTrace();
		}
	}

	public void getRollNews() {
		String base = "http://roll.news.sina.com.cn/s/channel.php?ch=01#col=89&spec=&type=&ch=01&"
				+ "k=&offset_page=0&offset_num=0&num=60&asc=&page=";
		for (int i = 1; i <= 10; i++) {
			String url = base + i;
			System.out.println(url);
			getOnePage(url);
		}
		System.out.println("End!");
	}

	public void getHome() {
		getOnePage("http://news.sina.com.cn/");
		System.out.println("End Home");
	}

}
