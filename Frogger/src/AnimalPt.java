// Assignment 12
// Pair 107
// Singh Shivanjali
// ssingh94
// Lin Hailu 
// hailu


import javalib.worldimages.*;
//Houses the AnimalPt locations and its methods
public class AnimalPt extends Posn {
    AnimalPt(int x, int y) {
        super(x, y);
    }

    // produce a point moved by the given distance from this point
    AnimalPt moveBy(int dx, int dy) {
        return new AnimalPt(this.x + dx, this.y + dy);
    }

    // Compute the distance from this point to the given one
    double distTo(AnimalPt that) {
        return Math.sqrt((this.x - that.x) * (this.x - that.x)
                + (this.y - that.y) * (this.y - that.y));
    }
}