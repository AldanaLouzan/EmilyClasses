package viewInterface;

import bookingclass.entity.Classes;
import bookingclass.entity.Parent;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Eoin
 */
public interface IView {
   public void registration()throws ParseException;
   public Parent parentDetails();
   public void logIn(String email, String pass) throws ParseException;
   public boolean login(String email, String pass);
   public void privatePageNav() throws ParseException;
   public void myAccount() throws ParseException;
   public void bookForm() throws ParseException;
   public void chooseClassType(Classes c) throws ParseException;
   public void chooseDate(Classes c) throws ParseException;
   public void showTimeAvailable(ArrayList<Classes> timeAvailable, Classes c);
}
