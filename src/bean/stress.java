package bean;

import java.sql.Date;

public class stress implements java.io.Serializable {

<<<<<<< HEAD
	private int user_num;             
	private int stress_score_num;     
	private Date date;                
=======
	private int user_num;
	private int stress_score_num;
	private Date date;
>>>>>>> branch 'master' of https://github.com/saitosoki/OruCa.git

	public stress() {}

	public int getUser_num() {
		return user_num;
	}

	public int getStress_score_num() {
		return stress_score_num;
	}

	public Date getDate() {
		return date;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public void setStress_score_num(int stress_score_num) {
		this.stress_score_num = stress_score_num;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
