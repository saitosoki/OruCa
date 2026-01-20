package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Stress; // 1. Beanをインポート（Sは大文字）

public class stressDao { // クラス名も大文字推奨

    // ※URL, USER, PASS はご自身の環境に合わせて修正してください
    private final String URL = "jdbc:mysql://localhost:3306/oruca_db";
    private final String USER = "root";
    private final String PASS = "password";

    public stressDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 引数の型を Stress に修正
    public void insert(Stress s) {
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

    // 戻り値とリストの型を Stress に修正
    public List<Stress> selectByUser(int user_num) {
        List<Stress> list = new ArrayList<>();
        String sql = "SELECT * FROM stress WHERE user_num = ? ORDER BY date";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, user_num);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Stress s = new Stress(); // インスタンス化も大文字
                    s.setUser_num(rs.getInt("user_num"));
                    s.setStress_score_num(rs.getInt("stress_score_num"));
                    s.setDate(rs.getDate("date"));
                    list.add(s);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 戻り値の型を Stress に修正
    public Stress selectByUserAndDate(int user_num, Date date) {
        Stress s = null;
        String sql = "SELECT * FROM stress WHERE user_num = ? AND date = ?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, user_num);
            ps.setDate(2, date);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    s = new Stress();
                    s.setUser_num(rs.getInt("user_num"));
                    s.setStress_score_num(rs.getInt("stress_score_num"));
                    s.setDate(rs.getDate("date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }
}