package ru.sbt.mipt.oop.homeelement;

import ru.sbt.mipt.oop.*;

import ru.sbt.mipt.oop.homeelement.alarm.SecurityAlarm;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Хранит состояние дома - состояния всех дверей и лампочек в комнатах.
 * метод-выключение всех лампочек.
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

    public void turnOffLights() {
        for (Room homeRoom : getRooms()) {
            for (Light light : homeRoom.getLights()) {
                light.turnOff();
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                SensorCommandExecutor.executeCommand(command);
            }
        }
    }
}
