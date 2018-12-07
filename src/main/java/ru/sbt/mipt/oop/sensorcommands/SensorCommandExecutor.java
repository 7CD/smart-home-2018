package ru.sbt.mipt.oop.sensorcommands;

import ru.sbt.mipt.oop.sensorcommands.SensorCommand;

public class SensorCommandExecutor {

    public static void executeCommand(SensorCommand command) {
        System.out.println("Pretend we're sending command " + command);
    }
}
