package Posts.Controller;

import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Posts.Model.Post;
import SessionManager.SessionManager;
import Utilities.UtilityManager;

public class PostController {
    UtilityManager utility = new UtilityManager();
    MenuSelector menuSelector = new MenuSelector();

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
        }
    }

    public void addComment(Post post){
        System.out.println("Enter Comment");
        String comment = utility.getStringInput();
        post.addComment(SessionManager.getUser(), comment);
    }

    public void Share(Post post){

    }
}
