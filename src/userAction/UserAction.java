package userAction;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Dao.TopicDao;
import Dao.UserDao;
import model.newsInfo;
import model.newsTopic;
import model.userinfo;

public class UserAction extends ActionSupport implements ModelDriven<userinfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private userinfo user = new userinfo();

	@Override
	public userinfo getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public void setUser(userinfo user) {
		this.user = user;
	}

	public String Login() throws Exception {
		// 登录
		String username = user.getUsername();
		// String password = user.getPassword();
		// System.out.println(username);
		UserDao userDao = new UserDao();
		String password = userDao.getPassword(username);
		if (password == null) {
			this.addFieldError("username", "此用户不存在！");
			return INPUT;
		} else if (password.compareTo(user.getPassword()) == 0) {
			ActionContext.getContext().getSession().put("username", username);
			ActionContext.getContext().getSession().put("password", password);
			return SUCCESS;
		} else {
			this.addFieldError("username", "密码错误！");
			return INPUT;
		}
	}

	public String Logout() throws Exception {
		// 登出
		ActionContext.getContext().getSession().put("username", null);
		ActionContext.getContext().getSession().put("password", null);
		return SUCCESS;
	}

	public String Register() throws Exception {
		// 注册
		String username = user.getUsername();
		String password = user.getPassword();
		UserDao userDao = new UserDao();
		if (userDao.addUser(user) == 0) {
			this.addFieldError("username", "该用户名已经被注册了！");
			return INPUT;
		} else {
			ActionContext.getContext().getSession().put("username", username);
			ActionContext.getContext().getSession().put("password", password);
			return SUCCESS;
		}
	}

	private ArrayList<String> favoriteList = new ArrayList<String>();
	private ArrayList<newsTopic> topicList = new ArrayList<newsTopic>();

	public String Subscribe() {
		// 设置订阅
		String username = ActionContext.getContext().getSession().get("username").toString();
		UserDao userDao = new UserDao();
		TopicDao topicDao = new TopicDao();
		if (username == null) {// 未登录
			this.addFieldError("username", "请先登录！");
			return INPUT;
		} else {
			if (favoriteList.size() > 0) {// 提交订阅
				String favoriteString = favoriteList.toString();
				favoriteString = favoriteString.replace('[', '(');
				favoriteString = favoriteString.replace(']', ')');
				userDao.setFavorites(username, favoriteString);
				return SUCCESS;
			} else {// 显示话题
				topicList = topicDao.getTopics();
				return INPUT;
			}
		}
	}

	public ArrayList<newsTopic> getTopicList() {
		return topicList;
	}

	public void setTopicList(ArrayList<newsTopic> topicList) {
		this.topicList = topicList;
	}

	public ArrayList<String> getFavoriteList() {
		return favoriteList;
	}

	public void setFavoriteList(ArrayList<String> favoriteList) {
		this.favoriteList = favoriteList;
	}
}
