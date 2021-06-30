package UserProfile.Model;

import Posts.Model.Post;
import Utilities.UtilityManager;

import java.util.ArrayList;

public class UserProfile {

    private String ID;
    private String username;
    private String password;
    private String Status;
    private ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<UserProfile> connections = new ArrayList<>();
    private ArrayList<UserProfile> sentRequestProfiles = new ArrayList<>();
    private ArrayList<UserProfile> rcvdRequestProfiles = new ArrayList<>();
    private ArrayList<UserProfile> followingProfiles = new ArrayList<>();
    private ArrayList<UserProfile> followerProfiles = new ArrayList<>();


    public UserProfile(String username, String password) {
        UtilityManager utility = new UtilityManager();
        this.ID = utility.generateID();
        this.username = username;
        this.password = password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<UserProfile> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<UserProfile> connections) {
        this.connections = connections;
    }

    public ArrayList<UserProfile> getSentRequestProfiles() {
        return sentRequestProfiles;
    }

    public void setSentRequestProfiles(ArrayList<UserProfile> sentRequestProfiles) {
        this.sentRequestProfiles = sentRequestProfiles;
    }

    public ArrayList<UserProfile> getRcvdRequestProfiles() {
        return rcvdRequestProfiles;
    }

    public void setRcvdRequestProfiles(ArrayList<UserProfile> rcvdRequestProfiles) {
        this.rcvdRequestProfiles = rcvdRequestProfiles;
    }

    public ArrayList<UserProfile> getFollowingProfiles() {
        return followingProfiles;
    }

    public void setFollowingProfiles(ArrayList<UserProfile> followingProfiles) {
        this.followingProfiles = followingProfiles;
    }

    public ArrayList<UserProfile> getFollowerProfiles() {
        return followerProfiles;
    }

    public void setFollowerProfiles(ArrayList<UserProfile> followerProfiles) {
        this.followerProfiles = followerProfiles;
    }
}
