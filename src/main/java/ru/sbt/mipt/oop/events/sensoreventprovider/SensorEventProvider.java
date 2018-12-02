package ru.sbt.mipt.oop.events.sensoreventprovider;

import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;

public interface SensorEventProvider {

    SensorEvent getNextSensorEvent();
}
