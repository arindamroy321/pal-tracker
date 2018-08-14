package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    private long id;
    private long projectId;

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(@Value("projectId") long projectId, @Value("userId") long userId,
                     @Value("date") LocalDate date, @Value("hours") int hours) {

        this.projectId=projectId;
        this.userId=userId;
        this.date=date;
        this.hours=hours;
    }

    public TimeEntry(@Value("id") long id, @Value("projectId") long projectId, @Value("userId") long userId,
                     @Value("date") LocalDate date, @Value("hours") int hours){
        this.id = id;
        this.projectId=projectId;
        this.userId=userId;
        this.date=date;
        this.hours=hours;

    }

    public TimeEntry() {

    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return id == timeEntry.id &&
                projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                Objects.equals(date, timeEntry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectId, userId, date, hours);
    }
}
