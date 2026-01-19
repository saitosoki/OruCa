<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Management System</title>
    <%-- CSSの読み込みもコンテキストパスを使用 --%>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/manegement_manager.css">
</head>
<body>

<div class="container">
    <h1>ユーザー管理システム</h1>

    <table>
        <thead>
            <tr>
                <th>名前</th>
                <th>メールアドレス</th>
                <th>所属部署</th>
                <th>状況確認</th>
            </tr>
        </thead>
        <tbody>
        <%
            String url = "jdbc:h2:tcp://localhost/~/oruca";
            String user = "sa";
            String pass = "";

            try (Connection conn = DriverManager.getConnection(url, user, pass);
                 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USER");
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    String dept = rs.getString("DEPARTMENT_NUM");
                    int userNum = rs.getInt("USER_NUM");

                    String deptClass = "dept-other";
                    if ("人事".equals(dept) || "人事部".equals(dept)) {
                        deptClass = "dept-jinji";
                    } else if ("開発".equals(dept) || "開発部".equals(dept)) {
                        deptClass = "dept-kaihatsu";
                    } else if ("営業".equals(dept) || "営業部".equals(dept)) {
                        deptClass = "dept-other";
                    }
        %>
                    <tr>
                        <td style="font-weight: 600; color: #2d3436;"><%= rs.getString("NAME") %></td>
                        <td><a href="mailto:<%= rs.getString("EMAIL") %>" class="email-link">
                            <%= rs.getString("EMAIL") %>
                        </a></td>
                        <td>
                            <span class="dept-badge <%= deptClass %>"><%= dept %></span>
                        </td>
                        <td>
                            <div class="action-buttons">
                                <%-- 既存の感情記録ボタン --%>
                                <a href="<%=request.getContextPath()%>/MentalHistoryServlet?userNum=<%= userNum %>&name=<%= rs.getString("NAME") %>" class="btn-history">
                                    感情記録
                                </a>
                                <%-- 新設のストレス度ボタン --%>
                                <a href="<%=request.getContextPath()%>/StressHistoryServlet?userNum=<%= userNum %>&name=<%= rs.getString("NAME") %>" class="btn-history btn-stress">
                                    ストレス度
                                </a>
                            </div>
                        </td>
                    </tr>
        <%
                }
            } catch (Exception e) {
                out.println("<tr><td colspan='4'>エラー: " + e.getMessage() + "</td></tr>");
            }
        %>
        </tbody>
    </table>

    <div class="button-group">
        <a href="<%=request.getContextPath()%>/user/menu.jsp" class="btn btn-menu">メニューに戻る</a>
        <a href="logout_manager.jsp" class="btn btn-logout"> ログアウト</a>
    </div>

</div>

</body>
</html>