<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="../css/login.css">

<form action="<%= request.getContextPath() %>/LoginServlet" method="post">

    <title>ログイン</title>
    <h1>OruCaログイン画面</h1>

    <p style="color: red;">
    <%-- エラーメッセージがセットされていれば表示する --%>
    <%
        String errorMessage = (String)request.getAttribute("errorMessage");
        if (errorMessage != null) {
            out.println(errorMessage);
        }
    %>
    </p>
    <p>ユーザID / パスワードをご入力の上、「ログイン」ボタンをクリックしてください。</p>
    <div>

        <input type="text" id="login" name="login" placeholder="ログインIDを入力" required><br>
        <input type="password" id="password" name="password" placeholder="パスワードを入力" required>
    </div>
    <button type="submit" value="ログイン">ログイン</button>
</form>