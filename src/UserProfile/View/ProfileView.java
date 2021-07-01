package UserProfile.View;

import ConnectionManager.ConnectionManager;
import Posts.Model.Post;
import SessionManager.SessionManager;
import UserProfile.Model.UserProfile;
import Utilities.UtilityManager;

import java.text.ParseException;
import java.util.ArrayList;

public class ProfileView {
    UtilityManager  utility = new UtilityManager();

    public void showMyProfile(){
        System.out.println(SessionManager.getUser().getUsername());
        System.out.println(SessionManager.getUser().getStatus());
        System.out.println(SessionManager.getUser().getConnections().size());
        int index = 1;
        for(Post post : SessionManager.getUser().getPosts()){
            System.out.println(index + ". " + post.getPostContent() + " " + post.getPostedTime());
            index ++;
        }
     }

     public void showMyConnections(){
        if(SessionManager.getUser().getConnections().size() > 0){
            int index = 1;
            for(UserProfile profile : SessionManager.getUser().getConnections()){
                System.out.println(index + ". " + profile.getUsername() + " " + profile.getStatus());
                index++;
            }
        }else{
            System.out.println("No connections yet");
        }
     }

     public void showMyRequests(){
         if(SessionManager.getUser().getSentRequestProfiles().size() > 0){
             int index = 1;
             for(UserProfile profile : SessionManager.getUser().getSentRequestProfiles()){
                 System.out.println(index + ". " + profile.getUsername() + " " + profile.getStatus());
                 index++;
             }
         }else{
             System.out.println("No sent requests");
         }
     }

     public void showReceivedRequests(){
         if(SessionManager.getUser().getRcvdRequestProfiles().size() > 0){
             int index = 1;
             for(UserProfile profile : SessionManager.getUser().getRcvdRequestProfiles()){
                 System.out.println(index + ". " + profile.getUsername() + " " + profile.getStatus());
                 index++;
             }
         }else{
             System.out.println("No requests received yet");
         }

     }

     public void visitProfile() throws ParseException {
         System.out.println("Choose Profile to visit");
        int choice = utility.getIntInput();
        ConnectionManager cm = new ConnectionManager();
        cm.showProfile(SessionManager.getUser().getConnections().get(choice-1));
     }

     public UserProfile chooseProfile(ArrayList<UserProfile> profiles){
         System.out.println("Choose Profile");
         int choice = utility.getIntInput();
         return profiles.get(choice-1);
     }

     public void showNotifications(){

     }

}
