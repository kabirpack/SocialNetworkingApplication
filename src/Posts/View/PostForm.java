package Posts.View;

import UserProfile.Controller.Implementation.ProfileManager;
import Utilities.UtilityManager;

import java.util.InputMismatchException;

public class PostForm {
    boolean done;
    UtilityManager utility = new UtilityManager();
    ProfileManager pm = new ProfileManager();


    public void createPost(){
         this.done = false;
        while(!this.done){
            try{
                System.out.println("What's in you mind?");
                String postContent = utility.getStringInput();
                if(postContent == "" || postContent == null){
                    System.out.println("Post content cannot be empty");
                    throw new InputMismatchException();
                }// add validation for content length and sentence length
                this.done = true;
                pm.addPost(postContent);
            }
            catch (InputMismatchException e){
                System.out.println("Invalid post content");
            }
        }
    }
}
