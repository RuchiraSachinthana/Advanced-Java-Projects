package controller;

public class Timer {  
    private long elapsedTime;
    private long startTime;
    private boolean isRunning;
    
	/**
	 * Default constructor to start at zero
	 */
   public Timer() {  
      reset();
   }

   /**
    * Timer starts now.
    */
   public void start() {  
      if (isRunning) return;
      isRunning = true;
      startTime = System.currentTimeMillis();
   }
      
   /**
    * Stops the timer. Time stops accumulating and is
    * is added to the elapsed time.
    */
   public void stop() {  
      if (!isRunning) return;
      isRunning = false;
      long endTime = System.currentTimeMillis();
      elapsedTime = elapsedTime + endTime - startTime;
   }
   
   /**
    * Returns the total elapsed time.
    * @return the total elapsed time
    */
   public long getElapsedTime() {  
      if (isRunning) {  
          long endTime = System.currentTimeMillis();
          return elapsedTime + endTime - startTime;
       } else {
    	   return elapsedTime;
       } 
    }
    
   /**
    *   Stops the watch and resets the elapsed time to 0.
    */
    public void reset() {  
       elapsedTime = 0;
       isRunning = false;
    }
    
    /**
     * Gets a string representation of the timer results
     * @return string = the string representation of the timer results
     */
    public String toString() {
    	return "The recorded time was " + getElapsedTime()/1000.0 + " seconds";
    }
 }
