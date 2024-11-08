package gr.aueb.cf.seminars.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "SEMINARS")
public class Seminar extends AbstractEntity {

    @Column(name = "TITLE", length = 256, nullable = false, unique = true)
    private String title;

    @Column(name = "DESCRIPTION", length = 512, nullable = true)
    private String description;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID", nullable = true)
    private Teacher teacher;

    @ManyToMany
    @JoinTable(name = "SEMINARS_STUDENTS",
                                joinColumns = @JoinColumn(name = "SEMINAR_ID", referencedColumnName = "ID"),
                                inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID"))
    private List<Student> students = new ArrayList<Student>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "SCHEDULING_ID", nullable = true)
    private SchedulingPeriod schedulingPeriod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID", nullable = true)
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean addRoom(Room room) {
        if (room == null) return false;
        for (Seminar seminar : room.getSeminars()) {
            if (seminar == this) return false;
        }

        this.room = room;
        room.getSeminars().add(this);
        return true;
    }

    public SchedulingPeriod getSchedulingPeriod() {
        return schedulingPeriod;
    }

    public void setSchedulingPeriod(SchedulingPeriod schedulingPeriod) {
        this.schedulingPeriod = schedulingPeriod;
    }

    protected List<Student> getStudents() {
        return students;
    }

    protected void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(students);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public boolean addTeacher(Teacher teacher) {
        if (teacher == null) return false;
        for (Seminar seminar : teacher.getSeminars()) {
            if (seminar == this) return false;
        }

        this.teacher = teacher;
        teacher.getSeminars().add(this);
        return true;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
