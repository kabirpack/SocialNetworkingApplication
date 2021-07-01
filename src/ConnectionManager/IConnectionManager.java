package ConnectionManager;

import UserProfile.Model.UserProfile;

import java.text.ParseException;
import java.util.ArrayList;

public interface IConnectionManager {
    void searchProfile();
    ArrayList<UserProfile> getSearchResults(String searchString);
    void chooseProfile(ArrayList<UserProfile> searchResults ,int choice) throws ParseException;
    void sendConnectionRequest(UserProfile profile);
    void acceptRequest(UserProfile profile);
    void deleteSentRequest(UserProfile profile);
    void deleteReceivedRequest(UserProfile profile);
    boolean isConnected(UserProfile profile1, UserProfile profile2);
}
