package com.tdn.model;
/**
 * 管理者のクラス
 * @author edu04
 *
 */
public class Admin {
	/**
	 * 管理者ID
	 */
	private String adminId;
	/**
	 * 管理者パスワード
	 */
	private String password;
	/**
	 * 管理者IDのゲッター
	 * @return 管理者ID取得
	 */
	public String getadminId() {
		return adminId;
	}
	/**
	 * 管理者IDのセッター
	 * @param 管理者IDの設置
	 */
	public void setadminId(String adminId) {
		this.adminId = adminId;
	}
	public Admin() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	/**
	 * 管理者パスワードのゲッター
	 * @return 管理者パスワードの取得
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 管理者パスワードのセッター
	 * @param 管理者パスワードの設置
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
