package NewsAction;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Dao.NewsDao;
import model.News;

public class financeNewsAction extends ActionSupport {
	List<News> financeNews = new ArrayList<News>();
	NewsDao newsDao = new NewsDao();

	public String excute(){
		financeNews = newsDao.getNews("finance");
		return "SUCCESS";
	}

	public List<News> getFinanceNews() {
		return financeNews;
	}

	public void setFinanceNews(List<News> financeNews) {
		this.financeNews = financeNews;
	}
	
}
