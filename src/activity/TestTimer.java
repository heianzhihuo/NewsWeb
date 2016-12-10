package activity;

import java.util.TimerTask;

import Dao.NewsInfoDao;

public class TestTimer extends TimerTask {
	NewsInfoDao mysqlDao = new NewsInfoDao();
	ChinaNews chinaNews = new ChinaNews();

	public void run() {
		// do something ...
		mysqlDao.InitData();//每半个小时清空一次数据库
		chinaNews.getAll();//获得得中国新闻网的新闻
		System.out.println("hello world");
	}
}
