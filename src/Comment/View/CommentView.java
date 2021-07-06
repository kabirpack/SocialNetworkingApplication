package Comment.View;

import Comment.Model.Comment;
import Posts.Model.Post;
import UserProfile.Model.UserProfile;
import Utilities.UtilityManager;

public class CommentView {

    UtilityManager utility = new UtilityManager();

    public void showCommentLikes(Post post){
        System.out.println("Choose Comment");
        int choice = utility.getIntInput();
        Comment chosenComment =  post.getComments().get(choice-1);
        if(chosenComment.getLikes().size() > 0){
            for(UserProfile profile : chosenComment.getLikes()){
                System.out.println(profile.getUsername());
            }
        }else{
            System.out.println("No Likes yet");
        }
    }

    public void showCommentReplies(Post post){
        System.out.println("Choose Comment");
        int choice = utility.getIntInput();
        Comment chosenComment =  post.getComments().get(choice-1);
        if(chosenComment.getReply().size() > 0){
            int index = 0;
            for(Comment reply : chosenComment.getReply()){
                System.out.println(index + ". " +reply.getProfile().getUsername() + " : " + " " + reply.getContent());
            }
        }
    }
}
