package Comment.View;

import Comment.Controller.CommentController;
import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Navigation.NavigationController;
import Posts.Model.Post;

import java.text.ParseException;

public class CommentReactionMenu {
    MenuSelector menu = new MenuSelector();
    CommentView commentView = new CommentView();

    public void commentReactionMenu(Post post) throws ParseException {

        int choice = menu.showMenuItems(MenuItems.CommentReactionMenu.class);
        CommentController commentController = new CommentController();
        switch (choice){
            case 1:{
                commentController.likeComment(post);
                break;
            }
            case 2:{
                commentController.replyToComment(post);
                break;
            }
            case 3:{
                NavigationController.goToOthersReactionMenu(post);
                return;
            }
        }
        NavigationController.goToOthersReactionMenu(post);
    }

    public void showOthersCommentReaction(Post post) throws ParseException {
        int choice = menu.showMenuItems(MenuItems.showCommentReactionMenu.class);
        switch (choice){
            case 1:{
                commentView.showCommentLikes(post);
                break;
            }
            case 2:{
                commentView.showCommentReplies(post);
                break;
            }
            case 3:{
                NavigationController.goToOthersReactionMenu(post);
                return;
            }
        }
        this.commentReactionMenu(post);

    }
}
