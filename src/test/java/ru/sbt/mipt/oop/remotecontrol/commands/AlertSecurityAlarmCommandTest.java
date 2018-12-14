package ru.sbt.mipt.oop.remotecontrol.commands;

import ru.sbt.mipt.oop.remotecontrol.SmartHomeRemoteControl;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlertSecurityAlarmCommandTest extends RemoteCommandTest {

    public AlertSecurityAlarmCommandTest() {
        super();
    }

    @Test
    public void execute() {
        assertFalse(smartHome.getSecurityAlarm().isActivated());
        remoteControl.setCommandOnButton(SmartHomeRemoteControl.Button.C, new AlertSecurityAlarmCommand(smartHome));
        remoteControl.onButtonPressed("C");
        assertTrue(smartHome.getSecurityAlarm().isActivated());
    }
}