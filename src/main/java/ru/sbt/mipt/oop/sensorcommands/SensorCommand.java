package ru.sbt.mipt.oop.sensorcommands;

import ru.sbt.mipt.oop.sensorcommands.CommandType;

public class SensorCommand {

    private final ru.sbt.mipt.oop.sensorcommands.CommandType type;
    private final String objectId;

    public SensorCommand(CommandType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return "SensorCommand{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
