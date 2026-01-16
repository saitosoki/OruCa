package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.MentalCheck;

public class MentalCheckDAO {

    private final String URL = "jdbc:h2:tcp://localhost/~/oruca";
    private final String USER = "sa";
    private final String PASS = "";

    public int insert(MentalCheck bean) {
        int result = 0;
        String sql = "INSERT INTO MENTAL_CHECK (NAME, DEPARTMENT_NUM, USER_NUM, Q1, Q2, Q3, Q4, Q5) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, bean.getName());
            pstmt.setString(2, bean.getDepartmentNum());
            pstmt.setInt(3, bean.getUserNum());
            pstmt.setString(4, bean.getQ1());
            pstmt.setString(5, bean.getQ2());
            pstmt.setString(6, bean.getQ3());
            pstmt.setString(7, bean.getQ4());
            pstmt.setString(8, bean.getQ5());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 特定のユーザーの名前で回答履歴を最新順に取得する
     */
 // MentalCheckDAO.java の findByName メソッド内
    public List<MentalCheck> findByName(String name) {
        List<MentalCheck> list = new ArrayList<>();
        // SQLをシンプルにする（WHERE句のミスを防ぐ）
        String sql = "SELECT * FROM MENTAL_CHECK WHERE NAME = ? ORDER BY ID DESC";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    MentalCheck mc = new MentalCheck();
                    mc.setName(rs.getString("NAME"));
                    mc.setQ1(rs.getString("Q1"));
                    mc.setQ2(rs.getString("Q2"));
                    mc.setQ3(rs.getString("Q3"));
                    mc.setQ4(rs.getString("Q4"));
                    mc.setQ5(rs.getString("Q5"));

                    // ★日付の取得：列番号ではなく「列名」で指定するのが一番確実です。
                    // image_e9bb64 を見ると、一番右の列名は恐らく「DATE」や「CREATED_AT」ではありませんか？
                    // もしわからなければ、一旦 rs.getTimestamp(9) か rs.getTimestamp(10) を試してください。
                    try {
                        mc.setDate(rs.getTimestamp(9));
                    } catch (Exception e) {
                        // 9番目でダメなら10番目を試す（安全策）
                        mc.setDate(rs.getTimestamp(10));
                    }

                    list.add(mc);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}