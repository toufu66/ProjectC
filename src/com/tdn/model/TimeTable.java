package com.tdn.model;

import java.sql.Timestamp;
/**
 * 水族館利用日のクラス
 * @author edu04
 *
 */
public class TimeTable {
	/**
	 * ユーザID
	 */
	private int uid;
	/**
	 * 利用日
	 */
	private Timestamp date;
	/**
	 * 水族館利用日のコンストラクタ
	 * @param uid
	 * @param date
	 */
	public TimeTable(int uid, Timestamp date) {
		this.uid = uid;
		this.date = date;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}

}
