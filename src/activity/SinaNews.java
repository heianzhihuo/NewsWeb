package activity;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Dao.TopicDao;
import model.newsTopic;

public class SinaNews {
	private TopicDao topicDao = new TopicDao();
	private ArrayList<newsTopic> topicList = topicDao.getTopics();
	FileOutputStream out;
	PrintStream p;

	public SinaNews() {
		try {
			out = new FileOutputStream("Data.txt");
			p = new PrintStream(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.getProperties().put("proxySet", "true");
		System.getProperties().put("proxyHost", "127.0.0.1");
		System.getProperties().put("proxyPort", "8080");

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
		String title, publishTime = null, topic = null, source = null;
		int topicId = 0;
		Document doc = null;
		try {
			// System.out.println("Start");
			doc = Jsoup.connect(url).get();
			// p.println(doc);
			print(url);
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
			Elements linksElements = doc.select("link[rel=alternate]");
			if (!linksElements.isEmpty()) {
				Element link = linksElements.first();
				// System.out.println(link);
				topic = link.attr("title");
			}

			// 下面获取时间
			Elements metas = doc.select("meta[name=weibo: article:create_at]");
			if (!metas.isEmpty()) {
				Element meta = metas.first();
				publishTime = meta.attr("content");
			}

			// 下面获取来源
			Elements mets = doc.select("meta[name=mediaid]");
			if (!metas.isEmpty()) {
				Element mes = mets.first();
				source = mes.attr("content");
			}

			print(title);
			print(topic);
			print(publishTime);
			print(source);
			print("++++++++++++++++++++");

			/*
			 * System.out.println(title); System.out.println(publishTime);
			 * System.out.println(topic); System.out.println(source);
			 */

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
					Thread.sleep((int) t * 100);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(url);
			e.printStackTrace();
		}
		System.out.println("End");
	}

	public void getRollNews() {

	}

}
