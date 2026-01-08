<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>環境最適化</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/optimal.css">
</head>
<body>

    <h1>環境最適化</h1>

    <!-- 温度設定 -->
<div class="container">
<section class="setting-block orange">
<h2 class="setting-title">部屋の温度設定</h2>

            <!-- ★ サーブレットに飛ばす -->
<form action="${pageContext.request.contextPath}/temperature" method="post">
<div class="input-group">
<label for="temperature-input">温度（℃）</label>
<input type="number" id="temperature-input" name="temperature"
                           placeholder="現在の部屋温度を入力..." min="15" max="30" required>
</div>
<button type="submit" class="submit-button">温度を送信</button>
</form>
</section>

        <!-- 明るさ設定 -->
<section class="setting-block green">
<h2 class="setting-title">部屋の明るさ設定</h2>

            <!-- ★ サーブレットに飛ばす -->
<form action="${pageContext.request.contextPath}/brightness" method="post">
<div class="brightness-options">
<label class="radio-label">
<input type="radio" name="brightness" value="low" required>
<span class="radio-text">暗い</span>
</label>
<label class="radio-label">
<input type="radio" name="brightness" value="medium">
<span class="radio-text">普通</span>
</label>
<label class="radio-label">
<input type="radio" name="brightness" value="high">
<span class="radio-text">明るい</span>
</label>
</div>
<button type="submit" class="submit-button">明るさを送信</button>
</form>
</section>
</div>

    <div class="menu-nav-section">
<a href="menu.jsp" class="btn btn-secondary-light return-menu-btn">メニュー画面に戻る</a>
</div>

</body>
</html>