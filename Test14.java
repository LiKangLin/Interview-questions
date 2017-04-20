package QuestionTest;

/**
 * Created by L_kanglin on 2017/4/10.
 * 死锁
 */
public class Test14 {
    private static Object firstMonitor = new Object();
    private static Object secondMonitor = new Object();
    public static void main(String[] args) {
        new Thread(new Runnable(){
            public void run() {
                while(true)
                {
                    synchronized(firstMonitor)
                    {
                        synchronized(secondMonitor)
                        {
                            System.out.println("Thread1");
                        }
                    }
                }
            }

        }).start();

        new Thread(new Runnable(){
            public void run() {
                while(true)
                {
                    synchronized(secondMonitor)
                    {
                        synchronized(firstMonitor)
                        {
                            System.out.println("Thread2");
                        }
                    }
                }
            }
        }).start();
    }
}
