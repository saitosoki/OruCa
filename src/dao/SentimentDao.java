package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.sentimental;


public class SentimentDao {

	// データベース接続情報（※環境に合わせて変更してください）
	private final String URL = "jdbc:mysql://localhost:3306/your_db_name";
	private final String USER = "your_user";
	private final String PASS = "your_password";

	// コンストラクタ
	public SentimentDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 感情スコアを登録
	public void insert(sentimental s) {
		String sql = "INSERT INTO sentiment (user_num, sentiment_score_num, date) VALUES (?, ?, ?)";
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, s.getUser_num());
			ps.setInt(2, s.getSentiment_score_num());
			ps.setDate(3, s.getDate());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 指定ユーザーの全感情データを取得
	public List<sentimental> selectByUser(int user_num) {
		List<sentimental> list = new ArrayList<>();
		String sql = "SELECT * FROM sentiment WHERE user_num = ? ORDER BY date";

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, user_num);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				sentimental s = new sentimental();
				s.setUser_num(rs.getInt("user_num"));
				s.setSentiment_score_num(rs.getInt("sentiment_score_num"));
				s.setDate(rs.getDate("date"));
				list.add(s);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 指定ユーザー＋日付のデータを1件取得
	public sentimental selectByUserAndDate(int user_num, Date date) {
		sentimental s = null;
		String sql = "SELECT * FROM sentiment WHERE user_num = ? AND date = ?";

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, user_num);
			ps.setDate(2, date);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				s = new sentimental();
				s.setUser_num(rs.getInt("user_num"));
				s.setSentiment_score_num(rs.getInt("sentiment_score_num"));
				s.setDate(rs.getDate("date"));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
}
