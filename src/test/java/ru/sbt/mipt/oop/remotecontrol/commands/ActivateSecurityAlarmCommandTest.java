package ru.sbt.mipt.oop.remotecontrol.commands;

import ru.sbt.mipt.oop.remotecontrol.SmartHomeRemoteControl;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActivateSecurityAlarmCommandTest extends RemoteCommandTest {

    public ActivateSecurityAlarmCommandTest() {
        super();
        remoteControl.setCommandOnButton(SmartHomeRemoteControl.Button.B, new ActivateSecurityAlarmCommand(smartHome, null));
    }

    @Test
    public void execute() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        remoteControl.onButtonPressed("B");
        assertEquals("Security alarm is activated.\r\n", output.toString());
    }
}