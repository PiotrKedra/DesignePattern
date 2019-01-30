package Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite {

    // Interface for out class
    interface Thing{
        int getCost();
        String getName();
    }

    // Concrete implementations of our class
    static class Product implements Thing{
        private int cost;
        private String name;

        Product(String name, int cost) {
            this.cost = cost;
            this.name = name;
        }

        @Override
        public int getCost() {
            return cost;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    // Composite which allow us to storage everything that implements Thing
    // so we can storage box inside of the box, which is quite nice
    static class BoxComposite implements Thing{

        private List<Thing> things = new ArrayList<>();

        // Here we execute getCost method for all the things in out list
        @Override
        public int getCost() {
            int cost = 5;

            for(Thing thing: things){
                cost += thing.getCost();
            }

            return cost;
        }

        @Override
        public String getName() {
            StringBuilder name = new StringBuilder("Box: [ ");

            for(Thing thing: things){
                name.append(thing.getName()).append(", ");
            }

            return name + "]";
        }

        void add(Thing thing){
            things.add(thing);
        }

        void remove(Thing thing){
            things.remove(thing);
        }
    }

    // Client
    public static void main(String[] args) {
        Thing airPads = new Product("airPads", 20);
        Thing shoes = new Product("shoes", 40);

        BoxComposite box = new BoxComposite();

        box.add(airPads);
        box.add(shoes);

        System.out.println(box.getName());
        System.out.println(box.getCost());

        BoxComposite box2 = new BoxComposite();
        box2.add(new Product("Desk",99));

        box.add(box2);

        System.out.println(box.getName());
        System.out.println(box.getCost());
    }
}
