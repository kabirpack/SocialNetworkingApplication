package UserProfile.Controller;

import Posts.Model.Post;
import SessionManager.SessionManager;
import UserProfile.Model.UserProfile;
import Utilities.UtilityManager;

public class ProfileManager {
    UtilityManager utility = new UtilityManager();

    public void addPost(String postContent){
        Post newPost = new Post(utility.generateID(),SessionManager.getUser(), postContent, utility.getCurrentTime());
        SessionManager.getUser().getPosts().add(newPost);
        newPost.setPostedProfile(SessionManager.getUser());
        this.sendCommonNotification("has added new post");
        System.out.println("Post Added Successfully");
    }


    public void updateStatus(){
        System.out.println("Existing Status " + SessionManager.getUser().getStatus());
        System.out.println("Enter Status: ");
        String status = utility.getStringInput();
        SessionManager.getUser().setStatus(status);
        this.sendCommonNotification(" has updated their status");
        System.out.println("Status Updated Successfully");
    }

    public void changeUserName(){
        System.out.println("Existing username " + SessionManager.getUser().getUsername());
        System.out.println("Enter new username: ");
        String username = utility.getStringInput();
        SessionManager.getUser().setUsername(username);
        System.out.println("username Updated Successfully");
    }

    public void sendCommonNotification(String message){
        if(SessionManager.getUser().getConnections().size()>0){
            for(UserProfile profile : SessionManager.getUser().getConnections()){
                profile.addNotification(SessionManager.getUser().getUsername() + " " + message);
            }
        }
        if(SessionManager.getUser().getFollowerProfiles().size()>0){
            for(UserProfile profile : SessionManager.getUser().getFollowerProfiles()){
                profile.addNotification(SessionManager.getUser().getUsername() + " " + message);
            }
        }

    }

    public void sendNotification(UserProfile profile, String message){
        profile.addNotification(SessionManager.getUser().getUsername() + " " + message);
    }

}
