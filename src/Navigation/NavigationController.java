package Navigation;

import ConnectionManager.ConnectionMenu;
import Main.View.MainMenu;
import NewsFeed.NewsFeed;
import UserProfile.Model.UserProfile;
import UserProfile.View.MyProfileMainMenu;

import java.text.ParseException;

public class NavigationController {

    public static void goToMainMenu() throws ParseException {
        MainMenu mainMenu = new MainMenu();
        mainMenu.welcomeMenu();
    }

    public static void goToConnectionMenu(UserProfile profile) throws ParseException {
        ConnectionMenu menu = new ConnectionMenu();
        menu.connectionMenu(profile);
    }

    public static void goToMyProfileMenu() throws ParseException {
        MyProfileMainMenu myProfileMainMenu = new MyProfileMainMenu();
        myProfileMainMenu.showMyProfileMenu();
    }

    public static void goToNewsFeed() throws ParseException {
        NewsFeed newsFeed = new NewsFeed();
        newsFeed.showNewsFeed();
    }

}
