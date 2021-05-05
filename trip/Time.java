public class Time {

   /** the number of hours for the time **/
   private int hours;
   
   /** the number of minutes for the time **/
   private int minutes;
   
   /** true if P.M. and false if A.M. **/
   private boolean postMeridiem;
   
   /** Constructor: creates Time objects
    *  @param h the number of hours for the time
    *  @param m the number of minutes for the time
    *  @param true if P.M. and false if A.M.
    */
   public Time(int h, int m, boolean pm) {
      hours = h;
      minutes = m;
      postMeridiem = pm;
   }
   
   /** @return difference, in minutes, between this time and the parameter other;
    *          difference is negative if other is earlier than this time.
    */
   public int minutesUntil(Time other) {
      if(postMeridiem == other.isPM()) {
         return (other.getHours() - hours)*60 + (other.getMinutes() - minutes);
      } else {
         if(!postMeridiem)
            return(other.getHours() - hours)*60+12*60 + (other.getMinutes() - minutes);
         else
            return(other.getHours() - hours)*60-12*60 + (other.getMinutes() - minutes);
      }
   }
   
   /** @return the number of hours for this time value.
    */
   public int getHours() {
      return hours;
   }
   
   /** @return the number of minutes for this time value.
    */
   public int getMinutes() {
      return minutes;
   }
   
   /** @return true if the time is P.M. and false if A.M.
    */
   public boolean isPM() {
      return postMeridiem;
   }
   
   /** @return A String representation of the time in the format:
    *          <hours>:<minutes>A.M. or <hours>:<time>P.M.
    */
   public String toString() {
      String m = "";
      if(postMeridiem)
         m = "P.M.";
      else
         m = "A.M.";
      
      String min = "";   
      if(minutes < 10)
         min = "0" + minutes;
      else
         min = Integer.toString(minutes);
         
      return hours + ":" + min + m;
   }
   
}
