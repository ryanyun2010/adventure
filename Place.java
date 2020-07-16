package examples.adventure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Place {
  final String name;
  final String description;
  final Collection<Event> events;
  final Collection<Place> transitions = new ArrayList<>();

  Place(String name, String description) {
    this.name = name;
    this.description = description;
    this.events = new ArrayList<>();
  }

  Place(String name, String description, Collection<Event> events) {
    this.name = name;
    this.description = description;
    this.events = events;
  }

  void addTransitions(Place... places) {
    Collections.addAll(transitions, places);
  }

  @Override public String toString() {
    return name + ": " + description;
  }
}
