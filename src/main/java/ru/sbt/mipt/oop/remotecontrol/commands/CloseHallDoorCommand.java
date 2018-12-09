package ru.sbt.mipt.oop.remotecontrol.commands;

import ru.sbt.mipt.oop.homeelement.SmartHome;
import ru.sbt.mipt.oop.homeelement.Door;
import ru.sbt.mipt.oop.homeelement.Room;

public class CloseHallDoorCommand implements Command {

    private final SmartHome smartHome;

    public CloseHallDoorCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Door door : room.getDoors()) {
                    door.close();
                }
                new TurnAllLightsOffCommand(smartHome).execute();
            }
        }
    }
}
