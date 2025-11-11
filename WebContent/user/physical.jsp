<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>フィジカルヘルス</title>
    <link rel="stylesheet" href="../css/physical.css">
</head>

<body>
    <h1>フィジカルヘルス</h1>
    <div class="feature-container">

        <!-- ストレッチ動画 -->
        <section class="feature feature-video">
            <h2>ストレッチ動画</h2>
            <p>首・肩・腰のストレッチ動画</p>
            <div class="video-placeholder">
                <p>ここにストレッチ動画プレイヤーが表示</p>
                <a href="${url}">動画</a>
                </div>
        </section>

        <!-- 目の休憩タイマー設定-->
        <section class="feature feature-timer-setting">
            <h2>目の休憩タイマー設定</h2>
            <form action="timer">
                <label for="eye_timer">タイマー設定 (分):</label>
                <input type="number" id="eye_timer" name="eye_timer" value="20" min="5">
                <button type="submit" class="submit-button1">決定</button>
            </form>
        </section>

        <!-- 目の休憩タイマー設定 -->
        <section class="feature feature-timer-display">
            <h2>目の休憩タイマー</h2>
            <p class="current-timer">残り時間: 20:00</p>
            <p class="timer-status"></p>
        </section>

        <!-- 休憩通知 -->
        <section class="feature feature-notification">
            <h2>休憩通知</h2>
            <p class="notification-text">⏰ 1時間ごとに「立って休憩しましょう」と通知されます</p>
        </section>

        <!-- 水分補給チェック -->
        <section class="feature feature-hydration">
            <h2>水分補給チェック</h2>
            <p class="prompt-text">💦 今日の水分補給目標：7回</p>
            <form class="hydration-form" action="/submit-hydration-data" method="post">
        <div class="hydration-input">
            <label for="drinks-count-select">1日の水分補給回数を選択:</label>
            <select id="drinks-count-select" name="drinks_count">
                <option value="0" selected>0回</option>
                <option value="1">1回</option>
                <option value="2">2回</option>
                <option value="3">3回</option>
                <option value="4">4回</option>
                <option value="5">5回</option>
                <option value="6">6回</option>
                <option value="7">7回(目標達成)</option>
                <option value="8">8回</option>
                <option value="8">9回</option>
                <option value="8">10回以上</option>
                </select>
        </div>
        <button type="submit" class="submit-button2">記録を送信</button>
    </form>
    </section>

        <!-- 休憩時間通知(参照) -->
        <section class="feature feature-break-info">
            <h2>休憩時間通知</h2>
            <p class="break-time-message">🍚 (例) 休憩時間: 12:00 ～ 13:00 (60分)です。</p>
            <p>※上司から指定された休憩時間が画面に通知されます</p>
        </section>
    </div>
</body>

<div class="menu-nav-section">
    <a href="menu.html" class="btn btn-secondary-light return-menu-btn">メニュー画面に戻る</a>
</div>

</html>