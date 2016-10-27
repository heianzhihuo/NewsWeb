package model;

import java.sql.Date;

public class User {
	private String NickName;
	private String PassWord;
	private String Email;
	private Date BirthDate;
	private String Profession;
	
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}
	public String getProfession() {
		return Profession;
	}
	public void setProfession(String profession) {
		Profession = profession;
	}
	
}
