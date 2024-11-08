package gr.aueb.cf.seminars.model;

import jakarta.persistence.*;

import java.time.Duration;
import java.util.Date;

@Entity
@Table(name = "SCHEDULING_PERIOD")
public class SchedulingPeriod extends AbstractEntity {

    @Column(name = "START_DATE")
    private Date start;

    @Column(name = "END_DATE")
    private Date end;

    //@Formula("DATEDIFF('MINUTE', START_DATE, END_DATE)")
    private Integer minutesDuration;

    @Transient
    private String formattedDuration;

    @OneToOne(mappedBy = "schedulingPeriod")
    private Seminar seminar;

    @PostLoad
    private void setFormattedDurationLoad() {
        Duration duration = Duration.between(getStart().toInstant(), getEnd().toInstant());
        long hours = duration.toHours();
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getMinutesDuration() {
        return minutesDuration;
    }

    public void setMinutesDuration(Integer minutesDuration) {
        this.minutesDuration = minutesDuration;
    }

    public String getFormattedDuration() {
        return formattedDuration;
    }

    public void setFormattedDuration(String formattedDuration) {
        this.formattedDuration = formattedDuration;
    }
}
