package bean;

/**
 * 動画情報を保持する Bean
 */
public class StretchVideo {

    /** 動画URL */
    private String videoUrl;

    /** ストレッチ番号 */
    private int stretchNum;

    // --- コンストラクタ ---
    public StretchVideo() {
        // デフォルト値として指定のYouTube URLをセット
        this.videoUrl = "https://www.youtube.com/watch?v=oWHPQgdqVcQ";
        this.stretchNum = 1; // 任意の初期値（必要に応じて変更）
    }

    public StretchVideo(String videoUrl, int stretchNum) {
        this.videoUrl = videoUrl;
        this.stretchNum = stretchNum;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getStretchNum() {
        return stretchNum;
    }

    public void setStretchNum(int stretchNum) {
        this.stretchNum = stretchNum;
    }

    @Override
    public String toString() {
        return "StretchVideoBean[" +
               "videoUrl='" + videoUrl + '\'' +
               ", stretchNum=" + stretchNum +
               ']';
    }
}
