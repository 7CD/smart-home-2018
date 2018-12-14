package ru.sbt.mipt.oop.homeelement;

/**
 * Composite pattern
 */

public interface HomeComponent {

    void execute(HomeComponentAction action, HomeComponent parent);
}