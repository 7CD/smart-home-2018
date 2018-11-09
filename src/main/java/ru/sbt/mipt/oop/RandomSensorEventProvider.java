package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.*;

/**
 * Pretend like we're getting the events from physical world,
 * but we're going to just generate some random events.
 */

public class RandomSensorEventProvider {

    int numberOfLightsInHome;
    int numberOfDoorsInHome;

    public RandomSensorEventProvider(SmartHome smartHome) {
        for (Room room : smartHome.getRooms()) {
            numberOfLightsInHome += room.getLights().size();
            numberOfDoorsInHome += room.getDoors().size();
        }
    }

    public SensorEvent getNextSensorEvent() {
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[
                random(0, SensorEventType.values().length)];
        int maxObjectId = 0;
        if (sensorEventType == LIGHT_ON || sensorEventType == LIGHT_OFF) {
            maxObjectId = numberOfLightsInHome;
        } else if (sensorEventType == DOOR_OPEN || sensorEventType == DOOR_CLOSED) {
            maxObjectId = numberOfDoorsInHome;
        }
        String objectId = "" + (random(1, maxObjectId + 1));
        return new SensorEvent(sensorEventType, objectId);
    }

    /**
     * Generates a random int in range from min (including) to max (excluding).
     */
    private static int random(int min, int max) {
        if (max < min) throw new IllegalArgumentException("max must not be less than min");
        return (int) (Math.random() * (max - min)) + min;
    }
}
