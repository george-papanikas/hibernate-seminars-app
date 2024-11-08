package gr.aueb.cf.seminars.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "ROOM")
@Inheritance(strategy = InheritanceType.JOINED)
public class Room extends AbstractEntity {

    @Column(name = "TITLE", length = 256, unique = true, nullable = false)
    private String title;

    @OneToMany(mappedBy = "room")
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
        if (seminar == null) return false;
        if (seminar.getRoom() == this) return false;

        seminar.setRoom(this);
        this.seminars.add(seminar);
        return true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
