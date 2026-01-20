package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Manegement_manager;

@WebServlet("/ManagementAction")
public class ManagementAction extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Manegement_manager> list = new ArrayList<>();

        String url = "jdbc:h2:tcp://localhost/~/oruca";
        String user = "sa";
        String pass = "";

        try {
            Class.forName("org.h2.Driver");

            try (Connection conn = DriverManager.getConnection(url, user, pass);
                 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER");
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    Manegement_manager m = new Manegement_manager();
                    m.setName(rs.getString("NAME"));
                    m.setEmail(rs.getString("EMAIL"));
                    m.setDepartmentNum(rs.getString("DEPARTMENT_NUM"));

                    list.add(m);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("userList", list);

        request.getRequestDispatcher("manegement_manager.jsp").forward(request, response);
    }
}