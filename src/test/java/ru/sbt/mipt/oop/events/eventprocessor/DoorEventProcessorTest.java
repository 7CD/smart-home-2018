package ru.sbt.mipt.oop.events.eventprocessor;

import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.*;
import org.junit.Test;

public class DoorEventProcessorTest extends EventProcessorTest {

    public DoorEventProcessorTest() {
        super();
        eventProcessor = new DoorEventProcessor();
    }

    @Test
    public void processNotDoorEventTest() {
        SensorEvent notDoorEvent = new SensorEvent(LIGHT_ON, "1");
        String expected = "";
        test(notDoorEvent, expected);
    }

    @Test
    public void processDoorOpenedTest() {
        SensorEvent doorOpenedEvent = new SensorEvent(DOOR_OPENED, "1");
        String expected = "Door 1 in room kitchen was opened.\r\n";// or + System.lineSeparator();
        test(doorOpenedEvent, expected);
    }

    @Test
    public void processDoorClosedTest() {
        SensorEvent doorClosedEvent = new SensorEvent(DOOR_CLOSED, "1");
        String expected = "Door 1 in room kitchen was closed.\r\n";
        test(doorClosedEvent, expected);
    }
}
