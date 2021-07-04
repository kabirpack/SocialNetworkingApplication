package Posts.View;

import Comment.View.CommentReactionMenu;
import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Navigation.NavigationController;
import Posts.Controller.Implementation.PostController;
import Posts.Model.Post;
import UserProfile.Model.UserProfile;
import Utilities.UtilityManager;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class PostReactionMenu {
    MenuSelector menu = new MenuSelector();
    UtilityManager utility = new UtilityManager();
    CommentReactionMenu commentReactionMenu = new CommentReactionMenu();
    boolean done;
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
                NavigationController.goToNewsFeed();
                break;
            }

            case 5:{
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
                break;
            }
            case 2: {
                reactionView.showComments(post);
                choice = menu.showMenuItems(MenuItems.CommentSectionMenu.class);
                switch (choice){
                    case 1:{
                      commentReactionMenu.commentReactionMenu(post);
                      break;
                    }
                    case 2:{
                      commentReactionMenu.showOthersCommentReaction(post);
                      break;
                    }
                    case 3:{
                        this.showOthersReactionMenuSelector(post);
                        return;
                    }
                }
                break;
            }
            case 3:{
                reactionView.showShares(post);
                break;
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
        while(!this.done) {
            try {
                int choice = utility.getIntInput();
                if(choice > profile.getPosts().size()){
                    throw new InputMismatchException();
                }
                this.done = true;
                return profile.getPosts().get(choice-1);
            } catch (InputMismatchException e) {
                System.out.println("invalid input, please enter again ");
            }
        }

        return null;
    }

    public Post choosePost(ArrayList<Post> feedPosts) {
        System.out.println("Choose Post");
         this.done = false;
        while(!this.done) {
            try {
                int choice = utility.getIntInput();
                if(choice > feedPosts.size()){
                    throw new InputMismatchException();
                }
                this.done = true;
                return feedPosts.get(choice - 1);

            } catch (InputMismatchException e) {
                System.out.println("invalid input, please enter again ");
            }
        }
        return null;
    }

}
