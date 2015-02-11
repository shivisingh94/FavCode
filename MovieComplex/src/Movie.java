
/**
 * @author Shivi Singh 
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
