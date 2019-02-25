package AbstractFactory;

public class AbstractFactory {

    interface FurnitureFactory{
        Chair createChair();
        Table createTable();
    }

    static class OldFactory implements FurnitureFactory{
        @Override
        public Chair createChair() {
            return new OldChair();
        }

        @Override
        public Table createTable() {
            return new OldTable();
        }
    }

    static class ModernFactory implements FurnitureFactory{
        @Override
        public Chair createChair() {
            return new ModernChair();
        }

        @Override
        public Table createTable() {
            return new ModernTable();
        }
    }


    interface Chair{

    }

    static class OldChair implements Chair{
        @Override
        public String toString() {
            return "OldChair";
        }
    }

    static class ModernChair implements Chair{
        @Override
        public String toString() {
            return "ModernChair";
        }
    }

    interface Table{

    }

    static class OldTable implements Table{
        @Override
        public String toString() {
            return "OldTable";
        }
    }

    static class ModernTable implements Table{
        @Override
        public String toString() {
            return "ModernTable";
        }
    }

    public static void main(String[] args) {
        FurnitureFactory factory = new ModernFactory();

        System.out.println(factory.createTable());
        System.out.println(factory.createChair());

        factory = new OldFactory();

        System.out.println(factory.createTable());
        System.out.println(factory.createChair());
    }


}
