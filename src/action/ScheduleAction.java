package action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Schedule;
import dao.ScheduleDao;
import dao.ScheduleDaoImpl;

@WebServlet("/schedule")
public class ScheduleAction extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int userNum = Integer.parseInt(request.getParameter("userNum"));
        Date date = Date.valueOf(request.getParameter("date"));
        String comment = request.getParameter("comment");

        Schedule schedule = new Schedule(userNum, date, comment);

        ScheduleDao dao = new ScheduleDaoImpl();
        dao.insert(schedule);

        response.sendRedirect("scheduleList.jsp");
    }
}