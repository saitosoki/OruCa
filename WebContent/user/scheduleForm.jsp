<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>集中サポート</title>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f6fa;
            font-family: 'Yu Gothic', 'Meiryo', sans-serif;
        }
        h1 {
            color: #007bff;
            text-align: center;
            margin: 30px 0 20px;
            font-weight: bold;
        }
        .card {
            border-radius: 10px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
            margin-bottom: 30px;
        }
        .goal-card {
            border-top: 5px solid #ff7f32;
        }
        .schedule-card {
            border-top: 5px solid #28a745;
        }
        .btn-orange {
            background-color: #ff7f32;
            border: none;
        }
        .btn-orange:hover {
            background-color: #e76b1d;
        }
        .btn-green {
            background-color: #28a745;
            border: none;
        }
        .btn-green:hover {
            background-color: #1e7e34;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <h1>集中サポート</h1>

    <div class="container" style="max-width: 700px;">

        <!-- 今日の目標カード -->
        <div class="card goal-card p-4 bg-white">
            <h5 class="mb-3 fw-bold" style="color:#ff7f32;">今日の目標</h5>
            <form action="setGoal" method="post">
                <div class="mb-3">
                    <label class="form-label">目標を入力</label>
                    <textarea class="form-control" name="goal" rows="2" placeholder="今日の集中すべき目標を記入…"></textarea>
                </div>
                <button type="submit" class="btn btn-orange w-100">設定</button>
            </form>
        </div>

        <!-- スケジュール登録カード -->
        <div class="card schedule-card p-4 bg-white">
            <h5 class="mb-3 fw-bold" style="color:#28a745;">スケジューラーの管理</h5>
            <form action="schedule" method="post">
                <div class="mb-3">
                </div>
                <div class="mb-3">
                    <label class="form-label">日付</label>
                    <input type="date" class="form-control" name="date" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">予定</label>
                    <textarea class="form-control" name="comment" rows="2" placeholder="会議やタスクの予定を記入…"></textarea>
                </div>
                <button type="submit" class="btn btn-green w-100">予定を登録</button>
            </form>
        </div>

        <a href="menu.jsp" class="back-link">メニュー画面に戻る</a>
    </div>

</body>
</html>
