package Adapter;

public class Main{
    public static void main(String [] args){
        RoundPeg roundPeg = new RoundPeg(10.0f);
        RoundHole hole = new RoundHole(10.0f);
        SquarePeg squarePeg = new SquarePeg(20.0f);

        SquarePegAdapter adapter = new SquarePegAdapter(squarePeg);

        System.out.println(hole.fits(roundPeg));

        System.out.println(hole.fits(adapter));
    }
}