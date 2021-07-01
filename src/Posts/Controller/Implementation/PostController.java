package Posts.Controller.Implementation;

import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Posts.Controller.Interface.IPostController;
import Posts.Model.Post;
import SessionManager.SessionManager;
import UserProfile.Controller.Implementation.ProfileManager;
import Utilities.UtilityManager;

public class PostController implements IPostController {
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
            if(!post.getPostedProfile().equals(SessionManager.getUser())){
                pm.sendNotification(post.getPostedProfile(), " has liked your post, posted on " + post.getPostedTime());
            }
        }
    }

    public void addComment(Post post){
        System.out.println("Enter Comment");
        String comment = utility.getStringInput();
        post.addComment(SessionManager.getUser().getUsername(), comment);
        if(!post.getPostedProfile().equals(SessionManager.getUser())){
            pm.sendNotification(post.getPostedProfile(), " has commented your post, posted on " + post.getPostedTime());
        }
    }

    public void Share(Post post){
        post.getShares().add(SessionManager.getUser());
        Post sharedPost = new Post();
        sharedPost.setPostedProfile(post.getPostedProfile());
        sharedPost.setShared(true);
        sharedPost.setPostContent(post.getPostContent());
        sharedPost.setPostedTime(utility.getCurrentTime());
        sharedPost.setSharedProfile(SessionManager.getUser().getUsername());
        SessionManager.getUser().getPosts().add(sharedPost);
        if(!post.getPostedProfile().equals(SessionManager.getUser())){
            pm.sendNotification(post.getPostedProfile(), " has shared your post, posted on " + post.getPostedTime());
        }
    }

}
