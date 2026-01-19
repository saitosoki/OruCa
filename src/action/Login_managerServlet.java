package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;

@WebServlet("/LoginManagerServlet")
public class Login_managerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
        String loginId = request.getParameter("login");
        String password = request.getParameter("password");

        LoginDao dao = new LoginDao();
        LoginAction customer = null;

        HttpSession session = request.getSession();

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
        try {
        	customer = dao.search(loginId, password);

        	if (customer != null) {
        		customer.setPassword(null);
        		session.setAttribute("user", customer);
        	    response.sendRedirect(request.getContextPath() + "/manager/manegement_manager.jsp");

            } else {
            	session.removeAttribute("user");
                request.setAttribute("errorMessage", "ログインIDまたはパスワードが違います");
                request.getRequestDispatcher(request.getContextPath() + "/manager/login_manager.jsp");
            }

        } catch (Exception e) {
            session.removeAttribute("user");
            e.printStackTrace();
            request.setAttribute("errorMessage", "システムエラーが発生しました。");
            request.getRequestDispatcher("/manager/login_manager.jsp").forward(request, response);
        }
    }
}