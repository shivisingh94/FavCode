/* 
Shivi Singh 
singh.sh@husky.neu.edu
This was a very tough one!! Took a long time to understand  and still unsure 
about the implementation. The tutors I contacted did not understand the 
abstraction function - neither did most of the students I asked- and therefore 
it was very difficult to find out what exactly the abstraction function was 
supposed to be written.. however I tried my best to fulfill it! 
 */

/* 
 * ABSTRACTION FUNCTION: 
 * AF(R) : AF(left) + label + AF(right) 
 */
/* 
 * Rep Invariant 
 * (Btree != null) && (Btree.left.label instanceof String)
                && (Btree.right.label instanceof String)
                && (Btree.comp.compare(Btree.label, this.left.label) < 0)
                && (Btree.comp.compare(Btree.right.label, this.label) < 0)
                && (Btree.right.repOk()) && (Btree.left.repOk());

 */
import java.util.*;
import rbtree.RBT;

/**
 * BTree is a class that represents a binary search based Iterable<String>
 * 
 * @author Shivi Singh
 * @version 10-07-2013
 */
public class BTree implements Iterable<String> {
    RBT rbtree; 
    Comparator<String> comp;
    /**
     * is the Btree empty
     */
    boolean empty;
    /**
     * houses the number of iterators applied
     */
    int iters;

    /**
     * @param comp
     *            Comparator<String> that sets the ordering type
     */
    BTree(Comparator<String> comp) {
        this.rbtree = RBT.empty(comp); 
        this.comp = comp;
        this.empty = true;
        this.iters = 0;
    }

    /**
     * checks whether this BTree is empty or not
     * 
     * @return a boolean whether empty or not
     */
    boolean isEmpty() {
        return empty;
    }

    /**
     * calculates the size of this BTree
     * 
     * @return int representing the size of the BTree
     */
    int count() {
        if (this.isEmpty()) {
            return 0;
        } 
        else {
            return 1 + rbtree.left.countthis() + rbtree.right.countthis();
        }
    }

    /**
     * creates a new empty BTree
     * 
     * @param comp
     *            Comparator <String> to order BTree
     * @return an empty BTree
     */
    public static BTree binTree(Comparator<String> comp) {
        return new BTree(comp);
    }

    /**
     * iterator returns the generator BTreeIter
     * 
     * @return initiation of BTreeIter
     */
    public Iterator<String> iterator() {
        iters = iters + 1;
        return new BTreeIter(count(), this.rbtree);
    }

    /**
     * build modifies this BTree by inserting Strings from iter
     * 
     * @param iter
     *            Iterable<String> contains the strings from BTree
     */
    public void build(Iterable<String> iter) {
        if (iters > 0) {
            throw new ConcurrentModificationException(
                    "Iterator already running");
        }
        for (String s : iter) {
            RBT.insert(rbtree,s);
        }
    }

    /**
     * Modifies: this binary search tree by inserting the first numStrings
     * <code>String</code>s from the given <code>Iterable</code> collection The
     * tree will not have any duplicates - if an item to be added equals an 
     * item that is already in the tree, it will not be added.
     * 
     * @param iter
     *            the given <code>Iterable</code> collection
     * @param numStrings
     *            int of <code>String</code>s to iterate through and add to
     *            BTree If numStrings is negative or larger than the number of
     *            <code>String</code>s in iter then all <code>String</code>s in
     *            iter should be inserted into the tree
     */

    public void build(Iterable<String> iter, int numStrings) {
        int n = 0;
        if (this.iters == 0 && n != numStrings) {
            for (String s : iter) {
                RBT.insert(rbtree,s);
                n++;
                if (n == numStrings) {
                    break;
                }
            }
        }
    }

    /**
     * modifies the Btree by inserting the given string s (in order !)
     * 
     * @param s
     *            String to insert into this BTree
     */
    void addHelper(String s) {
        
        if (this.isEmpty()) {
            rbtree = rbtree.add(s); 
            empty = false;
        }
        else if (comp.compare(rbtree.val, s) < 0) {
            rbtree.left = rbtree.left.add(s);
        } 
        else {
            rbtree.right = rbtree.right.add(s);
        }
    }
    /**
     * modifies the Btree by inserting the given string s (in order !) if it is
     * not in there already
     * 
     * @param s
     *            String to insert into this BTree
     */
    void add(String s) { 
        if (!this.contains(s)) { 
            this.addHelper(s);
        }
    }
    /**
     * Does this BTree contain this given string?
     * 
     * @param s
     *            String to check for in this BTree
     * @return boolean representing whether the String is in the BTree or not
     */
    public boolean isIn(String s) {
            return RBT.member(rbtree, s); 
        }

    /**
     * Effect: Checks to see if this BTree contains s
     * 
     * @param s
     *            <code>String</code> to look for in this
     * @return whether this contains s
     */
    public boolean contains(String s) {
        return isIn(s);
    }

    /**
     * String representation of the ordered values in this BTree
     * 
     * @return String representation
     */
    public String toString() {
        String result = "";
        if (empty) {
            return result;
        }
        Iterator<String> g = this.iterator();
        while (g.hasNext()) {
            String s = g.next();
            if (!(g.hasNext())) {
                result = result + s + rbtree.color;
            } 
            else {
                result = result + s + rbtree.color + ", ";
            }
        }
        return result;
    }

    /**
     * equal checks if this BTree and the given Object are equal
     * 
     * @param o
     *            Object to check if equal to this BTree
     * @return boolean representing whether they are equal or not
     */
    public boolean equals(Object o) {
        if (!(o instanceof BTree)) {
            return false;
        } 
        else {
            return this.toString().equals(((BTree) o).toString())
                    && this.comp.equals(((BTree) o).comp);
        }
    }

    /**
     * hashCode returns an identifying int for this BTree
     * 
     * @return int for this BTree
     */
    public int hashCode() {
        return this.toString().hashCode();
    }

    /**
     * Is the Btree representation correct?
     * 
     * @return boolean as to whether this representation is correct for a Btree
     */
    public boolean repOk() {
        return (this != null) && (this.rbtree.left.val instanceof String)
                && (this.rbtree.right.val instanceof String)
                && (this.comp.compare(this.rbtree.val, this.rbtree.left.val) < 0)
                && (this.comp.compare(this.rbtree.right.val, this.rbtree.val) < 0)
                && (this.rbtree.right.repOk()) && (this.rbtree.left.repOk());

    }

    /**
     * Generator class for BTree represented as an Iterator<String> f *
     * 
     * @author Shivi Singh
     * @version 10-07-2013
     */
    class BTreeIter implements Iterator<String> {
        /**
         * my node
         */
        private RBT me;
        /**
         * current subgenerator
         */
        private BTreeIter child;
        /**
         * count f the elements left to generate
         */
        private int cnt;

        /**
         * @param n
         *            int representing the count of BTreeIter
         * @param bt
         *            BTree to which BtreeIter is applied
         */
        BTreeIter(int n, RBT bt) {
            cnt = n;
            if (cnt > 0) {
                me = bt;
                child = new BTreeIter(bt.left.countthis(), bt.left);
            }
        }

        /**
         * hasNext checks whether the BTree has a next String
         * 
         * @return boolean representing whether there is a next String or not
         */
        public boolean hasNext() {
            return (cnt > 0);
        }

        /**
         * returns the next string value in the Btree (if there is one)
         * 
         * @return String representing the next String in the BTree
         */
        public String next() throws NoSuchElementException {
            if (!(this.hasNext())) {
                throw new NoSuchElementException();
            }
            cnt--;
            if (!(this.hasNext())) {
                iters = iters - 1;
            }
            try {
                return child.next();
            } 
            catch (NoSuchElementException e) {
                // Catching this NoSuchElementException
            }
            child = new BTreeIter(cnt, me.right);
            return me.val;
        }

        /**
         * removes the last String from the BTree
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

/**
 * Class used for sorting in the Btree; implements the Comparator<String>
 * 
 * @author Shivi Singh
 * @version 10-07-2013
 * 
 */
class StringByLex implements Comparator<String> {
    /**
     * Compare the two given strings with each other
     * 
     * @param s1
     *            String , first string being compared
     * @param s2
     *            String, second string being compared
     * @return int representing the difference between the given strings
     * 
     */
    public int compare(String s1, String s2) {
        return s2.compareTo(s1);
    }

    /**
     * Equals method to check if this class equals another object
     * 
     * @param o
     *            Object to which this class is being compared
     * @return boolean as to whether this and the given object are equal
     */
    public boolean equals(Object o) {
        return (o instanceof StringByLex);
    }
}

/**
 * Class used for sorting in the Btree; implements the Comparator<String>
 * 
 * @author Shivi Singh
 * @version 10-07-2013
 * 
 */
class StringByLength implements Comparator<String> {
    /**
     * Compare the two given strings with each other
     * 
     * @param s1
     *            String , first string being compared
     * @param s2
     *            String, second string being compared
     * @return int representing the difference between the given strings'
     *         lengths
     */
    public int compare(String s1, String s2) {
        return s2.length() - s1.length();
    }

    /**
     * Equals method to check if this class equals another object
     * 
     * @param o
     *            Object to which this class is being compared
     * @return boolean as to whether this and the given object are equal
     */
    public boolean equals(Object o) {
        return (o instanceof StringByLength);
    }
}

/**
 * Comparator implementation that compares the reverse of the Strings by
 * lexicographical ordering
 * 
 * @author Jessica Young Schmidt jschmidt
 * @version 2013-10-07
 */
class StringReverseByLex implements Comparator<String> {

    /**
     * compares o1 and o2
     * 
     * @param o1
     *            first String in comparison
     * @param o2
     *            second String in comparison
     * @return a negative integer, zero, or a positive integer as the first
     *         argument is less than, equal to, or greater than the second.
     */
    public int compare(String o1, String o2) {
        String s1 = new StringBuffer(o1).reverse().toString();
        String s2 = new StringBuffer(o2).reverse().toString();
        return s1.compareTo(s2);
        
        
        
        
    }

    /**
     * Is this <code>Comparator</code> same as the given object
     * 
     * @param o
     *            the given object
     * @return true if the given object is an instance of this class
     */
    public boolean equals(Object o) {
        return (o instanceof StringReverseByLex);
    }

    /**
     * There should be only one instance of this class = all are equal
     * 
     * @return the hash code same for all instances
     */
    public int hashCode() {
        return (this.toString().hashCode());
    }

    /**
     * @return name of class
     */
    public String toString() {
        return "StringReverseByLex";
    }

}

/**
 * Comparator implementation that compares the Strings without prefix by
 * lexicographical ordering
 * 
 * @author Jessica Young Schmidt jschmidt
 * @version 2013-10-07
 */
class StringWithOutPrefixByLex implements Comparator<String> {

    /**
     * compares o1 and o2
     * 
     * @param o1
     *            first String in comparison
     * @param o2
     *            second String in comparison
     * @return a negative integer, zero, or a positive integer as the first
     *         argument is less than, equal to, or greater than the second.
     */
    public int compare(String o1, String o2) {
        String s1;
        String s2;
        if (o1.length() > 4) {
            s1 = o1.substring(3);
        } 
        else {
            s1 = o1;
        }
        if (o2.length() > 4) {
            s2 = o2.substring(3);
        } 
        else {
            s2 = o2;
        }
        return s1.compareTo(s2);
    }

    /**
     * Is this <code>Comparator</code> same as the given object
     * 
     * @param o
     *            the given object
     * @return true if the given object is an instance of this class
     */
    public boolean equals(Object o) {
        return (o instanceof StringReverseByLex);
    }

    /**
     * There should be only one instance of this class = all are equal
     * 
     * @return the hash code same for all instances
     */
    public int hashCode() {
        return (this.toString().hashCode());
    }

    /**
     * @return name of class
     */
    public String toString() {
        return "StringWithOutPrefixByLex";
    }

}