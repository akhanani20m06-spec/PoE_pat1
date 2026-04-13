/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poe_part1;
  import java.util.Scanner;
import static poe_part1.PoE_part1.checkCellPhoneNumber;
import static poe_part1.PoE_part1.checkPasswordComplexity;
import static poe_part1.PoE_part1.checkUserName;
import static poe_part1.PoE_part1.loginUser;
import static poe_part1.PoE_part1.registerUser;
import static poe_part1.PoE_part1.returnLoginStatus;

/**
 *
 * @author Student
 */
 //  MAIN METHOD
    
public class LoginSystem {
      
     checkFirstName {
    
}
    
    checklastName{
    
}
    
    checkUserName {
    
}
    
    checkPassword{
    
}
    checkcellPhone{
    
}
   public static void main(String[] args) {
       //Den of the Nerds (2015) Username and Password Java tutorial. YouTube. Available at: URL (Accessed: 13 April 2026). 
        Scanner input = new Scanner(System.in);

        System.out.println("=== REGISTRATION ===");

        // Get first and last name
        System.out.print("Enter first name: ");
        String FirstName = input.nextLine();

        System.out.print("Enter last name: ");
        String LastName = input.nextLine();

        // Get username and check it
        System.out.print("Enter username (must contain '_' and be 5 or less characters): ");
        String username = input.nextLine();
        if (checkUserName(username)) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your " +
                               "username contains an underscore and is no more than five characters in length.");
            input.close();
            return;
        }

        // Get password and check it
        System.out.print("Enter password (min 8 chars, 1 capital, 1 number, 1 special char): ");
        String password = input.nextLine();
        if (checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password " +
                               "contains at least eight characters, a capital letter, a number, and a special character.");
            input.close();
            return;
        }

        // Get cell phone and check it
        System.out.print("Enter cell phone number (e.g. +27838968976): ");
        String cellPhone = input.nextLine();
        if (checkCellPhoneNumber(cellPhone)) {
            System.out.println("Cell number successfully captured.");
        } else {
            System.out.println("Cell number is incorrectly formatted or does not contain an international code; " +
                               "please correct the number and try again.");
            input.close();
            return;
        }

        // Register the user
        String regResult = registerUser(username, password, cellPhone);
        System.out.println("\n" + regResult);

        // 
        System.out.println("\n=== LOGIN ===");

        System.out.print("Enter username: ");
        String enteredUsername = input.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = input.nextLine();

        boolean loginSuccess = loginUser(enteredUsername, enteredPassword);
        System.out.println(returnLoginStatus(loginSuccess));

        input.close();
    }
}