package NewsAction;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Dao.NewsInfoDao;
import Dao.TopicDao;
import Dao.UserDao;
import model.newsInfo;
import model.newsTopic;

public class NewsInfoAction extends ActionSupport implements ModelDriven<newsInfo> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 模型封装了新闻记录的全部字段：（id：新闻ID，topicid：新闻栏目ID，title：新闻标题，
	// content：新闻内容，author：新闻作者，date：新闻发布日期，topicTitle：新闻栏目名称）
	// 在通过视图请求控制器时，同名的请求参数保存到对应字段中，
	// 并将字段对象存放于ActionContext中，在结果视图中使用字段名称的OGNL表达式获得字段值
	// 如果请求参数中无同名参数，模型的int字段默认为0，String字段默认为空字符串。
	/*
	 * private TopicDao topicDao = new TopicDao(); private NewsInfoDao
	 * newsInfoDao = new NewsInfoDao();
	 */

	private newsInfo news = new newsInfo();// 声明模型

	@Override
	public newsInfo getModel() {
		// TODO Auto-generated method stub
		return news;
	}

	// 新闻话题ID
	private int queryTopicId;

	public int getQueryTopicId() {
		return queryTopicId;
	}

	public void setQueryTopicId(int queryTopicId) {
		this.queryTopicId = queryTopicId;
	}

	// 新闻话题
	private String queryTopicName;

	public String getQueryTopicName() throws Exception {
		TopicDao topicDao = new TopicDao();
		queryTopicName = topicDao.getTopicName(queryTopicId);
		return queryTopicName;
	}

	public void setQueryTopicName(String queryTopicName) {
		this.queryTopicName = queryTopicName;
	}

	// 子类新闻
	private List<newsInfo> subNews = new ArrayList<newsInfo>();

	public List<newsInfo> getSubNews() throws Exception {
		NewsInfoDao newsInfoDao = new NewsInfoDao();
		subNews = newsInfoDao.getNews(queryTopicId);
		return subNews;
	}

	public void setSubNews(List<newsInfo> subNews) {
		this.subNews = subNews;
	}

	// 返回的所有新闻
	private List<newsInfo> allNews = new ArrayList<newsInfo>();

	public List<newsInfo> getAllNews() throws Exception {
		NewsInfoDao newsInfoDao = new NewsInfoDao();
		allNews = newsInfoDao.getNews(queryTopicId);
		return allNews;
	}

	public void setAllNews(List<newsInfo> allNews) {
		this.allNews = allNews;
	}

	private List<newsInfo> favNews = new ArrayList<newsInfo>();

	public String showSubscribtion() {
		UserDao userDao = new UserDao();
		NewsInfoDao newsInfoDao = new NewsInfoDao();
		String username = ActionContext.getContext().getSession().get("username").toString();
		
		if (username == null) {
			return "login";
		} else {
			String favoriteString = userDao.getFavorites(username);
			favNews = newsInfoDao.getNews(favoriteString);
			return SUCCESS;
		}
	}

	// Action默认执行方法
	public String execute() throws Exception {
		return SUCCESS;
	}

	// getNewsList()为进入新闻链接列表页面操作的同名Action方法，
	// 在Action方法中未执行任何操作，只是通过Action类的各个字段传递数据
	public String getNewsList() {
		// 返回SUCCESS，表示客户端跳转到Action的success结果视图
		// 根据Action动态配置规则，结果视图为getNewsList.jsp
		return SUCCESS;
	}

	// showList()为完成显示新闻链接列表操作的同名Action方法，
	// 在Action方法中未执行任何操作，只是通过Action类的各个字段传递数据
	public String showList() {
		// 返回SUCCESS，表示客户端跳转到Action的success结果视图
		// 根据Action动态配置规则，结果视图为showList.jsp
		return SUCCESS;
	}

	// showIndexList()为完成新闻网站首页中显示新闻链接列表操作的同名Action方法，
	// 在Action方法中未执行任何操作，只是通过Action类的各个字段传递数据
	public String showIndexList() {
		// 返回SUCCESS，表示客户端跳转到Action的success结果视图
		// 根据Action动态配置规则，结果视图为showIndexList.jsp
		return SUCCESS;
	}

}
