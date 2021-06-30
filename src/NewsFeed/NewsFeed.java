package NewsFeed;

import Posts.Model.Post;
import SessionManager.SessionManager;
import SocialNetworkDb.Implementation.SocialNetworkDb;
import UserProfile.Model.UserProfile;
import Utilities.UtilityManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class NewsFeed {
    UtilityManager utility = new UtilityManager();
    UserProfile user;
    SocialNetworkDb db;
    ArrayList<UserProfile> myConnections;
    ArrayList<Post> feedPosts;

    public void showNewsFeed() throws ParseException {
        user = SessionManager.getUser();
        db = SessionManager.getDb();
        myConnections = user.getConnections();
        for(int i=0 ; i < myConnections.size(); i++){
            for(Post post : myConnections.get(i).getPosts() ){
                feedPosts.add(post);
            }
        }
        feedPosts = this.sortByTime(feedPosts);    // display format has to be decided
    }

    public ArrayList<Post> sortByTime(ArrayList<Post> posts) throws ParseException {
        ArrayList<Post> sortedPosts = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        for(int i = 0; i < posts.size()-1; i++){
            if(sdf.parse(posts.get(i+1).getPostedTime()).before(sdf.parse(posts.get(i).getPostedTime()))){
                sortedPosts.add(0,posts.get(i+1));
            }
        }
        return sortedPosts;
    }
}
