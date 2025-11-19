<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>メンタルヘルス</title>
    <link rel="stylesheet" href="../css/mental.css">
</head>

<body>
    <h1>メンタルヘルス</h1>
    <main class="container">

        <!-- ======================= メンタルヘルスセクション ======================= -->

        <h3 class="card-title accent-color">ぼやキャッチAI</h3>

        <!-- AI対話インターフェース -->
        <div class="card full-width ai-interface-card">
            <p class="card-subtitle">AIに悩みや気持ちを吐き出して感情を整理する</p>

            <div class="chat-log-placeholder">
                <div class="chat-message ai">🤖: こんにちは。何かお話ししたいことはありますか？</div>
                <div class="chat-message user">User: (例)今日は仕事でたくさんミスをしてしまった...</div>
            </div>

            <textarea id="user-input" rows="3" placeholder="AIとの対話内容を入力してください..."></textarea>
            <button type="submit" class="btn btn-full-width btn-primary">送信</button>

            <p class="note mt-20">※AIとの対話内容は記録・保存され、ログは自分にしか見られないようになっています。</p>
        </div>

        <!-- メンタル・ストレスチェック (質問を5問に増加) -->

        <!-- メンタルチェック（アンケート） -->
        <div class="check-card full-width">
            <h3 class="card-title accent-color">メンタルチェック（感情スコア記録）</h3>
            <p class="card-subtitle">朝・昼・終業時に簡単な感情を記録しましょう。</p>
            <form class="survey-form" id="mental-check-form">
                <div class="question-group flat-group">
                    <p class="question-title">Q1. 今の気分に最も近いものは？</p>
                    <div class="radio-options">
                        <label><input type="radio" name="e1" value="happy"> 非常に良い</label>
                        <label><input type="radio" name="e1" value="good"> 良い</label>
                        <label><input type="radio" name="e1" value="neutral"> 普通</label>
                        <label><input type="radio" name="e1" value="bad"> 悪い</label>
                        <label><input type="radio" name="e1" value="terrible"> 非常に悪い</label>
                    </div>
                </div>

                <div class="question-group flat-group">
                    <p class="question-title">Q2. 活力やエネルギーが満ちていると感じますか？</p>
                    <div class="radio-options">
                        <label><input type="radio" name="e2" value="high"> とてもそう思う</label>
                        <label><input type="radio" name="e2" value="some"> ややそう思う</label>
                        <label><input type="radio" name="e2" value="neutral"> どちらでもない</label>
                        <label><input type="radio" name="e2" value="low"> あまりそう思わない</label>
                        <label><input type="radio" name="e2" value="none"> 全くそう思わない</label>
                    </div>
                </div>
                <div class="question-group flat-group">
                    <p class="question-title">Q3. 周りの人とのコミュニケーションを楽しんでいますか？</p>
                    <div class="radio-options">
                        <label><input type="radio" name="e3" value="high"> とてもそう思う</label>
                        <label><input type="radio" name="e3" value="some"> ややそう思う</label>
                        <label><input type="radio" name="e3" value="neutral"> どちらでもない</label>
                        <label><input type="radio" name="e3" value="low"> あまりそう思わない</label>
                        <label><input type="radio" name="e3" value="none"> 全くそう思わない</label>
                    </div>
                </div>
                <div class="question-group flat-group">
                    <p class="question-title">Q4. 今日の仕事や活動に意欲を持って取り組めましたか？</p>
                    <div class="radio-options">
                        <label><input type="radio" name="e4" value="high"> とてもそう思う</label>
                        <label><input type="radio" name="e4" value="some"> ややそう思う</label>
                        <label><input type="radio" name="e4" value="neutral"> どちらでもない</label>
                        <label><input type="radio" name="e4" value="low"> あまりそう思わない</label>
                        <label><input type="radio" name="e4" value="none"> 全くそう思わない</label>
                    </div>
                </div>
                <div class="question-group flat-group">
                    <p class="question-title">Q5. 身体的な疲れを感じていますか？</p>
                    <div class="radio-options">
                        <label><input type="radio" name="e5" value="none"> 全く感じない</label>
                        <label><input type="radio" name="e5" value="low"> あまり感じない</label>
                        <label><input type="radio" name="e5" value="neutral"> どちらでもない</label>
                        <label><input type="radio" name="e5" value="some"> やや感じる</label>
                        <label><input type="radio" name="e5" value="high"> とても感じる</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-full-width btn-primary">感情を記録</button>
            </form>
        </div>

        <!-- ストレス度チェック（アンケート） -->
        <div class="check-card full-width">
            <h3 class="card-title accent-color">ストレス度チェック（週間実施）</h3>
            <p class="card-subtitle">簡単な質問でストレス度をチェックしましょう。</p>
            <form class="survey-form" id="stress-check-form">
                <div class="question-group flat-group">
                    <p class="question-title">Q1. この1週間、気分が落ち込むことがありましたか？</p>
                    <div class="radio-options">
                        <label><input type="radio" name="q1" value="no"> 全くなかった</label>
                        <label><input type="radio" name="q1" value="sometimes"> たまにあった</label>
                        <label><input type="radio" name="q1" value="often"> しばしばあった</label>
                        <label><input type="radio" name="q1" value="always"> いつもそうだった</label>
                    </div>
                </div>
                <div class="question-group flat-group">
                    <p class="question-title">Q2. この1週間、物事に集中できないと感じましたか？</p>
                    <div class="radio-options">
                        <label><input type="radio" name="q2" value="no"> 全くなかった</label>
                        <label><input type="radio" name="q2" value="sometimes"> たまにあった</label>
                        <label><input type="radio" name="q2" value="often"> しばしばあった</label>
                        <label><input type="radio" name="q2" value="always"> いつもそうだった</label>
                    </div>
                </div>
                <div class="question-group flat-group">
                    <p class="question-title">Q3. この1週間、夜にぐっすり眠れないことがありましたか？</p>
                    <div class="radio-options">
                        <label><input type="radio" name="q3" value="no"> 全くなかった</label>
                        <label><input type="radio" name="q3" value="sometimes"> たまにあった</label>
                        <label><input type="radio" name="q3" value="often"> しばしばあった</label>
                        <label><input type="radio" name="q3" value="always"> いつもそうだった</label>
                    </div>
                </div>
                <div class="question-group flat-group">
                    <p class="question-title">Q4. この1週間、小さなことでイライラしたり、腹を立てることがありましたか？</p>
                    <div class="radio-options">
                        <label><input type="radio" name="q4" value="no"> 全くなかった</label>
                        <label><input type="radio" name="q4" value="sometimes"> たまにあった</label>
                        <label><input type="radio" name="q4" value="often"> しばしばあった</label>
                        <label><input type="radio" name="q4" value="always"> いつもそうだった</label>
                    </div>
                </div>
                <div class="question-group flat-group">
                    <p class="question-title">Q5. この1週間、仕事や生活に「やりがい」を感じていますか？</p>
                    <div class="radio-options">
                        <label><input type="radio" name="q5" value="always"> いつも感じている</label>
                        <label><input type="radio" name="q5" value="often"> しばしば感じている</label>
                        <label><input type="radio" name="q5" value="sometimes"> たまに感じる</label>
                        <label><input type="radio" name="q5" value="no"> 全く感じていない</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-full-width btn-record">ストレス度を判定</button>
            </form>
        </div>

    </main>
</body>

<div class="menu-nav-section">
    <a href="menu.jsp" class="btn btn-secondary-light return-menu-btn">メニュー画面に戻る</a>
</div>

</html>
