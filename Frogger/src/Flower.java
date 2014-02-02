// Assignment 12
// Pair 107
// Singh Shivanjali
// ssingh94
// Lin Hailu 
// hailu


import javalib.worldimages.*;
import java.util.ArrayList;

//Houses the flower class and its methods
class Flower {
    AnimalPt loc;

    Flower(AnimalPt loc) {
        this.loc = loc;
    }

    //produces the image of the Flower
    public WorldImage flowerImage() {
        return new FromFileImage(new Posn(this.loc.x, this.loc.y), 
                "flower.png");
    }

    //moves the flower to the left 
    public Flower moveLeft() {
        return new Flower(this.loc.moveBy(-4, 0));
    }

    //moves the flower to the right 
    public Flower moveRight() {
        return new Flower(this.loc.moveBy(+4, 0));
    }
}
