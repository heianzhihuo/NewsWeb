package NewsAction;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import Dao.NewsDao;
import model.News;

public class searchNews extends ActionSupport {
	
	List<News> searchResultNews = new ArrayList<News>();
	String keyWords;
	NewsDao newsDao = new NewsDao();
	
	public String excute() {
		searchResultNews = newsDao.searchNews(keyWords);
		return "SUCCESS";
	}

	public List<News> getSearchResultNews() {
		return searchResultNews;
	}

	public void setSearchResultNews(List<News> searchResultNews) {
		this.searchResultNews = searchResultNews;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	
}
