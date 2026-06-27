package ua.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    private int currentVersion;

    private final Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if (!versionHistoryMap.containsKey(rollbackVersion)) {
            return false;
        }

        currentVersion = rollbackVersion;
        deleteOldVersions();

        return true;
    }

    private void deleteOldVersions() {
        versionHistoryMap.entrySet().removeIf(entry -> entry.getKey() > currentVersion);
    }
}
