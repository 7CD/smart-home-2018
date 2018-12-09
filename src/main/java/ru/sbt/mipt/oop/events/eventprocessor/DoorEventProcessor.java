package ru.sbt.mipt.oop.events.eventprocessor;

import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.homeelement.Door;
import ru.sbt.mipt.oop.homeelement.Room;
import ru.sbt.mipt.oop.homeelement.SmartHome;

import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.DOOR_OPENED;

public class DoorEventProcessor implements EventProcessor {

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isDoorEvent(event)) return;

        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPENED) {
                        door.open();
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                    } else {
                        door.close();
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                    }
                }
            }
        }
    }

    private boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_OPENED || event.getType() == DOOR_CLOSED;
    }
}
