package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.events.eventprocessor.AlarmEventProcessor;
import ru.sbt.mipt.oop.events.eventprocessor.DoorEventProcessor;
import ru.sbt.mipt.oop.events.eventprocessor.HallDoorEventProcessor;
import ru.sbt.mipt.oop.events.eventprocessor.LightsEventProcessor;
import ru.sbt.mipt.oop.homeelement.SmartHome;
import ru.sbt.mipt.oop.homeloader.FileSmartHomeLoader;
import ru.sbt.mipt.oop.homeloader.SmartHomeLoader;

import java.io.IOException;

public class Application {

/*    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
        sensorEventsManager.start();
    }*/


    public static void main(String... args) throws IOException {
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader("smart-home-1.js");
        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        HomeEventsObserver homeEventsObserver = new HomeEventsObserver(smartHome);
        homeEventsObserver.registerEventProcessor(new LightsEventProcessor());
        homeEventsObserver.registerEventProcessor(new DoorEventProcessor());
        homeEventsObserver.registerEventProcessor(new HallDoorEventProcessor());
        homeEventsObserver.registerEventProcessor(new AlarmEventProcessor());
        homeEventsObserver.runEventsCycle();
    }
}
