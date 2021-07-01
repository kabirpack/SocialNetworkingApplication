package Posts.Controller;

import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Posts.Model.Post;
import SessionManager.SessionManager;
import UserProfile.Controller.ProfileManager;
import Utilities.UtilityManager;

public class PostController {
    UtilityManager utility = new UtilityManager();
    MenuSelector menuSelector = new MenuSelector();
    ProfileManager pm = new ProfileManager();

    public void addLike(Post post){
        if(post.getLikes().contains(SessionManager.getUser())){
            System.out.println("Would you like to unlike this post?");
            int choice = menuSelector.showMenuItems(MenuItems.yesOrNo.class);
            if(choice == 1){
                post.getLikes().remove(SessionManager.getUser());
            }
        }
        else{
            post.addLike(SessionManager.getUser());
            System.out.println("Like added");
            pm.sendNotification(post.getPostedProfile(), " has liked your post, posted on " + post.getPostedTime());
        }
    }

    public void addComment(Post post){
        System.out.println("Enter Comment");
        String comment = utility.getStringInput();
        post.addComment(SessionManager.getUser().getUsername(), comment);
        pm.sendNotification(post.getPostedProfile(), " has commented your post, posted on " + post.getPostedTime());
    }

    public void Share(Post post){
        post.getShares().add(SessionManager.getUser());
        Post sharedPost = post;
        sharedPost.setShared(true);
        SessionManager.getUser().getPosts().add(sharedPost);
        pm.sendNotification(post.getPostedProfile(), " has shared your post, posted on " + post.getPostedTime());
    }
}
