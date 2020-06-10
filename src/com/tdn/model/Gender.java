package com.tdn.model;
/**
 * 性別のクラス
 * @author 栄
 *
 */
public class Gender {
	/**
	 * 性別ID
	 */
	private int gid;
	/**
	 * 性別名
	 */
	private String gender;
	/**
	 * 性別のコンストラクタ
	 * @param gid
	 * @param gender
	 */
	public Gender(int gid, String gender) {
		this.gid = gid;
		this.gender = gender;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
