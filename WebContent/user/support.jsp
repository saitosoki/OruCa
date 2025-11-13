<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>集中サポート</title>
    <link rel="stylesheet" href="../css/support.css">
</head>
<body>
    <h1>集中サポート</h1>

    <main class="container">

        <!-- 今日の目標 -->

            <section class="card goal-card small-card">
                <h2 class="card-header orange-header">今日の目標</h2>
                <div class="card-content">
                    <p>今日の目標を入力</p>
                    <form action="/submit-daily-goal" method="post">
                        <div class="input-group">
                            <label for="today-goal">目標:</label>
                            <textarea id="today-goal" name="today_goal" rows="3" placeholder="今日の集中すべき目標を記入..." required></textarea>
                        </div>
                        <button type="submit" class="action-button">設定</button>
                    </form>
                </div>
            </section>
        </div>

        <!-- スケジューラーの管理 -->

        <div class="bottom-row">
            <section class="card scheduler-card full-width">
                <h2 class="card-header green-header">スケジューラーの管理</h2>
                <div class="card-content">
                    <p>カレンダーでスケジュール管理する</p>
                    <form action="/submit-schedule" method="post">
                        <div class="schedule-inputs-row">
                            <div class="input-group date-input">
                                <label for="schedule-date">日付:</label>
                                <input type="date" id="schedule-date" name="schedule_date" value="2025-10-22" required>
                            </div>
                            <div class="input-group detail-input">
                                <label for="schedule-detail">予定:</label>
                                <textarea id="schedule-detail" name="schedule_detail" rows="3" placeholder="会議やタスクの予定を記入..." required></textarea>
                            </div>
                        </div>
                        <button type="submit" class="action-button">予定を登録</button>
                    </form>
                </div>
            </section>
        </div>
    </main>


<div class="menu-nav-section">
    <a href="menu.html" class="btn btn-secondary-light return-menu-btn">メニュー画面に戻る</a>
</div>


</body>
</html>