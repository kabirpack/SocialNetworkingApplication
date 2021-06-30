package Posts.Model;

import UserProfile.Model.UserProfile;

import java.util.ArrayList;
import java.util.HashMap;

public class Post {
    private String postId;
    private UserProfile postedProfile;
    private String postContent;
    private String postedTime;
    private ArrayList<UserProfile> likes;
    private HashMap<UserProfile, String> profileCommentMap;
    private HashMap<UserProfile, String> profileShareMap;

    public Post(String postId, UserProfile postedProfile, String postContent, String postedTime) {
        this.postId = postId;
        this.postedProfile = postedProfile;
        this.postContent = postContent;
        this.postedTime = postedTime;
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

    public void setLikes(ArrayList<UserProfile> likes) {
        this.likes = likes;
    }

    public HashMap<UserProfile, String> getProfileCommentMap() {
        return profileCommentMap;
    }

    public void setProfileCommentMap(HashMap<UserProfile, String> profileCommentMap) {
        this.profileCommentMap = profileCommentMap;
    }

    public HashMap<UserProfile, String> getProfileShareMap() {
        return profileShareMap;
    }

    public void setProfileShareMap(HashMap<UserProfile, String> profileShareMap) {
        this.profileShareMap = profileShareMap;
    }
}
