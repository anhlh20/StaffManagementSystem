package ui;

import business.EmployeeManagement;
import entity.*;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class StaffUI {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        Employee employee;
        EmployeeManagement employeeManagement = new EmployeeManagement();
        ArrayList<Employee> employees = new ArrayList<>();
        while (true) {
            System.out.println("University Staff Management 1.0");
            System.out.println("\t1 - Add staff");
            System.out.println("\t2 - Search staff by name");
            System.out.println("\t3 - Search staff by department/faculty");
            System.out.println("\t4 - Display all staff");
            System.out.println("\t5 - Exit");
            System.out.println("Select function (1,2,3,4 or 5): ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    employee = createEmployee();
                    employeeManagement.addEmployee(employee);
                    employees = employeeManagement.getEmployeeList();
                    break;
                case 2:
                    System.out.print("Search by name: ");
                    Scanner sc = new Scanner(System.in);
                    String nameSearch = sc.nextLine();
                    ArrayList<Employee> foundByName = employeeManagement.searchByName(nameSearch);
                    System.out.println("Result: ");
                    showList(foundByName);
                    break;
                case 3:
                    System.out.println("Enter department/faculty for search: ");
                    Scanner sc2 = new Scanner(System.in);
                    String dept = sc2.nextLine();
                    ArrayList<Employee> foundByDept = employeeManagement.searchByDept(dept);
                    System.out.println("Result:");
                    showList(foundByDept);
                    break;
                case 4:
                    showList(employees);
                    break;
                default:
                    exit(0);
            }
        }
    }

    static Employee createEmployee() {
        System.out.print("Do you want to create a Staff or a Teacher (s for Staff, otherwise for Teacher)? ");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("s")) {
            Staff staff = new Staff();
            //nhap thong tin tu ban phim
            System.out.print("Staff Name: ");
            String fullName = scanner.nextLine();

            System.out.print("Salary ratio: ");
            float salaryRatio = Float.parseFloat(scanner.nextLine());

            System.out.println("Department: ");
            String department = scanner.nextLine();

            System.out.println("Position (1=HEAD, 2=VICE HEAD, 3=STAFF): ");
            int position = scanner.nextInt();

            System.out.println("Number of working days: ");
            int no = scanner.nextInt();

            staff.setName(fullName);
            staff.setSalaryRatio(salaryRatio);
            staff.setDepartment(department);
            staff.setNumberWorkingDays(no);
            if (position == 1){
                staff.setPosition(EPosition.HEAD);
                staff.setAllowance(2000);
            } else if (position == 2){
                staff.setPosition(EPosition.VICE_HEAD);
                staff.setAllowance(1000);
            } else {
                staff.setPosition(EPosition.STAFF);
                staff.setAllowance(500);
            }
            return staff;

        } else {
            Teacher teacher = new Teacher();

            //nhap thong tin tu ban phim
            System.out.print("Teacher Name: ");
            String fullName = scanner.nextLine();

            System.out.print("Salary ratio: ");
            float salaryRatio = Float.parseFloat(scanner.nextLine());

            System.out.print("Faculty: ");
            String faculty = scanner.nextLine();

            System.out.print("Degree (1=BACHELOR, 2=MASTER, 3=DOCTOR): ");
            int degree = scanner.nextInt();

            System.out.println("Number of teaching hours: ");
            int no = scanner.nextInt();

            teacher.setName(fullName);
            teacher.setSalaryRatio(salaryRatio);
            teacher.setFaculty(faculty);
            teacher.setNumberTeachingHours(no);
            if (degree == 1) {
                teacher.setDegree(EDegree.BACHELOR);
                teacher.setAllowance(300);
            } else if (degree == 2) {
                teacher.setDegree(EDegree.MASTER);
                teacher.setAllowance(500);
            } else {
                teacher.setDegree(EDegree.DOCTOR);
                teacher.setAllowance(1000);
            }
            return teacher;
        }
    }

    static void showList(ArrayList<Employee> list){
        for (Employee e : list){
            System.out.println(e);
        }
    }
}
