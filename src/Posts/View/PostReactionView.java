package Posts.View;

import Comment.Model.Comment;
import Posts.Model.Post;
import UserProfile.Model.UserProfile;

public class PostReactionView {

    public void showLikes(Post post){
        if(post.getLikes().size() > 0){
            for(UserProfile profile : post.getLikes()){
                System.out.println(profile.getUsername());
            }
        }else{
            System.out.println("No likes yet");
        }
    }

    public void showComments(Post post){
        if(post.getComments().size() > 0){

            for(Comment comment : post.getComments()){
                System.out.println(comment.getProfile().getUsername() + " " + comment.getContent() + " " + comment.getTime());
                System.out.println("Likes " + comment.getLikes().size() + " Replies " + comment.getReply().size());
            }
        }else{
            System.out.println("No comments yet");
        }
    }

    public void showShares(Post post){
        if(post.getShares().size() > 0){
            for(UserProfile profile : post.getShares()){
                System.out.println(profile.getUsername());
            }
        }else{
            System.out.println("No Shares yet");
        }
    }

}
