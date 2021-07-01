package SessionManager;

import Authentication.AuthenticationView.AuthenticationMenu;
import SocialNetworkDb.Implementation.SocialNetworkDb;
import UserProfile.Model.UserProfile;

import java.text.ParseException;

public class SessionManager {

    private static UserProfile user;
    private static SocialNetworkDb db;

    public static UserProfile getUser() {
        return user;
    }

    public static void setUser(UserProfile user) {
        SessionManager.user = user;
    }

    public static SocialNetworkDb getDb() {
        return db;
    }

    public static void setDb(SocialNetworkDb db) {
        SessionManager.db = db;
    }


    public static void logOut() throws ParseException {
        AuthenticationMenu menu = new AuthenticationMenu();
        menu.authenticationMenu();
    }
}
