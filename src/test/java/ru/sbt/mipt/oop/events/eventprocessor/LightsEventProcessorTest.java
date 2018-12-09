package ru.sbt.mipt.oop.events.eventprocessor;

import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.*;
import org.junit.Test;

public class LightsEventProcessorTest extends EventProcessorTest {

    public LightsEventProcessorTest() {
        super();
        eventProcessor = new LightsEventProcessor();
    }

    @Test
    public void processNotLightsEventTest() {
        SensorEvent notLightEvent = new SensorEvent(DOOR_CLOSED, "1");
        String expected = "";
        test(notLightEvent, expected);
    }

    @Test
    public void processLightOnTest() {
        SensorEvent lightOnEvent = new SensorEvent(LIGHT_ON, "1");
        String expected = "Light 1 in room kitchen was turned on.\r\n";// or + System.lineSeparator();
        test(lightOnEvent, expected);
    }

    @Test
    public void processLightOffTest() {
        SensorEvent lightOffEvent = new SensorEvent(LIGHT_OFF, "1");
        String expected = "Light 1 in room kitchen was turned off.\r\n";
        test(lightOffEvent, expected);
    }
}
