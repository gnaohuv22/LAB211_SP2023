/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011.DTO;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class validateInput {
    
    public static Scanner sc;
    
    
    private static boolean checkBigInt(String input)
    {
        String regex = "[0-9]+";
        return input.matches(regex);
    }
    
    //Enter a BigInteger number
    public static BigInteger inputBigInt(String msg)
    {
        BigInteger finalInput;
        do
        {
            System.out.print(msg);
            try
            {
                //Check validate
                sc = new Scanner(System.in);
                finalInput = sc.nextBigInteger();
                
                if (finalInput.toString().isEmpty()) throw new InputMismatchException("Input must not empty!");
                
                if (finalInput.compareTo(new BigInteger("0")) == -1) throw new InputMismatchException("Number must positive.");
                
                String checkInput = finalInput.toString();
                
                if (!checkBigInt(checkInput)) throw new InputMismatchException();
                
                break;
            }
            catch (InputMismatchException e)
            {
                //If user enter an invalid number
                System.out.println("Only accept valid number." + e);
            }
        }
        while (true);
        return finalInput;
    }
    
    //Enter an integer in [min - max]
    public static int inputInt(String msg, int min, int max)
    {
        int finalInput;
        do
        {
            System.out.print(msg);
            try
            {
                //Check validate
                sc = new Scanner(System.in);
                String rawInput = sc.nextLine().trim();
                
                //If leave it blank
                if (rawInput.isEmpty()) throw new NumberFormatException("Input must not empty!");
                
                //Parse to Integer
                finalInput = Integer.parseInt(rawInput);
                
                // Check if out of range
                if (finalInput < min || finalInput > max) throw new NumberFormatException("Out of range. Input number must from " + min + " to " + max);
                
                break;
            }
            catch (NumberFormatException e)
            {
                //If user enter an invalid number
                System.out.println("Only accept valid number." + e);
            }
        }
        while (true);
        return finalInput;
    }
    
    //Check if String hexa is a hexadecimal number or not
    public static boolean checkHexa (String hexa)
    {
        int i;
        for (i = 0; i < hexa.length(); ++i)
        {
            char ch = hexa.charAt(i);
            //HEX number contain (0 - 9) and (A - F). Accept only UPPERCASE character
            if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F')) {
            } else return false;
        }
        return true;
    }
    
    //Enter a hexadecimal number stored in a string, with limitation of length
    public static String inputHexa(String msg, int limitation)
    {
        String hexaInput = "";
        //Enter repeatly when String is format properly
        do
        {
            try
            {
                System.out.print(msg);

                sc = new Scanner(System.in);
                hexaInput = sc.nextLine().trim().toUpperCase();

                if (!checkHexa(hexaInput)) throw new NumberFormatException("Invalid hexadecimal input.");

                //Check if input string too long
                if (hexaInput.length() > limitation) throw new NumberFormatException ("Number is too large");

                //Check if hexadecimal input is empty
                if (hexaInput.isEmpty()) throw new NumberFormatException("Input must not empty!");

                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid format for hexadecimal." + e);
            }
        } 
        while (true);
        return hexaInput;
    }
    
    //Check if String bin is correct to binary format
    public static boolean checkBin(String bin)
    {
        int i;
        for (i = 0; i < bin.length(); ++i)
        {
            //A binary number contains only 0 and 1
            if (bin.charAt(i) != '0' && bin.charAt(i) != '1') return false;
        }
        return true;
    }
    
    //Enter binary number with limitation of length
    public static String inputBin(String msg, int limitation)
    {
        String binaryInput = "";
        do
        {
            try
            {
                System.out.print(msg);

                sc = new Scanner(System.in);
                binaryInput = sc.nextLine().trim();
                //Check if binary input is incorrect
                if (!checkBin(binaryInput)) throw new NumberFormatException("Invalid binary input.");

                //Check if binary input string is too long
                if (binaryInput.length() > limitation) throw new NumberFormatException ("Number is too large");

                //Check if binary input is empty
                if (binaryInput.isEmpty()) throw new NumberFormatException("Input must not empty!");

                break;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid format for binary." + e);
            }

        } 
        while (true);
        return binaryInput;
    }
}
