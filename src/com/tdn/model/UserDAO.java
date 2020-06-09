package com.tdn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * ユーザDAO
 *
 */
public class UserDAO {
	// 定数宣言
			static final String URL =  "jdbc:mysql://localhost/aquarium?useSSL=false";
			static final String USER = "java";
			static final String PASS = "pass";

			/**
			 *
			 * @param u ユーザ情報
			 * @param sql SQL文
			 *
			 */

			//update
			public void update(User u) {
				try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

					String sql = "update user_table set name=?,ruby=?,gender=?,birthday=?,mail=?,point=?,uclass=? where uid = ?";
					PreparedStatement stmt = con.prepareStatement(sql);
					//各?部分にユーザ情報を挿入
					stmt.setString(1,u.getName());
					stmt.setString(2, u.getRuby());
					stmt.setInt(3, u.getGid());
					stmt.setTimestamp(4, u.getBirthday());
					stmt.setString(5, u.getMail());
					stmt.setInt(6, u.getPoint());
					stmt.setInt(7, u.getUclass());
					stmt.setInt(8, u.getUid());

					stmt.executeUpdate();

					stmt.close();

				} catch (SQLException e) {
					System.out.println("updateエラー" + e.getMessage());
				}
			}

			/**
			 *
			 * @param u ユーザ情報
			 * @param sql SQL文
			 *
			 */
			//insert
			public void insert(User u) {
				try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

					//SQL文定義
					String sql = "INSERT INTO user_table (uid,name,ruby,gender,birthday,mail,point,pass,uclass) VALUES(0,?,?,?,?,?,0,?,?)";
					PreparedStatement stmt = con.prepareStatement(sql);

					//各?部分にユーザ情報を挿入
					stmt.setString(1,u.getName());
					stmt.setString(2, u.getRuby());
					stmt.setInt(3, u.getGid());
					stmt.setTimestamp(4, u.getBirthday());
					stmt.setString(5, u.getMail());
					stmt.setString(6, u.getPassword());
					stmt.setInt(7, u.getUclass());

					//SQL文を実行
					stmt.execute();

					stmt.close();

				} catch (SQLException e) {
					System.out.println("insertエラー" + e.getMessage());
				}
			}


			/**
			 *
			 * @param uid ユーザID
			 */
			//delete
			public void delete(int uid) {
				try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

					String sql = "delete from user_table where uid = ?";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setInt(1, uid);

					stmt.executeUpdate();

					stmt.close();

				} catch (SQLException e) {
					System.out.println("deleteエラー" + e.getMessage());
				}
			}


			/**
			 *
			 * @param ulist ユーザリスト
			 * @param sql SQL文
			 * @param name ユーザ名
			 * @param ruby ふりがな
			 * @param date1 最も遠い利用日
			 * @param date2 最も近い利用日
			 * @return 検索結果がなければnull,検索結果があれば検索したUserリスト(ArrayList<User>型)を返す
			 */
			//findUser
 			public ArrayList<User> findUser(String name,String ruby,String date1,String date2) {
				ArrayList<User> ulist = new ArrayList<>();
				try (Connection con = DriverManager.getConnection(URL,USER,PASS);){

					//SQL文を格納する変数を用意
					String sql = "select * from user_table";
					PreparedStatement stmt = con.prepareStatement(sql);

					//ふりがなが入力されているかどうか判定

					//名前検索
					if (ruby.equals("") && !name.equals("")) {
						//date1とdate2に日付が入力されている(区間検索)
						if(date1 != null && date2 != null) {
							sql ="select * from user_table left outer join date_table on user_table.uid = date_table.uid where name LIKE ? and date BETWEEN ? and ? group by name";
							stmt = con.prepareStatement(sql);
							//日付定義
							stmt.setString(1,"%"+name+"%");
							stmt.setString(2, date1);
							stmt.setString(3, date2);
						}else if(date1 != null){
							sql ="select * from user_table left outer join date_table on user_table.uid = date_table.uid where name LIKE ? and date >= ? group by name";
							stmt = con.prepareStatement(sql);
							//日付定義
							stmt.setString(1,"%"+name+"%");
							stmt.setString(2, date1);
						}else if(date2 != null){
							sql ="select * from user_table left outer join date_table on user_table.uid = date_table.uid where name LIKE ? and date <= ? group by name";
							stmt = con.prepareStatement(sql);
							//日付定義
							stmt.setString(1,"%"+name+"%");
							stmt.setString(2, date2);
						}else {
							//SQL文定義(名前)
							sql += " where name LIKE ? ";
							//1個目の?にnameをセット
							stmt = con.prepareStatement(sql);
							stmt.setString(1,"%"+name+"%");
						}

					//フリガナ検索
					}else if(!ruby.equals("")){
						//date1とdate2に日付が入力されている(区間検索)
						if(date1 != null && date2 != null) {
							sql ="select * from user_table left outer join date_table on user_table.uid = date_table.uid where ruby LIKE ? and date BETWEEN ? and ? group by name";
							stmt = con.prepareStatement(sql);
							//日付定義
							stmt.setString(1,"%"+ruby+"%");
							stmt.setString(2, date1);
							stmt.setString(3, date2);
						}else if(date1 != null){
							sql ="select * from user_table left outer join date_table on user_table.uid = date_table.uid where ruby LIKE ? and date >= ? group by name";
							stmt = con.prepareStatement(sql);
							//日付定義
							stmt.setString(1,"%"+ruby+"%");
							stmt.setString(2, date1);
						}else if(date2 != null){
							sql ="select * from user_table left outer join date_table on user_table.uid = date_table.uid where ruby LIKE ? and date <= ? group by name";
							stmt = con.prepareStatement(sql);
							//日付定義
							stmt.setString(1,"%"+ruby+"%");
							stmt.setString(2, date2);
						}else {
							//SQL文定義(ふりがな)
							sql += " where ruby LIKE ? ";
							//1個目の?にrubyをセット
							stmt = con.prepareStatement(sql);
							stmt.setString(1, "%"+ruby+"%");
						}
					}else {
						//date1とdate2に日付が入力されている(区間検索)
						if(date1 != null && date2 != null) {
							sql ="select * from user_table inner join date_table on user_table.uid = date_table.uid where date BETWEEN ? and ? group by name";
							stmt = con.prepareStatement(sql);
							//日付定義
							stmt.setString(1, date1);
							stmt.setString(2, date2);
						}
						//date1にのみに日付が入力されている(date1以降を検索)
						else if(date1 != null) {
							sql ="select * from user_table left outer join date_table on user_table.uid = date_table.uid where date >= ? group by name";
							stmt = con.prepareStatement(sql);
							stmt.setString(1, date1);
						}
						//date2にのみに日付が入力されている(date2以前を検索)
						else if(date2 != null) {
							sql ="select * from user_table left outer join date_table on user_table.uid = date_table.uid where date <= ? group by name";
							stmt = con.prepareStatement(sql);
							stmt.setString(1, date2);
						}
					}
					//SQL文を実行(指定された条件のUserリストを取り出す)
					ResultSet rs = stmt.executeQuery();

					//DBからUserを取り出せたら
					while(rs.next()){
						//取り出した情報からデータを取得
						int uid = rs.getInt("uid");
						String userName = rs.getString("name");
						String userRuby = rs.getString("ruby");
						int gid = rs.getInt("gender");
						Timestamp birthday = rs.getTimestamp("birthday");
						String mail = rs.getString("mail");
						int point = rs.getInt("point");
						String password = rs.getString("pass");
						int uClass = rs.getInt("uclass");

						//User情報を生成
						User u = new User(uid,userName,userRuby,gid,birthday,mail,point,password,uClass);
						ulist.add(u);
					}

					stmt.close();

				} catch (SQLException e) {
					System.out.println("findUserエラー" + e.getMessage());
				}
				return ulist;
			}

			/**
			 * @param uid ユーザID
			 * @return 検索結果がなければnull,検索結果があれば検索したUser情報(User型)を返す
			 */
			//findByUid
			public User findByUid(int uid) {

				User u = null;

				try (Connection con = DriverManager.getConnection(URL,USER,PASS);){
					//SQL文定義
					String sql = "select * from user_table where uid = ?";
					PreparedStatement stmt = con.prepareStatement(sql);
					//?にuidをセット
					stmt.setInt(1, uid);
					//SQL文を実行(指定されたuidのUserを取り出す)
					ResultSet rs = stmt.executeQuery();

					//DBからUserを取り出せたら
					if(rs.next()){
						//取り出した情報からデータを取得
						String name = rs.getString("name");
						String ruby = rs.getString("ruby");
						int gid = rs.getInt("gender");
						Timestamp birthday = rs.getTimestamp("birthday");
						String mail = rs.getString("mail");
						int point = rs.getInt("point");
						String password = rs.getString("pass");
						int uClass = rs.getInt("uclass");
						//User情報を生成
						//System.out.print( ""+uid+name+ruby+gid+birthday+mail+point+password+uClass);
						u = new User(uid,name,ruby,gid,birthday,mail,point,password,uClass);
					}

					stmt.close();

				} catch (SQLException e) {
					System.out.println("findByUidエラー" + e.getMessage());
				}
				return u;
			}

			public ArrayList<Gender> getGenderList(){
				ArrayList<Gender> genderList = new ArrayList<>();

				try (Connection con = DriverManager.getConnection(URL,USER,PASS);){
					String sql = "select * from gender_table";
					PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					while(rs.next()){
						//取り出した情報からデータを取得
						int gid = rs.getInt("gid");
						String gender = rs.getString("gender");

						//User情報を生成
						Gender g = new Gender(gid,gender);
						genderList.add(g);
					}
				}catch(SQLException e) {

				}

				return genderList;
			}

			public ArrayList<Userclass> getUserclassList(){
				ArrayList<Userclass> userclassList = new ArrayList<>();

				try (Connection con = DriverManager.getConnection(URL,USER,PASS);){
					String sql = "select * from class_table";
					PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					while(rs.next()){
						//取り出した情報からデータを取得
						int cid = rs.getInt("cid");
						String uclasstype = rs.getString("type");

						//User情報を生成
						Userclass u = new Userclass(cid,uclasstype);
						userclassList.add(u);
					}
				}catch(SQLException e) {

				}

				return userclassList;
			}
}




