package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StressCheck;
import dao.StressCheckDAO;

@WebServlet("/StressCheckAction")
public class StressCheckAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        Object loginObj = session.getAttribute("user");

        StressCheck sc = new StressCheck();

        if (loginObj != null) {
            if (loginObj instanceof action.LoginAction) {
                action.LoginAction user = (action.LoginAction) loginObj;
                sc.setName(user.getName());
                sc.setDepartmentNum(user.getDepartmentNum());
                sc.setUserNum(user.getId());
            } else if (loginObj instanceof bean.Manegement_manager) {
                bean.Manegement_manager manager = (bean.Manegement_manager) loginObj;
                sc.setName(manager.getName());
                sc.setDepartmentNum("0");
                sc.setUserNum(9999);
            }
        } else {
            sc.setName("不明なユーザー");
            sc.setDepartmentNum("0");
            sc.setUserNum(0);
        }

        sc.setQ1(convertToStar(request.getParameter("q1")));
        sc.setQ2(convertToStar(request.getParameter("q2")));
        sc.setQ3(convertToStar(request.getParameter("q3")));
        sc.setQ4(convertToStar(request.getParameter("q4")));
        sc.setQ5(convertToStar(request.getParameter("q5")));

        StressCheckDAO dao = new StressCheckDAO();
        int result = dao.insert(sc);

        if (result > 0) {
            response.sendRedirect(request.getContextPath() + "/user/mental.jsp?success=1&type=stress#stress-section");
        } else {
            response.sendRedirect(request.getContextPath() + "/user/mental.jsp?error=1&type=stress#stress-section");
        }
    }

    private String convertToStar(String value) {
        if (value == null) return "☆3";
        switch (value) {
            case "no":        return "☆5";
            case "sometimes": return "☆3";
            case "often":     return "☆2";
            case "always":    return "☆1";
            default:          return "☆3";
        }
    }
}