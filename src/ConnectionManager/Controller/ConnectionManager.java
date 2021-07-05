package ConnectionManager.Controller;

import Navigation.NavigationController;
import Posts.Model.Post;
import Posts.View.PostReactionMenu;
import SessionManager.SessionManager;
import UserProfile.Controller.Implementation.ProfileManager;
import UserProfile.Model.UserProfile;
import UserProfile.View.Implementation.ProfileView;
import Utilities.UtilityManager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ConnectionManager {
    UtilityManager utility = new UtilityManager();
    ArrayList<UserProfile> profiles = SessionManager.getDb().getProfiles();
    PostReactionMenu reactionMenu = new PostReactionMenu();
    ProfileManager pm = new ProfileManager();
    ProfileView profileView = new ProfileView();
    boolean done;

    public void searchProfile() throws ParseException {

        System.out.println("Enter username or profile id");
        String searchString = utility.getStringInput();
        ArrayList<UserProfile> resultsProfiles = this.getSearchResults(searchString);
        if(resultsProfiles.size() > 0) {
            int index = 1;
            for (UserProfile profile : resultsProfiles) {
                System.out.println(index + ". " + profile.getUsername());
                index++;
            }
            int choice = 0;
            System.out.println("Choose Profile");
            this.done = false;
            while(!this.done) {
                try {
                    choice = utility.getIntInput();
                    if(choice > resultsProfiles.size()){
                        throw new InputMismatchException();
                    }
                    this.done = true;
                    this.chooseProfile(resultsProfiles,choice-1);

                } catch (InputMismatchException e) {
                    System.out.println("invalid input, please enter again ");
                }
            }
        }else{
            System.out.println("No profile matches your search");
        }
    }

    public ArrayList<UserProfile> getSearchResults(String searchString){

        ArrayList<UserProfile> searchResults = new ArrayList<>();
        for(UserProfile profile : profiles){
            if(profile.getUsername().contains(searchString) || profile.getID().contains(searchString)){
                searchResults.add(profile);
            }
        }
       return searchResults;
    }

    public void chooseProfile(ArrayList<UserProfile> searchResults ,int choice) throws ParseException {
        UserProfile profile = searchResults.get(choice);
        if (profile.equals(SessionManager.getUser())) {
            NavigationController.goToMyProfileMenu();
        } else {
            profileView.showProfile(profile);
            if (!isConnected(SessionManager.getUser(), profile)) {
                NavigationController.goToConnectionMenu(profile);
            } else {
                if (profile.getPosts().size() > 0) {
                    Post postToReact = reactionMenu.choosePost(profile);
                    reactionMenu.showReactionMenuSelector(postToReact);
                }

            }
        }
    }


    public void sendConnectionRequest(UserProfile profile){
        if(!profile.getRcvdRequestProfiles().contains(SessionManager.getUser())){
            profile.getRcvdRequestProfiles().add(SessionManager.getUser());
            SessionManager.getUser().getSentRequestProfiles().add(profile);
            System.out.println("Connection sent successfully");
            pm.sendNotification(profile, "has sent you a connection request");
        }else{
            System.out.println("request already sent");
        }
    }



    public void acceptRequest(UserProfile profile){
        profile.getSentRequestProfiles().remove(SessionManager.getUser());
        profile.getConnections().add(SessionManager.getUser());
        SessionManager.getUser().getRcvdRequestProfiles().remove(profile);
        SessionManager.getUser().getConnections().add(profile);
        System.out.println("You and " + profile.getUsername() + " is now connected");
        pm.sendNotification(profile, "has accepted your connection request");
    }

    public void deleteSentRequest(UserProfile profile){
        SessionManager.getUser().getSentRequestProfiles().remove(profile);
        System.out.println("Request deleted Successfully");
    }

    public void deleteReceivedRequest(UserProfile profile){
        SessionManager.getUser().getRcvdRequestProfiles().remove(profile);
        System.out.println("Request deleted Successfully");
    }

    public boolean isConnected(UserProfile profile1, UserProfile profile2){
        if(profile1.getConnections().contains(profile2) && profile2.getConnections().contains(profile1)){
            return true;
        }
        return false;
    }



}
