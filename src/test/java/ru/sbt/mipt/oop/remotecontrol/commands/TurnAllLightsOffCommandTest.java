package ru.sbt.mipt.oop.remotecontrol.commands;

import ru.sbt.mipt.oop.homeelement.Light;
import ru.sbt.mipt.oop.homeelement.Room;
import ru.sbt.mipt.oop.remotecontrol.SmartHomeRemoteControl;
import org.junit.Test;
import static org.junit.Assert.*;

public class TurnAllLightsOffCommandTest extends RemoteCommandTest {

    public TurnAllLightsOffCommandTest() {
        super();
        remoteControl.setCommandOnButton(SmartHomeRemoteControl.Button.TWO, new TurnAllLightsOffCommand(smartHome));
    }

    @Test
    public void execute() {
        remoteControl.onButtonPressed("2");
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                assertFalse(light.isOn());
            }
        }
    }
}