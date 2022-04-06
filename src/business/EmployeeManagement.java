package business;

import entity.*;
import exception.MyValidateException;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class EmployeeManagement {
    public static final String FILE_NAME = "data.txt";
    public static final String NEW_LINE = "\n";
    public static final String EMP_TEACHER = "Teacher";
    public static final String EMP_STAFF = "Staff";

    private ArrayList<Employee> empList;

    public EmployeeManagement() throws IOException, Exception {
        empList = new ArrayList<>();

        //load data tu data.txt to empList
        this.load(FILE_NAME);
    }

    public void addEmployee(Employee e) throws IOException, Exception{
        //save to file
        save (e, FILE_NAME);

        //add to list
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



    /*
    * save data to data.txt
    * @param emp
    * @param fileName
    * */
    public void save (Employee employee, String fileName){
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;
    }
    //load data from data.txt
    /*
    * @param fileName
    * */
    public void load(String fileName) throws MyValidateException, Exception{
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String currentLine = null;

        try{
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            String[] words;

            while((currentLine = bufferedReader.readLine()) != null){
                words = currentLine.split(",");

                //8 columns
                if(words.length != 8){
                    throw new MyValidateException("Wrong data format at line: " + currentLine);
                }

                if(EMP_STAFF.equals(words[0].trim())){
                    // tao staff
                    //format : Staff, name, department, position, salaryRatio, allowance, noOfWorkingDay, salary
                    Staff s = new Staff();
                    s.setName(words[1].trim());
                    s.setDepartment(words[2].trim());
                    s.setPosition(EPosition.valueOf(words[3].trim()));
                    s.setSalaryRatio(Float.parseFloat(words[4].trim()));
                    s.setAllowance(Float.parseFloat(words[5].trim()));
                    s.setNumberWorkingDays(Integer.parseInt(words[6].trim()));

                    //bo sung thuoc tinh salary
                    //s.setSalary(Float.parseFloat(words[7].trim());

                    //add to list
                    this.getEmployeeList().add(s);
                } else if (EMP_TEACHER.equals(words[0].trim())){
                    //tao teacher
                    ////format: teacher, name, faculty, degree, salaryRatio, allowance, teachingHours, salary
                    Teacher t = new Teacher();
                    t.setName(words[1].trim());
                    t.setFaculty(words[2].trim());
                    t.setDegree(EDegree.valueOf(words[3].trim()));
                    t.setSalaryRatio(Float.parseFloat(words[4].trim()));
                    t.setAllowance(Float.parseFloat(words[5].trim()));
                    t.setNumberTeachingHours(Integer.parseInt(words[6].trim()));

                    //bo sung thuoc tinh salary


                    this.getEmployeeList().add(t);
                }
            }
        }catch(IOException e){
            throw new Exception("Can't read data.txt!!!");

        }catch(NumberFormatException e){//bat truong hop nhap so nhung user nhap ky tu
            throw new MyValidateException("Wrong input data, can not covert to number from character input at line: " + currentLine);
        }finally{
            //close
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(fileReader != null){
                fileReader.close();
            }
        }
    }

}
