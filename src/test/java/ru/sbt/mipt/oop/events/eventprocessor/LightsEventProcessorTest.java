package ru.sbt.mipt.oop.events.eventprocessor;

import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.*;
import org.junit.Test;
import ru.sbt.mipt.oop.homeelement.Light;
import ru.sbt.mipt.oop.homeelement.Room;
import java.util.NoSuchElementException;

public class LightsEventProcessorTest extends EventProcessorTest {

    public LightsEventProcessorTest() {
        super();
        eventProcessor = new LightsEventProcessor();
    }

    @Test
    public void processLightOnTest() {
        assertFalse(isLightOn("1"));
        SensorEvent lightOnEvent = new SensorEvent(LIGHT_ON, "1");
        eventProcessor.processEvent(smartHome, lightOnEvent);
        assertTrue(isLightOn("1"));
    }

    @Test
    public void processLightOffTest() {
        assertTrue(isLightOn("2"));
        SensorEvent lightOnEvent = new SensorEvent(LIGHT_OFF, "2");
        eventProcessor.processEvent(smartHome, lightOnEvent);
        assertFalse(isLightOn("1"));
    }

    private boolean isLightOn(String id) {
        for (Room room : smartHome.getRooms())
            for (Light light : room.getLights())
                if (light.getId().equals(id))
                    return light.isOn();
        throw new NoSuchElementException();
    }
}
