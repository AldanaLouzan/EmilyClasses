package bookingclass.view;

import bookingclass.controller.MenuController;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author Aldana
 */
public class Menu {

    public Menu() throws ParseException {
        //Variables to manage interaction with user
        String choice = null;
        Scanner scan = new Scanner(System.in);
        
        MenuController mc = new MenuController();
        
        //----NavBar----//
        System.out.println("<<<<< Welcome <<<<<");
        System.out.println("Pleas select one option");
        System.out.println("(1) Register");
        System.out.println("(2) Log-in");

        do {
            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    //Calling method to Register new Student
                    mc.registration();  
                    new Menu();
                    break;
                }
                case "2": {
                    //----Log-in---//
                    System.out.print("User Name: ");
                    String email = scan.nextLine();
                    System.out.print("Password: ");
                    //Verify password
                    String password = scan.nextLine();
                    mc.logIn(email, password);
                    break;
                }
          default: {
                    System.out.println("You chose and invalid option. Please, try again");
                    new Menu();
                    break;
                }
            }//end of switch
    }while (!choice.equals ("7")); // end of loop do-while

    }

}
