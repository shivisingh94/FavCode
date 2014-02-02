package rbtree;

import java.util.Comparator;

/** 
 * 
 * @author Shivi Singh 
 * @version 30 Oct 2013 
 *
 */
public abstract class RBT {
  
    public Comparator<String> comp;
    public String color; 
    public RBT right; 
    public RBT  left;
    public String val;
    public abstract int countthis(); 
    public abstract boolean equals(Object o); 
    public abstract RBT balancethis(); 
    abstract RBT balance(RBT a, RBT b, RBT c, RBT d, RBT e); 
    abstract boolean isRed();
    abstract RBT getright();
    abstract RBT makeblack(); 
    abstract RBT getleft();
    abstract boolean memberMethod(String s);
    public abstract RBT add(String s); 
    public static boolean member(RBT rbtree, String s) { 
        return rbtree.memberMethod(s); 
    }
    public static RBT insert(RBT rbtree, String s) { 
        return rbtree.add(s).makeblack().balancethis();
    }
    public static RBT empty(Comparator<String> comp) { 
        return new Empty(comp); 
    }
    abstract int countblacks();

    public abstract boolean repOk();
    public abstract boolean isEmpty(); 
    
}

class Node extends RBT { 
    
    Node(Comparator<String> comp, String val) { 
        this.comp = comp; 
        this.val = val; 
        this.color = "RED"; 
        this.left = new Empty(comp); 
        this.right = new Empty(comp); 
    } 
    
    public boolean isRed(){ 
        return this.color.equals("RED"); 
    }
    public int countthis(){ 
        return 1 + left.countthis() + right.countthis(); 
    }

    public boolean memberMethod(String s) {
        if (comp.compare(val, s) == 0) {
            return true;
        } 
        else if (comp.compare(val, s) < 0) {
            return left.memberMethod(s);
        } 
        else {
            return right.memberMethod(s);
        }
    }

    public RBT add(String s) {
//        System.out.println(this.val + this.comp); 
        if(this.comp.compare(val,s) < 0) { 
            left = left.add(s);
            return this.balancethis(); 
        }
        else if (this.comp.compare(val, s)> 0) { 
            right = right.add(s); 
            return this.balancethis(); 
        }
        else { 
            return this; 
        }
    }
    
    public boolean isEmpty() { 
        return false; 
    }
    public RBT makeblack() { 
        color = "BLACK"; 
        return this;
    } 
    public RBT getleft() { 
        return this.left; 
    }
    public RBT getright() { 
        return this.right; 
    }
    public boolean equals(Object o) { 
        if (!(o instanceof RBT)) {
            return false;
        } 
        else {
            return this.toString().equals(((Node) o).toString())
                    && this.comp.equals(((Node) o).comp);
        }
    }
    
    public RBT balancethis() {
        // Check for two red nodes in a row: Red child and red grandchild
        if (left.isRed() && left.getleft().isRed()) {
            return balance(left.getleft(), left, this,
                    left.getleft().getright(), left.getright()); 
            

        } else if (left.isRed() && left.getright().isRed()) {
            return balance(left, left.getright(), this,
                    left.getright().getleft(), left.getright().getright()); 

        } else if (right.isRed() && right.getleft().isRed()) {
           return balance(this, right.getleft(), right,
                    right.getleft().getleft(), right.getleft().getright());

        } else if (right.isRed() && right.getright().isRed()) {
           return balance(this, right, right.getright(),
                    right.getleft(), right.getright().getleft()); 
        }
        else {
            return this; 
        }
    }
    
    // Used to count he number of black nodes : total black nodes on left = total black nodes on right ;; invariant 2 
    
    public int countblacks() { 
        if(this.color.equals("BLACK")) { 
            return 1 + left.countblacks() + right.countblacks(); 
        }
        else { 
            return left.countblacks() + right.countblacks();
        }
    }
                
    public String toString() { 
        return this.left.toString() + " " + this.val + " " + this.color + " " + this.right.toString(); 
    }
    public RBT balance(RBT a, RBT b, RBT c, RBT d, RBT e) { 
        a.right = d; 
        b.left = a; 
        b.right = c; 
        c.left = e; 
        a.color = "BLACK"; 
        b.color = "RED"; 
        c.color = "BLACK"; 
        return b; 
    }
    
    public boolean repOk() {
        return (this != null) && (left.val instanceof String)
                && (this.right.val instanceof String)
                && (this.comp.compare(val, left.val) < 0)
                && (this.comp.compare(right.val, val) < 0) 
                && (right.countblacks() == left.countblacks())
                && (right.repOk()) && (left.repOk());

    }
}
class Empty extends RBT { 

    Empty(Comparator<String> comp) {
        this.comp = comp; 
    }
    public boolean memberMethod(String s ) { 
        return false; 
    } 
    
    public RBT add(String s) {
       return new Node(comp, s); 
        
        
    }
    public boolean isEmpty() { 
        return true; 
    }
    public int countthis() { 
        return 0; 
    }
    int countblacks() { 
        return 0; 
    }
    boolean isRed() {
        return false; 
    }
    RBT getright() {
        throw new RuntimeException("No right in an empty"); 
    }
    RBT getleft() {
        throw new RuntimeException("No left in an empty"); 
    }
    RBT makeblack() { 
        color = "BLACK"; 
        return this; 
    }
    public RBT balancethis() {
        return this;
    }
    RBT balance(RBT a, RBT b, RBT c, RBT d, RBT e) {
        return this;
    }
    public String toString() { 
        return " "; 
    }
    public boolean repOk() { 
        return this instanceof Empty;   
    }
    public boolean equals(Object o) {
        if (!(o instanceof RBT)) {
            return false;
        } 
        else {
            return this.toString().equals(((Empty) o).toString())
                    && this.comp.equals(((Empty) o).comp);
        }
    }
}
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
}
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