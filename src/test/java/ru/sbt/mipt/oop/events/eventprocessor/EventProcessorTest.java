package ru.sbt.mipt.oop.events.eventprocessor;

import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.homeelement.SmartHome;
import ru.sbt.mipt.oop.homeloader.FileSmartHomeLoader;
import ru.sbt.mipt.oop.homeloader.SmartHomeLoader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;

public abstract class EventProcessorTest {

    protected SmartHome smartHome;

    protected EventProcessor eventProcessor;

    protected ByteArrayOutputStream output = new ByteArrayOutputStream();

    public EventProcessorTest() {
        try {
            SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader("smart-home-1.js");
            smartHome = smartHomeLoader.loadSmartHome();
        } catch (IOException e) {

        }
        System.setOut(new PrintStream(output));
    }

    @AfterClass
    public static void cleanUpStreams() {
        System.setOut(System.out);
    }

    public void test(SensorEvent sensorEvent, String expected) {
        output.reset();
        eventProcessor.processEvent(smartHome, sensorEvent);
        assertEquals(expected, output.toString());
    }
}
