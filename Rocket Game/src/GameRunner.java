
// Assignment 4
// Pair 012
// Singh Shivanjali
// ssingh94
// Patel Premal
// Premal16

import java.awt.Color;
import javalib.worldimages.*;
import javalib.worldcanvas.*;
import javalib.funworld.*;
import tester.Tester;

// Display images for game and run it 
public class GameRunner {

    ExamplesFundies2Game examplesf2g = new ExamplesFundies2Game();

    WorldCanvas canvas1 = new WorldCanvas(400, 400);
    WorldCanvas canvas2 = new WorldCanvas(400, 400);

    WorldImage redImage = this.examplesf2g.red1.redImage();
    WorldImage rocketImage = this.examplesf2g.rocket.rocketImage();
    WorldImage yellowImage = this.examplesf2g.yellow1.yellowImage();

    WorldImage worldImage = this.examplesf2g.myWorld.makeImage();

    // Show images on canvas
    boolean onCanvas1 = canvas1.show() && canvas1.drawImage(this.redImage)
            && canvas1.drawImage(this.rocketImage)
            && canvas1.drawImage(this.yellowImage);

    // Show image on canvas
    boolean onCanavs2 = canvas2.show() && canvas2.drawImage(this.worldImage);

    // Run!!
    boolean run() {
        return this.examplesf2g.myWorld.bigBang(400, 400, 0.1);
    }

    // Method to run the game
    public static void main(String[] args) {
        GameRunner ag = new GameRunner();
        ag.run();
    }
}
