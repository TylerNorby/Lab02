/*
   Author: Tyler Norby
   Project: Lab02
   Description: implementation of Process object
    */
public class Process implements Comparable<Process> {

    // Declaring Variables
    int priority;
    int timeRemaining;
    int arrivalTime;
    int timeNotProcessed;


    //Default constructor
    public Process(int priority, int arrivalTime, int timeRemaining) {
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.timeRemaining = timeRemaining;
        setTimeNotProcessed(0);
    }


    // Getters and Setters
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTimeNotProcessed() {
        return timeNotProcessed;
    }

    public void setTimeNotProcessed(int timeNotProcessed) {
        this.timeNotProcessed = timeNotProcessed;
    }


    // Reduces timeRemaining
    public void reduceTimeRemaining() {
        this.timeRemaining--;
        resetTimeNotProcessed();
    }

    public void resetTimeNotProcessed() {
        timeNotProcessed = 0;
    }

    // Returns true if process is finished
    public boolean finish() {
        return (timeRemaining == 0);
    }

    // Increments timeNotProcessed
    public void incrementTimeNotProcessed() {
        timeNotProcessed++;
    }

    @Override
    // Implementation of compareTo method, compares processes
    public int compareTo(Process o) {
        if (priority > o.priority) {  // if o's priority time is less, return 1
            return 1;
        } else if (priority < o.priority) { // if o's priority time is greater, return -1
            return -1;
        } else {
            if (arrivalTime > o.arrivalTime) { // if o's arrival time is less, return 1
                return 1;
            } else if (arrivalTime < o.arrivalTime) { // if o's arrival time is greater, return -1
                return -1;
            } else { // If all values are equal, returns 0
                return 0;
            }
        }
    }
}