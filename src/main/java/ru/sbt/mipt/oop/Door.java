package ru.sbt.mipt.oop;

public class Door {

    private boolean isOpen;
    private final String id;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void open() { isOpen = true; }

    public void close() { isOpen = false; }
}
