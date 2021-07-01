package Posts.View;

import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Navigation.NavigationController;
import Posts.Controller.PostController;
import Posts.Model.Post;
import UserProfile.Model.UserProfile;
import Utilities.UtilityManager;

import java.text.ParseException;
import java.util.ArrayList;

public class PostReactionMenu {
    MenuSelector menu = new MenuSelector();
    UtilityManager utility = new UtilityManager();
    public void showReactionMenuSelector(Post post) throws ParseException {


        int choice =  menu.showMenuItems(MenuItems.ReactionMenu.class);
        PostController pc = new PostController();

        switch(choice){
            case 1:{
                pc.addLike(post);
                break;
            }
            case 2: {
                pc.addComment(post);
                break;
            }
            case 3:{
                pc.Share(post);
                break;
            }
            case 4:{
                NavigationController.goToMainMenu();
                return;
            }
        }
        this.showReactionMenuSelector(post);
    }

    public void showOthersReactionMenuSelector(Post post) throws ParseException {


        int choice =  menu.showMenuItems(MenuItems.ShowReactionMenu.class);
        PostReactionView reactionView = new PostReactionView();

        switch(choice){
            case 1:{
                reactionView.showLikes(post);
            }
            case 2: {
                reactionView.showComments(post);
            }
            case 3:{
//                reactionView.showShare(post);
            }
            case 4:{
                NavigationController.goToMainMenu();
                return;
            }
        }
        this.showOthersReactionMenuSelector(post);
    }



    public Post choosePost(UserProfile profile){
        System.out.println("Choose Post");
        int choice = utility.getIntInput();
        return profile.getPosts().get(choice-1);
    }

    public Post choosePost(ArrayList<Post> feedPosts){
        System.out.println("Choose Post");
        int choice = utility.getIntInput();
        return feedPosts.get(choice-1);
    }
}
