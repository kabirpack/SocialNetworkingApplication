package Authentication.AuthenticationView;

import Authentication.AuthenticationController.Authentication;
import SessionManager.SessionManager;
import UserProfile.Model.UserProfile;
import Utilities.UtilityManager;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AuthenticationForms {
    boolean done;
    UtilityManager utility = new UtilityManager();
    Authentication auth = new Authentication();

    public void registrationForm() {
        this.done = false;
        while (!done) {
            try {
                System.out.println("-----------------\nUSER REGISTRATION\n-----------------");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter username");
                String userName = utility.getStringInput();
                if (userName.length() > 4) {
                    if (auth.validateUserName(userName)) {
                        System.out.println("Username Already Exists");
                        throw new InputMismatchException();
                    }
                } else {
                    System.out.println("Username is too short");
                    throw new InputMismatchException();
                }
                System.out.println("Enter password");
                String passWord = utility.getStringInput();
                auth.register(userName, passWord);
                this.done = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid, Enter again");
            }
        }
    }

    public UserProfile loginForm() throws ParseException {
        this.done = false;
        while (!done) {
            try {
                System.out.println("-----------------\nUSER LOGIN\n-----------------");
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter username");
                String userName = utility.getStringInput();
                if (auth.validateUserName(userName) == false) {
                    System.out.println("Username not found");
                    throw new InputMismatchException();
                }
                System.out.println("Enter password");
                String passWord = utility.getStringInput();
                if (!auth.validateCredential(userName,passWord)) {
                    System.out.println("Wrong Password");
                    throw new InputMismatchException();
                }else {
                    UserProfile user = auth.getUserProfile(userName, passWord);
                    this.done = true;
                    return user;
                }
            } catch (InputMismatchException e) {
                SessionManager.logOut();
            }
        }
        return null;
    }
}
