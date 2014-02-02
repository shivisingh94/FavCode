// Assignment 12
// Pair 107
// Singh Shivanjali
// ssingh94
// Lin Hailu 
// hailu


import javalib.worldimages.*;

//Houses the Leaf class and its methods
class Leaf {
    AnimalPt loc;

    Leaf(AnimalPt loc) {
        this.loc = loc;
    }

    //Produces  the image of the leaf
    public WorldImage leafImage() {
        if (this.loc.y == 85 || this.loc.y == 205)
            return new FromFileImage(new Posn(this.loc.x, this.loc.y),
                    "leftLeaf.png");
        else
            return new FromFileImage(new Posn(this.loc.x, this.loc.y),
                    "rightLeaf.png");
    }

    //Moves the leaf to the Left 
    public Leaf moveLeft() {
        return new Leaf(this.loc.moveBy(-4, 0));
    }
    
    //Moves the leaf to the right 
    public Leaf moveRight() {
        return new Leaf(this.loc.moveBy(+4, 0));
    }
}