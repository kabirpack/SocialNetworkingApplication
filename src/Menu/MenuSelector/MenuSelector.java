package Menu.MenuSelector;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuSelector <E extends Enum<E>> {

    boolean done;
    int choice;
    Scanner sc = new Scanner(System.in);

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
                choice = sc.nextInt();
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
