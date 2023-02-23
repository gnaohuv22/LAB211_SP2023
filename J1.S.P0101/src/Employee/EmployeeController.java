/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import GetData.validateInput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author hoang
 */
public class EmployeeController {
    //It's a controller already
    private ArrayList <Employee> eList = new ArrayList<>();
    //Check duplicated ID with existed employee, return false if it exists, return true if the ID not found in database
    public boolean checkDuplicatedId(int id)
    {
        for (Employee e : eList)
        {
            if (e.getId() == id) return false;
        }
        return true;
    }
    
    //Use an ID number to search for Employee, return an Employee object if found, else return null
    public Employee searchById(int id)
    {
        for (Employee e : eList)
        {
            if (e.getId() == id) return e;
        }
        return null;
    }
    
    public int setEmployeeId()
    {
        int id;
        do
        {
            try
            {
                id = validateInput.inputId("Enter employee ID: ");
                if (!checkDuplicatedId(id)) throw new Exception("ID \"" + id + "\" already existed.");
                else break;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        while (2 > 1);
        return id;
    }
    
    //The regex means the name input must have the first letter uppercased
    public String setEmployeeFirstName()
    {
        String firstName = validateInput.inputStr("Enter first name (First letter uppercased): ", "([a-z]+)+");   
        return firstName.trim().substring(0, 1).toUpperCase() + firstName.trim().substring(1);
    }
    
    //The regex means the name input must have the first letter uppercased
    public String setEmployeeLastName()
    {
        String lastName = validateInput.inputStr("Enter last name (First letter uppercased): ", "([a-z]+)+");
        return lastName.trim().substring(0, 1).toUpperCase() + lastName.trim().substring(1);
    }
    
    //The phone number regex means that phone number start with 0, then one of [9843], and 8 more digits
    public String setEmployeePhone()
    {
        String phone = validateInput.inputStr("Enter phone number (09xxxxxxxx): ", "^0[9843]{1}\\d{8}$");
        return phone;
    }
    
    //Email format regex(abc@mail.cc) - start with letter, or -, or ..
    public String setEmployeeEmail()
    {
        String email = validateInput.inputStr("Enter email address (abc@mail.com): ", "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,4})+$");
        //Regex start with one or more \w character, and may include -, or., but if contains one of those, the next character must be a \w character. This sequence can repeat several times.
        //After the @ sign, the regex repeat again the above sequence, but end with its domain about 2 to 4 letter
        return email;
    }
    
    //Address contains alphabet letters, with -, ,, ., or '
    public String setEmployeeAddress()
    {
        String address = validateInput.inputStr("Enter address: ", "\\b([A-Z]+[-,a-z. ']+[ ]*)+");
        return address;
    }
    
    public String setEmployeeDoB()
    {
        //curDate is the execute time
        LocalDateTime curDate = LocalDateTime.now();
        //Set the date format to dd/MM/yyyy
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Set the currentDate variable by the format above
        String currentDate = curDate.format(dateFormat);
        String DoB;
        //This loop until the inputted-date is satisfy the requirement (18+, dd/MM/yyyy)
        do
        {
            //Enter date of birth following the format of currentDate variable above
            DoB = validateInput.inputStr("Enter date of birth (dd/MM/yyyy): ", "[\\d]{2}/[\\d]{2}/[\\d]{4}");
            
            //Check if the format of inputted-date is correct or not
            if (!validateInput.validateDate(DoB)) System.out.println("Invalid date format! (dd/MM/yyyy)");
            
            //According to labor law, employee must be 18+
            else if (!validateInput.checkDate(DoB, currentDate)) System.out.println("Employee must not over 18 years old!!");
        }
        while (!validateInput.checkDate(DoB, currentDate) || !validateInput.validateDate(DoB));
        return DoB;
    }
    
    public String setEmployeeSex()
    {
        //Only accept Male, Female and Other input for sex variable
        String sex = validateInput.inputStr("Enter gender (Male, Female and Other are accepted): ", "(Male|Female|Other)");
        return sex;
    }
    
    public double setEmployeeSalary()
    {
        //Salary is a double number from 1 to MAX
        double salary = validateInput.inputDouble("Enter salary: ", 1, Integer.MAX_VALUE);
        return salary;
    }
    
    public String setEmployeeEgency()
    {
        //Egency is an enable option which can be choose between Y or N
        String egency = validateInput.inputStr("Does employee have egency? (Y/N)", "(Y|N)");
        return egency;
    }
    
    public Employee addEmployee(int id, String firstName, String lastName, String phone, String email, String address, String DoB, String sex, double salary, String egency)
    {
        //Create an employee entity with inputted-attributes
        Employee e = new Employee(id, salary, firstName, lastName, phone, email, address, DoB, sex, egency);
        eList.add(e);
        return e;
    }
    
    public boolean isEmpty()
    {
        return eList.isEmpty();
    }

    public Employee removeEmployee(int id) 
    {
        Employee e = searchById(id);
        if (e != null) eList.remove(e);
        return e;
    }
    
    public ArrayList<Employee> getListEmployee()
    {
        return eList;
    }
    
    public boolean searchByName(String fullName, String find)
    {
        return (fullName.contains(find));
    }
    
    public ArrayList<Employee> sortListEmployee()
    {
        //Using collections sort, ascending order by salary, then by ID
        Collections.sort(eList, (Employee e1, Employee e2) -> {
            if (e1.getSalary() == e2.getSalary()) return e1.getId() - e2.getId();
            return (int)(e1.getSalary() - e2.getSalary());
        });
        return eList;
    }
}
