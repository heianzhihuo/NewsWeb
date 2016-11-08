package NewsAction;

import java.util.ArrayList;
import java.util.List;
import Dao.NewsDao;

import com.opensymphony.xwork2.ActionSupport;

import model.News;

public class educationNewsAction extends ActionSupport{
	
	List<News> educationNews = new ArrayList<News>();
	NewsDao newsDao = new NewsDao();

	public String excute(){
		educationNews = newsDao.getNews("education");
		return "SUCCESS";
	}
	
	public List<News> getEducationNews() {
		return educationNews;
	}

	public void setEducationNews(List<News> educationNews) {
		this.educationNews = educationNews;
	}
		
}
