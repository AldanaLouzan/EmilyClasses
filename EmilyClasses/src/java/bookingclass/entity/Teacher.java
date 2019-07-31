package bookingclass.entity;

/**
 *
 * @author Aldana
 */
public class Teacher extends Person {

    private int idTeacher;

    public Teacher() {
    }

    public Teacher(int id) {
        this.idTeacher = id;
    }

    public Teacher(int id, String name, String surname) {
        super(name, surname);
        this.idTeacher = id;
    }

    public int getId() {
        return idTeacher;
    }

    public void setId(int id) {
        this.idTeacher = id;
    }

}
