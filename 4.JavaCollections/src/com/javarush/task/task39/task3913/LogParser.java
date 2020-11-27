package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> ips = new HashSet<>();

        for (Log log : logs) {
            if (isDateInRange(log.date, after, before)) {
                ips.add(log.ip);
            }
        }
        return ips;
    }

    public Set<String> getIPsForDate(Date date, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> ips = new HashSet<>();

        for (Log log : logs) {
            if (log.date.equals(date) && isDateInRange(log.date, after, before)) {
                ips.add(log.ip);
            }
        }
        return ips;
    }


    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> ips = new HashSet<>();

        for (Log log : logs) {
            if (log.user.equals(user) && isDateInRange(log.date, after, before)) {
                ips.add(log.ip);
            }
        }

        return ips;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> ips = new HashSet<>();

        for (Log log : logs) {
            if (log.event.equals(event) && isDateInRange(log.date, after, before)) {
                ips.add(log.ip);
            }
        }

        return ips;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> ips = new HashSet<>();

        for (Log log : logs) {
            if (log.status.equals(status) && isDateInRange(log.date, after, before)) {
                ips.add(log.ip);
            }
        }

        return ips;
    }

    @Override
    public Set<String> getAllUsers() {
        ArrayList<Log> logs = getLogs();
        HashSet<String> users = new HashSet<>();

        for (Log log : logs) {
            users.add(log.user);
        }

        return users;
    }


    @Override
    public int getNumberOfUsers(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> users = new HashSet<>();

        for (Log log : logs) {
            if (isDateInRange(log.date, after, before)) {
                users.add(log.user);
            }
        }

        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Event> events = new HashSet<>();

        for (Log log : logs) {
            if (log.user.equals(user) && isDateInRange(log.date, after, before)) {
                events.add(log.event);
            }
        }

        return events.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> users = new HashSet<>();

        for (Log log : logs) {
            if (log.ip.equals(ip) && isDateInRange(log.date, after, before)) {
                users.add(log.user);
            }
        }

        return users;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> users = new HashSet<>();

        for (Log log : logs) {
            if (log.event == Event.LOGIN && isDateInRange(log.date, after, before)) {
                users.add(log.user);
            }
        }

        return users;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> users = new HashSet<>();

        for (Log log : logs) {
            if (log.event == Event.DOWNLOAD_PLUGIN && isDateInRange(log.date, after, before)) {
                users.add(log.user);
            }
        }

        return users;

    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> users = new HashSet<>();

        for (Log log : logs) {
            if (log.event == Event.WRITE_MESSAGE && isDateInRange(log.date, after, before)) {
                users.add(log.user);
            }
        }

        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> users = new HashSet<>();

        for (Log log : logs) {
            if (log.event == Event.SOLVE_TASK && isDateInRange(log.date, after, before)) {
                users.add(log.user);
            }
        }

        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> users = new HashSet<>();

        for (Log log : logs) {
            if (log.event == Event.SOLVE_TASK && log.task == task && isDateInRange(log.date, after, before)) {
                users.add(log.user);
            }
        }

        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> users = new HashSet<>();

        for (Log log : logs) {
            if (log.event == Event.DONE_TASK && isDateInRange(log.date, after, before)) {
                users.add(log.user);
            }
        }

        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> users = new HashSet<>();

        for (Log log : logs) {
            if (log.event == Event.DONE_TASK && log.task == task && isDateInRange(log.date, after, before)) {
                users.add(log.user);
            }
        }

        return users;
    }

    public Set<String> getUsersForDate(Date date, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> users = new HashSet<>();

        for (Log log : logs) {
            if (log.date.equals(date) && isDateInRange(log.date, after, before)) {
                users.add(log.user);
            }
        }

        return users;
    }

    public Set<String> getUsersForEvent(Event event, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> users = new HashSet<>();

        for (Log log : logs) {
            if (log.event.equals(event) && isDateInRange(log.date, after, before)) {
                users.add(log.user);
            }
        }

        return users;
    }

    public Set<String> getUsersForStatus(Status status, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<String> users = new HashSet<>();

        for (Log log : logs) {
            if (log.status.equals(status) && isDateInRange(log.date, after, before)) {
                users.add(log.user);
            }
        }

        return users;
    }

    public Set<Date> getAllDate(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Date> dates = new HashSet<>();

        for (Log log : logs) {
            if (isDateInRange(log.date, after, before)) {
                dates.add(log.date);
            }
        }

        return dates;
    }

    public Set<Date> getDatesForIP(String ip, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Date> dates = new HashSet<>();

        for (Log log : logs) {
            if (log.ip.equals(ip) && isDateInRange(log.date, after, before)) {
                dates.add(log.date);
            }
        }

        return dates;
    }

    public Set<Date> getDatesForUser(String user, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Date> dates = new HashSet<>();

        for (Log log : logs) {
            if (log.user.equals(user) && isDateInRange(log.date, after, before)) {
                dates.add(log.date);
            }
        }

        return dates;
    }

    public Set<Date> getDatesForEvent(Event event, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        SortedSet<Date> dates = new TreeSet<Date>();

        for (Log log : logs) {
            if (log.event == event && isDateInRange(log.date, after, before)) {
                dates.add(log.date);
            }
        }

        return dates;
    }

    public Set<Date> getDatesForStatus(Status status, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        SortedSet<Date> dates = new TreeSet<Date>();

        for (Log log : logs) {
            if (log.status == status && isDateInRange(log.date, after, before)) {
                dates.add(log.date);
            }
        }

        return dates;
    }


    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Date> dates = new HashSet<>();

        for (Log log : logs) {
            if (log.user.equals(user) && log.event == event && isDateInRange(log.date, after, before)) {
                dates.add(log.date);
            }
        }

        return dates;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Date> dates = new HashSet<>();

        for (Log log : logs) {
            if (log.status == Status.FAILED && isDateInRange(log.date, after, before)) {
                dates.add(log.date);
            }
        }

        return dates;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Date> dates = new HashSet<>();

        for (Log log : logs) {
            if (log.status == Status.ERROR && isDateInRange(log.date, after, before)) {
                dates.add(log.date);
            }
        }

        return dates;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        SortedSet<Date> dates = new TreeSet<Date>();

        for (Log log : logs) {
            if (log.user.equals(user) && log.event == Event.LOGIN && isDateInRange(log.date, after, before)) {
                dates.add(log.date);
            }
        }
        return dates.size() == 0 ? null : dates.first();
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        SortedSet<Date> dates = new TreeSet<Date>();

        for (Log log : logs) {
            if (log.user.equals(user) && log.event == Event.SOLVE_TASK && log.task == task && isDateInRange(log.date, after, before)) {
                dates.add(log.date);
            }
        }

        return dates.size() == 0 ? null : dates.first();
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        SortedSet<Date> dates = new TreeSet<Date>();

        for (Log log : logs) {
            if (log.user.equals(user) && log.event == Event.DONE_TASK && log.task == task && isDateInRange(log.date, after, before)) {
                dates.add(log.date);
            }
        }

        return dates.size() == 0 ? null : dates.first();
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Date> dates = new HashSet<>();

        for (Log log : logs) {
            if (log.user.equals(user) && log.event == Event.WRITE_MESSAGE && isDateInRange(log.date, after, before)) {
                dates.add(log.date);
            }
        }

        return dates;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Date> dates = new HashSet<>();

        for (Log log : logs) {
            if (log.user.equals(user) && log.event == Event.DOWNLOAD_PLUGIN && isDateInRange(log.date, after, before)) {
                dates.add(log.date);
            }
        }

        return dates;
    }

    public Set<Event> getEventsForDate(Date date, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Event> events = new HashSet<>();

        for (Log log : logs) {
            if (log.date.equals(date) && isDateInRange(log.date, after, before)) {
                events.add(log.event);
            }
        }

        return events;
    }


    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Event> events = new HashSet<>();

        for (Log log : logs) {
            if (isDateInRange(log.date, after, before)) {
                events.add(log.event);
            }
        }

        return events;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Event> events = new HashSet<>();

        for (Log log : logs) {
            if (log.ip.equals(ip) && isDateInRange(log.date, after, before)) {
                events.add(log.event);
            }
        }

        return events;
    }

    public Set<Event> getEventsForStatus(Status status, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Event> events = new HashSet<>();

        for (Log log : logs) {
            if (log.status == status && isDateInRange(log.date, after, before)) {
                events.add(log.event);
            }
        }

        return events;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Event> events = new HashSet<>();

        for (Log log : logs) {
            if (log.user.equals(user) && isDateInRange(log.date, after, before)) {
                events.add(log.event);
            }
        }

        return events;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Event> events = new HashSet<>();

        for (Log log : logs) {
            if (log.status == Status.FAILED && isDateInRange(log.date, after, before)) {
                events.add(log.event);
            }
        }

        return events;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Event> events = new HashSet<>();

        for (Log log : logs) {
            if (log.status == Status.ERROR && isDateInRange(log.date, after, before)) {
                events.add(log.event);
            }
        }

        return events;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        int count = 0;
        for (Log log : logs) {
            if (log.task == task && log.event == Event.SOLVE_TASK && isDateInRange(log.date, after, before)) {
                count++;
            }
        }

        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        int count = 0;

        for (Log log : logs) {
            if (log.task == task && log.event == Event.DONE_TASK && isDateInRange(log.date, after, before)) {
                count++;
            }
        }

        return count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        HashMap<Integer, Integer> allSolvedTasksAndTheirNumber = new HashMap<>();
        HashSet<Integer> tasks = getAllTasks();

        for (Integer task : tasks) {
            int count = getNumberOfAttemptToSolveTask(task, after, before);
            if (count > 0) {
                allSolvedTasksAndTheirNumber.put(task, count);
            }
        }

        return allSolvedTasksAndTheirNumber;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        HashMap<Integer, Integer> allDoneTasksAndTheirNumber = new HashMap<>();
        HashSet<Integer> tasks = getAllTasks();


        for (Integer task : tasks) {
            int count = getNumberOfSuccessfulAttemptToSolveTask(task, after, before);
            if (count > 0) {
                allDoneTasksAndTheirNumber.put(task, count);
            }
        }

        return allDoneTasksAndTheirNumber;
    }

    public Set<Status> getAllStatus(Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Status> statuses = new HashSet<>();

        for (Log log : logs) {
            if (isDateInRange(log.date, after, before)) {
                statuses.add(log.status);
            }
        }

        return statuses;
    }

    public Set<Status> getStatusForIp(String ip, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Status> statuses = new HashSet<>();

        for (Log log : logs) {
            if (log.ip.equals(ip) && isDateInRange(log.date, after, before)) {
                statuses.add(log.status);
            }
        }

        return statuses;
    }

    public Set<Status> getStatusForUser(String user, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Status> statuses = new HashSet<>();

        for (Log log : logs) {
            if (log.user.equals(user) && isDateInRange(log.date, after, before)) {
                statuses.add(log.status);
            }
        }

        return statuses;
    }

    public Set<Status> getStatusForDate(Date date, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Status> statuses = new HashSet<>();

        for (Log log : logs) {
            if (log.date.equals(date) && isDateInRange(log.date, after, before)) {
                statuses.add(log.status);
            }
        }

        return statuses;
    }

    public Set<Status> getStatusForEvent(Event event, Date after, Date before) {
        ArrayList<Log> logs = getLogs();
        HashSet<Status> statuses = new HashSet<>();

        for (Log log : logs) {
            if (log.event == event && isDateInRange(log.date, after, before)) {
                statuses.add(log.status);
            }
        }

        return statuses;
    }


    public ArrayList<Log> getLogs() {
        ArrayList<Log> logs = new ArrayList<>();
        BufferedReader bufferedReader = null;
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy HH:mm:ss");

        try {
            for (File file : logDir.toFile().listFiles()) {
                if (file.getName().endsWith(".log")) {
                    bufferedReader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        String[] params = line.split("\\t");
                        String ip = params[0];
                        String userFromLog = params[1];
                        Date date = format.parse(params[2]);
                        Event event = getEvent(params[3].split(" ")[0]);
                        int task = -1;
                        if (event == Event.DONE_TASK || event == Event.SOLVE_TASK) {
                            task = Integer.parseInt(params[3].split(" ")[1]);
                        }
                        Status status = getStatus(params[4]);

                        logs.add(new Log(ip, userFromLog, date, event, task, status));
                    }
                }
            }
            bufferedReader.close();
        } catch (Exception e) {

        }
        return logs;
    }


    public boolean isDateInRange(Date date, Date after, Date before) {
        if (after == null && before == null) {
            return true;
        } else if (after == null) {
            if (date.before(before)) {
                return true;
            }
        } else if (before == null) {
            if (date.after(after)) {
                return true;
            }
        } else {
            if (date.after(after) && date.before(before)) {
                return true;
            }
        }
        return false;
    }

    public HashSet<Integer> getAllTasks() {
        ArrayList<Log> logs = getLogs();
        HashSet<Integer> tasks = new HashSet<>();

        for (Log log : logs) {
            tasks.add(log.task);
        }
        tasks.remove(-1);

        return tasks;
    }

    @Override
    public Set<Object> execute(String query) {
        String field1 = getField1(query);
        String field2 = getField2(query);
        String value1 = getValue1(query);
        Date date = getDate(value1);
        Date after = getDateAfter(query);
        Date before = getDateBefore(query);

        if (field2 == null) {
            switch (field1) {
                case ("ip"):
                    return new HashSet<>(getUniqueIPs(after, before));
                case ("user"):
                    return new HashSet<>(getAllUsers());
                case ("date"):
                    return new HashSet<>(getAllDate(after, before));
                case ("event"):
                    return new HashSet<>(getAllEvents(after, before));
                case ("status"):
                    return new HashSet<>(getAllStatus(after, before));
            }
        }
        switch (field1) {
            case ("ip"):
                switch (field2) {
                    case ("user"):
                        return new HashSet<>(getIPsForUser(value1, after, before));
                    case ("date"):
                        return new HashSet<>(getIPsForDate(date, after, before));
                    case ("event"):
                        return new HashSet<>(getIPsForEvent(getEvent(value1), after, before));
                    case ("status"):
                        return new HashSet<>(getIPsForStatus(getStatus(value1), after, before));
                }
            case ("user"):
                switch (field2) {
                    case ("ip"):
                        return new HashSet<>(getUsersForIP(value1, after, before));
                    case ("date"):
                        return new HashSet<>(getUsersForDate(date, after, before));
                    case ("event"):
                        return new HashSet<>(getUsersForEvent(getEvent(value1), after, before));
                    case ("status"):
                        return new HashSet<>(getUsersForStatus(getStatus(value1), after, before));
                }
            case ("date"):
                switch (field2) {
                    case ("ip"):
                        return new HashSet<>(getDatesForIP(value1, after, before));
                    case ("user"):
                        return new HashSet<>(getDatesForUser(value1, after, before));
                    case ("event"):
                        return new HashSet<>(getDatesForEvent(getEvent(value1), after, before));
                    case ("status"):
                        return new HashSet<>(getDatesForStatus(getStatus(value1), after, before));
                }
            case ("event"):
                switch (field2) {
                    case ("ip"):
                        return new HashSet<>(getEventsForIP(value1, after, before));
                    case ("date"):
                        return new HashSet<>(getEventsForDate(date, after, before));
                    case ("user"):
                        return new HashSet<>(getEventsForUser(value1, after, before));
                    case ("status"):
                        return new HashSet<>(getEventsForStatus(getStatus(value1), after, before));
                }
            case ("status"):
                switch (field2) {
                    case ("ip"):
                        return new HashSet<>(getStatusForIp(value1, after, before));
                    case ("date"):
                        return new HashSet<>(getStatusForDate(date, after, before));
                    case ("user"):
                        return new HashSet<>(getStatusForUser(value1, after, before));
                    case ("event"):
                        return new HashSet<>(getStatusForEvent(getEvent(value1), after, before));
                }
        }
        return null;
    }

    public String getField1(String query) {
        String[] notSplitedParams = query.split("=");
        String field1 = notSplitedParams[0].split(" ")[1];
        return field1;
    }

    public String getField2(String query) {
        String[] notSplitedParams = query.split("=");
        String[] params = notSplitedParams[0].split(" ");
        if (params.length == 4) {
            String field2 = params[3];
            return field2;
        }
        return null;
    }

    public String getValue1(String query) {
        String[] notSplitedParams = query.split("=");
        if (notSplitedParams.length == 2) {
            String value1 = notSplitedParams[1].split("and")[0].replaceAll("\"", "").trim();
            return value1;
        }
        return null;
    }

    public Event getEvent(String eventStr) {
        for (Event eventIter : Event.values()) {
            if (eventIter.toString().equals(eventStr)) {
                return eventIter;
            }
        }
        return null;
    }

    public Status getStatus(String statusStr) {
        for (Status statusIter : Status.values()) {
            if (statusIter.toString().equals(statusStr)) {
                return statusIter;
            }
        }
        return null;
    }

    public Date getDate(String dateStr) {
        if (dateStr == null) {
            return null;
        }
        Date date = null;
        dateStr.trim().replaceAll("\"", "");

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
        }
        return date;
    }

    public Date getDateAfter(String query) {
        try {
            String[] notSplitedParams = query.split("between");
            String afterStr = notSplitedParams[1].split("and")[0].trim().replaceAll("\"", "");
            return getDate(afterStr);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public Date getDateBefore(String query) {
        try {
            String[] notSplitedParams = query.split("between");
            String afterStr = notSplitedParams[1].split("and")[1].trim().replaceAll("\"", "");
            return getDate(afterStr);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

}