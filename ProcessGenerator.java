/*
   Author: Tyler Norby
   Project: Lab02
   Description: implementation of ProcessGenerator, fills PQueue table
    */
import java.util.Random;

public class ProcessGenerator {

    private double genProb;
    Random rand = new Random();

    // Default Constructor
    public ProcessGenerator(double genProb) {
        this.genProb = genProb;
    }


    // Sends a new query
    public boolean query() {
        return rand.nextDouble() < genProb;
    }

    // Generates new Process for the PQueue
    public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
        int priority = rand.nextInt(maxLevel) + 1;
        int timeRemaining = rand.nextInt(maxProcessTime) + 1;
        Process newProcess = new Process(priority, timeRemaining, currentTime);
        return newProcess;
    }

}
