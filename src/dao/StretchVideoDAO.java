package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.StretchVideo;

/**
 * ストレッチ動画テーブルへのアクセスを担当するDAOクラス
 */
public class StretchVideoDAO {

    private Connection conn;

    /**
     * コンストラクタ（Connectionを受け取る）
     * @param conn データベース接続オブジェクト
     */
    public StretchVideoDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * ストレッチ番号から動画情報を取得
     * @param stretchNum ストレッチ番号
     * @return StretchVideoBean
     * @throws SQLException
     */
    public StretchVideo findByStretchNum(int stretchNum) throws SQLException {
        String sql = "SELECT video_url, stretch_num FROM stretch_video WHERE stretch_num = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, stretchNum);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    StretchVideo bean = new StretchVideo();
                    bean.setVideoUrl(rs.getString("video_url"));
                    bean.setStretchNum(rs.getInt("stretch_num"));
                    return bean;
                }
            }
        }
        return null;
    }

    /**
     * 新しい動画情報を登録
     * @param bean 登録する動画データ
     * @throws SQLException
     */
    public void insert(StretchVideo bean) throws SQLException {
        String sql = "INSERT INTO stretch_video (video_url, stretch_num) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bean.getVideoUrl());
            pstmt.setInt(2, bean.getStretchNum());
            pstmt.executeUpdate();
        }
    }

    /**
     * 動画URLを更新（ストレッチ番号指定）
     * @param bean 更新対象の動画データ
     * @throws SQLException
     */
    public void update(StretchVideo bean) throws SQLException {
        String sql = "UPDATE stretch_video SET video_url = ? WHERE stretch_num = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bean.getVideoUrl());
            pstmt.setInt(2, bean.getStretchNum());
            pstmt.executeUpdate();
        }
    }

    /**
     * ストレッチ番号で動画情報を削除
     * @param stretchNum 削除対象の番号
     * @throws SQLException
     */
    public void delete(int stretchNum) throws SQLException {
        String sql = "DELETE FROM stretch_video WHERE stretch_num = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, stretchNum);
            pstmt.executeUpdate();
        }
    }
}
