import java.io.FileNotFoundException;
import java.util.ArrayList;
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
 *  * @version Dec 4 2013 v1.0 
 *
 */
class TicketSalesTest {
    // CinemaComplex c = new CinemaComplex();
    // Movie m = new Movie(4, "YOLO", 890);
    // Theater th = new Theater(4, "A", 300 );
    // Show s = new Show(1, 4, 4,840);
    // public void testMethods(Tester t) {
    // c.addMovie(m);
    // c.addTheater(th);
    // c.addShow(s);
    // c.managerticketreport(3);
    //
    /**
     * @param args Array of String with all arguments 
     * @throws FileNotFoundException Exception to satisfy webcat 
     */
    public static void main(String[] args) throws FileNotFoundException {
        TicketSales prog = new TicketSales();
        //
        prog.initCinema("C:\\Users\\mommy\\workspace\\MovieComplexhw10\\" +
        		"src\\cinema.txt");
        prog.processOrders("C:\\Users\\mommy\\workspace\\MovieComplexhw10\\" +
        		"src\\orders.txt");

        String sales = prog.reportSales();

        String manager = prog.managerReport();
        String log = prog.logReport();
        // //
        //
        // }

    }
}