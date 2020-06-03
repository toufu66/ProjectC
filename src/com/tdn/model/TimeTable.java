package com.tdn.model;

import java.sql.Timestamp;

public class TimeTable {
	private int uid;//ユーザID
	private Timestamp date;//利用日
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
