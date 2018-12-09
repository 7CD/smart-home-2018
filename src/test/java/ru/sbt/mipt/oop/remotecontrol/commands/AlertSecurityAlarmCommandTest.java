package ru.sbt.mipt.oop.remotecontrol.commands;

import ru.sbt.mipt.oop.remotecontrol.SmartHomeRemoteControl;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlertSecurityAlarmCommandTest extends RemoteCommandTest {

    public AlertSecurityAlarmCommandTest() {
        super();
        remoteControl.setCommandOnButton(SmartHomeRemoteControl.Button.C, new AlertSecurityAlarmCommand(smartHome));
    }

    @Test
    public void execute() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        remoteControl.onButtonPressed("C");
        assertEquals("Alert!\r\n", output.toString());
    }
}