package ru.sbt.mipt.oop.events.eventprocessor;

import ru.sbt.mipt.oop.homeelement.SmartHome;
import ru.sbt.mipt.oop.homeloader.FileSmartHomeLoader;
import ru.sbt.mipt.oop.homeloader.SmartHomeLoader;
import java.io.IOException;

public abstract class EventProcessorTest {

    protected SmartHome smartHome;

    protected EventProcessor eventProcessor;

    public EventProcessorTest() {
        try {
            SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader("smart-home-1.js");
            smartHome = smartHomeLoader.loadSmartHome();
        } catch (IOException e) {

        }
    }
}
