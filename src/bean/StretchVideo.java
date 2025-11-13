package bean;




	public class StretchVideo {

	    /** 動画URL */
	    private String videoUrl;

	    /** ストレッチ番号 */
	    private int stretchNum;

	    // --- コンストラクタ ---
	    public StretchVideo() {}

	    public StretchVideo(String videoUrl, int stretchNum) {
	        this.videoUrl = videoUrl;
	        this.stretchNum = stretchNum;
	    }

	    // --- getter / setter ---
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

	    // --- デバッグ用 toString ---
	    @Override
	    public String toString() {
	        return "StretchVideoBean{" +
	                "videoUrl='" + videoUrl + '\'' +
	                ", stretchNum=" + stretchNum +
	                '}';
	    }
	}


