/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011.DTO;

import java.math.BigInteger;

/**
 *
 * @author hoang
 */
public class ConvertSystem {
    
    //Converter from Decimal to Binary
    public static String DecToBin(BigInteger number)
    {
        String binary = "";
        
        while (number.compareTo(new BigInteger("0")) == 1)
        {
            //Reverse the string when processing
            int add = number.remainder(new BigInteger("2")).intValue();
            binary = add + binary;
            number = number.divide(new BigInteger ("2"));
        }
        return (binary.length() > 0) ? binary : "0";
    }
    
    //Converter from Binary to Decimal
    public static BigInteger BinToDec(String binary)
    {
        BigInteger decimal = new BigInteger("0");
        int i, mul = 1;
        //Processing from the end of the number
        for (i = binary.length() - 1; i >= 0; --i)
        {
            if (binary.charAt(i) == '1') 
                decimal = decimal.add(BigInteger.valueOf(mul));
            mul *= 2;
        }
        return decimal;
    }
    
    //Converter from Decimal to Hexadecimal
    public static String DecToHex(BigInteger number)
    {
        String hexa = "";
        
        //Processing 0 - 9 -> 0 - 9 && 10 - 15 -> A - F
        while (number.compareTo(new BigInteger("0")) == 1)
        {
            //Get the remainer of number after divide 16
            BigInteger temp = number.remainder(new BigInteger("16"));
            char ch;
            if (temp.compareTo(new BigInteger("10")) == -1) 
            {
                ch = (char) (temp.intValue() + 48);
                hexa = ch + hexa;
            }
            else
            {
                ch = (char) (temp.intValue() + 55);
                hexa = ch + hexa;
            }
            number = number.divide(new BigInteger("16"));
        }
        return (hexa.length() > 0) ? hexa : "0";
    }
    
    //Hexadecimal to Decimal
    public static BigInteger HexToDec(String hexa)
    {
        BigInteger decimal = new BigInteger("0");
        int i;
        //Reverse the process of divide by 16 to multiply by 16 for each character in hexa string
        int mul = 1;
        for (i = hexa.length() - 1; i > -1; --i)
        {
            BigInteger add;
            char temp = hexa.charAt(i);
            if (temp == '0') {} 
            else if (temp >= '1' && temp <= '9') 
            {
                add = BigInteger.valueOf((int)temp - 48);
                decimal = decimal.add(add.multiply(BigInteger.valueOf(mul)));
            }
            else
            {
                add = BigInteger.valueOf((int)temp - 55);
                decimal = decimal.add(add.multiply(BigInteger.valueOf(mul)));
            }
            mul = mul * 16;
        }
        return decimal;
    }
    
    //Binary to Hexadecimal is a process that combine two task BinToDec and DecToHex
    public static String BinToHex(String binary)
    {
        BigInteger decimal = BinToDec(binary);
        String hexa = DecToHex(decimal);
        
        return hexa;
    }
    
    //The same with above, combine two program HexToDec and DecToBin
    public static String HexToBin(String hexa)
    {
        BigInteger decimal = HexToDec(hexa);
        String binary = DecToBin(decimal);
        
        return binary;
    }
}
