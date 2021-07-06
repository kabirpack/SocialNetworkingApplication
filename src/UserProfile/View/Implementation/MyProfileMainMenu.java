package UserProfile.View.Implementation;

import ConnectionManager.Controller.ConnectionManager;
import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Navigation.NavigationController;
import SessionManager.SessionManager;
import UserProfile.Controller.Implementation.ProfileManager;
import UserProfile.Model.UserProfile;

import java.text.ParseException;

public class MyProfileMainMenu {
    MenuSelector menu = new MenuSelector();
    ProfileView profileView = new ProfileView();
    EditProfileMenu editProfileMenu = new EditProfileMenu();
    ConnectionManager cm = new ConnectionManager();
    ProfileManager pm = new ProfileManager();

    public void showMyProfileMenu() throws ParseException {
        profileView.showProfile(SessionManager.getUser());
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
                            profileView.showMyRequests();
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
                            profileView.showReceivedRequests();
                            UserProfile chosenProfile =  profileView.chooseProfile(SessionManager.getUser().getRcvdRequestProfiles());
                            cm.deleteReceivedRequest(chosenProfile);
                            break;
                        }
                        case 2: {
                            profileView.showReceivedRequests();
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
                profileView.showPosts(SessionManager.getUser());
                if(SessionManager.getUser().getPosts().size()>0){
                    choice = menu.showMenuItems(MenuItems.MyPostsMenu.class);

                    switch(choice){
                        case 1:{
                            pm.deletePost();
                            break;
                        }
                        case 2:
                            NavigationController.goToMainMenu();
                            return;
                    }

                }

            }
            case 6:{
                NavigationController.goToMainMenu();
                return;
            }
        }
        this.showMyProfileMenu();
    }
}
