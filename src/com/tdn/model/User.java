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


	public void setUid() {}
	public void setName() {}
	public void setGid() {}
	public void setBirthday() {}
	public void setMail() {}
	public void setPoint() {}
	public void setPassword() {}
	public void setUclass() {}

	public int getUid() {}
	public String  getName() {}
	public int getGid() {}
	public Timestamp getBirthday() {}
	public String getMail() {}
	public int getPoint() {}
	public String getPassword() {}
	public int getUclass() {}


}
