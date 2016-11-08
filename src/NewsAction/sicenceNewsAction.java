package NewsAction;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Dao.NewsDao;
import model.News;

public class sicenceNewsAction extends ActionSupport {
	List<News> sicenceNews = new ArrayList<News>();
	NewsDao newsDao = new NewsDao();

	public String excute() {
		sicenceNews = newsDao.getNews("sicence");
		return "SUCCESS";
	}

	public List<News> getSicenceNews() {
		return sicenceNews;
	}

	public void setSicenceNews(List<News> sicenceNews) {
		this.sicenceNews = sicenceNews;
	}

}
