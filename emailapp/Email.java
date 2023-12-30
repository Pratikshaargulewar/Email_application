package Email_application.emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int mailboxCapacity =  500;
    private int  defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "Eggheadscompany.com";
    
    



    //Constructor to receive the first and last name 
    public Email(String firstName , String lastName){
        this.firstName = firstName;
        this.lastName  = lastName ;



        // Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: "+this.department);


        // Call a method that return a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password is : " +this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;


    }


    // Ask for the department 
    private String setDepartment(){
        System.out.println("New Worker: " + firstName + ". Department codes: \n 1 -> for Sales \n 2 -> for Developement \n 3 -> for Accounting \n 0 -> none \n Enter the department code please !.... ");
        Scanner sc = new Scanner(System.in);
        int depChoice = sc.nextInt();

        if(depChoice == 1) return "Sales";
        if(depChoice == 2) return "Developement";
        if(depChoice == 3) return "Accounting";
        else return " ";

    }
    // Generate the random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        char[] password = new char[length];
        for(int i = 0 ; i < length ; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt((rand));
        }
        return new String (password);

    } 

    // Set the mailbox capacity 
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }


    // Change the password
    public void changePassword(String password){
        this.password = password;
    }

    //get the mailbox capacity 
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + 
        " \nCOMPANY EMAIL: " + email + 
        " \nMAILBOX CAPACITY: " + mailboxCapacity + " mb";

    }


}
