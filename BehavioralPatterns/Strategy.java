public class Strategy {


    // Strategy for different map algorithm
    interface MapPathAlgorithm {
        String createMap();
    }

    static class GradientAlgorithm implements MapPathAlgorithm {

        @Override
        public String createMap() {
            return "Gradient map";
        }
    }

    static class AStarAlgorithm implements MapPathAlgorithm {

        @Override
        public String createMap() {
            return "A* mapped map";
        }
    }

    // interface for creating different type of maps
    // but client chose what type is it not navigator
    static class MapGenerator{

        private MapPathAlgorithm mapPathAlgorithm;

        public void setMapPathAlgorithm(MapPathAlgorithm mapPathAlgorithm) {
            this.mapPathAlgorithm = mapPathAlgorithm;
        }

        public String createMap(){
            return mapPathAlgorithm.createMap();
        }
    }

    // The client code picks a concrete strategy and passes it to
    // the context. The client should be aware of the differences
    // between strategies in order to make the right choice.
    public static void main(String[] args) {

        MapGenerator mapGenerator = new MapGenerator();

        //read input from user ab type of map
        String mapType = "A*";

        switch (mapType){
            case "A*":
                mapGenerator.setMapPathAlgorithm(new AStarAlgorithm());
                break;
            case "Gradient":
                mapGenerator.setMapPathAlgorithm(new GradientAlgorithm());
                break;
            default:
                throw new IllegalArgumentException("Wrong map type: " + mapType);
        }

        String map = mapGenerator.createMap();

        System.out.println(map);
    }


}
