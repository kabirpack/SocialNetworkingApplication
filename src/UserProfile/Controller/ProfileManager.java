package UserProfile.Controller;

import Posts.Model.Post;
import SessionManager.SessionManager;
import Utilities.UtilityManager;

public class ProfileManager {
    UtilityManager utility = new UtilityManager();

    public void addPost(String postContent){
        Post newPost = new Post(utility.generateID(),SessionManager.getUser(), postContent, utility.getCurrentTime());
        SessionManager.getUser().getPosts().add(newPost);
        System.out.println("Post Added Successfully");
    }
}
