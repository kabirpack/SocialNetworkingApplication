package NewsFeed.Controller;

import NewsFeed.View.NewsFeedMenu;
import Posts.Model.Post;
import SessionManager.SessionManager;
import SocialNetworkDb.Implementation.SocialNetworkDb;
import UserProfile.Model.UserProfile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
            feedPosts = this.sortByTime(feedPosts);
            int index = 1;
            for (Post post : feedPosts) {
                if(!post.isShared()){
                    System.out.println(index + ". " + post.getPostedProfile().getUsername()+ " :" + post.getPostContent()+ " " + post.getPostedTime());

                }else{
                    System.out.println("Originally posted by "+ post.getPostedProfile().getUsername());
                    System.out.println(index + ". " + "Shared by "+ post.getSharedProfile() + " :" + post.getPostContent()+ " " + post.getPostedTime());
                }
                System.out.println("Likes : " + post.getLikes().size() + " Comments " + post.getComments().size() + " Shares " + post.getShares().size());
                System.out.println("_______________________________________________________");
                index++;
            }
            newsFeed.newsFeedMenu(feedPosts);
        }else{
            System.out.println("No Posts to show");
        }

    }

    public ArrayList<Post> sortByTime(ArrayList<Post> posts){
        if(posts.size() == 1){
            return posts;
        }else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Collections.sort(posts, new Comparator<Post>() {
                @Override
                public int compare(Post o1, Post o2) {
                    try {
                        if (sdf.parse(o1.getPostedTime()) == null || sdf.parse(o2.getPostedTime()) == null)
                            return 0;
                        return sdf.parse(o1.getPostedTime()).compareTo(sdf.parse(o2.getPostedTime()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return 0;
                }
            });
        }
        return posts;
    }
}
