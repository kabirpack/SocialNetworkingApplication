package Posts.Model;

import Comment.Model.Comment;
import UserProfile.Model.UserProfile;

import java.util.ArrayList;

public class Post {
    private String postId;
    private UserProfile postedProfile;
    private String postContent;
    private String postedTime;
    private ArrayList<UserProfile> likes = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();
    private ArrayList<UserProfile> shares = new ArrayList<>();
    private boolean isShared = false;
    private String sharedProfile;

    public Post(String postId, UserProfile postedProfile, String postContent, String postedTime) {
        this.postId = postId;
        this.postedProfile = postedProfile;
        this.postContent = postContent;
        this.postedTime = postedTime;
    }

    public Post() {

    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public boolean isShared() {
        return isShared;
    }

    public void setShared(boolean shared) {
        isShared = shared;
    }

    public UserProfile getPostedProfile() {
        return postedProfile;
    }

    public void setPostedProfile(UserProfile postedProfile) {
        this.postedProfile = postedProfile;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(String postedTime) {
        this.postedTime = postedTime;
    }


    public ArrayList<UserProfile> getLikes() {
        return likes;
    }

    public void addLike(UserProfile profile){
        this.likes.add(profile);
    }

    public void setLikes(ArrayList<UserProfile> likes) {
        this.likes = likes;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<UserProfile> getShares() {
        return shares;
    }

    public String getSharedProfile() {
        return sharedProfile;
    }

    public void setSharedProfile(String sharedProfile) {
        this.sharedProfile = sharedProfile;
    }
}
