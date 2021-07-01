package Menu.MenuSelector;

import Utilities.UtilityManager;

import java.util.InputMismatchException;

public class MenuSelector <E extends Enum<E>> {
    UtilityManager utility = new UtilityManager();
    boolean done;
    int choice;

    public int showMenuItems(Class<E> menuData) {
        int index = 1;
        for (Enum<E> menuVal: menuData.getEnumConstants()) {
            System.out.println(Integer.toString(index++)+". "+menuVal.toString());
        }
        int menuItemCount = menuData.getEnumConstants().length;
        System.out.println("Enter your choice:");
        choice = 0;
        this.done = false;
        while(!this.done){
            try{
                choice = utility.getIntInput();
                if(choice > menuItemCount){
                    throw new InputMismatchException("Invalid");
                }else{
                    this.done = true;
                    return choice;
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter correct choice");
            }
        }
        return  choice;
    }
}
