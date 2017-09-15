/**
 * Created by kottejimmy on 9/8/2017.
 */
public class ThreadClass extends Thread {
    private StopWatch myWatch;


    public ThreadClass(StopWatch myWatch){
        this.myWatch = myWatch;

    }

    public void run () {

        while (myWatch.isThreadStarted()) {
            try {
                Thread.sleep(100);
                myWatch.tick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }}
