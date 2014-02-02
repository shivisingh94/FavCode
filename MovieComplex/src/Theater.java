/* 
 * Shivi Singh 
 * singh.sh@husky.neu.edu
 * Fun Homework! However, I was not able to implement as specifically and 
 * thoroughly as I wanted to. Wish we were not assigned this during break as 
 * tutor help was vital also was not familiar with concept of console use going 
 * in.Really wish we had more time! We had 3 weeks for  Black Red trees and 
 * think this should have had 2 weeks.Otherwise, I really learned a lot from 
 * this assignment -- great little sneak peek into software designing!
 */

/**
 * @author Shivi Singh 
 * @version Dec 4 2013 v1.0 
 *
 */
public class Theater {

    /**
     * Name of the Theater
     */
    String name;
    /**
     * id of the theater
     */
    int id;
    /**
     * seating the ther theater
     */
    int seating;

    /**
     * @param id int id for the theater
     * @param n String for the name of theater
     * @param s int for the seating in the theater 
     */
    public Theater(int id, String n, int s) {
        name = n;
        this.id = id;
        seating = s;
    }

    /**
     * @return String name of theater
     */
    public String getTheaterName() {
        return name;
    }

    /**
     * @return int the seating capacity in the theater 
     */
    public int getseating() {
        return seating;
    }

    /**
     * @return int the id of the theater
     */
    public int getid() {
        return id;
    }

}
