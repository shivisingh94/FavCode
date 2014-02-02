// Assignment 4
// Pair 012
// Singh Shivanjali
// ssingh94
// Patel Premal
// Premal16

import tester.Tester;

public class ExamplesBook {
    Book b1 = new Book("To Kill a Mockingbird", "Lee Harper", 200);
    Book b2 = new Book("Crime and Punishment", "Fyodor Dostoyevsky", 4536);
    RefBook r1 = new RefBook("Encyclopedia Brittanica", 203);
    RefBook r2 = new RefBook("Webster's Dictionary", 786);
    AudioBook a1 = new AudioBook("The Good Earth", "Pearl S. Buck", 987);
    AudioBook a2 = new AudioBook("Aladdin", "Disney", 986);

    void testdaysOverdue(Tester t) {
        t.checkExpect(b1.daysOverdue(211), -3);
        t.checkExpect(b1.daysOverdue(240), 26);
        t.checkExpect(r1.daysOverdue(251), 46);
        t.checkExpect(r2.daysOverdue(786), -2);
        t.checkExpect(a1.daysOverdue(990), -11);
        t.checkExpect(a2.daysOverdue(1001), 1);
    }

    void testisOverdue(Tester t) {
        t.checkExpect(b1.isOverdue(211), false);
        t.checkExpect(b2.isOverdue(4540), false);
        t.checkExpect(r1.isOverdue(205), false);
        t.checkExpect(r2.isOverdue(802), true);
        t.checkExpect(a1.isOverdue(997), false);
        t.checkExpect(a2.isOverdue(1023), true);
    }

    void testcomputeFine(Tester t) {
        t.checkExpect(b1.computeFine(211), 0);
        t.checkExpect(b2.computeFine(4600), 500);
        t.checkExpect(r1.computeFine(251), 460);
        t.checkExpect(r2.computeFine(786), 0);
        t.checkExpect(a1.computeFine(990), 0);
        t.checkExpect(a2.computeFine(1001), 20);
    }

}