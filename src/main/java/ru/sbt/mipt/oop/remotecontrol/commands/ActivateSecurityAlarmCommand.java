package ru.sbt.mipt.oop.remotecontrol.commands;

import ru.sbt.mipt.oop.homeelement.SmartHome;

public class ActivateSecurityAlarmCommand implements Command {

    private final SmartHome smartHome;
    private final String password;

    public ActivateSecurityAlarmCommand(SmartHome smartHome, String password) {
        this.smartHome = smartHome;
        this.password = password;
    }

    @Override
    public void execute() {
        smartHome.getSecurityAlarm().activate(password);
    }
}
