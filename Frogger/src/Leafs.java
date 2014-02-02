// Assignment 12
// Pair 107
// Singh Shivanjali
// ssingh94
// Lin Hailu 
// hailu


import javalib.worldimages.*;
import java.util.ArrayList;

//House the set of Leafs and its methods
public class Leafs {
    ArrayList<Leaf> leafs1;
    ArrayList<Leaf> leafs2;
    ArrayList<Leaf> leafs3;
    ArrayList<Leaf> leafs4;

    Leafs(ArrayList<Leaf> leafs1, ArrayList<Leaf> leafs2,
            ArrayList<Leaf> leafs3, ArrayList<Leaf> leafs4) {
        this.leafs1 = leafs1;
        this.leafs2 = leafs2;
        this.leafs3 = leafs3;
        this.leafs4 = leafs4;
    }

    //Produces the images for each of the Leafs in the given ArrayList
    public WorldImage leafsImageH(ArrayList<Leaf> a) {
        WorldImage image0 = a.get(0).leafImage();
        for (int i = 1; i < a.size(); i++) {
            image0 = image0.overlayImages(a.get(i).leafImage());
        }
        return image0;
    }
    
    //OverLaps the images of the leafs in teh given arraylists 
    public WorldImage leafsImage() {
        return this
                .leafsImageH(leafs1)
                .overlayImages(this.leafsImageH(leafs2))
                .overlayImages(
                        this.leafsImageH(leafs3).overlayImages(
                                this.leafsImageH(leafs4)));
    }
    
    //Moves each of the leaves in the given ArrayList to the left 
    public ArrayList<Leaf> moveLeft(ArrayList<Leaf> a) {
        ArrayList<Leaf> c0 = new ArrayList<Leaf>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).loc.x <= -25) {
                int y0 = a.get(i).loc.y;
                a.remove(i);
                a.add(new Leaf(new AnimalPt(825, y0)));
            }
            Leaf p = a.get(i).moveLeft();
            c0.add(p);
        }
        return c0;
    }

    //Moves each of the leaves in the given ArrayList to the right
    public ArrayList<Leaf> moveRight(ArrayList<Leaf> a) {
        ArrayList<Leaf> c0 = new ArrayList<Leaf>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).loc.x >= 825) {
                int y0 = a.get(i).loc.y;
                a.remove(i);
                a.add(new Leaf(new AnimalPt(-25, y0)));
            }
            Leaf p = a.get(i).moveRight();
            c0.add(p);
        }
        return c0;
    }

    //Moves each arraylist of the given set in its respective direction 
    public Leafs move() {
        return new Leafs(this.moveLeft(leafs1), this.moveRight(leafs2),
                this.moveLeft(leafs3), this.moveRight(leafs4));
    }
}
