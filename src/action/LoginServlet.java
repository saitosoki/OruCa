package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Manegement_manager;
import dao.LoginDao;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String loginId = request.getParameter("login");
        String password = request.getParameter("password");

        LoginDao dao = new LoginDao();
        LoginAction customer = null;

        HttpSession session = request.getSession();

        try {
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
            customer = dao.search(loginId, password);

            if (customer != null) {
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
                customer.setPassword(null);

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
                Manegement_manager manager = new Manegement_manager();

<<<<<<< HEAD
                manager.setUserNum(customer.getId());
                manager.setName(customer.getName());
                manager.setDepartmentNum(customer.getDepartmentNum());
=======
>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git

<<<<<<< HEAD
=======
                manager.setUserNum(customer.getId());
                manager.setName(customer.getName());
                manager.setDepartmentNum(customer.getDepartmentNum());


>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
                session.setAttribute("user", manager);

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
                response.sendRedirect(request.getContextPath() + "/user/menu.jsp");

            } else {
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
                session.removeAttribute("user");
                request.setAttribute("errorMessage", "ログインIDまたはパスワードが違います");
                request.getRequestDispatcher("/user/login.jsp").forward(request, response);
            }

        } catch (Exception e) {
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
            session.removeAttribute("user");
            e.printStackTrace();
            request.setAttribute("errorMessage", "システムエラーが発生しました。");
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
        }
    }
}