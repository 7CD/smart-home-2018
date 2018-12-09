package ru.sbt.mipt.oop.remotecontrol.commands;

import ru.sbt.mipt.oop.homeelement.Door;
import ru.sbt.mipt.oop.homeelement.Light;
import ru.sbt.mipt.oop.homeelement.Room;
import ru.sbt.mipt.oop.remotecontrol.SmartHomeRemoteControl;
import org.junit.Test;
import static org.junit.Assert.*;

public class CloseHallDoorCommandTest extends RemoteCommandTest {

    public CloseHallDoorCommandTest() {
        super();
        remoteControl.setCommandOnButton(SmartHomeRemoteControl.Button.A, new CloseHallDoorCommand(smartHome));
    }

    @Test
    public void execute() {
        remoteControl.onButtonPressed("A");
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Door door : room.getDoors()) {
                    assertFalse(door.isOpen());
                }
            }
            for (Light light : room.getLights()) {
                assertFalse(light.isOn());
            }
        }
    }
}