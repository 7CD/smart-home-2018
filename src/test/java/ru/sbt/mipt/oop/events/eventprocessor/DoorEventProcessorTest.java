package ru.sbt.mipt.oop.events.eventprocessor;

import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;

import static org.junit.Assert.*;
import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.*;
import org.junit.Test;
import ru.sbt.mipt.oop.homeelement.Door;
import ru.sbt.mipt.oop.homeelement.Room;

import java.util.NoSuchElementException;

public class DoorEventProcessorTest extends EventProcessorTest {

    public DoorEventProcessorTest() {
        super();
        eventProcessor = new DoorEventProcessor();
    }

    @Test
    public void processDoorOpenedTest() {
        assertFalse(isDoorOpened("1"));
        SensorEvent doorOpenedEvent = new SensorEvent(DOOR_OPENED, "1");
        eventProcessor.processEvent(smartHome, doorOpenedEvent);
        assertTrue(isDoorOpened("1"));
    }

    @Test
    public void processDoorClosedTest() {
        assertTrue(isDoorOpened("3"));
        SensorEvent doorOpenedEvent = new SensorEvent(DOOR_CLOSED, "3");
        eventProcessor.processEvent(smartHome, doorOpenedEvent);
        assertFalse(isDoorOpened("3"));
    }

    private boolean isDoorOpened(String id) {
        for (Room room : smartHome.getRooms())
            for (Door door : room.getDoors())
                if (door.getId().equals(id))
                    return door.isOpen();
        throw new NoSuchElementException() ;
    }
}
