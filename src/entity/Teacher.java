package entity;

public class Teacher extends Employee {
    private String faculty;
    private EDegree degree;
    private int numberTeachingHours;

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public EDegree getDegree() {
        return degree;
    }

    public void setDegree(EDegree degree) {
        this.degree = degree;
    }

    public int getNumberTeachingHours() {
        return numberTeachingHours;
    }

    public void setNumberTeachingHours(int numberTeachingHours) {
        this.numberTeachingHours = numberTeachingHours;
    }

    @Override
    public double getSalary() {
        return 730 * this.getSalaryRatio() + this.getAllowance() + 45 * this.getNumberTeachingHours();
    }


    @Override
    public String toString() {
        return this.getName() + ", " + this.getFaculty() + ", " + this.getDegree() + ", " + this.getSalaryRatio() + ", " + this.getAllowance() + ", " + this.getNumberTeachingHours() + this.getSalary();
    }
}
