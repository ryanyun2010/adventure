package examples.adventure;

import java.util.List;

/**
 * This very simple text adventure game uses Lists and Maps to store information about the world.
 */
public class Adventure extends Game {

    public static void main(String[] args) {
        new Adventure().play();
    }

    public Adventure() {
        var nurseryEvents = List.of(
                new Event(0.4f, "A panda is born it heals your soul. You gained 20 health", 20)
        );
        var airportEvents = List.of(
                new Event(0.2f, "Your hand gets jammed in a door. You lost 10 health", -10)
        );
        var foodEvents = List.of(
                new Event(0.2f, "You got food poisoning. You lost 10 health", -10)
        );
        var hospitalEvents = List.of(
                new Event(0.2f, "You got healed. You gained 10 health", 10)
        );
        var pandaCrammedEvents = List.of(
                new Event(0.3f, "You got crammed in the pandaZoo. You lost 4 health.", -4)
        );
        var grandOpeningEvents = List.of(
                new Event(0.3f, "Its the Grand Opening.", 0)
        );
        var bambooForestEvents = List.of(
                new Event(0.1f,"You step on panda poop. You lose 1 health",-1),
                new Event(0.2f, "You get stung be a bee. You lose 5 health",-5),
                new Event(0.2f,"You get cut on a piece of bamboo. You lose 5 health",-5)
        );
        var airport = new Place("Airport", "Come On To This Airport(Primarily used to get to PandaTown)", airportEvents);
        var pandaTown = new Place("Panda Town Airport", "a small town in the heart of pandaland");
        var hotel = new Place("The Hotel Of Bamboo", "the best hotel in all of pandaland");
        var pool = new Place("Pool", "Play with water");
        var bambooForest = new Place("Bamboo Forest", "Explore the habitat of the panda",bambooForestEvents);
        var foodShop = new Place("The Food Shop", "The shop for all food", foodEvents);
        var hospital = new Place("Hospital", "Come here to get a chance to heal", hospitalEvents);
        var pandaZoo = new Place("Panda Zoo", "a zoo dedicated to pandas", grandOpeningEvents);
        var grownup1 = new Place("The Old Pandas Exhibit", "a place where old pandas lounge", pandaCrammedEvents);
        var grownup2 = new Place("The Mid-Young Adults Exhibit", "a place where most adults live", pandaCrammedEvents);
        var kid1 = new Place("The Kid/Child Exhibit", "a place where pandas go when they leave there parents", pandaCrammedEvents);
        var baby1 = new Place("The Baby Tunnel", "a place where some babies sleep", pandaCrammedEvents);
        var nursery = new Place("The Nursery", "a place where panda mothers have babies", nurseryEvents);

        location = airport;

        airport.addTransitions(pandaTown);
        pandaTown.addTransitions(hotel, pandaZoo, airport, foodShop, hospital,pool,bambooForest);
        hotel.addTransitions(pandaZoo, airport, foodShop, hospital,pool,bambooForest);
        pandaZoo.addTransitions(grownup1, grownup2, kid1, baby1, nursery, hotel, airport, foodShop, hospital,pool,bambooForest);
        grownup1.addTransitions(pandaZoo);
        grownup2.addTransitions(pandaZoo);
        kid1.addTransitions(pandaZoo);
        baby1.addTransitions(pandaZoo);
        nursery.addTransitions(pandaZoo);
    }

}
