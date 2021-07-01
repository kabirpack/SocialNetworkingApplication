package Authentication.AuthenticationController;

import SessionManager.SessionManager;
import SocialNetworkDb.Implementation.SocialNetworkDb;
import UserProfile.Model.UserProfile;

import java.util.ArrayList;

public class Authentication {

    private ArrayList<UserProfile> authenticatedProfiles;
    SocialNetworkDb db = SessionManager.getDb();

    public Authentication() {
        authenticatedProfiles = db.getProfiles();
    }

    public boolean validateUserName(String userName){
        if(authenticatedProfiles.size() > 0) {
            for (UserProfile profile : authenticatedProfiles) {
                if (profile.getUsername().equals(userName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validateCredential(String userName, String password){
        for(UserProfile profile : authenticatedProfiles){
            if(profile.getUsername().equals(userName)){
                if(profile.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }

    public UserProfile getUserProfile(String userName, String password){
        for(UserProfile profile : authenticatedProfiles){
            if(profile.getUsername().equals(userName)){
                if(profile.getPassword().equals(password)){
                    return profile;
                }
            }
        }
        return null;
    }

    public void register(String username, String password){
        UserProfile user = new UserProfile(username, password);
        db.addProfile(user);
        System.out.println(db.getProfiles().size());
    }
}
