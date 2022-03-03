import java.util.Random;

public class ProcessGenerator {

    private double genProb;
    Random rand = new Random();

    public ProcessGenerator(double genProb) {
        this.genProb = genProb;
    }

    public boolean query() {
        return rand.nextDouble() < genProb;
    }

    public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
        int priority = rand.nextInt(maxLevel) + 1;
        int timeRemaining = rand.nextInt(maxProcessTime) + 1;
        Process newProcess = new Process(priority, timeRemaining, currentTime);
        return newProcess;
    }

}
