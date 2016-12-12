package activity;

import java.util.TimerTask;

import Dao.NewsInfoDao;

public class TestTimer extends TimerTask {
	NewsInfoDao mysqlDao = new NewsInfoDao();
	ChinaNews chinaNews = new ChinaNews();
	SinaNews sinaNews = new SinaNews();

	public void run() {
		// do something ...
		mysqlDao.InitData();//每半个小时清空一次数据库
		chinaNews.getHome();
		sinaNews.getHome();
		chinaNews.getRollNews();//获得得中国新闻网的新闻
		sinaNews.getRollNews();//获得得新浪新闻的新闻
		
		System.out.println("hello world");
	}
}
