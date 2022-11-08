import java.util.Queue;

public class Atc extends Thread {

    public final int maximumCalls;
    public final int timeToNextCall = 1000;

    private final Queue<String> pendingCalls;

    public Atc(Queue<String> pendingCalls, int maximumCalls) {
        this.pendingCalls = pendingCalls;
        this.maximumCalls = maximumCalls;
    }

    @Override
    public void run() {
        for (int i = 1; i <= maximumCalls; i++) {
            try {
                String currCall = "Звонок №" + i;
                pendingCalls.add(currCall);
                System.out.println(currCall + " добавлен");
                Thread.sleep(timeToNextCall);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}