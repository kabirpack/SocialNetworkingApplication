package ConnectionManager;

import Main.View.MainMenu;
import Posts.Model.Post;
import SocialNetworkDb.Implementation.SocialNetworkDb;
import UserProfile.Model.UserProfile;
import Utilities.UtilityManager;

import java.util.ArrayList;

public class ConnectionManager {
    UtilityManager utility = new UtilityManager();
    SocialNetworkDb db = new SocialNetworkDb();
    ArrayList<UserProfile> profiles = db.getProfiles();
    MainMenu menu = new MainMenu();
    ConnectionMenu cm = new ConnectionMenu();


    public void searchProfile(){

        System.out.println("Enter username or profile id");
        String searchString = utility.getStringInput();
        ArrayList<UserProfile> resultsProfiles = getSearchResults(searchString);
        if(resultsProfiles.size() > 0) {
            int index = 1;
            for (UserProfile profile : resultsProfiles) {
                System.out.println(index + ". " + profile.getUsername());
                index++;
            }
            int choice = 0;
            System.out.println("Choose Profile");
            choice = utility.getIntInput();
            this.chooseProfile(choice-1);
        }else{
            System.out.println("No profile matches your search");
            menu.welcomeMenu();
        }
    }

    public ArrayList<UserProfile> getSearchResults(String searchString){

        ArrayList<UserProfile> searchResults = new ArrayList<>();
        for(UserProfile profile : profiles){
            if(profile.getUsername().contains(searchString) || profile.getID().contains(searchString)){
                searchResults.add(profile);
            }
        }
       return searchResults;
    }

    public void chooseProfile(int choice){
        UserProfile profile = profiles.get(choice);
        this.showProfile(profile);
        cm.connectionMenu(profile);
    }

    public void showProfile(UserProfile profile){

        System.out.println(profile.getUsername());
        System.out.println(profile.getStatus());
        // add bio here
        int index = 1;
        for(Post post : profile.getPosts()){
            System.out.println(index + ". " + post.getPostContent() + "   " + post.getPostedTime());
            System.out.println("Likes :" + post.getLikes().size() + "Comments " + post.getProfileCommentMap().size()); // add share here
            index ++;
        }
        cm.connectionMenu(profile);
    }



}
