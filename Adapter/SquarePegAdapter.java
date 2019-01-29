class SquarePegAdapter extends RoundPeg{
    private SquarePeg squarePeg;

    SquarePegAdapter(SquarePeg squarePeg){
        this.squarePeg = squarePeg;
    }

    @Override
    public float getRadius(){
        return (this.squarePeg.getWidth()/2.0f) * (float) Math.sqrt(2.0);
    }
}