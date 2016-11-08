package NewsAction;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Dao.NewsDao;
import model.News;

public class hotNewsAction extends ActionSupport {
	List<News> hotNews = new ArrayList<News>();
	NewsDao newsDao = new NewsDao();

	public String excute(){
		hotNews = newsDao.getNews("hot");
		return "SUCCESS";
	}

	public List<News> getHotNews() {
		return hotNews;
	}

	public void setHotNews(List<News> hotNews) {
		this.hotNews = hotNews;
	}
	
	
}
