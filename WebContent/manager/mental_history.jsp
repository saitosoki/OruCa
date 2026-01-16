<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>メンタルチェック履歴</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/mental_history.css">
</head>
<body>
    <div class="card">
    <h2>${not empty targetName ? targetName : history[0].name} さんの回答履歴</h2>

    <c:choose>
        <c:when test="${not empty history}">
            <table class="history-table">
                <thead>
                    <tr>
                        <th>日時</th><th>Q1</th><th>Q2</th><th>Q3</th><th>Q4</th><th>Q5</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="h" items="${history}">
                        <tr>
                            <td><fmt:formatDate value="${h.date}" pattern="yyyy/MM/dd HH:mm"/></td>
                            <td>${h.q1}</td>
							<td>${h.q2}</td>
							<td>${h.q3}</td>
							<td>${h.q4}</td>
							<td>${h.q5}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="no-data"><p>履歴データが見つかりませんでした。</p></div>
        </c:otherwise>
    </c:choose>

    <div class="btn-container">
        <a href="<%= request.getContextPath() %>/manager/manegement_manager.jsp" class="btn btn-blue">ユーザー管理システムに戻る</a>
    </div>
</div>
</body>
</html>