// Assignment 12
// Pair 107
// Singh Shivanjali
// ssingh94
// Lin Hailu 
// hailu


import javalib.worldimages.*;

//Houses all methods and form of animals 
class Animal {
    AnimalPt loc;
    int type;

    Animal(AnimalPt loc, int type) {
        this.loc = loc;
        this.type = type;
    }

    //produces the image of the animal 
    public WorldImage animalImage() {

        if (this.loc.y == 360 || this.loc.y == 500)
            return new FromFileImage(new Posn(this.loc.x, this.loc.y),
                    this.leftImage(this.type));
        else
            return new FromFileImage(new Posn(this.loc.x, this.loc.y),
                    this.rightImage(this.type));
    }

    //produces the correct image from the right side 
    public String rightImage(int i) {
        if (i == 0)
            return "rightanimal1.png";
        if (i == 1)
            return "rightanimal2.png";
        if (i == 2)
            return "rightanimal3.png";
        if (i == 3)
            return "rightanimal4.png";
        else
            return "";
    }

    //produces the correct image from the left side
    public String leftImage(int i) {
        if (i == 0)
            return "leftanimal1.png";
        if (i == 1)
            return "leftanimal2.png";
        if (i == 2)
            return "leftanimal3.png";
        if (i == 3)
            return "leftanimal4.png";
        else
            return "";
    }

    //moves the animal to the left 
    public Animal moveLeft() {
        return new Animal(this.loc.moveBy(-5, 0), this.type);
    }

    //moves the animal to the right 
    public Animal moveRight() {
        return new Animal(this.loc.moveBy(+5, 0), this.type);
    }
}



