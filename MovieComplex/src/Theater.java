/**
 * @author Shivi Singh 
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
