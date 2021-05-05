/**
 * This is a sample tester to be modified
 */

import java.util.ArrayList;

public class TripTester {

   public static void main(String [] args) {
   
      //Create a list of flights 
      ArrayList<Flight> flightList = new ArrayList<Flight>();
      //add flights, in order, to the list using the information from orbitz or travelocity
      Time dep = new Time(11,30,false);
      Time arr = new Time(1,15, true);
      Flight f1 = new Flight(dep, arr);
      flightList.add(f1);
      //Create a Trip
      
      //call the Trip getDuration method for testing and print results
      
      //call the Trip getLongestLeg method for testing and print results
      
      //call the Trip getShortestLayover method for testing and print results
      
   }
}

