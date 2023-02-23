/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011.GUI;


/**
 *
 * @author hoang
 */
public class Display {
    
    //Both of this to display menu
    public static void displayMenu(Object[] options)
    {
        System.out.println("-------CONVERTING SYSTEM--------");
        int i;
        for (i = 0; i < options.length; ++i)
        {
            System.out.println((1 + i) + ". " + options[i]);
        }
    }
    
    public static void displayMenu(String[] options)
    {
        System.out.println("-------CONVERTING SYSTEM--------");
        int i;
        for (i = 0; i < options.length; ++i)
        {
            System.out.println((1 + i) + ". " + options[i]);
        }

    }
}
