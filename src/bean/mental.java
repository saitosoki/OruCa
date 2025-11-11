package bean;

import java.sql.Date;

public class mental implements java.io.Serializable {

	private int user_num;
	private int sentimental;
	private Date date;

	public mental() {}

	public int getUser_num() {
		return user_num;
	}

	public int getSentimental() {
		return sentimental;
	}

	public Date getDate() {
		return date;
	}

	public void setUser_num(int user_num) {
		this.user_num=user_num;
	}

	public void setSentimental(int sentimental) {
		this.sentimental=sentimental;
	}

	public void setDate(Date date) {
		this.date=date;
	}
}
