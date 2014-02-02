// Assignment 12
// Pair 107
// Singh Shivanjali
// ssingh94
// Lin Hailu 
// hailu


import javalib.worldimages.*;
import java.util.ArrayList;

//Houses the frog that the player controls and its methods
public class Frog {

    AnimalPt loc;

    Frog(AnimalPt loc) {
        this.loc = loc;
    }

    //Produces the image of the frog
    public WorldImage frogImage() {
        return new FromFileImage(new Posn(this.loc.x, this.loc.y), "frog.png");
    }

    //Determines what the frog does based on the keystroke 
    public Frog onKeyEvent(String ke) {
        if (ke.equals("left"))
            return this.moveLeft();
        if (ke.equals("right"))
            return this.moveRight();
        if (ke.equals("up"))
            return this.moveUp();
        if (ke.equals("down"))
            return this.moveDown();
        else
            return this;
    }

    //Moves the frog to the Left 
    public Frog moveLeft() {
        if (this.loc.x >= 25)
            return new Frog(this.loc.moveBy(-10, 0));
        else
            return this;
    }

    //Moves the frog to the Right 
    public Frog moveRight() {
        if (this.loc.x <= 775)
            return new Frog(this.loc.moveBy(+10, 0));
        else
            return this;
    }

    //Moves the frog Upwards
    public Frog moveUp() {
        if (this.loc.y > 25)
            return new Frog(this.loc.moveBy(0, -60));
        else
            return this;
    }
    
    //Moves the frog Downwards 
    public Frog moveDown() {
        if (this.loc.y < 625)
            return new Frog(this.loc.moveBy(0, +60));
        else
            return this;
    }

    //Determines whether the frog is on a safe leaf 
    public boolean onLeaf(ArrayList<Leaf> ap) {
        for (int i = 0; i < ap.size(); i++) {
            if (this.loc.distTo(ap.get(i).loc) <= 50)
                return true;
        }
        return false;
    }

    
    //Determines whether the frog is one one of the given leaves 
    public boolean onLeafs(Leafs ps) {
        return this.onLeaf(ps.leafs1) || this.onLeaf(ps.leafs2)
                || this.onLeaf(ps.leafs3) || this.onLeaf(ps.leafs4);
    }
    
    //Moves the frog based on whether it is on the leaf or not
    public Frog move(Leafs ps) {
        if (this.onLeafs(ps)) {
            if (this.loc.y == 85 || this.loc.y == 205)
                return new Frog(this.loc.moveBy(-4, 0));
            else
                return new Frog(this.loc.moveBy(+4, 0));
        } else
            return this;
    }
    
    //Did the frog clash with the dangerous Animal? 
    public boolean crashAnimal(ArrayList<Animal> ac) {
        for (int i = 0; i < ac.size(); i++) {
            if (this.loc.distTo(ac.get(i).loc) <= 40)
                return true;
        }
        return false;
    }
    
    //Did the frog clash with the dangerous pink flower?
    public boolean crashFlower(ArrayList<Flower> at) {
        for (int i = 0; i < at.size(); i++) {
            if (this.loc.distTo(at.get(i).loc) <= 25)
                return true;
        }
        return false;
    }
    
    //Did the frog crash into any of the given animals or Flowers?
    public boolean crash(Animals cs, Flowers ts) {
        return this.crashAnimal(cs.animals1) || this.crashAnimal(cs.animals2)
                || this.crashAnimal(cs.animals3)
                || this.crashAnimal(cs.animals4)
                || this.crashFlower(ts.flowers1)
                || this.crashFlower(ts.flowers2)
                || this.crashFlower(ts.flowers3)
                || this.crashFlower(ts.flowers4);
    }
    
    //reset the frog to original position (400,625)
    public Frog reset() {
        return new Frog(new AnimalPt(400, 625));
    }

}
