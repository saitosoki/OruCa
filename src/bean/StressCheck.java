package bean;

import java.io.Serializable;
import java.util.Date; // JSPの表示（fmt:formatDate）で使いやすくするため

public class StressCheck implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String departmentNum;
    private int userNum;
    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
    private Date createdAt; // TimestampはDateを継承しているのでDate型で定義するのが一般的です

    // コンストラクタ
    public StressCheck() {}

    // ゲッター・セッター
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartmentNum() { return departmentNum; }
    public void setDepartmentNum(String departmentNum) { this.departmentNum = departmentNum; }

    public int getUserNum() { return userNum; }
    public void setUserNum(int userNum) { this.userNum = userNum; }

    public String getQ1() { return q1; }
    public void setQ1(String q1) { this.q1 = q1; }

    public String getQ2() { return q2; }
    public void setQ2(String q2) { this.q2 = q2; }

    public String getQ3() { return q3; }
    public void setQ3(String q3) { this.q3 = q3; }

    public String getQ4() { return q4; }
    public void setQ4(String q4) { this.q4 = q4; }

    public String getQ5() { return q5; }
    public void setQ5(String q5) { this.q5 = q5; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
}