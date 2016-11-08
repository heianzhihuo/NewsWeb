package NewsAction;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Dao.NewsDao;
import model.News;

public class entertainmentNewsAction extends ActionSupport{
	
	List<News> entertainmentNews = new ArrayList<News>();
	NewsDao newsDao = new NewsDao();

	public String excute(){
		entertainmentNews = newsDao.getNews("entertainment");
		return "SUCCESS";
	}

	public List<News> getEntertainmentNews() {
		return entertainmentNews;
	}

	public void setEntertainmentNews(List<News> entertainmentNews) {
		this.entertainmentNews = entertainmentNews;
	}

}
