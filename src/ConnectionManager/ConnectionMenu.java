package ConnectionManager;

import Main.View.MainMenu;
import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Posts.Model.Post;
import Posts.View.PostReactionMenu;
import UserProfile.Model.UserProfile;

import java.text.ParseException;

public class ConnectionMenu {
    MenuSelector menuSelector = new MenuSelector();
    PostReactionMenu reactionMenu;
    ConnectionManager cm = new ConnectionManager();
    MainMenu mainMenu = new MainMenu();

    public void connectionMenu(UserProfile profile) throws ParseException {

        int choice = menuSelector.showMenuItems(MenuItems.ConnectionMenu.class);

        switch(choice){
            case 1:{
                if(profile.getPosts().size() > 0) {
                    Post postToReact = reactionMenu.choosePost(profile);
                    reactionMenu.showReactionMenuSelector(postToReact);
                }else{
                    System.out.println("No Posts yet");
                }
                break;
            }
            case 2:{
                cm.sendConnectionRequest(profile);
                break;
            }
            case 3:{
                cm.followProfile(profile);
                break;
            }
            case 4:{
                mainMenu.welcomeMenu();
                return;
            }
        }
        this.connectionMenu(profile);
    }

}
