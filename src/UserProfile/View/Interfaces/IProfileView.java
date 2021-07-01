package UserProfile.View.Interfaces;

import UserProfile.Model.UserProfile;

import java.text.ParseException;
import java.util.ArrayList;

public interface IProfileView {
    void showProfile(UserProfile profile);
    void showMyConnections();
    void showMyRequests();
    void showReceivedRequests();
    void visitProfile() throws ParseException;
    UserProfile chooseProfile(ArrayList<UserProfile> profiles);
    void showNotifications();
    void showPosts(UserProfile profile);

}
