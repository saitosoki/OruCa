<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/physical.css">
</head>

<body>
    <h1>フィジカルヘルス</h1>
    <div class="feature-container">

<!-- ======================= ストレッチ動画 ============================== -->

<section class="feature feature-video">
    <h2>ストレッチ動画</h2>
    <p>ストレッチ動画をランダムで表示してます。</p>

    <div class="video-placeholder" style="background-color: transparent;">
        <div class="video-item" style="text-align: center;">
            <script>

                const videoData = [
                	{ url: "https://youtu.be/SjmZGTU9tPM", num: 1 },
                    { url: "https://www.youtube.com/watch?v=bzGMeDoGpeA", num: 2 },
                    { url: "https://youtu.be/-aDbF7Wm6gc", num: 3 }
                ];

                // 2. ランダムに1つ選択
                const selectedVideo = videoData[Math.floor(Math.random() * videoData.length)];

                // 3. 埋め込み用URLに変換
                let embedUrl = "";
                if (selectedVideo.url.includes("youtube.com/watch?v=")) {
                    embedUrl = selectedVideo.url.replace("watch?v=", "embed/");
                } else if (selectedVideo.url.includes("youtu.be/")) {
                    const videoId = selectedVideo.url.split("youtu.be/")[1].split("?")[0];
                    embedUrl = "https://www.youtube.com/embed/" + videoId;
                }
            </script>

            <p style="margin-bottom: 15px; font-weight: bold; font-size: 1.1em;">
                ストレッチ番号 <span id="video-no-display"></span> を表示
            </p>

            <div id="video-container" style="position: relative; padding-bottom: 56.25%; height: 0; overflow: hidden; border-radius: 12px; border: 1px solid #ddd; background: #000;">
                </div>

            <div style="margin-top: 15px;">
                <p style="font-size: 0.85em; color: #666; margin-bottom: 5px;">※動画が再生できない場合はこちら↓↓↓</p>
                <a id="direct-link" href="#" target="_blank" class="submit-button2" style="display: inline-block; width: auto; padding: 8px 20px; text-decoration: none; font-size: 0.9em;">
                    YouTubeサイトで見る
                </a>
            </div>

            <script>
                document.getElementById('video-no-display').innerText = selectedVideo.num;
                document.getElementById('direct-link').href = selectedVideo.url;

                if (embedUrl) {
                    const iframe = document.createElement('iframe');
                    iframe.src = embedUrl + "?rel=0";
                    iframe.style = "position: absolute; top: 0; left: 0; width: 100%; height: 100%; border:0;";
                    iframe.allow = "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture";
                    iframe.allowFullscreen = true;
                    document.getElementById('video-container').appendChild(iframe);
                }
            </script>
        </div>
    </div>
</section>


<!-- ======================= 目の休憩タイマー設定.表示 ======================= -->
<section class="feature feature-timer-setting">
    <h2>目の休憩タイマー設定</h2>
    <form id="timer_setting_form" action="physical.jsp" method="post">
        <label for="eye_timer">タイマー設定 (分):</label>
        <input type="number" id="eye_timer" name="eye_timer" value="<%= initialMinutes %>" min="5">
        <button type="submit" class="submit-button1">決定</button>
    </form>
</section>

<section class="feature feature-timer-display">
    <h2>目の休憩タイマー</h2>
    <p class="current-timer" id="eyeCountdownDisplay">残り時間: 30:00</p>
</section>



<script>
    let eyeTotalSeconds = <%= initialSeconds %>;
    const eyeDisplay = document.getElementById('eyeCountdownDisplay');
    let eyeTimerInterval;

    function formatEyeTime(seconds) {
        if (seconds < 0) seconds = 0;
        const minutes = Math.floor(seconds / 60);
        const remainingSeconds = seconds % 60;
        return String(minutes).padStart(2, '0') + ":" + String(remainingSeconds).padStart(2, '0');
    }

    function updateEyeTimer() {
        if (eyeTotalSeconds < 0) {
            clearInterval(eyeTimerInterval);
            eyeDisplay.innerHTML = "お疲れ様!! 目を休ませてね";
            alert("目を休憩してください");
            return;
        }
        eyeDisplay.innerHTML = "残り時間: " + formatEyeTime(eyeTotalSeconds);
        eyeTotalSeconds--;
    }

    document.getElementById('timer_setting_form').addEventListener('submit', function(event) {
        event.preventDefault();
        const minutesInput = document.getElementById('eye_timer');
        const newMinutes = parseInt(minutesInput.value, 10);

        if (!isNaN(newMinutes) && newMinutes >= 5) {
            eyeTotalSeconds = newMinutes * 60;
            if (eyeTimerInterval) clearInterval(eyeTimerInterval);
            updateEyeTimer();
            eyeTimerInterval = setInterval(updateEyeTimer, 1000);
        } else {
            eyeDisplay.innerHTML = "残り時間: 設定が無効です";
        }
    });
</script>


<!-- ======================= 休憩通知(一時間ごとの) =================================== -->
<section class="feature feature-notification">
    <h2>休憩通知</h2>
    <p class="notification-text" id="standUpNotificationStatus">一時間おきの休憩タイマー</p>

    <div id="standUpCountdownArea" class="small-timer">次まで: --:--</div>

    <div class="button-group">
        <button id="startStandUpBtn" class="submit-button2 mini-btn">開始</button>
		<button id="stopStandUpBtn" class="submit-button1 mini-btn" disabled>停止</button>
		<button id="resetStandUpBtn" class="reset-button mini-btn">リセット</button>
    </div>
</section>

<script>
    const STAND_UP_MS = 1000 * 60 * 60; // 1時間
    let standUpIntervalId = null;
    let standUpRemaining = 0;

    const suStartBtn = document.getElementById('startStandUpBtn');
    const suStopBtn = document.getElementById('stopStandUpBtn');
    const suResetBtn = document.getElementById('resetStandUpBtn');
    const suStatus = document.getElementById('standUpNotificationStatus');
    const suTimerDisplay = document.getElementById('standUpCountdownArea');

    function updateSuDisplay() {
        const mins = Math.floor(standUpRemaining / 60);
        const secs = standUpRemaining % 60;
        suTimerDisplay.textContent = "次まで: " + String(mins).padStart(2, '0') + ":" + String(secs).padStart(2, '0');
    }

    suStartBtn.addEventListener('click', function() {
        if (standUpIntervalId === null) {
            standUpRemaining = STAND_UP_MS / 1000;
            updateSuDisplay();
            suStatus.textContent = "通知実行中";
            suStartBtn.disabled = true;
            suStopBtn.disabled = false;

            standUpIntervalId = setInterval(function() {
                standUpRemaining--;
                updateSuDisplay();
                if (standUpRemaining <= 0) {
                    alert("立って休憩しましょう！");
                    standUpRemaining = STAND_UP_MS / 1000;
                }
            }, 1000);
        }
    });

    suStopBtn.addEventListener('click', function() {
        clearInterval(standUpIntervalId);
        standUpIntervalId = null;
        suStatus.textContent = "実行停止中";
        suStartBtn.disabled = false;
        suStopBtn.disabled = true;
    });

    suResetBtn.addEventListener('click', function() {
        clearInterval(standUpIntervalId);
        standUpIntervalId = null;
        standUpRemaining = 0;
        suTimerDisplay.textContent = "次まで: --:--";
        suStatus.textContent = "一時間おきの休憩タイマー";
        suStartBtn.disabled = false;
        suStopBtn.disabled = true;
    });
</script>





<!-- ======================= 深呼吸ガイド =================================== -->
<div class="feature feature-breath-guide" id="breathPanel">
    <h2>深呼吸ガイド</h2>
    <div class="breath-canvas">
        <div id="breathCircle" class="breath-circle"></div>
        <p id="breathStatus" class="breath-text">リラックスしましょう</p>
    </div>
    <button type="button" id="breathBtn" class="submit-button2" onclick="toggleBreathing()">
        開始
    </button>
</div>
<script>
    let breathInterval;
    let breathCount = 0;
    const MAX_BREATHS = 3; // 深呼吸の回数設定

    function toggleBreathing() {
        const panel = document.getElementById('breathPanel');
        const btn = document.getElementById('breathBtn');
        const status = document.getElementById('breathStatus');

        if (!panel.classList.contains('active')) {
            // --- 開始処理 ---
            panel.classList.add('active');
            btn.innerText = "停止";
            btn.className = "submit-button1"; // 赤色
            breathCount = 0;

            startBreathingCycle(status);
        } else {
            // --- 手動停止処理 ---
            stopBreathing();
        }
    }

    //4-7-8呼吸法

    function startBreathingCycle(status) {
        // 4秒(吸う) + 7秒(止める) + 8秒(吐く) = 19秒サイクル
        const cycleTime = 19000;

        const runOneCycle = () => {
            if (breathCount >= MAX_BREATHS) {
                status.innerText = "終了しました！スッキリ！";
                clearInterval(breathInterval);
                setTimeout(stopBreathing, 2000);
                return;
            }

            breathCount++;
            const countDisplay = "(" + breathCount + "/" + MAX_BREATHS + ")";

            // 1. 吸う（4秒間）
            status.innerText = "鼻から吸って... (4秒) " + countDisplay;

            // 2. 止める（4秒後から7秒間）
            setTimeout(() => {
                if(document.getElementById('breathPanel').classList.contains('active')) {
                    status.innerText = "息を止めて... (7秒) " + countDisplay;
                }
            }, 4000);

            // 3. 吐く（11秒後から8秒間：4+7=11）
            setTimeout(() => {
                if(document.getElementById('breathPanel').classList.contains('active')) {
                    status.innerText = "口から吐き出して... (8秒) " + countDisplay;
                }
            }, 11000);
        };

        runOneCycle();
        breathInterval = setInterval(runOneCycle, cycleTime);
    }

    function stopBreathing() {
        const panel = document.getElementById('breathPanel');
        const btn = document.getElementById('breathBtn');
        const status = document.getElementById('breathStatus');

        clearInterval(breathInterval);
        panel.classList.remove('active');
        btn.innerText = "開始";
        btn.className = "submit-button2";

        if (breathCount < MAX_BREATHS) {
            status.innerText = "リラックスしましょう";
        }
    }
</script>

<!-- ======================= 水分補給チェック （保留）============================ -->
 <!--<section class="feature feature-hydration">
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
</section>>-->



<!-- ======================= 休憩時間通知 =======================（保留） -->

        <!--<section class="feature feature-break-info">
            <h2>休憩時間通知</h2>
            <p class="break-time-message">休憩時間: 12:00 ～ 13:00 (60分)です。</p>
            <p>※上司から指定された休憩時間が画面に通知されます</p>
        </section>
    </div>
</body>-->




</div> <div class="menu-nav-section" style="margin-top: 20px; text-align: center;">
    <a href="<%= request.getContextPath() %>/user/menu.jsp" class="btn btn-secondary-light return-menu-btn">メニュー画面に戻る</a>
</div>

</body>
</html>