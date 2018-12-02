package ru.sbt.mipt.oop.homeelement.alarm;

/**
 * State pattern
 */

abstract class SecurityAlarmState {

    protected SecurityAlarm securityAlarm;

    abstract void activate(String password);

    abstract void deactivate(String password);

    abstract void alert();

    abstract boolean isActivated();
}
