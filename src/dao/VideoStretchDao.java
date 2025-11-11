package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.VideoStretch;

/**
 * video_stretchテーブルへのアクセスを担当するDAOクラス。
 */
public class VideoStretchDao {

    // 🚨 以下の【設定必須】セクションを、ご自身のデータベース環境に合わせて書き換えてください。

    // 【設定必須】使用するデータベースへの接続URL。例: MySQLなら "jdbc:mysql://ホスト名:ポート番号/データベース名"
    private static final String DB_URL = "jdbc:mysql://localhost:3306/oruca_db";

    // 【設定必須】データベースに接続するためのユーザー名
    private static final String USER = "dbuser";

    // 【設定必須】データベースに接続するためのパスワード
    private static final String PASS = "dbpass";

    // 物理テーブル名。設計書で 'physical' とありましたが、ここでは分かりやすいように 'video_stretch' としています。
    // 実際に使用するテーブル名に合わせて確認・変更してください。
    private static final String TABLE_NAME = "video_stretch";

    /**
     * DB接続を取得するヘルパーメソッド
     */
    private Connection getConnection() throws SQLException {
        // 🚨 【確認】JDBCドライバーがプロジェクトに導入されている必要があります。
        // 例：MySQLなら 'mysql-connector-java.jar'
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    // --- 以降のCRUDメソッドは基本的なロジックは完成していますが、例外処理やリソース管理を確認してください ---

    /**
     * 新しいレコードをデータベースに挿入する。
     */
    public boolean insert(VideoStretch stretch) {
        // SQL文のテーブル名が正しいか確認してください
        String sql = "INSERT INTO " + TABLE_NAME + " (video_url, stretch_num) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, stretch.getVideoUrl());
            pstmt.setInt(2, stretch.getStretchNum());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            // 🚨 【推奨変更点】エラーが発生した場合の処理を、プロジェクトのログ出力方法に合わせて変更してください。
            // 例: Log4jなどのロギングライブラリを使う
            System.err.println("データベース挿入エラー: " + e.getMessage());
            return false;
        }
    }

    /**
     * 主キー(video_url)に基づいてレコードを取得する。
     */
    public VideoStretch findByVideoUrl(String videoUrl) {
        // SQL文のテーブル名とWHERE句の列名が正しいか確認してください
        String sql = "SELECT video_url, stretch_num FROM " + TABLE_NAME + " WHERE video_url = ?";
        VideoStretch stretch = null;

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, videoUrl);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    stretch = new VideoStretch();
                    // 🚨 【確認】getString/getInt の引数は、データベースの物理列名と一致している必要があります
                    stretch.setVideoUrl(rs.getString("video_url"));
                    stretch.setStretchNum(rs.getInt("stretch_num"));
                }
            }
        } catch (SQLException e) {
            // 🚨 【推奨変更点】エラーが発生した場合の処理を、プロジェクトのログ出力方法に合わせて変更してください。
            System.err.println("データベース検索エラー: " + e.getMessage());
        }
        return stretch;
    }

    /**
     * 主キー(video_url)に基づいてレコードを更新する。
     */
    public boolean update(VideoStretch stretch) {
        // SQL文のSET句とWHERE句の列名が正しいか確認してください
        String sql = "UPDATE " + TABLE_NAME + " SET stretch_num = ? WHERE video_url = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, stretch.getStretchNum());
            pstmt.setString(2, stretch.getVideoUrl());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            // 🚨 【推奨変更点】エラーが発生した場合の処理を、プロジェクトのログ出力方法に合わせて変更してください。
            System.err.println("データベース更新エラー: " + e.getMessage());
            return false;
        }
    }

    /**
     * 主キー(video_url)に基づいてレコードを削除する。
     */
    public boolean delete(String videoUrl) {
        // SQL文のWHERE句の列名が正しいか確認してください
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE video_url = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, videoUrl);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            // 🚨 【推奨変更点】エラーが発生した場合の処理を、プロジェクトのログ出力方法に合わせて変更してください。
            System.err.println("データベース削除エラー: " + e.getMessage());
            return false;
        }
    }

    // 💡 【追加推奨】すべてのレコードを取得する findALL() メソッドなど、必要な機能を追加することも検討してください。
    // 例: public List<VideoStretch> findAll() {...}
}