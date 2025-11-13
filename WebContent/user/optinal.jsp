<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>環境最適化</title>
    <link rel="stylesheet" href="../css/optimal.css">
</head>
<body>

    <h1>環境最適化</h1>

    <!-- 環境最適化 -->

    <div class="container">
        <section class="setting-block orange">
            <h2 class="setting-title">部屋の温度設定</h2>
            <form id="temperature-form">
                <div class="input-group">
                    <label for="temperature-input">温度（℃）</label>
                    <input type="number" id="temperature-input" name="temperature" placeholder="現在の部屋温度を入力..." min="15" max="30" required>
                </div>
                <button type="submit" class="submit-button">温度を送信</button>
            </form>
        </section>

        <!-- 明るさ設定 -->

        <section class="setting-block green">
            <h2 class="setting-title">部屋の明るさ設定</h2>
            <form id="brightness-form">
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
</body>


<div class="menu-nav-section">
    <a href="menu.html" class="btn btn-secondary-light return-menu-btn">メニュー画面に戻る</a>
</div>


</html>