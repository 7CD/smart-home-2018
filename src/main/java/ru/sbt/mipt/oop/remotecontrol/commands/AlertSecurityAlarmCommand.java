package ru.sbt.mipt.oop.remotecontrol.commands;

import ru.sbt.mipt.oop.homeelement.SmartHome;

public class AlertSecurityAlarmCommand implements Command {

    private final SmartHome smartHome;

    public AlertSecurityAlarmCommand(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.getSecurityAlarm().alert();
    }
}
