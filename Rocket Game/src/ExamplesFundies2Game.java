// Assignment 4
// Pair 012
// Singh Shivanjali
// ssingh94

import java.awt.Color;
import java.util.Random;
import javalib.worldimages.Posn;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import tester.Tester;

// Examples and Tests for Star Rocket game 
class ExamplesFundies2Game {

    // Constants
    int width = 400;
    int height = 400;

    // Rocket examples
    Rocket rocket = new Rocket(new CartPoint(300, 100), "p12-Rocket", 3);

    // YellowStar examples
    YellowStar yellow1 = new YellowStar(new CartPoint(50, 20),
            "p12-YellowStar.png");
    YellowStar yellow2 = new YellowStar(new CartPoint(10, 5),
            "p12-YellowStar.png");
    YellowStar yellow3 = new YellowStar(new CartPoint(300, 380),
            "p12-YellowStar.png");
    YellowStar yellow4 = new YellowStar(new CartPoint(300, 400),
            "p12-YellowStar.png");

    // RedStar examples
    RedStar red1 = new RedStar(new CartPoint(20, 30), "p12-RedStar.png");
    RedStar red2 = new RedStar(new CartPoint(40, 70), "p12-RedStar.png");
    RedStar red3 = new RedStar(new CartPoint(300, 380), "p12-RedStar.png");
    RedStar red4 = new RedStar(new CartPoint(300, 400), "p12-RedStar.png");

    // Test moveLeft and moveRight methods for Rocket Class
    boolean testrocketMoveLeftRight(Tester t) {
        return t.checkExpect(this.rocket.moveLeft(), new Rocket(new CartPoint(
                297, 250), "p12-Rocket.png", 3))
                && t.checkExpect(this.rocket.moveRight(), new Rocket(
                        new CartPoint(303, 300), "p12-Rocket.png", 3));
    }

    // Test yellowFall for YellowStar class
    boolean testyellowFall(Tester t) {
        return t.checkExpect(this.yellow1.yellowFall(), new YellowStar(
                new CartPoint(50, 23), "p12-YellowStar.png"))
                && t.checkExpect(this.yellow2.yellowFall(), new YellowStar(
                        new CartPoint(10, 8), "p12-YellowStar.png"));
    }

    // Test yellowCollide for YellowStar class
    boolean testyellowCollide(Tester t) {
        return t.checkExpect(this.yellow1.yellowCollide(this.rocket), false)
                && t.checkExpect(this.yellow3.yellowCollide(this.rocket), true);
    }

    // Test yellowonGround for YellowStar class
    boolean testyellowGround(Tester t) {
        return t.checkExpect(this.yellow1.yellowonGround(), false)
                && t.checkExpect(this.yellow4.yellowonGround(), true);
    }

    // Test redFall for RedStar class
    boolean testredFall(Tester t) {
        return t.checkExpect(this.red1.redFall(), new RedStar(new CartPoint(20,
                33), "p12-RedStar.png"))
                && t.checkExpect(this.red2.redFall(), new RedStar(
                        new CartPoint(40, 73), "p12-RedStar.png"));
    }

    // Test redCollide for RedStar class
    boolean testredCollide(Tester t) {
        return t.checkExpect(this.red1.redCollide(this.rocket), false)
                && t.checkExpect(this.red3.redCollide(this.rocket), true);
    }

    // Test redonGround for RedStar class
    boolean testredGround(Tester t) {
        return t.checkExpect(this.red1.redonGround(), false)
                && t.checkExpect(this.red4.redonGround(), true);
    }

    // Test Random generator
    int rand1 = new Random().nextInt(5);
    int rand2 = new Random().nextInt(10);

    void testRandom(Tester t) {
        t.checkExpect(rand1 == 0 || rand1 == 1 || rand1 == 2 || rand1 == 3
                || rand1 == 4);
        t.checkOneOf(rand1, 0, 1, 2, 3, 4);
        t.checkExpect(rand2 == 0 || rand2 == 1 || rand2 == 2 || rand2 == 3
                || rand2 == 4 || rand2 == 5 || rand2 == 6 || rand2 == 7
                || rand2 == 8 || rand2 == 9);
        t.checkOneOf(rand1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    // NEW WORLD
    OuterSpace myWorld = new OuterSpace(new Rocket(new CartPoint(width / 2,
            height - 50), "p12-Rocket.png", 3), new YellowStar(new CartPoint(
            width / 3, 0), "p12-YellowStar.png"), new RedStar(new CartPoint(
            width / 2, 0), "p12-RedStar.png"), 0);

    // Test onTick for OuterSpace class
    boolean testOuterSpaceOnTick(Tester t) {
        return t.checkExpect(this.myWorld.onTick(), new OuterSpace(new Rocket(
                new CartPoint(width / 2, height - 50), "p12-Rocket.png", 3),
                new YellowStar(new CartPoint(200, 3), "p12-YellowStar.png"),
                new RedStar(new CartPoint(width / 2, 3), "p12-RedStar.png"), 0));
    }

    // Test onKeyEvent for OuterSpace
    boolean testOnKeyEvent(Tester t) {
        return t.checkExpect(this.myWorld.onKeyEvent("x"), this.myWorld)
                && t.checkExpect(this.myWorld.onKeyEvent("left"),
                        new OuterSpace(new Rocket(new CartPoint(width / 2 - 3,
                                height - 50), "p12-Rocket.png", 3),
                                new YellowStar(new CartPoint(133, 0),
                                        "p12-YellowStar.png"), new RedStar(
                                        new CartPoint(width / 2, 0),
                                        "p12-RedStar.png"), 0))
                && t.checkExpect(this.myWorld.onKeyEvent("right"),
                        new OuterSpace(new Rocket(new CartPoint(width / 2 + 3,
                                height - 50), "p12-Rocket.png", 3),
                                new YellowStar(new CartPoint(133, 0),
                                        "p12-YellowStar.png"), new RedStar(
                                        new CartPoint(width / 2, 0),
                                        "p12-RedStar.png"), 0));
    }

    // Falling objects
    OuterSpace fallWorld = new OuterSpace(new Rocket(new CartPoint(200, 250),
            "p12-Rocket.png", 3), new YellowStar(new CartPoint(width / 2,
            height), "p12-YellowStar.png"), new RedStar(
            new CartPoint(300, 380), "p12-RedStar.png"), 0);

    // Test worldEnds for OuterSpace
    boolean testOuterSpaceWorldEnds(Tester t) {
        return t.checkExpect(this.myWorld.worldEnds(), new WorldEnd(false,
                this.myWorld.makeImage()))
                && t.checkExpect(
                        this.fallWorld.worldEnds(),
                        new WorldEnd(true, this.fallWorld.makeImage()
                                .overlayImages(
                                        new TextImage(new Posn(width / 2,
                                                height / 2), "Game Over",
                                                Color.white))));
    }

}
