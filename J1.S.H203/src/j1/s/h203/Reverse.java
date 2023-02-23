/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h203;

/**
 *
 * @author hoang
 */
public class Reverse {
    
    //Check if the character c is lowercase or not
    private static boolean isLowerCase(char c)
    {
        return (c >= 'a' && c <= 'z');
    }
    
    private static boolean isUpperCase(char c)
    {
        return (c >= 'A' && c <= 'Z');
    }
    
    public static void printReverse(String str)
    {
        if (str.equals("")) 
        {
            str = ValidateInput.inputNonEmptyStr("Enter a non-empty string: ");
        }
        String temp = "";
        //Add two blank spaces between the dot for easier reversing process
        str = str.replaceAll("\\.", " . ");
        
        //Remove space and normalize the string with only one blank space after a word or character
        str = str.trim().replaceAll("\\s+", " ");
        
        //Cut string into words
        String[] words = str.split(" ");
        int i;
        
        //Uppercase the first letter of the reversed-string
        for (i = words.length - 1; i > -1; i--)
        {
            //Check if the word is the beginning of the string.
            if(i == words.length - 1)
            {
                temp += words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
            }
            else temp += " " + words[i];
        }
        
        //Finishing reversing process
        StringBuilder result = new StringBuilder(temp);
        for (i = 0; i < result.length() - 1; ++i)
        {
            //This remove the blank space before the dot, which make 'a . b' into 'a. b'
            if (result.charAt(i) == ' ' && result.charAt(i + 1) == '.') result.deleteCharAt(i);
            
            //This uppercase the next two character after the dot (after the dot and a blank space added before)
            if (result.charAt(i) == '.')
            {
                if (i + 2 < result.length())
                {
                    char c = result.charAt(i + 2);
                    if (isLowerCase(c))
                        result.setCharAt(i + 2, Character.toUpperCase(result.charAt(i + 2)));
                }
            }
        }
        
        for (i = 2; i < result.length(); ++i)
        {
            if (isUpperCase(result.charAt(i)) && result.charAt(i - 2) != '.') result.setCharAt(i, Character.toLowerCase(result.charAt(i)));
        }
        
        int containDot = 0;
        while (!isLowerCase(result.charAt(0)) && !isUpperCase(result.charAt(0))) 
        {
            if (result.charAt(0) == '.') ++containDot;
            result.deleteCharAt(0);
        }
        if (containDot != 0)
        /// Note: The result will only reverse the string and uppercase the first letter in string, and after the dot, do not lowercase any character.
        System.out.println(result.toString() + ".");
        else System.out.println(result.toString());
        
    }
}
