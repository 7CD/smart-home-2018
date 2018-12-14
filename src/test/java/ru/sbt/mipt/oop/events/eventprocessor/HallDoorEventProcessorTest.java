package ru.sbt.mipt.oop.events.eventprocessor;

import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.*;
import org.junit.Test;
import ru.sbt.mipt.oop.homeelement.Light;
import ru.sbt.mipt.oop.homeelement.Room;
import static org.junit.Assert.assertTrue;

public class HallDoorEventProcessorTest extends EventProcessorTest {

    public HallDoorEventProcessorTest() {
        super();
        eventProcessor = new HallDoorEventProcessor();
    }

    @Test
    public void processHallDoorClosedTest() {
        SensorEvent hallDoorClosedEvent = new SensorEvent(DOOR_CLOSED, "4");
        eventProcessor.processEvent(smartHome, hallDoorClosedEvent);
        assertTrue(isAllLightsOff());
    }

    private boolean isAllLightsOff() {
        for (Room room : smartHome.getRooms())
            for (Light light : room.getLights())
                if (light.isOn())
                    return false;
        return true;
    }
}
