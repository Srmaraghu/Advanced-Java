// Part 1: Creating a thread by implementing Runnable
class RunnableExample implements Runnable {

    
    @Override
    public void run() {
        for (int i = 1; i <= 4; i++) {
            System.out.println( " - Runnable count: " + i);
            try {
                Thread.sleep(500); // Pause to simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println( " - Runnable finished.");
    }
}

// Part 2: Creating a thread by extending Thread
class ThreadExample extends Thread {


    @Override
    public void run() {
        for (int i = 1; i <= 4; i++) {
            System.out.println( " - Thread count: " + i);
            try {
                Thread.sleep(500); // Pause to simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println( " - Thread finished.");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        // Creating and starting the Runnable thread
        
        Thread runnableThread = new Thread(new RunnableExample());
        ThreadExample threadExample = new ThreadExample();
        
        runnableThread.start();

        threadExample.start();

        // Wait for both threads to finish
        try {
            runnableThread.join();
            threadExample.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Main thread message after both threads finish
        System.out.println("Both threads have finished execution.");
    }
}
