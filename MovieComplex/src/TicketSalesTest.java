import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 * @author Shivi Singh 
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
