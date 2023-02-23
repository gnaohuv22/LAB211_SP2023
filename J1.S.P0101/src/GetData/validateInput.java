package GetData;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class validateInput {
    
    private static Scanner sc;
    
    //Enter a string include only English alphabet, and -, ,, . and ' sign
    public static String inputStr(String msg, String regex)
    {
        String str;
        do
        {
            
            try
            {
                System.out.print(msg);
                sc = new Scanner(System.in);
                str = sc.nextLine().trim();

                //Match the regex out
                if (str.matches(regex)) break;
                else throw new Exception ("Invalid format. Try again.");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        while (true);
        return str;
    }
    
    public static double inputDouble (String msg, int min, int max)
    {
        double inp;
        do
        {
            System.out.print(msg);
            try
            {
                sc = new Scanner(System.in);
                String temp = sc.nextLine().trim();
                
                //Input must not empty
                if (temp.isEmpty()) System.out.println("Invalid input format.");
                
                //Parse int value to inp 
                inp = Double.parseDouble(temp);
                
                //If inp is out of range
                if (inp < min || inp > max) System.out.println("Out of range (" + min + " - " + max + ")");

                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Only accept valid number.");
            }
        }
        while (true);
        return inp;
    }

    
    //Enter an integer in range [min - max]
    public static int inputInt(String msg, int min, int max)
    {
        int inp;
        do
        {
            System.out.print(msg);
            try
            {
                sc = new Scanner(System.in);
                String temp = sc.nextLine().trim();
                
                //Input must not empty
                if (temp.isEmpty()) System.out.println("Invalid input format.");
                
                //Parse int value to inp 
                inp = Integer.parseInt(temp);
                
                //If inp is out of range
                if (inp < min || inp > max) System.out.println("Out of range (" + min + " - " + max + ")");

                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Only accept valid number.");
            }
        }
        while (true);
        return inp;
    }
    
    //Compare two date by substring its String form, if (date1 < date2) return true, else false
    public static boolean checkDate(String date1, String date2)
    {
        int day1 = Integer.parseInt(date1.substring(0, 2));
        int month1 = Integer.parseInt(date1.substring(3, 5));
        int year1 = Integer.parseInt(date1.substring(6, 10));
        
        int day2 = Integer.parseInt(date2.substring(0, 2));
        int month2 = Integer.parseInt(date2.substring(3, 5));
        int year2 = Integer.parseInt(date2.substring(6, 10)) - 18;
        
        if (year1 > year2) return false;
        if (year1 < year2) return true;
        
        if (month1 > month2) return false;
        if (month1 < month2) return true;
        
        if (day1 > day2) return false;
        if (day1 < day2) return true;
        return true;
    }
    
    //Check date string if it is correct
    public static boolean validateDate(String date)
    {
        int day = Integer.parseInt(date.substring(0, 2));
        int month = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10));
        
        if (day == 0 || month == 0) return false;
        
        if (month > 12) return false;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31) return false;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) return false;
                break;
            default:
                if (year % 4 == 0)
                {
                    if (day > 29) return false;
                }
                else
                {
                    if (day > 28) return false;
                }   break;
        }
        return true;
    }
    
    //Enter an ID include English Alphabet and number
    public static int inputId(String msg)
    {
        int id;
        String str;
        String regex = "([0-9]*)+";
        do
        {
            System.out.print(msg);
            try
            {
                sc = new Scanner(System.in);
                str = sc.nextLine().trim();
                
                //If ID is empty or contains invalid character
                if (str.isEmpty() || !str.matches(regex)) throw new Exception("Invalid ID format. ID must be an integer");
                
                id = Integer.parseInt(str);
                break;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
            
        }
        while (true);
        
        return id;
    }
}
