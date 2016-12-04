package model;

import java.util.ArrayList;
import java.util.List;

public class userinfo {

	private int userId;
	private String username;
	private String password;
	private String email;
	private List<Integer> favorites = new ArrayList<Integer>();

	public userinfo() {
	}

	public userinfo(int userId, String username, String password, List<Integer> favorites) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.favorites = favorites;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Integer> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Integer> favorites) {
		this.favorites = favorites;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
