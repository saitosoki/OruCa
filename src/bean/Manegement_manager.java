package bean;

public class Manegement_manager {

    private int deptId;        // 部署ID
    private String deptName;   // 部署名

    private int subId;         // 部下ID
    private String subName;    // 部下名

    public Manegement_manager() {}

    public Manegement_manager (int deptId, String deptName, int subId, String subName) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.subId = subId;
        this.subName = subName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }
}
