<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ストレス度チェック履歴</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/mental_history.css">
    <style>
        .card h2 { color: #e67e22; border-bottom: 2px solid #e67e22; }
        .history-table th { background-color: #f39c12; }
    </style>
</head>
<body>
    <div class="card">
    <h2>${not empty targetName ? targetName : 'ユーザー'} さんのストレス度チェック履歴</h2>

    <c:choose>
        <c:when test="${not empty history}">
            <table class="history-table">
                <thead>
                    <tr>
                        <th>実施日時</th>
                        <th>Q1</th>
                        <th>Q2</th>
                        <th>Q3</th>
                        <th>Q4</th>
                        <th>Q5</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="h" items="${history}">
                        <tr>
								<td><fmt:formatDate value="${h.createdAt}" pattern="yyyy/MM/dd HH:mm"/></td>

								<td><c:out value="${h.q1}" /></td>
								<td><c:out value="${h.q2}" /></td>
								<td><c:out value="${h.q3}" /></td>
								<td><c:out value="${h.q4}" /></td>
								<td><c:out value="${h.q5}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="no-data"><p>ストレスチェックの履歴データが見つかりませんでした。</p></div>
        </c:otherwise>
    </c:choose>

    <div class="btn-container">
        <a href="<%= request.getContextPath() %>/manager/manegement_manager.jsp" class="btn btn-blue">ユーザー管理システムに戻る</a>
    </div>
</div>
</body>
</html>