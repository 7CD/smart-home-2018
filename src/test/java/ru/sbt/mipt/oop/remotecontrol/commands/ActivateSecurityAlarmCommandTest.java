package ru.sbt.mipt.oop.remotecontrol.commands;

import ru.sbt.mipt.oop.remotecontrol.SmartHomeRemoteControl;
import org.junit.Test;
import static org.junit.Assert.*;

public class ActivateSecurityAlarmCommandTest extends RemoteCommandTest {

    public ActivateSecurityAlarmCommandTest() {
        super();
    }

    @Test
    public void execute() {
        assertFalse(smartHome.getSecurityAlarm().isActivated());
        remoteControl.setCommandOnButton(SmartHomeRemoteControl.Button.B, new ActivateSecurityAlarmCommand(smartHome, null));
        remoteControl.onButtonPressed("B");
        assertTrue(smartHome.getSecurityAlarm().isActivated());
    }
}