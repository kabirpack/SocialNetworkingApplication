package ConnectionManager;

import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Posts.Model.Post;
import Posts.View.PostReactionMenu;
import UserProfile.Model.UserProfile;

public class ConnectionMenu {
    MenuSelector menuSelector = new MenuSelector();
    PostReactionMenu reactionMenu = new PostReactionMenu();
    ConnectionManager cm = new ConnectionManager();

    public void connectionMenu(UserProfile profile){

        int choice = menuSelector.showMenuItems(MenuItems.connectionMenu.class);

        switch(choice){
            case 1:{
                Post postToReact = reactionMenu.choosePost(profile);
                reactionMenu.showReactionMenuSelector(postToReact);
            }
            case 2:{

            }
            case 3:{

            }
            case 4:{

            }
        }
    }

}
