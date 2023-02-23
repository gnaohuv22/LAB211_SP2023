/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h203;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class ValidateInput {
    
    
    private static Scanner sc;
    //Enter non-empty String
    public static String inputNonEmptyStr(String msg)
    {
        String str;
        do
        {
            try
            {
                System.out.print(msg);
                
                sc = new Scanner(System.in);
                str = sc.nextLine();
                //Check if string is empty
                if (str.isEmpty()) throw new Exception("Input must not empty.");
                
                break;
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        while (true);
        
        return str;
    }
}
