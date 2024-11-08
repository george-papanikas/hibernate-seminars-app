package gr.aueb.cf.seminars.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "STUDENTS")
public class Student extends AbstractEntity {

    @Column(name = "FIRSTNAME", length = 50, nullable = true, unique = false)
    private String firstName;

    @Column(name = "LASTNAME", length = 50, nullable = true, unique = false)
    private String lastName;

    @ManyToMany
    @JoinTable(name = "STUDENTS_SEMINARS",
                        joinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID") ,
                        inverseJoinColumns = @JoinColumn(name = "SEMINAR_ID", referencedColumnName = "ID"))
    private List<Seminar> seminars = new ArrayList<>();

    protected List<Seminar> getSeminars() {
        return seminars;
    }

    protected void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }

    public List<Seminar> getAllSeminars() {
        return Collections.unmodifiableList(seminars);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
