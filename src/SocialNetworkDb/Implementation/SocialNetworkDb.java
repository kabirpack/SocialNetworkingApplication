package SocialNetworkDb.Implementation;

import UserProfile.Model.UserProfile;

import java.util.ArrayList;

public class SocialNetworkDb {

    private ArrayList<UserProfile> profiles = new ArrayList<>();

    public ArrayList<UserProfile> getProfiles() {
        return profiles;
    }

    public void addAccount(UserProfile profile){
        this.profiles.add(profile);
    }

    public void setProfiles(ArrayList<UserProfile> profiles) {
        this.profiles = profiles;
    }
}
