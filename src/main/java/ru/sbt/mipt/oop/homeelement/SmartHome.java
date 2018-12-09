package ru.sbt.mipt.oop.homeelement;

import ru.sbt.mipt.oop.homeelement.alarm.SecurityAlarm;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Хранит состояние дома - состояния всех дверей и лампочек в комнатах.
 * А также сигнализацию.
 */

public class SmartHome {

    private Collection<Room> rooms;
    private SecurityAlarm securityAlarm = new SecurityAlarm();

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void setSecurityAlarm(SecurityAlarm securityAlarm) {
        this.securityAlarm = securityAlarm;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public SecurityAlarm getSecurityAlarm(){
        return securityAlarm;
    }
}
