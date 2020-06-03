package com.tdn.model;

import java.sql.Timestamp;

public class TimeTable {
	/**
	 * ユーザID
	 */
	private int uid;
	/**
	 * 利用日
	 */
	private Timestamp date;
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
