package ru.sbt.mipt.oop.events.eventprocessor;

import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.homeelement.Light;
import ru.sbt.mipt.oop.homeelement.Room;
import ru.sbt.mipt.oop.homeelement.SmartHome;

import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.LIGHT_ON;

public class LightsEventProcessor implements EventProcessor {

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isLightEvent(event)) return;

        smartHome.execute((homeComponent, homeComponentParent) -> {
            if (!(homeComponent instanceof Light)) return;

            Light light = (Light) homeComponent;

            if (!light.getId().equals(event.getObjectId())) return;

            Room room = (Room) homeComponentParent;

            if (event.getType() == LIGHT_ON) {
                light.turnOn();
                System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
            } else {
                light.turnOff();
                System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
            }
        }, null);
    }

    private boolean isLightEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }
}
