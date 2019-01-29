class RoundHole{
    private float radius = 10;

    RoundHole(float radius){
        this.radius = radius;
    }

    public boolean fits(RoundPeg peg){
        return this.radius >= peg.getRadius();
    }
}