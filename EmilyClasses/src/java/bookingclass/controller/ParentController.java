
package bookingclass.controller;

import bookingclass.entity.Parent;
import dao.ParentDaoImpl;

public class ParentController 
{   
    private static int count = 0;
    ParentDaoImpl data = new ParentDaoImpl();
    
    public void registerParent (Parent p){
        data.insertParent(p);

    }

    //Autoincrement parentID defined previous to inserting into database
    public void assignParentID (Parent p){
        int id;
        id = ++count;
        p.setIdParent(id);
        count = id;
    }
    
    
 }
