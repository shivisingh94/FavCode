
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shivi Singh 
 *
 */

public class CinemaComplex {

    // create Arraylists for movie, theater and show objects
    /**
     * ArrayList of Movies in which Movies will be housed
     */
    public List<Movie> movies = new ArrayList<Movie>();
    /**
     *ArrayList of Theaters in which Theaters will be houses 
     */
    public List<Theater> theaters = new ArrayList<Theater>();
    /**
     * ArrayList of Shows in which shows will be housed
     */
    public List<Show> showtimes = new ArrayList<Show>();
    /**
     * price of child ticket
     */
    public int childprice;
    /**
     * price of the adult ticket
     */
    public int adultprice;
    /**
     * price of the senior price 
     */
    public int seniorprice;

    /**
     * Initiating data for the Cinema Complex.. the constructor 
     */
    public CinemaComplex() {
        childprice = 0;
        adultprice = 0;
        seniorprice = 0;

    }

    /**
     * @return int that is the value of the childprice 
     */
    public int getchildprice() {
        return childprice;

    }

    /**
     * @return int that is the value of the adultprice
     */
    public int getadultprice() {
        return adultprice;

    }

    /**
     * @return int that is the value of the seniorprice
     */
    public int getseniorprice() {
        return seniorprice;

    }

    /**
     * @param p int to which the child price will be set to be 
     */
    public void changechildprice(int p) {
        childprice = p;

    }

    /**
     * @param p int to which the adult price will be set to be 
     */
    public void changeadultprice(int p) {
        adultprice = p;

    }

    /**
     * @param p int to which the senior price will be set to be 
     */
    public void changeseniorprice(int p) {
        seniorprice = p;

    }

    /**
     * @param m Movie that will be added to the Cinema's array list of movies 
     */
    public void addMovie(Movie m) {
        movies.add(m);

    }

    /**
     * @param t Theater that will be added to the Cinema's array 
     * list of theaters
     */
    public void addTheater(Theater t) {
        theaters.add(t);

    }

    /**
     * @param s Show that will be added to the Cinema's array 
     * list of Show
     */
    public void addShow(Show s) {
        showtimes.add(s);
    }

    /**
     * Creates a list of movies in the Movie arraylist in this CinemaComplex
     */
    public void listMovies() {
        for (Movie m : movies) {
            System.out.println(m.movieName());
        }
    }

    /**
     * Creates a list of theaters in the Theater arraylist in this CinemaComplex
     */
    public void listTheaters() {

        System.out.println("theaters: " + theaters.size());
    }

    /**
     * Creates a list of  and showtimes in the Showtime arraylist in 
     * this CinemaComplex
     */
    public void listMovieShowtimes() {
        int i = 1;
        for (Show s : showtimes) {
            System.out.println(i + ") " + "ID :" + s.getMovieId() + ","
                    + s.getTheaterId() + "\tShowtime: " + s.getShowtime()
                    + "\tmovie: " + movies.get(s.getMovieId() - 1).movieName()
                    + "\tDuration: "
                    + movies.get(s.getMovieId() - 1).getduration()
                    + " \tTheater: "
                    + theaters.get(s.getTheaterId() - 1).getTheaterName());
            i++;
        }
    }
    
  
    /*
     * public boolean overlap(Show show1, Show show2) { int show1start =
     * show1.getShowtime(); //int show2start = show2.getShowtime(); //int
     * show1end = (show1.getShowtime() + this.movies.get(show1.getMovieId() -
     * 1).getduration()); int show2end = (show2.getShowtime() +
     * this.movies.get(show1.getMovieId() - 1).getduration()); int show1duration
     * = this.movies.get(show1.getMovieId() - 1).getduration(); int
     * show2duration = this.movies.get(show1.getMovieId() - 1).getduration();
     * 
     * return (0 < (show2end - show1start) && (show2end - show1start) <=
     * (show1duration + show2duration));
     * 
     * }
     */

    /**
     * @param show1 Show that will be compared to existing Shows for overlapping
     * @param show2 Show to which other Show is being compared
     * @return boolean as to whether overlap occurred 
     */
    public boolean overlap(Show show1, Show show2) {
        int show1start = show1.getShowtime();
        int show2start = show2.getShowtime();
        int show1end = (show1.getShowtime() + this.movies.get(
                show1.getMovieId() - 1).getduration());
        int show2end = (show2.getShowtime() + this.movies.get(
                show1.getMovieId() - 1).getduration());

        return (show1start > show2start && show1start < show2end
                || show1end > show2start && show1end < show2end || 
                show1start < show2start
                && show1end > show2end);

    }

/*
    public void notimeclashconsole(Show s) {
        boolean clash = false;
        for (int i = 0; i < this.showtimes.size(); i++) {
            if (this.showtimes.get(i).getTheaterId() == s.getTheaterId()) {
                clash = overlap(s, this.showtimes.get(i));
                break;
            }
        }
        if (clash) {
            System.out.println("TIME CLASH! Cannot add movie" + s.toString());
        } else {
            this.addShow(s);

        }
    }
*/
    /**
     * @param s Show being passed in to check for time classes 
     */
    public void notimeclash3(Show s) {
        boolean clash = false;
        for (int i = 0; i < this.showtimes.size(); i++) {
            if (this.showtimes.get(i).getTheaterId() == s.getTheaterId()) {
                clash = overlap(s, this.showtimes.get(i));
                break;
                // if(this.showtimes.get(i).getShowtime() +
                // this.movies.get(this.showtimes.get(i).getMovieId() -
                // 1).getduration() > s.getShowtime()) {
                // clash = true;
                // break;
            }
        }
        if (clash) {
            System.out.println("TIME CLASH! Cannot add movie" + s.toString());
        } 
        else {
            this.addShow(s);
        }
    }
}

