package bookingclass.controller;

import bookingclass.entity.Classes;
import dao.ClassesDaoImpl;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import viewInterface.IClass;


/**
 *
 * @author Eoin
 */
public class ClassController implements IClass {
    ClassesDaoImpl data = new ClassesDaoImpl();

    //MenuController mm = new MenuController();
    
    //Store time available for the type of class and date selected
    //public ArrayList<Classes> checkClassAvailable(Classes c){
    @Override
    public ResultSet checkClassAvailable(String classType, String date) throws ParseException{    
    //public ResultSet checkClassAvailable(String classType, Date date) {
            //ArrayList <Classes> classAvailable = new ArrayList();
        //String classType = c.getType();
        Date d;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        d = sdf.parse(date);
        ResultSet rs;
        
        if ("private".equals(classType) || "ingroup".equals(classType)){
            //classAvailable = data.selectEmptyClass(c.getDate()); //Select depending on the type of class
            rs = data.selectEmptyClass(d);
        }else{
            //classAvailable = data.selectSemiprivateClass(c.getDate());   //Select if class = semiprivate
            rs = data.selectSemiprivateClass(d);
        }
        return rs;
        
    }
    
    //public int selectTime (Classes c){
    @Override
    public int selectTime (int classId){
        int timeSelected;
        timeSelected = data.selectTimeChosen(classId);
        
        return timeSelected;
    }
    
   
    public int previousQuantityStudents (int classID){
        int previousQuantityStudents = data.checkQuantityStudents (classID);
        return previousQuantityStudents; 
    }
    
    public int quantityStudents (String typeClass, int groupQuantity, int previousQuantity){
        int quantityStudents = 0;
        if ("private".equals(typeClass)){
            quantityStudents = 1;
        }else if ("semiprivate".equals(typeClass)){
            quantityStudents = previousQuantity + 1;
        }else{
            quantityStudents = groupQuantity;
        }
        return quantityStudents; 
    }
    
    public boolean bookClass (Classes c){
        //data.insertQuantityStudents(c, (previousQS + c.getQuantityStudents()));
        boolean booking = data.book(c);
        return booking;
        
    }

    
}
