package bookingclass.entity;

/**
 *
 * @author Aldana
 */
public class Teacher extends User {

    public Teacher() {
    }

    public Teacher(int id, String email, String password, String phone) {
        super(id, email, password, phone);
    }

    public Teacher(int id, String email, String password, String phone, String name, String surname) {
        super(id, email, password, phone, name, surname);
    }
     
}
