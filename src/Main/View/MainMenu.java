package Main.View;

import ConnectionManager.ConnectionManager;
import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import NewsFeed.NewsFeed;
import Posts.View.PostForm;
import SessionManager.SessionManager;
import UserProfile.View.MyProfileMainMenu;
import UserProfile.View.ProfileView;

import java.text.ParseException;

public class MainMenu {
    MenuSelector menu = new MenuSelector();
    PostForm postForm = new PostForm();
    ConnectionManager cm = new ConnectionManager();
    MyProfileMainMenu profileMenu = new MyProfileMainMenu();
    ProfileView profileView = new ProfileView();
    NewsFeed newsFeed = new NewsFeed();

    public void welcomeMenu() throws ParseException {
        int choice = menu.showMenuItems(MenuItems.MainMenu.class);

        switch (choice){
            case 1:{
                postForm.createPost();
                break;
            }
            case 2:{
                newsFeed.showNewsFeed();
                break;
            }
            case 3:{
               profileMenu.showMyProfileMenu();
               break;
            }
            case 4:{
                cm.searchProfile();
                break;
            }
            case 5:{
                profileView.showNotifications();
            }
            case 6:{
                SessionManager.logOut();
            }
        }
        this.welcomeMenu();
    }
}
