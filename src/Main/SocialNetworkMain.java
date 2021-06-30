package Main;

import Authentication.AuthenticationView.AuthenticationMenu;
import SessionManager.SessionManager;
import SocialNetworkDb.Implementation.SocialNetworkDb;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SocialNetworkMain {
    public static void main(String[] args) throws ParseException {
        String startDate = "2014/09/12 00:00";

        String endDate = "2014/09/13 00:00";

        SocialNetworkDb db = new SocialNetworkDb();
        SessionManager.setDb(db);
        AuthenticationMenu menu = new AuthenticationMenu();
        menu.authenticationMenu();
    }

}
