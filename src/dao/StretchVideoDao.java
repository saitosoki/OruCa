package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.StretchVideo;

public class StretchVideoDao {

    // DB接続情報（必要に応じて環境に合わせて変更）

    private static final String URL = "jdbc:h2:tcp://localhost/~/oruca";

    private static final String USER = "sa";

    private static final String PASSWORD = "";

    // JDBCドライバの読み込み（初回のみ）

    static {

        try {

            Class.forName("org.h2.Driver");

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

    }

    // --- INSERT ---

    public void insert(StretchVideo video) {

        String sql = "INSERT INTO stretch_videos (video_url, stretch_num) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, video.getVideoUrl());

            pstmt.setInt(2, video.getStretchNum());

            pstmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // --- SELECT（全件取得） ---

    public List<StretchVideo> findAll() {

        List<StretchVideo> list = new ArrayList<>();

        String sql = "SELECT * FROM physical";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

             Statement stmt = conn.createStatement();

             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                StretchVideo v = new StretchVideo();

                v.setVideoUrl(rs.getString("video_url"));

                v.setStretchNum(rs.getInt("stretch_num"));

                list.add(v);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return list;

    }

    // --- SELECT（1件取得） ---

    public StretchVideo findById(int id) {

        String sql = "SELECT * FROM stretch_videos WHERE id = ?";

        StretchVideo video = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {

                    video = new StretchVideo();

                    video.setVideoUrl(rs.getString("video_url"));

                    video.setStretchNum(rs.getInt("stretch_num"));

                }

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return video;

    }

    // --- UPDATE ---

    public void update(int id, StretchVideo video) {

        String sql = "UPDATE stretch_videos SET video_url=?, stretch_num=? WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, video.getVideoUrl());

            pstmt.setInt(2, video.getStretchNum());

            pstmt.setInt(3, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    // --- DELETE ---

    public void delete(int id) {

        String sql = "DELETE FROM stretch_videos WHERE id=?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}

