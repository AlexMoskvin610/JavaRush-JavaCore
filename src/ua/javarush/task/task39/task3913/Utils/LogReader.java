package ua.javarush.task.task39.task3913.Utils;

import ua.javarush.task.task39.task3913.DTO.LOG;
import ua.javarush.task.task39.task3913.Event;
import ua.javarush.task.task39.task3913.Status;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LogReader {
    private final Path LOG_PATH;
    private final List<LOG> logList;

    public LogReader(Path logPath){
        this.LOG_PATH = logPath;
        this.logList = new ArrayList<>();

        mapToLOGList();
    }

    private List<String[]> readLogs() {
        List<String[]> logs = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(LOG_PATH)) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    logs.add(line.split("\\t"));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return logs;
    }

    private void mapToLOGList() {
        for (String[] log : readLogs()) {
            LOG logDTO = LOG.builder()
                    .withIp(log[0])
                    .withUser(log[1])
                    .withDate(log[2])
                    .withStatus(Status.valueOf(log[4]))
                    .build();
            parseIvent(log, logDTO);

            logList.add(logDTO);
        }
    }

    private void parseIvent(String[] log, LOG logDTO) {
        String event = log[3];
        int taskNumber;

        if (event.contains(" ")) {
            String [] data = event.split(" ");

            event = data[0];
            taskNumber = Integer.parseInt(data[1]);
        } else {
            taskNumber = 0;
        }

        logDTO.setEvent(Event.valueOf(event));
        logDTO.setTaskId(taskNumber);
    }

    public List<LOG> getLogList() {
        return logList;
    }
}
