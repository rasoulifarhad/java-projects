package com.farhad.example.io;

import java.io.Console;
import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Password {
    
    // 1. Attempt to retrieve the Console object. If the object is not available, abort.
    // 2. Invoke Console.readLine to prompt for and read the user's login name.
    // 3. Invoke Console.readPassword to prompt for and read the user's existing password.
    // 4. Invoke verify to confirm that the user is authorized to change the password. (In this example, verify is a dummy method that always returns true.)
    // 5. Repeat the following steps until the user enters the same password twice:
    //     a. Invoke Console.readPassword twice to prompt for and read a new password.
    //     b. If the user entered the same password both times, invoke change to change it. (Again, change is a dummy method.)
    //     c. Overwrite both passwords with blanks.
    // 6. Overwrite the old password with blanks.
    //
    public static void main(String[] args) {
        Console c = System.console();
        if ( c == null ) {
            log.error("No console!.");
            System.exit(1);
        }

        String login = c.readLine("Enter your login:");
        char [] oldPassword = c.readPassword("Enter your old password:");
        if ( verify(login, oldPassword) ) {
            boolean noMatch;
            do {
                char [] newPassword1 = c.readPassword("Enter your new password:");
                char [] newPassword2 = c.readPassword("Enter new password again:");
                noMatch = ! Arrays.equals(newPassword1, newPassword2);
                if ( noMatch ) {
                    c.format("Passwords do not match. try again.%n");
                } else {
                    change(login, newPassword1);
                    c.format("Password for %s changed.%n", login);
                }
                Arrays.fill(newPassword1, ' ');
                Arrays.fill(newPassword2, ' ');
            } while(noMatch);
            Arrays.fill(oldPassword, ' ');
        }
        
    }

    public static boolean verify(String login, char [] password) {
        return true;
    }

    public static void change(String login, char [] password ) {
        log.info("password changed");
    }

}
