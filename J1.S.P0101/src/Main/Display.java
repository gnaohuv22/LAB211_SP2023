package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author hoang
 */
public class Display {
    public static void displayMenu(Object[] options)
    {
        for (int i = 0; i < options.length; ++i)
        {
            System.out.println((1 + i) + ". " + options[i]);
        }
    }
    
    //Display single object by using its toString() function
    public static void displaySingle(Object option)
    {
        System.out.println(option.toString());
    }
}
