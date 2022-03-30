package business;

import entity.Employee;

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

        if(name.equals("") || name.trim() == ""){
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



}
