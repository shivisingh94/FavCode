package rbtree;

import java.util.Comparator;

import tester.Tester;

public class Examplesrbtree {
public void testMethods(Tester t) { 
    Comparator<String> sbl = new StringByLength();
    Comparator<String> sblex = new StringByLex();
    RBT rbtree2 = RBT.empty(sblex); 
    rbtree2 = rbtree2.add("computers"); 
    rbtree2 = rbtree2.add("blank"); 
    t.checkExpect(rbtree2.left.color.equals("RED")); 
    t.checkExpect(rbtree2.left.makeblack().color.equals("BLACK")); 
    t.checkExpect(rbtree2.getleft().val.equals("blank")); 
   
    RBT rbtree = RBT.empty(sbl); 
        rbtree = rbtree.add("hello"); 
        rbtree = rbtree.add("yolo"); 
        rbtree = rbtree.add("bye"); 
        rbtree = rbtree.add("latergator"); 
//        rbtree = rbtree.balancethis(); 
        System.out.println(rbtree.left); 
        System.out.println(rbtree.right); 
        System.out.println(rbtree);
        t.checkExpect(rbtree.memberMethod("goodbye"), false); 
        t.checkExpect(rbtree.memberMethod("bye"), true); 
        t.checkExpect(rbtree.memberMethod("latergator"), true);
        t.checkExpect(rbtree.left.isRed(),false); 
        t.checkExpect(rbtree.isRed(), true); 
        t.checkExpect(rbtree.right.right.isRed(), true); 
        t.checkExpect(rbtree.right.getright().getright().equals(new Empty(sbl)), true); 
        t.checkExpect(rbtree.getright().getright().val.equals("latergator"));
        t.checkExpect(rbtree.getleft().val.equals("bye"));
        t.checkExpect(rbtree.countblacks()==2); 
        t.checkExpect(rbtree2.countblacks() == 1);  
   } /*
    public static void main(String[] args) {
        Comparator<String> sbl = new StringByLength();
        Comparator<String> sblex = new StringByLex();
        RBT rbtree = RBT.empty(sbl); 
        rbtree = rbtree.balancethis(); 
        rbtree = RBT.insert(rbtree,"hello");
        rbtree = RBT.insert(rbtree,"yolo"); 
        rbtree = RBT.insert(rbtree,"bye"); 
        rbtree = RBT.insert(rbtree,"latergator"); 
        rbtree = RBT.insert(rbtree, "northeastern"); 
        rbtree = RBT.insert(rbtree, "shivisingh"); 
        rbtree = RBT.insert(rbtree, "lolcatz"); 
        rbtree = RBT.insert(rbtree,"lolcatz2");
        rbtree = RBT.insert(rbtree, "lolcatz23"); 
        //System.out.println(rbtree.add("ay").add("bye").add("yoyoooo").add("supercali"));

        System.out.println(rbtree.left.toString()); 
        System.out.println(rbtree.right.toString());
        System.out.println(rbtree.toString()); 
        System.out.println(rbtree.countblacks()); 
        RBT rbtree2 = RBT.empty(sblex); 
        rbtree2 = RBT.insert(rbtree2,"state"); 
        rbtree2 = RBT.insert(rbtree2, "university"); 
        rbtree2 = RBT.insert(rbtree2,"wolfpack"); 
        rbtree2 = RBT.insert(rbtree2, "north"); 
        rbtree2 = RBT.insert(rbtree2,"carolina"); 
        rbtree2 = RBT.insert(rbtree2, "ncsu"); 
        rbtree2 = RBT.insert(rbtree2,"computer"); 
        rbtree2 = RBT.insert(rbtree2, "science"); 
        rbtree2 = RBT.insert(rbtree2,"sciences"); 

        System.out.println(rbtree2); 
        System.out.println(rbtree2.countblacks()); 
        
    } */

}

