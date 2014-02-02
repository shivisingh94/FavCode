// Assignment 12
// Pair 107
// Singh Shivanjali
// ssingh94
// Lin Hailu 
// hailu


import javalib.worldimages.*;
import java.util.ArrayList;


//Houses a set of Flowers and its methods
public class Flowers {
    ArrayList<Flower> flowers1;
    ArrayList<Flower> flowers2;
    ArrayList<Flower> flowers3;
    ArrayList<Flower> flowers4;

    Flowers(ArrayList<Flower> flowers1, ArrayList<Flower> flowers2,
            ArrayList<Flower> flowers3, ArrayList<Flower> flowers4) {
        this.flowers1 = flowers1;
        this.flowers2 = flowers2;
        this.flowers3 = flowers3;
        this.flowers4 = flowers4;
    }

    //produces the images of the flowers of the given ArrayList 
    public WorldImage flowersImageH(ArrayList<Flower> a) {
        WorldImage image0 = a.get(0).flowerImage();
        for (int i = 1; i < a.size(); i++) {
            image0 = image0.overlayImages(a.get(i).flowerImage());
        }
        return image0;
    }
    
    //overlaps the images of the flowers of the given ArrayList 
    public WorldImage flowersImage() {
        return this
                .flowersImageH(flowers1)
                .overlayImages(this.flowersImageH(flowers2))
                .overlayImages(
                        this.flowersImageH(flowers3).overlayImages(
                                this.flowersImageH(flowers4)));
    }

    //Moves all the flowers in the ArrayList to the left 
    public ArrayList<Flower> moveLeft(ArrayList<Flower> a) {
        ArrayList<Flower> c0 = new ArrayList<Flower>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).loc.x <= -25) {
                int y0 = a.get(i).loc.y;
                a.remove(i);
                a.add(new Flower(new AnimalPt(825, y0)));
            }
            Flower t = a.get(i).moveLeft();
            c0.add(t);
        }
        return c0;
    }

    //Moves all the flowers in the ArrayList to the right 
    public ArrayList<Flower> moveRight(ArrayList<Flower> a) {
        ArrayList<Flower> c0 = new ArrayList<Flower>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).loc.x >= 825) {
                int y0 = a.get(i).loc.y;
                a.remove(i);
                a.add(new Flower(new AnimalPt(-25, y0)));
            }
            Flower t = a.get(i).moveRight();
            c0.add(t);
        }
        return c0;
    }
    
    //Moves each arrayList in the set in its respective direction 
    public Flowers move() {
        return new Flowers(this.moveLeft(flowers1), this.moveRight(flowers2),
                this.moveLeft(flowers3), this.moveRight(flowers4));
    }
}
