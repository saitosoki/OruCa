package bean;  // ★ パッケージを明記（ここが重要！）

import java.sql.Date;  // ★ Date型をimportして省略できるようにする

public class Schedule {
    private int userNum;
    private Date date;
    private String comment;

    public Schedule() {}

    public Schedule(int userNum, Date date, String comment) {
        this.userNum = userNum;
        this.date = date;
        this.comment = comment;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
