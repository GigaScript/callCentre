import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    private static final Queue<String> pendingCalls = new PriorityBlockingQueue<>();
    public static int answeredCalls = 0;
    public static final int numberOfDispatcher = 5;
    public static final int maximumCalls = 60;

    public static void main(String[] args) throws InterruptedException {

        new Atc(pendingCalls, maximumCalls).start();

        for (int i = 0; i < numberOfDispatcher; i++) {
            new Dispatcher(pendingCalls).start();
        }
    }
}