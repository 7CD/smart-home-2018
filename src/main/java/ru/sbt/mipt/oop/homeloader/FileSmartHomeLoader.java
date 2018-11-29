package ru.sbt.mipt.oop.homeloader;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.homeelement.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSmartHomeLoader implements SmartHomeLoader {

    private final String path;

    public FileSmartHomeLoader(String path) {
        this.path = path;
    }

    public SmartHome loadSmartHome() throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(path)));
        return gson.fromJson(json, SmartHome.class);
    }
}
