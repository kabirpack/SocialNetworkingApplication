package Authentication.AuthenticationView;

import Main.View.MainMenu;
import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import SessionManager.SessionManager;
import UserProfile.Model.UserProfile;

public class AuthenticationMenu {

    private MenuSelector menu = new MenuSelector();
    private AuthenticationForms authForms = new AuthenticationForms();
    MainMenu mainMenu = new MainMenu();

    public void authenticationMenu(){

        int choice = menu.showMenuItems(MenuItems.landingMenu.class);

        switch (choice){
            case 1: {
                authForms.registrationForm();
                System.out.println("Registration Successful");
            }
            case 2:{
                UserProfile user = authForms.loginForm();
                SessionManager session = new SessionManager();
                session.setUser(user);
                mainMenu.welcomeMenu();
                return;
            }
        }
    }

}
