/*
package ru.sbt.mipt.oop;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import ru.sbt.mipt.oop.events.eventprocessor.LightsEventProcessor;
import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.homeelement.SmartHome;
import ru.sbt.mipt.oop.homeloader.FileSmartHomeLoader;
import ru.sbt.mipt.oop.homeloader.SmartHomeLoader;

import static ru.sbt.mipt.oop.events.sensorevents.SensorEventType.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class EventProcessorsTest {

    private SmartHome smartHome;

    public EventProcessorsTest() throws IOException {
        SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
        smartHome = smartHomeLoader.loadSmartHome();
    }

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeClass
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterClass
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void LightEventProcessorTest() {
        LightsEventProcessor lightsEventProcessor = new LightsEventProcessor();

        SensorEvent lightOnEvent = new SensorEvent(LIGHT_ON, "1");
        output.reset();
        lightsEventProcessor.processEvent(smartHome, lightOnEvent);
        String expected1 = "Light 1 in room kitchen was turned on.\r\n";// or + System.lineSeparator();
        assertEquals(expected1, output.toString());

        SensorEvent lightOffEvent = new SensorEvent(LIGHT_OFF, "3");
        output.reset();
        lightsEventProcessor.processEvent(smartHome, lightOffEvent);
        String expected2 = "Light 3 in room bathroom was turned off.\r\n";
        assertEquals(expected2, output.toString());
    }
}

*/
