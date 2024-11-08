package gr.aueb.cf.seminars.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TEAMS_ROOM")
public class TeamsRoom extends Room {

    @Column(name = "TEAMS_CODE", length = 6, unique = true, nullable = false)
    private String teamsCode;

    @Column(name = "TEAMS_URL", length = 512, unique = false, nullable = true)
    private String teamsURL;

    public String getTeamsCode() {
        return teamsCode;
    }

    public void setTeamsCode(String teamsCode) {
        this.teamsCode = teamsCode;
    }

    public String getTeamsURL() {
        return teamsURL;
    }

    public void setTeamsURL(String teamsURL) {
        this.teamsURL = teamsURL;
    }
}
