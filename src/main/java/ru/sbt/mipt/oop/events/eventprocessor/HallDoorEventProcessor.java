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

        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    // если мы получили событие о закрытии двери в холле - это значит, что была закрыта входная дверь.
                    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                    if (room.getName().equals("hall")) {
                        new TurnAllLightsOffCommand(smartHome).execute();
                    }
                }
            }
        }
    }
}
