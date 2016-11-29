package activity;


import Dao.NewsInfoDao;

public class ATest {
	
	public static void main(String[] args) {
		//pATest.testGetNewsInfo();
		//NewsInfoDao newsDao = new NewsInfoDao();
		ChinaNews chinaNews = new ChinaNews();
		chinaNews.getNewsInfo("http://www.chinanews.com/gj/2016/11-26/8075241.shtml");
		/*int topic = chinaNews.getTopicId("金融");
		System.out.println(topic);*/
		
		/*ArrayList<newsInfo> newsList = newsDao.getNews(1);
		System.out.println(newsList.get(0).getPublishTime());*/
		//Date date = new Date(2016,, day)
	}
}
