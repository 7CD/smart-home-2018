package ru.sbt.mipt.oop.eventmanager;

import org.junit.Test;
import ru.sbt.mipt.oop.events.eventprocessor.EventProcessor;
import ru.sbt.mipt.oop.events.sensoreventprovider.SensorEventProvider;
import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.events.sensorevents.SensorEventType;
import ru.sbt.mipt.oop.homeelement.SmartHome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HomeEventsObserverTest {

    private HomeEventsObserver homeEventsObserver;

    static final int N = 5;
    List<Integer> actual = new ArrayList<>();
    List<Integer> expected = new ArrayList<>();

    public HomeEventsObserverTest() {
        for (int i = 0; i < 2 * N; i++) {
            expected.add(i);
        }
    }

    @Test
    public void test() throws Exception {
        homeEventsObserver = new HomeEventsObserver(new SmartHome(), SimpleEventProvider.class);
        homeEventsObserver.registerEventProcessor(new SimpleEventProcessor1());
        homeEventsObserver.registerEventProcessor(new SimpleEventProcessor2());
        homeEventsObserver.runEventsCycle();
        assertEquals(expected, actual);
    }


    private class SimpleEventProcessor1 implements EventProcessor {

        private int count = 0;

        @Override
        public void processEvent(SmartHome smartHome, SensorEvent event) {
            actual.add(count);
            count += 2;
        }
    }

    private class SimpleEventProcessor2 implements EventProcessor {

        private int count = 1;

        @Override
        public void processEvent(SmartHome smartHome, SensorEvent event) {
            actual.add(count);
            count += 2;
        }
    }
}


class SimpleEventProvider implements SensorEventProvider {

    private int count = -1;
    SensorEvent sensorEvent = new SensorEvent(SensorEventType.LIGHT_ON, "1");

    public SimpleEventProvider(SmartHome smartHome) {
    }

    @Override
    public SensorEvent getNextSensorEvent() {
        count++;
        if (count < HomeEventsObserverTest.N) {
            return sensorEvent;
        }
        return null;
    }
}