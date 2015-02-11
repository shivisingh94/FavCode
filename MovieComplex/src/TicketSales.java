import java.util.*;
import java.io.*;

/**
 * @author Shivi Singh 
 *
 */
public class TicketSales {
    /**
     * CinemaComplex in which all the magic will occur 
     */
    CinemaComplex cc;

    /**
     * Initiates the class TicketSales that houses all methods to read
     * a txt file 
     */
    public TicketSales() {
        cc = new CinemaComplex();

    }

    /**
     * @param a String -- name of item being passed in, name of file being read
     */
    public void initCinema(String a) {
        Scanner input;
        try {
            input = new Scanner(new File(a));
            while (input.hasNext()) {

                if (input.hasNext("Movies")) {
                    String[] data;
                    int id = 0;
                    input.nextLine();
                    while (input.hasNext()) {

                        id++;
                        String line = input.nextLine();
                        data = line.split(":");
                        System.out.println(data);
                        Movie m = new Movie(id, data[0],
                                Integer.parseInt(data[1]));
                        cc.addMovie(m);
                        System.out.println(cc.movies.get(0).getduration());
                        if (input.hasNext("Theaters")) {
                            break;
                        }

                    }

                } 
                else if (input.hasNext("Theaters")) {
                    String[] data2;
                    int id2 = 0;
                    input.nextLine();
                    while (input.hasNext()) {
                        String line2 = input.nextLine();
                        data2 = line2.split(":");
                        Theater t = new Theater(id2++, data2[0],
                                Integer.parseInt(data2[1]));
                        cc.addTheater(t);
                        if (input.hasNext("Shows")) {
                            break;
                        }
                    }
                } 
                else if (input.hasNext("Shows")) {
                    String[] data3;
                    // int id3 = 0;
                    input.nextLine();
                    while (input.hasNext()) {
                        String line3 = input.nextLine();
                        data3 = line3.split(",");
                        Show s = new Show(Integer.parseInt(data3[0]),
                                Integer.parseInt(data3[1]),
                                Integer.parseInt(data3[2]));
                        s.setremainingseats(cc.theaters.get(
                                Integer.parseInt(data3[1]) - 1).getseating());
                        s.settotalseats(cc.theaters.get(
                                Integer.parseInt(data3[1]) - 1).getseating());
                        cc.notimeclash3(s);
                        // cc.notimeclash(s,data3[0],data3[1]);
                        // cc.addShow(s);

                        if (input.hasNext("Prices")) {
                            break;
                        }
                    }
                } 
                else if (input.hasNext("Prices")) {
                    String[] data4;
                    // int id4 = 0;
                    input.nextLine();
                    while (input.hasNext()) {
                        String line4 = input.nextLine();
                        data4 = line4.split(":");
                        if (data4[0].equals("Adult")) {
                            cc.changeadultprice(Integer.parseInt(data4[1]));
                        } 
                        else if (data4[0].equals("Child")) {
                            cc.changechildprice(Integer.parseInt(data4[1]));
                        } 
                        else if (data4[0].equals("Senior")) {
                            cc.changeseniorprice(Integer.parseInt(data4[1]));
                        }

                        else {
                            break;
                        }

                    }
                }
            }

            input.close();

        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    
    /**
     * @param o String -- process orders creates the array for tickets
     *  requested for the cinema complex
     */
    public void processOrders(String o) {
        int reportcount = 0;
        Scanner input;
        try {
            input = new Scanner(new File(o));
            PrintStream manager = 
                    new PrintStream(new File("managerReport.txt"));
            PrintStream sales = new PrintStream(new File("salesReport.txt"));
            PrintStream log = new PrintStream(new File("logReport.txt"));

            while (input.hasNext()) {
                if (input.hasNext("report")) {
                    reportcount++;
                    input.nextLine();
                    manager.println("Report " + reportcount);
                    for (int s = 0; s < cc.showtimes.size(); s++) {
                        manager.println(cc.movies.get(
                                cc.showtimes.get(s).getMovieId() - 1)
                                .movieName()
                                + ","
                                + cc.theaters.get(
                                        cc.showtimes.get(s).getTheaterId() - 1)
                                        .getTheaterName()
                                + ","
                                + cc.showtimes.get(s).getShowtime()
                                + ","
                                + cc.showtimes.get(s).gettotalseats()
                                + ","
                                + cc.showtimes.get(s).getadultsold()
                                + ","
                                + cc.showtimes.get(s).getchildsold()
                                + ","
                                + cc.showtimes.get(s).getseniorsold());

                    }
                }
                else {
                    String line = input.nextLine();
                    String[] data = line.split("[,]");

                    for (int s = 0; s < cc.showtimes.size(); s++) {
                        System.out.println("orders that ARE IN \t"
                                + cc.showtimes.get(s).toString());
                        if (cc.showtimes
                                .get(s)
                                .getset()
                                .equals(data[0] + "," + data[1] + "," + 
                                data[2])) {
                            System.out.println("orders that get past getset"
                                    + cc.showtimes.get(s).toString());
                            if (cc.showtimes.get(s).getremainingseats() > 
                                (Integer
                                    .parseInt(data[3])
                                    + Integer.parseInt(data[4]) + Integer
                                        .parseInt(data[5]))) {
                                System.out
                                        .println("orders that get past " +
                                    "remainingseats" + cc.showtimes.get(s)
                                                        .toString());

                                Show ss = cc.showtimes.get(s);

                                ss.updatetickets(Integer.parseInt(data[3]),
                                        Integer.parseInt(data[4]),
                                        Integer.parseInt(data[5]));

                                int total = Integer.parseInt(data[3])
                                        * cc.getadultprice()
                                        + Integer.parseInt(data[4])
                                        * cc.getchildprice()
                                        + Integer.parseInt(data[5])
                                        * cc.getseniorprice();
                                sales.println(line + "," + total);
                                log.println(line
                                        + " Order Successfully processed!");
                            } 
                            else {
                                sales.println(line + "," + 0);
                                log.println(line
                                        + " Order NOT processed!"
                                        + " Seats Left :"
                                        + (cc.showtimes.get(s).gettotalseats() 
                                                - cc.showtimes
                                                .get(s).totaltickets())
                                        + "\t Seats Needed : "
                                        + (Integer.parseInt(data[3])
                                                + Integer.parseInt(data[4]) 
                                                + Integer
                                                    .parseInt(data[5])));

                            }
                        }
                    }

                }
            }

            input.close();
            sales.close();
            manager.close();
            log.close();

        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * @return String , reports the tickets sold for each movie/theater
     */
    public String managerReport() {
        String s = "";
        Scanner managerReport;
        try {
            managerReport = new Scanner(new File("managerReport.txt"));
            while (managerReport.hasNext()) {
                String line = managerReport.nextLine();
                s = s + line + "\n";
            }
            managerReport.close();
            System.out.println(s);

        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return s;

    }

    /**
     * @return String , reports the sales of tickets 
     */
    public String reportSales() {
        Scanner salesReport;
        String s2 = "";
        try {
            salesReport = new Scanner(new File("salesReport.txt"));
            while (salesReport.hasNext()) {
                String line = salesReport.nextLine();
                s2 = s2 + line + "\n";
            }
            salesReport.close();
            System.out.println(s2);

        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return s2;
    }

    /**
     * @return String, reports whether orders were processed or not
     */
    public String logReport() {
        Scanner logReport;
        String s1 = "";
        try {
            logReport = new Scanner(new File("logReport.txt"));
            while (logReport.hasNext()) {
                String line = logReport.nextLine();
                s1 = s1 + line + "\n";
            }
            logReport.close();
            System.out.println(s1);

        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return s1;
    }

} 
