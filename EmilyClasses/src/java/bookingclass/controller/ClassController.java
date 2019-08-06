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
    //public ResultSet checkClassAvailable(String classType, String date) throws ParseException{    
    public ResultSet checkClassAvailable(String classType, Date date) {
            //ArrayList <Classes> classAvailable = new ArrayList();
        //String classType = c.getType();
        /*Date d;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        d = sdf.parse(date);*/
        ResultSet rs;
        
        if (classType == "private" || classType == "ingroup"){
            //classAvailable = data.selectEmptyClass(c.getDate()); //Select depending on the type of class
            rs = data.selectEmptyClass(date);
        }else{
            //classAvailable = data.selectSemiprivateClass(c.getDate());   //Select if class = semiprivate
            rs = data.selectSemiprivateClass(date);
        }
        return rs;
        
    }
    
    public int classId (String id){
        int classId = Integer.parseInt(id);
        return classId;
        
    }
    
    public int selectTime (Classes c){
        int timeSelected = 0;
        timeSelected = data.selectTimeChosen(c.getId(), c.getDate());
        return timeSelected;
    }
    
    public int quantityStudents (String typeClass, int groupQuantity){
        int quantityStudents = 0;
        if (typeClass == "private" || typeClass == "semiprivate"){
            quantityStudents = 1;
        }else{
            quantityStudents = groupQuantity;
        }
        return quantityStudents; 
    }
    
    public int previousQuantityStudents (int classID){
        int previousQuantityStudents = data.checkQuantityStudents (classID);
        return previousQuantityStudents; 
    }
    
    public void bookClass (Classes c, int previousQS){
        data.insertQuantityStudents(c, (previousQS + c.getQuantityStudents()));
        data.book(c);
        
    }
    
}
