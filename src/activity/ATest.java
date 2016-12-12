package activity;

import Dao.NewsInfoDao;

public class ATest {
	/*
	 * 用于测试的类
	 */

	public static void main(String[] args) {

		NewsInfoDao mysqlDao = new NewsInfoDao();
		mysqlDao.InitData();
		// SinaNews sinaNews = new SinaNews();
		// sinaNews.getOnePage("http://news.sina.com.cn");
		// sinaNews.getOnePage("http://roll.news.sina.com.cn/s/channel.php?ch=01#col=89&spec="
		// + "&type=&ch=01&k=&offset_page=0&offset_num=0&num=60&asc=&page=1");
		// System.out.println("End");
		// sinaNews.getHome();
		// sinaNews.getRollNews();
		// sinaNews.getNewsInfo("http://news.sina.com.cn/c/nd/2016-12-07/doc-ifxyiayq2651093.shtml");
		/* sinaNews.getOnePage("http://news.sina.com.cn/"); */

	}
}
