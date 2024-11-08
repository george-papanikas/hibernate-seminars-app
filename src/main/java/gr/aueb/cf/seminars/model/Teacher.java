package gr.aueb.cf.seminars.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "TEACHERS")
public class Teacher extends AbstractEntity {

    @Column(name = "SSN",length = 10, nullable = false, unique = true)
    private String ssn;

    @Column(name = "FIRSTNAME",length = 50, nullable = true, unique = false)
    private String firstName;

    @Column(name = "LASTNAME",length = 50, nullable = true, unique = false)
    private String lastName;

    @OneToMany(mappedBy = "teacher")
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

    public boolean addSeminar(Seminar seminar) {
        if (seminar == null || seminar.getTeacher() == this) return false;
        seminar.setTeacher(this);
        this.seminars.add(seminar);
        return true;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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
