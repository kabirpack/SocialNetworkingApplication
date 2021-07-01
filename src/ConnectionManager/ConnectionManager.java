package ConnectionManager;

import Navigation.NavigationController;
import Posts.Model.Post;
import Posts.View.PostReactionMenu;
import SessionManager.SessionManager;
import UserProfile.Controller.ProfileManager;
import UserProfile.Model.UserProfile;
import Utilities.UtilityManager;

import java.text.ParseException;
import java.util.ArrayList;

public class ConnectionManager {
    UtilityManager utility = new UtilityManager();
    ArrayList<UserProfile> profiles = SessionManager.getDb().getProfiles();
    PostReactionMenu reactionMenu = new PostReactionMenu();
    ProfileManager pm = new ProfileManager();


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
            choice = utility.getIntInput();
            this.chooseProfile(choice-1);
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

    public void chooseProfile(int choice) throws ParseException {
        UserProfile profile = profiles.get(choice);
        if(profile.equals(SessionManager.getUser())){
            NavigationController.goToMyProfileMenu();
        }
        else{
            this.showProfile(profile);
        }
    }

    public void showProfile(UserProfile profile) throws ParseException {
        pm.sendNotification(profile, "has visited your profile");
        System.out.println(profile.getUsername());
        System.out.println(profile.getStatus());
        // add bio here
        int index = 1;
        if(profile.getPosts().size()>0) {
            for (Post post : profile.getPosts()) {
                System.out.println(index + ". " + post.getPostContent() + "   " + post.getPostedTime());
                System.out.println("Likes :" + post.getLikes().size() + "Comments " + post.getProfileCommentMap().size()); // add share here
                index++;
            }
        }else{
            System.out.println("No post to show");
        }
        if(!isConnected(SessionManager.getUser(), profile)){
            NavigationController.goToConnectionMenu(profile);
        }
        else{
            Post postToReact = reactionMenu.choosePost(profile);
            reactionMenu.showReactionMenuSelector(postToReact);
        }
    }

    public void sendConnectionRequest(UserProfile profile){
        profile.getRcvdRequestProfiles().add(SessionManager.getUser());
        SessionManager.getUser().getSentRequestProfiles().add(profile);
        System.out.println("Connection sent successfully");
        pm.sendNotification(profile, "has sent you a connection request");
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
