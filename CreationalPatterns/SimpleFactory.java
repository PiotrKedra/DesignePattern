public class SimpleFactory {

    enum CAR_TYPE{
        SPORT,
        SUV,
        LIMOUSINE
    }

    interface Car{
        void drive();
    }

    static class SportCar implements Car{

        @Override
        public void drive() {
            System.out.println("I am very fast car( yyyyyy... )");
        }
    }

    static class SUV implements Car{

        @Override
        public void drive() {
            System.out.println("I can drive through mountains and honestly every terrain");
        }
    }

    static class Limousine implements Car{

        @Override
        public void drive() {
            System.out.println("Rich and important people drive me ( like Putin )");
        }
    }

    interface CarFactoryInterface{
        Car makeCar(CAR_TYPE type);
    }


    static class CarFactory implements CarFactoryInterface{

        //Usually there should be more logic then just one switch, because now this factory is pointless
        @Override
        public Car makeCar(CAR_TYPE type) {
            switch (type){
                case SPORT:
                    return new SportCar();

                case SUV:
                    return new SUV();

                case LIMOUSINE:
                    return new Limousine();

                default:
                    throw new IllegalArgumentException("There is not a such car type: " + type);
            }
        }
    }


    public static void main(String[] args) {
        CarFactory factory = new CarFactory();

        Car car = factory.makeCar(CAR_TYPE.SUV);
        car.drive();

        car = factory.makeCar(CAR_TYPE.LIMOUSINE);
        car.drive();
    }

}
