// Assignment 4
// Pair 012
// Singh Shivanjali
// ssingh94

public interface IBook {
}

abstract class ABook implements IBook {
    String title;
    String author;
    int dayTaken;

    ABook(String title, String author, int dayTaken) {
        this.title = title;
        this.author = author;
        this.dayTaken = dayTaken;
    }

    /*
     * TEMPLATE 
     * FIELDS 
     * ----- 
     * this.title... --String 
     * this.author... -- String
     * this.dayTaken... --int
     * 
     * METHODS 
     * ------- 
     * ...this.daysOverdue... --int
     * ...this.isOverdue...--boolean 
     * ...this.computeFine... --double
     * 
     * FIELDS FOR METHODS 
     * ---------------- 
     * ...today... --int 
     * ...this.dayTaken... --int
     * 
     * ...this.daysOverdue(int)... --int
     * 
     * ...this.isOverdue(int)... --boolean 
     * ...this.daysOverdue(int)... --int
     */

    int daysOverdue(int today) {
        return (today - this.dayTaken) - 14;

    }

    boolean isOverdue(int today) {
        return this.daysOverdue(today) > 0;
    }

    int computeFine(int today) {
        if (this.isOverdue(today))
            return (10 * this.daysOverdue(today));
        else
            return 0;
    }
}

// Defines what a Book is
class Book extends ABook {
    Book(String title, String author, int dayTaken) {
        super(title, author, dayTaken);
    }
}

// Defines what a RefBook is
class RefBook extends ABook {
    RefBook(String title, int dayTaken) {
        super(title, "", dayTaken);
    }

    int daysOverdue(int today) {
        return (today - this.dayTaken) - 2;
    }
}

// Defines what an AudioBook is
class AudioBook extends ABook {
    AudioBook(String title, String author, int dayTaken) {
        super(title, author, dayTaken);
    }

    int computeFine(int today) {
        if (this.isOverdue(today))
            return (20 * this.daysOverdue(today));
        else
            return 0;

    }
} 
