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

        request.setCharacterEncoding("UTF-8");
        String targetName = request.getParameter("name");

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