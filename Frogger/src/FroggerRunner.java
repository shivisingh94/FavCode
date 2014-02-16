// Assignment 12
// Pair 107
// Singh Shivanjali
// ssingh94
// Lin Hailu 
// hailu

//Houses the class for running this game
public class FroggerRunner {
    ExamplesFrogger ef = new ExamplesFrogger();

    boolean run() {
        return this.ef.myWorld.bigBang(800, 650, 0.1);
    }

    // invoke this method to run the frogger game
    public static void main(String[] argv) {
        FroggerRunner fr = new FroggerRunner();
        fr.run();
    }
}
