package viewInterface;

import bookingclass.entity.Classes;
import bookingclass.entity.Parent;
import bookingclass.entity.Slot;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public interface IMenu { 
   public void registration()throws ParseException;
   public Parent parentDetails();
   public int login(String email, String pass); 
   //public boolean login(String email, String pass); 
   public void logIn() throws ParseException;
   public void privatePageNav(int studentID) throws ParseException;
   public void myAccount(int studentID) throws ParseException;
   public void bookForm(int studentID) throws ParseException;
   public void chooseClassType(Classes c) throws ParseException;
   public Date chooseDate(String day) throws ParseException;
   //public void timeAvailable(ArrayList<Classes> timeAvailable, Classes c);
   public Map <Integer, Integer> timeAvailable(ArrayList<Classes> classAvailable);
   public String subjectChosen ();
   public String comment ();
   public void showBooking (Classes c, Slot s, int previousQS);
}
