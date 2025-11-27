package bean;

public class Manegement_manager {


    private String DEPARTMENT_NUM;   // 部署名


    private String NAME;    // 部下名

    public Manegement_manager() {}

    public Manegement_manager ( String DEPARTMENT_NUM,  String NAME) {
        this.DEPARTMENT_NUM = DEPARTMENT_NUM;
        this.NAME = NAME;
    }


    public String getDeptName() {
        return DEPARTMENT_NUM;
    }

    public void setDEPARTMENT_NUM(String DEPARTMENT_NUM) {
        this.DEPARTMENT_NUM = DEPARTMENT_NUM;
    }


    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
}
