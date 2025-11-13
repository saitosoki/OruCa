package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/setGoal")
public class SetGoalAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String goal = request.getParameter("goal");

        // 簡単な保存例（今回はセッションに保存するだけ）
        HttpSession session = request.getSession();
        session.setAttribute("todayGoal", goal);

        // goal設定後にスケジュール一覧画面へ移動
        response.sendRedirect("scheduleList.jsp");
    }
}
