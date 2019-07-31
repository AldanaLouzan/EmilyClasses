package bookingclass.controller;

import bookingclass.entity.Classes;
import bookingclass.entity.Parent;
import bookingclass.entity.Student;
import bookingclass.view.Menu;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import viewInterface.IView;

/**
 *
 * @author Aldana
 */
public class MenuController implements IView {

    //Variables to manage the interaction with user
    String choice = null;
    Scanner scan = new Scanner(System.in);
    Scanner kb = new Scanner(System.in);
    
    StudentController sc = new StudentController();
    ParentController pc = new ParentController();
    ClassController cCon = new ClassController();
    

    @Override
    //----Registration new IView----//
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
        bdate = sdf.parse(birth);
        st.setBirth(birth);
        age = sc.CalculateAge(bdate);   //Method to calculate the age
        st.setAge(age);
        
        //Requesting Parent details
        if (age < 18) {
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

        sc.registerStudent(st); //Calling controller to register Student

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

    //Login, checking password
    public void logIn(String email, String pass) throws ParseException {
        boolean check = sc.checkUser(email, pass);
        if (check == true) {
            privatePageNav();   //Giving access to the private page
        } else {
            System.out.println("Your password is incorrect");
            new Menu();
        }
    }

    //Login, checking password
    public boolean login(String email, String pass)  {
        boolean check = sc.checkUser(email, pass);
        return check;
    }
    
    //----Private page Nav Bar----//
    public void privatePageNav() throws ParseException {
        //NavBar
        System.out.println("Please select an option");
        System.out.println("1) Metodology");
        System.out.println("2) MyAccount");
        System.out.println("3) Log Out");

        do {
            choice = scan.nextLine();
            switch (choice) {
                case "1": {
                    System.out.println("Emily is the best teacher");
                    break;
                }
                case "2": {
                    myAccount();    //Access to user Account
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
    public void myAccount() throws ParseException {
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
                    bookForm(); //Calling the Book Form menu
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
    public void bookForm() throws ParseException {
        Classes c = new Classes();
        ArrayList<Classes> timeAvailable = new ArrayList();
        
        chooseClassType(c); //Select Class type
        chooseDate(c);      //Select Day
        timeAvailable = cCon.classType(c);  //Define Array with time availables that day
        showTimeAvailable(timeAvailable, c);   //Show the times and Set time chosen
        cCon.bookClass(c);
        
    }

    //----Select and Set Class Type----//
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
                    break;
                }
                case "2": {
                    c.setType("semiprivate");
                    break;
                }
                case "3": {
                    System.out.println("How many friends are coming with you?");
                    int groupQuantity = kb.nextInt();
                    c.setType("ingroup");
                    c.setQuantityStudents(groupQuantity);
                    break;
                }
                default: {
                    System.out.println("You chose and invalid option. Please, try again");
                    myAccount();
                    break;
                }
            }
            break;
        } while (!choice.equals("7")); // end of loop do-while
    }
    
    //Select and set Class Date
    public void chooseDate(Classes c) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        
        System.out.print("Please select a day:");
        String day = scan.nextLine();
        date = sdf.parse(day);
        c.setDate(date);
        
    }
    
    //Show the time available stored in ArrayList and Set the time and ID to the class
    @Override
    public void showTimeAvailable(ArrayList<Classes> timeAvailable, Classes c){
        for (int i = 0; i<timeAvailable.size(); i++){
            System.out.println((i+1)+") "+timeAvailable.get(i).getTime());
        }
        
        System.out.println("Please select a time");
        int choice = kb.nextInt();
        int timeChosen = timeAvailable.get(choice-1).getTime();
        int IDClassChosen = timeAvailable.get(choice-1).getId();
        int quantityStudents = timeAvailable.get(choice-1).getQuantityStudents();
        c.setTime(timeChosen);  //Set time chosen
        c.setId(IDClassChosen); //Set the ID of the class chosen
        c.setQuantityStudents(quantityStudents);    //Set quantity Students of the class chosen    
    }
}
