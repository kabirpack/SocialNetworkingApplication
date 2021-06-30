package Main.View;

import ConnectionManager.ConnectionManager;
import Menu.MenuItems.MenuItems;
import Menu.MenuSelector.MenuSelector;
import Posts.View.PostForm;

public class MainMenu {
    MenuSelector menu = new MenuSelector();
    PostForm postForm = new PostForm();
    ConnectionManager cm = new ConnectionManager();


    public void welcomeMenu(){
        int choice = menu.showMenuItems(MenuItems.mainMenu.class);

        switch (choice){
            case 1:{
                postForm.getPostContent();
                break;
            }
            case 2:{
                System.out.println("case 2");
            }
            case 3:{

            }
            case 4:{
//                if(cm.searchProfile();
////                UserProfile = cm.getSearchResults()
            }
            case 5:{

            }
        }
        this.welcomeMenu();
    }
}
