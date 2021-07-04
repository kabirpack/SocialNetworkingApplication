package Comment.Controller;

import Comment.Model.Comment;
import Posts.Model.Post;
import SessionManager.SessionManager;
import UserProfile.Controller.Implementation.ProfileManager;
import Utilities.UtilityManager;

import java.util.ArrayList;

public class CommentController {
    UtilityManager utility = new UtilityManager();
    ProfileManager pm = new ProfileManager();

    public void likeComment(Post post){
        Comment chosenComment = chooseComment(post.getComments());
        chosenComment.getLikes().add(SessionManager.getUser());
        if(!chosenComment.getProfile().equals(SessionManager.getUser())){
            pm.sendNotification(chosenComment.getProfile(), " has liked your Comment , on post of " + post.getPostedProfile().getUsername() + " posted on " + post.getPostedTime());
        }
    }

    public void replyToComment(Post post){
        Comment chosenComment = chooseComment(post.getComments());
        System.out.println("Enter your reply");
        String replyContent = utility.getStringInput();
        Comment reply = new Comment(SessionManager.getUser(),chosenComment.getId(), replyContent);
        chosenComment.getReply().add(reply);
        if(!chosenComment.getProfile().equals(SessionManager.getUser())){
            pm.sendNotification(chosenComment.getProfile(), " has replied your Comment , on post of " + post.getPostedProfile().getUsername() + " posted on " + post.getPostedTime());
        }
    }
    public Comment chooseComment(ArrayList<Comment> comments){
        System.out.println("Choose Comment");
        int choice = utility.getIntInput();
        return comments.get(choice-1);
    }
}
