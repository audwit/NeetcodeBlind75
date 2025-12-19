package multithreading;

public class RunnableDemo implements Runnable{
    private String threadName;
    private Thread thread;

    public RunnableDemo(String threadName){
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }


    @Override
    public void run() {
        System.out.println(threadName + " is running");
        try{
            for (int i=4; i>=0; i--){
                System.out.println(threadName + " " + i);
                thread.sleep(50);
            }
            System.out.println(threadName+ " finished running");
        }

        catch (InterruptedException e){
            System.out.println(threadName + " has been interrupted");
        }
    }

    public void start(){
        if (thread==null)
            thread = new Thread(this, threadName);
        System.out.println("Started" + threadName);
        thread.start();
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableDemo thread1 = new RunnableDemo("thread-1");
        thread1.start();
        RunnableDemo thread2 = new RunnableDemo("thread-2");
        thread2.run();

    }
}
