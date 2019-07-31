
package bookingclass.entity;

/**
 *
 * @author Aldana
 */
public class Slot {
    private int idSlot;
    private Student student;
    private String subject;
    private int price;
    private String status;
    private Classes classes;
    private String comment;

    public Slot() {
    }

    public Slot(int id, Student student, String subject, int price, String status, Classes classes, String comment) {
        this.idSlot = id;
        this.student = student;
        this.subject = subject;
        this.price = price;
        this.status = status;
        this.classes = classes;
        this.comment = comment;
    }
    
    public int getId() {
        return idSlot;
    }

    public void setId(int id) {
        this.idSlot = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
