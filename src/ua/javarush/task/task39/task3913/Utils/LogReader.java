package ua.javarush.task.task39.task3913.Utils;

import ua.javarush.task.task39.task3913.DTO.LogEntries;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LogReader {
    private final Path LOG_PATH;
    private final List<LogEntries> logEntriesList;

    public LogReader(Path logPath){
        this.LOG_PATH = logPath;
        this.logEntriesList = new ArrayList<>();
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
}
