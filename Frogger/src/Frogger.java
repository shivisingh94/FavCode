// Assignment 12
// Pair 107
// Singh Shivanjali
// ssingh94
// Lin Hailu 
// hailu


import javalib.worldimages.*;
import javalib.funworld.*;
import java.awt.Color;

//Houses the class Frogger and its methods
public class Frogger extends World {

    Frog afrog;
    Animals animals;
    Leafs leafs;
    Flowers flowers;
    int lives;

    Frogger(Frog afrog, Animals animals, Leafs leafs, Flowers flowers, int 
            lives) {
        this.afrog = afrog;
        this.animals = animals;
        this.leafs = leafs;
        this.flowers = flowers;
        this.lives = lives;
    }

    // CONSTANTS
    Color gray = new Color(100, 100, 100);
    Color white = new Color(250, 250, 250);
    Color blue = new Color(150, 150, 250);
    Color black = new Color(0, 0, 0);
    Color green = new Color(0, 100, 0);
    Color red = new Color(0, 255, 0);
    int width = 800;
    int height = 650;
    WorldImage grass = new RectangleImage(new Posn(width / 2, 475), width, 250,
            green)
            .overlayImages(
                    new RectangleImage(new Posn(width / 2, 415), width, 10,
                            red))
            .overlayImages(
                    new RectangleImage(new Posn(width / 2, 475), width, 10,
                            white))
            .overlayImages(
                    new RectangleImage(new Posn(width / 2, 535), width, 10, 
                            red))
            .overlayImages(
                    new RectangleImage(new Posn(width / 2, 595), width, 10,
                            white));

    WorldImage background = new RectangleImage(new Posn(width / 2, height / 2),
            width, height, gray)
            .overlayImages(
                    new RectangleImage(new Posn(width / 2, 175), width, 250,
                            blue))
            .overlayImages(grass)
            .overlayImages(
                    new RectangleImage(new Posn(width / 2, 25), width, 50, 
                            gray))
            .overlayImages(
                    new RectangleImage(new Posn(width / 2, 325), width, 50,
                            gray))
            .overlayImages(
                    new RectangleImage(new Posn(width / 2, 625), width, 50,
                            gray));

    //produces teh following worlds based on outside encounters
    public World onTick() {
        if (this.afrog.loc.y <= 265 && this.afrog.loc.y >= 85) {
            if (this.afrog.crash(this.animals, this.flowers)
                    || !this.afrog.onLeafs(this.leafs)) {
                this.lives = this.lives - 1;
                return new Frogger(this.afrog.reset(), this.animals,
                        this.leafs, this.flowers, this.lives);
            } else {
                return new Frogger(this.afrog.move(this.leafs),
                        this.animals.move(), this.leafs.move(),
                        this.flowers.move(), this.lives);
            }
        } else {
            if (this.afrog.crash(this.animals, this.flowers)) {
                this.lives = this.lives - 1;
                return new Frogger(this.afrog.reset(), this.animals,
                        this.leafs, this.flowers, this.lives);
            } else {
                return new Frogger(this.afrog.move(this.leafs),
                        this.animals.move(), this.leafs.move(),
                        this.flowers.move(), this.lives);
            }
        }
    }

    //Moves the frog based on the keystroke 
    public World onKeyEvent(String ke) {
        return new Frogger(this.afrog.onKeyEvent(ke), this.animals, this.leafs,
                this.flowers, this.lives);
    }

    //creates the image of the game 
    public WorldImage makeImage() {
        return background
                .overlayImages(this.animals.animalsImage())
                .overlayImages(this.leafs.leafsImage())
                .overlayImages(this.flowers.flowersImage())
                .overlayImages(this.afrog.frogImage())
                .overlayImages(
                        new TextImage(new Posn(720, 25),
                                "LIVES: " + this.lives, 25, 1, Color.red));
    }

    //the last image of the game 
    public WorldImage lastImage(String s) {
        return background;
    }

    //the World that occurs when the game ends.. either win or lose 
    public WorldEnd worldEnds() {
        if (this.lives == 0) {
            return new WorldEnd(true, this.makeImage().overlayImages(
                    new TextImage(new Posn(width / 2, height / 2),
                            "GAME OVER, YOU LOSE", 35, 1, white)));
        }
        if (this.afrog.loc.y == 25) {
            return new WorldEnd(true, this.makeImage().overlayImages(
                    new TextImage(new Posn(width / 2, height / 2),
                            "CONGRATULATIONS,YOU WIN!", 35, 1, white)));
        } else {
            return (new WorldEnd(false, this.makeImage()));
        }
    }

}
