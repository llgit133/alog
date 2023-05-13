package basic;

public class Emp implements Comparable<Emp> {

    private int empId;
    private String name;
    private double salary;

    public Emp(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    // 传入的参数 和 构造方法的参数
    public int compareTo(Emp o) {
        return (int) (this.salary  - o.salary); //升序
    }
}

