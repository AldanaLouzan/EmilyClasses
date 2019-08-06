package bookingclass.entity;

/**
 *
 * @author Aldana
 */
public class Teacher extends Person {

    private int idTeacher;
    private String email; 
    private String password;

    public Teacher() {
    }

    public Teacher(int idTeacher, String email, String password) {
        this.idTeacher = idTeacher;
        this.email = email;
        this.password = password;
    }

    public Teacher(int idTeacher, String email, String password, String name, String surname) {
        super(name, surname);
        this.idTeacher = idTeacher;
        this.email = email;
        this.password = password;
    }

    
    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    



}
