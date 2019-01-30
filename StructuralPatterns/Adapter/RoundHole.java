package Adapter;

class RoundHole{
    private float radius;

    RoundHole(float radius){
        this.radius = radius;
    }

    boolean fits(RoundPeg peg){
        return this.radius >= peg.getRadius();
    }
}