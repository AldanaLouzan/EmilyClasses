package bookingclass.entity;

import java.util.Date;



/**
 *
 * @author Aldana
 */
public class Student extends Person {

    private int idStudent;
    private String email;
    private String password;
    private String phone;
    private String birth;
    private int age;
    private String college;
    private String level;
    private Parent parent;

    public Student() {
    }
    
    //Constructor without parent attibute, as not all the students must have parents contanct details
    public Student(int id, String email, String password, String phone, String birth, int age, String college, String level, String name, String surname) {
        super(name, surname);
        this.idStudent = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.birth = birth;
        this.age = age;
        this.college = college;
        this.level = level;
    }

    public Student(String email, String password, String phone, String birth, int age, String college, String level, Parent parent, String name, String surname) {
        super(name, surname);
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.birth = birth;
        this.age = age;
        this.college = college;
        this.level = level;
        this.parent = parent;
    }
    
    

    public Student(int id, String email, String password, String phone, String birth, int age, String college, String level, Parent parent, String name, String surname) {
        super(name, surname);
        this.idStudent = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.birth = birth;
        this.age = age;
        this.college = college;
        this.level = level;
        this.parent = new Parent();
    }

    public int getId() {
        return idStudent;
    }

    public void setID(int id) {
        this.idStudent = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

}
