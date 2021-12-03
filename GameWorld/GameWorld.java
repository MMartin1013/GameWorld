import java.util.ArrayList;
import java.util.Queue;

/**
 * A class to find paths among game locations
 * @author Manolo Martin
 */
public class GameWorld {
    private GameLocations locations;
    private ArrayList<ArrayList<Location>> paths;

    /**
     * Default constructor for the gameworld class
     * @param locations a gameLocations object used to find paths
     */
    public GameWorld(GameLocations locations){
        this.locations = locations;
        paths = new ArrayList<>();
    }

    /**
     * Uses two locations to populate and print out
     * the paths array list with all paths to the 
     * requested destination from another destination
     * @param current the requestedstarting destination
     * @param destination the requested ending destination
     */
    public void printPaths(Location current, Location destination){
        ArrayList<Location> path = new ArrayList<>(); //Creates an arrayList to store a path to the requested destination
        findAllPaths(current, destination, path);//Calls findPath to populate the path list

        for(ArrayList<Location> p : paths){//Searches each completed path in the path list
            System.out.print("Path " + (paths.indexOf(p) + 1) + ": ");//Prints the path number
            for(Location l : p){//Prints each location in each path
                if(p.indexOf(l) < p.size() - 1){
                    System.out.print(l + "--" + locations.distanceIs(l,p.get(p.indexOf(l) + 1)) + "->");
                }else{
                    System.out.println(l);
                }
            }
        }
    }

    /**
     * Recursively populates the paths arraylist
     * with all paths to and from a location
     * @param current starting route for paths
     * @param destination ending route for paths
     * @param path where the completed paths are stored
     */
    public void findAllPaths(Location current, Location destination, ArrayList<Location> path){
        if(current.equals(destination)){//Base case checks if the current location is the destination
            path.add(destination);//Adds the destination to the current path
            paths.add(path);//Adds the completed path to paths
        }else{
            Queue<Location> connections = locations.directDestinations(current);//Recursive case uses direct destinations to see the connections to the current locaiton
            
            ArrayList<Location> splitPath = new ArrayList<>();//Declares a new arraylist to store paths of connections
            
            for(Location p : path){//Copies path into split path
                splitPath.add(p);
            }

            splitPath.add(current);//Updates split path with current location

            for(Location location : connections){//Ensures that there will be no recursive calls with repeated  locations
                boolean repeat = false;
                for(Location previous : path){
                    if(previous.equals(location)){
                        repeat = true;
                    }
                }
                
                if(!repeat){//Finds a path from the next location to the destination
                    findAllPaths(location, destination, splitPath);
                }
            }
        }
    }
}
