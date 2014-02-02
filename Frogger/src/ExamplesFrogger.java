// Assignment 12
// Pair 107
// Singh Shivanjali
// ssingh94
// Lin Hailu 
// hailu

import tester.Tester;
import java.util.*;

//Examples of objects and methods
public class ExamplesFrogger {

    AnimalPt pt = new AnimalPt(0, 0);
    AnimalPt pt1 = new AnimalPt(4, 0);
    Frog frog = new Frog(new AnimalPt(176, 445));
    Frog frog1 = new Frog(new AnimalPt(0, 776));
    Frog frog2 = new Frog(new AnimalPt(776, 0));
    Frog frog3 = new Frog(new AnimalPt(725, 145));
    Frog frog4 = new Frog(new AnimalPt(725, 85));
    Animal animal1 = new Animal(new AnimalPt(25, 385), 0);
    Animal animal2 = new Animal(new AnimalPt(225, 385), 1);
    Animal animal3 = new Animal(new AnimalPt(425, 385), 2);
    Animal animal4 = new Animal(new AnimalPt(625, 385), 3);
    ArrayList<Animal> animalS1 = new ArrayList<Animal>(Arrays.asList(animal1,
            animal2, animal3, animal4));
    Frog frog5 = new Frog(new AnimalPt(225, 385));

    Animal animal5 = new Animal(new AnimalPt(775, 445), 0);
    Animal animal6 = new Animal(new AnimalPt(575, 445), 1);
    Animal animal7 = new Animal(new AnimalPt(375, 445), 2);
    Animal animal8 = new Animal(new AnimalPt(175, 445), 3);
    ArrayList<Animal> animalS2 = new ArrayList<Animal>(Arrays.asList(animal5,
            animal6, animal7, animal8));

    Animal animal9 = new Animal(new AnimalPt(125, 505), 2);
    Animal animal10 = new Animal(new AnimalPt(325, 505), 3);
    Animal animal11 = new Animal(new AnimalPt(525, 505), 1);
    Animal animal12 = new Animal(new AnimalPt(725, 505), 0);
    ArrayList<Animal> animalS3 = new ArrayList<Animal>(Arrays.asList(animal9,
            animal10, animal11, animal12));

    Animal animal13 = new Animal(new AnimalPt(675, 565), 3);
    Animal animal14 = new Animal(new AnimalPt(475, 565), 0);
    Animal animal15 = new Animal(new AnimalPt(275, 565), 2);
    Animal animal16 = new Animal(new AnimalPt(75, 565), 1);
    ArrayList<Animal> animalS4 = new ArrayList<Animal>(Arrays.asList(animal13,
            animal14, animal15, animal16));

    Animals allanimals = new Animals(animalS1, animalS2, animalS3, animalS4);

    Leaf p1 = new Leaf(new AnimalPt(25, 85));
    Leaf p2 = new Leaf(new AnimalPt(75, 85));
    Leaf p3 = new Leaf(new AnimalPt(250, 85));
    Leaf p4 = new Leaf(new AnimalPt(350, 85));
    Leaf p5 = new Leaf(new AnimalPt(400, 85));
    Leaf p6 = new Leaf(new AnimalPt(677, 85));
    Leaf p7 = new Leaf(new AnimalPt(726, 85));
    Leaf p8 = new Leaf(new AnimalPt(775, 85));
    ArrayList<Leaf> leafS1 = new ArrayList<Leaf>(Arrays.asList(p1, p2, p3, p4,
            p5, p6, p7, p8));
    ArrayList<Leaf> leafS15 = new ArrayList<Leaf>(Arrays.asList(p1, p2, p3));

    Flower t1 = new Flower(new AnimalPt(625, 85));
    Flower t2 = new Flower(new AnimalPt(300, 85));
    Flower t3 = new Flower(new AnimalPt(125, 85));
    ArrayList<Flower> flowerS1 = new ArrayList<Flower>(
            Arrays.asList(t1, t2, t3));

    Leaf p9 = new Leaf(new AnimalPt(675, 145));
    Leaf p10 = new Leaf(new AnimalPt(625, 145));
    Leaf p11 = new Leaf(new AnimalPt(575, 145));
    Leaf p12 = new Leaf(new AnimalPt(425, 145));
    Leaf p13 = new Leaf(new AnimalPt(375, 145));
    Leaf p14 = new Leaf(new AnimalPt(325, 145));
    Leaf p15 = new Leaf(new AnimalPt(175, 145));
    Leaf p16 = new Leaf(new AnimalPt(125, 145));
    ArrayList<Leaf> leafS2 = new ArrayList<Leaf>(Arrays.asList(p9, p10, p11,
            p12, p13, p14, p15, p16));

    Flower t4 = new Flower(new AnimalPt(725, 145));
    Flower t5 = new Flower(new AnimalPt(75, 145));
    Flower t6 = new Flower(new AnimalPt(25, 145));
    ArrayList<Flower> flowerS2 = new ArrayList<Flower>(
            Arrays.asList(t4, t5, t6));

    Frog frog7 = new Frog(new AnimalPt(625, 83));

    Leaf p17 = new Leaf(new AnimalPt(75, 205));
    Leaf p18 = new Leaf(new AnimalPt(176, 445));
    Leaf p19 = new Leaf(new AnimalPt(225, 205));
    Leaf p20 = new Leaf(new AnimalPt(375, 205));
    Leaf p21 = new Leaf(new AnimalPt(475, 205));
    Leaf p22 = new Leaf(new AnimalPt(625, 205));
    Leaf p23 = new Leaf(new AnimalPt(675, 205));
    Leaf p24 = new Leaf(new AnimalPt(725, 205));
    ArrayList<Leaf> leafS3 = new ArrayList<Leaf>(Arrays.asList(p17, p18, p19,
            p20, p21, p22, p23, p24));

    Flower t7 = new Flower(new AnimalPt(425, 205));
    Flower t8 = new Flower(new AnimalPt(175, 205));
    ArrayList<Flower> flowerS3 = new ArrayList<Flower>(Arrays.asList(t7, t8));

    Leaf p25 = new Leaf(new AnimalPt(675, 265));
    Leaf p26 = new Leaf(new AnimalPt(575, 265));
    Leaf p27 = new Leaf(new AnimalPt(525, 265));
    Leaf p28 = new Leaf(new AnimalPt(275, 265));
    Leaf p29 = new Leaf(new AnimalPt(225, 265));
    Leaf p30 = new Leaf(new AnimalPt(175, 265));
    Leaf p31 = new Leaf(new AnimalPt(75, 265));
    Leaf p32 = new Leaf(new AnimalPt(25, 265));
    ArrayList<Leaf> leafS4 = new ArrayList<Leaf>(Arrays.asList(p25, p26, p27,
            p28, p29, p30, p31, p32));
    Frog frog6 = new Frog(new AnimalPt(225, 265));

    Flower t9 = new Flower(new AnimalPt(625, 265));
    Flower t10 = new Flower(new AnimalPt(475, 265));
    Flower t11 = new Flower(new AnimalPt(125, 265));
    ArrayList<Flower> flowerS4 = new ArrayList<Flower>(Arrays.asList(t9, t10,
            t11));

    Frogger myWorld = new Frogger(new Frog(new AnimalPt(400, 625)),
            new Animals(animalS1, animalS2, animalS3, animalS4), new Leafs(
                    leafS1, leafS2, leafS3, leafS4), new Flowers(flowerS1,
                    flowerS2, flowerS3, flowerS4), 3);
    Frogger myWorld2 = new Frogger(frog3, new Animals(animalS1, animalS2,
            animalS3, animalS4), new Leafs(leafS1, leafS2, leafS3, leafS4),
            new Flowers(flowerS1, flowerS2, flowerS3, flowerS4), 3);
    Frogger myWorld3 = new Frogger(frog5, new Animals(animalS1, animalS2,
            animalS3, animalS4), new Leafs(leafS1, leafS2, leafS3, leafS4),
            new Flowers(flowerS1, flowerS2, flowerS3, flowerS4), 3);

    Frogger myWorld4 = new Frogger(frog6, new Animals(animalS1, animalS2,
            animalS3, animalS4), new Leafs(leafS1, leafS2, leafS3, leafS4),
            new Flowers(flowerS1, flowerS2, flowerS3, flowerS4), 3);

    Frogger myWorld5 = new Frogger(frog7, new Animals(animalS1, animalS2,
            animalS3, animalS4), new Leafs(leafS1, leafS2, leafS3, leafS4),
            new Flowers(flowerS1, flowerS2, flowerS3, flowerS4), 3);

    // test the methods in the animals classes
    void testMoveanimals(Tester t) {
        int rand1 = new Random().nextInt(5);
        int rand2 = new Random().nextInt(10);

        t.checkExpect(rand1 == 0 || rand1 == 1 || rand1 == 2 || rand1 == 3
                || rand1 == 4);
        t.checkOneOf(rand1, 0, 1, 2, 3, 4);
        t.checkExpect(rand2 == 0 || rand2 == 1 || rand2 == 2 || rand2 == 3
                || rand2 == 4 || rand2 == 5 || rand2 == 6 || rand2 == 7
                || rand2 == 8 || rand2 == 9);
        t.checkOneOf(rand1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        t.checkExpect(animal1.moveLeft(), new Animal(new AnimalPt(20, 385), 0
                ));
        t.checkExpect(animal2.moveLeft(), new Animal(new AnimalPt(220, 385), 1
                ));
        t.checkExpect(animal3.moveLeft(), new Animal(new AnimalPt(420, 385), 2
                ));
        t.checkExpect(animal4.moveLeft(), new Animal(new AnimalPt(620, 385), 3
                ));
        t.checkExpect(animal1.moveLeft(), new Animal(new AnimalPt(20, 385), 0
                ));
        t.checkExpect(animal2.moveRight(),
                new Animal(new AnimalPt(230, 385), 1));
        t.checkExpect(animal3.moveRight(),
                new Animal(new AnimalPt(430, 385), 2));
        t.checkExpect(animal4.moveRight(),
                new Animal(new AnimalPt(630, 385), 3));

        allanimals.moveRight(animalS1);
        allanimals.moveLeft(animalS2);

        t.checkExpect(allanimals.moveRight(animalS1).get(0).loc.x, 30);
        t.checkExpect(allanimals.moveRight(animalS1).get(2).loc.x, 430);
        t.checkExpect(allanimals.moveLeft(animalS2).get(3).loc.x, 170);
        t.checkExpect(allanimals.moveLeft(animalS3).get(2).loc.x, 520);

        allanimals.move();
        t.checkExpect(animalS4.get(2).loc.x, 275);
        t.checkExpect(animalS3.get(0).loc.x, 125);
        t.checkExpect(animalS2.get(1).loc.x, 575);
        t.checkExpect(animalS1.get(3).loc.x, 625);

    }

    // test the methods in the AnimalPts class
    void testAnimalPts(Tester t) {

        t.checkExpect(pt.moveBy(4, 9).x, 4);
        t.checkExpect(pt.moveBy(4, 9).y, 9);

        t.checkExpect(pt.moveBy(-4, -9).x, -4);
        t.checkExpect(pt.moveBy(-4, -9).y, -9);

        t.checkExpect(pt.distTo(pt1), 4.0);
    }

    // test the methods in the Frogger class
    void testFroggermethods(Tester t) {

        t.checkExpect(myWorld.onKeyEvent("up"),
                new Frogger(myWorld.afrog.onKeyEvent("up"), myWorld.animals,
                        myWorld.leafs, myWorld.flowers, myWorld.lives));

        t.checkExpect(myWorld3.onTick(), new Frogger(myWorld3.afrog.reset(),
                myWorld3.animals, myWorld3.leafs, myWorld3.flowers,
                myWorld3.lives));

        t.checkExpect(myWorld4.onTick(),
                new Frogger(myWorld4.afrog.move(myWorld4.leafs),
                        myWorld4.animals.move(), myWorld4.leafs.move(),
                        myWorld4.flowers.move(), myWorld4.lives));

        t.checkExpect(myWorld5.onTick(), new Frogger(myWorld5.afrog.reset(),
                myWorld5.animals, myWorld5.leafs, myWorld5.flowers,
                myWorld5.lives));
        /*
         * myWorld2.onTick(); t.checkExpect(myWorld.lives, 2);
         */

    }

    // test the methods in the Frog class
    void testFrog(Tester t) {
        t.checkExpect(frog.onKeyEvent("right"),
                new Frog(new AnimalPt(186, 445)));
        t.checkExpect(frog.onKeyEvent("left"), new Frog(new AnimalPt(166, 445)
        ));
        t.checkExpect(frog.onKeyEvent("down"), new Frog(new AnimalPt(176, 505))
        );
        t.checkExpect(frog.onKeyEvent("up"), new Frog(new AnimalPt(176, 385)));
        t.checkExpect(frog.onKeyEvent("a"), frog);

        t.checkExpect(frog1.onKeyEvent("up"), new Frog(new AnimalPt(0, 716)));
        t.checkExpect(frog1.onKeyEvent("left"), frog1);
        t.checkExpect(frog2.onKeyEvent("up"), frog2);
        t.checkExpect(frog2.onKeyEvent("left"), new Frog(new AnimalPt(766, 0))
        );

        t.checkExpect(frog2.onKeyEvent("down"), new Frog(new AnimalPt(776, 60)
        ));
        t.checkExpect(frog2.onKeyEvent("right"), frog2);
        t.checkExpect(frog1.onKeyEvent("down"), frog1);
        t.checkExpect(frog1.onKeyEvent("right"),
                new Frog(new AnimalPt(10, 776)));

        t.checkExpect(frog.loc.x, 176);
        t.checkExpect(frog.onLeaf(leafS3), true);
        t.checkExpect(frog.onLeaf(leafS1), false);

        t.checkExpect(frog.onLeafs(myWorld.leafs), true);
        t.checkExpect(frog1.onLeafs(myWorld.leafs), false);

        t.checkExpect(frog.move(myWorld.leafs).loc.x, 180);
        t.checkExpect(frog1.move(myWorld.leafs).loc.x, 0);
        t.checkExpect(frog4.move(myWorld.leafs).loc.x, 721);
        t.checkExpect(frog2.crashAnimal(animalS2), false);
        t.checkExpect(frog3.crashFlower(flowerS2), true);
        t.checkExpect(frog2.crashFlower(flowerS2), false);
        t.checkExpect(frog3.crashAnimal(animalS2), false);

        t.checkExpect(frog.crash(myWorld.animals, myWorld.flowers), true);
        t.checkExpect(frog2.crash(myWorld.animals, myWorld.flowers), false);
        t.checkExpect(frog3.crash(myWorld.animals, myWorld.flowers), true);
        t.checkExpect(frog1.crash(myWorld.animals, myWorld.flowers), false);

        t.checkExpect(myWorld.onTick(),
                new Frogger(myWorld.afrog.reset(), myWorld.animals.move(),
                        myWorld.leafs.move(), myWorld.flowers.move(), 3));
        t.checkExpect(myWorld2.onTick(), new Frogger(myWorld2.afrog.reset(),
                myWorld2.animals, myWorld2.leafs, myWorld2.flowers,
                myWorld2.lives));
        t.checkExpect(frog.reset().loc.x, 400);
        t.checkExpect(frog.reset().loc.y, 625);
        t.checkExpect(frog3.reset().loc.x, 400);
        t.checkExpect(frog3.reset().loc.y, 625);
    }

    // test the methods in the Flowers class
    void testFlowers(Tester t) {
        t.checkExpect(t1.moveLeft(), new Flower(new AnimalPt(621, 85)));
        t.checkExpect(t2.moveLeft(), new Flower(new AnimalPt(296, 85)));
        t.checkExpect(t3.moveLeft(), new Flower(new AnimalPt(121, 85)));
        t.checkExpect(t1.moveRight(), new Flower(new AnimalPt(629, 85)));
        t.checkExpect(t2.moveRight(), new Flower(new AnimalPt(304, 85)));
        t.checkExpect(t3.moveRight(), new Flower(new AnimalPt(129, 85)));

        t.checkExpect(
                myWorld.flowers.moveLeft(flowerS1),
                new ArrayList<Flower>(Arrays.asList((new Flower(new AnimalPt(
                        621, 85))), (new Flower(new AnimalPt(296, 85))),
                        (new Flower(new AnimalPt(121, 85))))));
        t.checkExpect(
                myWorld.flowers.moveRight(flowerS1),
                new ArrayList<Flower>(Arrays.asList((new Flower(new AnimalPt(
                        629, 85))), (new Flower(new AnimalPt(304, 85))),
                        (new Flower(new AnimalPt(129, 85))))));

        t.checkExpect(
                myWorld.flowers.move(),
                new Flowers(myWorld.flowers.moveLeft(flowerS1), myWorld.flowers
                        .moveRight(flowerS2), myWorld.flowers
                        .moveLeft(flowerS3), myWorld.flowers
                        .moveRight(flowerS4)));

    }

    // Test the methods in the Leafs classes
    void testLeafs(Tester t) {

        t.checkExpect(p1.moveLeft(), new Leaf(new AnimalPt(21, 85)));
        t.checkExpect(p2.moveLeft(), new Leaf(new AnimalPt(71, 85)));
        t.checkExpect(p3.moveLeft(), new Leaf(new AnimalPt(246, 85)));
        t.checkExpect(p1.moveRight(), new Leaf(new AnimalPt(29, 85)));
        t.checkExpect(p2.moveRight(), new Leaf(new AnimalPt(79, 85)));
        t.checkExpect(p3.moveRight(), new Leaf(new AnimalPt(254, 85)));

        t.checkExpect(
                myWorld.leafs.moveLeft(leafS15),
                new ArrayList<Leaf>(Arrays.asList(
                        new Leaf(new AnimalPt(21, 85)), new Leaf(new AnimalPt(
                                71, 85)), new Leaf(new AnimalPt(246, 85)))));
        t.checkExpect(
                myWorld.leafs.moveRight(leafS15),
                new ArrayList<Leaf>(Arrays.asList(
                        new Leaf(new AnimalPt(29, 85)), new Leaf(new AnimalPt(
                                79, 85)), new Leaf(new AnimalPt(254, 85)))));

        t.checkExpect(
                myWorld.leafs.move(),
                new Leafs(myWorld.leafs.moveLeft(leafS1), myWorld.leafs
                        .moveRight(leafS2), myWorld.leafs.moveLeft(leafS3),
                        myWorld.leafs.moveRight(leafS4)));

    }

}