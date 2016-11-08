package NewsAction;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Dao.NewsDao;
import model.News;

public class sportsNewsAction extends ActionSupport {
	List<News> sportsNews = new ArrayList<News>();
	NewsDao newsDao = new NewsDao();

	public String excute() {
		sportsNews = newsDao.getNews("sports");
		return "SUCCESS";
	}

	public List<News> getSportsNews() {
		return sportsNews;
	}

	public void setSportsNews(List<News> sportsNews) {
		this.sportsNews = sportsNews;
	}
	
}
