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
import ru.sbt.mipt.oop.remotecontrol.RemoteControlRegistry;
import ru.sbt.mipt.oop.remotecontrol.SmartHomeRemoteControl;
import ru.sbt.mipt.oop.remotecontrol.SmartHomeRemoteControl.Button;
import ru.sbt.mipt.oop.remotecontrol.commands.*;

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

        RemoteControlRegistry remoteControlRegistry = new RemoteControlRegistry();

        SmartHomeRemoteControl remoteControl = new SmartHomeRemoteControl();
        remoteControl.setCommandOnButton(Button.A, new ActivateSecurityAlarmCommand(smartHome, null));
        remoteControl.setCommandOnButton(Button.B, new AlertSecurityAlarmCommand(smartHome));
        remoteControl.setCommandOnButton(Button.ONE, new TurnAllLightsOnCommand(smartHome));
        remoteControl.setCommandOnButton(Button.TWO, new TurnAllLightsOffCommand(smartHome));
        remoteControl.setCommandOnButton(Button.THREE, new CloseHallDoorCommand(smartHome));
        remoteControlRegistry.registerRemoteControl(remoteControl, "1");
    }

    @Bean
    EventsManager sensorEventsManager() {
        HomeEventsObserver eventsManager = new HomeEventsObserver(smartHome);
//        CoolCoEventsManagerAdapter eventsManager = new CoolCoEventsManagerAdapter(smartHome);

        eventsManager.registerEventProcessor(new AlarmEventProcessor());
        eventsManager.registerEventProcessor(new LightsEventProcessor());
        eventsManager.registerEventProcessor(new DoorEventProcessor());
        eventsManager.registerEventProcessor(new HallDoorEventProcessor());

        return eventsManager;
    }
}
