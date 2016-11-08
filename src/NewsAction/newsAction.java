package NewsAction;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.News;

public class newsAction extends ActionSupport {
	
	List<News> hotNews = new ArrayList<News>(); 
	List<News> finaceNews = new ArrayList<News>();
	List<News> sportsNews = new ArrayList<News>();
	List<News> politicsNews = new ArrayList<News>();
	List<News> educationNews = new ArrayList<News>();
	
	
	public String index(){
		return SUCCESS;
	}


	public List<News> getHotNews() {
		return hotNews;
	}


	public void setHotNews(List<News> hotNews) {
		this.hotNews = hotNews;
	}


	public List<News> getFinaceNews() {
		return finaceNews;
	}


	public void setFinaceNews(List<News> finaceNews) {
		this.finaceNews = finaceNews;
	}


	public List<News> getSportsNews() {
		return sportsNews;
	}


	public void setSportsNews(List<News> sportsNews) {
		this.sportsNews = sportsNews;
	}


	public List<News> getPoliticsNews() {
		return politicsNews;
	}


	public void setPoliticsNews(List<News> politicsNews) {
		this.politicsNews = politicsNews;
	}


	public List<News> getEducationNews() {
		return educationNews;
	}


	public void setEducationNews(List<News> educationNews) {
		this.educationNews = educationNews;
	}
	
	
}
