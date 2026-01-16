package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Manegement_manager;
import bean.MentalCheck;
import dao.MentalCheckDAO;

@WebServlet("/MentalCheckAction")
public class MentalCheckAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        Object loginObj = session.getAttribute("user");

        String q1 = request.getParameter("e1");
        String q2 = request.getParameter("e2");
        String q3 = request.getParameter("e3");
        String q4 = request.getParameter("e4");
        String q5 = request.getParameter("e5");

        MentalCheck mc = new MentalCheck();

        if (loginObj instanceof LoginAction) {
            LoginAction user = (LoginAction) loginObj;
            mc.setName(user.getName());
            mc.setDepartmentNum(user.getDepartmentNum());
            mc.setUserNum(user.getId());
        } else if (loginObj instanceof Manegement_manager) {
            Manegement_manager manager = (Manegement_manager) loginObj;
            mc.setName(manager.getName());
            mc.setDepartmentNum("0");
            mc.setUserNum(9999);
        }

        mc.setQ1(convertToStar(q1));
        mc.setQ2(convertToStar(q2));
        mc.setQ3(convertToStar(q3));
        mc.setQ4(convertToStar(q4));
        mc.setQ5(convertToStar(q5));

        MentalCheckDAO dao = new MentalCheckDAO();
        int result = dao.insert(mc);

        if (result > 0) {
            response.sendRedirect(request.getContextPath() + "/user/mental.jsp?success=1");
        } else {
            response.sendRedirect(request.getContextPath() + "/user/mental.jsp?error=1");
        }
    }

    private String convertToStar(String value) {
        if (value == null) return "☆1";
        switch (value.toLowerCase()) {
            case "happy":    return "☆5";
            case "high":     return "☆5";
            case "good":     return "☆4";
            case "some":     return "☆4";
            case "neutral":  return "☆3";
            case "bad":      return "☆2";
            case "low":      return "☆2";
            case "terrible": return "☆1";
            case "none":     return "☆1";
            default:         return "☆3";
        }
    }
}