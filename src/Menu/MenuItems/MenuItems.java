package Menu.MenuItems;

public class MenuItems {

    public enum LandingMenu {
        REGISTER,
        LOGIN
    }

    public enum MainMenu {
        CREATE_POST,
        NEWS_FEED,
        MY_PROFILE,
        SEARCH_PROFILE,
        NOTIFICATIONS,
        LOGOUT
    }

    public enum ConnectionMenu {
        REACT_TO_POSTS,
        SEND_CONNECTION_REQUEST,
        MAIN_MENU
    }

    public enum NewsFeedMenu {
        REACT_TO_POSTS,
        SEE_OTHERS_REACTIONS,
        MAIN_MENU
    }

    public enum ReactionMenu {
        LIKE,
        COMMENT,
        SHARE,
        GO_BACK_TO_NEWSFEED,
        MAIN_MENU
    }

    public enum ShowReactionMenu {
        SHOW_LIKE,
        SHOW_COMMENT,
        SHOW_SHARE,
        MAIN_MENU
    }


    public enum MyProfileMenu {
        EDIT_PROFILE,
        MY_CONNECTIONS,
        MY_REQUESTS,
        RECEIVED_REQUESTS,
        MY_POSTS,
        MAIN_MENU
    }

    public enum EditProfileMenu {
        UPDATE_STATUS,
        UPDATE_BIO,
        CHANGE_USERNAME,
        GO_BACK
    }

    public enum MyConnetionsMenu{
        VISIT_PROFILE,
        GO_BACK
    }

    public enum MyRequestsMenu {
        DELETE_REQUEST,
        GO_BACK
    }

    public enum ReceivedRequestMenu{
        DELETE_REQUEST,
        ACCEPT_REQUEST,
        GO_BACK
    }

    public enum yesOrNo{
        YES,
        NO
    }

    public enum MyPostsMenu{
        DELETE_POST,
        MAIN_MENU
    }


}
