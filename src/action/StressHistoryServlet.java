package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StressCheck;
import dao.StressCheckDAO;

@WebServlet("/StressHistoryServlet")
public class StressHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // パラメータの取得
        String userNumStr = request.getParameter("userNum");
        String targetName = request.getParameter("name");

        // 文字化け対策
        request.setCharacterEncoding("UTF-8");

        try {
            if (userNumStr != null && !userNumStr.isEmpty()) {
                int userNum = Integer.parseInt(userNumStr);

                StressCheckDAO dao = new StressCheckDAO();
                // DAOで特定のユーザーの履歴を取得
                List<StressCheck> history = dao.findByUserNum(userNum);

                // リクエスト属性にセットしてJSPへ渡す
                request.setAttribute("history", history);
                request.setAttribute("targetName", targetName);
            } else {
                // userNumがない場合はエラーメッセージをセット
                request.setAttribute("errorMessage", "ユーザーIDが正しく指定されていません。");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "不正なユーザーIDです。");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "システムエラーが発生しました。");
        }

        // ストレス履歴表示用のJSPへフォワード
        // パスが /manager/stress_history.jsp であることを確認してください
        request.getRequestDispatcher("/manager/stress_history.jsp").forward(request, response);
    }
}