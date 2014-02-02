// Assignment 4
// Pair 012
// Singh Shivanjali
// ssingh94
// Patel Premal
// Premal16

import java.util.*;
import javalib.funworld.*;
import javalib.worldimages.*;
import java.awt.Color;

// Represents World for Star Rocket game
class OuterSpace extends World {

    RedStar redstar; // dangerous red star
    Rocket rocket; // rocket (player)
    YellowStar yellowstar; // beneficial, fuel yellow star
    int score; // score of the game

    // Constants
    Color black = new Color(0, 0, 0);
    public int width = 400;
    public int height = 400;
    WorldImage background = new RectangleImage(new Posn(width / 2, height / 2),
            width, height, black);

    OuterSpace(Rocket rocket, YellowStar yellowstar, RedStar redstar, int score) {
        this.rocket = rocket;
        this.yellowstar = yellowstar;
        this.redstar = redstar;
        this.score = score;
    }

    /*
     * TEMPLATE; FIELDS: 
     * ...this.rocket... --- Rocket 
     * ...this.yellowstar... ---YellowStar 
     * ...this.redstar... --- RedStar 
     * ...this.score... --- int
     * 
     * METHODS 
     * ... this.onTick() ... -- World 
     * ... this.onKeyEvent(String) ... --World 
     * ... this.makeImage() ... -- WorldImage 
     * ... this.worldEnds() ... --WorldEnd
     * 
     * METHODS FOR FIELDS: 
     * ...this.yellowCollide(rocket)... -- YellowStar
     * ...this.redstar.redFall()... -- RedStar 
     * ...this.yellowstar.reSet()... -- YellowStar 
     * ...this.redstar.redonGround()... -- RedStar
     * ...this.redstar.reSet()... -- RedStar 
     * ...this.yellowstar.yellowFall()... -- YellowStar 
     * ...this.yellowstar.yellowonGround()... -- YellowStar
     * ...this.rocket.onKeyEvent(String)... --Rocket
     * ...this.rocket.moveLeft()... --Rocket 
     * ...this.rocket.moveRight()... --Rocket 
     * ...this.rocket.rocketImage()... --Rocket
     * ...this.redstar.redCollide(Rocket)... --RedStar
     */

    // Produce OuterSpace after one tick
    public World onTick() {
        if (this.yellowstar.yellowCollide(this.rocket)) {
            return new OuterSpace(this.rocket, this.yellowstar.reSet(),
                    this.redstar.redFall(), this.score + 1);
        } else if (this.redstar.redonGround()) {
            return new OuterSpace(this.rocket, this.yellowstar.yellowFall(),
                    this.redstar.reSet(), this.score);
        } else if (this.yellowstar.yellowonGround()) {
            return new OuterSpace(this.rocket, this.yellowstar.reSet(),
                    this.redstar.redFall(), this.score);
        } else {
            return new OuterSpace(this.rocket, this.yellowstar.yellowFall(),
                    this.redstar.redFall(), this.score);
        }
    }

    // Produce OuterSpace in response to key event
    // Rocket moves left or right, RedStar and YellowStar do not move
    public World onKeyEvent(String m) {
        return new OuterSpace(this.rocket.onKeyEvent(m), this.yellowstar,
                this.redstar, this.score);
    }

    // Produce the Image that represents this world
    public WorldImage makeImage() {
        return this.background.overlayImages(
                this.redstar.redImage(),
                this.yellowstar.yellowImage(),
                this.rocket.rocketImage(),
                new TextImage(new Posn(width - 20, height - 380), Integer
                        .toString(this.score), Color.white));
    }

    // Check if the RedStar collides with Rocket after every tick; end world if
    // true("Game Over :(")
    public WorldEnd worldEnds() {
        if (this.redstar.redCollide(this.rocket))
            return new WorldEnd(true, this.makeImage().overlayImages(
                    new TextImage(new Posn(width / 2, height / 2),
                            "Game Over :(", Color.white)));
        else
            return (new WorldEnd(false, this.makeImage()));
    }
}

// Represents the Rocket(player)
class Rocket {

    CartPoint loc; // the location of the rocket
    String name; // image of the rocket
    int score; // number of yellowStars caught

    Rocket(CartPoint loc, String name, int score) {
        this.loc = loc;
        this.name = name;
        this.score = score;
    }

    /*
     * TEMPLATE: FIELDS: 
     * ... this.loc ... --- CartPoint 
     * ... this.name ... ---String 
     * ... this.score... --- Integer
     * 
     * METHODS: 
     * ... this.onKeyEvent(String) ... --- Rocket 
     * ... this.moveLeft()... --- Rocket
     * ... this.moveRight() ... --- Rocket 
     * ...this.rocketImage()... --- WorldImage
     * 
     * METHODS FOR FIELDS: 
     * ...this.loc.moveBy(int, int)... --- CartPoint
     */

    // Rocket moves left and right according to keyEvent
    Rocket onKeyEvent(String m) {
        if (m.equals("left"))
            return this.moveLeft();
        else if (m.equals("right"))
            return this.moveRight();
        else
            return this;
    }

    // Create new Rocket to left
    Rocket moveLeft() {
        return new Rocket(this.loc.moveBy(-7, 0), this.name, this.score);
    }

    // Create new Rocket to right
    Rocket moveRight() {
        return new Rocket(this.loc.moveBy(+7, 0), this.name, this.score);
    }

    // Produce the image of this rocket at this position
    WorldImage rocketImage() {
        return new FromFileImage(this.loc, this.name);
    }
}

// Represent fuel replenishing yellowstars
class YellowStar {

    CartPoint loc; // the location of this yellowstar
    String name; // the image of this yellowstar

    YellowStar(CartPoint loc, String name) {
        this.loc = loc;
        this.name = name;
    }

    /*
     * TEMPLATE: FIELDS:
     *  ...this.loc... --- CartPoint 
     *  ...this.name... --- String
     * 
     * METHODS: 
     * ...this.yellowFall()... --- YellowStar
     *  ...this.reSet()... -- YellowStar 
     *  ...this.yellowCollide(Squirrel)... --- boolean
     * ...this.yellowonGround()... --- boolean 
     * ...this.yellowImage()... ---WorldImage
     * 
     * METHODS FOR FIELDS: 
     * ...this.loc.moveBy(int, int)... --- CartPoint
     * ...this.loc.distTo(CartPoint)... --- CartPoint
     */

    // Move YellowStar from top to bottom
    YellowStar yellowFall() {
        return new YellowStar(this.loc.moveBy(0, 15), this.name);
    }

    // Restart the YellowStar fall
    YellowStar reSet() {
        return new YellowStar(new CartPoint(new Random().nextInt(400), 0),
                this.name);
    }

    // Do the YellowStar and Rocket collide?
    boolean yellowCollide(Rocket that) {
        return this.loc.distTo(that.loc) < 30;
    }

    // Did the YellowStar fall past the Rocket to the bottom?
    boolean yellowonGround() {
        return this.loc.y >= 400;
    }

    // Produce image of YellowStar at this location
    WorldImage yellowImage() {
        return new FromFileImage(this.loc, this.name);
    }
}

// Represents dangerous RedStar
class RedStar {
    CartPoint loc; // Location of the RedStar
    String name; // Image of the RedStar

    RedStar(CartPoint loc, String name) {
        this.loc = loc;
        this.name = name;
    }

    /*
     * TEMPLATE: 
     * FIELDS
     * ... this.loc ... --- CartPoint 
     * ... this.name ... ---String
     * 
     * METHODS: 
     * ... this.redFall()... --- RedStar
     * ... this.redCollide(Rocket)... --- boolean 
     * ... this.redonGround()... --- boolean 
     * ... this.reSet()... ---RedStar 
     * ... this.redImage()... --- WorldImage
     * 
     * 
     * METHODS FOR FIELDS: 
     * ... this.loc.moveBy(int, int)... --- CartPoint 
     * ...this.loc.distTo(CartPoint)... --- double
     */

    //
    RedStar redFall() {
        return new RedStar(this.loc.moveBy(0, 10), this.name);
    }

    // Move RedStar from top to bottom
    boolean redCollide(Rocket that) {
        return this.loc.distTo(that.loc) < 50;
    }

    // Did the RedStar fall past the Rocket to the bottom?
    boolean redonGround() {
        return this.loc.y >= 400;
    }

    // Restart the RedStar fall
    RedStar reSet() {
        return new RedStar(new CartPoint(new Random().nextInt(400), 0),
                this.name);
    }

    // Produce image of RedStar at this location
    WorldImage redImage() {
        return new FromFileImage(this.loc, this.name);
    }

}

// extension of the Posn class with move methods
class CartPoint extends Posn {
    CartPoint(int x, int y) {
        super(x, y);
    }

    // produce a point move by the given distance from this point
    CartPoint moveBy(int dx, int dy) {
        return new CartPoint(this.x + dx, this.y + dy);
    }

    // Compute the distance from this point to the given one
    double distTo(CartPoint that) {
        return Math.sqrt((this.x - that.x) * (this.x - that.x)
                + (this.y - that.y) * (this.y - that.y));
    }
}
