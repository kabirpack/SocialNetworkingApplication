package UserProfile.View;

import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Navigation.NavigationController;
import UserProfile.Controller.ProfileManager;

import java.text.ParseException;

public class EditProfileMenu {
    MenuSelector menu = new MenuSelector();
    ProfileManager pm = new ProfileManager();

    public void showEditProfileMenu() throws ParseException {
        int choice = menu.showMenuItems(MenuItems.EditProfileMenu.class);

        switch (choice){

            case 1:{
              pm.updateStatus();
              break;
            }
            case 2:{
                pm.updateBio();
                break;
            }
            case 3:{
                pm.changeUserName();
                break;
            }
            case 4:{
                NavigationController.goToMyProfileMenu();
                return;
            }
        }
        this.showEditProfileMenu();
    }

}
