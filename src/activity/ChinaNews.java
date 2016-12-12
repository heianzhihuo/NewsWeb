package activity;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Dao.NewsInfoDao;
import Dao.TopicDao;
import model.newsInfo;
import model.newsTopic;

public class ChinaNews {
	private TopicDao topicDao = new TopicDao();
	private ArrayList<newsTopic> topicList = topicDao.getTopics();

	public void getHome() {
		String baseUrl = "http://www.chinanews.com/";
		getOnePage(baseUrl);// 获取首页新闻
		System.out.println("End Home");
	}

	public void getRollNews() {
		String base = "http://www.chinanews.com/scroll-news/news";
		for (int i = 1; i <= 10; i++) {
			String url = base + i + ".html";
			// System.out.println(url);
			getOnePage(url);// 获取滚动新闻
		}
		System.out.println("End");
	}

	public void getOnePage(String url) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
			Elements links = doc.select("a[href]");
			for (Element link : links) {
				if (link.attr("abs:href").contains("chinanews.com") && link.text().length() > 10) {
					// 判断链接是否为新闻链接
					getNewsInfo(link.attr("abs:href"));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(url);
			e.printStackTrace();
		}
	}

	private int getTopicId(String topic) {
		int topicId = -1;
		if (topic.contains("金融")) {
			return topicDao.getTopicId("财经");
		} else if (topic.contains("IT")) {
			return topicDao.getTopicId("科技");
		}
		for (int i = 0; i < topicList.size(); i++) {
			if (topic.contains(topicList.get(i).getTopicName())) {
				return topicList.get(i).getTopicId();
			}
		}
		return topicId;
	}

	public void getNewsInfo(String url) {
		String title, publishTime, topic;
		String source = null;
		int topicId;
		Document doc = null;
		// temp.setUrl(url);
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

			// 下面获取话题
			Elements divs = doc.select("div[id=nav]");
			if (divs.isEmpty()) {
				return;
			}

			topic = divs.text();
			topicId = getTopicId(topic);
			if (topicId < 1) {
				return;
			}

			// 下面获取发布时间
			Elements spans = doc.select("span[id=pubtime_baidu]");
			publishTime = spans.text();
			Timestamp timestamp = Timestamp.valueOf(publishTime);

			// 下面获取来源
			spans = doc.select("span[id=source_baidu]");
			if (!spans.isEmpty()) {
				source = spans.first().text().replace("来源：", "");
			}

			/*
			 * System.out.println(title+","+topicId+","+topic);
			 * System.out.println(publishDate+publishTime+source);
			 */

			newsInfo tempNews = new newsInfo();
			tempNews.setTitle(title);
			tempNews.setTopicId(topicId);
			tempNews.setUrl(url);
			tempNews.setPublishTime(timestamp);
			tempNews.setSource(source);

			NewsInfoDao newsDao = new NewsInfoDao();
			newsDao.addNews(tempNews);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(url);
		}
	}
}
