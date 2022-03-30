package business;

import entity.Employee;
import entity.Staff;
import entity.Teacher;

import java.util.ArrayList;
import java.util.Locale;

public class EmployeeManagement {
    private ArrayList<Employee> empList;

    public EmployeeManagement(){
        empList = new ArrayList<>();
    }

    public void addEmployee(Employee e){
        empList.add(e);
    }

    public ArrayList<Employee> getEmployeeList(){
        return this.empList;
    }
    public ArrayList<Employee> searchByName(String name){
        ArrayList<Employee> foundByName = new ArrayList<>();
        ArrayList<Employee> empListOrigin = this.getEmployeeList();

        if(name.trim() == ""){
            return foundByName;
        }
        for (Employee e : empListOrigin){
            String s = e.getName().toUpperCase();
            if(s.contains(name.toUpperCase())){
                foundByName.add(e);
            }
        }
        return foundByName;
    }

    public ArrayList<Employee> searchByDept(String dept){
        ArrayList<Employee> foundByDept = new ArrayList<>();
        ArrayList<Employee> empListOrigin = this.getEmployeeList();

        Staff s = null;
        Teacher t = null;
        String name = null;
        for (Employee e : empListOrigin){
            if (e instanceof Staff){
                s = (Staff) e;
                name = s.getDepartment();
            }
            else if (e instanceof Teacher){
                t = (Teacher) e;
                name = t.getFaculty();
            }

            if (name.toUpperCase().contains(dept.toUpperCase())){
                foundByDept.add(e);
            }
        }
        return foundByDept;
    }



}
