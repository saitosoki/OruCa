package bean;

/**
 * 動画とストレッチ番号の関連情報を保持するBeanクラス。
 */
public class VideoStretch {

    private String videoUrl;
    private int stretchNum;


    public VideoStretch() {
    }

    /**
     * 全フィールドを持つコンストラクタ
     * @param videoUrl 動画URL
     * @param stretchNum ストレッチ番号
     */

    public VideoStretch(String videoUrl, int stretchNum) {
        this.videoUrl = videoUrl;
        this.stretchNum = stretchNum;
    }

    //ゲットとサーチ

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
        return "VideoStretch{" +
                "videoUrl='" + videoUrl + '\'' +
                ", stretchNum=" + stretchNum +
                '}';
    }
}