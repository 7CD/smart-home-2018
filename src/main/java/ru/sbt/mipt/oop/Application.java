package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.events.eventprocessor.DoorEventProcessor;
import ru.sbt.mipt.oop.events.eventprocessor.HallDoorEventProcessor;
import ru.sbt.mipt.oop.events.eventprocessor.LightsEventProcessor;
import ru.sbt.mipt.oop.homeelement.SmartHome;
import ru.sbt.mipt.oop.homeloader.FileSmartHomeLoader;
import ru.sbt.mipt.oop.homeloader.SmartHomeLoader;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader("smart-home-1.js");
        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        HomeEventsObserver homeEventsObserver = new HomeEventsObserver(smartHome);
        homeEventsObserver.registerEventProcessor(new LightsEventProcessor());
        homeEventsObserver.registerEventProcessor(new DoorEventProcessor());
        homeEventsObserver.registerEventProcessor(new HallDoorEventProcessor());
        homeEventsObserver.runEventsCycle();
    }
}
