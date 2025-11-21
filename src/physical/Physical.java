//1.DAOから動画のURLを取得する


		//2.取得したURLをjspに埋め込む


		//3.jspを表示する

package physical;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StretchVideo;
import dao.StretchVideoDao;

@WebServlet("/stretchVideo")
public class Physical extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StretchVideoDao dao = new StretchVideoDao();

    // --- GET：一覧表示 ---
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<StretchVideo> list = dao.findAll();


        /*
         * 1.list変数からランダムに1つ選ぶ。
         */
        int index = ThreadLocalRandom.current().nextInt(list.size());
        StretchVideo pick = list.get(index);

        /*
         * 2.選んだbeanのデータをvideoUrlとvideoNoに格納する
         */

    	request.setAttribute("videoUrl", pick.getVideoUrl());
        request.setAttribute("videoNo", pick.getStretchNum());

        /********
         * sample
        // JSPにデータを渡す
    	String url="https://www.bing.com/videos/riverview/relatedvideo?q=neko+youtube&&mid=AF21CBDA31A5799845CAAF21CBDA31A5799845CA&FORM=VAMGZC";

    	request.setAttribute("videoUrl", url);
        request.setAttribute("videoNo", "1");
         *********/

        // JSP に一覧を渡す
//      request.setAttribute("videos", list);


        // 一覧表示用 JSP へフォワード
//        request.getRequestDispatcher("/WEB-INF/stretchVideoList.jsp")
//               .forward(request, response);


        request.getRequestDispatcher("/user/physical.jsp").forward(request, response);
    }

    // --- POST：登録処理 ---
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF-8");
//
//        // フォームから受け取り
//        String videoUrl = request.getParameter("videoUrl");
//        String stretchNumStr = request.getParameter("stretchNum");
//
//        int stretchNum = Integer.parseInt(stretchNumStr);
//
//        // Bean へセット
//        StretchVideo video = new StretchVideo(videoUrl, stretchNum);
//
//        // DB に保存
////        dao.insert(video);
//
//        // 登録後に一覧へリダイレクト
//        response.sendRedirect(request.getContextPath() + "/stretchVideo");
    	this.doGet(request, response);
    }
}
