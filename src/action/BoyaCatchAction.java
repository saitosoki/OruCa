package action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.boyacatch;
import dao.BoyaCatchDaoimpl;

@WebServlet(urlPatterns={"/BoyaCatchAction"})
public class BoyaCatchAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String API_KEY = System.getenv("AI_API_KEY");
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	this.doPost(request, response);
//    	System.out.print(API_KEY);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//    	System.out.print(API_KEY);
        request.setCharacterEncoding("UTF-8");


        String userInput = request.getParameter("input");
        String aiReply = "AIとの通信エラーが発生しました。";

        Integer userId = (Integer) request.getSession().getAttribute("userNum");
        if (userId == null) {
            request.setAttribute("chatResult", "エラー: ログインユーザー情報がセッションに見つかりません。");
            request.getRequestDispatcher("/user/mental.jsp").forward(request, response);
            return;
        }

        if (userInput == null || userInput.trim().isEmpty()) {
            request.setAttribute("chatResult", "エラー: 入力内容がありません。");
            request.getRequestDispatcher("/user/mental.jsp").forward(request, response);
            return;
        }

        OutputStream os = null;
        BufferedReader br = null;
        HttpURLConnection connection = null;

        try {
            String escapedInput = userInput.replace("\"", "\\\"");

            String jsonPayload =
                "{"
                + "\"model\": \"gpt-3.5-turbo\","
                + "\"messages\": ["
                + "    {\"role\": \"system\", \"content\": \"あなたはユーザーのメンタルヘルスをサポートする優しいAIです。共感的な返事をしてください。\"},"
                + "    {\"role\": \"user\", \"content\": \"" + escapedInput + "\"}"
                + "],"
                + "\"max_tokens\": 500"
                + "}";

            URL url = new URL(API_URL);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setDoOutput(true); // リクエストボディを送信することを許可

            os = connection.getOutputStream();

            byte[] input = jsonPayload.getBytes("UTF-8");
            os.write(input, 0, input.length);
            os.flush();
            int statusCode = connection.getResponseCode();
            StringBuilder responseBuilder = new StringBuilder();

            if (statusCode < 400) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream(), "UTF-8"));
            }

            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                responseBuilder.append(responseLine.trim());
            }

            String responseBody = responseBuilder.toString();


            if (statusCode != 200) {
                System.err.println("APIエラーレスポンス: " + responseBody);
                aiReply = "AIサービスからの応答エラーです。ステータスコード: " + statusCode + "。詳細: " + responseBody;
            } else {

                aiReply = extractResponseText(responseBody);
            }

        } catch (Exception e) {
            e.printStackTrace();
            aiReply = "AIとの通信エラーが発生しました。（詳細: " + e.getMessage() + "）";
        } finally {
            // finallyブロックで明示的にストリームとコネクションを閉じる
            if (os != null) {
                try { os.close(); } catch (IOException e) { e.printStackTrace(); }
            }
            if (br != null) {
                try { br.close(); } catch (IOException e) { e.printStackTrace(); }
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        boyacatch entry = new boyacatch();
        entry.setInput(userInput);
        entry.setReply(aiReply);
        entry.setUserId(userId);
        entry.setDate(new Date(System.currentTimeMillis()));

        BoyaCatchDaoimpl dao = new BoyaCatchDaoimpl();
        boolean success = dao.insert(entry);
        if (success) {
            request.setAttribute("chatResult", "AIとの対話内容を正常に記録しました。");
        } else {
            request.setAttribute("chatResult", "対話内容の記録に失敗しました。データベース設定を確認してください。");
        }


        request.setAttribute("userInput", userInput);
        request.setAttribute("aiReply", aiReply);

        request.getRequestDispatcher("/user/mental.jsp").forward(request, response);
    }
    private String extractResponseText(String jsonResponse) {

        final String START_TAG = "\"content\":\"";

        int startIndex = jsonResponse.indexOf(START_TAG);

        if (startIndex == -1) {

            return "AIからの応答JSONにコンテンツが見つかりませんでした。生の応答: " + jsonResponse;
        }

        startIndex += START_TAG.length();

        int endIndex = startIndex;
        while (endIndex < jsonResponse.length()) {

            if (jsonResponse.charAt(endIndex) == '"' && jsonResponse.charAt(endIndex - 1) != '\\') {
                break;
            }
            endIndex++;
        }

        if (endIndex >= jsonResponse.length()) {
            return "AIからの応答解析中に終了マーカーが見つかりませんでした。";
        }

        try {

            String content = jsonResponse.substring(startIndex, endIndex);

            content = content.replace("\\n", "\n")
                             .replace("\\t", "\t")
                             .replace("\\\"", "\"")
                             .replace("\\\\", "\\");

            return content.trim();

        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("JSON文字列解析エラー: インデックスが範囲外です。");
            e.printStackTrace();
            return "AIからの応答解析中にエラーが発生しました。";

        }
    }
}





