package ua.javarush.task.task39.task3913.DAO;

import ua.javarush.task.task39.task3913.DTO.LogEntry;
import ua.javarush.task.task39.task3913.Event;
import ua.javarush.task.task39.task3913.Status;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogReader {
    private final Path LOGS_PATH;
    private final List<LogEntry> logs;

    public LogReader(Path logPath){
        this.LOGS_PATH = logPath;
        this.logs = new ArrayList<>();

        readFile();
    }

    private void readFile() {
        try (BufferedReader reader = Files.newBufferedReader(LOGS_PATH)) {
            String line;

            while ((line = reader.readLine()) != null) {
                LogEntry logEntry = parseLogLine(line);

                if (logEntry != null) {
                    logs.add(logEntry);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private LogEntry parseLogLine(String line) {
        if (line == null || line.isEmpty()) return null;

        String[] parts = line.split("\\t");

        if (parts.length < 5) return null;

        try {
            String ip = parts[0].trim();
            String user = parts[1].trim();
            Date date = parseDate(parts[2].trim());
            String eventFull = parts[3].trim();

            Event event;
            int taskNumber = 0;

            if (eventFull.contains(" ")) {
                String[] eventParts = eventFull.split("\\s+");
                event = Event.valueOf(eventParts[0]);
                taskNumber = Integer.parseInt(eventParts[1]);
            } else {
                event = Event.valueOf(eventFull);
            }

            Status status = Status.valueOf(parts[4].trim());

            return new LogEntry(ip, user, date, event, taskNumber, status);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    private Date parseDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("d.M.yyyy H:m:s");

        return formatter.parse(date);
    }

    public List<LogEntry> getLogs() {
        return logs;
    }
}
