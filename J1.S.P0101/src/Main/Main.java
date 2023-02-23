package Main;

import Employee.EmployeeView;
import GetData.validateInput;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoang
 */
public class Main {
    
    public static void main (String[] args)
    {
        EmployeeView ev = new EmployeeView();
        int choice;
        //Main display menu
        String[] options = {"Add an employee", "Update an employee", "Remove an employee", "Search for employees", "Sort employees by salary", "Exit"};
        
        do
        {
            //Displaying
            Display.displayMenu(options);
            
            //Choose options
            choice = validateInput.inputInt("Your choice: ", 1, 6);
            switch (choice)
            {
                case 1:
                    ev.addEmployee();
                break;
                
                case 2:
                    ev.updateEmployee();
                break;
                
                case 3:
                    ev.removeEmployee();
                break;
                
                case 4: 
                    ev.searchEmployee();
                break;
                
                case 5: 
                    ev.sortBySalary();
                break;
                
                case 6:
                    return;
            }
        }
        while (true);
    }
}
