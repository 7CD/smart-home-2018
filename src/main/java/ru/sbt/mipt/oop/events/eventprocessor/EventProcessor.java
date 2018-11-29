package ru.sbt.mipt.oop.events.eventprocessor;

import ru.sbt.mipt.oop.events.sensorevents.SensorEvent;
import ru.sbt.mipt.oop.homeelement.SmartHome;

/**
 * Шаблон Observer. Играет роль наблюдателя за HomeEventsObserver.
 * При возникновении event-а HomeEventsObserver вызывет у наблюдателей
 * метод processEvent, который фиксирует возникшее событие и
 * соответствующим образом изменяет состояние smartHome.
 */

public interface EventProcessor {

    void processEvent(SmartHome smartHome, SensorEvent event);
}
