/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import Main.Display;
import GetData.validateInput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author hoang
 */
public class EmployeeView {
    // Work as Controller
    EmployeeController ec = new EmployeeController();
    
    //Add an employee to database
    public void addEmployee()
    {
        int id;
        double salary;
        String firstName, lastName, phone, email, address, DoB, sex, egency;
     
        id = ec.setEmployeeId();
        firstName = ec.setEmployeeFirstName();
        lastName = ec.setEmployeeLastName();
        phone = ec.setEmployeePhone();
        email = ec.setEmployeeEmail();
        address = ec.setEmployeeAddress();
        DoB = ec.setEmployeeDoB();
        sex = ec.setEmployeeSex();
        salary = ec.setEmployeeSalary();
        egency = ec.setEmployeeEgency();
        ec.addEmployee(id, firstName, lastName, phone, email, address, DoB, sex, salary, egency);
    }
    
    public void updateEmployee()
    {
        //No data to process the update
        if (ec.isEmpty()) System.out.println("No data available.");
        else
        {   
            //Enter an ID to find, if the ID doesn't existed, will return a notification that the ID cannot be found, else, choose attribute to update from menu by enter a number
            int findId = validateInput.inputId("Enter ID number: ");
            Employee e = ec.searchById(findId);
            if (e == null) {
                System.out.println("ID #" + findId + " not found!");
            }
            else
            {
                System.out.format("%3s%10s%10s%15s%30s%20s%15s%10s%10s%10s\n", "ID", "firstName", "lastName", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Egency");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
                Display.displaySingle(e);
                //Update menu
                String options[] = {"Change first name", "Change last name", 
                            "Change phone number", "Change email address", 
                            "Change address", "Change date of birth",
                            "Change gender", "Change salary", "Change egency", "Exit update"};

                do
                {
                    int choice;
                    //Display the menu
                    Display.displayMenu(options);
                    
                    //Enter choice from 1 to 9 to update each attribute using switch-case
                    choice = validateInput.inputInt("Your choice: ", 1, 10);
                    switch (choice)
                    {
                        case 1:
                            e.setFirstName(ec.setEmployeeFirstName());
                        break;
                        
                        case 2:
                            e.setLastName(ec.setEmployeeLastName());
                        break;
                        
                        case 3:
                            e.setPhone(ec.setEmployeePhone());
                        break;
                        
                        case 4:
                            e.setEmail(ec.setEmployeeEmail());
                        break;
                        
                        case 5:
                            e.setAddress(ec.setEmployeeAddress());
                        break;
                        
                        case 6:
                            e.setDoB(ec.setEmployeeDoB());
                        break;
                        
                        case 7:
                            e.setSex(ec.setEmployeeSex());
                        break;
                        
                        case 8:
                           e.setSalary(ec.setEmployeeSalary());
                        break;
                        
                        case 9:
                            e.setEgency(ec.setEmployeeEgency());
                        break;
                        
                        case 10:
                            return;
                    }
                }
                while (2 > 1);
            }
        }
    }
    
    //This will remove employee by its ID, if not found, return a message that the ID doesn't existed, else, remove entire Employee with inputted-ID
    public void removeEmployee()
    {
        //No data to process remove task
        if (ec.isEmpty()) System.out.println("No data available");
        else
        {
            //Enter ID to find, ID must be a number
            int findId = validateInput.inputId("Enter ID to find: ");
            if (ec.removeEmployee(findId) == null) System.out.println("ID #" + findId + " not found!");
            else System.out.println("Remove successfully.");
        }
    }
    
    //Search for employees by its name, or a part of them
    public void searchEmployee()
    {
        //No data to process searching task
        if (ec.isEmpty()) System.out.println("No data available");
        else
        {
            //Enter a string to find, it can only be alphabet letter
            String find = validateInput.inputStr("Enter a part of name to find: ", "[A-Z]*[a-z]*");
            
            //Print in format
            System.out.format("%3s%10s%10s%15s%30s%20s%15s%10s%10s%10s\n", "ID", "firstName", "lastName", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Egency");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            for (Employee e : ec.getListEmployee())
            {
                String fullName = e.getFirstName() + " " + e.getLastName();
                
                //If an employee's fullName = firstName + lastName, it will be displayed on screen
                if (ec.searchByName(fullName, find)) Display.displaySingle(e);
            }
        }
    }
    
    //Sort entire list by salary, ascending order
    public void sortBySalary()
    {
        if (ec.isEmpty()) System.out.println("No data available");
        else
        {
            ArrayList<Employee> eList = ec.sortListEmployee();
            System.out.format("%3s%10s%10s%15s%30s%20s%15s%10s%10s%10s\n", "ID", "firstName", "lastName", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Egency");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            for (Employee e : eList)
            {
                Display.displaySingle(e);
            }
        }
    }
}
