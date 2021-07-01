package Posts.Controller.Interface;

import Posts.Model.Post;

public interface IPostController {

    void addLike(Post post);
    void addComment(Post post);
    void Share(Post post);
}
