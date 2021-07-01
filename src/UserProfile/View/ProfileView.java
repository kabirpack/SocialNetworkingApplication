package UserProfile.View;

import Posts.Model.Post;
import SessionManager.SessionManager;
import UserProfile.Controller.ProfileManager;
import UserProfile.Model.UserProfile;
import Utilities.UtilityManager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ProfileView {
    UtilityManager  utility = new UtilityManager();
    ProfileManager pm = new ProfileManager();
    boolean done;
    public void showProfile(UserProfile profile){
        if(!profile.equals(SessionManager.getUser())){
            pm.sendNotification(profile, "has visited your profile");
        }
        System.out.println("_______________________________________________________");
        if(profile.equals(SessionManager.getUser())){
            System.out.println("MY PROFILE");
        }else{
            System.out.println("PROFILE PAGE");
        }
        System.out.println("Profile Name : " + profile.getUsername());
        System.out.println("My Status : " + profile.getStatus());
        System.out.println("My Bio : " + profile.getBio());
        if(profile.getConnections().size() == 0){
            System.out.println("No connections made yet");
        }else{
            System.out.println(profile.getConnections().size() + " Connections ");
        }
        this.showMyPosts(profile);
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
         this.done = false;
         while(!this.done) {
             try {
                 int choice = utility.getIntInput();
                 if(choice > SessionManager.getUser().getConnections().size()){
                     throw new InputMismatchException();
                 }
                 this.done = true;
                 this.showProfile(SessionManager.getUser().getConnections().get(choice-1));
             } catch (InputMismatchException e) {
                 System.out.println("Invalid input, please enter again ");
             }
         }
     }

     public UserProfile chooseProfile(ArrayList<UserProfile> profiles){
         System.out.println("Choose Profile");
         this.done = false;
         while(!this.done) {
             try {
                 int choice = utility.getIntInput();
                 if(choice > profiles.size()){
                     throw new InputMismatchException();
                 }
                 this.done = true;
                 return profiles.get(choice-1);

             } catch (InputMismatchException e) {
                 System.out.println("invalid input, please enter again ");
             }
         }
         return null;
     }

     public void showNotifications(){
        if(SessionManager.getUser().getNotifications().size() > 0){
            for(String notification : SessionManager.getUser().getNotifications()){
                System.out.println(notification);
            }
        }else{
            System.out.println("No notifications to show");
        }
     }

     public void showMyPosts(UserProfile profile){
        int index = 1;
        if(profile.getPosts().size()>0) {

            System.out.println("MY POSTS");
            System.out.println("_______________________________________________________");
            for(Post post : profile.getPosts()){
                if(!post.isShared()){
                    System.out.println(index + ". " + post.getPostedProfile().getUsername()+ " :" + post.getPostContent()+ " " + post.getPostedTime());

                }else{
                    System.out.println("Originally posted by "+ post.getPostedProfile().getUsername());
                    System.out.println(index + ". " + "Shared by "+ post.getSharedProfile() + " :" + post.getPostContent()+ " " + post.getPostedTime());
                }
                index ++;
                System.out.println("_______________________________________________________");
            }
        }else{
            System.out.println("No post to show");
        }

     }

}
