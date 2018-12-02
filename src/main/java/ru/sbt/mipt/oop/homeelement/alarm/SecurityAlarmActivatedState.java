package ru.sbt.mipt.oop.homeelement.alarm;

/**
 * State pattern
 * and also Singleton
 */

class SecurityAlarmActivatedState extends SecurityAlarmState {

    private static SecurityAlarmActivatedState instance;

    private SecurityAlarmActivatedState(SecurityAlarm securityAlarm) {
        this.securityAlarm = securityAlarm;
    }

    public static SecurityAlarmActivatedState getInstance(SecurityAlarm securityAlarm) {
        if (instance == null) {
            instance = new SecurityAlarmActivatedState(securityAlarm);
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
            securityAlarm.alert();
        }
    }

    @Override
    public void alert() {
        securityAlarm.setState(SecurityAlarmAlertState.getInstance(securityAlarm));
        System.out.println("Alert!");
    }

    @Override
    public boolean isActivated() {
        return true;
    }
}
