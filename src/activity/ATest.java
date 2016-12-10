package activity;


import Dao.NewsInfoDao;

public class ATest {
	
	public static void main(String[] args) {
		//NewsInfoDao mysqlDao = new NewsInfoDao();
		//mysqlDao.InitData();
		//pATest.testGetNewsInfo();
		//NewsInfoDao newsDao = new NewsInfoDao();
		/*ChinaNews chinaNews = new ChinaNews();
		chinaNews.getAll();*/
		//chinaNews.getOnePage("http://www.chinanews.com/scroll-news/news1.html");
		//chinaNews.getNewsInfo("http://www.chinanews.com/gj/2016/11-26/8075241.shtml");
		/*int topic = chinaNews.getTopicId("金融");
		System.out.println(topic);*/
		
		/*ArrayList<newsInfo> newsList = newsDao.getNews(1);
		System.out.println(newsList.get(0).getPublishTime());*/
		//Date date = new Date(2016,, day)
		
		SinaNews sinaNews= new SinaNews();
		//sinaNews.getNewsInfo("http://news.sina.com.cn/c/nd/2016-12-07/doc-ifxyiayq2651093.shtml");
		sinaNews.getOnePage("http://news.sina.com.cn/");
		
	}
}
