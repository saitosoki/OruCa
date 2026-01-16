package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Manegement_manager; // さっき作ったBeanをインポート

@WebServlet("/ManagementAction") // ブラウザからアクセスする時の名前
public class ManagementAction extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // データを格納するリスト
        List<Manegement_manager> list = new ArrayList<>();

        // H2データベース接続情報 (画像から引用)
        String url = "jdbc:h2:tcp://localhost/~/oruca";
        String user = "sa";
        String pass = "";

        try {
            // 1. ドライバの読み込み
            Class.forName("org.h2.Driver");

            // 2. 接続・SQL実行
            try (Connection conn = DriverManager.getConnection(url, user, pass);
                 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER");
                 ResultSet rs = pstmt.executeQuery()) {

                // 3. 結果を1行ずつ取り出してリストに入れる
                while (rs.next()) {
                    Manegement_manager m = new Manegement_manager();
                    m.setName(rs.getString("NAME"));
                    m.setEmail(rs.getString("EMAIL"));
                    m.setDepartmentNum(rs.getString("DEPARTMENT_NUM"));
                    // 必要に応じて他の項目も追加
                    list.add(m);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 4. JSPに「userList」という名前でデータを渡す
        request.setAttribute("userList", list);

        // 5. 表示するJSP（manegement_manager.jsp）に移動する
        request.getRequestDispatcher("manegement_manager.jsp").forward(request, response);
    }
}