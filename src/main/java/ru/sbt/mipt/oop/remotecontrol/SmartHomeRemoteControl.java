package ru.sbt.mipt.oop.remotecontrol;

import ru.sbt.mipt.oop.remotecontrol.commands.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * Command pattern.
 * Играет роль Invoker.
 */

public class SmartHomeRemoteControl implements RemoteControl {

    @Override
    public void onButtonPressed(String buttonCode) {
        buttonCodeToCommandMap.get(buttonCode).execute();
    }

    public void setCommandOnButton(Button button, Command command) {
        buttonCodeToCommandMap.put(buttonToButtonCodeMap.get(button), command);
    }

    public enum Button {
        A, B, C, D, ONE, TWO, THREE, FOUR;
    }

    private final Map<String, Command> buttonCodeToCommandMap = new HashMap<>();

    private static Map<Button, String> buttonToButtonCodeMap = new HashMap<>();
    static {
        buttonToButtonCodeMap.put(Button.A, "A");
        buttonToButtonCodeMap.put(Button.B, "B");
        buttonToButtonCodeMap.put(Button.C, "C");
        buttonToButtonCodeMap.put(Button.D, "D");
        buttonToButtonCodeMap.put(Button.ONE, "1");
        buttonToButtonCodeMap.put(Button.TWO, "2");
        buttonToButtonCodeMap.put(Button.THREE, "3");
        buttonToButtonCodeMap.put(Button.FOUR, "4");
    }
}
