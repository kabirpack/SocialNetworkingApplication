package UserProfile.Model;

import Posts.Model.Post;
import Utilities.UtilityManager;

import java.util.ArrayList;

public class UserProfile {

    private String ID;
    private String username;
    private String password;
    private String bio;
    private String status;
    private ArrayList<Post> posts = new ArrayList<>();
    private ArrayList<String> notifications = new ArrayList<>();
    private ArrayList<UserProfile> connections = new ArrayList<>();
    private ArrayList<UserProfile> sentRequestProfiles = new ArrayList<>();
    private ArrayList<UserProfile> rcvdRequestProfiles = new ArrayList<>();


    public UserProfile(String username, String password) {
        UtilityManager utility = new UtilityManager();
        this.ID = utility.generateID();
        this.username = username;
        this.password = password;
        this.status = "Hey there Iam Using Social Network Application!";
        this.bio = "My bio will be added soon! :)";
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
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<String> notifications) {
        this.notifications = notifications;
    }

    public void addNotification(String notification){
        this.notifications.add(notification);
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

}
