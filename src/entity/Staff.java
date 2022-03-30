package entity;

public class Staff extends Employee {
    private String department;
    private EPosition position;
    private int numberWorkingDays;


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public EPosition getPosition() {
        return position;
    }

    public void setPosition(EPosition position) {
        this.position = position;
    }

    public int getNumberWorkingDays() {
        return numberWorkingDays;
    }

    public void setNumberWorkingDays(int numberWorkingDays) {
        this.numberWorkingDays = numberWorkingDays;
    }

    @Override
    public double getSalary() {
        return 730 * this.getSalaryRatio() + this.getAllowance() + 30 * this.getNumberWorkingDays();
    }

    public String toString() {
        return "Name: " + this.getName() + ", Department: " + this.getDepartment() + ", Position: " + this.getPosition() + ", Salary Ratio: " + this.getSalaryRatio() + ", Allowance: " + this.getAllowance() + ", Number working days: " + this.getNumberWorkingDays() + ", Salary: " + this.getSalary();
    }
}
