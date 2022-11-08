import java.util.Queue;

public class Dispatcher extends Thread {

    private final Queue<String> pendingCalls;
    public static final long talkingTime = 3000;

    public Dispatcher(Queue<String> pendingCalls) {
        this.pendingCalls = pendingCalls;
    }

    @Override
    public void run() {
        while (Main.answeredCalls != Main.maximumCalls) {
            try {
                String call = pendingCalls.poll();
                if (call != null) {
                    Thread.sleep(talkingTime);
                    Main.answeredCalls++;
                    System.out.println("Оператор " + Thread.currentThread().getName() + " обслужил : " + call);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}