<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 1. 両方のクラスをインポートしておく --%>
<%@ page import="action.LoginAction" %>
<%@ page import="bean.Manegement_manager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>メニュー</title>
    <link rel="stylesheet" href="../css/menu.css">
</head>
<body>
    <div class="container">
        <%

            Object loginObj = session.getAttribute("user");
            String userName = "ゲスト";

            if (loginObj instanceof LoginAction) {

                userName = ((LoginAction) loginObj).getName();
            } else if (loginObj instanceof Manegement_manager) {

                userName = ((Manegement_manager) loginObj).getName();
            }
        %>
        <%-- 3. ログイン中の名前を表示 --%>
        <p style="text-align: right; color: #555; padding-right: 20px;">
            ログイン中：<strong><%= userName %></strong> 様
        </p>

        <div class="title-box">
            <h1>OruCaメニュー画面</h1>
        </div>
        <div class="subtitle-grid">
            <button type="submit" onclick="location.href='physical.jsp'" class="subtitle-box">フィジカルヘルス</button>
            <button type="submit" onclick="location.href='mental.jsp'" class="subtitle-box">メンタルヘルス</button>
            <button type="submit" onclick="location.href='logout.jsp'" class="mini-subtitle-box">ログアウト</button>
            <button type="submit" onclick="location.href='<%= request.getContextPath() %>/manager/login_manager.jsp'" class="mini-subtitle-box2">マネージャー専用</button>
        </div>
    </div>
</body>
</html>