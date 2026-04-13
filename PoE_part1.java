/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poe_part1;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class PoE_part1 {




    //  Stored user data (static fields like your existing code) â”€â”€
    static String storedFirstName;
    static String storedLastName;
    static String storedUsername;
    static String storedPassword;

    // 
    //  METHOD 1: checkUserName()
    //  Rules: must contain '_' AND be <= 5 characters
    //Lee, A. (2019) Boolean and Java tutorial. YouTube. Available at: https://youtu.be/CHVVEGRGiJU (Accessed: 13 April 2026).
    public static boolean checkUserName(String username) {
        boolean hasUnderscore = username.contains("_");
        boolean correctLength = username.length() <= 5;
        return hasUnderscore && correctLength;
    }

    // 
    //  METHOD 2: checkPasswordComplexity()
    //  Rules: >= 8 chars, 1 capital, 1 number, 1 special char
    // used ai calaude for explanation
    public static boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) return false;

        boolean hasCapital = false;
        boolean hasNumber  = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c))            hasCapital = true;
            else if (Character.isDigit(c))           hasNumber  = true;
            else if (!Character.isLetterOrDigit(c))  hasSpecial = true;
        }
        return hasCapital && hasNumber && hasSpecial;
    }

    // 
    //  METHOD 3: checkCellPhoneNumber()
    // cellPhone must have not more thann ll numbers and must start with'+'(South African international code)
    // Lee, A. (2019) Boolean and Java tutorial. YouTube. Available at: https://youtu.be/CHVVEGRGiJU (Accessed: 13 April 2026).
    public static boolean checkCellPhoneNumber(String cellPhone) {
        if (!cellPhone.startsWith("+")) return false;
        String digits = cellPhone.substring(1); // remove the '+'
        if (!digits.matches("\\d+")) return false; // only digits after '+'
        return digits.length() <= 11;
    }

    // 
    //  METHOD 4: registerUser()
    //  Returns a registration result message
    // 
    public static String registerUser(String username, String password, String cellPhone) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username " +
                   "contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password " +
                   "contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell number is incorrectly formatted or does not contain an international code; " +
                   "please correct the number and try again.";
        }
        // All checks passed â€” store the details
        storedUsername  = username;
        storedPassword  = password;
        return "Registration successful!";
    }

    // 
    //  METHOD 5: loginUser()
    //  Returns true if credentials match stored ones
    // 
    public static boolean loginUser(String username, String password) {
       if (storedUsername == null || storedPassword == null) return false;
        return storedUsername.equals(username) && storedPassword.equals(password);
    }

    // 
    //  METHOD 6: returnLoginStatus()
    //  Returns welcome or failure message
    // Lee, A. (2019) Boolean and Java tutorial. YouTube. Available at: https://youtu.be/CHVVEGRGiJU (Accessed: 13 April 2026).
    public static String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + storedFirstName + ", " + storedLastName +
                   " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }// method is closed 
 
  }
