package Comment.Model;

import UserProfile.Model.UserProfile;
import Utilities.UtilityManager;

import java.util.ArrayList;

public class Comment {

    private UserProfile profile;
    private String id;
    private String postId;
    private String content;
    private String time;
    private ArrayList<UserProfile> likes = new ArrayList<>();
    private ArrayList<Comment> reply = new ArrayList<>();
    UtilityManager utility = new UtilityManager();

    public Comment(UserProfile profile, String postId, String content) {
        this.profile = profile;
        this.postId = postId;
        this.id = utility.generateID();
        this.content = content;
        this.time = utility.getCurrentTime();
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<UserProfile> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<UserProfile> likes) {
        this.likes = likes;
    }

    public ArrayList<Comment> getReply() {
        return reply;
    }

    public void setReply(ArrayList<Comment> reply) {
        this.reply = reply;
    }

    public UtilityManager getUtility() {
        return utility;
    }

    public void setUtility(UtilityManager utility) {
        this.utility = utility;
    }
}
