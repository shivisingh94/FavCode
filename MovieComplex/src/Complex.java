
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Shivi Singh 
 *
 */
public class Complex {
    /**
     * Scanner that makes it possible to take in the txt
     */
    static Scanner scan = new Scanner(System.in);
    /**
     * Initiating a new TicketSales in which everything will occur
     */
    public static TicketSales ts = new TicketSales();
    /**
     * Name of the user 
     */
    static String name;
   
    /**
     * Number of tickets needed
     */
    static int number;
   

    /**
     * Prompts for user name to create a friendlier experience. Initial of the 
     * customer interface
     */
    public static void userName() {
        System.out.println("Hello! Please enter your name");
        name = scan.nextLine();
        System.out.println("Welcome to the movie theater " + name);
        userMovie();
    }


    /**
     * prompts user for the movie + showtime desired
     */
    public static void userMovie() {
        if (!(ts.cc.showtimes.isEmpty())) {
            System.out
                    .println("Below are the movies showing today and " + 
                "their show times");
            ts.cc.listMovieShowtimes();
            System.out
                    .println("Please enter the number of the movie you " +
                "would like to watch");
            number = scan.nextInt();
            System.out.println("You selected the following movie and showtime:"
                    + ts.cc.movies.get(number - 1).movieName() + ", "
                    + ts.cc.showtimes.get(number - 1).getShowtime());
            userSeat();
        } 
        else {
            System.out
                    .print("Sorry there are no movies playing right now. " +
                "Come back later for more movies!\n\n");
            whoiswho(); 
        }
    }

    /**
     * prompts user for the seats demanded
     */
    public static void userSeat() {
        System.out.println("How many seats would you like?");
        int seats = scan.nextInt();
        System.out.println("How many children's tickets?");
        int childseats = scan.nextInt();
        System.out.println("How many adult tickets?");
        int adultseats = scan.nextInt();
        System.out.println("How many senior's tickets?");
        int seniorseats = scan.nextInt();
        if ((childseats + adultseats + seniorseats) == seats) {
            if ((childseats + adultseats + seniorseats) <= ts.cc.showtimes.get(
                    number - 1).getremainingseats()) {
                System.out.println("Please review your order:\n" + childseats
                        + " Children's tickets\n" + adultseats
                        + " Adult tickets\n" + seniorseats
                        + " Senior's tickets\n");
            } 
            else {
                System.out
                        .println("Sorry there are not enough seats to " + 
                    "match your ticket demand. Would you " + 
                    "like to try again or exit? (try again " +
                    "or exit)");
                String choice = scan.nextLine();
                if (choice.equals("try again")) {
                    userSeat();
                } 
                else if (choice.equals("exit")) {
                    whoiswho();
                } 
                else {
                    System.out
                            .println("Invalid request, sending " +
                            		"to ticket screen");
                    userSeat();
                }
            }
        } 
        else {
            System.out
                    .println("The number of tickets ordered does not " +
                    		"equal total seats needed. Please try again");
            userSeat();
        }
    }

    /**
     * @param num int of adult tickets sold 
     * @param num2 int of child tickets sold 
     * @param num3 int of senior tickets sold 
     */
    public static void totalprice(int num, int num2, int num3) {
        int total = num * ts.cc.getadultprice() + num2 * ts.cc.getchildprice()
                + num3 * ts.cc.getseniorprice();
        ts.cc.showtimes.get(number - 1).updatetickets(num, num2, num3);
        System.out.println(ts.cc.showtimes.get(number - 1).toString());
        System.out.println("Your total is: " + total + "\nEnjoy watching "
                + ts.cc.movies.get(number - 1).movieName() + " in theater "
                + ts.cc.theaters.get(number - 1).getTheaterName()
                + "\nSee you soon!");

        whoiswho();

    }

    /*
    public static void theatercheck(Theater t, Integer n1, Integer n2) {
        if (!ts.cc.theaters.isEmpty()) {
            // if (theaterid > 1) {
            for (int show = 0; show < ts.cc.showtimes.size() - 1; show++) {
                if (ts.cc.showtimes.get(show).getset2() == n1.toString() + ","
                        + n2.toString()) {
                    System.out.println("Theater ID "
                            + ts.cc.theaters.get(show).getid()
                            + " already exists for theater "
                            + ts.cc.theaters.get(show).getTheaterName()
                            + "\t Please try again!");
                    addMovies();
                } else {
                    ts.cc.addTheater(t);
                }
            }
        }*/
        /*
          * else { if (!(ts.cc.theaters.get(theaterid - 1).getTheaterName() ==
          * movietheater)) { System.out.println("Theater ID " +
          * ts.cc.theaters.get(theaterid - 1).getid() +
          * " already exists for theater " + ts.cc.theaters.get(theaterid - 1)
          * .getTheaterName() + "\t Please try again!"); addMovies(); } else {
          * ts.cc.addTheater(t); } } }
          *//*
        else {

            ts.cc.addTheater(t);

        }
    }
*/
    /**
     * Manager interface that allows for addition of movie,theater and show to 
     * the Cinema  
     */
    public static void addMovies() {
        System.out
                .println("Below are the current movies playing, " +
                		"their showings and respective theaters\n");
        ts.cc.listMovieShowtimes();
        System.out
                .println("Please enter the movie ID (MUST be " +
                		"entered in sequential,progressive order): ");
        int movieid = scan.nextInt();
        scan.nextLine();
        System.out.println("What is the name of the movie? ");
        String movietitle = scan.nextLine();
        System.out.println("What is the duration of the movie? ");
        int movietime = scan.nextInt();
        scan.nextLine();
        System.out.println("In what theater is the movie playing?");
        String movietheater = scan.nextLine();
        System.out
                .println("Please enter the theater ID (MUST be " +
                		"entered in sequential,progressive order): ");
        int theaterid = scan.nextInt();
        scan.nextLine();
        System.out.println("What is the  capacity of the theater?");
        int theaterseats = scan.nextInt();
        scan.nextLine();
        System.out.println("What is the showtime for the movie?");
        int movieshowtime = scan.nextInt();
        scan.nextLine();
        Movie m = new Movie(movieid, movietitle, movietime);
        Theater t = new Theater(theaterid, movietheater, theaterseats);
        Show s = new Show(movieid, theaterid, movieshowtime);
        s.setremainingseats(t.getseating());
        ts.cc.notimeclash3(s);
        ts.cc.addTheater(t);
        ts.cc.addMovie(m);
        managerchanges();
    }

    /**
     * Allows manager to change the ticket prices 
     */
    public static void changePrice() {
        System.out.println("Below are the current ticket prices: ");
        System.out.println("Children's " + ts.cc.getchildprice() + "\n Adult "
                + ts.cc.getadultprice() + "\n Senior's "
                + ts.cc.getseniorprice());
        System.out
                .println("Which ticket price would you like to change? " +
                		"(Children's, Adult or Senior's)");
        String answer = scan.nextLine();
        System.out.println("What is the new price? ");
        int price = scan.nextInt();
        scan.nextLine();
        if (answer.equals("Children's")) {
            ts.cc.changechildprice(price);
            System.out.println("Children's price changed!");
            managerchanges();
        } 
        else if (answer.equals("Adult")) {
            ts.cc.changeadultprice(price);
            System.out.println("Adult price changed!");
            managerchanges();
        } 
        else if (answer.equals("Senior's")) {
            ts.cc.changeseniorprice(price);
            System.out.println("Senior's price changed!");
            managerchanges();
        } 
        else {
            System.out
                    .println("Please enter the correct ticket type!" +
                    		"Children's, Adult or Senior's");
            managerchanges();
        }
    }


    /**
     * Manager interface in which manager can choose which action to perform 
     */
    public static void managerchanges() {
        System.out
                .println("Would you like to add movies, showtimes" + " " +
                        		"and/or theaters, access manager report " +
                        		"or change prices? " +
                        		"(add, access, change or exit)");
        String manageraction = scan.nextLine();
        if (manageraction.equals("add")) {
            addMovies();
        } 
        else if (manageraction.equals("access")) {
            managerreport();
            accessreports();
        } 
        else if (manageraction.equals("change")) {
            changePrice();
        } 
        else if (manageraction.equals("exit")) {
            whoiswho();
        } 
        else {
            System.out.println("invalid action!");
            managerchanges();
        }
    }

    /**
     * Allows manager to access the manager report 
     */
    public static void accessreports() {

        System.out.print(readmanagerreport());
        System.out.println("Would you like to exit? (yes or no)");
        String answer = scan.nextLine();
        if (answer.equals("yes")) {
            managerchanges();
        }

    }

    /**
     * Initial Screen that allows user to go in as customer or manager
     */
    public static void whoiswho() {
        System.out.println("Are you a customer or manager?");
        String usertype = scan.nextLine();
        if (usertype.equals("customer")) {
            userName();
        } 
        else if (usertype.equals("manager")) {
            managerchanges();
        } 
        else {
            System.out.println("Invalid usertype!");
            whoiswho();
        }

    }

    /**
     * Creates the manager report for the changes occuring cause by purchases
     */
    public static void managerreport() {
        PrintStream manager;
        Date date = new Date();
        try {
            manager = new PrintStream(new File("consolemanagerReport.txt"));
            manager.println("Manager Report as of " + date);
            for (int s = 0; s < ts.cc.showtimes.size(); s++) {
                manager.println(ts.cc.movies.get(
                        ts.cc.showtimes.get(s).getMovieId() - 1).movieName()
                        + ","
                        + ts.cc.theaters.get(
                                ts.cc.showtimes.get(s).getTheaterId() - 1)
                                .getTheaterName()
                        + ","
                        + ts.cc.showtimes.get(s).getShowtime()
                        + ","
                        + ts.cc.showtimes.get(s).gettotalseats()
                        + ","
                        + ts.cc.showtimes.get(s).getadultsold()
                        + ","
                        + ts.cc.showtimes.get(s).getchildsold()
                        + ","
                        + ts.cc.showtimes.get(s).getseniorsold());

            }
            manager.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * @return String of the manager report created earlier -- allows manager
     * to view the report 
     */
    public static String readmanagerreport() {
        String s = "";
        Scanner managerReport;
        try {
            managerReport = new Scanner(new File("consolemanagerReport.txt"));
            while (managerReport.hasNext()) {
                String line = managerReport.nextLine();
                s = s + line + "\n";
            }
            managerReport.close();
            // System.out.println(s);

        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return s;

    }

    /**
     * @param args Array of String housing teh argument -- Runs the whole 
     * console program 
     */
    public static void main(String[] args) {

        whoiswho();
        // managerreport();
        // accessreports();
    }

}
