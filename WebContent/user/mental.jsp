<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 1. 両方のクラスをインポートする --%>
<%@ page import="action.LoginAction" %>
<%@ page import="bean.Manegement_manager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>メンタルヘルス</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mental.css">

</head>

<body>
    <h1>メンタルヘルス</h1>
    <main class="container">
        <%

            Object loginObj = session.getAttribute("user");
            String userName = "ゲスト";

            if (loginObj instanceof LoginAction) {
                userName = ((LoginAction) loginObj).getName();
            } else if (loginObj instanceof Manegement_manager) {
                userName = ((Manegement_manager) loginObj).getName();
            }
        %>
        <p style="text-align: right; padding: 10px;">ログイン中：<strong><%= userName %></strong> 様</p>
    </main>

    <div class="check-card full-width">
        <h3 class="card-title accent-color">メンタルチェック（感情スコア記録）</h3>
        <p class="card-subtitle">朝・昼・終業時に簡単な感情を記録しましょう。</p>

        <%-- 保存成功・失敗のメッセージ表示 --%>
        <% if ("1".equals(request.getParameter("success"))) { %>
            <p style="color: blue; font-weight: bold; text-align: center;">感情を記録しました！</p>
        <% } else if ("1".equals(request.getParameter("error"))) { %>
            <p style="color: red; font-weight: bold; text-align: center;">保存に失敗しました。管理者へ連絡してください。</p>
        <% } %>

        <form class="survey-form" id="mental-check-form" action="<%=request.getContextPath() %>/MentalCheckAction" method="post">
            <div class="question-group flat-group">
                <p class="question-title">Q1. 今の気分に最も近いものは？</p>
                <div class="radio-options">
                    <label><input type="radio" name="e1" value="happy"> 非常に良い</label>
                    <label><input type="radio" name="e1" value="good"> 良い</label>
                    <label><input type="radio" name="e1" value="neutral"> 普通</label>
                    <label><input type="radio" name="e1" value="bad"> 悪い</label>
                    <label><input type="radio" name="e1" value="terrible"> 非常に悪い</label>
                </div>
            </div>

            <div class="question-group flat-group">
                <p class="question-title">Q2. 活力やエネルギーが満ちていると感じますか？</p>
                <div class="radio-options">
                    <label><input type="radio" name="e2" value="high"> とてもそう思う</label>
                    <label><input type="radio" name="e2" value="some"> ややそう思う</label>
                    <label><input type="radio" name="e2" value="neutral"> どちらでもない</label>
                    <label><input type="radio" name="e2" value="low"> あまりそう思わない</label>
                    <label><input type="radio" name="e2" value="none"> 全くそう思わない</label>
                </div>
            </div>
            <div class="question-group flat-group">
                <p class="question-title">Q3. 周りの人とのコミュニケーションを楽しんでいますか？</p>
                <div class="radio-options">
                    <label><input type="radio" name="e3" value="high"> とてもそう思う</label>
                    <label><input type="radio" name="e3" value="some"> ややそう思う</label>
                    <label><input type="radio" name="e3" value="neutral"> どちらでもない</label>
                    <label><input type="radio" name="e3" value="low"> あまりそう思わない</label>
                    <label><input type="radio" name="e3" value="none"> 全くそう思わない</label>
                </div>
            </div>
            <div class="question-group flat-group">
                <p class="question-title">Q4. 今日の仕事や活動に意欲を持って取り組めましたか？</p>
                <div class="radio-options">
                    <label><input type="radio" name="e4" value="high"> とてもそう思う</label>
                    <label><input type="radio" name="e4" value="some"> ややそう思う</label>
                    <label><input type="radio" name="e4" value="neutral"> どちらでもない</label>
                    <label><input type="radio" name="e4" value="low"> あまりそう思わない</label>
                    <label><input type="radio" name="e4" value="none"> 全くそう思わない</label>
                </div>
            </div>
            <div class="question-group flat-group">
                <p class="question-title">Q5. 身体的な疲れを感じていますか？</p>
                <div class="radio-options">
                    <label><input type="radio" name="e5" value="none"> 全く感じない</label>
                    <label><input type="radio" name="e5" value="low"> あまり感じない</label>
                    <label><input type="radio" name="e5" value="neutral"> どちらでもない</label>
                    <label><input type="radio" name="e5" value="some"> やや感じる</label>
                    <label><input type="radio" name="e5" value="high"> とても感じる</label>
                </div>
            </div>
            <button type="submit" class="btn btn-full-width btn-primary">感情を記録</button>
        </form>
    </div>
    <div class="menu-nav-section">
        <a href="menu.jsp" class="btn btn-secondary-light return-menu-btn">メニュー画面に戻る</a>
    </div>

</body>
</html>