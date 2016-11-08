package NewsAction;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Dao.NewsDao;
import model.News;

public class militaryNewsAction extends ActionSupport {
	List<News> militaryNews = new ArrayList<News>();
	NewsDao newsDao = new NewsDao();

	public String excute() {
		militaryNews = newsDao.getNews("military");
		return "SUCCESS";
	}

	public List<News> getMilitaryNews() {
		return militaryNews;
	}

	public void setMilitaryNews(List<News> militaryNews) {
		this.militaryNews = militaryNews;
	}
	
}
