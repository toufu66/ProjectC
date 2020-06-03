package com.tdn.model;

import java.sql.Timestamp;
/**
 *
 * ユーザクラス
 *
 */
public class User {
	/**
	 * ユーザID
	 */
	private int uid;    //user id

	/**
	 * 名前
	 */
	private String name;     //user name

	/**
	 * 性別 gender id
	 */
	private int gid;      //gender id

	/**
	 *  誕生日
	 */
	private  Timestamp birthday;     //birthday

	/**
	 *  メールアドレス
	 */
	private String mail;       //mailaddress

	/**
	 *  保有ポイント
	 */
	private int point;       //point

	/**
	 *  パスワード
	 */
	private String password;

	/**
	 *  会員区分コード 0 or1or 2
	 */
	private int uclass;       //user class (区分)

	/**
	 * コンストラクタ
	 */
	public User() {}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUclass() {
		return uclass;
	}

	public void setUclass(int uclass) {
		this.uclass = uclass;
	}



}
