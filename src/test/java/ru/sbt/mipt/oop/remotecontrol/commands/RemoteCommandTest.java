package ru.sbt.mipt.oop.remotecontrol.commands;

import ru.sbt.mipt.oop.homeelement.SmartHome;
import ru.sbt.mipt.oop.homeloader.FileSmartHomeLoader;
import ru.sbt.mipt.oop.homeloader.SmartHomeLoader;
import ru.sbt.mipt.oop.remotecontrol.SmartHomeRemoteControl;
import java.io.IOException;

public abstract class RemoteCommandTest {

    protected SmartHome smartHome;
    SmartHomeRemoteControl remoteControl;

    public RemoteCommandTest() {
        try {
            SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader("smart-home-1.js");
            smartHome = smartHomeLoader.loadSmartHome();
        } catch (IOException e) {

        }
        remoteControl = new SmartHomeRemoteControl();
    }
}
