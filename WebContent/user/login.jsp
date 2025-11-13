<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="../css/login.css">
<form name="login_form">

  <title>ログイン</title>
    <h1>OruCaログイン画面</h1>
    <p>ユーザID / パスワードをご入力の上、「ログイン」ボタンをクリックしてください。</p>

  <div>
    <input type="id" name="user_id" placeholder="ユーザーIDを入力してください"><br>
    <input type="password" name="password"placeholder="パスワードを入力してください">
  </div>
  <button type="submit">ログイン</button>
</form>