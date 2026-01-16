<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>マネージャーログアウト</title>
    <link rel="stylesheet" href="../css/logot_manager.css">
</head>
<body>
    <div class="logout-card">
        <svg class="logout-icon" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H5a3 3 0 01-3-3V7a3 3 0 013-3h5a3 3 0 013 3v1"></path>
        </svg>
        <h1>マネージャーログアウト完了</h1>
        <p>OruCaサービスからログアウトしました。
            <br>ご利用ありがとうございました。</p>
        <button type="button" onclick="location.href='login_manager.jsp'" class="return-button">ログイン画面へ戻る</button>
    </div>
</body>
</html>