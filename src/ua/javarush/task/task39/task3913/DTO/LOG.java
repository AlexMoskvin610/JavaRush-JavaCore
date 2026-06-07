package ua.javarush.task.task39.task3913.DTO;

import ua.javarush.task.task39.task3913.Event;
import ua.javarush.task.task39.task3913.Status;

import java.util.Objects;

public class LOG {
    public static Builder builder() {
        return new Builder();
    }

    private String ip;
    private String user;
    private String date;
    private Event event;
    private int taskId;
    private Status status;

    @Override
    public String toString() {
        String eventString = taskId == 0 ? event.name() : event.name() + " " + taskId;

        return String.format("LOG[%s | %s | %s | %s | %s]",
                ip, user, date, eventString, status);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LOG log = (LOG) o;
        return taskId == log.taskId && Objects.equals(ip, log.ip) && Objects.equals(user, log.user) && Objects.equals(date, log.date) && event == log.event && status == log.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, user, date, event, taskId, status);
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static class Builder {
        private LOG log = new LOG();

        public Builder withIp(String ip) {
            log.ip = ip;

            return this;
        }

        public Builder withUser(String user) {
            log.user = user;

            return this;
        }

        public Builder withDate(String date) {
            log.date = date;

            return this;
        }

        public Builder withEvent(Event event) {
            log.event = event;

            return this;
        }

        public Builder withTaskId(int taskId) {
            log.taskId = taskId;

            return this;
        }

        public Builder withStatus(Status status) {
            log.status = status;

            return this;
        }

        public LOG build() {
            return log;
        }
    }
}
