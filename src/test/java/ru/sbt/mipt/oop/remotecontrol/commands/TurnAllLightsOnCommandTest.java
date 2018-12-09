package ru.sbt.mipt.oop.remotecontrol.commands;

import ru.sbt.mipt.oop.homeelement.Light;
import ru.sbt.mipt.oop.homeelement.Room;
import ru.sbt.mipt.oop.remotecontrol.SmartHomeRemoteControl;
import org.junit.Test;
import static org.junit.Assert.*;

public class TurnAllLightsOnCommandTest extends RemoteCommandTest {

    public TurnAllLightsOnCommandTest() {
        super();
        remoteControl.setCommandOnButton(SmartHomeRemoteControl.Button.ONE, new TurnAllLightsOnCommand(smartHome));
    }

    @Test
    public void execute() {
        remoteControl.onButtonPressed("1");
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                assertTrue(light.isOn());
            }
        }
    }
}