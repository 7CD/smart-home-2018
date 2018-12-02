package ru.sbt.mipt.oop.homeelement.alarm;

public class SecurityAlarm {

    private SecurityAlarmState securityAlarmState; // State pattern
    String password;

    public SecurityAlarm() {
        securityAlarmState = SecurityAlarmDeactivatedState.getInstance(this);
    }

    public void setPassword(String oldPassword, String newPassword) {
        if (oldPassword == password) {
            this.password = newPassword;
            System.out.println("Alarm security password has been changed.");
        } else {
            System.out.println("Can not change alarm security password: wrong old password.");
        }
    }

    public boolean checkPassword (String password) {
        return this.password == null || this.password.equals(password);
    }

    void setState(SecurityAlarmState securityAlarmState) {
        this.securityAlarmState = securityAlarmState;
    }

    public void activate(String password) {
        securityAlarmState.activate(password);
    }

    public void deactivate(String password) {
        securityAlarmState.deactivate(password);

    }

    public void alert() {
        securityAlarmState.alert();
    }

    public boolean isActivated() {
        return securityAlarmState.isActivated();
    }
}
