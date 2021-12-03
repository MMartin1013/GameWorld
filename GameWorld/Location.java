/**
 * A class to hold game location information
 * @author Manolo Martin
 */
public class Location {
    //Class variables
    private String locName;
    private String locDesc;

    /**
     * Default constructor for locatin class
     * @param locName location name
     * @param locDesc location description
     */
    public Location(String locName, String locDesc){
        this.locDesc = locDesc;
        this.locName = locName;
    }

    //Setters and Getters
    public void setLocDesc(String locDesc) {
        this.locDesc = locDesc;
    }

    public void setLocName(String locName) {
        this.locName = locName;
    }

    public String getLocDesc() {
        return locDesc;
    }

    public String getLocName() {
        return locName;
    }

    /**
     * To string method
     */
    @Override
    public String toString() {
        return locName + "(" + locDesc + ")";
    }
}
