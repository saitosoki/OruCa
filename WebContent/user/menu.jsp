<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>メニュー</title>
    <link rel="stylesheet" href="../css/menu.css">
</head>
<body>
    <div class="container">
        <div class="title-box">
            <h1>OruCaメニュー画面</h1>
        </div>
        <div class="subtitle-grid">
            <button type="submit" onclick="location.href='physical.jsp'" class="subtitle-box">フィジカルヘルス</button>
            <button type="submit" onclick="location.href='mental.jsp'" class="subtitle-box">メンタルヘルス</button>
            <button type="submit" onclick="location.href='scheduleForm.jsp'" class="subtitle-box">集中サポート</button>
            <button type="submit" onclick="location.href='optimal.jsp'" class="subtitle-box">環境最適化</button>
            <button type="submit" onclick="location.href='logout.jsp'" class="mini-subtitle-box">ログアウト</button>
            <button type="submit" onclick="location.href='manager_login.jsp'" class="mini-subtitle-box2">上司専用</button>
        </div>
    </div>
</body>
</html>