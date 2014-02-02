/* 
Shivi Singh 
singh.sh@husky.neu.edu 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import tester.Tester;

/**
 * @author Shivi Singh
 * @version Oct 19 2013 Houses the tests for BTree as well as the method used 
 *          to measure time
 */
public class ExamplesBTree {
    /**
     * Comparator StringByLength that compares string lengths
     **/
    StringByLength sbl = new StringByLength();
    /**
     * Comparator StringByLex that compares string lexicons
     */
    StringByLex sblex = new StringByLex();
    /**
     * BTree ordered by string length initiated by bintree
     */
    BTree btreebylength2 = BTree.binTree(sbl);
    /**
     * BTree ordered by string lexicon initiated by bintree
     */
    BTree btreebylex2 = BTree.binTree(sblex);
    /**
     * BTree ordered by string length initiated by bintree
     */
    BTree btreebylength3 = BTree.binTree(sbl);
    /**
     * BTree ordered by string lexicon initiated by bintree
     */
    BTree btreebylex3 = BTree.binTree(sblex);

    /**
     * @param t
     *            Tester imported from the java tester.Tester file; built in
     *            Java makes it possible to test methods given a true/false
     *            scenario
     */
    public void testMethods(Tester t) {
        
        t.checkExpect(btreebylength2.isEmpty(), true);
        t.checkExpect(btreebylex2.isEmpty(), true);
        btreebylength2.add("Hello");
        btreebylength2.add("Bye");
        btreebylength2.add("c"); 
        System.out.println(btreebylength2);
        btreebylex2.add("a"); 
        btreebylex2.add("b"); 
        btreebylex2.add("c"); 
        btreebylex2.add("d"); 
        System.out.println(btreebylex2); 
        t.checkExpect(btreebylength2.rbtree.left.val.equals("Bye"), true);
        btreebylength3.add("Goodbye");
        btreebylength3.add("Vamanos");
        btreebylength3.add("chalo");
        btreebylength3.add("cu");
        
        System.out.println(btreebylength3);
        
        System.out.println(btreebylength3.rbtree.left.val);
        System.out.println(btreebylength3.rbtree.left.left.val);
        System.out.println(btreebylength3.rbtree.val);
        
        t.checkExpect(btreebylength3.rbtree.left.left.val.equals("cu"), true);
        //t.checkExpect(btreebylength3.rbtree.val.equals("chalo"), true);
        //t.checkExpect(btreebylength3.rbtree.right.val.equals("Goodbye"), true);
        /*
        btreebylex3.add("Hello");
        btreebylex3.add("Bye");
        btreebylex3.add("Goodbye");
        btreebylex3.add("Vamanos");
        btreebylex3.add("chalo");
        btreebylex3.add("cu");
        t.checkExpect(btreebylex3.rbtree.right.val.equals("Vamanos"), true);
        t.checkExpect(btreebylex3.rbtree.left.val.equals("Bye"), true);
        t.checkExpect(btreebylex3.rbtree.left.right.val.equals("Goodbye"), true);
        t.checkExpect(btreebylex3.isIn("chalo"), true);
        t.checkExpect(btreebylex3.rbtree.right.right.val.equals("chalo"), true);
        t.checkExpect(btreebylex3.rbtree.right.right.right.val.equals("cu"), true);
        btreebylex3.add("chalo");
        t.checkExpect(btreebylex3.rbtree.right.right.val.equals("chalo"), true);
        t.checkExpect(btreebylex3.rbtree.right.right.right.val.equals("cu"), true);
        t.checkExpect(btreebylength2.isIn("laterall"), false);
        t.checkExpect(btreebylex2.isIn("yolo"), false);
        t.checkExpect(btreebylength2.isEmpty(), false);
        t.checkExpect(btreebylex2.isEmpty(), false);
        btreebylength2.iterator();
        t.checkExpect(btreebylength2.iters == 1, true);
        btreebylex2.iterator();
        btreebylex2.iterator();
        t.checkExpect(btreebylex2.iters == 2, true);
        t.checkExpect(btreebylex2.count() == 6, true);
        t.checkExpect(btreebylength2.count() == 4, true);
        t.checkExpect(btreebylength2.rbtree.left.countthis() == 2, true);
        t.checkExpect(btreebylex2.rbtree.right.countthis() == 3, true);
        btreebylength2.build(btreebylength2);
        t.checkExpect(btreebylength2.equals(btreebylength2), true);
        t.checkExpect(btreebylength2.equals(btreebylex2), false);
        t.checkExpect(btreebylength2.hashCode() == (btreebylength2.hashCode()));
        btreebylex2.build(btreebylex2, 4);
        t.checkExpect(btreebylex2.count() == 4, true);
        t.checkExpect(btreebylength2.toString().equals(
                "cu, Bye, Hello, Goodbye"), true);
        t.checkExpect(
                btreebylex2.toString().equals(
                        "Bye, Goodbye, Hello, Vamanos, chalo, cu"), true);
        t.checkExpect(btreebylex2.contains("cu"), true);
        t.checkExpect(btreebylex2.contains("yolo"), false);
        Iterator<String> bylengthiter = btreebylength2.iterator();
        t.checkExpect(bylengthiter.next().equals("cu"), true);
        bylengthiter.next();
        bylengthiter.next();
        t.checkExpect(bylengthiter.next().equals("Goodbye"), true);
        t.checkExpect(bylengthiter.hasNext(), false);
        Iterator<String> bylexiter = btreebylex2.iterator();
        t.checkExpect(bylexiter.next().equals("Bye"), true);
        bylexiter.next();
        bylexiter.next();
        t.checkExpect(bylexiter.next().equals("Vamanos"), true);
        t.checkExpect(bylexiter.hasNext(), true);
        t.checkExpect(sbl.compare("Hello", "Bye") < 0, true);
        t.checkExpect(sbl.compare("Hello", "Hello") == 0, true);
        t.checkExpect(sbl.compare("Hello", "Vamanos") > 0, true);
        t.checkExpect(sblex.compare("Hello", "Bye") < 0, true);
        t.checkExpect(sblex.compare("Hello", "Hello") == 0, true);
        t.checkExpect(sblex.compare("Hello", "Vamanos") > 0, true);
       */
    }

    /**
     * @author Shivi Singh
     * @version Oct 19 2013
     * 
     *          Class that houses the time testing function and the main method
     *          to execute it
     */
    public static class Examples {

        /**
         * Returns the timing for build, contains and iteration functions for
         * the given comparators, txt files and number of strings
         * 
         */
        public void buildTiming() {
            StringByLex lex = new StringByLex();
            StringReverseByLex revlex = new StringReverseByLex();
            StringWithOutPrefixByLex preflex = new StringWithOutPrefixByLex();
            ArrayList<Comparator<String>> allcomps = 
                    new ArrayList<Comparator<String>>();
            allcomps.add(lex);
            allcomps.add(revlex);
            allcomps.add(preflex);
            ArrayList<String> allfiles = new ArrayList<String>(Arrays.asList(
                    "lexicographically_ordered.txt", "reverse_ordered.txt",
                    "prefix_ordered.txt", "random_order.txt", "iliad.txt",
                    "hippooath_DUPLICATES.txt"));
            ArrayList<Integer> allnums = new ArrayList<Integer>(Arrays.asList(
                    2000, 4000, 8000, 16000, 20000, 24000));

            for (Comparator<String> comps : allcomps) {
                for (String files : allfiles) {
                    for (Integer n : allnums) {
                        BTree bt = new BTree(comps);
                        long startbuild = System.currentTimeMillis();
                        bt.build(new StringIterator(files), n);
                        long endbuild = System.currentTimeMillis();
                        long startcontains = System.currentTimeMillis();
                        int count = 0;
                        StringIterator iter = 
                                new StringIterator("contains.txt");
                        for (String s : iter) {

                            bt.contains(s);
                            count++;
                        }
                        long endcontains = System.currentTimeMillis();
                        long startiterations = System.currentTimeMillis();
                        Iterator<String> it = bt.iterator();
                        while (it.hasNext()) {
                            it.next();
                        }

                        long enditerations = System.currentTimeMillis();
                        System.out.println(comps + "\t" + files + "\t" + n
                                + "\t" + (endbuild - startbuild) + "\t"
                                + (enditerations - startiterations) + "\t"
                                + (endcontains - startcontains) + "\t" + count);
                    }
                }
            }
        }

        /**
         * @param args
         *            ArrayList<String> that is arbitrary for main method to
         *            work and printout info based on buildTiming method
         */
        /*public static void main(String[] args) {
            Examples ex = new Examples();
            ex.buildTiming();
        }
        */
    }
}
