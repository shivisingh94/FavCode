// Assignment 12
// Pair 107
// Singh Shivanjali
// ssingh94
// Lin Hailu 
// hailu



import java.util.ArrayList;
import java.util.Random;

import javalib.worldimages.WorldImage;

//Houses the class of a set of animals 
public class Animals  {
    ArrayList<Animal> animals1;
    ArrayList<Animal> animals2;
    ArrayList<Animal> animals3;
    ArrayList<Animal> animals4;

    Animals(ArrayList<Animal> animals1, ArrayList<Animal> animals2,
            ArrayList<Animal> animals3, ArrayList<Animal> animals4) {
        this.animals1 = animals1;
        this.animals2 = animals2;
        this.animals3 = animals3;
        this.animals4 = animals4;
    }

    //returns the images of all the animals in the given arraylist 
    public WorldImage animalsImageH(ArrayList<Animal> a) {
        WorldImage image0 = a.get(0).animalImage();
        for (int i = 1; i < a.size(); i++) {
            image0 = image0.overlayImages(a.get(i).animalImage());
        }
        return image0;
    }

    //overlays the images of the animals from the given arraylist 
    public WorldImage animalsImage() {
        return this.animalsImageH(animals1).overlayImages
                (this.animalsImageH(animals2))
                .overlayImages(this.animalsImageH(animals3).overlayImages(
                        this.animalsImageH(animals4)));
    }

    //moves all the animals in the given arraylist to the left
    public ArrayList<Animal> moveLeft(ArrayList<Animal> a) {
        Random rand = new Random();
        ArrayList<Animal> c0 = new ArrayList<Animal>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).loc.x <= -25) {
                int y0 = a.get(i).loc.y;
                a.remove(i);
                a.add(new Animal(new AnimalPt(825, y0), rand.nextInt(4)));
            }
            Animal c = a.get(i).moveLeft();
            c0.add(c);
        }
        return c0;
    }

    //moves all the animals in the given arraylist to the right 
    public ArrayList<Animal> moveRight(ArrayList<Animal> a) {
        Random rand = new Random();
        ArrayList<Animal> c0 = new ArrayList<Animal>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).loc.x >= 825) {
                int y0 = a.get(i).loc.y;
                a.remove(i);
                a.add(new Animal(new AnimalPt(-25, y0), rand.nextInt(4)));
            }
            Animal c = a.get(i).moveRight();
            c0.add(c);
        }
        return c0;
    }

    //moves all the arraylists of animals in this class to their respective
    //directions 
    public Animals move() {
        return new Animals(this.moveLeft(animals1), this.moveRight(animals2),
                this.moveLeft(animals3), this.moveRight(animals4));
    }
}
