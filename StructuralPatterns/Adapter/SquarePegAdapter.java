package Adapter;

class SquarePegAdapter extends RoundPeg{
    private SquarePeg squarePeg;

    SquarePegAdapter(SquarePeg squarePeg){
        this.squarePeg = squarePeg;
    }

    @Override
    public float getRadius(){
        return (this.squarePeg.getWidth() * (float) Math.sqrt(2.0)) / 2.0f;
    }
}