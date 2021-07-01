package Main;

import Authentication.AuthenticationView.AuthenticationMenu;
import Navigation.NavigationController;
import SessionManager.SessionManager;
import SocialNetworkDb.Implementation.SocialNetworkDb;

import java.text.ParseException;

public class SocialNetworkMain {
    public static void main(String[] args) throws ParseException {

        NavigationController  nav = new NavigationController();
        SocialNetworkDb db = new SocialNetworkDb();
        SessionManager.setDb(db);
        AuthenticationMenu authMenu = new AuthenticationMenu();
        authMenu.authenticationMenu();
    }

}
