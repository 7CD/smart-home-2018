package ru.sbt.mipt.oop.homeelement;

import java.util.Collection;

public class Room implements HomeComponent {

    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public void execute(HomeComponentAction action, HomeComponent smartHome) {
        for (Light light : lights)
            light.execute(action, this);
        for (Door door : doors)
            door.execute(action, this);
    }
}
