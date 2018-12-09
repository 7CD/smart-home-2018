package ru.sbt.mipt.oop.events.eventprocessor;

import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.*;
import org.junit.Test;

public class HallDoorEventProcessorTest extends EventProcessorTest {

    public HallDoorEventProcessorTest() {
        super();
        eventProcessor = new HallDoorEventProcessor();
    }

    @Test
    public void processNotHallDoorEventTest() {
        SensorEvent notDoorEvent = new SensorEvent(DOOR_OPENED, "1");
        String expected = "";
        test(notDoorEvent, expected);

        notDoorEvent = new SensorEvent(DOOR_CLOSED, "1");
        expected = "";
        test(notDoorEvent, expected);
    }

    @Test
    public void processHallDoorClosedTest() {
        SensorEvent hallDoorClosedEvent = new SensorEvent(DOOR_CLOSED, "4");
        String expected = "All the lights are turned off.\r\n";
        test(hallDoorClosedEvent, expected);
    }
}
