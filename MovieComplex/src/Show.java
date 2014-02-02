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
public class Show {

    /**
     * Showtime of the Showing
     */
    int showtime;
    /**
     * id of the theater in the Show 
     */
    int theaterId;
    /**
     * id of the movie in the Show
     */
    int movieId;
    /**
     * Adult tickets sold to show
     */
    int adultsold = 0;
    /**
     * Children tickets sold to show
     */
    int childrensold = 0;
    /**
     * Senior tickets sold to show
     */
    int seniorsold = 0;
    /**
     * remaining seats in show
     */
    int remainingseats = 0;
    /**
     * total seats in show = capacity of associated theater 
     */
    int totalseats = 0;

/**
 * @return String with the contents of the Show in string form
 */
    public String toString() {

        Integer showtimeI = showtime;
        Integer theaterIDI = theaterId;
        Integer movieIDI = movieId;
        Integer adultsoldI = adultsold;
        Integer childrensoldI = childrensold;
        Integer seniorsoldI = seniorsold;
        Integer remainingseatsI = remainingseats;

        return "showtime " + showtimeI.toString() + "\n" + "theaterid "
                + theaterIDI.toString() + "\n" + "movidId "
                + movieIDI.toString() + "\n" + "adultsold "
                + adultsoldI.toString() + "\n" + "childrensold"
                + childrensoldI.toString() + "\n" + "seniorsold "
                + seniorsoldI.toString() + "\n" + "remainingseats"
                + remainingseatsI.toString() + "\n" + "nextline";

    }


    /**
     * @param movieId int representing the movieid
     * @param theaterId int representing the theaterid
     * @param showtime int representing the showtime
     */
    public Show(int movieId, int theaterId, int showtime) {
        // this.id = id;
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.showtime = showtime;
        /*
         * int adultsold = 0; int childrensold = 0; int seniorsold = 0; int
         * remainingseats = 0;
         */
        /*
         * childprice = 0; adultprice = 0; seniorprice = 0;
         */
    }

    /**
     * @return String of movieid,theaterid,showtime of the Show
     */
    public String getset() {
        Integer movieId2 = movieId;
        Integer theaterId2 = theaterId;
        Integer showtime2 = showtime;

        return movieId2.toString() + "," + theaterId2.toString() + ","
                + showtime2.toString();
    }

    /**
     * @return String of movieid,theaterid of the Show
     */
    public String getset2() {
        Integer movieId2 = movieId;
        Integer theaterId2 = theaterId;

        return movieId2.toString() + "," + theaterId2.toString();
    }

    /**
     * @return int representing the number of children tickets sold 
     */
    public int getchildsold() {
        return childrensold;

    }

    /**
     * @return int representing the number of the adult tickets sold 
     */
    public int getadultsold() {
        return adultsold;

    }

    /**
     * @return int representing the number of the adult tickets sold 
     */
    public int getseniorsold() {
        return seniorsold;

    }

    /**
     * @return int representing theaterid in this Show
     */
    public int getTheaterId() {
        return theaterId;
    }

    /**
     * @return int representing movieid in this Show 
     */
    public int getMovieId() {
        return movieId;
    }

    /**
     * @return int representing showtime of this Show
     */
    public int getShowtime() {
        return showtime;
    }

    /**
     * @return int representing the remainingseats in this Show
     */
    public int getremainingseats() {
        return remainingseats;
    }

    /**
     * @return int with totalseats in the showing = capacity of theater 
     * associated with the Show 
     */
    public int gettotalseats() {
        return totalseats;
    }

    /**
     * @param i int representing the value the remaining seats should be
     */
    public void setremainingseats(int i) {
        remainingseats = i;
    }

    /**
     * @param a int representing the value the total seats should be
     */
    public void settotalseats(int a) {
        totalseats = a;
    }
 
    /**
     * @param adult int representing the adult tickets demanded
     * @param child int representing the child tickets demanded
     * @param senior int representing the senior tickets demanded
     */
    public void updatetickets(int adult, int child, int senior) {
        int total = adult + child + senior;
        adultsold = adultsold + adult;
        childrensold = childrensold + child;
        seniorsold = seniorsold + senior;
        remainingseats = remainingseats - total; 
    }

    /**
     * @return in representing the total tickets sold for this Show 
     */
    public int totaltickets() {
        return adultsold + childrensold + seniorsold;
    }

}