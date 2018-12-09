package ru.sbt.mipt.oop.remotecontrol.commands;

import ru.sbt.mipt.oop.homeelement.SmartHome;
import ru.sbt.mipt.oop.homeelement.Light;
import ru.sbt.mipt.oop.homeelement.Room;

public class TurnAllLightsOnCommand implements Command {

    private final SmartHome smartHome;

    public TurnAllLightsOnCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                light.turnOn();
            }
        }
        System.out.println("All the lights are turned on.");
    }
}
