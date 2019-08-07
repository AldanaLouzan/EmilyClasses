package bookingclass.entity;

/**
 *
 * @author Aldana
 */
public class Parent extends Person {

    private int idParent;
    private String phone;

    public Parent() {
    }

    public Parent(int idParent, String phone) {
        this.idParent = idParent;
        this.phone = phone;
    }

    public Parent(int idParent, String phone, String name, String surname) {
        super(name, surname);
        this.idParent = idParent;
        this.phone = phone;
    }
    
    public Parent(String phone, String name, String surname) {
        super(name, surname);
        this.phone = phone;
    }

    public int getIdParent() {        
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }
    
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
