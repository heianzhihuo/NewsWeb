package NewsAction;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Dao.NewsDao;
import model.News;

public class politicsNewsAction extends ActionSupport {
	List<News> politicsNews = new ArrayList<News>();
	NewsDao newsDao = new NewsDao();

	public String excute() {
		politicsNews = newsDao.getNews("politics");
		return "SUCCESS";
	}

	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}
	
}
