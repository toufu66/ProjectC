package com.tdn.model;

public class Userclass {
	/**
	 * 会員クラスのID
	 */
	private int cid;
	/**
	 * 会員クラス
	 */
	private String uclass;
	/**
	 * 会員クラスのコンストラクタ
	 * @param cid
	 * @param uclass
	 */
	public Userclass(int cid, String uclass) {
		this.cid = cid;
		this.uclass = uclass;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getUclass() {
		return uclass;
	}
	public void setUclass(String uclass) {
		this.uclass = uclass;
	}

}
