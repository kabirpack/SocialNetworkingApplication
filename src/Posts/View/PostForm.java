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
                if(postContent.equals("")){
                    throw new InputMismatchException();
                }
                this.done = true;
                pm.addPost(postContent);
            }
            catch (InputMismatchException e){
                System.out.println("Post content cannot be empty");
            }
        }
    }
}
