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

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
        HttpSession session = request.getSession();
        session.setAttribute("todayGoal", goal);

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
        response.sendRedirect("scheduleList.jsp");
    }
}
