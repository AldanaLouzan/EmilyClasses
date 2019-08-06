package bookingclass.controller;

import bookingclass.entity.Classes;
import bookingclass.entity.Parent;
import bookingclass.entity.Slot;
import bookingclass.entity.Student;
import bookingclass.view.Menu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import viewInterface.IMenu;

/**
 *
 * @author Aldana
 */
public class MenuController implements IMenu {

    //Variables to manage the interaction with user
    String choice = null;
    Scanner scan = new Scanner(System.in);
    Scanner kb = new Scanner(System.in);

    StudentController sc = new StudentController();
    ParentController pc = new ParentController();
    ClassController cCon = new ClassController();
    SlotController slotC = new SlotController();
    TeacherController tt = new TeacherController();
    

   @Override
    //----Registration new IMenu----//
    public void registration() throws ParseException {
        //Will need a Student and Parent object
        Student st = new Student();
        Parent p = new Parent();

        //Variables to register a new Student
        String name, surname, phone, birth, college, level, email, pass;
        int age;
        Date bdate;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //----Registration form----//
        System.out.println("Please complete the following fields");

        System.out.println("> Name: ");
        name = scan.nextLine();
        st.setName(name);

        System.out.println("> Surname: ");
        surname = scan.nextLine();
        st.setSurname(surname);

        System.out.println("> Birth date (yyyy-MM-dd): ");
        birth = scan.nextLine();
        //bdate = sdf.parse(birth);
        st.setBirth(birth);
        age = sc.CalculateAge(birth);   //Method to calculate the age
        st.setAge(age);
        boolean requestParent = sc.studentUnder18(age);
        //Requesting Parent details
        if (requestParent == true) {
            p = this.parentDetails();
            pc.registerParent(p);
            st.setParent(p);
        }

        System.out.println("> Phone number: ");
        phone = scan.nextLine();
        st.setPhone(phone);

        System.out.println("> College: ");
        college = scan.nextLine();
        st.setCollege(college);

        System.out.println("> Level: ");
        level = scan.nextLine();
        st.setLevel(level);

        System.out.println("> E-mail: ");
        email = scan.nextLine();
        st.setEmail(email);

        System.out.println("> Password: ");
        pass = scan.nextLine();
        st.setPassword(pass);

        boolean success = sc.registerStudent(st); //Calling controller to register Student

    }

    //Parent details form
    public Parent parentDetails() {

        Parent p = new Parent();
        String parentName, parentSurname, parentPhone;

        System.out.println("As you are under 18 we need your parent detail");

        System.out.println("> Name: ");
        parentName = scan.nextLine();
        p.setName(parentName);

        System.out.println("> Surname: ");
        parentSurname = scan.nextLine();
        p.setSurname(parentSurname);

        System.out.println("> Phone: ");
        parentPhone = scan.nextLine();
        p.setPhone(parentPhone);

        pc.assignParentID(p);   //Defining a parent ID

        return p;
    }

    //Login
    @Override
    public void logIn() throws ParseException {
        System.out.print("User Name: ");
        String email = scan.nextLine();
        //Validate user
        boolean checkUser = sc.checkUser(email);
        if (checkUser == true) {
            int studentID = sc.checkStudentId(email);
            System.out.print("Password: ");
            String password = scan.nextLine();
            //Verify password
            boolean checkPass = sc.checkUserPassword(email, password);

            if (checkPass == true) {
                privatePageNav(studentID);   //Giving access to the private page
            } else {
                System.out.println("Your password is incorrect");
                logIn();
                
            }

        } else {
            System.out.println("You are not a registered Student. Please Register as a new user");
            registration();
        }
    }

    public int login(String email, String pass) {
        int value;
        boolean checkTeacher = tt.checkTeacher(email);

        if (checkTeacher == true) {
            boolean checkTeacherPass = tt.checkTeacherPass(pass);
            if (checkTeacherPass == true) {
                value = 1;  //Access to Teacher Account
            } else {
                value = 0;  //Password wrong
            }
        } else {
            boolean checkUser = sc.checkUser(email);
            boolean checkPass = sc.checkUserPassword(email, pass);

            if (checkUser == true && checkPass == true) {
                value = 2;  // Access to Student Accoun
            } else {
                value = 0;  //Password or user wrong
            }
            }
        return value;
    }

    /*public boolean login (String email, String pass){
        boolean checkUser = sc.checkUser(email);
        boolean checkPass = sc.checkUserPassword(email, pass);

        if (checkUser == true && checkPass == true) {
            
            return true; // give access to privatePageNav
            }  
    return false;        
    }*/

   
   //----Private page Nav Bar----//
    public void privatePageNav(int studentID) throws ParseException {
        //NavBar
        System.out.println("Please select an option");
        System.out.println("1) Metodology");
        System.out.println("2) MyAccount");
        System.out.println("3) Log Out");

        do {
            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    System.out.println("Emily is the best teacher");    //goes to methodology page
                    break;
                }
                case "2": {
                    myAccount(studentID);    //Access to user Account
                    break;
                }
                case "3": {
                
                    new Menu();
                 
                    break;
                }
                default: {
                    System.out.println("You chose and invalid option. Please, try again");
        
                    new Menu();
             
                    break;
                }
            }

        } while (!choice.equals("7")); // end of loop do-while

    }
    //----My Account Nav Bar----//
    public void myAccount(int studentID) throws ParseException {
        System.out.println("Please select an option");
        System.out.println("1) Check my bookings");
        System.out.println("2) Book a class");

        do {
            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    System.out.println("This are your future bookings");
                    break;
                }
                case "2": {
                    bookForm(studentID); //Calling the Book Form menu
                    break;
                }
                default: {
                    System.out.println("You chose and invalid option. Please, try again");
         
                    new Menu();
         
                    break;
                }
            }

            break;
        } while (!choice.equals("7")); // end of loop do-while

    }

    
      //----Booking Form----//
    @Override
    public void bookForm(int studentID) throws ParseException {
        Classes c = new Classes();
        ArrayList<Classes> classAvailable = new ArrayList();

        //chooseClassType(c); //Select Class type
        //chooseDate(c);      //Select Day
        //classAvailable = cCon.checkClassAvailable(c.);  //Define Array with time availables that day
        timeAvailable(classAvailable);   //Show the times and Set time chosen
        
        int previousQuantityStudents = cCon.previousQuantityStudents (c.getId());
        
        String bookingSubject = subjectChosen ();   //Define subject
        String bookingComment = comment ();         //Define comment
        Slot booking = slotC.booking(c, studentID, bookingSubject, bookingComment); //Create Slot
        
        System.out.println("Here are the details of the class booked:");
        
        showBooking(c, booking, previousQuantityStudents); //Show booking
       }


  //----Select and Set Class Type----//
    @Override
    public void chooseClassType(Classes c) throws ParseException {
        System.out.println("Please select which type of class you want to book");
        System.out.println("1) Private");
        System.out.println("2) Semi-private");
        System.out.println("3) In-group");

        do {
            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    c.setType("private");
                    c.setQuantityStudents(1);
                    break;
                }
                case "2": {
                    c.setType("semiprivate");
                    c.setQuantityStudents(1);
                    break;
                }
                case "3": {
                    System.out.println("How many friends are coming with you?");
                    int groupQuantity = kb.nextInt();
                    if (groupQuantity > 3){
                        System.out.println("Sorry the maximum of Students are 4");
                        chooseClassType(c);
                    }
                    c.setType("ingroup");
                    c.setQuantityStudents((groupQuantity+1));
                    break;
                }
                default: {
                    System.out.println("You chose and invalid option. Please, try again");
                    chooseClassType(c);
                    break;
                }
            }
            break;
        } while (!choice.equals("7")); // end of loop do-while
    }
    
    //Select and set Class Date
    @Override
    public Date chooseDate(String day) throws ParseException {
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        /*System.out.print("Please select a day:");
        String day = scan.nextLine();*/
        date = sdf.parse(day);
        //c.setDate(date);
        return date;
    }

    //Show the time available stored in ArrayList and Set the time and ID to the class
    /*@Override
    public void timeAvailable(ArrayList<Classes> timeAvailable, Classes c) {
        for (int i = 0; i < timeAvailable.size(); i++) {
            System.out.println((i + 1) + ") " + timeAvailable.get(i).getTime());
        }

        System.out.println("Please select a time");
        int choice = kb.nextInt();
        int timeChosen = timeAvailable.get(choice - 1).getTime();
        int IDClassChosen = timeAvailable.get(choice - 1).getId();
        c.setTime(timeChosen);  //Set time chosen
        c.setId(IDClassChosen); //Set the ID of the class chosen
        
    }*/
    public Map <Integer, Integer> timeAvailable(ArrayList<Classes> classAvailable) {
        Map <Integer, Integer> timeAvailable = new HashMap();
        
        for (int i = 0; i < classAvailable.size(); i++) {
            timeAvailable.put(classAvailable.get(i).getId(), classAvailable.get(i).getTime());
        }

        return timeAvailable;
    }

 
    @Override
    public String subjectChosen (){
        String subject = null;
        System.out.println("Please select which subject you want to learn");
        
        System.out.println("1) Mathematics");
        System.out.println("2) Physics");
        System.out.println("3) Chemistry");

        do {
            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    subject = "M";
                    break;
                }
                case "2": {
                    subject = "P";
                    break;
                }
                case "3": {
                    subject = "C";
                    break;
                }
                default: {
                    System.out.println("You chose and invalid option. Please, try again");
                
                    subjectChosen();
                    break;
                }
            }

            break;
        } while (!choice.equals("7")); // end of loop do-while
        return subject;
    }
    
    @Override
    public String comment (){
        String comment = null;
        System.out.println("Would you like to add a comment? Y/N");
        do {
            choice = scan.nextLine();
            switch (choice) {
                case "Y": {
                    comment = scan.nextLine();
                    break;
                }
                case "N": {
                    comment = "no comments";
                    break;
                }
                 default: {
                    System.out.println("You chose and invalid option. Please, try again");
                    comment();
                    break;
                }
            }

            break;
        } while (!choice.equals("7")); // end of loop do-while
        return comment;
    }
    
    @Override
    public void showBooking (Classes c, Slot s, int previousQS){
        
        System.out.println("Date: "+c.getDate()+" | Time: "+c.getTime()
                           +" | Type: "+c.getType()+" | Price: "+s.getPrice()
                           +" | Subject: "+s.getSubject()+ " | Comments: "+s.getComment());
        
        System.out.println("Do you confirm your booking? Y/N");
        do {
            choice = scan.nextLine();
            switch (choice) {
                case "Y": {
                      s.setStatus("confirmed");
                      slotC.confirmBooking(cCon, c,s, previousQS);
                      System.out.println("Your Class has been booked successfully");
                }
                case "2": {
                    
                    break;
                }
                 default: {
                    System.out.println("You chose and invalid option. Please, try again");
                    showBooking(c, s, previousQS);
                    break;
                }
            }

        } while (!choice.equals("7")); // end of loop do-while
 
    }
        
        
}
