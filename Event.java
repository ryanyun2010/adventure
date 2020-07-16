package examples.adventure;

class Event {
  final float probability;
  final String description;
  final int conditionImpact;

  public Event(float probability, String description, int conditionImpact) {
    this.probability = probability;
    this.description = description;
    this.conditionImpact = conditionImpact;
  }

  public Event(float probability, String description) {
    this.probability = probability;
    this.description = description;
    this.conditionImpact = 0;
  }

  @Override public String toString() {
    return "Event{" +
        "probability=" + probability +
        ", description='" + description + '\'' +
        '}';
  }
}
