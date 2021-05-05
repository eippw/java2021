public class Flight {

   /** the arrival time of the flight **/
   private Time arrival;
   
   /** the departure time of the flight **/
   private Time departure;
   
   /** Constructor: creates Flight objects
    *  @param the departure time for the flight
    *  @param the arrival time of the flight
    */
   public Flight(Time d, Time a) {
      arrival = a;
      departure = d;
   }
   
   /** @return the departure time of this flight.
    */
   public Time getDepartureTime() {
      return departure;
   }
   
   /** @return the arrival time of this flight.
    */
   public Time getArrivalTime() {
      return arrival;
   }
}

