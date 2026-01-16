package physical;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/physical")
public class Physical extends HttpServlet {


    private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/oruca";
    private static final String USER = "sa";
    private static final String PASS = "";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String selectedUrl = "";
        int stretchNum = 0;


        String sql = "SELECT VIDEO_URL, STRETCH_NUM FROM PHYSICAL ORDER BY RAND() LIMIT 1";

        try {
            Class.forName("org.h2.Driver");
            try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
                 PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    selectedUrl = rs.getString("VIDEO_URL");
                    stretchNum = rs.getInt("STRETCH_NUM");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        request.setAttribute("videoUrl", selectedUrl);
        request.setAttribute("videoNo", stretchNum);

        request.getRequestDispatcher("/WEB-INF/jsp/physical.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}