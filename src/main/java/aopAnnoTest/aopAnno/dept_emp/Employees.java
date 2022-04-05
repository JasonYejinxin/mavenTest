package aopAnnoTest.aopAnno.dept_emp;

public class Employees {
    private String ename;
    private String gender;
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
    public void test1(){
        System.out.println(this.dept.getDname() + this.gender + this.ename);
    }
}
