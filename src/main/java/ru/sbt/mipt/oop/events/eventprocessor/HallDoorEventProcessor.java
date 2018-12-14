package ru.sbt.mipt.oop.events.eventprocessor;

import ru.sbt.mipt.oop.homeelement.SmartHome;
import ru.sbt.mipt.oop.homeelement.Door;
import ru.sbt.mipt.oop.homeelement.Room;
import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.remotecontrol.commands.TurnAllLightsOffCommand;
import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.DOOR_CLOSED;

public class HallDoorEventProcessor implements EventProcessor {

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() != DOOR_CLOSED) return;

        smartHome.execute((homeComponent, homeComponentParent) -> {
            if (!(homeComponent instanceof Door)) return;

            Door door = (Door) homeComponent;

            if (!door.getId().equals(event.getObjectId())) return;

            Room room = (Room) homeComponentParent;

            if (room.getName().equals("hall")) {
                new TurnAllLightsOffCommand(smartHome).execute();
            }

        }, null);
    }
}
