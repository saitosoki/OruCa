package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.stress;

public class stressDao {


	private final String URL = "jdbc:mysql://localhost:3306/your_db_name";
	private final String USER = "your_user";
	private final String PASS = "your_password";


	public stressDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	public void insert(stress s) {
		String sql = "INSERT INTO stress (user_num, stress_score_num, date) VALUES (?, ?, ?)";
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, s.getUser_num());
			ps.setInt(2, s.getStress_score_num());
			ps.setDate(3, s.getDate());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public List<stress> selectByUser(int user_num) {
		List<stress> list = new ArrayList<>();
		String sql = "SELECT * FROM stress WHERE user_num = ? ORDER BY date";

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, user_num);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				stress s = new stress();
				s.setUser_num(rs.getInt("user_num"));
				s.setStress_score_num(rs.getInt("stress_score_num"));
				s.setDate(rs.getDate("date"));
				list.add(s);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public stress selectByUserAndDate(int user_num, Date date) {
		stress s = null;
		String sql = "SELECT * FROM stress WHERE user_num = ? AND date = ?";

		try (Connection con = DriverManager.getConnection(URL, USER, PASS);
			 PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, user_num);
			ps.setDate(2, date);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				s = new stress();
				s.setUser_num(rs.getInt("user_num"));
				s.setStress_score_num(rs.getInt("stress_score_num"));
				s.setDate(rs.getDate("date"));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
}
