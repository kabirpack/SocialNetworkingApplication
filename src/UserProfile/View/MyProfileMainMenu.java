package UserProfile.View;

import ConnectionManager.ConnectionManager;
import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Navigation.NavigationController;
import SessionManager.SessionManager;
import UserProfile.Model.UserProfile;

import java.text.ParseException;

public class MyProfileMainMenu {
    MenuSelector menu = new MenuSelector();
    ProfileView profileView = new ProfileView();
    EditProfileMenu editProfileMenu = new EditProfileMenu();
//    MainMenu mainMenu;
    ConnectionManager cm = new ConnectionManager();

    public void showMyProfileMenu() throws ParseException {
        profileView.showMyProfile();
        int choice = menu.showMenuItems(MenuItems.MyProfileMenu.class);
        switch (choice){

            case 1:{
                editProfileMenu.showEditProfileMenu();
                break;
            }
            case 2:{
                profileView.showMyConnections();
                if(SessionManager.getUser().getConnections().size() > 0){
                    choice = menu.showMenuItems(MenuItems.MyConnetionsMenu.class);
                    switch (choice) {
                        case 1:{
                            profileView.visitProfile();
                            break;
                        }
                        case 2:{
                            this.showMyProfileMenu();
                            break;
                        }
                    }

                }
                 break;
            }
            case 3:{
                profileView.showMyRequests();
                if(SessionManager.getUser().getSentRequestProfiles().size() > 0) {
                    choice = menu.showMenuItems(MenuItems.MyRequestsMenu.class);

                    switch (choice) {
                        case 1: {
                            UserProfile chosenProfile =  profileView.chooseProfile(SessionManager.getUser().getSentRequestProfiles());
                            cm.deleteSentRequest(chosenProfile);
                            break;
                        }
                        case 2: {
                            this.showMyProfileMenu();
                            break;
                        }
                    }
                }
               break;
            }
            case 4:{
                profileView.showReceivedRequests();
                if(SessionManager.getUser().getRcvdRequestProfiles().size() > 0) {
                    choice = menu.showMenuItems(MenuItems.ReceivedRequestMenu.class);

                    switch (choice) {
                        case 1: {
                            UserProfile chosenProfile =  profileView.chooseProfile(SessionManager.getUser().getRcvdRequestProfiles());
                            cm.deleteSentRequest(chosenProfile);
                            break;
                        }
                        case 2: {
                            UserProfile chosenProfile =  profileView.chooseProfile(SessionManager.getUser().getRcvdRequestProfiles());
                            cm.acceptRequest(chosenProfile);
                            break;
                        }
                        case 3:{
                            this.showMyProfileMenu();
                            break;
                        }
                    }
                }
                break;
            }
            case 5:{
                NavigationController.goToMainMenu();
                return;
            }
        }
        this.showMyProfileMenu();
    }
}
