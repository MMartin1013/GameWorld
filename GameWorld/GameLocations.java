import java.util.LinkedList;
import java.util.Queue;
/**
 * A class to hold a collection of game locations
 * @author Manolo Martin
 */

public class GameLocations {
    //Class variables
    private int total;
    private int[][] distance;
    private LinkedList<Location> locations;
    private boolean[] visited;

    /**
     * Default GameLocations class
     * @param total number of locations
     */
    public GameLocations(int total){
        this.total = total;
        distance = new int[total][total];
        visited = new boolean[total];
        locations = new LinkedList<>();

    }

    /**
     * Adds passed in location to list of locations
     * his method also initializes certain elements in the 
     * 2D array distance; initializing distances from the passed-in 
     * location to all other locations in the game 
     *  to a default value -1
     * @param location to be added to the array
     */
    public void addLocation(Location location){
        locations.add(location);

        int index = locations.indexOf(location);
        /*Fills the locations index in the linked lists rows 
        and columns to -1 in the distance array
         */
        for(int i = 0; i < total; i++){
            distance[index][i] = -1;
            distance[i][index] = -1;
        }
    }

    /**
     * Places a specific distance to and from a location
     * into the array of distances
     * @param from a location that is the starting point of the distance
     * @param to a location that is the ending point of the distance
     * @param dist the distance of the two points
     */
    public void addDistance(Location from, Location to, int dist){
        distance[locations.indexOf(from)][locations.indexOf(to)] = dist;
    }

    /**
     * Returns a distance between two locations
     * @param from a location that is the starting point of the distance
     * @param to a location that is the ending point of the distance
     * @return the distance of the two points
     */
    public int distanceIs(Location from, Location to){
        return distance[locations.indexOf(from)][locations.indexOf(to)];
    }

    /**
     * Sets a specific location to the passed in boolean value
     * @param location to be visited or not
     * @param value determines whether the location is visited
     */
    public void markAsVisited(Location location, boolean value){
        int index = locations.indexOf(location);

        visited[index] = value;
    }

    /**
     * returns a specific value stored in the visited array
     * @param location that is checked for visitation
     * @returns whether the location was visited or not
     */
    public boolean haveVisited(Location location){
        return visited[locations.indexOf(location)];
    }

    /**
     * Returns a queue that holds location objects directly connected 
     * to the passed in location
     * @param location that is checked for direct connections
     * @return a queue of direct connections
     */
    public Queue<Location> directDestinations(Location location){
        Queue<Location> directLocations = new LinkedList<>();
        
        for(Location l : locations){ //Checks if there is a distance from each location in the list
            if(distanceIs(location, l) != -1 && !(l.equals(location))){
                directLocations.add(l);//If there is a distance it is added if it is not the same location
            }
        }

        return directLocations;
        
    }

}
