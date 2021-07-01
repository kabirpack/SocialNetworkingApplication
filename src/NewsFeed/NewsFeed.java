package NewsFeed;

import NewsFeed.View.NewsFeedMenu;
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
    ArrayList<UserProfile> followingProfiles;
    ArrayList<Post> feedPosts = new ArrayList<>();
    NewsFeedMenu newsFeed = new NewsFeedMenu();

    public void showNewsFeed() throws ParseException {
        user = SessionManager.getUser();
        db = SessionManager.getDb();

        if(user.getPosts().size()>0){
            for (Post post : SessionManager.getUser().getPosts()) {
                feedPosts.add(post);
            }
        }
        if(user.getConnections().size() > 0) {
            myConnections = user.getConnections();
            for (int i = 0; i < myConnections.size(); i++) {
                for (Post post : myConnections.get(i).getPosts()) {
                    feedPosts.add(post);
                }
            }
        }

        if(user.getFollowingProfiles().size() > 0) {
            followingProfiles = user.getFollowingProfiles();
            for (int i = 0; i < followingProfiles.size(); i++) {
                for (Post post : followingProfiles.get(i).getPosts()) {
                    feedPosts.add(post);
                }
            }
        }

        if(feedPosts.size() > 0){
            System.out.println("sdsadda");
//            feedPosts = this.sortByTime(feedPosts);
            int index = 1;
            for (Post post : feedPosts) {
                System.out.println(index + ". " + post.getPostedProfile().getUsername()+ " :" + post.getPostContent() + post.getPostedTime());
                index++;
            }
        }
        newsFeed.newsFeedMenu(feedPosts);

    }

    public ArrayList<Post> sortByTime(ArrayList<Post> posts) throws ParseException {
        if(posts.size() == 1){
            return posts;
        }else {
            ArrayList<Post> sortedPosts = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            for (int i = 0; i < posts.size() - 1; i++) {
                if (sdf.parse(posts.get(i + 1).getPostedTime()).before(sdf.parse(posts.get(i).getPostedTime()))) {
                    sortedPosts.add(0, posts.get(i + 1));
                }
            }
            return sortedPosts;
        }
    }
}
