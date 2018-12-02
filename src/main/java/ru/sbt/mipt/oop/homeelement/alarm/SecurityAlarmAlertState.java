package ru.sbt.mipt.oop.homeelement.alarm;

/**
 * State pattern
 * and also Singleton
 */

class SecurityAlarmAlertState extends SecurityAlarmState {

    private static SecurityAlarmAlertState instance;

    private SecurityAlarmAlertState(SecurityAlarm securityAlarm) {
        this.securityAlarm = securityAlarm;
    }

    public static SecurityAlarmAlertState getInstance(SecurityAlarm securityAlarm) {
        if (instance == null) {
            instance = new SecurityAlarmAlertState(securityAlarm);
        }
        return instance;
    }

    @Override
    public void activate(String password) {
        //nothing to do
    }

    @Override
    void deactivate(String password) {
        if (securityAlarm.checkPassword(password)) {
            securityAlarm.setState(SecurityAlarmDeactivatedState.getInstance(securityAlarm));
            System.out.println("Security alarm is deactivated.");
        } else {
            System.out.println("Wrong password!");
        }
    }

    @Override
    public void alert() {
        //nothing to do
    }

    @Override
    public boolean isActivated() {
        return true;
    }
}
