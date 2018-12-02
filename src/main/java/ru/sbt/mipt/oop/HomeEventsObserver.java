package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.events.eventprocessor.EventProcessor;
import ru.sbt.mipt.oop.events.sensoreventprovider.RandomSensorEventProvider;
import ru.sbt.mipt.oop.events.sensoreventprovider.SensorEventProvider;
import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.homeelement.SmartHome;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Шаблон Observer. Играет роль Observable.
 * Cам генерирует события, происходящие в доме, и опевещает об их наступлении
 * закрепленных за ним наблюдателей типа EventProcessor.
 */

public class HomeEventsObserver {

    private SmartHome smartHome;
    private SensorEventProvider sensorEventProvider;
    private Collection<EventProcessor> eventProcessors = new ArrayList<>();

    public HomeEventsObserver(SmartHome smartHome) {
        this.smartHome = smartHome;
        sensorEventProvider = new RandomSensorEventProvider(smartHome);
    }

    public HomeEventsObserver(SmartHome smartHome,
                              Class<? extends SensorEventProvider> eventProviderClass) throws Exception {
        this.smartHome = smartHome;
        sensorEventProvider = eventProviderClass.getConstructor(SmartHome.class).newInstance(smartHome);
    }

    public void registerEventProcessor(EventProcessor eventProcessor) {
        eventProcessors.add(eventProcessor);
    }

    public void runEventsCycle() {
        SensorEvent event = sensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, event);
            }
            event = sensorEventProvider.getNextSensorEvent();
        }
    }
}
