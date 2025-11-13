package bean;

import java.sql.Date;

public class sentimental implements java.io.Serializable {

	private int user_num;              // 利用者番号
	private int sentiment_score_num;   // 感情スコア
	private Date date;                 // 日付

	public sentimental() {}

	public int getUser_num() {
		return user_num;
	}

	public int getSentiment_score_num() {
		return sentiment_score_num;
	}

	public Date getDate() {
		return date;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public void setSentiment_score_num(int sentiment_score_num) {
		this.sentiment_score_num = sentiment_score_num;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
