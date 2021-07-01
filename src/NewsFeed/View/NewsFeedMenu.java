package NewsFeed.View;

import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Navigation.NavigationController;
import Posts.Model.Post;
import Posts.View.PostReactionMenu;

import java.text.ParseException;
import java.util.ArrayList;

public class NewsFeedMenu {
    MenuSelector menuSelector = new MenuSelector();
    PostReactionMenu postReactionMenu = new PostReactionMenu();

    public void newsFeedMenu(ArrayList<Post> feedPosts) throws ParseException {

        int choice = menuSelector.showMenuItems(MenuItems.NewsFeedMenu.class);

        switch(choice) {
            case 1:{
                Post post = postReactionMenu.choosePost(feedPosts);
                postReactionMenu.showReactionMenuSelector(post);
                break;
            }
            case 2:{
                Post post = postReactionMenu.choosePost(feedPosts);
                postReactionMenu.showOthersReactionMenuSelector(post);
                break;
            }
            case 3:{
                NavigationController.goToMainMenu();
                return;
            }
        }
        this.newsFeedMenu(feedPosts);
    }
}
