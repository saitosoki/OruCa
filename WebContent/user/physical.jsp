<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<%

    String initialMinutesStr = request.getParameter("eye_timer");
    int initialMinutes = 30;

    if (initialMinutesStr != null && !initialMinutesStr.isEmpty()) {
        try {
            initialMinutes = Integer.parseInt(initialMinutesStr);
        } catch (NumberFormatException e) {
        }
    }

    int initialSeconds = initialMinutes * 60;
%>

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


<!-- ======================= ストレッチ動画 ============================== -->

        <section class="feature feature-video">
            <h2>ストレッチ動画</h2>
            <p>首・肩・腰のストレッチ動画</p>
            <div class="video-placeholder">
                <p>ここにストレッチ動画プレイヤーが表示</p>
                <a href="${url}">動画</a>
                </div>
        </section>


<!-- ======================= 目の休憩タイマー設定 ======================= -->

        <section class="feature feature-timer-setting">
        <h2>目の休憩タイマー設定</h2>
        <form id="timer_setting_form" action="physical.jsp" method="post">
            <label for="eye_timer">タイマー設定 (分):</label>
            <input type="number" id="eye_timer" name="eye_timer" value="<%= initialMinutes %>" min="5">
            <button type="submit" class="submit-button1">決定</button>
        </form>
    </section>

    <script>
        let interval = null;

        const countdown = document.getElementById('countdown');
        const timerForm = document.getElementById('timer_setting_form');
        const timerInput = document.getElementById('eye_timer');
        let targetTime = 0;

        function updateCountDown() {
            const now = new Date().getTime();
            const distance = targetTime - now;

            if (distance > 0) {
                const hours = Math.floor(distance / (1000 * 60 * 60));
                const minutes = Math.floor(distance % (1000 * 60 * 60) / (1000 * 60));
                const seconds = Math.floor(distance % (1000 * 60) / 1000);

                countdown.textContent = `${String(hours).padStart(2, '0')}:${String(minutes).padStart(2, '0')}:${String(seconds).padStart(2, '0')}`;
            } else {
                clearInterval(interval);
                countdown.textContent = "終了しました";
            }
        }

        function startTimer(minutes) {
            if (interval) {
                clearInterval(interval);
            }
            targetTime = new Date().getTime() + minutes * 60 * 1000;
            interval = setInterval(updateCountDown, 1000);
        }

        }
        countdown.textContent = "00:00:00";
    </script>



<!-- ======================= 目の休憩タイマー表示 ======================= -->

        <section class="feature feature-timer-display">
		    <h2>目の休憩タイマー</h2>
		    <p class="current-timer" id="countdownDisplay">残り時間: <%= String.format("%02d:00", initialMinutes) %></p>
	    </section>



<!-- ======================= 休憩通知(一時間ごとの) =================================== -->

    <section class="feature feature-notification">
	    <h2>休憩通知</h2>
	    <p class="notification-text" id="standUpNotificationStatus">一時間おきの休憩タイマー</p>

	    <button id="startStandUpNotificationBtn" class="submit-button1">休憩通知スタート</button>
	</section>

	<script>
	    // 1時間ごとの休憩通知設定
	    const STAND_UP_INTERVAL_DURATION = 60 * 60 * 1; // 3,600,000ミリ秒 = 1時間
	    const STAND_UP_MESSAGE = "立って休憩しましょう！";
	    let standUpAlertIntervalId = null; //

	    const startBtn = document.getElementById('startStandUpNotificationBtn');
	    const statusText = document.getElementById('standUpNotificationStatus');

	    function toggleStandUpNotification() {
	        if (standUpAlertIntervalId !== null) {
	            // 実行中停止処理
	            clearInterval(standUpAlertIntervalId);
	            standUpAlertIntervalId = null;

	            // UIの更新
	            startBtn.textContent = "通知設定を再開する";
	            statusText.textContent = "実行停止中";
	            startBtn.classList.remove('active'); // 必要であればデザインを切り替えるためのクラスを削除
	            console.log("休憩通知を停止しました。");

	        } else {
	            // 停止中の開始処理
	            // 1時間ごとにアラートを表示するタイマーを開始
	            standUpAlertIntervalId = setInterval(() => {
	                alert(STAND_UP_MESSAGE);
	            }, STAND_UP_INTERVAL_DURATION);

	            startBtn.textContent = "通知を停止する";
	            statusText.textContent = "通知実行中 (1時間ごと)";
	            startBtn.classList.add('active');

	            console.log(`1時間ごとの休憩通知を開始しました。Interval ID: ${standUpAlertIntervalId}`);
	        }
	    }

	    document.addEventListener('DOMContentLoaded', () => {
	        if (startBtn) {
	            startBtn.addEventListener('click', toggleStandUpNotification);


	            // 初期表示の状態
	            if (standUpAlertIntervalId === null) {
	                 startBtn.textContent = "休憩通知スタート";
	            }
	        }
	    });
	</script>


<!-- ======================= 水分補給チェック ============================ -->

        <section class="feature feature-hydration">
            <h2>水分補給チェック</h2>
            <p class="prompt-text">今日の水分補給目標：7回</p>
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
                <option value="9">9回</option>
                <option value="10">10回以上</option>
                </select>
        </div>
        <button type="submit" class="submit-button2">記録を送信</button>
  		 	</form>
        </section>



<!-- ======================= 休憩時間通知 ======================= -->

        <section class="feature feature-break-info">
            <h2>休憩時間通知</h2>
            <p class="break-time-message">休憩時間: 12:00 ～ 13:00 (60分)です。</p>
            <p>※上司から指定された休憩時間が画面に通知されます</p>
        </section>
    </div>
</body>

<!-- 目の休憩タイマー処理↓ -->

<script>
    let totalSeconds = <%= initialSeconds %>;

    const countdownDisplay = document.getElementById('countdownDisplay');
    let timerInterval;

    document.querySelectorAll('button').forEach(button => {
        button.disabled = false;
        button.style.cursor = 'pointer';
        button.style.opacity = '1.0';
    });
    function formatTime(seconds) {
        if (seconds < 0) seconds = 0;
        const minutes = Math.floor(seconds / 60);
        const remainingSeconds = seconds % 60;

        const formattedMinutes = String(minutes).padStart(2, '0');
        const formattedSeconds = String(remainingSeconds).padStart(2, '0');
        return `${formattedMinutes}:${formattedSeconds}`;
    }
    function updateTimer() {
        if (totalSeconds < 0) {
            clearInterval(timerInterval);
            countdownDisplay.innerHTML = "お疲れ様!! 目を休ませてね";

            alert("目を休憩してください");

            function a() {
            	  alert("今クリックしたよね？");
            	}

            return;
        }
        // タイマー表示を更新
        countdownDisplay.innerHTML = "残り時間: " + formatTime(totalSeconds);
        // 1秒減
        totalSeconds--;
    }
    function startTimer() {
        if (timerInterval) {
            clearInterval(timerInterval);
        }
        updateTimer();
        timerInterval = setInterval(updateTimer, 1000);
    }
    countdownDisplay.innerHTML = "残り時間: " + formatTime(totalSeconds);
    document.getElementById('timer_setting_form').addEventListener('submit', function(event) {
        event.preventDefault();

        const minutesInput = document.getElementById('eye_timer');
        const newMinutes = parseInt(minutesInput.value, 10);

        if (!isNaN(newMinutes) && newMinutes >= 5) {
            totalSeconds = newMinutes * 60;
            countdownDisplay.innerHTML = "残り時間: " + formatTime(totalSeconds);
            startTimer();
        } else {
            countdownDisplay.innerHTML = "残り時間: 設定が無効です";
        }
    });

</script>

<div class="menu-nav-section">
    <a href="menu.jsp" class="btn btn-secondary-light return-menu-btn">メニュー画面に戻る</a>
</div>

</html>