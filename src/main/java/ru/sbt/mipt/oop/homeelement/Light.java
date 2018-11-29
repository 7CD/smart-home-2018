package ru.sbt.mipt.oop.homeelement;

public class Light {

    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void turnOn() { isOn = true; }

    public void turnOff() { isOn = false; }
}
