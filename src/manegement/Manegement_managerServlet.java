package manegement;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Manegement_manager;
import dao.Manegement_managerDao;

@WebServlet("/manegement")
public class Manegement_managerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // DAO 呼び出し
        Manegement_managerDao dao = new Manegement_managerDao();
        List<Manegement_manager> list = dao.findAll();

        // JSP に渡す
        request.setAttribute("manegerList", list);

        // 画面へ転送
        request.getRequestDispatcher("/manager/manegement_manager.jsp")
        .forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
