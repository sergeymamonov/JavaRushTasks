package com.javarush.task.task39.task3913;

import java.util.Date;

public class Log {
    String ip;
    String user;
    Date date;
    Event event;
    int task;
    Status status;

    public Log(String ip, String userFromLog, Date date, Event event, int task, Status status) {
        this.ip = ip;
        this.user = userFromLog;
        this.date = date;
        this.event = event;
        this.task = task;
        this.status = status;
    }
}
