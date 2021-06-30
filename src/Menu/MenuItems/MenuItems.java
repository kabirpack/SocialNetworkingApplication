package Menu.MenuItems;

public class MenuItems {

    public enum landingMenu {
        REGISTER,
        LOGIN
    }

    public enum mainMenu {
        CREATE_POST,
        NEWS_FEED,
        MY_PROFILE,
        SEARCH_PROFILE,
        LOGOUT
    }

    public enum connectionMenu {
        REACT_TO_POSTS,  // add this to post controller
        SEND_CONNECTION_REQUEST,
        FOLLOW,
        MAIN_MENU
    }

    public enum reactionMenu {
        LIKE,
        COMMENT,
        SHARE
    }

}
