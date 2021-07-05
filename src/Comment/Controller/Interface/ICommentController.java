package Comment.Controller.Interface;

import Comment.Model.Comment;
import Posts.Model.Post;

import java.util.ArrayList;

public interface ICommentController {

    void likeComment(Post post);
    void replyToComment(Post post);
    Comment chooseComment(ArrayList<Comment> comments);
}
