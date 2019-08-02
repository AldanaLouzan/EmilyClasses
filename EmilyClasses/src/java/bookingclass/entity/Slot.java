
package bookingclass.entity;

/**
 *
 * @author Aldana
 */
public class Slot {
   private int idSlot;
    private int studentID;
    private String subject;
    private int price;
    private String status;
    private Classes classes;
    private String comment;

    public Slot() {
    }

    public Slot(int idSlot, int studentID, String subject, int price, String status, Classes classes, String comment) {
        this.idSlot = idSlot;
        this.studentID = studentID;
        this.subject = subject;
        this.price = price;
        this.status = status;
        this.classes = classes;
        this.comment = comment;
    }

    public int getIdSlot() {
        return idSlot;
    }

    public void setIdSlot(int idSlot) {
        this.idSlot = idSlot;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
