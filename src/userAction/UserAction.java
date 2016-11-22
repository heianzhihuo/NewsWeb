package userAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Dao.UserDao;
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
		String username = user.getUsername();
		// String password = user.getPassword();
		System.out.println(username);
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
		ActionContext.getContext().getSession().put("username", null);
		ActionContext.getContext().getSession().put("password", null);
		return SUCCESS;
	}
	
	public String Register() throws Exception {
		String username = user.getUsername();
		String password = user.getPassword();
		UserDao userDao = new UserDao();
		if(userDao.addUser(username, password)==0) {
			this.addFieldError("username", "该用户名已经被注册了！");
			return INPUT;
		} else {
			ActionContext.getContext().getSession().put("username", username);
			ActionContext.getContext().getSession().put("password", password);
			return SUCCESS;
		}
	}
	
	public String addFavorites() {
		return SUCCESS;
	}
}
