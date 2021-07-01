package Posts.Model;

import UserProfile.Model.UserProfile;

import java.util.ArrayList;
import java.util.HashMap;

public class Post {
    private String postId;
    private UserProfile postedProfile;
    private String postContent;
    private String postedTime;
    private ArrayList<UserProfile> likes = new ArrayList<>();
    private HashMap<String, String> profileCommentMap = new HashMap<>();
    private ArrayList<UserProfile> shares = new ArrayList<>();
    private boolean isShared = false;

    public Post(String postId, UserProfile postedProfile, String postContent, String postedTime) {
        this.postId = postId;
        this.postedProfile = postedProfile;
        this.postContent = postContent;
        this.postedTime = postedTime;
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

    public HashMap<String, String> getProfileCommentMap() {
        return profileCommentMap;
    }

    public void addComment(String username, String comment){
        this.profileCommentMap.put(username, comment);
    }

    public void setProfileCommentMap(HashMap<String, String> profileCommentMap) {
        this.profileCommentMap = profileCommentMap;
    }

    public ArrayList<UserProfile> getShares() {
        return shares;
    }

    public void setProfileShareMap(ArrayList<UserProfile> shares) {
        this.shares = shares;
    }
}
