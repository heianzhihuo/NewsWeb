package NewsAction;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Dao.NewsDao;
import model.News;

public class gamesNewsAction extends ActionSupport {
	List<News> gamesNews = new ArrayList<News>();
	NewsDao newsDao = new NewsDao();

	public String excute(){
		gamesNews = newsDao.getNews("games");
		return "SUCCESS";
	}

	public List<News> getGamesNews() {
		return gamesNews;
	}

	public void setGamesNews(List<News> gamesNews) {
		this.gamesNews = gamesNews;
	}
	
}
