package ru.sbt.mipt.oop.homeelement.alarm;

/**
 * State pattern
 * and also Singleton
 */

class SecurityAlarmDeactivatedState extends SecurityAlarmState {

    private static SecurityAlarmDeactivatedState instance;

    private SecurityAlarmDeactivatedState(SecurityAlarm securityAlarm) {
        this.securityAlarm = securityAlarm;
    }

    public static SecurityAlarmDeactivatedState getInstance(SecurityAlarm securityAlarm) {
        if (instance == null) {
            instance = new SecurityAlarmDeactivatedState(securityAlarm);
        }
        return instance;
    }

    @Override
    public void activate(String password) {
        if (securityAlarm.checkPassword(password)) {
            securityAlarm.setState(SecurityAlarmActivatedState.getInstance(securityAlarm));
            System.out.println("Security alarm is activated.");
        } else {
            System.out.println("Can not activate security alarm: wrong password.");
        }
    }

    @Override
    void deactivate(String password) {
        //nothing to do
    }

    @Override
    public void alert() {
        securityAlarm.setState(SecurityAlarmAlertState.getInstance(securityAlarm));
        System.out.println("Alert!");
    }

    @Override
    public boolean isActivated() {
        return false;
    }
}
