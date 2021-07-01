package NewsFeed;

import NewsFeed.View.NewsFeedMenu;
import Posts.Model.Post;
import SessionManager.SessionManager;
import SocialNetworkDb.Implementation.SocialNetworkDb;
import UserProfile.Model.UserProfile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class NewsFeed {
    UserProfile user;
    SocialNetworkDb db;
    ArrayList<UserProfile> myConnections;
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


        if(feedPosts.size() > 0){
//            feedPosts = this.sortByTime(feedPosts);
            int index = 1;
            for (Post post : feedPosts) {
                if(!post.isShared()){
                    System.out.println(index + ". " + post.getPostedProfile().getUsername()+ " :" + post.getPostContent() + post.getPostedTime());
                }else{
                    System.out.println("Originally posted by"+ post.getPostedProfile().getUsername());
                    System.out.println(index + ". " + "Shared by"+ post.getSharedProfile() + " :" + post.getPostContent() + post.getPostedTime());
                }
                index++;
            }
            newsFeed.newsFeedMenu(feedPosts);
        }else{
            System.out.println("No Posts to show");
        }

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
