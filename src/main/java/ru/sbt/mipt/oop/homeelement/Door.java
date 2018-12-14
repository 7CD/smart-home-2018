package ru.sbt.mipt.oop.homeelement;

public class Door implements HomeComponent {

    private boolean isOpen;
    private final String id;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open() { isOpen = true; }

    public void close() { isOpen = false; }

    @Override
    public void execute(HomeComponentAction action, HomeComponent room) {
        action.execute(this, room);
    }
}
