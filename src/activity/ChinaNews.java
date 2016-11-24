package activity;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.border.TitledBorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.newsInfo;

public class ChinaNews {
	public HashMap<String, String> TopicList = new HashMap<String, String>();
	String baseUrlString = "http://www.chinanews.com/";
	ArrayList<newsInfo> subNewsList = new ArrayList<newsInfo>();

	public void getTopics() {
		Document doc = null;
		try {
			doc = Jsoup.connect(baseUrlString).get();
			Elements groups = doc.select("[class=group]");
			Elements links = groups.select("a[href]");
			for (Element link : links) {
				TopicList.put(link.text(), link.attr("abs:href"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void getNewsList(String url){
		Document doc = null;
		try{
			doc = Jsoup.connect(url).get();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/*
	 * public void getNews(String topic) { Document doc = null; String url =
	 * TopicList.get(topic); try {
	 * 
	 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
	 * }
	 */

	public newsInfo getNewsInfo(String url) {
		newsInfo temp = new newsInfo();
		Document doc = null;
		temp.setUrl(url);
		try {
			doc = Jsoup.connect(url).get();
			Elements titles = doc.select("h1");
			Element title = titles.first();
			temp.setTitle(title.text());
			/*Elements usages = doc.select("div[class=left-t]");
			Element usageElement  = usages.first();
			System.out.println(usageElement.text());*/
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}
}
