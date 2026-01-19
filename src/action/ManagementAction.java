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

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
        List<Manegement_manager> list = new ArrayList<>();

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
        String url = "jdbc:h2:tcp://localhost/~/oruca";
        String user = "sa";
        String pass = "";

        try {
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
            Class.forName("org.h2.Driver");

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
            try (Connection conn = DriverManager.getConnection(url, user, pass);
                 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER");
                 ResultSet rs = pstmt.executeQuery()) {

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
                while (rs.next()) {
                    Manegement_manager m = new Manegement_manager();
                    m.setName(rs.getString("NAME"));
                    m.setEmail(rs.getString("EMAIL"));
                    m.setDepartmentNum(rs.getString("DEPARTMENT_NUM"));
<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
                    list.add(m);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
        request.setAttribute("userList", list);

<<<<<<< HEAD
=======

>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git
        request.getRequestDispatcher("manegement_manager.jsp").forward(request, response);
    }
}