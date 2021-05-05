/* Trip.java
 *
 * A trip consists of a sequence of flights and is represented by the Trip 
 * class. The Trip class contains an ArrayList of Flight objects that are 
 * stored in chronological order. You may assume that for each flight after 
 * the first flight in the list, the departure time of the flight is later 
 * than the arrival time of the preceding flight in the list.
 * 
 */
 
import java.util.ArrayList;
 
public class Trip {

   //stores the flights(if any) in chronological order
   private ArrayList<Flight> flights;
   
   
   /** Constructor: creates Trip objects
    *  @param f the list of flights for the trip.
    */
   public Trip(ArrayList<Flight> f) {
      flights = f;
   }
   
   /** @return the number of minutes from the departure of the first
    *          flight to the arrival of the last flight if there are
    *          one or more flights in the trip; 0, if there are no 
    *          flights in the trip.
    */    
   public int getDuration() {
      return 0; //here so the program compiles.  
   }

   /** Precondition: the departure time for each flight is later than
    *                the arrival time of its preceding flight.
    *  @return the largest number of minutes of a single flight in the trip; 
    *          -1, if there are fewer than two flights in the trip.
    */
   public int getLongestLeg() {
      return 0; //here so the program compiles;
   }
   
   /** Precondition: the departure time for each flight is later than
    *                the arrival time of its preceding flight.
    *  @return the smallest number of minutes between the arrival of a
    *          flight and the departure of the flight immediately after
    *          it, if there are two or more flights in the trip; -1, if
    *          there are fewer than two flights in the trip.
    */
   public int getShortestLayover() {
      return 0; //here so the program compiles.
   }

}
