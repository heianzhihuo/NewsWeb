package NewsAction;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Dao.NewsDao;
import model.News;

public class societyNewsAction extends ActionSupport {
	List<News> societyNews = new ArrayList<News>();
	NewsDao newsDao = new NewsDao();

	public String excute() {
		societyNews = newsDao.getNews("society");
		return "SUCCESS";
	}

	public List<News> getSocietyNews() {
		return societyNews;
	}

	public void setSocietyNews(List<News> societyNews) {
		this.societyNews = societyNews;
	}

}
