package bookingclass.entity;

public class Booking {
    private Classes Oneclass;
    private Slot slot;
    private Student student;

    public Booking() {
    }
    
    public Booking(Classes Oneclass, Slot slot, Student student) {
        this.Oneclass = Oneclass;
        this.slot = slot;
        this.student = student;
    }
    
    public Classes getOneclass() {
        return Oneclass;
    }

    public void setOneclass(Classes Oneclass) {
        this.Oneclass = Oneclass;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
