<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, bean.Schedule, dao.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>スケジュール一覧</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-4">
    <h2 class="text-center text-primary mb-4">今日の目標とスケジュール</h2>

    <% String goal = (String) session.getAttribute("todayGoal"); %>
    <div class="alert alert-warning text-center fw-bold">
        今日の目標： <%= (goal != null && !goal.isEmpty()) ? goal : "未設定です" %>
    </div>

    <%
        ScheduleDao dao = new ScheduleDaoImpl();
        List<Schedule> list = dao.findAll();
        if (list.isEmpty()) {
    %>
        <p class="text-center text-muted">まだ予定は登録されていません。</p>
    <% } else { %>
        <table class="table table-bordered table-striped">
            <thead class="table-success">
                <tr><th>ユーザー番号</th><th>日付</th><th>コメント</th></tr>
            </thead>
            <tbody>
                <% for (Schedule s : list) { %>
                    <tr>
                        <td><%= s.getUserNum() %></td>
                        <td><%= s.getDate() %></td>
                        <td><%= s.getComment() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } %>

    <div class="text-center mt-3">
        <a href="scheduleForm.jsp" class="btn btn-primary">戻る</a>
    </div>
</div>
</body>
</html>
