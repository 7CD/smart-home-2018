package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.eventmanager.CoolCoEventsManagerAdapter;
import ru.sbt.mipt.oop.eventmanager.EventsManager;
import ru.sbt.mipt.oop.eventmanager.HomeEventsObserver;
import ru.sbt.mipt.oop.events.eventprocessor.AlarmEventProcessor;
import ru.sbt.mipt.oop.events.eventprocessor.DoorEventProcessor;
import ru.sbt.mipt.oop.events.eventprocessor.HallDoorEventProcessor;
import ru.sbt.mipt.oop.events.eventprocessor.LightsEventProcessor;
import ru.sbt.mipt.oop.homeelement.SmartHome;
import ru.sbt.mipt.oop.homeloader.FileSmartHomeLoader;

import java.io.IOException;

@Configuration
public class HomeConfiguration {

    private SmartHome smartHome;

    public HomeConfiguration() {
        try {
            smartHome = new FileSmartHomeLoader("smart-home-1.js").loadSmartHome();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    EventsManager sensorEventsManager() {
//        HomeEventsObserver eventsManager = new HomeEventsObserver(smartHome);
        CoolCoEventsManagerAdapter eventsManager = new CoolCoEventsManagerAdapter(smartHome);

        eventsManager.registerEventProcessor(new LightsEventProcessor());
        eventsManager.registerEventProcessor(new DoorEventProcessor());
        eventsManager.registerEventProcessor(new HallDoorEventProcessor());
        eventsManager.registerEventProcessor(new AlarmEventProcessor());

        return eventsManager;
    }
}
