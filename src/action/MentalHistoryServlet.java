package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MentalCheck;
import dao.MentalCheckDAO;

@WebServlet("/MentalHistoryServlet")
public class MentalHistoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. リクエストから「name」パラメータを受け取る
        request.setCharacterEncoding("UTF-8"); // 文字化け防止
        String targetName = request.getParameter("name");

        // ★修正ポイント：固定していた「山田太郎」を消して、
        // 取得した targetName が空でない場合のみ検索する
        if (targetName != null && !targetName.isEmpty()) {
            targetName = targetName.trim();

            MentalCheckDAO dao = new MentalCheckDAO();
            List<MentalCheck> history = dao.findByName(targetName);

            request.setAttribute("targetName", targetName);
            request.setAttribute("history", history);
        }

        request.getRequestDispatcher("manager/mental_history.jsp").forward(request, response);
    }
}