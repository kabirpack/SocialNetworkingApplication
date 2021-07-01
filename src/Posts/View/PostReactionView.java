package Posts.View;

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
        if(post.getProfileCommentMap().size() > 0){

            for(int i=0; i<post.getProfileCommentMap().size(); i++){
                System.out.println(post.getProfileCommentMap().get(i));
            }
        }else{
            System.out.println("No comments yet");
        }
    }

}
