package ru.sbt.mipt.oop.events.eventprocessor;

import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.homeelement.SmartHome;

import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.ALARM_ACTIVATED;
import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.ALARM_DEACTIVATED;

public class AlarmEventProcessor implements EventProcessor {

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isAlarmEvent(event)) {
            if (smartHome.getSecurityAlarm().isActivated()) {
                smartHome.getSecurityAlarm().alert();
                System.out.print("Sending sms: Somebody is in the house. ");
            }
        } else if (event.getType() == ALARM_ACTIVATED) {
            smartHome.getSecurityAlarm().activate(null);
        } else {
            smartHome.getSecurityAlarm().deactivate(null);
        }
    }

    private boolean isAlarmEvent(SensorEvent event) {
        return event.getType() == ALARM_ACTIVATED || event.getType() == ALARM_DEACTIVATED;
    }
}
