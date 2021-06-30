package Posts.View;

import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Posts.Controller.PostController;
import Posts.Model.Post;
import UserProfile.Model.UserProfile;
import Utilities.UtilityManager;

public class PostReactionMenu {
    MenuSelector menu = new MenuSelector();
    UtilityManager utility = new UtilityManager();
    public void showReactionMenuSelector(Post post){


        int choice =  menu.showMenuItems(MenuItems.reactionMenu.class);
        PostController pc = new PostController();

        switch(choice){
            case 1:{
                pc.addLike(post);
            }
            case 2: {
                pc.addComment(post);
            }
            case 3:{
                pc.Share(post);
            }
        }
    }

    public Post choosePost(UserProfile profile){
        int choice = utility.getIntInput();
        return profile.getPosts().get(choice-1);
    }
}
