package ru.sbt.mipt.oop.eventmanager;

import ru.sbt.mipt.oop.events.eventprocessor.EventProcessor;

public interface EventsManager {

    void registerEventProcessor(EventProcessor eventProcessor);

    void runEventsCycle();
}
