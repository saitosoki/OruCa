package bean;

public class mental implements java.io.Serializable {

	private int user_num;
	private int sentimental;
	private int date;

	public int getUser_num() {
		return user_num;
	}

	public int getSentimental() {
		return sentimental;
	}

	public int getDate() {
		return date;
	}

	public void setUser_num(int user_num) {
		this.user_num=user_num;
	}

	public void setSentimental(int sentimental) {
		this.sentimental=sentimental;
	}

	public void setDate(int date) {
		this.date=date;
	}
}
