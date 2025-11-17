<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>マネージャー管理</title>
    <link rel="stylesheet" href="../css/management_manager.css">
</head>
<body>

    <h1>マネージャー管理</h1>

    <!-- 管理対象の部下を選択画面 -->
    <section id="subordinate-selection" class="card">
        <h2>管理対象の部下を選択</h2>
        <form id="select-subordinate-form">

            <div class="form-group">
            <label for="department-select">部署を選んでください:</label>
            <select id="department-select" name="department">
                <option value="" disabled selected>(例)開発部</option>
                <option value="sales">(例)営業部</option>
                <option value="hr">(例)人事部</option>
            </select>

            <div class="form-group">
                <label for="subordinate-user">部下を選んでください:</label>
                <select id="subordinate-user" required>
                    <option value="">------</option>
                    <option value="user-a" selected>(例)部下A</option>
                    <option value="user-b">(例)部下B</option>
                    <option value="user-c">(例)部下C</option>
                    </select>
            </div>
            </form>
        <p class="selected-info">(例)現在、部下Aさんの情報を表示・操作しています。</p>
    </section>
    <main>

    <!-- 憩を促す時間設定 -->
        <section id="break-setting" class="card">
            <h2>部下に休憩を促す時間設定</h2>
            <p class="description">※この設定は**現在選択中の部下**に適用されます。</p>
            <form>
                <div class="form-group">
                    <label for="break-time">休憩時間を選択:</label>
                    <select id="break-time" required>
                        <option value="">------</option>
                        <option value="5分">5分</option>
                        <option value="10分">10分</option>
                        <option value="15分">15分</option>
                        <option value="20分">20分</option>
                        <option value="25分">25分</option>
                        <option value="30分">30分</option>
                        <option value="35分">35分</option>
                        <option value="40分">40分</option>
                        <option value="45分">45分</option>
                        <option value="50分">50分</option>
                        <option value="55分">55分</option>
                        <option value="60分">60分</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="comment">コメント:</label>
                    <textarea id="comment" rows="3"></textarea>
                </div>
                <button type="submit" class="submit-btn">休憩時間とコメントを送信</button>
            </form>
        </section>

        <!-- スコアチェック1 -->

        <div class="flex-container">
            <section id="mental-checkin" class="card checkin-card">
                <h2>部下のメンタル状態</h2>
                <div class="score-display">
                    <p class="score-label">現在のメンタルスコア:</p>
                    <p class="score-value">75<span class="percentage">%</span></p>
                </div>
                <p class="source-info">※アンケートの結果によるメンタルの現状スコア</p>
                <div class="status-indicator good">安定</div>
            </section>

            <!-- スコアチェック2 -->

            <section id="stress-checkin" class="card checkin-card">
                <h2>部下のストレス度</h2>
                <div class="score-display">
                    <p class="score-label">現在のストレス度スコア:</p>
                    <p class="score-value low-stress">28<span class="percentage">%</span></p>
                </div>
                <p class="source-info">※アンケートの結果によるメンタルの現状スコア</p>
                <div class="status-indicator">低ストレス</div>
            </section>
        </div>

        <!-- スケジューラーの管理 -->

        <section id="scheduler-management" class="card green-card">
        <h2>スケジューラーの管理</h2>
        <div class="card-content">
        <p class="description">**選択中の部下**がカレンダーに書き込んだタスクや予定を参照できます。</p>

        <div class="schedule-view">

            <h3>選択している部下の部署と名前を表示</h3>
            <div class="schedule-filter">
                <label for="schedule-date-a">表示日付:</label>
                <input type="date" id="schedule-date-a" value="2025-10-22">
                <button class="filter-btn">日付を適用</button>
            </div>

            <ul class="task-list">
                <li class="task-item">プロジェクトXの仕様書レビュー</li>
                <li class="task-item">開発チーム定例会議</li>
                <li class="task-item">顧客向け提案資料作成</li>
            </ul>
            </div>
        </div>
        </section>
    </main>
</body>

<div class="menu-nav-section">
    <a href="manager_logout.html" class="btn btn-secondary-light return-menu-btn">マネージャー管理画面をログアウトする</a>
</div>
</html>