package Bridge;

public class Bridge {

    // Abstraction it supposed to be height level layer for some entity
    // Usually it should delegate are work to this entity (Implementation layer)
    // For example GUI delegate are work to some different implementation(macOS, windows)
    // We could make interface for Abstraction for different implementation of GUI
    static class GUI{

        private API api_implementation;

        GUI(API api_implementation) {
            this.api_implementation = api_implementation;
        }

        void display(){
            System.out.println("Name: " + api_implementation.implementation());
            System.out.println(" ---------------- ");
            System.out.println(" --- Weak Gui --- ");
            System.out.println(" ---------------- ");
        }
    }

    // Implementation layer (for different APIs)
    interface API{
        String implementation();
    }

    // Concrete implementation
    static class MacOS_API implements API{

        @Override
        public String implementation() {
            return "MacOS implementation";
        }
    }

    static class WindowsAPI implements API{

        @Override
        public String implementation() {
            return "Windows implementation";
        }
    }

    // Client
    public static void main(String[] args) {
        GUI gui = new GUI(new MacOS_API());

        gui.display();

        gui = new GUI(new WindowsAPI());

        gui.display();
    }

}
