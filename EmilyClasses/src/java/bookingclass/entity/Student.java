package bookingclass.entity;

import java.util.Date;



/**
 *
 * @author Aldana
 */
public class Student extends User {

    private String birth;
    private int age;
    private String college;
    private String level;
    private Parent parent;
    private Teacher teacher;

    public Student() {
    }
    
    //Constructor without parent attibute, as not all the students must have parents contanct details
    public Student(String birth, int age, String college, String level, Teacher teacher, int id, String email, String password, String phone, String name, String surname) {
        super(id, email, password, phone, name, surname);
        this.birth = birth;
        this.age = age;
        this.college = college;
        this.level = level;
        this.teacher = teacher;
    }

    public Student(String birth, int age, String college, String level, Parent parent, Teacher teacher, int id, String email, String password, String phone, String name, String surname) {
        super(id, email, password, phone, name, surname);
        this.birth = birth;
        this.age = age;
        this.college = college;
        this.level = level;
        this.parent = new Parent();
        this.teacher = new Teacher();
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
