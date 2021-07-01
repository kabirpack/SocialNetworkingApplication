package SocialNetworkDb.Interface;

import UserProfile.Model.UserProfile;

import java.util.ArrayList;

public interface ISocialNetworkDb {


    ArrayList<UserProfile> getProfiles();
    void addProfile(UserProfile profile);
    void setProfiles(ArrayList<UserProfile> profiles);

}
