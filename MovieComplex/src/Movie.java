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
public class Movie {
    /**
     * Id for the movie
     */
    int id;
    /**
     *Movie Title 
     */
    String name;
    /**
     * length of the movie
     */
    int duration;

    /**
     * @param id int of the Movie id
     * @param name String of Movie Title 
     * @param duration int the length of movie 
     */
    public Movie(int id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    /**
     * @return String of the name of this Movie
     */
    public String movieName() {
        return name;
    }

    /**
     * @return int of the duration value of this Movie
     */
    public int getduration() {
        return duration;
    }

}