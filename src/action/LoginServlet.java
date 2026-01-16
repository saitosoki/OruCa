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
            // DBからログインユーザーを検索
            customer = dao.search(loginId, password);

            if (customer != null) {
                // 認証成功の場合
                customer.setPassword(null);

                // --- MentalCheckActionで使うためにManegement_managerへ詰め替える ---
                Manegement_manager manager = new Manegement_manager();

                // 修正ポイント：正しい値をセットします
                manager.setUserNum(customer.getId());         // ユーザーID (1, 2...)
                manager.setName(customer.getName());          // ★ getLoginではなくgetNameを使う
                manager.setDepartmentNum(customer.getDepartmentNum()); // ★ 部署番号も追加

                // セッションに "user" という名前で manager を保存
                session.setAttribute("user", manager);

                // メニュー画面へ遷移
                response.sendRedirect(request.getContextPath() + "/user/menu.jsp");

            } else {
                // 認証失敗の場合
                session.removeAttribute("user");
                request.setAttribute("errorMessage", "ログインIDまたはパスワードが違います");
                request.getRequestDispatcher("/user/login.jsp").forward(request, response);
            }

        } catch (Exception e) {
            // システムエラーの場合
            session.removeAttribute("user");
            e.printStackTrace();
            request.setAttribute("errorMessage", "システムエラーが発生しました。");
            request.getRequestDispatcher("/user/login.jsp").forward(request, response);
        }
    }
}