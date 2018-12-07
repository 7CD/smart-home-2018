package ru.sbt.mipt.oop.eventmanager;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.events.eventprocessor.EventProcessor;
import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.events.sensorevents.SensorEventType;
import ru.sbt.mipt.oop.homeelement.SmartHome;

import java.util.HashMap;
import java.util.Map;

public class CoolCoEventsManagerAdapter implements EventsManager {

    private SensorEventsManager coolCoEventsManager = new SensorEventsManager();

    private SmartHome smartHome;

    public CoolCoEventsManagerAdapter(SmartHome smartHome) {
        this.smartHome = smartHome;
    }

    @Override
    public void registerEventProcessor(EventProcessor eventProcessor) {
        EventHandler eventHandler = (event) ->
                eventProcessor.processEvent(smartHome, adaptEvent(event));
        coolCoEventsManager.registerEventHandler(eventHandler);
    }

    @Override
    public void runEventsCycle() {
        coolCoEventsManager.start();
    }

    private static Map<String, SensorEventType> eventTypeMap = new HashMap<>();
    static {
        eventTypeMap.put("LightIsOn", SensorEventType.LIGHT_ON);
        eventTypeMap.put("LightIsOff", SensorEventType.LIGHT_OFF);
        eventTypeMap.put("DoorIsOpen", SensorEventType.DOOR_OPENED);
        eventTypeMap.put("DoorIsClosed", SensorEventType.DOOR_CLOSED);
        eventTypeMap.put("DoorIsLocked", SensorEventType.ALARM_ACTIVATED);
        eventTypeMap.put("DoorIsUnlocked", SensorEventType.ALARM_DEACTIVATED);
    }

    private SensorEvent adaptEvent(CCSensorEvent coolCoEvent) {
        return new SensorEvent(eventTypeMap.get(coolCoEvent.getEventType()),
                coolCoEvent.getObjectId());
    }
}

