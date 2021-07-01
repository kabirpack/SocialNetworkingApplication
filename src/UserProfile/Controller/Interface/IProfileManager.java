package UserProfile.Controller.Interface;

import UserProfile.Model.UserProfile;

public interface IProfileManager {
    void addPost(String postContent);
    void deletePost();
    void updateStatus();
    void changeUserName();
    void sendCommonNotification(String message);
    void sendNotification(UserProfile profile, String message);
    public void updateBio();
}
