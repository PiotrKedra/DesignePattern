package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class Flyweight {

    // It's flyweight class that represent concrete type of tree
    static class TreeType{
        private String name;
        private String color;
        private int texture;

        TreeType(String name, String color, int texture) {
            this.name = name;
            this.color = color;
            this.texture = texture;
        }

        void draw(int x, int y){
            System.out.println("x: " + x + ", y: " + y + toString());
        }

        @Override
        public String toString() {
            return " TreeType{" +
                    name + '\'' +
                    color + '\'' +
                    texture +
                    '}';
        }
    }

    // Tree factory it holds representations of concrete types, if someone needs
    // type that was used earlier it does not create new object, but returns
    // references to object in the list (to flyweight), that's how we save RAM
    static class TreeFactory{
        static Map<String, TreeType> treeTypes = new HashMap<>();

        TreeType getTreeType(String name, String color, int texture){
            TreeType type = treeTypes.get(name);
            if(type == null){
                type = new TreeType(name, color, texture);
                treeTypes.put(name, type);
            }
            return type;
        }
    }

    // Class which use flyweight
    static class Tree{
        private int x;
        private int y;
        private TreeType type;

        Tree(int x, int y, TreeType type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }

        void draw(){
            type.draw(x, y);
        }
    }

    // Client (it could be a Forest or sth)
    public static void main(String[] args) {
        TreeFactory factory = new TreeFactory();

        Tree tree1 = new Tree(1, 1, factory.getTreeType("Oak", "Green", 1));
        Tree tree2 = new Tree(10, 10, factory.getTreeType("Oak", "White", 1));
        Tree tree3 = new Tree(5, 5, factory.getTreeType("Pine", "Light Green", 2));

        tree1.draw();
        tree2.draw();
        tree3.draw();
    }
}
