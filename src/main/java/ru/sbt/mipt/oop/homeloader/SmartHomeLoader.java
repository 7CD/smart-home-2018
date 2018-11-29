package ru.sbt.mipt.oop.homeloader;

import ru.sbt.mipt.oop.homeelement.SmartHome;

import java.io.IOException;

public interface SmartHomeLoader {

    SmartHome loadSmartHome() throws IOException;
}
