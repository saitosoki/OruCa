package bean;

import java.io.Serializable;
import java.sql.Date; 

public class boyacatch implements Serializable {

    private String input;       
    private String reply;       
    private int userId;        
    private Date date;         

    public boyacatch() {
    }


    public String getInput() {
        return input;
    }

    public String getReply() {
        return reply;
    }

    public int getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

 
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}