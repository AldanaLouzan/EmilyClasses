package bookingclass.entity;

import java.util.Date;

/**
 *
 * @author Aldana
 */
public class Classes {

    private int idClass;
    private Date date;
    private int time;
    private String type;
    private int quantityStudents;

    public Classes() {
    }

    public Classes(int idClass, Date date, int time, String type, int quantityStudents) {
        this.idClass = idClass;
        this.date = date;
        this.time = time;
        this.type = type;
        this.quantityStudents = quantityStudents;
    }

    public int getId() {
        return idClass;
    }

    public void setId(int id) {
        this.idClass = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantityStudents() {
        return quantityStudents;
    }

    public void setQuantityStudents(int quantityStudents) {
        this.quantityStudents = quantityStudents;
    }

    
}
