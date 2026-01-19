<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="action.LoginAction" %>
<%@ page import="bean.Manegement_manager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>メンタルヘルス</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/mental.css">
<style>
    /* メッセージの視認性を高めるためのスタイル追加 */
    .message-box {
        padding: 10px;
        margin-bottom: 15px;
        border-radius: 5px;
        text-align: center;
        font-weight: bold;
    }
    .success-msg { background-color: #e7f3ff; color: #004085; border: 1px solid #b8daff; }
    .error-msg { background-color: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; }
</style>
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


    <div class="check-card full-width" id="mental-section">
        <h3 class="card-title accent-color">メンタルチェック</h3>
        <p class="card-subtitle">現在の感情を記録しましょう。</p>

        <%-- MentalCheckActionからのリダイレクト時のみ表示 --%>
        <% if ("1".equals(request.getParameter("success")) && request.getParameter("type") == null) { %>
            <div class="message-box success-msg">感情を記録しました！</div>
        <% } else if ("1".equals(request.getParameter("error")) && request.getParameter("type") == null) { %>
            <div class="message-box error-msg">保存に失敗しました。管理者へ連絡してください。</div>
        <% } %>

        <form class="survey-form" id="mental-check-form" action="<%=request.getContextPath() %>/MentalCheckAction" method="post">
            <div class="question-group flat-group">
                <p class="question-title">Q1. 今の気分に最も近いものは？</p>
                <div class="radio-options">
                    <label><input type="radio" name="e1" value="happy" required> 非常に良い</label>
                    <label><input type="radio" name="e1" value="good"> 良い</label>
                    <label><input type="radio" name="e1" value="neutral"> 普通</label>
                    <label><input type="radio" name="e1" value="bad"> 悪い</label>
                    <label><input type="radio" name="e1" value="terrible"> 非常に悪い</label>
                </div>
            </div>

            <div class="question-group flat-group">
                <p class="question-title">Q2. 活力やエネルギーが満ちていると感じますか？</p>
                <div class="radio-options">
                    <label><input type="radio" name="e2" value="high" required> とてもそう思う</label>
                    <label><input type="radio" name="e2" value="some"> ややそう思う</label>
                    <label><input type="radio" name="e2" value="neutral"> どちらでもない</label>
                    <label><input type="radio" name="e2" value="low"> あまりそう思わない</label>
                    <label><input type="radio" name="e2" value="none"> 全くそう思わない</label>
                </div>
            </div>

            <div class="question-group flat-group">
                <p class="question-title">Q3. 周りの人とのコミュニケーションを楽しんでいますか？</p>
                <div class="radio-options">
                    <label><input type="radio" name="e3" value="high" required> とてもそう思う</label>
                    <label><input type="radio" name="e3" value="some"> ややそう思う</label>
                    <label><input type="radio" name="e3" value="neutral"> どちらでもない</label>
                    <label><input type="radio" name="e3" value="low"> あまりそう思わない</label>
                    <label><input type="radio" name="e3" value="none"> 全くそう思わない</label>
                </div>
            </div>

            <div class="question-group flat-group">
                <p class="question-title">Q4. 今日の仕事や活動に意欲を持って取り組めましたか？</p>
                <div class="radio-options">
                    <label><input type="radio" name="e4" value="high" required> とてもそう思う</label>
                    <label><input type="radio" name="e4" value="some"> ややそう思う</label>
                    <label><input type="radio" name="e4" value="neutral"> どちらでもない</label>
                    <label><input type="radio" name="e4" value="low"> あまりそう思わない</label>
                    <label><input type="radio" name="e4" value="none"> 全くそう思わない</label>
                </div>
            </div>

            <div class="question-group flat-group">
                <p class="question-title">Q5. 身体的な疲れを感じていますか？</p>
                <div class="radio-options">
                    <label><input type="radio" name="e5" value="none" required> 全く感じない</label>
                    <label><input type="radio" name="e5" value="low"> あまり感じない</label>
                    <label><input type="radio" name="e5" value="neutral"> どちらでもない</label>
                    <label><input type="radio" name="e5" value="some"> やや感じる</label>
                    <label><input type="radio" name="e5" value="high"> とても感じる</label>
                </div>
            </div>
            <button type="submit" class="btn btn-full-width btn-primary">感情を記録</button>
        </form>
    </div>




    <div class="check-card full-width" id="stress-section">
        <h3 class="card-title accent-color">ストレス度チェック</h3>
        <p class="card-subtitle">簡単な質問でストレス度をチェックしましょう。</p>

        <%-- StressCheckActionからのリダイレクト時のみ表示 --%>
        <% if ("1".equals(request.getParameter("success")) && "stress".equals(request.getParameter("type"))) { %>
            <div class="message-box success-msg">ストレスチェックを記録しました！</div>
        <% } else if ("1".equals(request.getParameter("error")) && "stress".equals(request.getParameter("type"))) { %>
            <div class="message-box error-msg">保存に失敗しました。</div>
        <% } %>

        <form class="survey-form" id="stress-check-form" action="<%=request.getContextPath() %>/StressCheckAction" method="post">
            <div class="question-group flat-group">
                <p class="question-title">Q1. この1週間、気分が落ち込むことがありましたか？</p>
                <div class="radio-options">
                    <label><input type="radio" name="q1" value="no" required> 全くなかった</label>
                    <label><input type="radio" name="q1" value="sometimes"> たまにあった</label>
                    <label><input type="radio" name="q1" value="often"> しばしばあった</label>
                    <label><input type="radio" name="q1" value="always"> いつもそうだった</label>
                </div>
            </div>

            <div class="question-group flat-group">
                <p class="question-title">Q2. この1週間、物事に集中できないと感じましたか？</p>
                <div class="radio-options">
                    <label><input type="radio" name="q2" value="no" required> 全くなかった</label>
                    <label><input type="radio" name="q2" value="sometimes"> たまにあった</label>
                    <label><input type="radio" name="q2" value="often"> しばしばあった</label>
                    <label><input type="radio" name="q2" value="always"> いつもそうだった</label>
                </div>
            </div>

            <div class="question-group flat-group">
                <p class="question-title">Q3. この1週間、夜にぐっすり眠れないことがありましたか？</p>
                <div class="radio-options">
                    <label><input type="radio" name="q3" value="no" required> 全くなかった</label>
                    <label><input type="radio" name="q3" value="sometimes"> たまにあった</label>
                    <label><input type="radio" name="q3" value="often"> しばしばあった</label>
                    <label><input type="radio" name="q3" value="always"> いつもそうだった</label>
                </div>
            </div>

            <div class="question-group flat-group">
                <p class="question-title">Q4. この1週間、小さなことでイライラしたり、腹を立てることがありましたか？</p>
                <div class="radio-options">
                    <label><input type="radio" name="q4" value="no" required> 全くなかった</label>
                    <label><input type="radio" name="q4" value="sometimes"> たまにあった</label>
                    <label><input type="radio" name="q4" value="often"> しばしばあった</label>
                    <label><input type="radio" name="q4" value="always"> いつもそうだった</label>
                </div>
            </div>

            <div class="question-group flat-group">
                <p class="question-title">Q5. この1週間、仕事や生活に「やりがい」を感じていますか？</p>
                <div class="radio-options">
                    <label><input type="radio" name="q5" value="always" required> いつも感じている</label>
                    <label><input type="radio" name="q5" value="often"> しばしば感じている</label>
                    <label><input type="radio" name="q5" value="sometimes"> たまに感じる</label>
                    <label><input type="radio" name="q5" value="no"> 全く感じていない</label>
                </div>
            </div>

            <button type="submit" class="btn btn-full-width btn-record">ストレス度を判定</button>
        </form>
    </div>

    <div class="menu-nav-section">
        <a href="menu.jsp" class="btn btn-secondary-light return-menu-btn">メニュー画面に戻る</a>
    </div>

</body>
</html>